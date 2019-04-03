package com.uframe.generator.provider.db.procedure.model;

import java.io.*;

public class CustomObjectParameter implements Serializable
{
    private static final long serialVersionUID = 7645829463583539071L;
    private ProcedureParameter procedureParameter;
    private String objectName;
    private String objectNameLower;
    private String objectClass;
    private String customListName;
    private String cunstomListNameLower;
    private String sqlTypeName;
    private String jdbcTypeName;
    private String javaTypeName;
    
    public String getObjectClass() {
        return this.objectClass;
    }
    
    public void setObjectClass(final String objectClass) {
        this.objectClass = objectClass;
    }
    
    public ProcedureParameter getProcedureParameter() {
        return this.procedureParameter;
    }
    
    public void setProcedureParameter(final ProcedureParameter procedureParameter) {
        this.procedureParameter = procedureParameter;
    }
    
    public String getObjectName() {
        return this.objectName;
    }
    
    public void setObjectName(final String objectName) {
        this.objectName = objectName;
    }
    
    public String getObjectNameLower() {
        return this.objectNameLower;
    }
    
    public void setObjectNameLower(final String objectNameLower) {
        this.objectNameLower = objectNameLower;
    }
    
    public String getCustomListName() {
        return this.customListName;
    }
    
    public void setCustomListName(final String customListName) {
        this.customListName = customListName;
    }
    
    public String getCunstomListNameLower() {
        return this.cunstomListNameLower;
    }
    
    public void setCunstomListNameLower(final String cunstomListNameLower) {
        this.cunstomListNameLower = cunstomListNameLower;
    }
    
    public String getSqlTypeName() {
        return this.sqlTypeName;
    }
    
    public void setSqlTypeName(final String sqlTypeName) {
        this.sqlTypeName = sqlTypeName;
    }
    
    public String getJdbcTypeName() {
        return this.jdbcTypeName;
    }
    
    public void setJdbcTypeName(final String jdbcTypeName) {
        this.jdbcTypeName = jdbcTypeName;
    }
    
    public String getJavaTypeName() {
        return this.javaTypeName;
    }
    
    public void setJavaTypeName(final String javaTypeName) {
        this.javaTypeName = javaTypeName;
    }
}
