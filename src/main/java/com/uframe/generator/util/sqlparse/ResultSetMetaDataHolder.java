package com.uframe.generator.util.sqlparse;

import java.sql.*;
import com.uframe.generator.util.*;

public class ResultSetMetaDataHolder
{
    String catalogName;
    String columnClassName;
    int columnDisplaySize;
    String columnLabel;
    String columnName;
    int columnType;
    String columnTypeName;
    int precision;
    int scale;
    String schemaName;
    String tableName;
    
    public ResultSetMetaDataHolder() {
    }
    
    public ResultSetMetaDataHolder(final ResultSetMetaData m, final int i) throws SQLException {
        final String catalogName = m.getCatalogName(i);
        final String columnClassName = m.getColumnClassName(i);
        final int columnDisplaySize = m.getColumnDisplaySize(i);
        final String columnLabel = m.getColumnLabel(i);
        final String columnName = m.getColumnName(i);
        final int columnType = m.getColumnType(i);
        final String columnTypeName = m.getColumnTypeName(i);
        final int precision = m.getPrecision(i);
        final int scale = m.getScale(i);
        final String schemaName = m.getSchemaName(i);
        final String tableName = m.getTableName(i);
        this.catalogName = catalogName;
        this.columnClassName = columnClassName;
        this.columnDisplaySize = columnDisplaySize;
        this.columnLabel = columnLabel;
        this.columnName = columnName;
        this.columnType = columnType;
        this.columnTypeName = columnTypeName;
        this.precision = precision;
        this.scale = scale;
        this.schemaName = schemaName;
        this.tableName = tableName;
    }
    
    public String getCatalogName() {
        return this.catalogName;
    }
    
    public void setCatalogName(final String catalogName) {
        this.catalogName = catalogName;
    }
    
    public String getColumnClassName() {
        return this.columnClassName;
    }
    
    public void setColumnClassName(final String columnClassName) {
        this.columnClassName = columnClassName;
    }
    
    public int getColumnDisplaySize() {
        return this.columnDisplaySize;
    }
    
    public void setColumnDisplaySize(final int columnDisplaySize) {
        this.columnDisplaySize = columnDisplaySize;
    }
    
    public String getColumnLabel() {
        return this.columnLabel;
    }
    
    public void setColumnLabel(final String columnLabel) {
        this.columnLabel = columnLabel;
    }
    
    public String getColumnNameOrLabel() {
        return StringHelper.isBlank(this.columnName) ? this.columnLabel : this.columnName;
    }
    
    public String getColumnName() {
        return this.columnName;
    }
    
    public void setColumnName(final String columnName) {
        this.columnName = columnName;
    }
    
    public int getColumnType() {
        return this.columnType;
    }
    
    public void setColumnType(final int columnType) {
        this.columnType = columnType;
    }
    
    public String getColumnTypeName() {
        return this.columnTypeName;
    }
    
    public void setColumnTypeName(final String columnTypeName) {
        this.columnTypeName = columnTypeName;
    }
    
    public int getPrecision() {
        return this.precision;
    }
    
    public void setPrecision(final int precision) {
        this.precision = precision;
    }
    
    public int getScale() {
        return this.scale;
    }
    
    public void setScale(final int scale) {
        this.scale = scale;
    }
    
    public String getSchemaName() {
        return this.schemaName;
    }
    
    public void setSchemaName(final String schemaName) {
        this.schemaName = schemaName;
    }
    
    public String getTableName() {
        return this.tableName;
    }
    
    public void setTableName(final String tableName) {
        this.tableName = tableName;
    }
}
