package com.uframe.generator.provider.db.sql.model;

import com.uframe.generator.provider.db.table.model.*;
import com.uframe.generator.util.*;

public class SqlParameter extends Column
{
    String parameterClass;
    String paramName;
    boolean isListParam;
    
    public SqlParameter() {
        this.isListParam = false;
    }
    
    public SqlParameter(final Column param) {
        super(param);
        this.isListParam = false;
        BeanHelper.copyProperties(this, param);
    }
    
    public SqlParameter(final SqlParameter param) {
        super(param);
        this.isListParam = false;
        this.isListParam = param.isListParam;
        this.paramName = param.paramName;
    }
    
    public String getParameterClass() {
        if (StringHelper.isNotBlank(this.parameterClass)) {
            return this.parameterClass;
        }
        return this.getPossibleShortJavaType();
    }
    
    public void setParameterClass(final String parameterClass) {
        this.parameterClass = parameterClass;
    }
    
    public String getPreferredParameterJavaType() {
        return this.toListParam(this.getParameterClass());
    }
    
    private String toListParam(final String parameterClassName) {
        if (!this.isListParam) {
            return parameterClassName;
        }
        if (parameterClassName.indexOf("[]") >= 0) {
            return parameterClassName;
        }
        if (parameterClassName.indexOf("List") >= 0) {
            return parameterClassName;
        }
        if (parameterClassName.indexOf("Set") >= 0) {
            return parameterClassName;
        }
        return "java.util.List<" + parameterClassName + ">";
    }
    
    public String getParamName() {
        return this.paramName;
    }
    
    public void setParamName(final String paramName) {
        this.paramName = paramName;
    }
    
    public boolean isListParam() {
        return this.isListParam;
    }
    
    public void setListParam(final boolean isListParam) {
        this.isListParam = isListParam;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof SqlParameter) {
            final SqlParameter other = (SqlParameter)obj;
            return this.paramName.equals(other.getParamName());
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.paramName.hashCode();
    }
    
    @Override
    public String toString() {
        return "paramName:" + this.paramName + " preferredParameterJavaType:" + this.getPreferredParameterJavaType();
    }
}
