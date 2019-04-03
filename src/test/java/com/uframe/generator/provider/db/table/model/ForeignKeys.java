package com.uframe.generator.provider.db.table.model;

import java.io.*;
import com.uframe.generator.util.*;

public class ForeignKeys implements Serializable
{
    protected Table parentTable;
    protected ListHashtable associatedTables;
    
    public ForeignKeys(final Table aTable) {
        this.parentTable = aTable;
        this.associatedTables = new ListHashtable();
    }
    
    public void addForeignKey(final String tableName, final String columnName, final String parentColumn, final Integer seq) {
        ForeignKey tbl = null;
        if (this.associatedTables.containsKey(tableName)) {
            tbl = (ForeignKey) this.associatedTables.get(tableName);
        }
        else {
            tbl = new ForeignKey(this.parentTable, tableName);
            this.associatedTables.put(tableName, tbl);
        }
        tbl.addColumn(columnName, parentColumn, seq);
    }
    
    public ListHashtable getAssociatedTables() {
        return this.associatedTables;
    }
    
    public int getSize() {
        return this.getAssociatedTables().size();
    }
    
    public boolean getHasImportedKeyColumn(final String aColumn) {
        boolean isFound = false;
        for (int numKeys = this.getAssociatedTables().size(), i = 0; i < numKeys; ++i) {
            final ForeignKey aKey = (ForeignKey)this.getAssociatedTables().getOrderedValue(i);
            if (aKey.getHasImportedKeyColumn(aColumn)) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }
    
    public ForeignKey getAssociatedTable(final String name) {
        final Object fkey = this.getAssociatedTables().get(name);
        if (fkey != null) {
            return (ForeignKey)fkey;
        }
        return null;
    }
    
    public Table getParentTable() {
        return this.parentTable;
    }
    
    public boolean getHasImportedKeyParentColumn(final String aColumn) {
        boolean isFound = false;
        for (int numKeys = this.getAssociatedTables().size(), i = 0; i < numKeys; ++i) {
            final ForeignKey aKey = (ForeignKey)this.getAssociatedTables().getOrderedValue(i);
            if (aKey.getHasImportedKeyParentColumn(aColumn)) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }
    
    public ForeignKey getImportedKeyParentColumn(final String aColumn) {
        ForeignKey aKey = null;
        for (int numKeys = this.getAssociatedTables().size(), i = 0; i < numKeys; ++i) {
            aKey = (ForeignKey)this.getAssociatedTables().getOrderedValue(i);
            if (aKey.getHasImportedKeyParentColumn(aColumn)) {
                break;
            }
        }
        return aKey;
    }
}
