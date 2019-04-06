package com.uframe.generator.provider.db.table.model;

import java.io.*;
import com.uframe.generator.*;
import com.uframe.generator.provider.db.table.model.util.*;
import com.uframe.generator.util.*;
import java.util.*;
import com.uframe.generator.util.typemapping.*;

public class Column implements Serializable, Cloneable
{
    private Table _table;
    private int _sqlType;
    private String _sqlTypeName;
    private String _sqlName;
    private boolean _isPk;
    private boolean _isFk;
    private int _size;
    private int _decimalDigits;
    private boolean _isNullable;
    private boolean _isIndexed;
    private boolean _isUnique;
    private String _defaultValue;
    private String _remarks;
    private ForeignKey.ReferenceKey hasOne;
    private ForeignKey.ReferenceKey hasMany;
    private String enumString;
    private String javaType;
    private String columnAlias;
    private String columnName;
    private String asType;
    private String enumClassName;
    private boolean updatable;
    private boolean insertable;
    private String hibernateValidatorExprssion;
    
    public Column(final Table table, final int sqlType, final String sqlTypeName, final String sqlName, final int size, final int decimalDigits, final boolean isPk, final boolean isNullable, final boolean isIndexed, final boolean isUnique, final String defaultValue, final String remarks) {
        this.hasMany = null;
        this.enumString = "";
        this.updatable = true;
        this.insertable = true;
        if (sqlName == null) {
            throw new NullPointerException();
        }
        this._table = table;
        this._sqlType = sqlType;
        this._sqlName = sqlName;
        this._sqlTypeName = sqlTypeName;
        this._size = size;
        this._decimalDigits = decimalDigits;
        this._isPk = isPk;
        this._isNullable = isNullable;
        this._isIndexed = isIndexed;
        this._isUnique = isUnique;
        this._defaultValue = defaultValue;
        this._remarks = remarks;
        GLogger.trace(String.valueOf(sqlName) + " isPk -> " + this._isPk);
        this.initOtherProperties();
    }
    
    public Column(final Column c) {
        this(c.getTable(), c.getSqlType(), c.getSqlTypeName(), c.getSqlName(), c.getSize(), c.getDecimalDigits(), c.isPk(), c.isNullable(), c.isIndexed(), c.isUnique(), c.getDefaultValue(), c.getRemarks());
    }
    
    public Column() {
        this.hasMany = null;
        this.enumString = "";
        this.updatable = true;
        this.insertable = true;
    }
    
    public int getSqlType() {
        return this._sqlType;
    }
    
    public Table getTable() {
        return this._table;
    }
    
    public int getSize() {
        return this._size;
    }
    
    public int getDecimalDigits() {
        return this._decimalDigits;
    }
    
    public String getSqlTypeName() {
        return this._sqlTypeName;
    }
    
    public String getSqlName() {
        if (this._sqlName == null) {
            throw new NullPointerException();
        }
        if ("U".equals(GeneratorProperties.getProperty("column.sqlName.caseSize", "L").trim())) {
            return this._sqlName.toUpperCase();
        }
        return this._sqlName.toLowerCase();
    }
    
    public boolean isPk() {
        return this._isPk;
    }
    
    public boolean isFk() {
        return this._isFk;
    }
    
    public boolean isNullable() {
        return this._isNullable;
    }
    
    public boolean isIndexed() {
        return this._isIndexed;
    }
    
    public boolean isUnique() {
        return this._isUnique;
    }
    
    public String getDefaultValue() {
        return this._defaultValue;
    }
    
    public String getRemarks() {
        return this._remarks;
    }
    
    public void setUpdatable(final boolean updatable) {
        this.updatable = updatable;
    }
    
    public void setInsertable(final boolean insertable) {
        this.insertable = insertable;
    }
    
    public void setNullable(final boolean v) {
        this._isNullable = v;
    }
    
    public void setUnique(final boolean unique) {
        this._isUnique = unique;
    }
    
    public void setPk(final boolean v) {
        this._isPk = v;
    }
    
    @Override
    public int hashCode() {
        if (this.getTable() != null) {
            return (String.valueOf(this.getTable().getSqlName()) + "#" + this.getSqlName()).hashCode();
        }
        return this.getSqlName().hashCode();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Column) {
            final Column other = (Column)o;
            if (this.getSqlName().equals(other.getSqlName())) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return this.getSqlName();
    }
    
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }
    
    protected String prefsPrefix() {
        return "tables/" + this.getTable().getSqlName() + "/columns/" + this.getSqlName();
    }
    
    void setFk(final boolean flag) {
        this._isFk = flag;
    }
    
    public String getUnderscoreName() {
        return this.getSqlName().toLowerCase();
    }
    
    public String getColumnName() {
        return this.columnName;
    }
    
    public String getColumnNameFirstLower() {
        return StringHelper.uncapitalize(this.getColumnName());
    }
    
    public String getColumnNameLowerCase() {
        return this.getColumnName().toLowerCase();
    }
    
    @Deprecated
    public String getColumnNameLower() {
        return this.getColumnNameFirstLower();
    }
    
    public String getJdbcSqlTypeName() {
        return this.getJdbcType();
    }
    
    public String getJdbcType() {
        final String result = JdbcType.getJdbcSqlTypeName(this.getSqlType());
        return result;
    }
    
    public String getColumnAlias() {
        return this.columnAlias;
    }
    
    public String getConstantName() {
        return StringHelper.toUnderscoreName(this.getColumnName()).toUpperCase();
    }
    
    @Deprecated
    public boolean getIsNotIdOrVersionField() {
        return !this.isPk();
    }
    
    public String getValidateString() {
        return this.isNullable() ? this.getNoRequiredValidateString() : ("required " + this.getNoRequiredValidateString());
    }
    
    public String getNoRequiredValidateString() {
        return ColumnHelper.getRapidValidation(this);
    }
    
    public String[] getHibernateValidatorConstraintNames() {
        return ColumnHelper.removeHibernateValidatorSpecialTags(this.getHibernateValidatorExprssion());
    }
    
    public String getHibernateValidatorExprssion() {
        return this.hibernateValidatorExprssion;
    }
    
    public void setHibernateValidatorExprssion(final String v) {
        this.hibernateValidatorExprssion = v;
    }
    
    public boolean getIsStringColumn() {
        return DatabaseDataTypesUtils.isString(this.getJavaType());
    }
    
    public boolean getIsDateTimeColumn() {
        return DatabaseDataTypesUtils.isDate(this.getJavaType());
    }
    
    public boolean getIsNumberColumn() {
        return DatabaseDataTypesUtils.isFloatNumber(this.getJavaType()) || DatabaseDataTypesUtils.isIntegerNumber(this.getJavaType());
    }
    
    public boolean contains(final String keywords) {
        if (keywords == null) {
            throw new IllegalArgumentException("'keywords' must be not null");
        }
        return StringHelper.contains(this.getSqlName(), keywords.split(","));
    }
    
    public boolean isHtmlHidden() {
        return this.isPk() && this._table.isSingleId();
    }
    
    public String getJavaType() {
        return this.javaType;
    }
    
    public String getSimpleJavaType() {
        return StringHelper.getJavaClassSimpleName(this.getJavaType());
    }
    
    public String getPossibleShortJavaType() {
        if (this.getJavaType().startsWith("java.lang.")) {
            return this.getSimpleJavaType();
        }
        return this.getJavaType();
    }
    
    public boolean isPrimitive() {
        return JavaPrimitiveTypeMapping.getWrapperTypeOrNull(this.getJavaType()) != null;
    }
    
    public String getPrimitiveJavaType() {
        return JavaPrimitiveTypeMapping.getPrimitiveType(this.getSimpleJavaType());
    }
    
    public String getAsType() {
        return this.asType;
    }
    
    public String getTestData() {
        return new TestDataGenerator().getDBUnitTestData(this.getColumnName(), this.getJavaType(), this.getSize());
    }
    
    public boolean isUpdatable() {
        return this.updatable;
    }
    
    public boolean isInsertable() {
        return this.insertable;
    }
    
    public String getEnumClassName() {
        return this.enumClassName;
    }
    
    public void setEnumString(final String str) {
        this.enumString = str;
    }
    
    public String getEnumString() {
        return this.enumString;
    }
    
    public List<EnumMetaDada> getEnumList() {
        return StringHelper.string2EnumMetaData(this.getEnumString());
    }
    
    public boolean isEnumColumn() {
        return this.getEnumList() != null && !this.getEnumList().isEmpty();
    }
    
    public void setJavaType(final String javaType) {
        this.javaType = javaType;
    }
    
    public void setColumnAlias(final String columnAlias) {
        this.columnAlias = columnAlias;
    }
    
    public void setColumnName(final String columnName) {
        this.columnName = columnName;
    }
    
    public void setAsType(final String asType) {
        this.asType = asType;
    }
    
    public void setEnumClassName(final String enumClassName) {
        this.enumClassName = enumClassName;
    }
    
    public String getHasOne() {
        return ForeignKey.ReferenceKey.toString(this.hasOne);
    }
    
    public String getNullValue() {
        return JavaPrimitiveTypeMapping.getDefaultValue(this.getJavaType());
    }
    
    public boolean isHasNullValue() {
        return JavaPrimitiveTypeMapping.getWrapperTypeOrNull(this.getJavaType()) != null;
    }
    
    public void setHasOne(final String foreignKey) {
        this.hasOne = ForeignKey.ReferenceKey.fromString(foreignKey);
        if (this.hasOne != null && this._table != null) {
            this._table.getImportedKeys().addForeignKey(this.hasOne.tableName, this.hasOne.columnSqlName, this.getSqlName(), this.hasOne.columnSqlName.toLowerCase().hashCode());
        }
    }
    
    public String getHasMany() {
        return ForeignKey.ReferenceKey.toString(this.hasMany);
    }
    
    public void setHasMany(final String foreignKey) {
        this.hasMany = ForeignKey.ReferenceKey.fromString(foreignKey);
        if (this.hasMany != null && this._table != null) {
            this._table.getExportedKeys().addForeignKey(this.hasMany.tableName, this.hasMany.columnSqlName, this.getSqlName(), this.hasMany.columnSqlName.toLowerCase().hashCode());
        }
    }
    
    private void initOtherProperties() {
        final String normalJdbcJavaType = DatabaseDataTypesUtils.getPreferredJavaType(this.getSqlType(), this.getSize(), this.getDecimalDigits());
        this.javaType = GeneratorProperties.getProperty("java_typemapping." + normalJdbcJavaType, normalJdbcJavaType).trim();
        this.columnName = StringHelper.makeAllWordFirstLetterUpperCase(StringHelper.toUnderscoreName(this.getSqlName()));
        this.enumClassName = String.valueOf(this.getColumnName()) + "Enum";
        this.asType = ActionScriptDataTypesUtils.getPreferredAsType(this.getJavaType());
        this.columnAlias = StringHelper.removeCrlf(StringHelper.defaultIfEmpty(this.getRemarks(), this.getColumnNameFirstLower()));
        this.setHibernateValidatorExprssion(ColumnHelper.getHibernateValidatorExpression(this));
    }
    
    public static String removeAggregationColumnChars(final String columSqlName) {
        return columSqlName.replace('(', '_').replace(")", "").replace("*", "");
    }
    
    public static class EnumMetaDada
    {
        private String enumAlias;
        private String enumKey;
        private String enumDesc;
        
        public EnumMetaDada(final String enumAlias, final String enumKey, final String enumDesc) {
            this.enumAlias = enumAlias;
            this.enumKey = enumKey;
            this.enumDesc = enumDesc;
        }
        
        public String getEnumAlias() {
            return this.enumAlias;
        }
        
        public String getEnumKey() {
            return this.enumKey;
        }
        
        public String getEnumDesc() {
            return this.enumDesc;
        }
    }
}
