package com.uframe.generator.provider.db.procedure;

import org.antlr.runtime.tree.*;
import java.io.*;
import org.antlr.runtime.*;
import java.util.*;

public class PLSQL2Test
{
    public static void main(final String[] args) throws IOException, RecognitionException {
        System.out.println("good");
        final String file = "./src/new_type.plsql";
        final CharStream cs = (CharStream)new ANTLRFileStream(file);
        final PLSQL2Lexer lexer = new PLSQL2Lexer(cs);
        final CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource((TokenSource)lexer);
        final Parser parser2;
        final PLSQL2Parser parser = (PLSQL2Parser)(parser2 = new PLSQL2Parser((TokenStream)tokens));
        final RuleReturnScope result = (RuleReturnScope)parser.sqlplus_file();
        final CommonTree tree = (CommonTree)result.getTree();
        System.out.println(tree.toStringTree());
        final List procedureList = parser.getProcedureList();
        System.out.println(procedureList);
        final List functionList = parser.getFunctionList();
        System.out.println(functionList);
        final List typeList = parser.getTypeList();
        System.out.println(typeList);
    }
    
    public static void traverseTree(final CommonTree tree) {
        if (tree == null) {
            return;
        }
        final Token token = tree.getToken();
        System.out.print(tree.getText());
        System.out.print(tree.getType());
        System.out.println();
        final List children = tree.getChildren();
        if (children == null) {
            return;
        }
        for (final Object object : children) {
            final CommonTree subTree = (CommonTree)object;
            traverseTree(subTree);
        }
    }
}
