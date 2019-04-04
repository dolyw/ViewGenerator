package com.uframe.generator.provider.db.table.model;

import java.io.*;
import com.uframe.generator.provider.db.table.*;
import java.util.*;
import com.uframe.generator.util.*;

public class ForeignKey implements Serializable
{
    protected String relationShip;
    protected String firstRelation;
    protected String secondRelation;
    protected Table parentTable;
    protected String tableName;
    protected ListHashtable columns;
    protected ListHashtable parentColumns;
    
    public ForeignKey(final Table aTable, final String tblName) {
        this.relationShip = null;
        this.firstRelation = null;
        this.secondRelation = null;
        this.parentTable = aTable;
        this.tableName = tblName;
        this.columns = new ListHashtable();
        this.parentColumns = new ListHashtable();
    }
    
    public String getTableName() {
        return this.tableName;
    }
    
    public String getParentTableName() {
        return this.parentTable.getSqlName();
    }
    
    public void addColumn(final String col, final String parentCol, final Integer seq) {
        this.columns.put(seq, col);
        this.parentColumns.put(seq, parentCol);
    }
    
    public String getColumn(final String parentCol) {
        final Object key = this.parentColumns.getKeyForValue(parentCol);
        final String col = StringHelper.convertType(this.columns.get(key));
        return col;
    }
    
    public ListHashtable getColumns() {
        return this.columns;
    }
    
    private void initRelationship() {
        this.firstRelation = "";
        this.secondRelation = "";
        Table foreignTable = null;
        try {
            foreignTable = TableFactory.getInstance().getTable(this.tableName);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        final List parentPrimaryKeys = this.parentTable.getPrimaryKeyColumns();
        final List foreignPrimaryKeys = foreignTable.getPrimaryKeyColumns();
        if (this.hasAllPrimaryKeys(parentPrimaryKeys, this.parentColumns)) {
            this.firstRelation = "one";
        }
        else {
            this.firstRelation = "many";
        }
        if (this.hasAllPrimaryKeys(foreignPrimaryKeys, this.columns)) {
            this.secondRelation = "one";
        }
        else {
            this.secondRelation = "many";
        }
        this.relationShip = String.valueOf(this.firstRelation) + "-to-" + this.secondRelation;
    }
    
    private boolean hasAllPrimaryKeys(final List pkeys, final ListHashtable cols) {
        final boolean hasAll = true;
        final int numKeys = pkeys.size();
        if (numKeys != cols.size()) {
            return false;
        }
        for (int i = 0; i < numKeys; ++i) {
            final Column col = (Column) pkeys.get(i);
            final String colname = col.getColumnName();
            if (!cols.contains(colname)) {
                return false;
            }
        }
        return hasAll;
    }
    
    public boolean isParentColumnsFromPrimaryKey() {
        boolean isFrom = true;
        final List keys = this.parentTable.getPrimaryKeyColumns();
        for (int numKeys = this.getParentColumns().size(), i = 0; i < numKeys; ++i) {
            final String pcol = (String)this.getParentColumns().getOrderedValue(i);
            if (!this.primaryKeyHasColumn(pcol)) {
                isFrom = false;
                break;
            }
        }
        return isFrom;
    }
    
    private boolean primaryKeyHasColumn(final String aColumn) {
        boolean isFound = false;
        for (int numKeys = this.parentTable.getPrimaryKeyColumns().size(), i = 0; i < numKeys; ++i) {
            final Column sqlCol = this.parentTable.getPrimaryKeyColumns().get(i);
            final String colname = sqlCol.getColumnName();
            if (colname.equals(aColumn)) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }
    
    public boolean getHasImportedKeyColumn(final String aColumn) {
        boolean isFound = false;
        final List cols = this.getColumns().getOrderedValues();
        for (int numCols = cols.size(), i = 0; i < numCols; ++i) {
            final String col = StringHelper.convertType(cols.get(i));
            if (col.equals(aColumn)) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }
    
    public String getFirstRelation() {
        if (this.firstRelation == null) {
            this.initRelationship();
        }
        return this.firstRelation;
    }
    
    public Table getSqlTable() {
        Table table = null;
        try {
            table = TableFactory.getInstance().getTable(this.tableName);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }
    
    public Table getParentTable() {
        return this.parentTable;
    }
    
    public String getRelationShip() {
        if (this.relationShip == null) {
            this.initRelationship();
        }
        return this.relationShip;
    }
    
    public String getSecondRelation() {
        if (this.secondRelation == null) {
            this.initRelationship();
        }
        return this.secondRelation;
    }
    
    public ListHashtable getParentColumns() {
        return this.parentColumns;
    }
    
    public boolean getHasImportedKeyParentColumn(final String aColumn) {
        boolean isFound = false;
        final List cols = this.getParentColumns().getOrderedValues();
        for (int numCols = cols.size(), i = 0; i < numCols; ++i) {
            final String col = StringHelper.convertType(cols.get(i));
            if (col.equals(aColumn)) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }
    
    public static class ReferenceKey implements Serializable
    {
        public String schemaName;
        public String tableName;
        public String columnSqlName;
        
        public ReferenceKey(final String schemaName, final String tableName, final String columnSqlName) {
            this.schemaName = StringHelper.defaultIfEmpty(schemaName, null);
            this.tableName = tableName;
            this.columnSqlName = columnSqlName;
        }
        
        @Override
        public String toString() {
            if (StringHelper.isBlank(this.schemaName)) {
                return String.valueOf(this.tableName) + "(" + this.columnSqlName + ")";
            }
            return String.valueOf(this.schemaName) + "." + this.tableName + "(" + this.columnSqlName + ")";
        }
        
        public static String toString(final ReferenceKey k) {
            if (k == null) {
                return null;
            }
            return k.toString();
        }
        
        public static ReferenceKey fromString(final String foreignKey) {
            if (StringHelper.isBlank(foreignKey)) {
                return null;
            }
            if (!foreignKey.trim().matches(".*\\w+\\(.*\\)")) {
                throw new IllegalArgumentException("Illegal foreignKey:[" + foreignKey + "] ,example value: fk_table_name(fk_column) ");
            }
            final String schemaName = foreignKey.substring(0, Math.max(foreignKey.lastIndexOf("."), 0));
            final String tableSqlName = foreignKey.substring(Math.max(foreignKey.lastIndexOf(".") + 1, 0), foreignKey.indexOf("("));
            final String columnSqlName = foreignKey.substring(foreignKey.indexOf("(") + 1, foreignKey.indexOf(")"));
            return new ReferenceKey(schemaName, tableSqlName, columnSqlName);
        }
    }
}
