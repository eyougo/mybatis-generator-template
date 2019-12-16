
package com.eyougo.mybatis.generator.file;

import com.eyougo.mybatis.generator.model.TableClass;
import com.eyougo.mybatis.generator.template.TemplateFormatter;
import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.dom.java.CompilationUnit;

import java.util.Properties;

/**
 * @author eyougo
 */
public class TemplateGeneratedFile extends GeneratedJavaFile {
    public static final String ENCODING = "UTF-8";

    private String targetPackage;

    private String fileName;

    private String templateContent;

    private Properties properties;

    private TableClass tableClass;

    private TemplateFormatter templateFormatter;

    public TemplateGeneratedFile(TableClass tableClass, TemplateFormatter templateFormatter, Properties properties, String targetProject, String targetPackage, String fileName, String templateContent) {
        super(null, targetProject, ENCODING, null);
        this.targetProject = targetProject;
        this.targetPackage = targetPackage;
        this.fileName = fileName;
        this.templateContent = templateContent;
        this.properties = properties;
        this.tableClass = tableClass;
        this.templateFormatter = templateFormatter;
    }

    @Override
    public CompilationUnit getCompilationUnit() {
        return null;
    }

    @Override
    public String getFileName() {
        return templateFormatter.getFormattedContent(tableClass, properties, targetPackage, fileName);

    }

    @Override
    public String getFormattedContent() {
        return templateFormatter.getFormattedContent(tableClass, properties, targetPackage, templateContent);
    }

    @Override
    public String getTargetPackage() {
        return templateFormatter.getFormattedContent(tableClass, properties, targetPackage, targetPackage);
    }

    @Override
    public boolean isMergeable() {
        return false;
    }

}
