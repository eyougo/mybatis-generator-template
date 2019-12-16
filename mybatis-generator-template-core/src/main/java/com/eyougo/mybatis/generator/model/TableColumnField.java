package com.eyougo.mybatis.generator.model;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;

/**
 * @author eyougo
 */
public class TableColumnField {

    private TableClass tableClass;
    private String columnName;
    private String jdbcType;
    private String fieldName;
    private String remarks;
    private FullyQualifiedJavaType type;
    private String typePackage;
    private String shortTypeName;
    private String fullTypeName;
    private boolean isIdentity;
    private boolean isAutoIncrement;
    private boolean isNullable;
    private boolean isBlobColumn;
    private boolean isStringColumn;
    private boolean isJdbcCharacterColumn;
    private boolean isJdbcDateColumn;
    private boolean isJdbcTimeColumn;
    private boolean isSequenceColumn;
    private int length;
    private int scale;

    public TableClass getTableClass() {
        return tableClass;
    }

    public void setTableClass(TableClass tableClass) {
        this.tableClass = tableClass;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public FullyQualifiedJavaType getType() {
        return type;
    }

    public void setType(FullyQualifiedJavaType type) {
        this.type = type;
    }

    public String getTypePackage() {
        return typePackage;
    }

    public void setTypePackage(String typePackage) {
        this.typePackage = typePackage;
    }

    public String getShortTypeName() {
        return shortTypeName;
    }

    public void setShortTypeName(String shortTypeName) {
        this.shortTypeName = shortTypeName;
    }

    public String getFullTypeName() {
        return fullTypeName;
    }

    public void setFullTypeName(String fullTypeName) {
        this.fullTypeName = fullTypeName;
    }

    public boolean getIdentity() {
        return isIdentity;
    }

    public void setIdentity(boolean identity) {
        isIdentity = identity;
    }

    public boolean getAutoIncrement() {
        return isAutoIncrement;
    }

    public void setAutoIncrement(boolean autoIncrement) {
        isAutoIncrement = autoIncrement;
    }

    public boolean getNullable() {
        return isNullable;
    }

    public void setNullable(boolean nullable) {
        isNullable = nullable;
    }

    public boolean getBlobColumn() {
        return isBlobColumn;
    }

    public void setBlobColumn(boolean blobColumn) {
        isBlobColumn = blobColumn;
    }

    public boolean getStringColumn() {
        return isStringColumn;
    }

    public void setStringColumn(boolean stringColumn) {
        isStringColumn = stringColumn;
    }

    public boolean getJdbcCharacterColumn() {
        return isJdbcCharacterColumn;
    }

    public void setJdbcCharacterColumn(boolean jdbcCharacterColumn) {
        isJdbcCharacterColumn = jdbcCharacterColumn;
    }

    public boolean getJdbcDateColumn() {
        return isJdbcDateColumn;
    }

    public void setJdbcDateColumn(boolean jdbcDateColumn) {
        isJdbcDateColumn = jdbcDateColumn;
    }

    public boolean getJdbcTimeColumn() {
        return isJdbcTimeColumn;
    }

    public void setJdbcTimeColumn(boolean jdbcTimeColumn) {
        isJdbcTimeColumn = jdbcTimeColumn;
    }

    public boolean getSequenceColumn() {
        return isSequenceColumn;
    }

    public void setSequenceColumn(boolean sequenceColumn) {
        isSequenceColumn = sequenceColumn;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }
}
