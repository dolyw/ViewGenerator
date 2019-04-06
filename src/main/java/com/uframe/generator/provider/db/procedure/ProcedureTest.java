package com.uframe.generator.provider.db.procedure;

import java.util.*;
import org.antlr.runtime.tree.*;
import java.sql.*;
import org.antlr.runtime.*;
import com.uframe.generator.provider.db.*;

public class ProcedureTest
{
    public static List parserSelfList(final Connection conn) throws SQLException, RecognitionException {
        final String sql = " select lower(text) as text from user_source where type = 'TYPE' and name = 'REC_CLASS' ";
        final Statement s = conn.createStatement();
        final ResultSet rs = s.executeQuery(sql);
        final StringBuffer sb = new StringBuffer();
        sb.append("create or replace ");
        while (rs.next()) {
            sb.append(rs.getString("text"));
        }
        final CharStream cs = (CharStream)new ANTLRStringStream(sb.toString());
        final PLSQL2Lexer lexer = new PLSQL2Lexer(cs);
        final CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource((TokenSource)lexer);
        final Parser parser2;
        final PLSQL2Parser parser = (PLSQL2Parser)(parser2 = new PLSQL2Parser((TokenStream)tokens));
        final RuleReturnScope result = (RuleReturnScope)parser.sqlplus_file();
        final CommonTree tree = (CommonTree)result.getTree();
        final List typeList = parser.getTypeList();
        System.out.println(typeList);
        return typeList;
    }
    
    public static void main(final String[] args) throws Exception {
        final Connection conn = DataSourceProvider.getConnection();
        final String sql = "SELECT lower(text) as text FROM user_source WHERE name = 'TEST_PROCEDURE_STUDENT' and type = 'PACKAGE' ";
        final Statement s = conn.createStatement();
        final ResultSet rs = s.executeQuery(sql);
        final StringBuffer sb = new StringBuffer();
        sb.append("create or replace ");
        while (rs.next()) {
            sb.append(rs.getString("text"));
        }
        final CharStream cs = (CharStream)new ANTLRStringStream(sb.toString());
        System.out.println("\u7b2c\u4e00\u6b21\u89e3\u6790");
        final PLSQL2Lexer lexer = new PLSQL2Lexer(cs);
        final CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource((TokenSource)lexer);
        final Parser parser2;
        final PLSQL2Parser parser = (PLSQL2Parser)(parser2 = new PLSQL2Parser((TokenStream)tokens));
        final RuleReturnScope result = (RuleReturnScope)parser.sqlplus_file();
        final CommonTree tree = (CommonTree)result.getTree();
        final List procedureList = parser.getProcedureList();
        System.out.println(procedureList);
        System.out.println("\u7b2c\u4e8c\u6b21\u89e3\u6790");
        parserSelfList(conn);
    }
}
