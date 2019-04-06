package com.uframe.generator.provider.db.procedure.model;

import java.io.*;
import java.util.*;

public class ProcedureParameter implements Serializable
{
    private static final long serialVersionUID = 7645829463583539070L;
    private Procedure procedure;
    private String parameterName;
    private String parameterJavaName;
    private int parameterType;
    private String parameterTypeName;
    private int sqlDataType;
    private String sqlTypeName;
    private String jdbcTypeName;
    private String javaTypeName;
    private String parameterKind;
    private LinkedHashSet<CustomObjectParameter> parameters;
    
    public ProcedureParameter() {
        this.parameters = new LinkedHashSet<CustomObjectParameter>();
    }
    
    public ProcedureParameter(final Procedure procedure, final String parameterName, final String parameterJavaName, final int parameterType, final String parameterTypeName, final int sqlDataType, final String sqlTypeName, final String javaTypeName) {
        this.parameters = new LinkedHashSet<CustomObjectParameter>();
        this.procedure = procedure;
        this.parameterName = parameterName;
        this.parameterJavaName = parameterJavaName;
        this.parameterType = parameterType;
        this.parameterTypeName = parameterTypeName;
        this.sqlDataType = sqlDataType;
        this.sqlTypeName = sqlTypeName;
        this.javaTypeName = javaTypeName;
    }
    
    public LinkedHashSet<CustomObjectParameter> getParameters() {
        return this.parameters;
    }
    
    public void setParameters(final LinkedHashSet<CustomObjectParameter> parameters) {
        this.parameters = parameters;
    }
    
    public Procedure getProcedure() {
        return this.procedure;
    }
    
    public void setProcedure(final Procedure procedure) {
        this.procedure = procedure;
    }
    
    public String getParameterName() {
        return this.parameterName;
    }
    
    public void setParameterName(final String parameterName) {
        this.parameterName = parameterName;
    }
    
    public String getParameterJavaName() {
        return this.parameterJavaName;
    }
    
    public void setParameterJavaName(final String parameterJavaName) {
        this.parameterJavaName = parameterJavaName;
    }
    
    public int getParameterType() {
        return this.parameterType;
    }
    
    public void setParameterType(final int parameterType) {
        this.parameterType = parameterType;
    }
    
    public String getParameterTypeName() {
        return this.parameterTypeName;
    }
    
    public void setParameterTypeName(final String parameterTypeName) {
        this.parameterTypeName = parameterTypeName;
    }
    
    public int getSqlDataType() {
        return this.sqlDataType;
    }
    
    public void setSqlDataType(final int sqlDataType) {
        this.sqlDataType = sqlDataType;
    }
    
    public String getSqlTypeName() {
        return this.sqlTypeName;
    }
    
    public void setSqlTypeName(final String sqlTypeName) {
        this.sqlTypeName = sqlTypeName;
    }
    
    public String getJavaTypeName() {
        return this.javaTypeName;
    }
    
    public void setJavaTypeName(final String javaTypeName) {
        this.javaTypeName = javaTypeName;
    }
    
    public String getJdbcTypeName() {
        return this.jdbcTypeName;
    }
    
    public void setJdbcTypeName(final String jdbcTypeName) {
        this.jdbcTypeName = jdbcTypeName;
    }
    
    public String getParameterKind() {
        return this.parameterKind;
    }
    
    public void setParameterKind(final String parameterKind) {
        this.parameterKind = parameterKind;
    }
}
