package com.uframe.generator.util.sqlparse;

import java.util.*;

public class BasicSqlFormatter
{
    public static final String WHITESPACE = " \n\r\f\t";
    private static final Set BEGIN_CLAUSES;
    private static final Set END_CLAUSES;
    private static final Set LOGICAL;
    private static final Set QUANTIFIERS;
    private static final Set DML;
    private static final Set MISC;
    static final String indentString = "    ";
    static final String initial = "\n    ";
    
    static {
        BEGIN_CLAUSES = new HashSet();
        END_CLAUSES = new HashSet();
        LOGICAL = new HashSet();
        QUANTIFIERS = new HashSet();
        DML = new HashSet();
        MISC = new HashSet();
        BasicSqlFormatter.BEGIN_CLAUSES.add("left");
        BasicSqlFormatter.BEGIN_CLAUSES.add("right");
        BasicSqlFormatter.BEGIN_CLAUSES.add("inner");
        BasicSqlFormatter.BEGIN_CLAUSES.add("outer");
        BasicSqlFormatter.BEGIN_CLAUSES.add("group");
        BasicSqlFormatter.BEGIN_CLAUSES.add("order");
        BasicSqlFormatter.END_CLAUSES.add("where");
        BasicSqlFormatter.END_CLAUSES.add("set");
        BasicSqlFormatter.END_CLAUSES.add("having");
        BasicSqlFormatter.END_CLAUSES.add("join");
        BasicSqlFormatter.END_CLAUSES.add("from");
        BasicSqlFormatter.END_CLAUSES.add("by");
        BasicSqlFormatter.END_CLAUSES.add("join");
        BasicSqlFormatter.END_CLAUSES.add("into");
        BasicSqlFormatter.END_CLAUSES.add("union");
        BasicSqlFormatter.LOGICAL.add("and");
        BasicSqlFormatter.LOGICAL.add("or");
        BasicSqlFormatter.LOGICAL.add("when");
        BasicSqlFormatter.LOGICAL.add("else");
        BasicSqlFormatter.LOGICAL.add("end");
        BasicSqlFormatter.QUANTIFIERS.add("in");
        BasicSqlFormatter.QUANTIFIERS.add("all");
        BasicSqlFormatter.QUANTIFIERS.add("exists");
        BasicSqlFormatter.QUANTIFIERS.add("some");
        BasicSqlFormatter.QUANTIFIERS.add("any");
        BasicSqlFormatter.DML.add("insert");
        BasicSqlFormatter.DML.add("update");
        BasicSqlFormatter.DML.add("delete");
        BasicSqlFormatter.MISC.add("select");
        BasicSqlFormatter.MISC.add("on");
    }
    
    public String format(final String source) {
        return new FormatProcess(source).perform();
    }
    
    private static class FormatProcess
    {
        boolean beginLine;
        boolean afterBeginBeforeEnd;
        boolean afterByOrSetOrFromOrSelect;
        boolean afterValues;
        boolean afterOn;
        boolean afterBetween;
        boolean afterInsert;
        int inFunction;
        int parensSinceSelect;
        private LinkedList parenCounts;
        private LinkedList afterByOrFromOrSelects;
        int indent;
        StringBuffer result;
        StringTokenizer tokens;
        String lastToken;
        String token;
        String lcToken;
        
        public FormatProcess(final String sql) {
            this.beginLine = true;
            this.afterBeginBeforeEnd = false;
            this.afterByOrSetOrFromOrSelect = false;
            this.afterValues = false;
            this.afterOn = false;
            this.afterBetween = false;
            this.afterInsert = false;
            this.inFunction = 0;
            this.parensSinceSelect = 0;
            this.parenCounts = new LinkedList();
            this.afterByOrFromOrSelects = new LinkedList();
            this.indent = 1;
            this.result = new StringBuffer();
            this.tokens = new StringTokenizer(sql, "()+*/-=<>'`\"[], \n\r\f\t", true);
        }
        
        public String perform() {
            this.result.append("\n    ");
            while (this.tokens.hasMoreTokens()) {
                this.token = this.tokens.nextToken();
                this.lcToken = this.token.toLowerCase();
                if ("'".equals(this.token)) {
                    do {
                        final String t = this.tokens.nextToken();
                        this.token = String.valueOf(this.token) + t;
                        if (!"'".equals(t)) {
                            continue;
                        }
                        break;
                    } while (this.tokens.hasMoreTokens());
                }
                else if ("\"".equals(this.token)) {
                    String t;
                    do {
                        t = this.tokens.nextToken();
                        this.token = String.valueOf(this.token) + t;
                    } while (!"\"".equals(t));
                }
                if (this.afterByOrSetOrFromOrSelect && ",".equals(this.token)) {
                    this.commaAfterByOrFromOrSelect();
                }
                else if (this.afterOn && ",".equals(this.token)) {
                    this.commaAfterOn();
                }
                else if ("(".equals(this.token)) {
                    this.openParen();
                }
                else if (")".equals(this.token)) {
                    this.closeParen();
                }
                else if (BasicSqlFormatter.BEGIN_CLAUSES.contains(this.lcToken)) {
                    this.beginNewClause();
                }
                else if (BasicSqlFormatter.END_CLAUSES.contains(this.lcToken)) {
                    this.endNewClause();
                }
                else if ("select".equals(this.lcToken)) {
                    this.select();
                }
                else if (BasicSqlFormatter.DML.contains(this.lcToken)) {
                    this.updateOrInsertOrDelete();
                }
                else if ("values".equals(this.lcToken)) {
                    this.values();
                }
                else if ("on".equals(this.lcToken)) {
                    this.on();
                }
                else if (this.afterBetween && this.lcToken.equals("and")) {
                    this.misc();
                    this.afterBetween = false;
                }
                else if (BasicSqlFormatter.LOGICAL.contains(this.lcToken)) {
                    this.logical();
                }
                else if (isWhitespace(this.token)) {
                    this.white();
                }
                else {
                    this.misc();
                }
                if (!isWhitespace(this.token)) {
                    this.lastToken = this.lcToken;
                }
            }
            return this.result.toString();
        }
        
        private void commaAfterOn() {
            this.out();
            --this.indent;
            this.newline();
            this.afterOn = false;
            this.afterByOrSetOrFromOrSelect = true;
        }
        
        private void commaAfterByOrFromOrSelect() {
            this.out();
        }
        
        private void logical() {
            if ("end".equals(this.lcToken)) {
                --this.indent;
            }
            this.newline();
            this.out();
            this.beginLine = false;
        }
        
        private void on() {
            ++this.indent;
            this.afterOn = true;
            this.newline();
            this.out();
            this.beginLine = false;
        }
        
        private void misc() {
            this.out();
            if ("between".equals(this.lcToken)) {
                this.afterBetween = true;
            }
            if (this.afterInsert) {
                this.newline();
                this.afterInsert = false;
            }
            else {
                this.beginLine = false;
                if ("case".equals(this.lcToken)) {
                    ++this.indent;
                }
            }
        }
        
        private void white() {
            if (!this.beginLine) {
                this.result.append(" ");
            }
        }
        
        private void updateOrInsertOrDelete() {
            this.out();
            ++this.indent;
            this.beginLine = false;
            if ("update".equals(this.lcToken)) {
                this.newline();
            }
            if ("insert".equals(this.lcToken)) {
                this.afterInsert = true;
            }
        }
        
        private void select() {
            this.out();
            ++this.indent;
            this.newline();
            this.parenCounts.addLast(new Integer(this.parensSinceSelect));
            this.afterByOrFromOrSelects.addLast(this.afterByOrSetOrFromOrSelect);
            this.parensSinceSelect = 0;
            this.afterByOrSetOrFromOrSelect = true;
        }
        
        private void out() {
            this.result.append(this.token);
        }
        
        private void endNewClause() {
            if (!this.afterBeginBeforeEnd) {
                --this.indent;
                if (this.afterOn) {
                    --this.indent;
                    this.afterOn = false;
                }
                this.newline();
            }
            this.out();
            if (!"union".equals(this.lcToken)) {
                ++this.indent;
            }
            this.newline();
            this.afterBeginBeforeEnd = false;
            this.afterByOrSetOrFromOrSelect = ("by".equals(this.lcToken) || "set".equals(this.lcToken) || "from".equals(this.lcToken));
        }
        
        private void beginNewClause() {
            if (!this.afterBeginBeforeEnd) {
                if (this.afterOn) {
                    --this.indent;
                    this.afterOn = false;
                }
                --this.indent;
                this.newline();
            }
            this.out();
            this.beginLine = false;
            this.afterBeginBeforeEnd = true;
        }
        
        private void values() {
            --this.indent;
            this.newline();
            this.out();
            ++this.indent;
            this.newline();
            this.afterValues = true;
        }
        
        private void closeParen() {
            --this.parensSinceSelect;
            if (this.parensSinceSelect < 0) {
                --this.indent;
                this.parensSinceSelect = (Integer) this.parenCounts.removeLast();
                this.afterByOrSetOrFromOrSelect = (Boolean) this.afterByOrFromOrSelects.removeLast();
            }
            if (this.inFunction > 0) {
                --this.inFunction;
                this.out();
            }
            else {
                if (!this.afterByOrSetOrFromOrSelect) {
                    --this.indent;
                    this.newline();
                }
                this.out();
            }
            this.beginLine = false;
        }
        
        private void openParen() {
            if (isFunctionName(this.lastToken) || this.inFunction > 0) {
                ++this.inFunction;
            }
            this.beginLine = false;
            if (this.inFunction > 0) {
                this.out();
            }
            else {
                this.out();
                if (!this.afterByOrSetOrFromOrSelect) {
                    ++this.indent;
                    this.newline();
                    this.beginLine = true;
                }
            }
            ++this.parensSinceSelect;
        }
        
        private static boolean isFunctionName(final String tok) {
            final char begin = tok.charAt(0);
            final boolean isIdentifier = Character.isJavaIdentifierStart(begin) || '\"' == begin;
            return isIdentifier && !BasicSqlFormatter.LOGICAL.contains(tok) && !BasicSqlFormatter.END_CLAUSES.contains(tok) && !BasicSqlFormatter.QUANTIFIERS.contains(tok) && !BasicSqlFormatter.DML.contains(tok) && !BasicSqlFormatter.MISC.contains(tok);
        }
        
        private static boolean isWhitespace(final String token) {
            return " \n\r\f\t".indexOf(token) >= 0;
        }
        
        private void newline() {
            this.result.append("\n");
            for (int i = 0; i < this.indent; ++i) {
                this.result.append("    ");
            }
            this.beginLine = true;
        }
    }
}
