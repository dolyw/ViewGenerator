package com.uframe.generator.provider.db.procedure;

import org.antlr.runtime.*;

public class PLSQL2Lexer extends Lexer
{
    public static final int FUNCTION = 8;
    public static final int PACKAGE = 116;
    public static final int EXTERNAL = 118;
    public static final int EXPONENT = 100;
    public static final int WHILE = 88;
    public static final int DETERMINISTIC = 38;
    public static final int VARYING = 28;
    public static final int CASE = 51;
    public static final int DOUBLEDOT = 67;
    public static final int NOT = 20;
    public static final int SUBTYPE = 25;
    public static final int EOF = -1;
    public static final int SQL = 101;
    public static final int RPAREN = 12;
    public static final int CREATE = 115;
    public static final int INSERT = 80;
    public static final int USING = 63;
    public static final int RETURNING = 64;
    public static final int LOOP = 50;
    public static final int BEGIN = 42;
    public static final int SAVEPOINT = 83;
    public static final int RETURN = 9;
    public static final int RAISE = 75;
    public static final int BODY = 117;
    public static final int GEQ = 94;
    public static final int EQ = 89;
    public static final int GOTO = 70;
    public static final int SELECT = 84;
    public static final int INTO = 60;
    public static final int ISOPEN = 103;
    public static final int ARRAY = 29;
    public static final int DIVIDE = 4;
    public static final int EXCEPTION = 23;
    public static final int EXIT = 57;
    public static final int RBRACK = 126;
    public static final int RECORD = 26;
    public static final int N = 129;
    public static final int TRANSACTION = 86;
    public static final int NULL = 21;
    public static final int ELSE = 52;
    public static final int AT_SIGN = 125;
    public static final int DEFINER = 121;
    public static final int DELETE = 49;
    public static final int DOUBLEVERTBAR = 98;
    public static final int ROLLBACK = 82;
    public static final int AUTHID = 119;
    public static final int NOCOPY = 17;
    public static final int WS = 131;
    public static final int LANGUAGE = 122;
    public static final int FETCH = 58;
    public static final int OUT = 16;
    public static final int REAL_NUMBER = 106;
    public static final int PIPELINED = 39;
    public static final int SL_COMMENT = 132;
    public static final int OR = 45;
    public static final int CONSTANT = 22;
    public static final int ELSIF = 72;
    public static final int END = 43;
    public static final int FALSE = 108;
    public static final int COLLECT = 62;
    public static final int CURSOR = 18;
    public static final int OTHERS = 46;
    public static final int LBRACK = 127;
    public static final int POINT = 124;
    public static final int CURRENT_USER = 120;
    public static final int LIMIT = 59;
    public static final int EXECUTE = 55;
    public static final int INSERTING = 111;
    public static final int GTH = 93;
    public static final int NOTFOUND = 104;
    public static final int PRAGMA = 74;
    public static final int RESULT_CACHE = 41;
    public static final int TABLE = 31;
    public static final int LLABEL = 77;
    public static final int UPDATE = 87;
    public static final int FOR = 65;
    public static final int ID = 7;
    public static final int AND = 69;
    public static final int ASTERISK = 99;
    public static final int LPAREN = 10;
    public static final int LOCK = 81;
    public static final int UPDATING = 112;
    public static final int IF = 71;
    public static final int RLABEL = 78;
    public static final int ML_COMMENT = 133;
    public static final int INDEX = 32;
    public static final int AS = 24;
    public static final int ROWTYPE = 37;
    public static final int THEN = 47;
    public static final int IN = 15;
    public static final int CONTINUE = 54;
    public static final int OBJECT = 27;
    public static final int COMMA = 11;
    public static final int IS = 19;
    public static final int PLUS = 97;
    public static final int QUOTED_STRING = 109;
    public static final int EXISTS = 110;
    public static final int DOT = 35;
    public static final int LIKE = 95;
    public static final int INTEGER = 105;
    public static final int VARRAY = 30;
    public static final int BY = 33;
    public static final int PERCENT = 36;
    public static final int PARALLEL_ENABLE = 40;
    public static final int DOUBLEQUOTED_STRING = 123;
    public static final int DEFAULT = 14;
    public static final int FORALL = 66;
    public static final int SET = 85;
    public static final int MINUS = 96;
    public static final int SEMI = 5;
    public static final int TRUE = 107;
    public static final int PROCEDURE = 6;
    public static final int NOT_EQ = 90;
    public static final int REF = 34;
    public static final int VERTBAR = 128;
    public static final int LTH = 91;
    public static final int OPEN = 73;
    public static final int COLON = 48;
    public static final int COMMIT = 79;
    public static final int BULK_ROWCOUNT = 102;
    public static final int CLOSE = 53;
    public static final int WHEN = 44;
    public static final int ASSIGN = 13;
    public static final int IMMEDIATE = 56;
    public static final int NUMBER_VALUE = 130;
    public static final int DECLARE = 76;
    public static final int ARROW = 114;
    public static final int DELETING = 113;
    public static final int BULK = 61;
    public static final int BETWEEN = 68;
    public static final int LEQ = 92;
    protected DFA9 dfa9;
    protected DFA15 dfa15;
    static final String DFA9_eotS = "\u0001\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff";
    static final String DFA9_eofS = "\u0006\uffff";
    static final String DFA9_minS = "\u0002.\u0001\uffff\u0001.\u0002\uffff";
    static final String DFA9_maxS = "\u00029\u0001\uffff\u00019\u0002\uffff";
    static final String DFA9_acceptS = "\u0002\uffff\u0001\u0002\u0001\uffff\u0001\u0003\u0001\u0001";
    static final String DFA9_specialS = "\u0001\uffff\u0001\u0000\u0001\uffff\u0001\u0001\u0002\uffff}>";
    static final String[] DFA9_transitionS;
    static final short[] DFA9_eot;
    static final short[] DFA9_eof;
    static final char[] DFA9_min;
    static final char[] DFA9_max;
    static final short[] DFA9_accept;
    static final short[] DFA9_special;
    static final short[][] DFA9_transition;
    static final String DFA15_eotS = "\u0001\uffff\u0012\u0014\u0003\uffff\u0001`\u0001a\u0001\uffff\u0001e\u0006\uffff\u0001g\u0001i\u0001k\u0001\uffff\u0001n\u0001q\u0001s\u0001\uffff\u0001u\u0001\uffff\u0002\u0014\u0001z\u0004\u0014\u0001\u0080\u000e\u0014\u0001\u0097\u0001\u009b\u0001\u009d\u0007\u0014\u0001��\u0014\u0014\u0015\uffff\u0001u\u0003\uffff\u0001\u00c6\u0001\u0014\u0001\uffff\u0005\u0014\u0001\uffff\u0010\u0014\u0001\u00e2\u0002\u0014\u0001\u00e6\u0002\u0014\u0001\uffff\u0003\u0014\u0001\uffff\u0001\u0014\u0001\uffff\u0006\u0014\u0001\u00f4\u0003\u0014\u0001\uffff\u0002\u0014\u0001\u00fa\t\u0014\u0001\u0104\u0004\u0014\u0001\u0109\u0001\u010a\n\u0014\u0001\uffff\u0004\u0014\u0001\u011a\u0001\u011c\u0001\u011d\r\u0014\u0001\u012b\u0003\u0014\u0001\u012f\u0002\u0014\u0001\uffff\u0003\u0014\u0001\uffff\u0001\u0014\u0001\u0136\u0002\u0014\u0001\u0139\u0003\u0014\u0001\u013d\u0001\u0014\u0001\u013f\u0001\u0140\u0001\u0014\u0001\uffff\u0001\u0014\u0001\u0143\u0001\u0144\u0002\u0014\u0001\uffff\t\u0014\u0001\uffff\u0004\u0014\u0002\uffff\u0003\u0014\u0001\u0157\u0001\u0158\u0003\u0014\u0001\u015c\u0002\u0014\u0001\u015f\u0002\u0014\u0001\u0162\u0001\uffff\u0001\u0014\u0002\uffff\u0007\u0014\u0001\u016b\u0005\u0014\u0001\uffff\u0001\u0172\u0002\u0014\u0001\uffff\u0002\u0014\u0001\u0177\u0001\u0178\u0002\u0014\u0001\uffff\u0001\u017b\u0001\u0014\u0001\uffff\u0003\u0014\u0001\uffff\u0001\u0180\u0002\uffff\u0002\u0014\u0002\uffff\u0007\u0014\u0001\u018a\b\u0014\u0001\u0193\u0001\u0014\u0002\uffff\u0001\u0014\u0001\u0197\u0001\u0198\u0001\uffff\u0002\u0014\u0001\uffff\u0001\u019b\u0001\u0014\u0001\uffff\u0001\u0014\u0001\u019e\u0001\u0014\u0001\u01a0\u0003\u0014\u0001\u01a4\u0001\uffff\u0002\u0014\u0001\u01a7\u0003\u0014\u0001\uffff\u0001\u0014\u0001\u01ac\u0002\u0014\u0002\uffff\u0001\u01af\u0001\u0014\u0001\uffff\u0001\u01b2\u0001\u01b3\u0002\u0014\u0001\uffff\u0001\u0014\u0001\u01b7\u0001\u01b8\u0001\u01b9\u0003\u0014\u0001\u01bd\u0001\u0014\u0001\uffff\u0002\u0014\u0001\u01c1\u0001\u0014\u0001\u01c4\u0001\u0014\u0001\u01c6\u0001\u0014\u0001\uffff\u0001\u0014\u0001\u01c9\u0001\u0014\u0002\uffff\u0001\u01cb\u0001\u0014\u0001\uffff\u0001\u01cd\u0001\u0014\u0001\uffff\u0001\u01cf\u0001\uffff\u0003\u0014\u0001\uffff\u0001\u01d3\u0001\u01d4\u0001\uffff\u0001\u0014\u0001\u01d6\u0002\u0014\u0001\uffff\u0001\u0014\u0001\u01da\u0001\uffff\u0002\u0014\u0002\uffff\u0003\u0014\u0003\uffff\u0001\u01e0\u0002\u0014\u0001\uffff\u0002\u0014\u0001\u01e5\u0001\uffff\u0002\u0014\u0001\uffff\u0001\u0014\u0001\uffff\u0001\u01e9\u0001\u0014\u0001\uffff\u0001\u0014\u0001\uffff\u0001\u01ec\u0001\uffff\u0001\u0014\u0001\uffff\u0001\u01ee\u0001\u01ef\u0001\u0014\u0002\uffff\u0001\u01f1\u0001\uffff\u0001\u0014\u0001\u01f3\u0001\u0014\u0001\uffff\u0001\u01f5\u0002\u0014\u0001\u01f8\u0001\u01f9\u0001\uffff\u0003\u0014\u0001\u01fd\u0001\uffff\u0003\u0014\u0001\uffff\u0001\u0014\u0001\u0202\u0001\uffff\u0001\u0014\u0002\uffff\u0001\u0014\u0001\uffff\u0001\u0014\u0001\uffff\u0001\u0206\u0001\uffff\u0001\u0207\u0001\u0208\u0002\uffff\u0001\u0014\u0001\u020a\u0001\u020b\u0001\uffff\u0001\u0014\u0001\u020d\u0001\u020e\u0001\u0014\u0001\uffff\u0003\u0014\u0003\uffff\u0001\u0014\u0002\uffff\u0001\u0014\u0002\uffff\u0006\u0014\u0001\u021b\u0001\u0014\u0001\u021d\u0002\u0014\u0001\u0220\u0001\uffff\u0001\u0221\u0001\uffff\u0001\u0222\u0001\u0014\u0003\uffff\u0001\u0014\u0001\u0225\u0001\uffff";
    static final String DFA15_eofS = "\u0226\uffff";
    static final String DFA15_minS = "\u0001\t\u0001n\u0001e\u0001a\u0001e\u0001l\u0001a\u0001o\u0001f\u0001a\u0001'\u0001b\u0004a\u0001p\u0001h\u0001a\u0003\uffff\u0001=\u0001.\u0001\uffff\u0001*\u0006\uffff\u0001-\u0001*\u0001>\u0001\uffff\u0001<\u0001=\u0001|\u0001\uffff\u0001.\u0001\uffff\u0001d\u0001r\u0001#\u0001t\u0001g\u0001d\u0001l\u0001#\u0001s\u0001e\u0001l\u0001r\u0001o\u0001c\u0001s\u0001c\u0001d\u0001l\u0001t\u0001r\u0001n\u0001t\u0003#\u0001m\u0001n\u0001k\u0002c\u0001l\u0001e\u0001#\u0001j\u0001h\u0001t\u0001c\u0001p\u0001a\u0001i\u0001l\u0001c\u0001v\u0002l\u0002b\u0001a\u0001e\u0001d\u0001i\u0001e\u0001r\u0015\uffff\u0001.\u0003\uffff\u0001#\u0001a\u0001\uffff\u0001h\u0001w\u0001i\u0001y\u0001k\u0001\uffff\u0001e\u0001a\u0001l\u0001m\u0001s\u0001r\u0001s\u0001a\u0001e\u0001l\u0003e\u0001s\u0001e\u0001c\u0001#\u0001s\u0001c\u0001#\u0001c\u0001o\u0001\uffff\u0002e\u0001o\u0001\uffff\u0001p\u0001\uffff\u0001e\u0001g\u0001e\u0001i\u0001k\u0001p\u0001#\u0001o\u0001l\u0001n\u0001\uffff\u0002e\u0001#\u0001k\u0001a\u0001e\u0001g\u0001c\u0001s\u0001l\u0001t\u0001o\u0001#\u0002u\u0002e\u0002#\u0001t\u0001l\u0001n\u0001e\u0001n\u0001a\u0001n\u0001l\u0001n\u0001r\u0001\uffff\u0001y\u0001i\u0001e\u0001n\u0003#\u0001t\u0001e\u0001i\u0001t\u0001i\u0001e\u0001o\u0001e\u0001u\u0001n\u0001t\u0001a\u0001r\u0001#\u0001f\u0001r\u0001t\u0001#\u0001p\u0001u\u0001\uffff\u0001e\u0001h\u0001l\u0001\uffff\u0001t\u0001#\u0001x\u0001r\u0001#\u0001e\u0001d\u0001u\u0001#\u0001t\u0002#\u0001o\u0001\uffff\u0001p\u0002#\u0001c\u0001r\u0001\uffff\u0001a\u0002l\u0001m\u0002e\u0001b\u0001y\u0001r\u0001\uffff\u0001l\u0001r\u0001p\u0001c\u0002\uffff\u0001y\u0001e\u0001s\u0002#\u0001t\u0001g\u0001e\u0001#\u0001a\u0001i\u0001#\u0001d\u0001e\u0001#\u0001\uffff\u0001r\u0002\uffff\u0001e\u0001c\u0001t\u0001a\u0002n\u0001r\u0001#\u0001l\u0002e\u0001r\u0001m\u0001\uffff\u0001#\u0001n\u0001s\u0001\uffff\u0002t\u0002#\u0001l\u0001i\u0001\uffff\u0001#\u0001t\u0001\uffff\u0001n\u0001i\u0001a\u0001\uffff\u0001#\u0002\uffff\u0001u\u0001y\u0002\uffff\u0001t\u0001s\u0001g\u0001l\u0001i\u0001a\u0001d\u0001#\u0001a\u0001p\u0001d\u0001t\u0001n\u0001o\u0001t\u0001p\u0001#\u0001a\u0002\uffff\u0001e\u0002#\u0001\uffff\u0001y\u0001n\u0001\uffff\u0001#\u0001n\u0001\uffff\u0001o\u0001#\u0001t\u0001#\u0001n\u0001u\u0001t\u0001#\u0001\uffff\u0001t\u0001r\u0001#\u0001n\u0001e\u0001i\u0001\uffff\u0001a\u0001#\u0001i\u0001e\u0002\uffff\u0001#\u0001o\u0001\uffff\u0002#\u0001a\u0001g\u0001\uffff\u0001n\u0003#\u0002e\u0001n\u0001#\u0001u\u0001\uffff\u0001c\u0001e\u0001#\u0001_\u0001#\u0001i\u0001#\u0001e\u0001\uffff\u0001c\u0001#\u0001n\u0002\uffff\u0001#\u0001g\u0001\uffff\u0001#\u0001w\u0001\uffff\u0001#\u0001\uffff\u0001t\u0001e\u0001_\u0001\uffff\u0002#\u0001\uffff\u0001g\u0001#\u0001n\u0001l\u0001\uffff\u0001o\u0001#\u0001\uffff\u0002n\u0002\uffff\u0001t\u0001e\u0001d\u0003\uffff\u0001#\u0001l\u0001e\u0001\uffff\u0001r\u0001k\u0001#\u0001\uffff\u0001c\u0001n\u0001\uffff\u0001n\u0001\uffff\u0001#\u0001t\u0001\uffff\u0001g\u0001\uffff\u0001#\u0001\uffff\u0001c\u0001\uffff\u0002#\u0001u\u0002\uffff\u0001#\u0001\uffff\u0001i\u0001#\u0001n\u0001\uffff\u0001#\u0001g\u0001e\u0002#\u0001\uffff\u0001_\u0001d\u0001e\u0001#\u0001\uffff\u0001a\u0001g\u0001t\u0001\uffff\u0001i\u0001#\u0001\uffff\u0001o\u0002\uffff\u0001s\u0001\uffff\u0001s\u0001\uffff\u0001#\u0001\uffff\u0002#\u0002\uffff\u0001e\u0002#\u0001\uffff\u0001c\u0002#\u0001o\u0001\uffff\u0001u\u0001e\u0001t\u0003\uffff\u0001n\u0002\uffff\u0001h\u0002\uffff\u0002n\u0001r\u0001i\u0001a\u0001e\u0001#\u0001t\u0001#\u0001c\u0001b\u0001#\u0001\uffff\u0001#\u0001\uffff\u0001#\u0001l\u0003\uffff\u0001e\u0001#\u0001\uffff";
    static final String DFA15_maxS = "\u0001~\u0001u\u0001y\u0001u\u0001e\u0001x\u0001u\u0001o\u0001s\u0001o\u0002u\u0001r\u0001o\u0001u\u0001r\u0001s\u0001h\u0001a\u0003\uffff\u0001=\u00019\u0001\uffff\u0001*\u0006\uffff\u0001-\u0001*\u0001>\u0001\uffff\u0002>\u0001|\u0001\uffff\u0001e\u0001\uffff\u0001d\u0001r\u0001z\u0002t\u0001d\u0001l\u0001z\u0001s\u0001e\u0001n\u0001r\u0001o\u0001t\u0001s\u0001t\u0001d\u0001l\u0001t\u0001r\u0001n\u0001t\u0003z\u0001m\u0001n\u0001m\u0001o\u0001t\u0001l\u0001e\u0001z\u0001j\u0001h\u0001t\u0001r\u0001p\u0001o\u0001i\u0001w\u0001t\u0001v\u0001t\u0001l\u0002b\u0001u\u0001e\u0001d\u0002i\u0001r\u0015\uffff\u0001e\u0003\uffff\u0001z\u0001a\u0001\uffff\u0001h\u0001w\u0001i\u0001y\u0001k\u0001\uffff\u0001e\u0001a\u0001l\u0001m\u0001t\u0002s\u0001i\u0001e\u0001l\u0001e\u0001i\u0001e\u0001t\u0001e\u0001c\u0001z\u0001s\u0001c\u0001z\u0001c\u0001o\u0001\uffff\u0002e\u0001o\u0001\uffff\u0001p\u0001\uffff\u0001e\u0001g\u0001e\u0001i\u0001k\u0001p\u0001z\u0001o\u0001l\u0001n\u0001\uffff\u0002e\u0001z\u0001k\u0001a\u0001e\u0001g\u0001c\u0001s\u0001l\u0001t\u0001o\u0001z\u0002u\u0002e\u0002z\u0001t\u0001l\u0001n\u0001e\u0001n\u0001a\u0001n\u0001l\u0001n\u0001y\u0001\uffff\u0001y\u0001i\u0001e\u0001n\u0003z\u0001t\u0001e\u0001i\u0001t\u0001i\u0001e\u0001o\u0001e\u0001u\u0001n\u0001t\u0001a\u0001r\u0001z\u0001f\u0001r\u0001t\u0001z\u0001p\u0001u\u0001\uffff\u0001e\u0001h\u0001l\u0001\uffff\u0001t\u0001z\u0001x\u0001r\u0001z\u0001e\u0001d\u0001u\u0001z\u0001t\u0002z\u0001o\u0001\uffff\u0001p\u0002z\u0001c\u0001r\u0001\uffff\u0001a\u0002l\u0001m\u0002e\u0001b\u0001y\u0001r\u0001\uffff\u0001l\u0001r\u0001p\u0001c\u0002\uffff\u0001y\u0001e\u0001s\u0002z\u0001t\u0001g\u0001e\u0001z\u0001a\u0001i\u0001z\u0001d\u0001e\u0001z\u0001\uffff\u0001r\u0002\uffff\u0001e\u0001c\u0001t\u0001a\u0002n\u0001r\u0001z\u0001l\u0001e\u0001i\u0001r\u0001m\u0001\uffff\u0001z\u0001n\u0001s\u0001\uffff\u0002t\u0002z\u0001l\u0001i\u0001\uffff\u0001z\u0001t\u0001\uffff\u0001n\u0001i\u0001a\u0001\uffff\u0001z\u0002\uffff\u0001u\u0001y\u0002\uffff\u0001t\u0001s\u0001g\u0001l\u0001i\u0001a\u0001d\u0001z\u0001a\u0001p\u0001d\u0001t\u0001n\u0001o\u0001t\u0001p\u0001z\u0001a\u0002\uffff\u0001i\u0002z\u0001\uffff\u0001y\u0001n\u0001\uffff\u0001z\u0001n\u0001\uffff\u0001o\u0001z\u0001t\u0001z\u0001n\u0001u\u0001t\u0001z\u0001\uffff\u0001t\u0001r\u0001z\u0001n\u0001e\u0001i\u0001\uffff\u0001a\u0001z\u0001i\u0001e\u0002\uffff\u0001z\u0001o\u0001\uffff\u0002z\u0001a\u0001g\u0001\uffff\u0001n\u0003z\u0002e\u0001n\u0001z\u0001u\u0001\uffff\u0001c\u0001e\u0001z\u0001_\u0001z\u0001i\u0001z\u0001e\u0001\uffff\u0001c\u0001z\u0001n\u0002\uffff\u0001z\u0001g\u0001\uffff\u0001z\u0001w\u0001\uffff\u0001z\u0001\uffff\u0001t\u0001e\u0001_\u0001\uffff\u0002z\u0001\uffff\u0001g\u0001z\u0001n\u0001l\u0001\uffff\u0001o\u0001z\u0001\uffff\u0002n\u0002\uffff\u0001t\u0001e\u0001d\u0003\uffff\u0001z\u0001l\u0001e\u0001\uffff\u0001r\u0001k\u0001z\u0001\uffff\u0001c\u0001n\u0001\uffff\u0001n\u0001\uffff\u0001z\u0001t\u0001\uffff\u0001g\u0001\uffff\u0001z\u0001\uffff\u0001c\u0001\uffff\u0002z\u0001u\u0002\uffff\u0001z\u0001\uffff\u0001i\u0001z\u0001n\u0001\uffff\u0001z\u0001g\u0001e\u0002z\u0001\uffff\u0001_\u0001d\u0001e\u0001z\u0001\uffff\u0001a\u0001g\u0001t\u0001\uffff\u0001i\u0001z\u0001\uffff\u0001o\u0002\uffff\u0001s\u0001\uffff\u0001s\u0001\uffff\u0001z\u0001\uffff\u0002z\u0002\uffff\u0001e\u0002z\u0001\uffff\u0001c\u0002z\u0001o\u0001\uffff\u0001u\u0001e\u0001t\u0003\uffff\u0001n\u0002\uffff\u0001h\u0002\uffff\u0002n\u0001r\u0001i\u0001a\u0001e\u0001z\u0001t\u0001z\u0001c\u0001b\u0001z\u0001\uffff\u0001z\u0001\uffff\u0001z\u0001l\u0003\uffff\u0001e\u0001z\u0001\uffff";
    static final String DFA15_acceptS = "\u0013\uffff\u0001\\\u0001]\u0001^\u0002\uffff\u0001b\u0001\uffff\u0001e\u0001f\u0001g\u0001h\u0001i\u0001j\u0003\uffff\u0001n\u0003\uffff\u0001u\u0001\uffff\u0001|5\uffff\u0001q\u0001_\u0001a\u0001`\u0001{\u0001c\u0001d\u0001}\u0001k\u0001~\u0001l\u0001r\u0001m\u0001o\u0001w\u0001v\u0001p\u0001y\u0001x\u0001t\u0001s\u0001\uffff\u0001z\u0002{\u0002\uffff\u0001\u0003\u0005\uffff\u0001\t\u0016\uffff\u0001\u001a\u0003\uffff\u0001\u001b\u0001\uffff\u0001\u001f\n\uffff\u0001(\u001d\uffff\u0001\u0001\u001b\uffff\u0001B\u0003\uffff\u0001\u0017\r\uffff\u0001$\u0005\uffff\u0001L\t\uffff\u0001R\u0004\uffff\u0001.\u0001/\u000f\uffff\u0001\u0006\u0001\uffff\u0001\u0007\u0001\n\r\uffff\u0001\u0012\u0003\uffff\u0001E\u0006\uffff\u0001\u0019\u0002\uffff\u0001\u001e\u0003\uffff\u0001!\u0001\uffff\u0001#\u0001H\u0002\uffff\u0001&\u0001'\u0012\uffff\u00012\u00013\u0003\uffff\u0001[\u0002\uffff\u0001\u0002\u0002\uffff\u0001;\b\uffff\u0001<\u0006\uffff\u0001\u0013\u0004\uffff\u0001\u0015\u0001\u0016\u0002\uffff\u0001\u001c\u0004\uffff\u0001\"\t\uffff\u0001*\b\uffff\u00010\u0003\uffff\u0001X\u00015\u0002\uffff\u0001\u0004\u0002\uffff\u0001\u000b\u0001\uffff\u0001\r\u0003\uffff\u0001?\u0002\uffff\u0001\u0011\u0004\uffff\u0001:\u0002\uffff\u0001\u0018\u0002\uffff\u0001\u001d\u00019\u0003\uffff\u0001I\u0001J\u0001K\u0003\uffff\u0001O\u0003\uffff\u0001Q\u0002\uffff\u0001T\u0001\uffff\u0001-\u0002\uffff\u00014\u0001\uffff\u0001Y\u0001\uffff\u0001\u0005\u0001\uffff\u0001\f\u0003\uffff\u0001\u000f\u0001\u0010\u0001\uffff\u0001@\u0003\uffff\u0001D\u0005\uffff\u0001)\u0004\uffff\u0001V\u0003\uffff\u0001W\u0002\uffff\u0001Z\u0001\uffff\u0001=\u0001>\u0001\uffff\u00018\u0001\uffff\u0001\u0014\u0001\uffff\u0001F\u0002\uffff\u0001 \u0001%\u0003\uffff\u0001+\u0004\uffff\u00017\u0003\uffff\u0001C\u00016\u0001G\u0001\uffff\u0001N\u0001P\u0001\uffff\u0001U\u0001,\f\uffff\u00011\u0001\uffff\u0001\u000e\u0002\uffff\u0001S\u0001\b\u0001A\u0002\uffff\u0001M";
    static final String DFA15_specialS = "(\uffff\u0001\u0001K\uffff\u0001\u0000\u01b1\uffff}>";
    static final String[] DFA15_transitionS;
    static final short[] DFA15_eot;
    static final short[] DFA15_eof;
    static final char[] DFA15_min;
    static final char[] DFA15_max;
    static final short[] DFA15_accept;
    static final short[] DFA15_special;
    static final short[][] DFA15_transition;
    
    static {
        DFA9_transitionS = new String[] { "\u0001\u0002\u0001\uffff\n\u0001", "\u0001\u0005\u0001\uffff\n\u0003", "", "\u0001\u0005\u0001\uffff\n\u0003", "", "" };
        DFA9_eot = DFA.unpackEncodedString("\u0001\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff");
        DFA9_eof = DFA.unpackEncodedString("\u0006\uffff");
        DFA9_min = DFA.unpackEncodedStringToUnsignedChars("\u0002.\u0001\uffff\u0001.\u0002\uffff");
        DFA9_max = DFA.unpackEncodedStringToUnsignedChars("\u00029\u0001\uffff\u00019\u0002\uffff");
        DFA9_accept = DFA.unpackEncodedString("\u0002\uffff\u0001\u0002\u0001\uffff\u0001\u0003\u0001\u0001");
        DFA9_special = DFA.unpackEncodedString("\u0001\uffff\u0001\u0000\u0001\uffff\u0001\u0001\u0002\uffff}>");
        int numStates = PLSQL2Lexer.DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i = 0; i < numStates; ++i) {
            PLSQL2Lexer.DFA9_transition[i] = DFA.unpackEncodedString(PLSQL2Lexer.DFA9_transitionS[i]);
        }
        DFA15_transitionS = new String[] { "\u0002)\u0002\uffff\u0001)\u0012\uffff\u0001)\u0001'\u0001\u0014\u0002\uffff\u0001#\u0001\uffff\u0001\u0013\u0001\u001c\u0001\u001b\u0001\u0019\u0001\u001f\u0001\u0018\u0001 \u0001\u0017\u0001!\n(\u0001\u0016\u0001\u0015\u0001$\u0001\"\u0001%\u0001\uffff\u0001\u001a\u001a\uffff\u0001\u001e\u0001\uffff\u0001\u001d\u0001'\u0002\uffff\u0001\u0001\u0001\u0002\u0001\u0003\u0001\u0004\u0001\u0005\u0001\u0006\u0001\u0007\u0001\u0014\u0001\b\u0002\u0014\u0001\t\u0001\u0014\u0001\n\u0001\u000b\u0001\f\u0001\u0014\u0001\r\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0012\u0001\u0011\u0003\u0014\u0001\uffff\u0001&\u0001\uffff\u0001'", "\u0001*\u0003\uffff\u0001+\u0001,\u0001\uffff\u0001-", "\u0001.\t\uffff\u0001/\u0005\uffff\u00010\u0003\uffff\u00011", "\u00012\n\uffff\u00016\u0002\uffff\u00014\u0002\uffff\u00013\u0002\uffff\u00015", "\u00017", "\u00018\u0001\uffff\u0001:\t\uffff\u00019", "\u0001;\u0003\uffff\u0001<\t\uffff\u0001=\u0005\uffff\u0001>", "\u0001?", "\u0001@\u0006\uffff\u0001C\u0001A\u0004\uffff\u0001B", "\u0001D\u0007\uffff\u0001E\u0005\uffff\u0001F", "\u0001\u0013G\uffff\u0001G\u0005\uffff\u0001H", "\u0001K\r\uffff\u0001I\u0001\uffff\u0001J\u0001\uffff\u0001L\u0001M", "\u0001N\u0007\uffff\u0001O\b\uffff\u0001P", "\u0001Q\u0003\uffff\u0001S\t\uffff\u0001R", "\u0001T\u0003\uffff\u0001U\u000b\uffff\u0001V\u0003\uffff\u0001W", "\u0001X\u0006\uffff\u0001Z\t\uffff\u0001Y", "\u0001[\u0002\uffff\u0001\\", "\u0001]", "\u0001^", "", "", "", "\u0001_", "\u0001b\u0001\uffff\nc", "", "\u0001d", "", "", "", "", "", "", "\u0001f", "\u0001h", "\u0001j", "", "\u0001l\u0001m\u0001'", "\u0001p\u0001o", "\u0001r", "", "\u0001v\u0001\uffff\nt+\uffff\u0001w", "", "\u0001x", "\u0001y", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001{", "\u0001}\f\uffff\u0001|", "\u0001~", "\u0001\u007f", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u0081", "\u0001\u0082", "\u0001\u0083\u0001\u0084\u0001\u0085", "\u0001\u0086", "\u0001\u0087", "\u0001\u008a\u0002\uffff\u0001\u0088\u0005\uffff\u0001\u0089\u0007\uffff\u0001\u008b", "\u0001\u008c", "\u0001\u008f\u0001\uffff\u0001\u0090\u0003\uffff\u0001\u008e\n\uffff\u0001\u008d", "\u0001\u0091", "\u0001\u0092", "\u0001\u0093", "\u0001\u0094", "\u0001\u0095", "\u0001\u0096", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u0003\u0014\u0001\u0098\u000e\u0014\u0001\u0099\u0001\u009a\u0006\u0014", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u000e\u0014\u0001\u009c\u000b\u0014", "\u0001\u009e", "\u0001\u009f", "\u0001?\u0001\uffff\u0001?", "\u0001?\u000b\uffff\u0001?", "\u0001?\u0010\uffff\u0001��", "\u0001?", "\u0001��", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001?", "\u0001?", "\u0001?", "\u0001?\u000e\uffff\u0001\u00ad", "\u0001?", "\u0001?\r\uffff\u0001��", "\u0001��", "\u0001?\n\uffff\u0001?", "\u0001?\u0002\uffff\u0001?\f\uffff\u0001?\u0001��", "\u0001?", "\u0001?\u0007\uffff\u0001?", "\u0001?", "\u0001?", "\u0001?", "\u0001?\u0013\uffff\u0001?", "\u0001\u00c0", "\u0001\u00c1", "\u0001\u00c2", "\u0001\u00c4\u0003\uffff\u0001\u00c3", "\u0001\u00c5", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "\u0001v\u0001\uffff\nt+\uffff\u0001w", "", "", "", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u00c7", "", "\u0001\u00c8", "\u0001\u00c9", "\u0001\u00ca", "\u0001\u00cb", "\u0001\u00cc", "", "\u0001\u00cd", "\u0001\u00ce", "\u0001\u00cf", "\u0001\u00d0", "\u0001\u00d1\u0001\u00d2", "\u0001\u00d3\u0001\u00d4", "\u0001\u00d5", "\u0001\u00d6\u0007\uffff\u0001\u00d7", "\u0001\u00d8", "\u0001\u00d9", "\u0001\u00da", "\u0001\u00db\u0003\uffff\u0001\u00dc", "\u0001\u00dd", "\u0001\u00de\u0001\u00df", "\u0001\u00e0", "\u0001\u00e1", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u00e3", "\u0001\u00e4", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u0001\u00e5\u0019\u0014", "\u0001\u00e7", "\u0001\u00e8", "", "\u0001\u00e9", "\u0001\u00ea", "\u0001\u00eb", "", "\u0001\u00ec", "", "\u0001\u00ed", "\u0001\u00ee", "\u0001\u00ef", "\u0001\u00f0", "\u0001\u00f1", "\u0001\u00f2", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u0005\u0014\u0001\u00f3\u0014\u0014", "\u0001\u00f5", "\u0001\u00f6", "\u0001\u00f7", "", "\u0001\u00f8", "\u0001\u00f9", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u00fb", "\u0001\u00fc", "\u0001\u00fd", "\u0001\u00fe", "\u0001\u00ff", "\u0001\u0100", "\u0001\u0101", "\u0001\u0102", "\u0001\u0103", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u0105", "\u0001\u0106", "\u0001\u0107", "\u0001\u0108", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u010b", "\u0001\u010c", "\u0001\u010d", "\u0001\u010e", "\u0001\u010f", "\u0001\u0110", "\u0001\u0111", "\u0001\u0112", "\u0001\u0113", "\u0001\u0114\u0006\uffff\u0001\u0115", "", "\u0001\u0116", "\u0001\u0117", "\u0001\u0118", "\u0001\u0119", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u011b\u0001\uffff\u001a\u0014", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u011e", "\u0001\u011f", "\u0001\u0120", "\u0001\u0121", "\u0001\u0122", "\u0001\u0123", "\u0001\u0124", "\u0001\u0125", "\u0001\u0126", "\u0001\u0127", "\u0001\u0128", "\u0001\u0129", "\u0001\u012a", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u012c", "\u0001\u012d", "\u0001\u012e", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u0130", "\u0001\u0131", "", "\u0001\u0132", "\u0001\u0133", "\u0001\u0134", "", "\u0001\u0135", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u0137", "\u0001\u0138", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u013a", "\u0001\u013b", "\u0001\u013c", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u013e", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u0141", "", "\u0001\u0142", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u0145", "\u0001\u0146", "", "\u0001\u0147", "\u0001\u0148", "\u0001\u0149", "\u0001\u014a", "\u0001\u014b", "\u0001\u014c", "\u0001\u014d", "\u0001\u014e", "\u0001\u014f", "", "\u0001\u0150", "\u0001\u0151", "\u0001\u0152", "\u0001\u0153", "", "", "\u0001\u0154", "\u0001\u0155", "\u0001\u0156", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u0159", "\u0001\u015a", "\u0001\u015b", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u015d", "\u0001\u015e", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u0160", "\u0001\u0161", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "", "\u0001\u0163", "", "", "\u0001\u0164", "\u0001\u0165", "\u0001\u0166", "\u0001\u0167", "\u0001\u0168", "\u0001\u0169", "\u0001\u016a", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u016c", "\u0001\u016d", "\u0001\u016e\u0003\uffff\u0001\u016f", "\u0001\u0170", "\u0001\u0171", "", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u0173", "\u0001\u0174", "", "\u0001\u0175", "\u0001\u0176", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u0179", "\u0001\u017a", "", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u017c", "", "\u0001\u017d", "\u0001\u017e", "\u0001\u017f", "", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "", "", "\u0001\u0181", "\u0001\u0182", "", "", "\u0001\u0183", "\u0001\u0184", "\u0001\u0185", "\u0001\u0186", "\u0001\u0187", "\u0001\u0188", "\u0001\u0189", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u018b", "\u0001\u018c", "\u0001\u018d", "\u0001\u018e", "\u0001\u018f", "\u0001\u0190", "\u0001\u0191", "\u0001\u0192", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u0194", "", "", "\u0001\u0195\u0003\uffff\u0001\u0196", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "", "\u0001\u0199", "\u0001\u019a", "", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u019c", "", "\u0001\u019d", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u019f", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u01a1", "\u0001\u01a2", "\u0001\u01a3", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "", "\u0001\u01a5", "\u0001\u01a6", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u01a8", "\u0001\u01a9", "\u0001\u01aa", "", "\u0001\u01ab", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u01ad", "\u0001\u01ae", "", "", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u01b0", "", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\b\u0014\u0001\u01b1\u0011\u0014", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u01b4", "\u0001\u01b5", "", "\u0001\u01b6", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u01ba", "\u0001\u01bb", "\u0001\u01bc", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u01be", "", "\u0001\u01bf", "\u0001\u01c0", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u01c2", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\b\u0014\u0001\u01c3\u0011\u0014", "\u0001\u01c5", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u01c7", "", "\u0001\u01c8", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u01ca", "", "", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u01cc", "", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u01ce", "", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "", "\u0001\u01d0", "\u0001\u01d1", "\u0001\u01d2", "", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "", "\u0001\u01d5", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u01d7", "\u0001\u01d8", "", "\u0001\u01d9", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "", "\u0001\u01db", "\u0001\u01dc", "", "", "\u0001\u01dd", "\u0001\u01de", "\u0001\u01df", "", "", "", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u01e1", "\u0001\u01e2", "", "\u0001\u01e3", "\u0001\u01e4", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "", "\u0001\u01e6", "\u0001\u01e7", "", "\u0001\u01e8", "", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u01ea", "", "\u0001\u01eb", "", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "", "\u0001\u01ed", "", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u01f0", "", "", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "", "\u0001\u01f2", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u01f4", "", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u01f6", "\u0001\u01f7", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "", "\u0001\u01fa", "\u0001\u01fb", "\u0001\u01fc", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "", "\u0001\u01fe", "\u0001\u01ff", "\u0001\u0200", "", "\u0001\u0201", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "", "\u0001\u0203", "", "", "\u0001\u0204", "", "\u0001\u0205", "", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "", "", "\u0001\u0209", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "", "\u0001\u020c", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u020f", "", "\u0001\u0210", "\u0001\u0211", "\u0001\u0212", "", "", "", "\u0001\u0213", "", "", "\u0001\u0214", "", "", "\u0001\u0215", "\u0001\u0216", "\u0001\u0217", "\u0001\u0218", "\u0001\u0219", "\u0001\u021a", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u021c", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u021e", "\u0001\u021f", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "\u0001\u0223", "", "", "", "\u0001\u0224", "\u0002\u0014\u000b\uffff\n\u0014%\uffff\u0001\u0014\u0001\uffff\u001a\u0014", "" };
        DFA15_eot = DFA.unpackEncodedString("\u0001\uffff\u0012\u0014\u0003\uffff\u0001`\u0001a\u0001\uffff\u0001e\u0006\uffff\u0001g\u0001i\u0001k\u0001\uffff\u0001n\u0001q\u0001s\u0001\uffff\u0001u\u0001\uffff\u0002\u0014\u0001z\u0004\u0014\u0001\u0080\u000e\u0014\u0001\u0097\u0001\u009b\u0001\u009d\u0007\u0014\u0001��\u0014\u0014\u0015\uffff\u0001u\u0003\uffff\u0001\u00c6\u0001\u0014\u0001\uffff\u0005\u0014\u0001\uffff\u0010\u0014\u0001\u00e2\u0002\u0014\u0001\u00e6\u0002\u0014\u0001\uffff\u0003\u0014\u0001\uffff\u0001\u0014\u0001\uffff\u0006\u0014\u0001\u00f4\u0003\u0014\u0001\uffff\u0002\u0014\u0001\u00fa\t\u0014\u0001\u0104\u0004\u0014\u0001\u0109\u0001\u010a\n\u0014\u0001\uffff\u0004\u0014\u0001\u011a\u0001\u011c\u0001\u011d\r\u0014\u0001\u012b\u0003\u0014\u0001\u012f\u0002\u0014\u0001\uffff\u0003\u0014\u0001\uffff\u0001\u0014\u0001\u0136\u0002\u0014\u0001\u0139\u0003\u0014\u0001\u013d\u0001\u0014\u0001\u013f\u0001\u0140\u0001\u0014\u0001\uffff\u0001\u0014\u0001\u0143\u0001\u0144\u0002\u0014\u0001\uffff\t\u0014\u0001\uffff\u0004\u0014\u0002\uffff\u0003\u0014\u0001\u0157\u0001\u0158\u0003\u0014\u0001\u015c\u0002\u0014\u0001\u015f\u0002\u0014\u0001\u0162\u0001\uffff\u0001\u0014\u0002\uffff\u0007\u0014\u0001\u016b\u0005\u0014\u0001\uffff\u0001\u0172\u0002\u0014\u0001\uffff\u0002\u0014\u0001\u0177\u0001\u0178\u0002\u0014\u0001\uffff\u0001\u017b\u0001\u0014\u0001\uffff\u0003\u0014\u0001\uffff\u0001\u0180\u0002\uffff\u0002\u0014\u0002\uffff\u0007\u0014\u0001\u018a\b\u0014\u0001\u0193\u0001\u0014\u0002\uffff\u0001\u0014\u0001\u0197\u0001\u0198\u0001\uffff\u0002\u0014\u0001\uffff\u0001\u019b\u0001\u0014\u0001\uffff\u0001\u0014\u0001\u019e\u0001\u0014\u0001\u01a0\u0003\u0014\u0001\u01a4\u0001\uffff\u0002\u0014\u0001\u01a7\u0003\u0014\u0001\uffff\u0001\u0014\u0001\u01ac\u0002\u0014\u0002\uffff\u0001\u01af\u0001\u0014\u0001\uffff\u0001\u01b2\u0001\u01b3\u0002\u0014\u0001\uffff\u0001\u0014\u0001\u01b7\u0001\u01b8\u0001\u01b9\u0003\u0014\u0001\u01bd\u0001\u0014\u0001\uffff\u0002\u0014\u0001\u01c1\u0001\u0014\u0001\u01c4\u0001\u0014\u0001\u01c6\u0001\u0014\u0001\uffff\u0001\u0014\u0001\u01c9\u0001\u0014\u0002\uffff\u0001\u01cb\u0001\u0014\u0001\uffff\u0001\u01cd\u0001\u0014\u0001\uffff\u0001\u01cf\u0001\uffff\u0003\u0014\u0001\uffff\u0001\u01d3\u0001\u01d4\u0001\uffff\u0001\u0014\u0001\u01d6\u0002\u0014\u0001\uffff\u0001\u0014\u0001\u01da\u0001\uffff\u0002\u0014\u0002\uffff\u0003\u0014\u0003\uffff\u0001\u01e0\u0002\u0014\u0001\uffff\u0002\u0014\u0001\u01e5\u0001\uffff\u0002\u0014\u0001\uffff\u0001\u0014\u0001\uffff\u0001\u01e9\u0001\u0014\u0001\uffff\u0001\u0014\u0001\uffff\u0001\u01ec\u0001\uffff\u0001\u0014\u0001\uffff\u0001\u01ee\u0001\u01ef\u0001\u0014\u0002\uffff\u0001\u01f1\u0001\uffff\u0001\u0014\u0001\u01f3\u0001\u0014\u0001\uffff\u0001\u01f5\u0002\u0014\u0001\u01f8\u0001\u01f9\u0001\uffff\u0003\u0014\u0001\u01fd\u0001\uffff\u0003\u0014\u0001\uffff\u0001\u0014\u0001\u0202\u0001\uffff\u0001\u0014\u0002\uffff\u0001\u0014\u0001\uffff\u0001\u0014\u0001\uffff\u0001\u0206\u0001\uffff\u0001\u0207\u0001\u0208\u0002\uffff\u0001\u0014\u0001\u020a\u0001\u020b\u0001\uffff\u0001\u0014\u0001\u020d\u0001\u020e\u0001\u0014\u0001\uffff\u0003\u0014\u0003\uffff\u0001\u0014\u0002\uffff\u0001\u0014\u0002\uffff\u0006\u0014\u0001\u021b\u0001\u0014\u0001\u021d\u0002\u0014\u0001\u0220\u0001\uffff\u0001\u0221\u0001\uffff\u0001\u0222\u0001\u0014\u0003\uffff\u0001\u0014\u0001\u0225\u0001\uffff");
        DFA15_eof = DFA.unpackEncodedString("\u0226\uffff");
        DFA15_min = DFA.unpackEncodedStringToUnsignedChars("\u0001\t\u0001n\u0001e\u0001a\u0001e\u0001l\u0001a\u0001o\u0001f\u0001a\u0001'\u0001b\u0004a\u0001p\u0001h\u0001a\u0003\uffff\u0001=\u0001.\u0001\uffff\u0001*\u0006\uffff\u0001-\u0001*\u0001>\u0001\uffff\u0001<\u0001=\u0001|\u0001\uffff\u0001.\u0001\uffff\u0001d\u0001r\u0001#\u0001t\u0001g\u0001d\u0001l\u0001#\u0001s\u0001e\u0001l\u0001r\u0001o\u0001c\u0001s\u0001c\u0001d\u0001l\u0001t\u0001r\u0001n\u0001t\u0003#\u0001m\u0001n\u0001k\u0002c\u0001l\u0001e\u0001#\u0001j\u0001h\u0001t\u0001c\u0001p\u0001a\u0001i\u0001l\u0001c\u0001v\u0002l\u0002b\u0001a\u0001e\u0001d\u0001i\u0001e\u0001r\u0015\uffff\u0001.\u0003\uffff\u0001#\u0001a\u0001\uffff\u0001h\u0001w\u0001i\u0001y\u0001k\u0001\uffff\u0001e\u0001a\u0001l\u0001m\u0001s\u0001r\u0001s\u0001a\u0001e\u0001l\u0003e\u0001s\u0001e\u0001c\u0001#\u0001s\u0001c\u0001#\u0001c\u0001o\u0001\uffff\u0002e\u0001o\u0001\uffff\u0001p\u0001\uffff\u0001e\u0001g\u0001e\u0001i\u0001k\u0001p\u0001#\u0001o\u0001l\u0001n\u0001\uffff\u0002e\u0001#\u0001k\u0001a\u0001e\u0001g\u0001c\u0001s\u0001l\u0001t\u0001o\u0001#\u0002u\u0002e\u0002#\u0001t\u0001l\u0001n\u0001e\u0001n\u0001a\u0001n\u0001l\u0001n\u0001r\u0001\uffff\u0001y\u0001i\u0001e\u0001n\u0003#\u0001t\u0001e\u0001i\u0001t\u0001i\u0001e\u0001o\u0001e\u0001u\u0001n\u0001t\u0001a\u0001r\u0001#\u0001f\u0001r\u0001t\u0001#\u0001p\u0001u\u0001\uffff\u0001e\u0001h\u0001l\u0001\uffff\u0001t\u0001#\u0001x\u0001r\u0001#\u0001e\u0001d\u0001u\u0001#\u0001t\u0002#\u0001o\u0001\uffff\u0001p\u0002#\u0001c\u0001r\u0001\uffff\u0001a\u0002l\u0001m\u0002e\u0001b\u0001y\u0001r\u0001\uffff\u0001l\u0001r\u0001p\u0001c\u0002\uffff\u0001y\u0001e\u0001s\u0002#\u0001t\u0001g\u0001e\u0001#\u0001a\u0001i\u0001#\u0001d\u0001e\u0001#\u0001\uffff\u0001r\u0002\uffff\u0001e\u0001c\u0001t\u0001a\u0002n\u0001r\u0001#\u0001l\u0002e\u0001r\u0001m\u0001\uffff\u0001#\u0001n\u0001s\u0001\uffff\u0002t\u0002#\u0001l\u0001i\u0001\uffff\u0001#\u0001t\u0001\uffff\u0001n\u0001i\u0001a\u0001\uffff\u0001#\u0002\uffff\u0001u\u0001y\u0002\uffff\u0001t\u0001s\u0001g\u0001l\u0001i\u0001a\u0001d\u0001#\u0001a\u0001p\u0001d\u0001t\u0001n\u0001o\u0001t\u0001p\u0001#\u0001a\u0002\uffff\u0001e\u0002#\u0001\uffff\u0001y\u0001n\u0001\uffff\u0001#\u0001n\u0001\uffff\u0001o\u0001#\u0001t\u0001#\u0001n\u0001u\u0001t\u0001#\u0001\uffff\u0001t\u0001r\u0001#\u0001n\u0001e\u0001i\u0001\uffff\u0001a\u0001#\u0001i\u0001e\u0002\uffff\u0001#\u0001o\u0001\uffff\u0002#\u0001a\u0001g\u0001\uffff\u0001n\u0003#\u0002e\u0001n\u0001#\u0001u\u0001\uffff\u0001c\u0001e\u0001#\u0001_\u0001#\u0001i\u0001#\u0001e\u0001\uffff\u0001c\u0001#\u0001n\u0002\uffff\u0001#\u0001g\u0001\uffff\u0001#\u0001w\u0001\uffff\u0001#\u0001\uffff\u0001t\u0001e\u0001_\u0001\uffff\u0002#\u0001\uffff\u0001g\u0001#\u0001n\u0001l\u0001\uffff\u0001o\u0001#\u0001\uffff\u0002n\u0002\uffff\u0001t\u0001e\u0001d\u0003\uffff\u0001#\u0001l\u0001e\u0001\uffff\u0001r\u0001k\u0001#\u0001\uffff\u0001c\u0001n\u0001\uffff\u0001n\u0001\uffff\u0001#\u0001t\u0001\uffff\u0001g\u0001\uffff\u0001#\u0001\uffff\u0001c\u0001\uffff\u0002#\u0001u\u0002\uffff\u0001#\u0001\uffff\u0001i\u0001#\u0001n\u0001\uffff\u0001#\u0001g\u0001e\u0002#\u0001\uffff\u0001_\u0001d\u0001e\u0001#\u0001\uffff\u0001a\u0001g\u0001t\u0001\uffff\u0001i\u0001#\u0001\uffff\u0001o\u0002\uffff\u0001s\u0001\uffff\u0001s\u0001\uffff\u0001#\u0001\uffff\u0002#\u0002\uffff\u0001e\u0002#\u0001\uffff\u0001c\u0002#\u0001o\u0001\uffff\u0001u\u0001e\u0001t\u0003\uffff\u0001n\u0002\uffff\u0001h\u0002\uffff\u0002n\u0001r\u0001i\u0001a\u0001e\u0001#\u0001t\u0001#\u0001c\u0001b\u0001#\u0001\uffff\u0001#\u0001\uffff\u0001#\u0001l\u0003\uffff\u0001e\u0001#\u0001\uffff");
        DFA15_max = DFA.unpackEncodedStringToUnsignedChars("\u0001~\u0001u\u0001y\u0001u\u0001e\u0001x\u0001u\u0001o\u0001s\u0001o\u0002u\u0001r\u0001o\u0001u\u0001r\u0001s\u0001h\u0001a\u0003\uffff\u0001=\u00019\u0001\uffff\u0001*\u0006\uffff\u0001-\u0001*\u0001>\u0001\uffff\u0002>\u0001|\u0001\uffff\u0001e\u0001\uffff\u0001d\u0001r\u0001z\u0002t\u0001d\u0001l\u0001z\u0001s\u0001e\u0001n\u0001r\u0001o\u0001t\u0001s\u0001t\u0001d\u0001l\u0001t\u0001r\u0001n\u0001t\u0003z\u0001m\u0001n\u0001m\u0001o\u0001t\u0001l\u0001e\u0001z\u0001j\u0001h\u0001t\u0001r\u0001p\u0001o\u0001i\u0001w\u0001t\u0001v\u0001t\u0001l\u0002b\u0001u\u0001e\u0001d\u0002i\u0001r\u0015\uffff\u0001e\u0003\uffff\u0001z\u0001a\u0001\uffff\u0001h\u0001w\u0001i\u0001y\u0001k\u0001\uffff\u0001e\u0001a\u0001l\u0001m\u0001t\u0002s\u0001i\u0001e\u0001l\u0001e\u0001i\u0001e\u0001t\u0001e\u0001c\u0001z\u0001s\u0001c\u0001z\u0001c\u0001o\u0001\uffff\u0002e\u0001o\u0001\uffff\u0001p\u0001\uffff\u0001e\u0001g\u0001e\u0001i\u0001k\u0001p\u0001z\u0001o\u0001l\u0001n\u0001\uffff\u0002e\u0001z\u0001k\u0001a\u0001e\u0001g\u0001c\u0001s\u0001l\u0001t\u0001o\u0001z\u0002u\u0002e\u0002z\u0001t\u0001l\u0001n\u0001e\u0001n\u0001a\u0001n\u0001l\u0001n\u0001y\u0001\uffff\u0001y\u0001i\u0001e\u0001n\u0003z\u0001t\u0001e\u0001i\u0001t\u0001i\u0001e\u0001o\u0001e\u0001u\u0001n\u0001t\u0001a\u0001r\u0001z\u0001f\u0001r\u0001t\u0001z\u0001p\u0001u\u0001\uffff\u0001e\u0001h\u0001l\u0001\uffff\u0001t\u0001z\u0001x\u0001r\u0001z\u0001e\u0001d\u0001u\u0001z\u0001t\u0002z\u0001o\u0001\uffff\u0001p\u0002z\u0001c\u0001r\u0001\uffff\u0001a\u0002l\u0001m\u0002e\u0001b\u0001y\u0001r\u0001\uffff\u0001l\u0001r\u0001p\u0001c\u0002\uffff\u0001y\u0001e\u0001s\u0002z\u0001t\u0001g\u0001e\u0001z\u0001a\u0001i\u0001z\u0001d\u0001e\u0001z\u0001\uffff\u0001r\u0002\uffff\u0001e\u0001c\u0001t\u0001a\u0002n\u0001r\u0001z\u0001l\u0001e\u0001i\u0001r\u0001m\u0001\uffff\u0001z\u0001n\u0001s\u0001\uffff\u0002t\u0002z\u0001l\u0001i\u0001\uffff\u0001z\u0001t\u0001\uffff\u0001n\u0001i\u0001a\u0001\uffff\u0001z\u0002\uffff\u0001u\u0001y\u0002\uffff\u0001t\u0001s\u0001g\u0001l\u0001i\u0001a\u0001d\u0001z\u0001a\u0001p\u0001d\u0001t\u0001n\u0001o\u0001t\u0001p\u0001z\u0001a\u0002\uffff\u0001i\u0002z\u0001\uffff\u0001y\u0001n\u0001\uffff\u0001z\u0001n\u0001\uffff\u0001o\u0001z\u0001t\u0001z\u0001n\u0001u\u0001t\u0001z\u0001\uffff\u0001t\u0001r\u0001z\u0001n\u0001e\u0001i\u0001\uffff\u0001a\u0001z\u0001i\u0001e\u0002\uffff\u0001z\u0001o\u0001\uffff\u0002z\u0001a\u0001g\u0001\uffff\u0001n\u0003z\u0002e\u0001n\u0001z\u0001u\u0001\uffff\u0001c\u0001e\u0001z\u0001_\u0001z\u0001i\u0001z\u0001e\u0001\uffff\u0001c\u0001z\u0001n\u0002\uffff\u0001z\u0001g\u0001\uffff\u0001z\u0001w\u0001\uffff\u0001z\u0001\uffff\u0001t\u0001e\u0001_\u0001\uffff\u0002z\u0001\uffff\u0001g\u0001z\u0001n\u0001l\u0001\uffff\u0001o\u0001z\u0001\uffff\u0002n\u0002\uffff\u0001t\u0001e\u0001d\u0003\uffff\u0001z\u0001l\u0001e\u0001\uffff\u0001r\u0001k\u0001z\u0001\uffff\u0001c\u0001n\u0001\uffff\u0001n\u0001\uffff\u0001z\u0001t\u0001\uffff\u0001g\u0001\uffff\u0001z\u0001\uffff\u0001c\u0001\uffff\u0002z\u0001u\u0002\uffff\u0001z\u0001\uffff\u0001i\u0001z\u0001n\u0001\uffff\u0001z\u0001g\u0001e\u0002z\u0001\uffff\u0001_\u0001d\u0001e\u0001z\u0001\uffff\u0001a\u0001g\u0001t\u0001\uffff\u0001i\u0001z\u0001\uffff\u0001o\u0002\uffff\u0001s\u0001\uffff\u0001s\u0001\uffff\u0001z\u0001\uffff\u0002z\u0002\uffff\u0001e\u0002z\u0001\uffff\u0001c\u0002z\u0001o\u0001\uffff\u0001u\u0001e\u0001t\u0003\uffff\u0001n\u0002\uffff\u0001h\u0002\uffff\u0002n\u0001r\u0001i\u0001a\u0001e\u0001z\u0001t\u0001z\u0001c\u0001b\u0001z\u0001\uffff\u0001z\u0001\uffff\u0001z\u0001l\u0003\uffff\u0001e\u0001z\u0001\uffff");
        DFA15_accept = DFA.unpackEncodedString("\u0013\uffff\u0001\\\u0001]\u0001^\u0002\uffff\u0001b\u0001\uffff\u0001e\u0001f\u0001g\u0001h\u0001i\u0001j\u0003\uffff\u0001n\u0003\uffff\u0001u\u0001\uffff\u0001|5\uffff\u0001q\u0001_\u0001a\u0001`\u0001{\u0001c\u0001d\u0001}\u0001k\u0001~\u0001l\u0001r\u0001m\u0001o\u0001w\u0001v\u0001p\u0001y\u0001x\u0001t\u0001s\u0001\uffff\u0001z\u0002{\u0002\uffff\u0001\u0003\u0005\uffff\u0001\t\u0016\uffff\u0001\u001a\u0003\uffff\u0001\u001b\u0001\uffff\u0001\u001f\n\uffff\u0001(\u001d\uffff\u0001\u0001\u001b\uffff\u0001B\u0003\uffff\u0001\u0017\r\uffff\u0001$\u0005\uffff\u0001L\t\uffff\u0001R\u0004\uffff\u0001.\u0001/\u000f\uffff\u0001\u0006\u0001\uffff\u0001\u0007\u0001\n\r\uffff\u0001\u0012\u0003\uffff\u0001E\u0006\uffff\u0001\u0019\u0002\uffff\u0001\u001e\u0003\uffff\u0001!\u0001\uffff\u0001#\u0001H\u0002\uffff\u0001&\u0001'\u0012\uffff\u00012\u00013\u0003\uffff\u0001[\u0002\uffff\u0001\u0002\u0002\uffff\u0001;\b\uffff\u0001<\u0006\uffff\u0001\u0013\u0004\uffff\u0001\u0015\u0001\u0016\u0002\uffff\u0001\u001c\u0004\uffff\u0001\"\t\uffff\u0001*\b\uffff\u00010\u0003\uffff\u0001X\u00015\u0002\uffff\u0001\u0004\u0002\uffff\u0001\u000b\u0001\uffff\u0001\r\u0003\uffff\u0001?\u0002\uffff\u0001\u0011\u0004\uffff\u0001:\u0002\uffff\u0001\u0018\u0002\uffff\u0001\u001d\u00019\u0003\uffff\u0001I\u0001J\u0001K\u0003\uffff\u0001O\u0003\uffff\u0001Q\u0002\uffff\u0001T\u0001\uffff\u0001-\u0002\uffff\u00014\u0001\uffff\u0001Y\u0001\uffff\u0001\u0005\u0001\uffff\u0001\f\u0003\uffff\u0001\u000f\u0001\u0010\u0001\uffff\u0001@\u0003\uffff\u0001D\u0005\uffff\u0001)\u0004\uffff\u0001V\u0003\uffff\u0001W\u0002\uffff\u0001Z\u0001\uffff\u0001=\u0001>\u0001\uffff\u00018\u0001\uffff\u0001\u0014\u0001\uffff\u0001F\u0002\uffff\u0001 \u0001%\u0003\uffff\u0001+\u0004\uffff\u00017\u0003\uffff\u0001C\u00016\u0001G\u0001\uffff\u0001N\u0001P\u0001\uffff\u0001U\u0001,\f\uffff\u00011\u0001\uffff\u0001\u000e\u0002\uffff\u0001S\u0001\b\u0001A\u0002\uffff\u0001M");
        DFA15_special = DFA.unpackEncodedString("(\uffff\u0001\u0001K\uffff\u0001\u0000\u01b1\uffff}>");
        numStates = PLSQL2Lexer.DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i = 0; i < numStates; ++i) {
            PLSQL2Lexer.DFA15_transition[i] = DFA.unpackEncodedString(PLSQL2Lexer.DFA15_transitionS[i]);
        }
    }
    
    public String getErrorHeader(final RecognitionException e) {
        return String.valueOf(this.getSourceName()) + ":" + e.line + ":" + (e.charPositionInLine + 1) + ":";
    }
    
    private boolean numberDotValid() {
        int i;
        for (i = 1; this.input.LA(i) >= 48 && this.input.LA(i) <= 57; ++i) {}
        return this.input.LA(i) == 46 && this.input.LA(i + 1) != 46;
    }
    
    public PLSQL2Lexer() {
        this.dfa9 = new DFA9((BaseRecognizer)this);
        this.dfa15 = new DFA15((BaseRecognizer)this);
    }
    
    public PLSQL2Lexer(final CharStream input) {
        this(input, new RecognizerSharedState());
    }
    
    public PLSQL2Lexer(final CharStream input, final RecognizerSharedState state) {
        super(input, state);
        this.dfa9 = new DFA9((BaseRecognizer)this);
        this.dfa15 = new DFA15((BaseRecognizer)this);
    }
    
    public String getGrammarFileName() {
        return "generator/src/com/uframe/generator/provider/db/procedure/PLSQL2.g";
    }
    
    public final void mAND() throws RecognitionException {
        final int _type = 69;
        final int _channel = 0;
        this.match("and");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mARRAY() throws RecognitionException {
        final int _type = 29;
        final int _channel = 0;
        this.match("array");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mAS() throws RecognitionException {
        final int _type = 24;
        final int _channel = 0;
        this.match("as");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mAUTHID() throws RecognitionException {
        final int _type = 119;
        final int _channel = 0;
        this.match("authid");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mBETWEEN() throws RecognitionException {
        final int _type = 68;
        final int _channel = 0;
        this.match("between");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mBODY() throws RecognitionException {
        final int _type = 117;
        final int _channel = 0;
        this.match("body");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mBULK() throws RecognitionException {
        final int _type = 61;
        final int _channel = 0;
        this.match("bulk");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mBULK_ROWCOUNT() throws RecognitionException {
        final int _type = 102;
        final int _channel = 0;
        this.match("bulk_rowcount");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mBY() throws RecognitionException {
        final int _type = 33;
        final int _channel = 0;
        this.match("by");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mCASE() throws RecognitionException {
        final int _type = 51;
        final int _channel = 0;
        this.match("case");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mCREATE() throws RecognitionException {
        final int _type = 115;
        final int _channel = 0;
        this.match("create");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mCOLLECT() throws RecognitionException {
        final int _type = 62;
        final int _channel = 0;
        this.match("collect");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mCOMMIT() throws RecognitionException {
        final int _type = 79;
        final int _channel = 0;
        this.match("commit");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mCURRENT_USER() throws RecognitionException {
        final int _type = 120;
        final int _channel = 0;
        this.match("current_user");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mDEFAULT() throws RecognitionException {
        final int _type = 14;
        final int _channel = 0;
        this.match("default");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mDEFINER() throws RecognitionException {
        final int _type = 121;
        final int _channel = 0;
        this.match("definer");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mDELETE() throws RecognitionException {
        final int _type = 49;
        final int _channel = 0;
        this.match("delete");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mELSE() throws RecognitionException {
        final int _type = 52;
        final int _channel = 0;
        this.match("else");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mELSIF() throws RecognitionException {
        final int _type = 72;
        final int _channel = 0;
        this.match("elsif");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mEXTERNAL() throws RecognitionException {
        final int _type = 118;
        final int _channel = 0;
        this.match("external");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mFALSE() throws RecognitionException {
        final int _type = 108;
        final int _channel = 0;
        this.match("false");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mFETCH() throws RecognitionException {
        final int _type = 58;
        final int _channel = 0;
        this.match("fetch");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mFOR() throws RecognitionException {
        final int _type = 65;
        final int _channel = 0;
        this.match("for");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mFORALL() throws RecognitionException {
        final int _type = 66;
        final int _channel = 0;
        this.match("forall");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mGOTO() throws RecognitionException {
        final int _type = 70;
        final int _channel = 0;
        this.match("goto");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mIF() throws RecognitionException {
        final int _type = 71;
        final int _channel = 0;
        this.match("if");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mIN() throws RecognitionException {
        final int _type = 15;
        final int _channel = 0;
        this.match("in");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mINDEX() throws RecognitionException {
        final int _type = 32;
        final int _channel = 0;
        this.match("index");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mINSERT() throws RecognitionException {
        final int _type = 80;
        final int _channel = 0;
        this.match("insert");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mINTO() throws RecognitionException {
        final int _type = 60;
        final int _channel = 0;
        this.match("into");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mIS() throws RecognitionException {
        final int _type = 19;
        final int _channel = 0;
        this.match("is");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mLANGUAGE() throws RecognitionException {
        final int _type = 122;
        final int _channel = 0;
        this.match("language");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mLIKE() throws RecognitionException {
        final int _type = 95;
        final int _channel = 0;
        this.match("like");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mLIMIT() throws RecognitionException {
        final int _type = 59;
        final int _channel = 0;
        this.match("limit");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mLOCK() throws RecognitionException {
        final int _type = 81;
        final int _channel = 0;
        this.match("lock");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mNOT() throws RecognitionException {
        final int _type = 20;
        final int _channel = 0;
        this.match("not");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mNOTFOUND() throws RecognitionException {
        final int _type = 104;
        final int _channel = 0;
        this.match("notfound");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mNULL() throws RecognitionException {
        final int _type = 21;
        final int _channel = 0;
        this.match("null");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mOPEN() throws RecognitionException {
        final int _type = 73;
        final int _channel = 0;
        this.match("open");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mOR() throws RecognitionException {
        final int _type = 45;
        final int _channel = 0;
        this.match("or");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mPACKAGE() throws RecognitionException {
        final int _type = 116;
        final int _channel = 0;
        this.match("package");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mRAISE() throws RecognitionException {
        final int _type = 75;
        final int _channel = 0;
        this.match("raise");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mROLLBACK() throws RecognitionException {
        final int _type = 82;
        final int _channel = 0;
        this.match("rollback");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mSAVEPOINT() throws RecognitionException {
        final int _type = 83;
        final int _channel = 0;
        this.match("savepoint");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mSELECT() throws RecognitionException {
        final int _type = 84;
        final int _channel = 0;
        this.match("select");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mSET() throws RecognitionException {
        final int _type = 85;
        final int _channel = 0;
        this.match("set");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mSQL() throws RecognitionException {
        final int _type = 101;
        final int _channel = 0;
        this.match("sql");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mTABLE() throws RecognitionException {
        final int _type = 31;
        final int _channel = 0;
        this.match("table");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mTRANSACTION() throws RecognitionException {
        final int _type = 86;
        final int _channel = 0;
        this.match("transaction");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mTRUE() throws RecognitionException {
        final int _type = 107;
        final int _channel = 0;
        this.match("true");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mTHEN() throws RecognitionException {
        final int _type = 47;
        final int _channel = 0;
        this.match("then");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mUPDATE() throws RecognitionException {
        final int _type = 87;
        final int _channel = 0;
        this.match("update");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mWHILE() throws RecognitionException {
        final int _type = 88;
        final int _channel = 0;
        this.match("while");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mINSERTING() throws RecognitionException {
        final int _type = 111;
        final int _channel = 0;
        this.match("inserting");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mUPDATING() throws RecognitionException {
        final int _type = 112;
        final int _channel = 0;
        this.match("updating");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mDELETING() throws RecognitionException {
        final int _type = 113;
        final int _channel = 0;
        this.match("deleting");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mISOPEN() throws RecognitionException {
        final int _type = 103;
        final int _channel = 0;
        this.match("isopen");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mEXISTS() throws RecognitionException {
        final int _type = 110;
        final int _channel = 0;
        this.match("exists");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mBEGIN() throws RecognitionException {
        final int _type = 42;
        final int _channel = 0;
        this.match("begin");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mCLOSE() throws RecognitionException {
        final int _type = 53;
        final int _channel = 0;
        this.match("close");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mCONSTANT() throws RecognitionException {
        final int _type = 22;
        final int _channel = 0;
        this.match("constant");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mCONTINUE() throws RecognitionException {
        final int _type = 54;
        final int _channel = 0;
        this.match("continue");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mCURSOR() throws RecognitionException {
        final int _type = 18;
        final int _channel = 0;
        this.match("cursor");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mDECLARE() throws RecognitionException {
        final int _type = 76;
        final int _channel = 0;
        this.match("declare");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mDETERMINISTIC() throws RecognitionException {
        final int _type = 38;
        final int _channel = 0;
        this.match("deterministic");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mEND() throws RecognitionException {
        final int _type = 43;
        final int _channel = 0;
        this.match("end");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mEXCEPTION() throws RecognitionException {
        final int _type = 23;
        final int _channel = 0;
        this.match("exception");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mEXECUTE() throws RecognitionException {
        final int _type = 55;
        final int _channel = 0;
        this.match("execute");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mEXIT() throws RecognitionException {
        final int _type = 57;
        final int _channel = 0;
        this.match("exit");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mFUNCTION() throws RecognitionException {
        final int _type = 8;
        final int _channel = 0;
        this.match("function");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mIMMEDIATE() throws RecognitionException {
        final int _type = 56;
        final int _channel = 0;
        this.match("immediate");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mLOOP() throws RecognitionException {
        final int _type = 50;
        final int _channel = 0;
        this.match("loop");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mNOCOPY() throws RecognitionException {
        final int _type = 17;
        final int _channel = 0;
        this.match("nocopy");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mOBJECT() throws RecognitionException {
        final int _type = 27;
        final int _channel = 0;
        this.match("object");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mOTHERS() throws RecognitionException {
        final int _type = 46;
        final int _channel = 0;
        this.match("others");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mOUT() throws RecognitionException {
        final int _type = 16;
        final int _channel = 0;
        this.match("out");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mPARALLEL_ENABLE() throws RecognitionException {
        final int _type = 40;
        final int _channel = 0;
        this.match("parallel_enable");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mPIPELINED() throws RecognitionException {
        final int _type = 39;
        final int _channel = 0;
        this.match("pipelined");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mPRAGMA() throws RecognitionException {
        final int _type = 74;
        final int _channel = 0;
        this.match("pragma");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mPROCEDURE() throws RecognitionException {
        final int _type = 6;
        final int _channel = 0;
        this.match("procedure");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mRECORD() throws RecognitionException {
        final int _type = 26;
        final int _channel = 0;
        this.match("record");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mREF() throws RecognitionException {
        final int _type = 34;
        final int _channel = 0;
        this.match("ref");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mRESULT_CACHE() throws RecognitionException {
        final int _type = 41;
        final int _channel = 0;
        this.match("result_cache");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mRETURN() throws RecognitionException {
        final int _type = 9;
        final int _channel = 0;
        this.match("return");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mRETURNING() throws RecognitionException {
        final int _type = 64;
        final int _channel = 0;
        this.match("returning");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mROWTYPE() throws RecognitionException {
        final int _type = 37;
        final int _channel = 0;
        this.match("rowtype");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mSUBTYPE() throws RecognitionException {
        final int _type = 25;
        final int _channel = 0;
        this.match("subtype");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mUSING() throws RecognitionException {
        final int _type = 63;
        final int _channel = 0;
        this.match("using");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mVARRAY() throws RecognitionException {
        final int _type = 30;
        final int _channel = 0;
        this.match("varray");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mVARYING() throws RecognitionException {
        final int _type = 28;
        final int _channel = 0;
        this.match("varying");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mWHEN() throws RecognitionException {
        final int _type = 44;
        final int _channel = 0;
        this.match("when");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mQUOTED_STRING() throws RecognitionException {
        final int _type = 109;
        final int _channel = 0;
        int alt1 = 2;
        final int LA1_0 = this.input.LA(1);
        if (LA1_0 == 110) {
            alt1 = 1;
        }
        switch (alt1) {
            case 1: {
                this.match(110);
                break;
            }
        }
        this.match(39);
        while (true) {
            int alt2 = 3;
            final int LA2_0 = this.input.LA(1);
            if (LA2_0 == 39) {
                final int LA2_2 = this.input.LA(2);
                if (LA2_2 == 39) {
                    alt2 = 1;
                }
            }
            else if ((LA2_0 >= 0 && LA2_0 <= 38) || (LA2_0 >= 40 && LA2_0 <= 65535)) {
                alt2 = 2;
            }
            switch (alt2) {
                case 1: {
                    this.match("''");
                    continue;
                }
                case 2: {
                    if ((this.input.LA(1) >= 0 && this.input.LA(1) <= 38) || (this.input.LA(1) >= 40 && this.input.LA(1) <= 65535)) {
                        this.input.consume();
                        continue;
                    }
                    final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                    this.recover((RecognitionException)mse);
                    throw mse;
                }
                default: {
                    this.match(39);
                    this.state.type = _type;
                    this.state.channel = _channel;
                }
            }
        }
    }
    
    public final void mID() throws RecognitionException {
        final int _type = 7;
        final int _channel = 0;
        int alt4 = 2;
        final int LA4_0 = this.input.LA(1);
        if (LA4_0 >= 97 && LA4_0 <= 122) {
            alt4 = 1;
        }
        else {
            if (LA4_0 != 34) {
                final NoViableAltException nvae = new NoViableAltException("", 4, 0, (IntStream)this.input);
                throw nvae;
            }
            alt4 = 2;
        }
        Label_0339: {
            switch (alt4) {
                case 1: {
                    this.matchRange(97, 122);
                    while (true) {
                        int alt5 = 2;
                        final int LA3_0 = this.input.LA(1);
                        if ((LA3_0 >= 35 && LA3_0 <= 36) || (LA3_0 >= 48 && LA3_0 <= 57) || LA3_0 == 95 || (LA3_0 >= 97 && LA3_0 <= 122)) {
                            alt5 = 1;
                        }
                        switch (alt5) {
                            case 1: {
                                if ((this.input.LA(1) >= 35 && this.input.LA(1) <= 36) || (this.input.LA(1) >= 48 && this.input.LA(1) <= 57) || this.input.LA(1) == 95 || (this.input.LA(1) >= 97 && this.input.LA(1) <= 122)) {
                                    this.input.consume();
                                    continue;
                                }
                                final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                                this.recover((RecognitionException)mse);
                                throw mse;
                            }
                            default: {
                                break Label_0339;
                            }
                        }
                    }
                    /*break;*/
                }
                case 2: {
                    this.mDOUBLEQUOTED_STRING();
                    break;
                }
            }
        }
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mSEMI() throws RecognitionException {
        final int _type = 5;
        final int _channel = 0;
        this.match(59);
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mCOLON() throws RecognitionException {
        final int _type = 48;
        final int _channel = 0;
        this.match(58);
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mDOUBLEDOT() throws RecognitionException {
        final int _type = 67;
        final int _channel = 0;
        this.mPOINT();
        this.mPOINT();
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mDOT() throws RecognitionException {
        final int _type = 35;
        final int _channel = 0;
        this.mPOINT();
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mPOINT() throws RecognitionException {
        this.match(46);
    }
    
    public final void mCOMMA() throws RecognitionException {
        final int _type = 11;
        final int _channel = 0;
        this.match(44);
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mEXPONENT() throws RecognitionException {
        final int _type = 100;
        final int _channel = 0;
        this.match("**");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mASTERISK() throws RecognitionException {
        final int _type = 99;
        final int _channel = 0;
        this.match(42);
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mAT_SIGN() throws RecognitionException {
        final int _type = 125;
        final int _channel = 0;
        this.match(64);
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mRPAREN() throws RecognitionException {
        final int _type = 12;
        final int _channel = 0;
        this.match(41);
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mLPAREN() throws RecognitionException {
        final int _type = 10;
        final int _channel = 0;
        this.match(40);
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mRBRACK() throws RecognitionException {
        final int _type = 126;
        final int _channel = 0;
        this.match(93);
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mLBRACK() throws RecognitionException {
        final int _type = 127;
        final int _channel = 0;
        this.match(91);
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mPLUS() throws RecognitionException {
        final int _type = 97;
        final int _channel = 0;
        this.match(43);
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mMINUS() throws RecognitionException {
        final int _type = 96;
        final int _channel = 0;
        this.match(45);
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mDIVIDE() throws RecognitionException {
        final int _type = 4;
        final int _channel = 0;
        this.match(47);
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mEQ() throws RecognitionException {
        final int _type = 89;
        final int _channel = 0;
        this.match(61);
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mPERCENT() throws RecognitionException {
        final int _type = 36;
        final int _channel = 0;
        this.match(37);
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mLLABEL() throws RecognitionException {
        final int _type = 77;
        final int _channel = 0;
        this.match("<<");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mRLABEL() throws RecognitionException {
        final int _type = 78;
        final int _channel = 0;
        this.match(">>");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mASSIGN() throws RecognitionException {
        final int _type = 13;
        final int _channel = 0;
        this.match(":=");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mARROW() throws RecognitionException {
        final int _type = 114;
        final int _channel = 0;
        this.match("=>");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mVERTBAR() throws RecognitionException {
        final int _type = 128;
        final int _channel = 0;
        this.match(124);
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mDOUBLEVERTBAR() throws RecognitionException {
        final int _type = 98;
        final int _channel = 0;
        this.match("||");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mNOT_EQ() throws RecognitionException {
        final int _type = 90;
        final int _channel = 0;
        int alt5 = 4;
        switch (this.input.LA(1)) {
            case 60: {
                alt5 = 1;
                break;
            }
            case 33: {
                alt5 = 2;
                break;
            }
            case 126: {
                alt5 = 3;
                break;
            }
            case 94: {
                alt5 = 4;
                break;
            }
            default: {
                final NoViableAltException nvae = new NoViableAltException("", 5, 0, (IntStream)this.input);
                throw nvae;
            }
        }
        switch (alt5) {
            case 1: {
                this.match("<>");
                break;
            }
            case 2: {
                this.match("!=");
                break;
            }
            case 3: {
                this.match("~=");
                break;
            }
            case 4: {
                this.match("^=");
                break;
            }
        }
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mLTH() throws RecognitionException {
        final int _type = 91;
        final int _channel = 0;
        this.match(60);
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mLEQ() throws RecognitionException {
        final int _type = 92;
        final int _channel = 0;
        this.match("<=");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mGTH() throws RecognitionException {
        final int _type = 93;
        final int _channel = 0;
        this.match(62);
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mGEQ() throws RecognitionException {
        final int _type = 94;
        final int _channel = 0;
        this.match(">=");
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mINTEGER() throws RecognitionException {
        final int _type = 105;
        final int _channel = 0;
        this.mN();
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mREAL_NUMBER() throws RecognitionException {
        final int _type = 106;
        final int _channel = 0;
        this.mNUMBER_VALUE();
        int alt7 = 2;
        final int LA7_0 = this.input.LA(1);
        if (LA7_0 == 101) {
            alt7 = 1;
        }
        switch (alt7) {
            case 1: {
                this.match(101);
                int alt8 = 2;
                final int LA6_0 = this.input.LA(1);
                if (LA6_0 == 43 || LA6_0 == 45) {
                    alt8 = 1;
                }
                switch (alt8) {
                    case 1: {
                        if (this.input.LA(1) == 43 || this.input.LA(1) == 45) {
                            this.input.consume();
                            break;
                        }
                        final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                        this.recover((RecognitionException)mse);
                        throw mse;
                    }
                }
                this.mN();
                break;
            }
        }
        this.state.type = _type;
        this.state.channel = _channel;
    }
    
    public final void mNUMBER_VALUE() throws RecognitionException {
        int alt9 = 3;
        alt9 = this.dfa9.predict((IntStream)this.input);
        switch (alt9) {
            case 1: {
                if (!this.numberDotValid()) {
                    throw new FailedPredicateException((IntStream)this.input, "NUMBER_VALUE", "numberDotValid()");
                }
                this.mN();
                this.mPOINT();
                int alt10 = 2;
                final int LA8_0 = this.input.LA(1);
                if (LA8_0 >= 48 && LA8_0 <= 57) {
                    alt10 = 1;
                }
                switch (alt10) {
                    case 1: {
                        this.mN();
                        break;
                    }
                }
                break;
            }
            case 2: {
                this.mPOINT();
                this.mN();
                break;
            }
            case 3: {
                this.mN();
                break;
            }
        }
    }
    
    public final void mN() throws RecognitionException {
        this.matchRange(48, 57);
        while (true) {
            int alt10 = 2;
            final int LA10_0 = this.input.LA(1);
            if (LA10_0 >= 48 && LA10_0 <= 57) {
                alt10 = 1;
            }
            switch (alt10) {
                case 1: {
                    this.matchRange(48, 57);
                    continue;
                }
                default: {}
            }
        }
    }
    
    public final void mDOUBLEQUOTED_STRING() throws RecognitionException {
        this.match(34);
        while (true) {
            int alt11 = 2;
            final int LA11_0 = this.input.LA(1);
            if ((LA11_0 >= 0 && LA11_0 <= 33) || (LA11_0 >= 35 && LA11_0 <= 65535)) {
                alt11 = 1;
            }
            switch (alt11) {
                case 1: {
                    if ((this.input.LA(1) >= 0 && this.input.LA(1) <= 33) || (this.input.LA(1) >= 35 && this.input.LA(1) <= 65535)) {
                        this.input.consume();
                        continue;
                    }
                    final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                    this.recover((RecognitionException)mse);
                    throw mse;
                }
                default: {
                    this.match(34);
                }
            }
        }
    }
    
    public final void mWS() throws RecognitionException {
        final int _type = 131;
        int _channel = 0;
        if ((this.input.LA(1) >= 9 && this.input.LA(1) <= 10) || this.input.LA(1) == 13 || this.input.LA(1) == 32) {
            this.input.consume();
            _channel = 99;
            this.state.type = _type;
            this.state.channel = _channel;
            return;
        }
        final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
        this.recover((RecognitionException)mse);
        throw mse;
    }
    
    public final void mSL_COMMENT() throws RecognitionException {
        final int _type = 132;
        int _channel = 0;
        this.match("--");
        while (true) {
            int alt12 = 2;
            final int LA12_0 = this.input.LA(1);
            if ((LA12_0 >= 0 && LA12_0 <= 9) || (LA12_0 >= 11 && LA12_0 <= 12) || (LA12_0 >= 14 && LA12_0 <= 65535)) {
                alt12 = 1;
            }
            switch (alt12) {
                case 1: {
                    if ((this.input.LA(1) >= 0 && this.input.LA(1) <= 9) || (this.input.LA(1) >= 11 && this.input.LA(1) <= 12) || (this.input.LA(1) >= 14 && this.input.LA(1) <= 65535)) {
                        this.input.consume();
                        continue;
                    }
                    final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                    this.recover((RecognitionException)mse);
                    throw mse;
                }
                default: {
                    int alt13 = 2;
                    final int LA13_0 = this.input.LA(1);
                    if (LA13_0 == 13) {
                        alt13 = 1;
                    }
                    switch (alt13) {
                        case 1: {
                            this.match(13);
                            break;
                        }
                    }
                    this.match(10);
                    _channel = 99;
                    this.state.type = _type;
                    this.state.channel = _channel;
                }
            }
        }
    }
    
    public final void mML_COMMENT() throws RecognitionException {
        final int _type = 133;
        int _channel = 0;
        this.match("/*");
        while (true) {
            int alt14 = 2;
            final int LA14_0 = this.input.LA(1);
            if (LA14_0 == 42) {
                final int LA14_2 = this.input.LA(2);
                if (LA14_2 == 47) {
                    alt14 = 2;
                }
                else if ((LA14_2 >= 0 && LA14_2 <= 46) || (LA14_2 >= 48 && LA14_2 <= 65535)) {
                    alt14 = 1;
                }
            }
            else if ((LA14_0 >= 0 && LA14_0 <= 41) || (LA14_0 >= 43 && LA14_0 <= 65535)) {
                alt14 = 1;
            }
            switch (alt14) {
                case 1: {
                    this.matchAny();
                    continue;
                }
                default: {
                    this.match("*/");
                    _channel = 99;
                    this.state.type = _type;
                    this.state.channel = _channel;
                }
            }
        }
    }
    
    public void mTokens() throws RecognitionException {
        int alt15 = 126;
        alt15 = this.dfa15.predict((IntStream)this.input);
        switch (alt15) {
            case 1: {
                this.mAND();
                break;
            }
            case 2: {
                this.mARRAY();
                break;
            }
            case 3: {
                this.mAS();
                break;
            }
            case 4: {
                this.mAUTHID();
                break;
            }
            case 5: {
                this.mBETWEEN();
                break;
            }
            case 6: {
                this.mBODY();
                break;
            }
            case 7: {
                this.mBULK();
                break;
            }
            case 8: {
                this.mBULK_ROWCOUNT();
                break;
            }
            case 9: {
                this.mBY();
                break;
            }
            case 10: {
                this.mCASE();
                break;
            }
            case 11: {
                this.mCREATE();
                break;
            }
            case 12: {
                this.mCOLLECT();
                break;
            }
            case 13: {
                this.mCOMMIT();
                break;
            }
            case 14: {
                this.mCURRENT_USER();
                break;
            }
            case 15: {
                this.mDEFAULT();
                break;
            }
            case 16: {
                this.mDEFINER();
                break;
            }
            case 17: {
                this.mDELETE();
                break;
            }
            case 18: {
                this.mELSE();
                break;
            }
            case 19: {
                this.mELSIF();
                break;
            }
            case 20: {
                this.mEXTERNAL();
                break;
            }
            case 21: {
                this.mFALSE();
                break;
            }
            case 22: {
                this.mFETCH();
                break;
            }
            case 23: {
                this.mFOR();
                break;
            }
            case 24: {
                this.mFORALL();
                break;
            }
            case 25: {
                this.mGOTO();
                break;
            }
            case 26: {
                this.mIF();
                break;
            }
            case 27: {
                this.mIN();
                break;
            }
            case 28: {
                this.mINDEX();
                break;
            }
            case 29: {
                this.mINSERT();
                break;
            }
            case 30: {
                this.mINTO();
                break;
            }
            case 31: {
                this.mIS();
                break;
            }
            case 32: {
                this.mLANGUAGE();
                break;
            }
            case 33: {
                this.mLIKE();
                break;
            }
            case 34: {
                this.mLIMIT();
                break;
            }
            case 35: {
                this.mLOCK();
                break;
            }
            case 36: {
                this.mNOT();
                break;
            }
            case 37: {
                this.mNOTFOUND();
                break;
            }
            case 38: {
                this.mNULL();
                break;
            }
            case 39: {
                this.mOPEN();
                break;
            }
            case 40: {
                this.mOR();
                break;
            }
            case 41: {
                this.mPACKAGE();
                break;
            }
            case 42: {
                this.mRAISE();
                break;
            }
            case 43: {
                this.mROLLBACK();
                break;
            }
            case 44: {
                this.mSAVEPOINT();
                break;
            }
            case 45: {
                this.mSELECT();
                break;
            }
            case 46: {
                this.mSET();
                break;
            }
            case 47: {
                this.mSQL();
                break;
            }
            case 48: {
                this.mTABLE();
                break;
            }
            case 49: {
                this.mTRANSACTION();
                break;
            }
            case 50: {
                this.mTRUE();
                break;
            }
            case 51: {
                this.mTHEN();
                break;
            }
            case 52: {
                this.mUPDATE();
                break;
            }
            case 53: {
                this.mWHILE();
                break;
            }
            case 54: {
                this.mINSERTING();
                break;
            }
            case 55: {
                this.mUPDATING();
                break;
            }
            case 56: {
                this.mDELETING();
                break;
            }
            case 57: {
                this.mISOPEN();
                break;
            }
            case 58: {
                this.mEXISTS();
                break;
            }
            case 59: {
                this.mBEGIN();
                break;
            }
            case 60: {
                this.mCLOSE();
                break;
            }
            case 61: {
                this.mCONSTANT();
                break;
            }
            case 62: {
                this.mCONTINUE();
                break;
            }
            case 63: {
                this.mCURSOR();
                break;
            }
            case 64: {
                this.mDECLARE();
                break;
            }
            case 65: {
                this.mDETERMINISTIC();
                break;
            }
            case 66: {
                this.mEND();
                break;
            }
            case 67: {
                this.mEXCEPTION();
                break;
            }
            case 68: {
                this.mEXECUTE();
                break;
            }
            case 69: {
                this.mEXIT();
                break;
            }
            case 70: {
                this.mFUNCTION();
                break;
            }
            case 71: {
                this.mIMMEDIATE();
                break;
            }
            case 72: {
                this.mLOOP();
                break;
            }
            case 73: {
                this.mNOCOPY();
                break;
            }
            case 74: {
                this.mOBJECT();
                break;
            }
            case 75: {
                this.mOTHERS();
                break;
            }
            case 76: {
                this.mOUT();
                break;
            }
            case 77: {
                this.mPARALLEL_ENABLE();
                break;
            }
            case 78: {
                this.mPIPELINED();
                break;
            }
            case 79: {
                this.mPRAGMA();
                break;
            }
            case 80: {
                this.mPROCEDURE();
                break;
            }
            case 81: {
                this.mRECORD();
                break;
            }
            case 82: {
                this.mREF();
                break;
            }
            case 83: {
                this.mRESULT_CACHE();
                break;
            }
            case 84: {
                this.mRETURN();
                break;
            }
            case 85: {
                this.mRETURNING();
                break;
            }
            case 86: {
                this.mROWTYPE();
                break;
            }
            case 87: {
                this.mSUBTYPE();
                break;
            }
            case 88: {
                this.mUSING();
                break;
            }
            case 89: {
                this.mVARRAY();
                break;
            }
            case 90: {
                this.mVARYING();
                break;
            }
            case 91: {
                this.mWHEN();
                break;
            }
            case 92: {
                this.mQUOTED_STRING();
                break;
            }
            case 93: {
                this.mID();
                break;
            }
            case 94: {
                this.mSEMI();
                break;
            }
            case 95: {
                this.mCOLON();
                break;
            }
            case 96: {
                this.mDOUBLEDOT();
                break;
            }
            case 97: {
                this.mDOT();
                break;
            }
            case 98: {
                this.mCOMMA();
                break;
            }
            case 99: {
                this.mEXPONENT();
                break;
            }
            case 100: {
                this.mASTERISK();
                break;
            }
            case 101: {
                this.mAT_SIGN();
                break;
            }
            case 102: {
                this.mRPAREN();
                break;
            }
            case 103: {
                this.mLPAREN();
                break;
            }
            case 104: {
                this.mRBRACK();
                break;
            }
            case 105: {
                this.mLBRACK();
                break;
            }
            case 106: {
                this.mPLUS();
                break;
            }
            case 107: {
                this.mMINUS();
                break;
            }
            case 108: {
                this.mDIVIDE();
                break;
            }
            case 109: {
                this.mEQ();
                break;
            }
            case 110: {
                this.mPERCENT();
                break;
            }
            case 111: {
                this.mLLABEL();
                break;
            }
            case 112: {
                this.mRLABEL();
                break;
            }
            case 113: {
                this.mASSIGN();
                break;
            }
            case 114: {
                this.mARROW();
                break;
            }
            case 115: {
                this.mVERTBAR();
                break;
            }
            case 116: {
                this.mDOUBLEVERTBAR();
                break;
            }
            case 117: {
                this.mNOT_EQ();
                break;
            }
            case 118: {
                this.mLTH();
                break;
            }
            case 119: {
                this.mLEQ();
                break;
            }
            case 120: {
                this.mGTH();
                break;
            }
            case 121: {
                this.mGEQ();
                break;
            }
            case 122: {
                this.mINTEGER();
                break;
            }
            case 123: {
                this.mREAL_NUMBER();
                break;
            }
            case 124: {
                this.mWS();
                break;
            }
            case 125: {
                this.mSL_COMMENT();
                break;
            }
            case 126: {
                this.mML_COMMENT();
                break;
            }
        }
    }
    
    class DFA9 extends DFA
    {
        public DFA9(final BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = PLSQL2Lexer.DFA9_eot;
            this.eof = PLSQL2Lexer.DFA9_eof;
            this.min = PLSQL2Lexer.DFA9_min;
            this.max = PLSQL2Lexer.DFA9_max;
            this.accept = PLSQL2Lexer.DFA9_accept;
            this.special = PLSQL2Lexer.DFA9_special;
            this.transition = PLSQL2Lexer.DFA9_transition;
        }
        
        public String getDescription() {
            return "996:1: fragment NUMBER_VALUE : ({...}? => N POINT ( N )? | POINT N | N );";
        }
        
        public int specialStateTransition(int s, final IntStream _input) throws NoViableAltException {
            final IntStream input = _input;
            final int _s = s;
            switch (s) {
                case 0: {
                    final int LA9_1 = input.LA(1);
                    final int index9_1 = input.index();
                    input.rewind();
                    s = -1;
                    if (LA9_1 >= 48 && LA9_1 <= 57) {
                        s = 3;
                    }
                    else if (LA9_1 == 46 && PLSQL2Lexer.this.numberDotValid()) {
                        s = 5;
                    }
                    else {
                        s = 4;
                    }
                    input.seek(index9_1);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                }
                case 1: {
                    final int LA9_2 = input.LA(1);
                    final int index9_2 = input.index();
                    input.rewind();
                    s = -1;
                    if (LA9_2 == 46 && PLSQL2Lexer.this.numberDotValid()) {
                        s = 5;
                    }
                    else if (LA9_2 >= 48 && LA9_2 <= 57) {
                        s = 3;
                    }
                    else {
                        s = 4;
                    }
                    input.seek(index9_2);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                }
            }
            final NoViableAltException nvae = new NoViableAltException(this.getDescription(), 9, _s, input);
            this.error(nvae);
            throw nvae;
        }
    }
    
    class DFA15 extends DFA
    {
        public DFA15(final BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = PLSQL2Lexer.DFA15_eot;
            this.eof = PLSQL2Lexer.DFA15_eof;
            this.min = PLSQL2Lexer.DFA15_min;
            this.max = PLSQL2Lexer.DFA15_max;
            this.accept = PLSQL2Lexer.DFA15_accept;
            this.special = PLSQL2Lexer.DFA15_special;
            this.transition = PLSQL2Lexer.DFA15_transition;
        }
        
        public String getDescription() {
            return "1:1: Tokens : ( AND | ARRAY | AS | AUTHID | BETWEEN | BODY | BULK | BULK_ROWCOUNT | BY | CASE | CREATE | COLLECT | COMMIT | CURRENT_USER | DEFAULT | DEFINER | DELETE | ELSE | ELSIF | EXTERNAL | FALSE | FETCH | FOR | FORALL | GOTO | IF | IN | INDEX | INSERT | INTO | IS | LANGUAGE | LIKE | LIMIT | LOCK | NOT | NOTFOUND | NULL | OPEN | OR | PACKAGE | RAISE | ROLLBACK | SAVEPOINT | SELECT | SET | SQL | TABLE | TRANSACTION | TRUE | THEN | UPDATE | WHILE | INSERTING | UPDATING | DELETING | ISOPEN | EXISTS | BEGIN | CLOSE | CONSTANT | CONTINUE | CURSOR | DECLARE | DETERMINISTIC | END | EXCEPTION | EXECUTE | EXIT | FUNCTION | IMMEDIATE | LOOP | NOCOPY | OBJECT | OTHERS | OUT | PARALLEL_ENABLE | PIPELINED | PRAGMA | PROCEDURE | RECORD | REF | RESULT_CACHE | RETURN | RETURNING | ROWTYPE | SUBTYPE | USING | VARRAY | VARYING | WHEN | QUOTED_STRING | ID | SEMI | COLON | DOUBLEDOT | DOT | COMMA | EXPONENT | ASTERISK | AT_SIGN | RPAREN | LPAREN | RBRACK | LBRACK | PLUS | MINUS | DIVIDE | EQ | PERCENT | LLABEL | RLABEL | ASSIGN | ARROW | VERTBAR | DOUBLEVERTBAR | NOT_EQ | LTH | LEQ | GTH | GEQ | INTEGER | REAL_NUMBER | WS | SL_COMMENT | ML_COMMENT );";
        }
        
        public int specialStateTransition(int s, final IntStream _input) throws NoViableAltException {
            final IntStream input = _input;
            final int _s = s;
            switch (s) {
                case 0: {
                    final int LA15_116 = input.LA(1);
                    final int index15_116 = input.index();
                    input.rewind();
                    s = -1;
                    if (LA15_116 == 46 && PLSQL2Lexer.this.numberDotValid()) {
                        s = 118;
                    }
                    else if (LA15_116 >= 48 && LA15_116 <= 57) {
                        s = 116;
                    }
                    else if (LA15_116 == 101) {
                        s = 119;
                    }
                    else {
                        s = 117;
                    }
                    input.seek(index15_116);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                }
                case 1: {
                    final int LA15_117 = input.LA(1);
                    final int index15_117 = input.index();
                    input.rewind();
                    s = -1;
                    if (LA15_117 >= 48 && LA15_117 <= 57) {
                        s = 116;
                    }
                    else if (LA15_117 == 46 && PLSQL2Lexer.this.numberDotValid()) {
                        s = 118;
                    }
                    else if (LA15_117 == 101) {
                        s = 119;
                    }
                    else {
                        s = 117;
                    }
                    input.seek(index15_117);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                }
            }
            final NoViableAltException nvae = new NoViableAltException(this.getDescription(), 15, _s, input);
            this.error(nvae);
            throw nvae;
        }
    }
}
