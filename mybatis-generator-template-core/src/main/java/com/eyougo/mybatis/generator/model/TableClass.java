
package com.eyougo.mybatis.generator.model;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;

import java.util.List;

/**
 * @author eyougo
 */
public class TableClass {

    private IntrospectedTable introspectedTable;

    private String tableName;
    private String variableName;
    private String lowerCaseName;
    private String shortClassName;
    private String fullClassName;
    private String packageName;
    private FullyQualifiedJavaType type;

    private List<TableColumnField> pkFields;
    private List<TableColumnField> baseFields;
    private List<TableColumnField> blobFields;
    private List<TableColumnField> allFields;

    public IntrospectedTable getIntrospectedTable() {
        return introspectedTable;
    }

    public void setIntrospectedTable(IntrospectedTable introspectedTable) {
        this.introspectedTable = introspectedTable;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getLowerCaseName() {
        return lowerCaseName;
    }

    public void setLowerCaseName(String lowerCaseName) {
        this.lowerCaseName = lowerCaseName;
    }

    public String getShortClassName() {
        return shortClassName;
    }

    public void setShortClassName(String shortClassName) {
        this.shortClassName = shortClassName;
    }

    public String getFullClassName() {
        return fullClassName;
    }

    public void setFullClassName(String fullClassName) {
        this.fullClassName = fullClassName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public FullyQualifiedJavaType getType() {
        return type;
    }

    public void setType(FullyQualifiedJavaType type) {
        this.type = type;
    }

    public List<TableColumnField> getPkFields() {
        return pkFields;
    }

    public void setPkFields(List<TableColumnField> pkFields) {
        this.pkFields = pkFields;
    }

    public List<TableColumnField> getBaseFields() {
        return baseFields;
    }

    public void setBaseFields(List<TableColumnField> baseFields) {
        this.baseFields = baseFields;
    }

    public List<TableColumnField> getBlobFields() {
        return blobFields;
    }

    public void setBlobFields(List<TableColumnField> blobFields) {
        this.blobFields = blobFields;
    }

    public List<TableColumnField> getAllFields() {
        return allFields;
    }

    public void setAllFields(List<TableColumnField> allFields) {
        this.allFields = allFields;
    }
}
