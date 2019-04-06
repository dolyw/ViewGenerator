package com.uframe.generator.provider.db.table.model;

import java.io.*;
import com.uframe.generator.provider.db.table.*;
import com.uframe.generator.*;
import com.uframe.generator.util.*;
import java.util.*;
import java.sql.*;

public class Table implements Serializable, Cloneable
{
    String sqlName;
    String remarks;
    String className;
    private String ownerSynonymName;
    private String tableSynonymName;
    LinkedHashSet<Column> columns;
    List<Column> primaryKeyColumns;
    String catalog;
    String schema;
    private String tableAlias;
    private ForeignKeys exportedKeys;
    private ForeignKeys importedKeys;
    public static final String PKTABLE_NAME = "PKTABLE_NAME";
    public static final String PKCOLUMN_NAME = "PKCOLUMN_NAME";
    public static final String FKTABLE_NAME = "FKTABLE_NAME";
    public static final String FKCOLUMN_NAME = "FKCOLUMN_NAME";
    public static final String KEY_SEQ = "KEY_SEQ";
    
    public Table() {
        this.ownerSynonymName = null;
        this.tableSynonymName = null;
        this.columns = new LinkedHashSet<Column>();
        this.primaryKeyColumns = new ArrayList<Column>();
        this.catalog = TableFactory.getInstance().getCatalog();
        this.schema = TableFactory.getInstance().getSchema();
    }
    
    public Table(final Table t) {
        this.ownerSynonymName = null;
        this.tableSynonymName = null;
        this.columns = new LinkedHashSet<Column>();
        this.primaryKeyColumns = new ArrayList<Column>();
        this.catalog = TableFactory.getInstance().getCatalog();
        this.schema = TableFactory.getInstance().getSchema();
        this.setSqlName(t.getSqlName());
        this.remarks = t.getRemarks();
        this.className = t.getClassName();
        this.ownerSynonymName = t.getOwnerSynonymName();
        this.columns = t.getColumns();
        this.primaryKeyColumns = t.getPrimaryKeyColumns();
        this.tableAlias = t.getTableAlias();
        this.exportedKeys = t.exportedKeys;
        this.importedKeys = t.importedKeys;
    }
    
    public LinkedHashSet<Column> getColumns() {
        return this.columns;
    }
    
    public void setColumns(final LinkedHashSet<Column> columns) {
        this.columns = columns;
    }
    
    public String getOwnerSynonymName() {
        return this.ownerSynonymName;
    }
    
    public void setOwnerSynonymName(final String ownerSynonymName) {
        this.ownerSynonymName = ownerSynonymName;
    }
    
    public String getTableSynonymName() {
        return this.tableSynonymName;
    }
    
    public void setTableSynonymName(final String tableSynonymName) {
        this.tableSynonymName = tableSynonymName;
    }
    
    @Deprecated
    public List<Column> getPrimaryKeyColumns() {
        return this.primaryKeyColumns;
    }
    
    @Deprecated
    public void setPrimaryKeyColumns(final List<Column> primaryKeyColumns) {
        this.primaryKeyColumns = primaryKeyColumns;
    }
    
    public String getSqlName() {
        if ("U".equals(GeneratorProperties.getProperty("table.sqlName.caseSize", "L").trim())) {
            return this.sqlName.toUpperCase();
        }
        return this.sqlName.toLowerCase();
    }
    
    public void setSqlName(final String sqlName) {
        this.sqlName = sqlName;
    }
    
    public static String removeTableSqlNamePrefix(final String sqlName) {
        final String prefixs = GeneratorProperties.getProperty("tableRemovePrefixes", "");
        String[] split;
        for (int length = (split = prefixs.split(",")).length, i = 0; i < length; ++i) {
            final String prefix = split[i];
            final String removedPrefixSqlName = StringHelper.removePrefix(sqlName, prefix, true);
            if (!removedPrefixSqlName.equals(sqlName)) {
                return removedPrefixSqlName;
            }
        }
        return sqlName;
    }
    
    public String getRemarks() {
        return this.remarks;
    }
    
    public void setRemarks(final String remarks) {
        this.remarks = remarks;
    }
    
    public void addColumn(final Column column) {
        this.columns.add(column);
    }
    
    public void setClassName(final String customClassName) {
        this.className = customClassName;
    }
    
    public String getClassName() {
        if (StringHelper.isBlank(this.className)) {
            final String removedPrefixSqlName = removeTableSqlNamePrefix(this.sqlName);
            return StringHelper.makeAllWordFirstLetterUpperCase(StringHelper.toUnderscoreName(removedPrefixSqlName));
        }
        return this.className;
    }
    
    public String getTableAlias() {
        if (StringHelper.isNotBlank(this.tableAlias)) {
            return this.tableAlias;
        }
        return StringHelper.removeCrlf(StringHelper.defaultIfEmpty(this.getRemarks(), this.getClassName()));
    }
    
    public void setTableAlias(final String v) {
        this.tableAlias = v;
    }
    
    public String getClassNameLowerCase() {
        return this.getClassName().toLowerCase();
    }
    
    public String getUnderscoreName() {
        return StringHelper.toUnderscoreName(this.getClassName()).toLowerCase();
    }
    
    public String getClassNameFirstLower() {
        return StringHelper.uncapitalize(this.getClassName());
    }
    
    public String getConstantName() {
        return StringHelper.toUnderscoreName(this.getClassName()).toUpperCase();
    }
    
    @Deprecated
    public boolean isSingleId() {
        return this.getPkCount() == 1;
    }
    
    @Deprecated
    public boolean isCompositeId() {
        return this.getPkCount() > 1;
    }
    
    @Deprecated
    public boolean isNotCompositeId() {
        return !this.isCompositeId();
    }
    
    public int getPkCount() {
        int pkCount = 0;
        for (final Column c : this.columns) {
            if (c.isPk()) {
                ++pkCount;
            }
        }
        return pkCount;
    }
    
    @Deprecated
    public List getCompositeIdColumns() {
        return this.getPkColumns();
    }
    
    public List<Column> getPkColumns() {
        final List results = new ArrayList();
        for (final Column c : this.getColumns()) {
            if (c.isPk()) {
                results.add(c);
            }
        }
        return (List<Column>)results;
    }
    
    public List<Column> getNotPkColumns() {
        final List results = new ArrayList();
        for (final Column c : this.getColumns()) {
            if (!c.isPk()) {
                results.add(c);
            }
        }
        return (List<Column>)results;
    }
    
    public Column getPkColumn() {
        if (this.getPkColumns().isEmpty()) {
            throw new IllegalStateException("not found primary key on table:" + this.getSqlName());
        }
        return this.getPkColumns().get(0);
    }
    
    @Deprecated
    public Column getIdColumn() {
        return this.getPkColumn();
    }
    
    public List<Column> getEnumColumns() {
        final List results = new ArrayList();
        for (final Column c : this.getColumns()) {
            if (!c.isEnumColumn()) {
                results.add(c);
            }
        }
        return (List<Column>)results;
    }
    
    public Column getColumnByName(final String name) {
        Column c = this.getColumnBySqlName(name);
        if (c == null) {
            c = this.getColumnBySqlName(StringHelper.toUnderscoreName(name));
        }
        return c;
    }
    
    public Column getColumnBySqlName(final String sqlName) {
        for (final Column c : this.getColumns()) {
            if (c.getSqlName().equalsIgnoreCase(sqlName)) {
                return c;
            }
        }
        return null;
    }
    
    public Column getRequiredColumnBySqlName(final String sqlName) {
        if (this.getColumnBySqlName(sqlName) == null) {
            throw new IllegalArgumentException("not found column with sqlName:" + sqlName + " on table:" + this.getSqlName());
        }
        return this.getColumnBySqlName(sqlName);
    }
    
    public List<Column> getIgnoreKeywordsColumns(final String ignoreKeywords) {
        final List results = new ArrayList();
        for (final Column c : this.getColumns()) {
            final String sqlname = c.getSqlName().toLowerCase();
            if (StringHelper.contains(sqlname, ignoreKeywords.split(","))) {
                continue;
            }
            results.add(c);
        }
        return (List<Column>)results;
    }
    
    public void initImportedKeys(final DatabaseMetaData dbmd, final String owner) throws SQLException {
        final ResultSet fkeys = dbmd.getImportedKeys(this.catalog, owner, this.sqlName);
        while (fkeys.next()) {
            final String pktable = fkeys.getString("PKTABLE_NAME");
            final String pkcol = fkeys.getString("PKCOLUMN_NAME");
            final String fktable = fkeys.getString("FKTABLE_NAME");
            final String fkcol = fkeys.getString("FKCOLUMN_NAME");
            final String seq = fkeys.getString("KEY_SEQ");
            final Integer iseq = new Integer(seq);
            this.getImportedKeys().addForeignKey(pktable, pkcol, fkcol, iseq);
        }
        fkeys.close();
    }
    
    public void initExportedKeys(final DatabaseMetaData dbmd, final String owner) throws SQLException {
        final ResultSet fkeys = dbmd.getExportedKeys(this.catalog, owner, this.sqlName);
        while (fkeys.next()) {
            final String pktable = fkeys.getString("PKTABLE_NAME");
            final String pkcol = fkeys.getString("PKCOLUMN_NAME");
            final String fktable = fkeys.getString("FKTABLE_NAME");
            final String fkcol = fkeys.getString("FKCOLUMN_NAME");
            final String seq = fkeys.getString("KEY_SEQ");
            final Integer iseq = new Integer(seq);
            this.getExportedKeys().addForeignKey(fktable, fkcol, pkcol, iseq);
        }
        fkeys.close();
    }
    
    public ForeignKeys getExportedKeys() {
        if (this.exportedKeys == null) {
            this.exportedKeys = new ForeignKeys(this);
        }
        return this.exportedKeys;
    }
    
    public ForeignKeys getImportedKeys() {
        if (this.importedKeys == null) {
            this.importedKeys = new ForeignKeys(this);
        }
        return this.importedKeys;
    }
    
    @Override
    public String toString() {
        return "Database Table:" + this.getSqlName() + " to ClassName:" + this.getClassName();
    }
    
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
