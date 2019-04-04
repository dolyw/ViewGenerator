package com.uframe.generator.provider.db.table;

import com.uframe.generator.*;
import com.uframe.generator.provider.db.*;
import java.sql.*;
import com.uframe.generator.provider.db.table.model.*;
import java.util.*;
import com.uframe.generator.util.*;
import java.io.*;

public class TableFactory
{
    private DbHelper dbHelper;
    private static TableFactory instance;
    
    static {
        TableFactory.instance = null;
    }
    
    private TableFactory() {
        this.dbHelper = new DbHelper();
    }
    
    public static synchronized TableFactory getInstance() {
        if (TableFactory.instance == null) {
            TableFactory.instance = new TableFactory();
        }
        return TableFactory.instance;
    }
    
    public String getCatalog() {
        return GeneratorProperties.getNullIfBlank("jdbc.catalog");
    }
    
    public String getSchema() {
        return GeneratorProperties.getNullIfBlank("jdbc.schema");
    }
    
    private Connection getConnection() {
        return DataSourceProvider.getConnection();
    }
    
    public List getAllTables() {
        try {
            final Connection conn = this.getConnection();
            return this.getAllTables(conn);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public Table getTable(final String tableName) {
        return this.getTable(this.getSchema(), tableName);
    }
    
    private Table getTable(final String schema, final String tableName) {
        return this.getTable(this.getCatalog(), schema, tableName);
    }
    
    private Table getTable(final String catalog, final String schema, final String tableName) {
        Table t = null;
        try {
            t = this._getTable(catalog, schema, tableName);
            if (t == null && !tableName.equals(tableName.toUpperCase())) {
                t = this._getTable(catalog, schema, tableName.toUpperCase());
            }
            if (t == null && !tableName.equals(tableName.toLowerCase())) {
                t = this._getTable(catalog, schema, tableName.toLowerCase());
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (t == null) {
            throw new NotFoundTableException("not found table with give name:" + tableName + (this.dbHelper.isOracleDataBase() ? (" \n databaseStructureInfo:" + this.getDatabaseStructureInfo()) : ""));
        }
        return t;
    }
    
    private Table _getTable(String catalog, String schema, final String tableName) throws SQLException {
        if (tableName == null || tableName.trim().length() == 0) {
            throw new IllegalArgumentException("tableName must be not empty");
        }
        catalog = StringHelper.defaultIfEmpty(catalog, null);
        schema = StringHelper.defaultIfEmpty(schema, null);
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = this.getConnection();
            final DatabaseMetaData dbMetaData = conn.getMetaData();
            rs = dbMetaData.getTables(catalog, schema, tableName, null);
            if (rs.next()) {
                final Table table = this.createTable(conn, rs);
                return table;
            }
        }
        finally {
            rs.close();
            conn.close();
        }
        rs.close();
        conn.close();
        return null;
    }
    
    private Table createTable(final Connection conn, final ResultSet rs) throws SQLException {
        String realTableName = null;
        try {
            final ResultSetMetaData rsMetaData = rs.getMetaData();
            final String schemaName = (rs.getString("TABLE_SCHEM") == null) ? "" : rs.getString("TABLE_SCHEM");
            realTableName = rs.getString("TABLE_NAME");
            final String tableType = rs.getString("TABLE_TYPE");
            String remarks = rs.getString("REMARKS");
            if ((remarks == null || "".equals(remarks)) && this.dbHelper.isOracleDataBase()) {
                remarks = this.getOracleTableComments(realTableName);
            }
            else if ((remarks == null || "".equals(remarks)) && this.dbHelper.isMySqlDataBase()) {
                final String tableCat = rs.getString("TABLE_CAT");
                remarks = this.getMySqlTableComments(tableCat, realTableName);
            }
            final Table table = new Table();
            table.setSqlName(realTableName);
            table.setRemarks(remarks);
            if ("SYNONYM".equals(tableType) && this.dbHelper.isOracleDataBase()) {
                table.setOwnerSynonymName(this.getSynonymOwner(realTableName));
            }
            this.retriveTableColumns(table);
            table.initExportedKeys(conn.getMetaData(), this.getOracleTableOwner(realTableName));
            table.initImportedKeys(conn.getMetaData(), this.getOracleTableOwner(realTableName));
            BeanHelper.copyProperties(table, TableOverrideValuesProvider.getTableOverrideValues(table.getSqlName()));
            return table;
        }
        catch (SQLException e) {
            throw new RuntimeException("create table object error,tableName:" + realTableName, e);
        }
    }
    
    private List getAllTables(final Connection conn) throws SQLException {
        final DatabaseMetaData dbMetaData = conn.getMetaData();
        final ResultSet rs = dbMetaData.getTables(this.getCatalog(), this.getSchema(), null, null);
        final List tables = new ArrayList();
        while (rs.next()) {
            tables.add(this.createTable(conn, rs));
        }
        return tables;
    }
    
    private String getSynonymOwner(final String synonymName) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String ret = null;
        try {
            ps = this.getConnection().prepareStatement("select table_owner from sys.all_synonyms where table_name=? and owner=?");
            ps.setString(1, synonymName);
            ps.setString(2, this.getSchema());
            rs = ps.executeQuery();
            if (!rs.next()) {
                final String databaseStructure = this.getDatabaseStructureInfo();
                throw new RuntimeException("Wow! Synonym " + synonymName + " not found. How can it happen? " + databaseStructure);
            }
            ret = rs.getString(1);
        }
        catch (SQLException e) {
            final String databaseStructure2 = this.getDatabaseStructureInfo();
            GLogger.error(e.getMessage(), e);
            throw new RuntimeException("Exception in getting synonym owner " + databaseStructure2);
        }
        finally {
            this.dbHelper.close(rs, ps, new Statement[0]);
        }
        this.dbHelper.close(rs, ps, new Statement[0]);
        return ret;
    }
    
    private String getDatabaseStructureInfo() {
        ResultSet schemaRs = null;
        ResultSet catalogRs = null;
        final String nl = System.getProperty("line.separator");
        final StringBuffer sb = new StringBuffer(nl);
        sb.append("Configured schema:").append(this.getSchema()).append(nl);
        sb.append("Configured catalog:").append(this.getCatalog()).append(nl);
        Label_0193: {
            try {
                schemaRs = this.getMetaData().getSchemas();
                sb.append("Available schemas:").append(nl);
                while (schemaRs.next()) {
                    sb.append("  ").append(schemaRs.getString("TABLE_SCHEM")).append(nl);
                }
            }
            catch (SQLException e2) {
                GLogger.warn("Couldn't get schemas", e2);
                sb.append("  ?? Couldn't get schemas ??").append(nl);
                break Label_0193;
            }
            finally {
                this.dbHelper.close(schemaRs, null, new Statement[0]);
            }
            this.dbHelper.close(schemaRs, null, new Statement[0]);
            try {
                catalogRs = this.getMetaData().getCatalogs();
                sb.append("Available catalogs:").append(nl);
                while (catalogRs.next()) {
                    sb.append("  ").append(catalogRs.getString("TABLE_CAT")).append(nl);
                }
            }
            catch (SQLException e2) {
                GLogger.warn("Couldn't get catalogs", e2);
                sb.append("  ?? Couldn't get catalogs ??").append(nl);
                return sb.toString();
            }
            finally {
                this.dbHelper.close(catalogRs, null, new Statement[0]);
            }
        }
        this.dbHelper.close(catalogRs, null, new Statement[0]);
        return sb.toString();
    }
    
    private DatabaseMetaData getMetaData() throws SQLException {
        return this.getConnection().getMetaData();
    }
    
    private void retriveTableColumns(final Table table) throws SQLException {
        GLogger.trace("-------setColumns(" + table.getSqlName() + ")");
        final List primaryKeys = this.getTablePrimaryKeys(table);
        table.setPrimaryKeyColumns(primaryKeys);
        final List indices = new LinkedList();
        final Map uniqueIndices = new HashMap();
        final Map uniqueColumns = new HashMap();
        ResultSet indexRs = null;
        Label_0383: {
            try {
                if (table.getOwnerSynonymName() != null) {
                    indexRs = this.getMetaData().getIndexInfo(this.getCatalog(), table.getOwnerSynonymName(), table.getSqlName(), false, true);
                }
                else {
                    indexRs = this.getMetaData().getIndexInfo(this.getCatalog(), this.getSchema(), table.getSqlName(), false, true);
                }
                while (indexRs.next()) {
                    final String columnName = indexRs.getString("COLUMN_NAME");
                    if (columnName != null) {
                        GLogger.trace("index:" + columnName);
                        indices.add(columnName);
                    }
                    final String indexName = indexRs.getString("INDEX_NAME");
                    final boolean nonUnique = indexRs.getBoolean("NON_UNIQUE");
                    if (!nonUnique && columnName != null && indexName != null) {
                        List l = (List) uniqueColumns.get(indexName);
                        if (l == null) {
                            l = new ArrayList();
                            uniqueColumns.put(indexName, l);
                        }
                        l.add(columnName);
                        uniqueIndices.put(columnName, indexName);
                        GLogger.trace("unique:" + columnName + " (" + indexName + ")");
                    }
                }
            }
            catch (Throwable t) {
                break Label_0383;
            }
            finally {
                this.dbHelper.close(indexRs, null, new Statement[0]);
            }
            this.dbHelper.close(indexRs, null, new Statement[0]);
        }
        final List columns = this.getTableColumns(table, primaryKeys, indices, uniqueIndices, uniqueColumns);
        for (Object column : columns) {
            table.addColumn((Column) column);
        }
        if (primaryKeys.size() == 0) {
            GLogger.warn("WARNING: The JDBC driver didn't report any primary key columns in " + table.getSqlName());
        }
    }
    
    private List getTableColumns(final Table table, final List primaryKeys, final List indices, final Map uniqueIndices, final Map uniqueColumns) throws SQLException {
        final List columns = new LinkedList();
        final ResultSet columnRs = this.getColumnsResultSet(table);
        while (columnRs.next()) {
            final int sqlType = columnRs.getInt("DATA_TYPE");
            final String sqlTypeName = columnRs.getString("TYPE_NAME");
            final String columnName = columnRs.getString("COLUMN_NAME");
            final String columnDefaultValue = columnRs.getString("COLUMN_DEF");
            String remarks = columnRs.getString("REMARKS");
            if (remarks == null && this.dbHelper.isOracleDataBase()) {
                remarks = this.getOracleColumnComments(table.getSqlName(), columnName);
            }
            final boolean isNullable = 1 == columnRs.getInt("NULLABLE");
            final int size = columnRs.getInt("COLUMN_SIZE");
            final int decimalDigits = columnRs.getInt("DECIMAL_DIGITS");
            final boolean isPk = primaryKeys.contains(columnName);
            final boolean isIndexed = indices.contains(columnName);
            final String uniqueIndex = StringHelper.convertType(uniqueIndices.get(columnName));
            List columnsInUniqueIndex = null;
            if (uniqueIndex != null) {
                columnsInUniqueIndex = (List) uniqueColumns.get(uniqueIndex);
            }
            final boolean isUnique = columnsInUniqueIndex != null && columnsInUniqueIndex.size() == 1;
            if (isUnique) {
                GLogger.trace("unique column:" + columnName);
            }
            final Column column = new Column(table, sqlType, sqlTypeName, columnName, size, decimalDigits, isPk, isNullable, isIndexed, isUnique, columnDefaultValue, remarks);
            BeanHelper.copyProperties(column, TableOverrideValuesProvider.getColumnOverrideValues(table, column));
            columns.add(column);
        }
        columnRs.close();
        return columns;
    }
    
    private ResultSet getColumnsResultSet(final Table table) throws SQLException {
        ResultSet columnRs = null;
        if (table.getOwnerSynonymName() != null) {
            columnRs = this.getMetaData().getColumns(this.getCatalog(), table.getOwnerSynonymName(), table.getSqlName(), null);
        }
        else {
            columnRs = this.getMetaData().getColumns(this.getCatalog(), this.getSchema(), table.getSqlName(), null);
        }
        return columnRs;
    }
    
    private List<String> getTablePrimaryKeys(final Table table) throws SQLException {
        final List primaryKeys = new LinkedList();
        ResultSet primaryKeyRs = null;
        if (table.getOwnerSynonymName() != null) {
            primaryKeyRs = this.getMetaData().getPrimaryKeys(this.getCatalog(), table.getOwnerSynonymName(), table.getSqlName());
        }
        else {
            primaryKeyRs = this.getMetaData().getPrimaryKeys(this.getCatalog(), this.getSchema(), table.getSqlName());
        }
        while (primaryKeyRs.next()) {
            final String columnName = primaryKeyRs.getString("COLUMN_NAME");
            GLogger.trace("primary key:" + columnName);
            primaryKeys.add(columnName);
        }
        primaryKeyRs.close();
        return (List<String>)primaryKeys;
    }
    
    private String getOracleTableComments(final String table) {
        final String sql = "SELECT comments FROM all_tab_comments WHERE table_name='" + table + "'";
        return this.dbHelper.queryForString(sql);
    }
    
    private String getMySqlTableComments(final String schema, final String table) {
        final String sql = "SELECT SUBSTRING_INDEX(TABLE_COMMENT, '; InnoDB', 1) FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = '" + schema + "' AND table_name = '" + table + "'";
        return this.dbHelper.queryForString(sql);
    }
    
    private String getOracleColumnComments(final String table, final String column) {
        final String sql = "SELECT comments FROM ALL_COL_COMMENTS WHERE table_name='" + table + "' AND column_name = '" + column + "'";
        return this.dbHelper.queryForString(sql);
    }
    
    private String getOracleTableOwner(final String tableName) {
        final String sql = "SELECT owner FROM all_tables WHERE table_name='" + tableName + "'";
        return this.dbHelper.queryForString(sql);
    }
    
    public static class NotFoundTableException extends RuntimeException
    {
        private static final long serialVersionUID = 5976869128012158628L;
        
        public NotFoundTableException(final String message) {
            super(message);
        }
    }
    
    public static class TableOverrideValuesProvider
    {
        public static Map getTableOverrideValues(final String tableSqlName) {
            final XMLHelper.NodeData nd = getTableConfigXmlNodeData(tableSqlName);
            if (nd == null) {
                return new HashMap();
            }
            return (nd == null) ? new HashMap<String, String>() : nd.attributes;
        }

        public static Map getColumnOverrideValues(final Table table, final Column column) {
            final XMLHelper.NodeData root = getTableConfigXmlNodeData(table.getSqlName());
            if (root != null) {
                for (final XMLHelper.NodeData item : root.childs) {
                    if (item.nodeName.equals("column") && column.getSqlName().equalsIgnoreCase(item.attributes.get("sqlName"))) {
                        return item.attributes;
                    }
                }
            }
            return new HashMap();
        }

        public static XMLHelper.NodeData getTableConfigXmlNodeData(final String tableSqlName) {
            XMLHelper.NodeData nd = getTableConfigXmlNodeData0(tableSqlName);
            if (nd == null) {
                nd = getTableConfigXmlNodeData0(tableSqlName.toLowerCase());
                if (nd == null) {
                    nd = getTableConfigXmlNodeData0(tableSqlName.toUpperCase());
                }
            }
            return nd;
        }

        public static XMLHelper.NodeData getTableConfigXmlNodeData0(final String tableSqlName) {
            try {
                final File file = FileHelper.getFileByClassLoader("generator_config/table/" + tableSqlName + ".xml");
                GLogger.trace("getTableConfigXml() load nodeData by tableSqlName:" + tableSqlName + ".xml");
                return new XMLHelper().parseXML(file);
            }
            catch (Exception e) {
                GLogger.trace("not found config xml for table:" + tableSqlName + ", exception:" + e);
                return null;
            }
        }
    }
    
    class DbHelper
    {
        public void close(final ResultSet rs, final PreparedStatement ps, final Statement... statements) {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
                for (final Statement s : statements) {
                    s.close();
                }
            }
            catch (Exception ex) {}
        }
        
        public boolean isOracleDataBase() {
            try {
                return DatabaseMetaDataUtils.isOracleDataBase(TableFactory.this.getMetaData());
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        
        public boolean isMySqlDataBase() {
            try {
                return DatabaseMetaDataUtils.isMySqlDataBase(TableFactory.this.getMetaData());
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        
        public String queryForString(final String sql) {
            Statement s = null;
            ResultSet rs = null;
            try {
                s = TableFactory.this.getConnection().createStatement();
                rs = s.executeQuery(sql);
                if (rs.next()) {
                    return rs.getString(1);
                }
                return null;
            }
            catch (SQLException e) {
                return null;
            }
            finally {
                this.close(rs, null, s);
            }
        }
    }
    
    public static class DatabaseMetaDataUtils
    {
        public static boolean isOracleDataBase(final DatabaseMetaData metadata) {
            try {
                boolean ret = false;
                ret = (metadata.getDatabaseProductName().toLowerCase().indexOf("oracle") != -1);
                return ret;
            }
            catch (SQLException s) {
                return false;
            }
        }
        
        public static boolean isHsqlDataBase(final DatabaseMetaData metadata) {
            try {
                boolean ret = false;
                ret = (metadata.getDatabaseProductName().toLowerCase().indexOf("hsql") != -1);
                return ret;
            }
            catch (SQLException s) {
                return false;
            }
        }
        
        public static boolean isMySqlDataBase(final DatabaseMetaData metadata) {
            try {
                boolean ret = false;
                ret = (metadata.getDatabaseProductName().toLowerCase().indexOf("mysql") != -1);
                return ret;
            }
            catch (SQLException s) {
                return false;
            }
        }
    }
}
