package com.uframe.generator.provider.db.procedure.model;

import java.io.*;
import java.util.*;

public class Procedure implements Serializable
{
    private static final long serialVersionUID = 6363021201582602022L;
    private String packageName;
    private String procedureName;
    private int parameterNumber;
    private String className;
    private String procedureKind;
    private LinkedHashSet<ProcedureParameter> parameters;
    private LinkedHashSet<ResultProperty> resultPropertys;
    
    public Procedure() {
        this.parameters = new LinkedHashSet<ProcedureParameter>();
        this.resultPropertys = new LinkedHashSet<ResultProperty>();
    }
    
    public Procedure(final Procedure p) {
        this.parameters = new LinkedHashSet<ProcedureParameter>();
        this.resultPropertys = new LinkedHashSet<ResultProperty>();
        this.packageName = p.getPackageName();
        this.procedureName = p.getProcedureName();
        this.parameters = p.getParameters();
        this.resultPropertys = p.getResultPropertys();
    }
    
    public int getParameterNumber() {
        return this.parameterNumber;
    }
    
    public void setParameterNumber(final int parameterNumber) {
        this.parameterNumber = parameterNumber;
    }
    
    public void addParameters(final ProcedureParameter procedureParameter) {
        this.parameters.add(procedureParameter);
    }
    
    public String getPackageName() {
        return this.packageName;
    }
    
    public void setPackageName(final String packageName) {
        this.packageName = packageName;
    }
    
    public String getProcedureName() {
        return this.procedureName;
    }
    
    public void setProcedureName(final String procedureName) {
        this.procedureName = procedureName;
    }
    
    public String getClassName() {
        return this.className;
    }
    
    public void setClassName(final String className) {
        this.className = className;
    }
    
    public LinkedHashSet<ProcedureParameter> getParameters() {
        return this.parameters;
    }
    
    public void setParameters(final LinkedHashSet<ProcedureParameter> parameters) {
        this.parameters = parameters;
    }
    
    public LinkedHashSet<ResultProperty> getResultPropertys() {
        return this.resultPropertys;
    }
    
    public void setResultPropertys(final LinkedHashSet<ResultProperty> resultPropertys) {
        this.resultPropertys = resultPropertys;
    }
    
    public String getProcedureKind() {
        return this.procedureKind;
    }
    
    public void setProcedureKind(final String procedureKind) {
        this.procedureKind = procedureKind;
    }
}
