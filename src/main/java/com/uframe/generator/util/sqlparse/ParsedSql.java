package com.uframe.generator.util.sqlparse;

import java.util.*;

public class ParsedSql
{
    private String originalSql;
    private List<String> parameterNames;
    private List<String> parameterPlaceholders;
    private List<int[]> parameterIndexes;
    private int namedParameterCount;
    private int unnamedParameterCount;
    private int totalParameterCount;
    
    ParsedSql(final String originalSql) {
        this.parameterNames = new ArrayList<String>();
        this.parameterPlaceholders = new ArrayList<String>();
        this.parameterIndexes = new ArrayList<int[]>();
        this.originalSql = originalSql;
    }
    
    String getOriginalSql() {
        return this.originalSql;
    }
    
    public void addNamedParameter(final String parameterName, final String parameterPlaceholder, final int startIndex, final int endIndex) {
        this.parameterNames.add(parameterName);
        this.parameterPlaceholders.add(parameterPlaceholder);
        this.parameterIndexes.add(new int[] { startIndex, endIndex });
    }
    
    public List<String> getParameterNames() {
        return this.parameterNames;
    }
    
    public List<String> getParameterPlaceholders() {
        return this.parameterPlaceholders;
    }
    
    public int[] getParameterIndexes(final int parameterPosition) {
        return this.parameterIndexes.get(parameterPosition);
    }
    
    public void setNamedParameterCount(final int namedParameterCount) {
        this.namedParameterCount = namedParameterCount;
    }
    
    public int getNamedParameterCount() {
        return this.namedParameterCount;
    }
    
    public void setUnnamedParameterCount(final int unnamedParameterCount) {
        this.unnamedParameterCount = unnamedParameterCount;
    }
    
    public int getUnnamedParameterCount() {
        return this.unnamedParameterCount;
    }
    
    public void setTotalParameterCount(final int totalParameterCount) {
        this.totalParameterCount = totalParameterCount;
    }
    
    public int getTotalParameterCount() {
        return this.totalParameterCount;
    }
    
    @Override
    public String toString() {
        return this.originalSql;
    }
}
