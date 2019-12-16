package com.eyougo.mybatis.generator.plugins;

import com.eyougo.mybatis.generator.file.TemplateGeneratedFile;
import com.eyougo.mybatis.generator.model.TableClass;
import com.eyougo.mybatis.generator.model.TableClassBuilder;
import com.eyougo.mybatis.generator.template.TemplateFormatter;
import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.internal.ObjectFactory;
import org.mybatis.generator.internal.util.ClassloaderUtility;
import org.mybatis.generator.internal.util.StringUtility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

/**
 * @author mei
 * @date 2019/12/12
 */
public class TemplateFilePlugin extends PluginAdapter {

    public static final String DEFAULT_TEMPLATEFORMATTER = "com.eyougo.mybatis.generator.template.FreemarkerTemplateFormatter";

    private String baseDir;
    /**
     * 项目路径（目录需要已经存在）
     */
    private String targetProject;
    /**
     * 生成的包（路径不存在则创建）
     */
    private String targetPackage;
    /**
     * 模板路径
     */
    private String templatePath;
    /**
     * 模板内容
     */
    private String templateContent;
    /**
     * 文件名模板，通过模板方式生成文件名，包含后缀
     */
    private String fileName;
    /**
     * 模板生成器
     */
    private Object templateFormatter;
    private String templateFormatterClass;

    /**
     * 编码
     */
    private String encoding;


    /**
     * 读取文件
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    protected String read(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, encoding));
        StringBuilder stringBuilder = new StringBuilder();
        String line = reader.readLine();
        while (line != null) {
            stringBuilder.append(line).append("\n");
            line = reader.readLine();
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean validate(List<String> warnings) {
        boolean right = true;
        if (!StringUtility.stringHasValue(fileName)) {
            warnings.add("没有配置 \"fileName\" 文件名模板，因此不会生成任何额外代码!");
            right = false;
        }
        if (!StringUtility.stringHasValue(templatePath)) {
            warnings.add("没有配置 \"templatePath\" 模板路径，因此不会生成任何额外代码!");
            right = false;
        } else {
            ClassLoader cl = ClassloaderUtility.getCustomClassloader(Arrays.asList(baseDir));
            ObjectFactory.addExternalClassLoader(cl);
            URL resourceUrl = null;
            try {
                resourceUrl = ObjectFactory.getResource(templatePath);
            } catch (Exception e) {
                warnings.add("本地加载\"templatePath\" 模板路径失败，尝试 URL 方式获取!");
            }
            try {
                if (resourceUrl == null) {
                    resourceUrl = new URL(templatePath);
                }
                InputStream inputStream = resourceUrl.openConnection().getInputStream();
                templateContent = read(inputStream);
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                warnings.add("读取模板文件出错: " + e.getMessage());
                right = false;
            }
        }
        if (!StringUtility.stringHasValue(templateFormatterClass)) {
            templateFormatterClass = DEFAULT_TEMPLATEFORMATTER;
            warnings.add("没有配置 \"fileTemplateClass\" 模板处理器，使用默认的处理器!");
        }
        try {
            templateFormatter = Class.forName(templateFormatterClass).newInstance();
        } catch (Exception e) {
            warnings.add("初始化 templateFormatter 出错:" + e.getMessage());
            right = false;
        }
        if (!right) {
            return false;
        }
        int errorCount = 0;
        if (!StringUtility.stringHasValue(targetProject)) {
            errorCount++;
            warnings.add("没有配置 \"targetProject\" 路径!");
        }
        if (!StringUtility.stringHasValue(targetPackage)) {
            errorCount++;
            warnings.add("没有配置 \"targetPackage\" 路径!");
        }
        if (errorCount >= 2) {
            warnings.add("由于没有配置任何有效路径，不会生成任何额外代码!");
            return false;
        }
        return true;
    }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        List<GeneratedJavaFile> list = new ArrayList<>();
        TableClass tableClass = TableClassBuilder.build(introspectedTable);
        list.add(new TemplateGeneratedFile(tableClass, (TemplateFormatter) templateFormatter, properties, targetProject, targetPackage, fileName, templateContent));
        return list;
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        this.baseDir = properties.getProperty("baseDir");
        this.targetProject = properties.getProperty("targetProject");
        this.targetPackage = properties.getProperty("targetPackage");
        this.templatePath = properties.getProperty("templatePath");
        this.fileName = properties.getProperty("fileName");
        this.templateFormatterClass = properties.getProperty("templateFormatter");
        this.encoding = properties.getProperty("encoding", "UTF-8");
    }
}
