package com.uframe.generator.provider.db.procedure;

import com.uframe.generator.*;
import com.uframe.generator.provider.db.*;
import com.uframe.generator.provider.db.table.*;
import com.uframe.generator.util.*;
import org.antlr.runtime.tree.*;
import org.antlr.runtime.*;
import java.util.*;
import com.uframe.generator.util.typemapping.*;
import com.uframe.generator.util.enums.*;
import com.uframe.generator.provider.db.procedure.model.*;
import java.sql.*;

public class ProcedureFactory
{
    private DbHelper dbHelper;
    private static ProcedureFactory instance;
    
    static {
        ProcedureFactory.instance = null;
    }
    
    private ProcedureFactory() {
        this.dbHelper = new DbHelper();
    }
    
    public static synchronized ProcedureFactory getInstance() {
        if (ProcedureFactory.instance == null) {
            ProcedureFactory.instance = new ProcedureFactory();
        }
        return ProcedureFactory.instance;
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
    
    public Procedure getProcedure(final String procedureName) throws SQLException {
        return this.getProcedure(this.getCatalog(), this.getSchema(), procedureName);
    }
    
    public Procedure getProcedure(final String catalog, final String schema, final String procedureName) throws SQLException {
        Procedure p = null;
        try {
            p = this._getProcedure(catalog, schema, procedureName);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (p == null) {
            throw new TableFactory.NotFoundTableException("not found procedure with give procedureName:" + procedureName);
        }
        return p;
    }
    
    public Procedure _getProcedure(String catalog, String schema, final String procedureName) throws SQLException, RecognitionException {
        if (procedureName == null || procedureName.trim().length() == 0) {
            throw new IllegalArgumentException("procedureName must be not empty");
        }
        if (procedureName.indexOf(".") < 0) {
            throw new IllegalArgumentException("procedureName input error,must package.procedureName");
        }
        catalog = StringHelper.defaultIfEmpty(catalog, null);
        schema = StringHelper.defaultIfEmpty(schema, null);
        final int len = procedureName.indexOf(".");
        final String packageName = procedureName.substring(0, len);
        final String upPackageName = packageName.toUpperCase();
        final String newProName = procedureName.substring(len + 1);
        final String lowProName = newProName.toLowerCase();
        final String packageContent = this.getPackageContent(upPackageName);
        final List procedureList = this.genProcedureParameters(packageContent);
        final Procedure procedure = this.createProcedure(upPackageName, lowProName, procedureList);
        return procedure;
    }
    
    public String getPackageContent(final String upPackageName) throws SQLException {
        final StringBuffer sb = new StringBuffer();
        sb.append("create or replace ");
        final String sql = "SELECT lower(text) as text FROM user_source WHERE name = '" + upPackageName + "' and type = 'PACKAGE'";
        final Statement s = this.getConnection().createStatement();
        final ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            sb.append(rs.getString("text"));
        }
        return sb.toString();
    }
    
    public List genProcedureParameters(final String packageContent) throws RecognitionException {
        final CharStream cs = (CharStream)new ANTLRStringStream(packageContent);
        final PLSQL2Lexer lexer = new PLSQL2Lexer(cs);
        final CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource((TokenSource)lexer);
        final Parser parser2;
        final PLSQL2Parser parser = (PLSQL2Parser)(parser2 = new PLSQL2Parser((TokenStream)tokens));
        final RuleReturnScope result = (RuleReturnScope)parser.sqlplus_file();
        final CommonTree tree = (CommonTree)result.getTree();
        final List procedureList = parser.getProcedureList();
        return procedureList;
    }
    
    public Procedure createProcedure(final String upPackageName, final String lowProName, final List procedureList) throws SQLException, RecognitionException {
        if (procedureList == null || procedureList.size() == 0) {
            throw new RuntimeException("package \u89e3\u6790\u65e0\u7ed3\u679c\uff01");
        }
        final Map map = new HashMap();
        for (int i = 0; i < procedureList.size(); ++i) {
            final Map rtMap = (Map) procedureList.get(i);
            final String proname = StringHelper.convertType(rtMap.get("id"));
            if (proname.equals(lowProName)) {
                map.putAll(rtMap);
                break;
            }
        }
        if (map == null || map.size() == 0) {
            throw new RuntimeException(String.valueOf(upPackageName) + "\u4e2d\u4e0d\u5b58\u5728\u5b58\u50a8\u8fc7\u7a0b\uff1a" + lowProName);
        }
        final Procedure procedure = new Procedure();
        procedure.setPackageName(upPackageName);
        procedure.setProcedureName(lowProName);
        final List paramList = (List) map.get("paramList");
        procedure.setParameterNumber(paramList.size());
        final String className = StringHelper.convertToClassName(lowProName);
        procedure.setClassName(className);
        procedure.setProcedureKind("NORMAL");
        this.retriveProcedureParameters(procedure, paramList);
        return procedure;
    }
    
    public void retriveProcedureParameters(final Procedure procedure, final List paramList) throws SQLException, RecognitionException {
        final LinkedHashSet<ProcedureParameter> parameters = new LinkedHashSet<ProcedureParameter>();
        for (int i = 0; i < paramList.size(); ++i) {
            final Map map = (Map) paramList.get(i);
            final String parameterName = StringHelper.convertType(map.get("id"));
            final String parameterType = StringHelper.convertType(map.get("paramType"));
            String dataType = StringHelper.convertType(map.get("dataType"));
            final ProcedureParameter procedureParameter = new ProcedureParameter();
            procedureParameter.setParameterName(parameterName);
            procedureParameter.setParameterTypeName(parameterType.toUpperCase());
            procedureParameter.setParameterJavaName(StringHelper.convertToParameterJavaName(parameterName));
            dataType = this.retrieveBaseDataType(dataType).toLowerCase();
            procedureParameter.setSqlTypeName(dataType);
            this.initOtherParameterProperties(procedureParameter, dataType);
            parameters.add(procedureParameter);
        }
        procedure.setParameters(parameters);
    }
    
    public String retrieveBaseDataType(final String dataType) throws SQLException {
        if (dataType.indexOf("%type") > 0) {
            final String tableName = dataType.substring(0, dataType.indexOf(".")).toUpperCase();
            final String columnName = dataType.replace("%type", "").substring(dataType.indexOf(".") + 1).toUpperCase();
            return this.getTableColumnDataType(tableName, columnName);
        }
        return dataType;
    }
    
    public String getTableColumnDataType(final String tableName, final String columnName) throws SQLException {
        final String sql = "select data_type from all_tab_columns  WHERE table_name = '" + tableName + "' and column_name = '" + columnName + "'";
        return this.dbHelper.queryForString(sql);
    }
    
    private void initOtherParameterProperties(final ProcedureParameter procedureParameter, final String dataType) throws SQLException, RecognitionException {
        if (OracleDataTypeForJdbcAndJava.isBaseDataType(dataType)) {
            final String jdbcType = OracleDataTypeForJdbcAndJava.getPreferredJdbcType(dataType);
            final String javaType = OracleDataTypeForJdbcAndJava.getPreferredJavaType(dataType);
            procedureParameter.setJdbcTypeName(jdbcType);
            procedureParameter.setJavaTypeName(javaType);
            procedureParameter.setParameterKind(ProcedureParameterKind.NORMAL.getId());
        }
        else {
            final String arrayTypeContent = this.getTypeContent(dataType.toUpperCase());
            final List arrayTypeList = this.genTypeParameters(arrayTypeContent);
            final Map arrayMap = (Map) arrayTypeList.get(0);
            final String typeName = StringHelper.convertType(arrayMap.get("type"));
            final Map typeMap = (Map) arrayMap.get("collectionType");
            final String customDataType = StringHelper.convertType(typeMap.get("dataType"));
            if (!"collection".equals(typeName)) {
                throw new RuntimeException("\u76ee\u524dpackage\u4ee3\u7801\u751f\u6210\u53ea\u652f\u6301\u57fa\u672c\u7c7b\u578b\u548c\u81ea\u5b9a\u4e49\u5bf9\u8c61\u6570\u7ec4 \uff01");
            }
            final String objectTypeContent = this.getTypeContent(customDataType);
            final List objectTypeList = this.genTypeParameters(objectTypeContent);
            final Map objectMap = (Map) objectTypeList.get(0);
            final String objectType = StringHelper.convertType(objectMap.get("type"));
            if (!"object".equals(objectType)) {
                throw new RuntimeException("\u76ee\u524dpackage\u4ee3\u7801\u5668\u4e0d\u652f\u6301\u591a\u5c42\u6570\u7ec4\u5d4c\u5957\uff01");
            }
            this.initCustomTypeParameter(procedureParameter, objectMap);
        }
    }
    
    public void initCustomTypeParameter(final ProcedureParameter procedureParameter, final Map objectMap) {
        procedureParameter.setJdbcTypeName("ARRAY");
        procedureParameter.setJavaTypeName("java.util.List");
        procedureParameter.setParameterKind(ProcedureParameterKind.ARRAY.getId());
        final LinkedHashSet<CustomObjectParameter> parameters = new LinkedHashSet<CustomObjectParameter>();
        final List parameterList = (List) objectMap.get("fieldList");
        final String customObjectTypeName = StringHelper.convertType(objectMap.get("id"));
        final String className = StringHelper.convertToClassName(customObjectTypeName);
        for (int i = 0; i < parameterList.size(); ++i) {
            final Map paraMap = (Map) parameterList.get(i);
            final String parameterName = StringHelper.convertType(paraMap.get("id"));
            String dataType = StringHelper.convertType(paraMap.get("dataType"));
            dataType = StringHelper.convertToRuleDataType(dataType);
            final CustomObjectParameter customObjectParameter = new CustomObjectParameter();
            customObjectParameter.setObjectName(customObjectTypeName);
            final String jdbcType = OracleDataTypeForJdbcAndJava.getPreferredJdbcType(dataType);
            final String javaType = OracleDataTypeForJdbcAndJava.getPreferredJavaType(dataType);
            customObjectParameter.setJdbcTypeName(jdbcType);
            customObjectParameter.setJavaTypeName(javaType);
            customObjectParameter.setObjectClass(className);
            parameters.add(customObjectParameter);
        }
        procedureParameter.setParameters(parameters);
    }
    
    public String getTypeContent(final String upTypeName) throws SQLException {
        final StringBuffer sb = new StringBuffer();
        sb.append("create or replace ");
        final String sql = "SELECT lower(text) as text FROM user_source WHERE name = '" + upTypeName + "' and type = 'TYPE'";
        final Statement s = this.getConnection().createStatement();
        final ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            sb.append(rs.getString("text"));
        }
        return sb.toString();
    }
    
    public List genTypeParameters(final String typeContent) throws RecognitionException {
        final CharStream cs = (CharStream)new ANTLRStringStream(typeContent);
        final PLSQL2Lexer lexer = new PLSQL2Lexer(cs);
        final CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource((TokenSource)lexer);
        final Parser parser2;
        final PLSQL2Parser parser = (PLSQL2Parser)(parser2 = new PLSQL2Parser((TokenStream)tokens));
        final RuleReturnScope result = (RuleReturnScope)parser.sqlplus_file();
        final CommonTree tree = (CommonTree)result.getTree();
        final List typeList = parser.getTypeList();
        return typeList;
    }
    
    private void retriveCursorColumns(final Connection conn, final Procedure procedure, final int paramterCount) throws SQLException {
        final StringBuffer psql = new StringBuffer();
        psql.append("{call ");
        psql.append(String.valueOf(procedure.getPackageName()) + "." + procedure.getProcedureName());
        psql.append("(");
        for (int i = 0; i < paramterCount; ++i) {
            psql.append("?");
            if (i < paramterCount - 1) {
                psql.append(",");
            }
        }
        final CallableStatement cstmt = conn.prepareCall(psql.toString());
    }
    
    private DatabaseMetaData getMetaData() throws SQLException {
        return this.getConnection().getMetaData();
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
                return TableFactory.DatabaseMetaDataUtils.isOracleDataBase(ProcedureFactory.this.getMetaData());
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        
        public String queryForString(final String sql) {
            Statement s = null;
            ResultSet rs = null;
            try {
                s = ProcedureFactory.this.getConnection().createStatement();
                rs = s.executeQuery(sql);
                if (rs.next()) {
                    return rs.getString(1);
                }
                return null;
            }
            catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
            finally {
                this.close(rs, null, s);
            }
        }
    }
}
