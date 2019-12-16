package com.eyougo.mybatis.generator.template;

import com.eyougo.mybatis.generator.model.TableClass;

import java.util.Properties;

/**
 * @author eyougo
 */
public interface TemplateFormatter {

    /**
     * 获取根据模板生成的数据
     *
     * @param tableClass
     * @param properties
     * @param targetPackage
     * @param templateContent
     * @return
     */
    String getFormattedContent(TableClass tableClass, Properties properties, String targetPackage, String templateContent);
}
