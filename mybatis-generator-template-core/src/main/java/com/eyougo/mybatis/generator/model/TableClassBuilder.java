
package com.eyougo.mybatis.generator.model;

import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;

import java.beans.Introspector;
import java.util.ArrayList;
import java.util.List;

/**
 * @author eyougo
 */
public class TableClassBuilder {

    public static TableClass build(IntrospectedTable introspectedTable) {
        TableClass tableClass = new TableClass();
        tableClass.setIntrospectedTable(introspectedTable);

        FullyQualifiedTable fullyQualifiedTable = introspectedTable.getFullyQualifiedTable();
        tableClass.setTableName(fullyQualifiedTable.getIntrospectedTableName());

        FullyQualifiedJavaType type = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        tableClass.setType(type);
        tableClass.setVariableName(Introspector.decapitalize(type.getShortName()));
        tableClass.setLowerCaseName(type.getShortName().toLowerCase());
        tableClass.setShortClassName(type.getShortName());
        tableClass.setFullClassName(type.getFullyQualifiedName());
        tableClass.setPackageName(type.getPackageName());

        List<TableColumnField> pkFields = new ArrayList<>();
        List<TableColumnField> baseFields = new ArrayList<>();
        List<TableColumnField> blobFields = new ArrayList<>();
        List<TableColumnField> allFields = new ArrayList<>();
        for (IntrospectedColumn column : introspectedTable.getPrimaryKeyColumns()) {
            TableColumnField field = build(column);
            field.setTableClass(tableClass);
            pkFields.add(field);
            allFields.add(field);
        }
        for (IntrospectedColumn column : introspectedTable.getBaseColumns()) {
            TableColumnField field = build(column);
            field.setTableClass(tableClass);
            baseFields.add(field);
            allFields.add(field);
        }
        for (IntrospectedColumn column : introspectedTable.getBLOBColumns()) {
            TableColumnField field = build(column);
            field.setTableClass(tableClass);
            blobFields.add(field);
            allFields.add(field);
        }
        tableClass.setPkFields(pkFields);
        tableClass.setBaseFields(baseFields);
        tableClass.setBlobFields(blobFields);
        tableClass.setAllFields(allFields);

        return tableClass;
    }

    public static TableColumnField build(IntrospectedColumn column) {
        TableColumnField field = new TableColumnField();
        field.setColumnName(column.getActualColumnName());
        field.setJdbcType(column.getJdbcTypeName());
        field.setFieldName(column.getJavaProperty());
        field.setRemarks(column.getRemarks());
        FullyQualifiedJavaType type = column.getFullyQualifiedJavaType();
        field.setType(type);
        field.setTypePackage(type.getPackageName());
        field.setShortTypeName(type.getShortName());
        field.setFullTypeName(type.getFullyQualifiedName());
        field.setIdentity(column.isIdentity());
        field.setAutoIncrement(column.isAutoIncrement());
        field.setNullable(column.isNullable());
        field.setSequenceColumn(column.isSequenceColumn());
        field.setBlobColumn(column.isBLOBColumn());
        field.setStringColumn(column.isStringColumn());
        field.setJdbcCharacterColumn(column.isJdbcCharacterColumn());
        field.setJdbcDateColumn(column.isJDBCDateColumn());
        field.setJdbcTimeColumn(column.isJDBCTimeColumn());
        field.setLength(column.getLength());
        field.setScale(column.getScale());
        return field;
    }


}
