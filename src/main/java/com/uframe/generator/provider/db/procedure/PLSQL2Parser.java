package com.uframe.generator.provider.db.procedure;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.tree.*;
import java.util.*;
import org.antlr.runtime.*;

public class PLSQL2Parser extends Parser
{
    public static final String[] tokenNames;
    public static final int PACKAGE = 116;
    public static final int FUNCTION = 8;
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
    public static final int BEGIN = 42;
    public static final int LOOP = 50;
    public static final int SAVEPOINT = 83;
    public static final int RETURN = 9;
    public static final int BODY = 117;
    public static final int RAISE = 75;
    public static final int GEQ = 94;
    public static final int GOTO = 70;
    public static final int EQ = 89;
    public static final int SELECT = 84;
    public static final int ISOPEN = 103;
    public static final int INTO = 60;
    public static final int ARRAY = 29;
    public static final int DIVIDE = 4;
    public static final int EXCEPTION = 23;
    public static final int RBRACK = 126;
    public static final int EXIT = 57;
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
    public static final int IN = 15;
    public static final int THEN = 47;
    public static final int OBJECT = 27;
    public static final int CONTINUE = 54;
    public static final int COMMA = 11;
    public static final int IS = 19;
    public static final int QUOTED_STRING = 109;
    public static final int PLUS = 97;
    public static final int EXISTS = 110;
    public static final int DOT = 35;
    public static final int LIKE = 95;
    public static final int INTEGER = 105;
    public static final int BY = 33;
    public static final int VARRAY = 30;
    public static final int PARALLEL_ENABLE = 40;
    public static final int PERCENT = 36;
    public static final int DOUBLEQUOTED_STRING = 123;
    public static final int DEFAULT = 14;
    public static final int FORALL = 66;
    public static final int SET = 85;
    public static final int MINUS = 96;
    public static final int TRUE = 107;
    public static final int SEMI = 5;
    public static final int PROCEDURE = 6;
    public static final int NOT_EQ = 90;
    public static final int REF = 34;
    public static final int VERTBAR = 128;
    public static final int COLON = 48;
    public static final int OPEN = 73;
    public static final int LTH = 91;
    public static final int BULK_ROWCOUNT = 102;
    public static final int COMMIT = 79;
    public static final int CLOSE = 53;
    public static final int WHEN = 44;
    public static final int ASSIGN = 13;
    public static final int NUMBER_VALUE = 130;
    public static final int IMMEDIATE = 56;
    public static final int ARROW = 114;
    public static final int DECLARE = 76;
    public static final int DELETING = 113;
    public static final int BULK = 61;
    public static final int BETWEEN = 68;
    public static final int LEQ = 92;
    protected TreeAdaptor adaptor;
    private List m_procedureList;
    private List m_functionList;
    private List m_typeList;
    protected DFA5 dfa5;
    protected DFA15 dfa15;
    protected DFA96 dfa96;
    protected DFA139 dfa139;
    static final String DFA5_eotS = "\n\uffff";
    static final String DFA5_eofS = "\n\uffff";
    static final String DFA5_minS = "\u0001s\u0001\u0006\u0001\u0007\u0001\uffff\u0001\u0007\u0002\uffff\u0001\u0006\u0002\uffff";
    static final String DFA5_maxS = "\u0001s\u0001t\u0001\u0007\u0001\uffff\u0001u\u0002\uffff\u0001t\u0002\uffff";
    static final String DFA5_acceptS = "\u0003\uffff\u0001\u0003\u0001\uffff\u0001\u0005\u0001\u0004\u0001\uffff\u0001\u0002\u0001\u0001";
    static final String DFA5_specialS = "\n\uffff}>";
    static final String[] DFA5_transitionS;
    static final short[] DFA5_eot;
    static final short[] DFA5_eof;
    static final char[] DFA5_min;
    static final char[] DFA5_max;
    static final short[] DFA5_accept;
    static final short[] DFA5_special;
    static final short[][] DFA5_transition;
    static final String DFA15_eotS = "\u000b\uffff";
    static final String DFA15_eofS = "\u000b\uffff";
    static final String DFA15_minS = "\u0001\u0006\u0001\uffff\u0001\u0007\u0006\uffff\u0001\u0005\u0001\uffff";
    static final String DFA15_maxS = "\u0001J\u0001\uffff\u0001\"\u0006\uffff\u0001$\u0001\uffff";
    static final String DFA15_acceptS = "\u0001\uffff\u0001\b\u0001\uffff\u0001\u0002\u0001\u0003\u0001\u0005\u0001\u0006\u0001\u0007\u0001\u0004\u0001\uffff\u0001\u0001";
    static final String DFA15_specialS = "\u000b\uffff}>";
    static final String[] DFA15_transitionS;
    static final short[] DFA15_eot;
    static final short[] DFA15_eof;
    static final char[] DFA15_min;
    static final char[] DFA15_max;
    static final short[] DFA15_accept;
    static final short[] DFA15_special;
    static final short[][] DFA15_transition;
    static final String DFA96_eotS = "\u000f\uffff";
    static final String DFA96_eofS = "\u000f\uffff";
    static final String DFA96_minS = "\u0001\u0007\u0002\uffff\u0001\u0000\u000b\uffff";
    static final String DFA96_maxS = "\u0001q\u0002\uffff\u0001\u0000\u000b\uffff";
    static final String DFA96_acceptS = "\u0001\uffff\u0001\u0001\u000b\uffff\u0001\u0002\u0001\u0003";
    static final String DFA96_specialS = "\u0003\uffff\u0001\u0000\u000b\uffff}>";
    static final String[] DFA96_transitionS;
    static final short[] DFA96_eot;
    static final short[] DFA96_eof;
    static final char[] DFA96_min;
    static final char[] DFA96_max;
    static final short[] DFA96_accept;
    static final short[] DFA96_special;
    static final short[][] DFA96_transition;
    static final String DFA139_eotS = "\n\uffff";
    static final String DFA139_eofS = "\u0002\uffff\u0001\u0001\u0007\uffff";
    static final String DFA139_minS = "\u0001\u0007\u0001\uffff\u0001\u0004\u0006\uffff\u0001\u0007";
    static final String DFA139_maxS = "\u0001q\u0001\uffff\u0001d\u0006\uffff\u0001n";
    static final String DFA139_acceptS = "\u0001\uffff\u0001\u0001\u0001\uffff\u0001\u0002\u0001\u0003\u0001\u0004\u0001\u0005\u0001\u0006\u0001\u0007\u0001\uffff";
    static final String DFA139_specialS = "\n\uffff}>";
    static final String[] DFA139_transitionS;
    static final short[] DFA139_eot;
    static final short[] DFA139_eof;
    static final char[] DFA139_min;
    static final char[] DFA139_max;
    static final short[] DFA139_accept;
    static final short[] DFA139_special;
    static final short[][] DFA139_transition;
    public static final BitSet FOLLOW_create_object_in_sqlplus_file62;
    public static final BitSet FOLLOW_DIVIDE_in_sqlplus_file66;
    public static final BitSet FOLLOW_show_errors_in_sqlplus_file68;
    public static final BitSet FOLLOW_DIVIDE_in_sqlplus_file73;
    public static final BitSet FOLLOW_EOF_in_sqlplus_file79;
    public static final BitSet FOLLOW_kSHOW_in_show_errors100;
    public static final BitSet FOLLOW_kERRORS_in_show_errors102;
    public static final BitSet FOLLOW_SEMI_in_show_errors104;
    public static final BitSet FOLLOW_create_package_in_create_object122;
    public static final BitSet FOLLOW_create_package_body_in_create_object130;
    public static final BitSet FOLLOW_create_function_in_create_object138;
    public static final BitSet FOLLOW_create_procedure_in_create_object146;
    public static final BitSet FOLLOW_create_type_in_create_object154;
    public static final BitSet FOLLOW_PROCEDURE_in_procedure_heading182;
    public static final BitSet FOLLOW_ID_in_procedure_heading184;
    public static final BitSet FOLLOW_parameter_declarations_in_procedure_heading207;
    public static final BitSet FOLLOW_FUNCTION_in_function_heading282;
    public static final BitSet FOLLOW_ID_in_function_heading284;
    public static final BitSet FOLLOW_parameter_declarations_in_function_heading306;
    public static final BitSet FOLLOW_RETURN_in_function_heading327;
    public static final BitSet FOLLOW_datatype_in_function_heading329;
    public static final BitSet FOLLOW_LPAREN_in_parameter_declarations405;
    public static final BitSet FOLLOW_parameter_declaration_in_parameter_declarations410;
    public static final BitSet FOLLOW_COMMA_in_parameter_declarations434;
    public static final BitSet FOLLOW_parameter_declaration_in_parameter_declarations439;
    public static final BitSet FOLLOW_RPAREN_in_parameter_declarations466;
    public static final BitSet FOLLOW_ID_in_parameter_declaration522;
    public static final BitSet FOLLOW_param_type_in_parameter_declaration524;
    public static final BitSet FOLLOW_datatype_in_parameter_declaration527;
    public static final BitSet FOLLOW_ASSIGN_in_parameter_declaration542;
    public static final BitSet FOLLOW_DEFAULT_in_parameter_declaration546;
    public static final BitSet FOLLOW_expression_in_parameter_declaration550;
    public static final BitSet FOLLOW_IN_in_param_type681;
    public static final BitSet FOLLOW_OUT_in_param_type689;
    public static final BitSet FOLLOW_IN_in_param_type693;
    public static final BitSet FOLLOW_OUT_in_param_type695;
    public static final BitSet FOLLOW_NOCOPY_in_param_type699;
    public static final BitSet FOLLOW_type_definition_in_declare_section729;
    public static final BitSet FOLLOW_SEMI_in_declare_section731;
    public static final BitSet FOLLOW_subtype_definition_in_declare_section743;
    public static final BitSet FOLLOW_SEMI_in_declare_section745;
    public static final BitSet FOLLOW_cursor_definition_in_declare_section754;
    public static final BitSet FOLLOW_SEMI_in_declare_section756;
    public static final BitSet FOLLOW_item_declaration_in_declare_section765;
    public static final BitSet FOLLOW_SEMI_in_declare_section767;
    public static final BitSet FOLLOW_function_declaration_or_definition_in_declare_section776;
    public static final BitSet FOLLOW_SEMI_in_declare_section778;
    public static final BitSet FOLLOW_procedure_declaration_or_definition_in_declare_section789;
    public static final BitSet FOLLOW_SEMI_in_declare_section791;
    public static final BitSet FOLLOW_pragma_in_declare_section802;
    public static final BitSet FOLLOW_SEMI_in_declare_section804;
    public static final BitSet FOLLOW_CURSOR_in_cursor_definition833;
    public static final BitSet FOLLOW_ID_in_cursor_definition835;
    public static final BitSet FOLLOW_parameter_declarations_in_cursor_definition837;
    public static final BitSet FOLLOW_IS_in_cursor_definition840;
    public static final BitSet FOLLOW_select_statement_in_cursor_definition842;
    public static final BitSet FOLLOW_variable_declaration_in_item_declaration859;
    public static final BitSet FOLLOW_constant_declaration_in_item_declaration867;
    public static final BitSet FOLLOW_exception_declaration_in_item_declaration875;
    public static final BitSet FOLLOW_ID_in_variable_declaration896;
    public static final BitSet FOLLOW_datatype_in_variable_declaration898;
    public static final BitSet FOLLOW_NOT_in_variable_declaration906;
    public static final BitSet FOLLOW_NULL_in_variable_declaration908;
    public static final BitSet FOLLOW_set_in_variable_declaration913;
    public static final BitSet FOLLOW_expression_in_variable_declaration925;
    public static final BitSet FOLLOW_ID_in_constant_declaration950;
    public static final BitSet FOLLOW_CONSTANT_in_constant_declaration952;
    public static final BitSet FOLLOW_datatype_in_constant_declaration954;
    public static final BitSet FOLLOW_NOT_in_constant_declaration958;
    public static final BitSet FOLLOW_NULL_in_constant_declaration960;
    public static final BitSet FOLLOW_set_in_constant_declaration965;
    public static final BitSet FOLLOW_expression_in_constant_declaration979;
    public static final BitSet FOLLOW_ID_in_exception_declaration1000;
    public static final BitSet FOLLOW_EXCEPTION_in_exception_declaration1002;
    public static final BitSet FOLLOW_kTYPE_in_type_definition1029;
    public static final BitSet FOLLOW_ID_in_type_definition1031;
    public static final BitSet FOLLOW_set_in_type_definition1052;
    public static final BitSet FOLLOW_record_type_definition_in_type_definition1062;
    public static final BitSet FOLLOW_collection_type_definition_in_type_definition1066;
    public static final BitSet FOLLOW_ref_cursor_type_definition_in_type_definition1104;
    public static final BitSet FOLLOW_object_type_definition_in_type_definition1119;
    public static final BitSet FOLLOW_SUBTYPE_in_subtype_definition1178;
    public static final BitSet FOLLOW_ID_in_subtype_definition1180;
    public static final BitSet FOLLOW_IS_in_subtype_definition1182;
    public static final BitSet FOLLOW_datatype_in_subtype_definition1184;
    public static final BitSet FOLLOW_NOT_in_subtype_definition1188;
    public static final BitSet FOLLOW_NULL_in_subtype_definition1190;
    public static final BitSet FOLLOW_RECORD_in_record_type_definition1211;
    public static final BitSet FOLLOW_LPAREN_in_record_type_definition1213;
    public static final BitSet FOLLOW_record_field_declaration_in_record_type_definition1215;
    public static final BitSet FOLLOW_COMMA_in_record_type_definition1219;
    public static final BitSet FOLLOW_record_field_declaration_in_record_type_definition1221;
    public static final BitSet FOLLOW_RPAREN_in_record_type_definition1226;
    public static final BitSet FOLLOW_ID_in_record_field_declaration1250;
    public static final BitSet FOLLOW_datatype_in_record_field_declaration1257;
    public static final BitSet FOLLOW_NOT_in_record_field_declaration1268;
    public static final BitSet FOLLOW_NULL_in_record_field_declaration1270;
    public static final BitSet FOLLOW_set_in_record_field_declaration1275;
    public static final BitSet FOLLOW_expression_in_record_field_declaration1285;
    public static final BitSet FOLLOW_OBJECT_in_object_type_definition1315;
    public static final BitSet FOLLOW_LPAREN_in_object_type_definition1317;
    public static final BitSet FOLLOW_record_field_declaration_in_object_type_definition1321;
    public static final BitSet FOLLOW_COMMA_in_object_type_definition1336;
    public static final BitSet FOLLOW_record_field_declaration_in_object_type_definition1340;
    public static final BitSet FOLLOW_RPAREN_in_object_type_definition1360;
    public static final BitSet FOLLOW_varray_type_definition_in_collection_type_definition1388;
    public static final BitSet FOLLOW_nested_table_type_definition_in_collection_type_definition1394;
    public static final BitSet FOLLOW_VARYING_in_varray_type_definition1412;
    public static final BitSet FOLLOW_ARRAY_in_varray_type_definition1414;
    public static final BitSet FOLLOW_VARRAY_in_varray_type_definition1419;
    public static final BitSet FOLLOW_LPAREN_in_varray_type_definition1423;
    public static final BitSet FOLLOW_numeric_literal_in_varray_type_definition1425;
    public static final BitSet FOLLOW_RPAREN_in_varray_type_definition1427;
    public static final BitSet FOLLOW_kOF_in_varray_type_definition1429;
    public static final BitSet FOLLOW_datatype_in_varray_type_definition1431;
    public static final BitSet FOLLOW_NOT_in_varray_type_definition1435;
    public static final BitSet FOLLOW_NULL_in_varray_type_definition1437;
    public static final BitSet FOLLOW_TABLE_in_nested_table_type_definition1461;
    public static final BitSet FOLLOW_kOF_in_nested_table_type_definition1463;
    public static final BitSet FOLLOW_datatype_in_nested_table_type_definition1465;
    public static final BitSet FOLLOW_NOT_in_nested_table_type_definition1474;
    public static final BitSet FOLLOW_NULL_in_nested_table_type_definition1476;
    public static final BitSet FOLLOW_INDEX_in_nested_table_type_definition1483;
    public static final BitSet FOLLOW_BY_in_nested_table_type_definition1485;
    public static final BitSet FOLLOW_associative_index_type_in_nested_table_type_definition1487;
    public static final BitSet FOLLOW_datatype_in_associative_index_type1501;
    public static final BitSet FOLLOW_REF_in_ref_cursor_type_definition1512;
    public static final BitSet FOLLOW_CURSOR_in_ref_cursor_type_definition1514;
    public static final BitSet FOLLOW_RETURN_in_ref_cursor_type_definition1518;
    public static final BitSet FOLLOW_datatype_in_ref_cursor_type_definition1520;
    public static final BitSet FOLLOW_REF_in_datatype1539;
    public static final BitSet FOLLOW_ID_in_datatype1544;
    public static final BitSet FOLLOW_DOT_in_datatype1548;
    public static final BitSet FOLLOW_ID_in_datatype1550;
    public static final BitSet FOLLOW_LPAREN_in_datatype1557;
    public static final BitSet FOLLOW_numeric_literal_in_datatype1559;
    public static final BitSet FOLLOW_COMMA_in_datatype1563;
    public static final BitSet FOLLOW_numeric_literal_in_datatype1565;
    public static final BitSet FOLLOW_RPAREN_in_datatype1570;
    public static final BitSet FOLLOW_PERCENT_in_datatype1574;
    public static final BitSet FOLLOW_kTYPE_in_datatype1578;
    public static final BitSet FOLLOW_ROWTYPE_in_datatype1582;
    public static final BitSet FOLLOW_function_heading_in_function_declaration_or_definition1612;
    public static final BitSet FOLLOW_set_in_function_declaration_or_definition1622;
    public static final BitSet FOLLOW_set_in_function_declaration_or_definition1651;
    public static final BitSet FOLLOW_declare_section_in_function_declaration_or_definition1661;
    public static final BitSet FOLLOW_body_in_function_declaration_or_definition1664;
    public static final BitSet FOLLOW_function_heading_in_function_declaration1687;
    public static final BitSet FOLLOW_set_in_function_declaration1697;
    public static final BitSet FOLLOW_function_heading_in_function_definition1735;
    public static final BitSet FOLLOW_set_in_function_definition1745;
    public static final BitSet FOLLOW_set_in_function_definition1772;
    public static final BitSet FOLLOW_declare_section_in_function_definition1782;
    public static final BitSet FOLLOW_body_in_function_definition1785;
    public static final BitSet FOLLOW_procedure_heading_in_procedure_declaration_or_definition1807;
    public static final BitSet FOLLOW_set_in_procedure_declaration_or_definition1819;
    public static final BitSet FOLLOW_declare_section_in_procedure_declaration_or_definition1829;
    public static final BitSet FOLLOW_body_in_procedure_declaration_or_definition1832;
    public static final BitSet FOLLOW_procedure_heading_in_procedure_declaration1852;
    public static final BitSet FOLLOW_procedure_heading_in_procedure_definition1863;
    public static final BitSet FOLLOW_set_in_procedure_definition1866;
    public static final BitSet FOLLOW_declare_section_in_procedure_definition1876;
    public static final BitSet FOLLOW_body_in_procedure_definition1879;
    public static final BitSet FOLLOW_BEGIN_in_body1893;
    public static final BitSet FOLLOW_statement_in_body1895;
    public static final BitSet FOLLOW_SEMI_in_body1897;
    public static final BitSet FOLLOW_statement_in_body1901;
    public static final BitSet FOLLOW_SEMI_in_body1903;
    public static final BitSet FOLLOW_pragma_in_body1907;
    public static final BitSet FOLLOW_SEMI_in_body1909;
    public static final BitSet FOLLOW_EXCEPTION_in_body1917;
    public static final BitSet FOLLOW_exception_handler_in_body1919;
    public static final BitSet FOLLOW_END_in_body1925;
    public static final BitSet FOLLOW_ID_in_body1927;
    public static final BitSet FOLLOW_WHEN_in_exception_handler1939;
    public static final BitSet FOLLOW_qual_id_in_exception_handler1943;
    public static final BitSet FOLLOW_OR_in_exception_handler1947;
    public static final BitSet FOLLOW_qual_id_in_exception_handler1949;
    public static final BitSet FOLLOW_OTHERS_in_exception_handler1956;
    public static final BitSet FOLLOW_THEN_in_exception_handler1962;
    public static final BitSet FOLLOW_statement_in_exception_handler1966;
    public static final BitSet FOLLOW_SEMI_in_exception_handler1968;
    public static final BitSet FOLLOW_label_in_statement1986;
    public static final BitSet FOLLOW_assign_or_call_statement_in_statement1995;
    public static final BitSet FOLLOW_case_statement_in_statement2003;
    public static final BitSet FOLLOW_close_statement_in_statement2011;
    public static final BitSet FOLLOW_continue_statement_in_statement2019;
    public static final BitSet FOLLOW_basic_loop_statement_in_statement2027;
    public static final BitSet FOLLOW_execute_immediate_statement_in_statement2035;
    public static final BitSet FOLLOW_exit_statement_in_statement2043;
    public static final BitSet FOLLOW_fetch_statement_in_statement2051;
    public static final BitSet FOLLOW_for_loop_statement_in_statement2059;
    public static final BitSet FOLLOW_forall_statement_in_statement2067;
    public static final BitSet FOLLOW_goto_statement_in_statement2075;
    public static final BitSet FOLLOW_if_statement_in_statement2083;
    public static final BitSet FOLLOW_null_statement_in_statement2091;
    public static final BitSet FOLLOW_open_statement_in_statement2099;
    public static final BitSet FOLLOW_plsql_block_in_statement2107;
    public static final BitSet FOLLOW_raise_statement_in_statement2115;
    public static final BitSet FOLLOW_return_statement_in_statement2123;
    public static final BitSet FOLLOW_sql_statement_in_statement2131;
    public static final BitSet FOLLOW_while_loop_statement_in_statement2139;
    public static final BitSet FOLLOW_call_in_lvalue2162;
    public static final BitSet FOLLOW_DOT_in_lvalue2166;
    public static final BitSet FOLLOW_call_in_lvalue2168;
    public static final BitSet FOLLOW_lvalue_in_assign_or_call_statement2188;
    public static final BitSet FOLLOW_DOT_in_assign_or_call_statement2192;
    public static final BitSet FOLLOW_delete_call_in_assign_or_call_statement2194;
    public static final BitSet FOLLOW_ASSIGN_in_assign_or_call_statement2198;
    public static final BitSet FOLLOW_expression_in_assign_or_call_statement2200;
    public static final BitSet FOLLOW_COLON_in_call2220;
    public static final BitSet FOLLOW_ID_in_call2223;
    public static final BitSet FOLLOW_LPAREN_in_call2227;
    public static final BitSet FOLLOW_parameter_in_call2231;
    public static final BitSet FOLLOW_COMMA_in_call2235;
    public static final BitSet FOLLOW_parameter_in_call2237;
    public static final BitSet FOLLOW_RPAREN_in_call2245;
    public static final BitSet FOLLOW_DELETE_in_delete_call2265;
    public static final BitSet FOLLOW_LPAREN_in_delete_call2269;
    public static final BitSet FOLLOW_parameter_in_delete_call2271;
    public static final BitSet FOLLOW_RPAREN_in_delete_call2274;
    public static final BitSet FOLLOW_LOOP_in_basic_loop_statement2298;
    public static final BitSet FOLLOW_statement_in_basic_loop_statement2302;
    public static final BitSet FOLLOW_SEMI_in_basic_loop_statement2304;
    public static final BitSet FOLLOW_END_in_basic_loop_statement2309;
    public static final BitSet FOLLOW_LOOP_in_basic_loop_statement2311;
    public static final BitSet FOLLOW_label_name_in_basic_loop_statement2313;
    public static final BitSet FOLLOW_CASE_in_case_statement2335;
    public static final BitSet FOLLOW_expression_in_case_statement2337;
    public static final BitSet FOLLOW_WHEN_in_case_statement2350;
    public static final BitSet FOLLOW_expression_in_case_statement2352;
    public static final BitSet FOLLOW_THEN_in_case_statement2354;
    public static final BitSet FOLLOW_statement_in_case_statement2358;
    public static final BitSet FOLLOW_SEMI_in_case_statement2360;
    public static final BitSet FOLLOW_ELSE_in_case_statement2378;
    public static final BitSet FOLLOW_statement_in_case_statement2380;
    public static final BitSet FOLLOW_SEMI_in_case_statement2382;
    public static final BitSet FOLLOW_END_in_case_statement2395;
    public static final BitSet FOLLOW_CASE_in_case_statement2397;
    public static final BitSet FOLLOW_label_name_in_case_statement2399;
    public static final BitSet FOLLOW_CLOSE_in_close_statement2421;
    public static final BitSet FOLLOW_ID_in_close_statement2423;
    public static final BitSet FOLLOW_DOT_in_close_statement2427;
    public static final BitSet FOLLOW_ID_in_close_statement2429;
    public static final BitSet FOLLOW_CONTINUE_in_continue_statement2453;
    public static final BitSet FOLLOW_ID_in_continue_statement2459;
    public static final BitSet FOLLOW_WHEN_in_continue_statement2466;
    public static final BitSet FOLLOW_expression_in_continue_statement2468;
    public static final BitSet FOLLOW_EXECUTE_in_execute_immediate_statement2492;
    public static final BitSet FOLLOW_IMMEDIATE_in_execute_immediate_statement2494;
    public static final BitSet FOLLOW_expression_in_execute_immediate_statement2496;
    public static final BitSet FOLLOW_into_clause_in_execute_immediate_statement2510;
    public static final BitSet FOLLOW_bulk_collect_into_clause_in_execute_immediate_statement2514;
    public static final BitSet FOLLOW_using_clause_in_execute_immediate_statement2517;
    public static final BitSet FOLLOW_using_clause_in_execute_immediate_statement2530;
    public static final BitSet FOLLOW_dynamic_returning_clause_in_execute_immediate_statement2532;
    public static final BitSet FOLLOW_dynamic_returning_clause_in_execute_immediate_statement2545;
    public static final BitSet FOLLOW_EXIT_in_exit_statement2577;
    public static final BitSet FOLLOW_ID_in_exit_statement2583;
    public static final BitSet FOLLOW_WHEN_in_exit_statement2590;
    public static final BitSet FOLLOW_expression_in_exit_statement2592;
    public static final BitSet FOLLOW_FETCH_in_fetch_statement2616;
    public static final BitSet FOLLOW_qual_id_in_fetch_statement2618;
    public static final BitSet FOLLOW_into_clause_in_fetch_statement2622;
    public static final BitSet FOLLOW_bulk_collect_into_clause_in_fetch_statement2626;
    public static final BitSet FOLLOW_LIMIT_in_fetch_statement2630;
    public static final BitSet FOLLOW_numeric_expression_in_fetch_statement2632;
    public static final BitSet FOLLOW_INTO_in_into_clause2662;
    public static final BitSet FOLLOW_lvalue_in_into_clause2664;
    public static final BitSet FOLLOW_COMMA_in_into_clause2668;
    public static final BitSet FOLLOW_lvalue_in_into_clause2670;
    public static final BitSet FOLLOW_BULK_in_bulk_collect_into_clause2698;
    public static final BitSet FOLLOW_COLLECT_in_bulk_collect_into_clause2700;
    public static final BitSet FOLLOW_INTO_in_bulk_collect_into_clause2702;
    public static final BitSet FOLLOW_lvalue_in_bulk_collect_into_clause2704;
    public static final BitSet FOLLOW_COMMA_in_bulk_collect_into_clause2708;
    public static final BitSet FOLLOW_lvalue_in_bulk_collect_into_clause2710;
    public static final BitSet FOLLOW_USING_in_using_clause2734;
    public static final BitSet FOLLOW_param_modifiers_in_using_clause2736;
    public static final BitSet FOLLOW_expression_in_using_clause2739;
    public static final BitSet FOLLOW_COMMA_in_using_clause2743;
    public static final BitSet FOLLOW_param_modifiers_in_using_clause2745;
    public static final BitSet FOLLOW_expression_in_using_clause2748;
    public static final BitSet FOLLOW_IN_in_param_modifiers2765;
    public static final BitSet FOLLOW_OUT_in_param_modifiers2767;
    public static final BitSet FOLLOW_OUT_in_param_modifiers2772;
    public static final BitSet FOLLOW_set_in_dynamic_returning_clause2790;
    public static final BitSet FOLLOW_into_clause_in_dynamic_returning_clause2802;
    public static final BitSet FOLLOW_bulk_collect_into_clause_in_dynamic_returning_clause2806;
    public static final BitSet FOLLOW_FOR_in_for_loop_statement2829;
    public static final BitSet FOLLOW_ID_in_for_loop_statement2831;
    public static final BitSet FOLLOW_IN_in_for_loop_statement2833;
    public static final BitSet FOLLOW_set_in_for_loop_statement2837;
    public static final BitSet FOLLOW_LOOP_in_for_loop_statement2845;
    public static final BitSet FOLLOW_statement_in_for_loop_statement2849;
    public static final BitSet FOLLOW_SEMI_in_for_loop_statement2851;
    public static final BitSet FOLLOW_END_in_for_loop_statement2856;
    public static final BitSet FOLLOW_LOOP_in_for_loop_statement2858;
    public static final BitSet FOLLOW_label_name_in_for_loop_statement2860;
    public static final BitSet FOLLOW_FORALL_in_forall_statement2882;
    public static final BitSet FOLLOW_ID_in_forall_statement2884;
    public static final BitSet FOLLOW_IN_in_forall_statement2886;
    public static final BitSet FOLLOW_bounds_clause_in_forall_statement2888;
    public static final BitSet FOLLOW_sql_statement_in_forall_statement2890;
    public static final BitSet FOLLOW_kSAVE_in_forall_statement2894;
    public static final BitSet FOLLOW_kEXCEPTIONS_in_forall_statement2896;
    public static final BitSet FOLLOW_numeric_expression_in_bounds_clause2918;
    public static final BitSet FOLLOW_DOUBLEDOT_in_bounds_clause2920;
    public static final BitSet FOLLOW_numeric_expression_in_bounds_clause2922;
    public static final BitSet FOLLOW_kINDICES_in_bounds_clause2930;
    public static final BitSet FOLLOW_kOF_in_bounds_clause2932;
    public static final BitSet FOLLOW_atom_in_bounds_clause2934;
    public static final BitSet FOLLOW_BETWEEN_in_bounds_clause2938;
    public static final BitSet FOLLOW_numeric_expression_in_bounds_clause2940;
    public static final BitSet FOLLOW_AND_in_bounds_clause2942;
    public static final BitSet FOLLOW_numeric_expression_in_bounds_clause2944;
    public static final BitSet FOLLOW_kVALUES_in_bounds_clause2955;
    public static final BitSet FOLLOW_kOF_in_bounds_clause2957;
    public static final BitSet FOLLOW_atom_in_bounds_clause2959;
    public static final BitSet FOLLOW_GOTO_in_goto_statement2980;
    public static final BitSet FOLLOW_label_name_in_goto_statement2982;
    public static final BitSet FOLLOW_IF_in_if_statement3003;
    public static final BitSet FOLLOW_expression_in_if_statement3005;
    public static final BitSet FOLLOW_THEN_in_if_statement3007;
    public static final BitSet FOLLOW_statement_in_if_statement3011;
    public static final BitSet FOLLOW_SEMI_in_if_statement3013;
    public static final BitSet FOLLOW_ELSIF_in_if_statement3028;
    public static final BitSet FOLLOW_expression_in_if_statement3030;
    public static final BitSet FOLLOW_THEN_in_if_statement3032;
    public static final BitSet FOLLOW_statement_in_if_statement3036;
    public static final BitSet FOLLOW_SEMI_in_if_statement3038;
    public static final BitSet FOLLOW_ELSE_in_if_statement3056;
    public static final BitSet FOLLOW_statement_in_if_statement3060;
    public static final BitSet FOLLOW_SEMI_in_if_statement3062;
    public static final BitSet FOLLOW_END_in_if_statement3078;
    public static final BitSet FOLLOW_IF_in_if_statement3080;
    public static final BitSet FOLLOW_NULL_in_null_statement3101;
    public static final BitSet FOLLOW_OPEN_in_open_statement3122;
    public static final BitSet FOLLOW_ID_in_open_statement3124;
    public static final BitSet FOLLOW_DOT_in_open_statement3128;
    public static final BitSet FOLLOW_ID_in_open_statement3130;
    public static final BitSet FOLLOW_call_args_in_open_statement3135;
    public static final BitSet FOLLOW_FOR_in_open_statement3140;
    public static final BitSet FOLLOW_select_statement_in_open_statement3142;
    public static final BitSet FOLLOW_PRAGMA_in_pragma3166;
    public static final BitSet FOLLOW_swallow_to_semi_in_pragma3168;
    public static final BitSet FOLLOW_RAISE_in_raise_statement3189;
    public static final BitSet FOLLOW_ID_in_raise_statement3193;
    public static final BitSet FOLLOW_DOT_in_raise_statement3197;
    public static final BitSet FOLLOW_ID_in_raise_statement3199;
    public static final BitSet FOLLOW_RETURN_in_return_statement3226;
    public static final BitSet FOLLOW_expression_in_return_statement3228;
    public static final BitSet FOLLOW_DECLARE_in_plsql_block3252;
    public static final BitSet FOLLOW_declare_section_in_plsql_block3254;
    public static final BitSet FOLLOW_body_in_plsql_block3259;
    public static final BitSet FOLLOW_LLABEL_in_label3280;
    public static final BitSet FOLLOW_label_in_label3282;
    public static final BitSet FOLLOW_RLABEL_in_label3284;
    public static final BitSet FOLLOW_COLON_in_qual_id3298;
    public static final BitSet FOLLOW_ID_in_qual_id3301;
    public static final BitSet FOLLOW_DOT_in_qual_id3305;
    public static final BitSet FOLLOW_COLON_in_qual_id3307;
    public static final BitSet FOLLOW_ID_in_qual_id3310;
    public static final BitSet FOLLOW_commit_statement_in_sql_statement3330;
    public static final BitSet FOLLOW_delete_statement_in_sql_statement3338;
    public static final BitSet FOLLOW_insert_statement_in_sql_statement3346;
    public static final BitSet FOLLOW_lock_table_statement_in_sql_statement3354;
    public static final BitSet FOLLOW_rollback_statement_in_sql_statement3362;
    public static final BitSet FOLLOW_savepoint_statement_in_sql_statement3370;
    public static final BitSet FOLLOW_select_statement_in_sql_statement3378;
    public static final BitSet FOLLOW_set_transaction_statement_in_sql_statement3386;
    public static final BitSet FOLLOW_update_statement_in_sql_statement3394;
    public static final BitSet FOLLOW_COMMIT_in_commit_statement3415;
    public static final BitSet FOLLOW_swallow_to_semi_in_commit_statement3417;
    public static final BitSet FOLLOW_DELETE_in_delete_statement3439;
    public static final BitSet FOLLOW_swallow_to_semi_in_delete_statement3441;
    public static final BitSet FOLLOW_INSERT_in_insert_statement3462;
    public static final BitSet FOLLOW_swallow_to_semi_in_insert_statement3464;
    public static final BitSet FOLLOW_LOCK_in_lock_table_statement3485;
    public static final BitSet FOLLOW_TABLE_in_lock_table_statement3487;
    public static final BitSet FOLLOW_swallow_to_semi_in_lock_table_statement3489;
    public static final BitSet FOLLOW_ROLLBACK_in_rollback_statement3510;
    public static final BitSet FOLLOW_swallow_to_semi_in_rollback_statement3512;
    public static final BitSet FOLLOW_SAVEPOINT_in_savepoint_statement3534;
    public static final BitSet FOLLOW_ID_in_savepoint_statement3536;
    public static final BitSet FOLLOW_SELECT_in_select_statement3557;
    public static final BitSet FOLLOW_swallow_to_semi_in_select_statement3559;
    public static final BitSet FOLLOW_SET_in_set_transaction_statement3580;
    public static final BitSet FOLLOW_TRANSACTION_in_set_transaction_statement3582;
    public static final BitSet FOLLOW_swallow_to_semi_in_set_transaction_statement3584;
    public static final BitSet FOLLOW_UPDATE_in_update_statement3605;
    public static final BitSet FOLLOW_swallow_to_semi_in_update_statement3607;
    public static final BitSet FOLLOW_set_in_swallow_to_semi3628;
    public static final BitSet FOLLOW_WHILE_in_while_loop_statement3655;
    public static final BitSet FOLLOW_expression_in_while_loop_statement3657;
    public static final BitSet FOLLOW_LOOP_in_while_loop_statement3659;
    public static final BitSet FOLLOW_statement_in_while_loop_statement3663;
    public static final BitSet FOLLOW_SEMI_in_while_loop_statement3665;
    public static final BitSet FOLLOW_END_in_while_loop_statement3670;
    public static final BitSet FOLLOW_LOOP_in_while_loop_statement3672;
    public static final BitSet FOLLOW_label_name_in_while_loop_statement3674;
    public static final BitSet FOLLOW_set_in_match_parens3703;
    public static final BitSet FOLLOW_RPAREN_in_match_parens3743;
    public static final BitSet FOLLOW_match_parens_in_match_parens3745;
    public static final BitSet FOLLOW_LPAREN_in_match_parens3747;
    public static final BitSet FOLLOW_ID_in_label_name3759;
    public static final BitSet FOLLOW_or_expr_in_expression3771;
    public static final BitSet FOLLOW_and_expr_in_or_expr3788;
    public static final BitSet FOLLOW_OR_in_or_expr3792;
    public static final BitSet FOLLOW_and_expr_in_or_expr3794;
    public static final BitSet FOLLOW_not_expr_in_and_expr3814;
    public static final BitSet FOLLOW_AND_in_and_expr3818;
    public static final BitSet FOLLOW_not_expr_in_and_expr3820;
    public static final BitSet FOLLOW_NOT_in_not_expr3840;
    public static final BitSet FOLLOW_compare_expr_in_not_expr3843;
    public static final BitSet FOLLOW_is_null_expr_in_compare_expr3860;
    public static final BitSet FOLLOW_set_in_compare_expr3864;
    public static final BitSet FOLLOW_is_null_expr_in_compare_expr3890;
    public static final BitSet FOLLOW_like_expr_in_is_null_expr3910;
    public static final BitSet FOLLOW_IS_in_is_null_expr3914;
    public static final BitSet FOLLOW_NOT_in_is_null_expr3916;
    public static final BitSet FOLLOW_NULL_in_is_null_expr3919;
    public static final BitSet FOLLOW_between_expr_in_like_expr3938;
    public static final BitSet FOLLOW_NOT_in_like_expr3942;
    public static final BitSet FOLLOW_LIKE_in_like_expr3945;
    public static final BitSet FOLLOW_between_expr_in_like_expr3947;
    public static final BitSet FOLLOW_in_expr_in_between_expr3967;
    public static final BitSet FOLLOW_NOT_in_between_expr3971;
    public static final BitSet FOLLOW_BETWEEN_in_between_expr3974;
    public static final BitSet FOLLOW_in_expr_in_between_expr3976;
    public static final BitSet FOLLOW_AND_in_between_expr3978;
    public static final BitSet FOLLOW_in_expr_in_between_expr3980;
    public static final BitSet FOLLOW_add_expr_in_in_expr4000;
    public static final BitSet FOLLOW_NOT_in_in_expr4004;
    public static final BitSet FOLLOW_IN_in_in_expr4007;
    public static final BitSet FOLLOW_LPAREN_in_in_expr4009;
    public static final BitSet FOLLOW_add_expr_in_in_expr4011;
    public static final BitSet FOLLOW_COMMA_in_in_expr4015;
    public static final BitSet FOLLOW_add_expr_in_in_expr4017;
    public static final BitSet FOLLOW_RPAREN_in_in_expr4022;
    public static final BitSet FOLLOW_add_expr_in_numeric_expression4042;
    public static final BitSet FOLLOW_mul_expr_in_add_expr4059;
    public static final BitSet FOLLOW_set_in_add_expr4063;
    public static final BitSet FOLLOW_mul_expr_in_add_expr4077;
    public static final BitSet FOLLOW_unary_sign_expr_in_mul_expr4097;
    public static final BitSet FOLLOW_ASTERISK_in_mul_expr4103;
    public static final BitSet FOLLOW_DIVIDE_in_mul_expr4107;
    public static final BitSet FOLLOW_kMOD_in_mul_expr4111;
    public static final BitSet FOLLOW_unary_sign_expr_in_mul_expr4115;
    public static final BitSet FOLLOW_set_in_unary_sign_expr4135;
    public static final BitSet FOLLOW_exponent_expr_in_unary_sign_expr4146;
    public static final BitSet FOLLOW_atom_in_exponent_expr4163;
    public static final BitSet FOLLOW_EXPONENT_in_exponent_expr4167;
    public static final BitSet FOLLOW_atom_in_exponent_expr4169;
    public static final BitSet FOLLOW_variable_or_function_call_in_atom4189;
    public static final BitSet FOLLOW_PERCENT_in_atom4193;
    public static final BitSet FOLLOW_attribute_in_atom4195;
    public static final BitSet FOLLOW_SQL_in_atom4206;
    public static final BitSet FOLLOW_PERCENT_in_atom4208;
    public static final BitSet FOLLOW_attribute_in_atom4210;
    public static final BitSet FOLLOW_string_literal_in_atom4218;
    public static final BitSet FOLLOW_numeric_atom_in_atom4226;
    public static final BitSet FOLLOW_boolean_atom_in_atom4234;
    public static final BitSet FOLLOW_NULL_in_atom4242;
    public static final BitSet FOLLOW_LPAREN_in_atom4250;
    public static final BitSet FOLLOW_expression_in_atom4252;
    public static final BitSet FOLLOW_RPAREN_in_atom4254;
    public static final BitSet FOLLOW_call_in_variable_or_function_call4275;
    public static final BitSet FOLLOW_DOT_in_variable_or_function_call4279;
    public static final BitSet FOLLOW_call_in_variable_or_function_call4281;
    public static final BitSet FOLLOW_DOT_in_variable_or_function_call4288;
    public static final BitSet FOLLOW_delete_call_in_variable_or_function_call4290;
    public static final BitSet FOLLOW_BULK_ROWCOUNT_in_attribute4310;
    public static final BitSet FOLLOW_LPAREN_in_attribute4312;
    public static final BitSet FOLLOW_expression_in_attribute4314;
    public static final BitSet FOLLOW_RPAREN_in_attribute4316;
    public static final BitSet FOLLOW_kFOUND_in_attribute4324;
    public static final BitSet FOLLOW_ISOPEN_in_attribute4332;
    public static final BitSet FOLLOW_NOTFOUND_in_attribute4340;
    public static final BitSet FOLLOW_kROWCOUNT_in_attribute4348;
    public static final BitSet FOLLOW_LPAREN_in_call_args4365;
    public static final BitSet FOLLOW_parameter_in_call_args4369;
    public static final BitSet FOLLOW_COMMA_in_call_args4373;
    public static final BitSet FOLLOW_parameter_in_call_args4375;
    public static final BitSet FOLLOW_RPAREN_in_call_args4383;
    public static final BitSet FOLLOW_boolean_literal_in_boolean_atom4400;
    public static final BitSet FOLLOW_collection_exists_in_boolean_atom4408;
    public static final BitSet FOLLOW_conditional_predicate_in_boolean_atom4416;
    public static final BitSet FOLLOW_numeric_literal_in_numeric_atom4433;
    public static final BitSet FOLLOW_set_in_numeric_literal0;
    public static final BitSet FOLLOW_set_in_boolean_literal0;
    public static final BitSet FOLLOW_QUOTED_STRING_in_string_literal4500;
    public static final BitSet FOLLOW_ID_in_collection_exists4517;
    public static final BitSet FOLLOW_DOT_in_collection_exists4519;
    public static final BitSet FOLLOW_EXISTS_in_collection_exists4521;
    public static final BitSet FOLLOW_LPAREN_in_collection_exists4523;
    public static final BitSet FOLLOW_expression_in_collection_exists4525;
    public static final BitSet FOLLOW_RPAREN_in_collection_exists4527;
    public static final BitSet FOLLOW_INSERTING_in_conditional_predicate4544;
    public static final BitSet FOLLOW_UPDATING_in_conditional_predicate4552;
    public static final BitSet FOLLOW_LPAREN_in_conditional_predicate4556;
    public static final BitSet FOLLOW_QUOTED_STRING_in_conditional_predicate4558;
    public static final BitSet FOLLOW_RPAREN_in_conditional_predicate4560;
    public static final BitSet FOLLOW_DELETING_in_conditional_predicate4571;
    public static final BitSet FOLLOW_ID_in_parameter4590;
    public static final BitSet FOLLOW_ARROW_in_parameter4592;
    public static final BitSet FOLLOW_expression_in_parameter4597;
    public static final BitSet FOLLOW_expression_in_index4614;
    public static final BitSet FOLLOW_CREATE_in_create_package4635;
    public static final BitSet FOLLOW_OR_in_create_package4639;
    public static final BitSet FOLLOW_kREPLACE_in_create_package4641;
    public static final BitSet FOLLOW_PACKAGE_in_create_package4646;
    public static final BitSet FOLLOW_package_full_name_in_create_package4648;
    public static final BitSet FOLLOW_invoker_rights_clause_in_create_package4660;
    public static final BitSet FOLLOW_IS_in_create_package4675;
    public static final BitSet FOLLOW_AS_in_create_package4679;
    public static final BitSet FOLLOW_declare_section_in_create_package4685;
    public static final BitSet FOLLOW_END_in_create_package4690;
    public static final BitSet FOLLOW_ID_in_create_package4694;
    public static final BitSet FOLLOW_SEMI_in_create_package4699;
    public static final BitSet FOLLOW_ID_in_package_full_name4733;
    public static final BitSet FOLLOW_DOT_in_package_full_name4735;
    public static final BitSet FOLLOW_ID_in_package_full_name4742;
    public static final BitSet FOLLOW_CREATE_in_create_package_body4767;
    public static final BitSet FOLLOW_OR_in_create_package_body4771;
    public static final BitSet FOLLOW_kREPLACE_in_create_package_body4773;
    public static final BitSet FOLLOW_PACKAGE_in_create_package_body4778;
    public static final BitSet FOLLOW_BODY_in_create_package_body4780;
    public static final BitSet FOLLOW_ID_in_create_package_body4786;
    public static final BitSet FOLLOW_DOT_in_create_package_body4788;
    public static final BitSet FOLLOW_ID_in_create_package_body4795;
    public static final BitSet FOLLOW_set_in_create_package_body4805;
    public static final BitSet FOLLOW_declare_section_in_create_package_body4817;
    public static final BitSet FOLLOW_body_in_create_package_body4834;
    public static final BitSet FOLLOW_END_in_create_package_body4838;
    public static final BitSet FOLLOW_ID_in_create_package_body4844;
    public static final BitSet FOLLOW_SEMI_in_create_package_body4859;
    public static final BitSet FOLLOW_CREATE_in_create_procedure4885;
    public static final BitSet FOLLOW_OR_in_create_procedure4889;
    public static final BitSet FOLLOW_kREPLACE_in_create_procedure4891;
    public static final BitSet FOLLOW_PROCEDURE_in_create_procedure4896;
    public static final BitSet FOLLOW_ID_in_create_procedure4902;
    public static final BitSet FOLLOW_DOT_in_create_procedure4904;
    public static final BitSet FOLLOW_ID_in_create_procedure4911;
    public static final BitSet FOLLOW_parameter_declarations_in_create_procedure4931;
    public static final BitSet FOLLOW_invoker_rights_clause_in_create_procedure4963;
    public static final BitSet FOLLOW_IS_in_create_procedure4976;
    public static final BitSet FOLLOW_AS_in_create_procedure4980;
    public static final BitSet FOLLOW_declare_section_in_create_procedure4994;
    public static final BitSet FOLLOW_body_in_create_procedure4997;
    public static final BitSet FOLLOW_call_spec_in_create_procedure5011;
    public static final BitSet FOLLOW_EXTERNAL_in_create_procedure5038;
    public static final BitSet FOLLOW_SEMI_in_create_procedure5067;
    public static final BitSet FOLLOW_CREATE_in_create_function5109;
    public static final BitSet FOLLOW_OR_in_create_function5113;
    public static final BitSet FOLLOW_kREPLACE_in_create_function5115;
    public static final BitSet FOLLOW_FUNCTION_in_create_function5120;
    public static final BitSet FOLLOW_ID_in_create_function5126;
    public static final BitSet FOLLOW_DOT_in_create_function5128;
    public static final BitSet FOLLOW_ID_in_create_function5135;
    public static final BitSet FOLLOW_parameter_declarations_in_create_function5155;
    public static final BitSet FOLLOW_RETURN_in_create_function5175;
    public static final BitSet FOLLOW_datatype_in_create_function5177;
    public static final BitSet FOLLOW_invoker_rights_clause_in_create_function5197;
    public static final BitSet FOLLOW_set_in_create_function5208;
    public static final BitSet FOLLOW_declare_section_in_create_function5228;
    public static final BitSet FOLLOW_body_in_create_function5231;
    public static final BitSet FOLLOW_call_spec_in_create_function5243;
    public static final BitSet FOLLOW_EXTERNAL_in_create_function5255;
    public static final BitSet FOLLOW_SEMI_in_create_function5267;
    public static final BitSet FOLLOW_AUTHID_in_invoker_rights_clause5288;
    public static final BitSet FOLLOW_set_in_invoker_rights_clause5290;
    public static final BitSet FOLLOW_LANGUAGE_in_call_spec5315;
    public static final BitSet FOLLOW_swallow_to_semi_in_call_spec5317;
    public static final BitSet FOLLOW_CREATE_in_create_type5334;
    public static final BitSet FOLLOW_OR_in_create_type5338;
    public static final BitSet FOLLOW_kREPLACE_in_create_type5340;
    public static final BitSet FOLLOW_type_definition_in_create_type5345;
    public static final BitSet FOLLOW_ID_in_kERRORS5356;
    public static final BitSet FOLLOW_ID_in_kEXCEPTIONS5365;
    public static final BitSet FOLLOW_ID_in_kFOUND5374;
    public static final BitSet FOLLOW_ID_in_kINDICES5383;
    public static final BitSet FOLLOW_ID_in_kMOD5392;
    public static final BitSet FOLLOW_ID_in_kNAME5401;
    public static final BitSet FOLLOW_ID_in_kOF5410;
    public static final BitSet FOLLOW_ID_in_kREPLACE5419;
    public static final BitSet FOLLOW_ID_in_kROWCOUNT5428;
    public static final BitSet FOLLOW_ID_in_kSAVE5437;
    public static final BitSet FOLLOW_ID_in_kSHOW5446;
    public static final BitSet FOLLOW_ID_in_kTYPE5455;
    public static final BitSet FOLLOW_ID_in_kVALUES5464;
    
    static {
        tokenNames = new String[] { "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIVIDE", "SEMI", "PROCEDURE", "ID", "FUNCTION", "RETURN", "LPAREN", "COMMA", "RPAREN", "ASSIGN", "DEFAULT", "IN", "OUT", "NOCOPY", "CURSOR", "IS", "NOT", "NULL", "CONSTANT", "EXCEPTION", "AS", "SUBTYPE", "RECORD", "OBJECT", "VARYING", "ARRAY", "VARRAY", "TABLE", "INDEX", "BY", "REF", "DOT", "PERCENT", "ROWTYPE", "DETERMINISTIC", "PIPELINED", "PARALLEL_ENABLE", "RESULT_CACHE", "BEGIN", "END", "WHEN", "OR", "OTHERS", "THEN", "COLON", "DELETE", "LOOP", "CASE", "ELSE", "CLOSE", "CONTINUE", "EXECUTE", "IMMEDIATE", "EXIT", "FETCH", "LIMIT", "INTO", "BULK", "COLLECT", "USING", "RETURNING", "FOR", "FORALL", "DOUBLEDOT", "BETWEEN", "AND", "GOTO", "IF", "ELSIF", "OPEN", "PRAGMA", "RAISE", "DECLARE", "LLABEL", "RLABEL", "COMMIT", "INSERT", "LOCK", "ROLLBACK", "SAVEPOINT", "SELECT", "SET", "TRANSACTION", "UPDATE", "WHILE", "EQ", "NOT_EQ", "LTH", "LEQ", "GTH", "GEQ", "LIKE", "MINUS", "PLUS", "DOUBLEVERTBAR", "ASTERISK", "EXPONENT", "SQL", "BULK_ROWCOUNT", "ISOPEN", "NOTFOUND", "INTEGER", "REAL_NUMBER", "TRUE", "FALSE", "QUOTED_STRING", "EXISTS", "INSERTING", "UPDATING", "DELETING", "ARROW", "CREATE", "PACKAGE", "BODY", "EXTERNAL", "AUTHID", "CURRENT_USER", "DEFINER", "LANGUAGE", "DOUBLEQUOTED_STRING", "POINT", "AT_SIGN", "RBRACK", "LBRACK", "VERTBAR", "N", "NUMBER_VALUE", "WS", "SL_COMMENT", "ML_COMMENT" };
        DFA5_transitionS = new String[] { "\u0001\u0001", "\u0001\u0006\u0001\u0005\u0001\u0003$\uffff\u0001\u0002F\uffff\u0001\u0004", "\u0001\u0007", "", "\u0001\tm\uffff\u0001\b", "", "", "\u0001\u0006\u0001\u0005\u0001\u0003k\uffff\u0001\u0004", "", "" };
        DFA5_eot = DFA.unpackEncodedString("\n\uffff");
        DFA5_eof = DFA.unpackEncodedString("\n\uffff");
        DFA5_min = DFA.unpackEncodedStringToUnsignedChars("\u0001s\u0001\u0006\u0001\u0007\u0001\uffff\u0001\u0007\u0002\uffff\u0001\u0006\u0002\uffff");
        DFA5_max = DFA.unpackEncodedStringToUnsignedChars("\u0001s\u0001t\u0001\u0007\u0001\uffff\u0001u\u0002\uffff\u0001t\u0002\uffff");
        DFA5_accept = DFA.unpackEncodedString("\u0003\uffff\u0001\u0003\u0001\uffff\u0001\u0005\u0001\u0004\u0001\uffff\u0001\u0002\u0001\u0001");
        DFA5_special = DFA.unpackEncodedString("\n\uffff}>");
        int numStates = PLSQL2Parser.DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i = 0; i < numStates; ++i) {
            PLSQL2Parser.DFA5_transition[i] = DFA.unpackEncodedString(PLSQL2Parser.DFA5_transitionS[i]);
        }
        DFA15_transitionS = new String[] { "\u0001\u0006\u0001\u0002\u0001\u0005\t\uffff\u0001\u0004\u0006\uffff\u0001\u0003\u0010\uffff\u0002\u0001\u001e\uffff\u0001\u0007", "", "\u0001\t\u000e\uffff\u0002\b\n\uffff\u0001\b", "", "", "", "", "", "", "\u0001\b\u0004\uffff\u0001\b\u0002\uffff\u0002\b\u0004\uffff\u0001\n\u0001\b\u0003\uffff\u0001\n\n\uffff\u0002\b", "" };
        DFA15_eot = DFA.unpackEncodedString("\u000b\uffff");
        DFA15_eof = DFA.unpackEncodedString("\u000b\uffff");
        DFA15_min = DFA.unpackEncodedStringToUnsignedChars("\u0001\u0006\u0001\uffff\u0001\u0007\u0006\uffff\u0001\u0005\u0001\uffff");
        DFA15_max = DFA.unpackEncodedStringToUnsignedChars("\u0001J\u0001\uffff\u0001\"\u0006\uffff\u0001$\u0001\uffff");
        DFA15_accept = DFA.unpackEncodedString("\u0001\uffff\u0001\b\u0001\uffff\u0001\u0002\u0001\u0003\u0001\u0005\u0001\u0006\u0001\u0007\u0001\u0004\u0001\uffff\u0001\u0001");
        DFA15_special = DFA.unpackEncodedString("\u000b\uffff}>");
        numStates = PLSQL2Parser.DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i = 0; i < numStates; ++i) {
            PLSQL2Parser.DFA15_transition[i] = DFA.unpackEncodedString(PLSQL2Parser.DFA15_transitionS[i]);
        }
        DFA96_transitionS = new String[] { "\u0001\u0003\u0002\uffff\u0001\u0001\n\uffff\u0001\u0001\u001a\uffff\u0001\u0001/\uffff\u0002\u0001\u0003\uffff\u0001\u0001\u0003\uffff\u0005\u0001\u0001\uffff\u0003\u0001", "", "", "\u0001\uffff", "", "", "", "", "", "", "", "", "", "", "" };
        DFA96_eot = DFA.unpackEncodedString("\u000f\uffff");
        DFA96_eof = DFA.unpackEncodedString("\u000f\uffff");
        DFA96_min = DFA.unpackEncodedStringToUnsignedChars("\u0001\u0007\u0002\uffff\u0001\u0000\u000b\uffff");
        DFA96_max = DFA.unpackEncodedStringToUnsignedChars("\u0001q\u0002\uffff\u0001\u0000\u000b\uffff");
        DFA96_accept = DFA.unpackEncodedString("\u0001\uffff\u0001\u0001\u000b\uffff\u0001\u0002\u0001\u0003");
        DFA96_special = DFA.unpackEncodedString("\u0003\uffff\u0001\u0000\u000b\uffff}>");
        numStates = PLSQL2Parser.DFA96_transitionS.length;
        DFA96_transition = new short[numStates][];
        for (int i = 0; i < numStates; ++i) {
            PLSQL2Parser.DFA96_transition[i] = DFA.unpackEncodedString(PLSQL2Parser.DFA96_transitionS[i]);
        }
        DFA139_transitionS = new String[] { "\u0001\u0002\u0002\uffff\u0001\b\n\uffff\u0001\u0007\u001a\uffff\u0001\u00014\uffff\u0001\u0003\u0003\uffff\u0002\u0005\u0002\u0006\u0001\u0004\u0001\uffff\u0003\u0006", "", "\u0002\u0001\u0001\uffff\u0001\u0001\u0001\uffff\u0004\u0001\u0002\uffff\u0001\u0001\u0003\uffff\u0002\u0001\u000e\uffff\u0001\t\u0001\u0001\u0007\uffff\u0002\u0001\u0001\uffff\u0001\u0001\u0001\uffff\u0002\u0001\t\uffff\u0002\u0001\u0001\uffff\u0002\u0001\u0002\uffff\u0003\u0001\t\uffff\u0007\u0001\u0001\uffff\u0001\u0001\u0001\uffff\f\u0001", "", "", "", "", "", "", "\u0001\u0001(\uffff\u0002\u0001<\uffff\u0001\u0006" };
        DFA139_eot = DFA.unpackEncodedString("\n\uffff");
        DFA139_eof = DFA.unpackEncodedString("\u0002\uffff\u0001\u0001\u0007\uffff");
        DFA139_min = DFA.unpackEncodedStringToUnsignedChars("\u0001\u0007\u0001\uffff\u0001\u0004\u0006\uffff\u0001\u0007");
        DFA139_max = DFA.unpackEncodedStringToUnsignedChars("\u0001q\u0001\uffff\u0001d\u0006\uffff\u0001n");
        DFA139_accept = DFA.unpackEncodedString("\u0001\uffff\u0001\u0001\u0001\uffff\u0001\u0002\u0001\u0003\u0001\u0004\u0001\u0005\u0001\u0006\u0001\u0007\u0001\uffff");
        DFA139_special = DFA.unpackEncodedString("\n\uffff}>");
        numStates = PLSQL2Parser.DFA139_transitionS.length;
        DFA139_transition = new short[numStates][];
        for (int i = 0; i < numStates; ++i) {
            PLSQL2Parser.DFA139_transition[i] = DFA.unpackEncodedString(PLSQL2Parser.DFA139_transitionS[i]);
        }
        FOLLOW_create_object_in_sqlplus_file62 = new BitSet(new long[] { 16L, 2251799813685248L });
        FOLLOW_DIVIDE_in_sqlplus_file66 = new BitSet(new long[] { 128L });
        FOLLOW_show_errors_in_sqlplus_file68 = new BitSet(new long[] { 16L, 2251799813685248L });
        FOLLOW_DIVIDE_in_sqlplus_file73 = new BitSet(new long[] { 16L, 2251799813685248L });
        FOLLOW_EOF_in_sqlplus_file79 = new BitSet(new long[] { 2L });
        FOLLOW_kSHOW_in_show_errors100 = new BitSet(new long[] { 128L });
        FOLLOW_kERRORS_in_show_errors102 = new BitSet(new long[] { 34L });
        FOLLOW_SEMI_in_show_errors104 = new BitSet(new long[] { 2L });
        FOLLOW_create_package_in_create_object122 = new BitSet(new long[] { 2L });
        FOLLOW_create_package_body_in_create_object130 = new BitSet(new long[] { 2L });
        FOLLOW_create_function_in_create_object138 = new BitSet(new long[] { 2L });
        FOLLOW_create_procedure_in_create_object146 = new BitSet(new long[] { 2L });
        FOLLOW_create_type_in_create_object154 = new BitSet(new long[] { 2L });
        FOLLOW_PROCEDURE_in_procedure_heading182 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_procedure_heading184 = new BitSet(new long[] { 1026L });
        FOLLOW_parameter_declarations_in_procedure_heading207 = new BitSet(new long[] { 2L });
        FOLLOW_FUNCTION_in_function_heading282 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_function_heading284 = new BitSet(new long[] { 1536L });
        FOLLOW_parameter_declarations_in_function_heading306 = new BitSet(new long[] { 512L });
        FOLLOW_RETURN_in_function_heading327 = new BitSet(new long[] { 17179869312L });
        FOLLOW_datatype_in_function_heading329 = new BitSet(new long[] { 2L });
        FOLLOW_LPAREN_in_parameter_declarations405 = new BitSet(new long[] { 128L });
        FOLLOW_parameter_declaration_in_parameter_declarations410 = new BitSet(new long[] { 6144L });
        FOLLOW_COMMA_in_parameter_declarations434 = new BitSet(new long[] { 128L });
        FOLLOW_parameter_declaration_in_parameter_declarations439 = new BitSet(new long[] { 6144L });
        FOLLOW_RPAREN_in_parameter_declarations466 = new BitSet(new long[] { 2L });
        FOLLOW_ID_in_parameter_declaration522 = new BitSet(new long[] { 17179967616L });
        FOLLOW_param_type_in_parameter_declaration524 = new BitSet(new long[] { 17179869312L });
        FOLLOW_datatype_in_parameter_declaration527 = new BitSet(new long[] { 24578L });
        FOLLOW_ASSIGN_in_parameter_declaration542 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_DEFAULT_in_parameter_declaration546 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_expression_in_parameter_declaration550 = new BitSet(new long[] { 2L });
        FOLLOW_IN_in_param_type681 = new BitSet(new long[] { 2L });
        FOLLOW_OUT_in_param_type689 = new BitSet(new long[] { 131074L });
        FOLLOW_IN_in_param_type693 = new BitSet(new long[] { 65536L });
        FOLLOW_OUT_in_param_type695 = new BitSet(new long[] { 131074L });
        FOLLOW_NOCOPY_in_param_type699 = new BitSet(new long[] { 2L });
        FOLLOW_type_definition_in_declare_section729 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_declare_section731 = new BitSet(new long[] { 33817026L, 1024L });
        FOLLOW_subtype_definition_in_declare_section743 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_declare_section745 = new BitSet(new long[] { 33817058L, 1024L });
        FOLLOW_cursor_definition_in_declare_section754 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_declare_section756 = new BitSet(new long[] { 33817058L, 1024L });
        FOLLOW_item_declaration_in_declare_section765 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_declare_section767 = new BitSet(new long[] { 33817058L, 1024L });
        FOLLOW_function_declaration_or_definition_in_declare_section776 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_declare_section778 = new BitSet(new long[] { 33817058L, 1024L });
        FOLLOW_procedure_declaration_or_definition_in_declare_section789 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_declare_section791 = new BitSet(new long[] { 33817058L, 1024L });
        FOLLOW_pragma_in_declare_section802 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_declare_section804 = new BitSet(new long[] { 33817058L, 1024L });
        FOLLOW_CURSOR_in_cursor_definition833 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_cursor_definition835 = new BitSet(new long[] { 525312L });
        FOLLOW_parameter_declarations_in_cursor_definition837 = new BitSet(new long[] { 524288L });
        FOLLOW_IS_in_cursor_definition840 = new BitSet(new long[] { 0L, 1048576L });
        FOLLOW_select_statement_in_cursor_definition842 = new BitSet(new long[] { 2L });
        FOLLOW_variable_declaration_in_item_declaration859 = new BitSet(new long[] { 2L });
        FOLLOW_constant_declaration_in_item_declaration867 = new BitSet(new long[] { 2L });
        FOLLOW_exception_declaration_in_item_declaration875 = new BitSet(new long[] { 2L });
        FOLLOW_ID_in_variable_declaration896 = new BitSet(new long[] { 17179869312L });
        FOLLOW_datatype_in_variable_declaration898 = new BitSet(new long[] { 1073154L });
        FOLLOW_NOT_in_variable_declaration906 = new BitSet(new long[] { 2097152L });
        FOLLOW_NULL_in_variable_declaration908 = new BitSet(new long[] { 24576L });
        FOLLOW_set_in_variable_declaration913 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_expression_in_variable_declaration925 = new BitSet(new long[] { 2L });
        FOLLOW_ID_in_constant_declaration950 = new BitSet(new long[] { 4194304L });
        FOLLOW_CONSTANT_in_constant_declaration952 = new BitSet(new long[] { 17179869312L });
        FOLLOW_datatype_in_constant_declaration954 = new BitSet(new long[] { 1073152L });
        FOLLOW_NOT_in_constant_declaration958 = new BitSet(new long[] { 2097152L });
        FOLLOW_NULL_in_constant_declaration960 = new BitSet(new long[] { 24576L });
        FOLLOW_set_in_constant_declaration965 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_expression_in_constant_declaration979 = new BitSet(new long[] { 2L });
        FOLLOW_ID_in_exception_declaration1000 = new BitSet(new long[] { 8388608L });
        FOLLOW_EXCEPTION_in_exception_declaration1002 = new BitSet(new long[] { 2L });
        FOLLOW_kTYPE_in_type_definition1029 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_type_definition1031 = new BitSet(new long[] { 17301504L });
        FOLLOW_set_in_type_definition1052 = new BitSet(new long[] { 20870856704L });
        FOLLOW_record_type_definition_in_type_definition1062 = new BitSet(new long[] { 2L });
        FOLLOW_collection_type_definition_in_type_definition1066 = new BitSet(new long[] { 2L });
        FOLLOW_ref_cursor_type_definition_in_type_definition1104 = new BitSet(new long[] { 2L });
        FOLLOW_object_type_definition_in_type_definition1119 = new BitSet(new long[] { 2L });
        FOLLOW_SUBTYPE_in_subtype_definition1178 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_subtype_definition1180 = new BitSet(new long[] { 524288L });
        FOLLOW_IS_in_subtype_definition1182 = new BitSet(new long[] { 17179869312L });
        FOLLOW_datatype_in_subtype_definition1184 = new BitSet(new long[] { 1048578L });
        FOLLOW_NOT_in_subtype_definition1188 = new BitSet(new long[] { 2097152L });
        FOLLOW_NULL_in_subtype_definition1190 = new BitSet(new long[] { 2L });
        FOLLOW_RECORD_in_record_type_definition1211 = new BitSet(new long[] { 1024L });
        FOLLOW_LPAREN_in_record_type_definition1213 = new BitSet(new long[] { 128L });
        FOLLOW_record_field_declaration_in_record_type_definition1215 = new BitSet(new long[] { 6144L });
        FOLLOW_COMMA_in_record_type_definition1219 = new BitSet(new long[] { 128L });
        FOLLOW_record_field_declaration_in_record_type_definition1221 = new BitSet(new long[] { 6144L });
        FOLLOW_RPAREN_in_record_type_definition1226 = new BitSet(new long[] { 2L });
        FOLLOW_ID_in_record_field_declaration1250 = new BitSet(new long[] { 17179869312L });
        FOLLOW_datatype_in_record_field_declaration1257 = new BitSet(new long[] { 1073154L });
        FOLLOW_NOT_in_record_field_declaration1268 = new BitSet(new long[] { 2097152L });
        FOLLOW_NULL_in_record_field_declaration1270 = new BitSet(new long[] { 24576L });
        FOLLOW_set_in_record_field_declaration1275 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_expression_in_record_field_declaration1285 = new BitSet(new long[] { 2L });
        FOLLOW_OBJECT_in_object_type_definition1315 = new BitSet(new long[] { 1024L });
        FOLLOW_LPAREN_in_object_type_definition1317 = new BitSet(new long[] { 128L });
        FOLLOW_record_field_declaration_in_object_type_definition1321 = new BitSet(new long[] { 6144L });
        FOLLOW_COMMA_in_object_type_definition1336 = new BitSet(new long[] { 128L });
        FOLLOW_record_field_declaration_in_object_type_definition1340 = new BitSet(new long[] { 6144L });
        FOLLOW_RPAREN_in_object_type_definition1360 = new BitSet(new long[] { 2L });
        FOLLOW_varray_type_definition_in_collection_type_definition1388 = new BitSet(new long[] { 2L });
        FOLLOW_nested_table_type_definition_in_collection_type_definition1394 = new BitSet(new long[] { 2L });
        FOLLOW_VARYING_in_varray_type_definition1412 = new BitSet(new long[] { 536871936L });
        FOLLOW_ARRAY_in_varray_type_definition1414 = new BitSet(new long[] { 1024L });
        FOLLOW_VARRAY_in_varray_type_definition1419 = new BitSet(new long[] { 1024L });
        FOLLOW_LPAREN_in_varray_type_definition1423 = new BitSet(new long[] { 0L, 6597069766656L });
        FOLLOW_numeric_literal_in_varray_type_definition1425 = new BitSet(new long[] { 4096L });
        FOLLOW_RPAREN_in_varray_type_definition1427 = new BitSet(new long[] { 128L });
        FOLLOW_kOF_in_varray_type_definition1429 = new BitSet(new long[] { 17179869312L });
        FOLLOW_datatype_in_varray_type_definition1431 = new BitSet(new long[] { 1048578L });
        FOLLOW_NOT_in_varray_type_definition1435 = new BitSet(new long[] { 2097152L });
        FOLLOW_NULL_in_varray_type_definition1437 = new BitSet(new long[] { 2L });
        FOLLOW_TABLE_in_nested_table_type_definition1461 = new BitSet(new long[] { 128L });
        FOLLOW_kOF_in_nested_table_type_definition1463 = new BitSet(new long[] { 17179869312L });
        FOLLOW_datatype_in_nested_table_type_definition1465 = new BitSet(new long[] { 4296015874L });
        FOLLOW_NOT_in_nested_table_type_definition1474 = new BitSet(new long[] { 2097152L });
        FOLLOW_NULL_in_nested_table_type_definition1476 = new BitSet(new long[] { 4294967298L });
        FOLLOW_INDEX_in_nested_table_type_definition1483 = new BitSet(new long[] { 8589934592L });
        FOLLOW_BY_in_nested_table_type_definition1485 = new BitSet(new long[] { 17179869312L });
        FOLLOW_associative_index_type_in_nested_table_type_definition1487 = new BitSet(new long[] { 2L });
        FOLLOW_datatype_in_associative_index_type1501 = new BitSet(new long[] { 2L });
        FOLLOW_REF_in_ref_cursor_type_definition1512 = new BitSet(new long[] { 262144L });
        FOLLOW_CURSOR_in_ref_cursor_type_definition1514 = new BitSet(new long[] { 514L });
        FOLLOW_RETURN_in_ref_cursor_type_definition1518 = new BitSet(new long[] { 17179869312L });
        FOLLOW_datatype_in_ref_cursor_type_definition1520 = new BitSet(new long[] { 2L });
        FOLLOW_REF_in_datatype1539 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_datatype1544 = new BitSet(new long[] { 103079216130L });
        FOLLOW_DOT_in_datatype1548 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_datatype1550 = new BitSet(new long[] { 68719477762L });
        FOLLOW_LPAREN_in_datatype1557 = new BitSet(new long[] { 0L, 6597069766656L });
        FOLLOW_numeric_literal_in_datatype1559 = new BitSet(new long[] { 6144L });
        FOLLOW_COMMA_in_datatype1563 = new BitSet(new long[] { 0L, 6597069766656L });
        FOLLOW_numeric_literal_in_datatype1565 = new BitSet(new long[] { 6144L });
        FOLLOW_RPAREN_in_datatype1570 = new BitSet(new long[] { 2L });
        FOLLOW_PERCENT_in_datatype1574 = new BitSet(new long[] { 137438953600L });
        FOLLOW_kTYPE_in_datatype1578 = new BitSet(new long[] { 2L });
        FOLLOW_ROWTYPE_in_datatype1582 = new BitSet(new long[] { 2L });
        FOLLOW_function_heading_in_function_declaration_or_definition1612 = new BitSet(new long[] { 4123185905666L });
        FOLLOW_set_in_function_declaration_or_definition1622 = new BitSet(new long[] { 4123185905666L });
        FOLLOW_set_in_function_declaration_or_definition1651 = new BitSet(new long[] { 4398080328160L, 1024L });
        FOLLOW_declare_section_in_function_declaration_or_definition1661 = new BitSet(new long[] { 4398080328160L, 1024L });
        FOLLOW_body_in_function_declaration_or_definition1664 = new BitSet(new long[] { 2L });
        FOLLOW_function_heading_in_function_declaration1687 = new BitSet(new long[] { 4123168604162L });
        FOLLOW_set_in_function_declaration1697 = new BitSet(new long[] { 4123168604162L });
        FOLLOW_function_heading_in_function_definition1735 = new BitSet(new long[] { 4123185905664L });
        FOLLOW_set_in_function_definition1745 = new BitSet(new long[] { 4123185905664L });
        FOLLOW_set_in_function_definition1772 = new BitSet(new long[] { 4398080328160L, 1024L });
        FOLLOW_declare_section_in_function_definition1782 = new BitSet(new long[] { 4398080328160L, 1024L });
        FOLLOW_body_in_function_definition1785 = new BitSet(new long[] { 2L });
        FOLLOW_procedure_heading_in_procedure_declaration_or_definition1807 = new BitSet(new long[] { 17301506L });
        FOLLOW_set_in_procedure_declaration_or_definition1819 = new BitSet(new long[] { 4398080328160L, 1024L });
        FOLLOW_declare_section_in_procedure_declaration_or_definition1829 = new BitSet(new long[] { 4398080328160L, 1024L });
        FOLLOW_body_in_procedure_declaration_or_definition1832 = new BitSet(new long[] { 2L });
        FOLLOW_procedure_heading_in_procedure_declaration1852 = new BitSet(new long[] { 2L });
        FOLLOW_procedure_heading_in_procedure_definition1863 = new BitSet(new long[] { 17301504L });
        FOLLOW_set_in_procedure_definition1866 = new BitSet(new long[] { 4398080328160L, 1024L });
        FOLLOW_declare_section_in_procedure_definition1876 = new BitSet(new long[] { 4398080328160L, 1024L });
        FOLLOW_body_in_procedure_definition1879 = new BitSet(new long[] { 2L });
        FOLLOW_BEGIN_in_body1893 = new BitSet(new long[] { 499622481743840224L, 29343430L });
        FOLLOW_statement_in_body1895 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_body1897 = new BitSet(new long[] { 499631277845251040L, 29343430L });
        FOLLOW_statement_in_body1901 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_body1903 = new BitSet(new long[] { 499631277845251040L, 29343430L });
        FOLLOW_pragma_in_body1907 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_body1909 = new BitSet(new long[] { 499631277845251040L, 29343430L });
        FOLLOW_EXCEPTION_in_body1917 = new BitSet(new long[] { 17592186044416L });
        FOLLOW_exception_handler_in_body1919 = new BitSet(new long[] { 26388279066624L });
        FOLLOW_END_in_body1925 = new BitSet(new long[] { 130L });
        FOLLOW_ID_in_body1927 = new BitSet(new long[] { 2L });
        FOLLOW_WHEN_in_exception_handler1939 = new BitSet(new long[] { 351843720888448L });
        FOLLOW_qual_id_in_exception_handler1943 = new BitSet(new long[] { 175921860444160L });
        FOLLOW_OR_in_exception_handler1947 = new BitSet(new long[] { 281474976710784L });
        FOLLOW_qual_id_in_exception_handler1949 = new BitSet(new long[] { 175921860444160L });
        FOLLOW_OTHERS_in_exception_handler1956 = new BitSet(new long[] { 140737488355328L });
        FOLLOW_THEN_in_exception_handler1962 = new BitSet(new long[] { 499622481743840224L, 29343430L });
        FOLLOW_statement_in_exception_handler1966 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_exception_handler1968 = new BitSet(new long[] { 499622481743840226L, 29343430L });
        FOLLOW_label_in_statement1986 = new BitSet(new long[] { 499622481743840224L, 29343430L });
        FOLLOW_assign_or_call_statement_in_statement1995 = new BitSet(new long[] { 2L });
        FOLLOW_case_statement_in_statement2003 = new BitSet(new long[] { 2L });
        FOLLOW_close_statement_in_statement2011 = new BitSet(new long[] { 2L });
        FOLLOW_continue_statement_in_statement2019 = new BitSet(new long[] { 2L });
        FOLLOW_basic_loop_statement_in_statement2027 = new BitSet(new long[] { 2L });
        FOLLOW_execute_immediate_statement_in_statement2035 = new BitSet(new long[] { 2L });
        FOLLOW_exit_statement_in_statement2043 = new BitSet(new long[] { 2L });
        FOLLOW_fetch_statement_in_statement2051 = new BitSet(new long[] { 2L });
        FOLLOW_for_loop_statement_in_statement2059 = new BitSet(new long[] { 2L });
        FOLLOW_forall_statement_in_statement2067 = new BitSet(new long[] { 2L });
        FOLLOW_goto_statement_in_statement2075 = new BitSet(new long[] { 2L });
        FOLLOW_if_statement_in_statement2083 = new BitSet(new long[] { 2L });
        FOLLOW_null_statement_in_statement2091 = new BitSet(new long[] { 2L });
        FOLLOW_open_statement_in_statement2099 = new BitSet(new long[] { 2L });
        FOLLOW_plsql_block_in_statement2107 = new BitSet(new long[] { 2L });
        FOLLOW_raise_statement_in_statement2115 = new BitSet(new long[] { 2L });
        FOLLOW_return_statement_in_statement2123 = new BitSet(new long[] { 2L });
        FOLLOW_sql_statement_in_statement2131 = new BitSet(new long[] { 2L });
        FOLLOW_while_loop_statement_in_statement2139 = new BitSet(new long[] { 2L });
        FOLLOW_call_in_lvalue2162 = new BitSet(new long[] { 34359738370L });
        FOLLOW_DOT_in_lvalue2166 = new BitSet(new long[] { 281474976710784L });
        FOLLOW_call_in_lvalue2168 = new BitSet(new long[] { 34359738370L });
        FOLLOW_lvalue_in_assign_or_call_statement2188 = new BitSet(new long[] { 34359746562L });
        FOLLOW_DOT_in_assign_or_call_statement2192 = new BitSet(new long[] { 562949953421312L });
        FOLLOW_delete_call_in_assign_or_call_statement2194 = new BitSet(new long[] { 2L });
        FOLLOW_ASSIGN_in_assign_or_call_statement2198 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_expression_in_assign_or_call_statement2200 = new BitSet(new long[] { 2L });
        FOLLOW_COLON_in_call2220 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_call2223 = new BitSet(new long[] { 1026L });
        FOLLOW_LPAREN_in_call2227 = new BitSet(new long[] { 281474979861632L, 1053482463264768L });
        FOLLOW_parameter_in_call2231 = new BitSet(new long[] { 6144L });
        FOLLOW_COMMA_in_call2235 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_parameter_in_call2237 = new BitSet(new long[] { 6144L });
        FOLLOW_RPAREN_in_call2245 = new BitSet(new long[] { 2L });
        FOLLOW_DELETE_in_delete_call2265 = new BitSet(new long[] { 1026L });
        FOLLOW_LPAREN_in_delete_call2269 = new BitSet(new long[] { 281474979861632L, 1053482463264768L });
        FOLLOW_parameter_in_delete_call2271 = new BitSet(new long[] { 4096L });
        FOLLOW_RPAREN_in_delete_call2274 = new BitSet(new long[] { 2L });
        FOLLOW_LOOP_in_basic_loop_statement2298 = new BitSet(new long[] { 499622481743840224L, 29343430L });
        FOLLOW_statement_in_basic_loop_statement2302 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_basic_loop_statement2304 = new BitSet(new long[] { 499631277836862432L, 29343430L });
        FOLLOW_END_in_basic_loop_statement2309 = new BitSet(new long[] { 1125899906842624L });
        FOLLOW_LOOP_in_basic_loop_statement2311 = new BitSet(new long[] { 130L });
        FOLLOW_label_name_in_basic_loop_statement2313 = new BitSet(new long[] { 2L });
        FOLLOW_CASE_in_case_statement2335 = new BitSet(new long[] { 299067165901952L, 1053482463264768L });
        FOLLOW_expression_in_case_statement2337 = new BitSet(new long[] { 17592186044416L });
        FOLLOW_WHEN_in_case_statement2350 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_expression_in_case_statement2352 = new BitSet(new long[] { 140737488355328L });
        FOLLOW_THEN_in_case_statement2354 = new BitSet(new long[] { 499622481743840224L, 29343430L });
        FOLLOW_statement_in_case_statement2358 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_case_statement2360 = new BitSet(new long[] { 504152469650277344L, 29343430L });
        FOLLOW_ELSE_in_case_statement2378 = new BitSet(new long[] { 499622481743840224L, 29343430L });
        FOLLOW_statement_in_case_statement2380 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_case_statement2382 = new BitSet(new long[] { 8796093022208L });
        FOLLOW_END_in_case_statement2395 = new BitSet(new long[] { 2251799813685248L });
        FOLLOW_CASE_in_case_statement2397 = new BitSet(new long[] { 130L });
        FOLLOW_label_name_in_case_statement2399 = new BitSet(new long[] { 2L });
        FOLLOW_CLOSE_in_close_statement2421 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_close_statement2423 = new BitSet(new long[] { 34359738370L });
        FOLLOW_DOT_in_close_statement2427 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_close_statement2429 = new BitSet(new long[] { 2L });
        FOLLOW_CONTINUE_in_continue_statement2453 = new BitSet(new long[] { 17592186044546L });
        FOLLOW_ID_in_continue_statement2459 = new BitSet(new long[] { 17592186044418L });
        FOLLOW_WHEN_in_continue_statement2466 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_expression_in_continue_statement2468 = new BitSet(new long[] { 2L });
        FOLLOW_EXECUTE_in_execute_immediate_statement2492 = new BitSet(new long[] { 72057594037927936L });
        FOLLOW_IMMEDIATE_in_execute_immediate_statement2494 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_expression_in_execute_immediate_statement2496 = new BitSet(new long[] { -5764607523034234366L, 1L });
        FOLLOW_into_clause_in_execute_immediate_statement2510 = new BitSet(new long[] { -9223372036854775806L });
        FOLLOW_bulk_collect_into_clause_in_execute_immediate_statement2514 = new BitSet(new long[] { -9223372036854775806L });
        FOLLOW_using_clause_in_execute_immediate_statement2517 = new BitSet(new long[] { 2L });
        FOLLOW_using_clause_in_execute_immediate_statement2530 = new BitSet(new long[] { 514L, 1L });
        FOLLOW_dynamic_returning_clause_in_execute_immediate_statement2532 = new BitSet(new long[] { 2L });
        FOLLOW_dynamic_returning_clause_in_execute_immediate_statement2545 = new BitSet(new long[] { 2L });
        FOLLOW_EXIT_in_exit_statement2577 = new BitSet(new long[] { 17592186044546L });
        FOLLOW_ID_in_exit_statement2583 = new BitSet(new long[] { 17592186044418L });
        FOLLOW_WHEN_in_exit_statement2590 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_expression_in_exit_statement2592 = new BitSet(new long[] { 2L });
        FOLLOW_FETCH_in_fetch_statement2616 = new BitSet(new long[] { 281474976710784L });
        FOLLOW_qual_id_in_fetch_statement2618 = new BitSet(new long[] { 3458764513820540928L });
        FOLLOW_into_clause_in_fetch_statement2622 = new BitSet(new long[] { 2L });
        FOLLOW_bulk_collect_into_clause_in_fetch_statement2626 = new BitSet(new long[] { 576460752303423490L });
        FOLLOW_LIMIT_in_fetch_statement2630 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_numeric_expression_in_fetch_statement2632 = new BitSet(new long[] { 2L });
        FOLLOW_INTO_in_into_clause2662 = new BitSet(new long[] { 281474976710784L });
        FOLLOW_lvalue_in_into_clause2664 = new BitSet(new long[] { 2050L });
        FOLLOW_COMMA_in_into_clause2668 = new BitSet(new long[] { 281474976710784L });
        FOLLOW_lvalue_in_into_clause2670 = new BitSet(new long[] { 2050L });
        FOLLOW_BULK_in_bulk_collect_into_clause2698 = new BitSet(new long[] { 4611686018427387904L });
        FOLLOW_COLLECT_in_bulk_collect_into_clause2700 = new BitSet(new long[] { 1152921504606846976L });
        FOLLOW_INTO_in_bulk_collect_into_clause2702 = new BitSet(new long[] { 281474976710784L });
        FOLLOW_lvalue_in_bulk_collect_into_clause2704 = new BitSet(new long[] { 2050L });
        FOLLOW_COMMA_in_bulk_collect_into_clause2708 = new BitSet(new long[] { 281474976710784L });
        FOLLOW_lvalue_in_bulk_collect_into_clause2710 = new BitSet(new long[] { 2050L });
        FOLLOW_USING_in_using_clause2734 = new BitSet(new long[] { 281474979955840L, 1053482463264768L });
        FOLLOW_param_modifiers_in_using_clause2736 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_expression_in_using_clause2739 = new BitSet(new long[] { 2050L });
        FOLLOW_COMMA_in_using_clause2743 = new BitSet(new long[] { 281474979955840L, 1053482463264768L });
        FOLLOW_param_modifiers_in_using_clause2745 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_expression_in_using_clause2748 = new BitSet(new long[] { 2050L });
        FOLLOW_IN_in_param_modifiers2765 = new BitSet(new long[] { 65538L });
        FOLLOW_OUT_in_param_modifiers2767 = new BitSet(new long[] { 2L });
        FOLLOW_OUT_in_param_modifiers2772 = new BitSet(new long[] { 2L });
        FOLLOW_set_in_dynamic_returning_clause2790 = new BitSet(new long[] { 3458764513820540928L });
        FOLLOW_into_clause_in_dynamic_returning_clause2802 = new BitSet(new long[] { 2L });
        FOLLOW_bulk_collect_into_clause_in_dynamic_returning_clause2806 = new BitSet(new long[] { 2L });
        FOLLOW_FOR_in_for_loop_statement2829 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_for_loop_statement2831 = new BitSet(new long[] { 32768L });
        FOLLOW_IN_in_for_loop_statement2833 = new BitSet(new long[] { -1125899906842640L, -1L, 63L });
        FOLLOW_set_in_for_loop_statement2837 = new BitSet(new long[] { -16L, -1L, 63L });
        FOLLOW_LOOP_in_for_loop_statement2845 = new BitSet(new long[] { 499622481743840224L, 29343430L });
        FOLLOW_statement_in_for_loop_statement2849 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_for_loop_statement2851 = new BitSet(new long[] { 499631277836862432L, 29343430L });
        FOLLOW_END_in_for_loop_statement2856 = new BitSet(new long[] { 1125899906842624L });
        FOLLOW_LOOP_in_for_loop_statement2858 = new BitSet(new long[] { 130L });
        FOLLOW_label_name_in_for_loop_statement2860 = new BitSet(new long[] { 2L });
        FOLLOW_FORALL_in_forall_statement2882 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_forall_statement2884 = new BitSet(new long[] { 32768L });
        FOLLOW_IN_in_forall_statement2886 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_bounds_clause_in_forall_statement2888 = new BitSet(new long[] { 562949953421312L, 12550144L });
        FOLLOW_sql_statement_in_forall_statement2890 = new BitSet(new long[] { 130L });
        FOLLOW_kSAVE_in_forall_statement2894 = new BitSet(new long[] { 128L });
        FOLLOW_kEXCEPTIONS_in_forall_statement2896 = new BitSet(new long[] { 2L });
        FOLLOW_numeric_expression_in_bounds_clause2918 = new BitSet(new long[] { 0L, 8L });
        FOLLOW_DOUBLEDOT_in_bounds_clause2920 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_numeric_expression_in_bounds_clause2922 = new BitSet(new long[] { 2L });
        FOLLOW_kINDICES_in_bounds_clause2930 = new BitSet(new long[] { 128L });
        FOLLOW_kOF_in_bounds_clause2932 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_atom_in_bounds_clause2934 = new BitSet(new long[] { 2L, 16L });
        FOLLOW_BETWEEN_in_bounds_clause2938 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_numeric_expression_in_bounds_clause2940 = new BitSet(new long[] { 0L, 32L });
        FOLLOW_AND_in_bounds_clause2942 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_numeric_expression_in_bounds_clause2944 = new BitSet(new long[] { 2L });
        FOLLOW_kVALUES_in_bounds_clause2955 = new BitSet(new long[] { 128L });
        FOLLOW_kOF_in_bounds_clause2957 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_atom_in_bounds_clause2959 = new BitSet(new long[] { 2L });
        FOLLOW_GOTO_in_goto_statement2980 = new BitSet(new long[] { 128L });
        FOLLOW_label_name_in_goto_statement2982 = new BitSet(new long[] { 2L });
        FOLLOW_IF_in_if_statement3003 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_expression_in_if_statement3005 = new BitSet(new long[] { 140737488355328L });
        FOLLOW_THEN_in_if_statement3007 = new BitSet(new long[] { 499622481743840224L, 29343430L });
        FOLLOW_statement_in_if_statement3011 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_if_statement3013 = new BitSet(new long[] { 504134877464232928L, 29343686L });
        FOLLOW_ELSIF_in_if_statement3028 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_expression_in_if_statement3030 = new BitSet(new long[] { 140737488355328L });
        FOLLOW_THEN_in_if_statement3032 = new BitSet(new long[] { 499622481743840224L, 29343430L });
        FOLLOW_statement_in_if_statement3036 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_if_statement3038 = new BitSet(new long[] { 504134877464232928L, 29343686L });
        FOLLOW_ELSE_in_if_statement3056 = new BitSet(new long[] { 499622481743840224L, 29343430L });
        FOLLOW_statement_in_if_statement3060 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_if_statement3062 = new BitSet(new long[] { 499631277836862432L, 29343430L });
        FOLLOW_END_in_if_statement3078 = new BitSet(new long[] { 0L, 128L });
        FOLLOW_IF_in_if_statement3080 = new BitSet(new long[] { 2L });
        FOLLOW_NULL_in_null_statement3101 = new BitSet(new long[] { 2L });
        FOLLOW_OPEN_in_open_statement3122 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_open_statement3124 = new BitSet(new long[] { 34359739394L, 2L });
        FOLLOW_DOT_in_open_statement3128 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_open_statement3130 = new BitSet(new long[] { 34359739394L, 2L });
        FOLLOW_call_args_in_open_statement3135 = new BitSet(new long[] { 2L, 2L });
        FOLLOW_FOR_in_open_statement3140 = new BitSet(new long[] { 0L, 1048576L });
        FOLLOW_select_statement_in_open_statement3142 = new BitSet(new long[] { 2L });
        FOLLOW_PRAGMA_in_pragma3166 = new BitSet(new long[] { -48L, -1L, 63L });
        FOLLOW_swallow_to_semi_in_pragma3168 = new BitSet(new long[] { 2L });
        FOLLOW_RAISE_in_raise_statement3189 = new BitSet(new long[] { 130L });
        FOLLOW_ID_in_raise_statement3193 = new BitSet(new long[] { 34359738370L });
        FOLLOW_DOT_in_raise_statement3197 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_raise_statement3199 = new BitSet(new long[] { 34359738370L });
        FOLLOW_RETURN_in_return_statement3226 = new BitSet(new long[] { 281474979857538L, 1053482463264768L });
        FOLLOW_expression_in_return_statement3228 = new BitSet(new long[] { 2L });
        FOLLOW_DECLARE_in_plsql_block3252 = new BitSet(new long[] { 33817056L, 1024L });
        FOLLOW_declare_section_in_plsql_block3254 = new BitSet(new long[] { 4398080328160L, 1024L });
        FOLLOW_body_in_plsql_block3259 = new BitSet(new long[] { 2L });
        FOLLOW_LLABEL_in_label3280 = new BitSet(new long[] { 0L, 8192L });
        FOLLOW_label_in_label3282 = new BitSet(new long[] { 0L, 16384L });
        FOLLOW_RLABEL_in_label3284 = new BitSet(new long[] { 2L });
        FOLLOW_COLON_in_qual_id3298 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_qual_id3301 = new BitSet(new long[] { 34359738370L });
        FOLLOW_DOT_in_qual_id3305 = new BitSet(new long[] { 281474976710784L });
        FOLLOW_COLON_in_qual_id3307 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_qual_id3310 = new BitSet(new long[] { 34359738370L });
        FOLLOW_commit_statement_in_sql_statement3330 = new BitSet(new long[] { 2L });
        FOLLOW_delete_statement_in_sql_statement3338 = new BitSet(new long[] { 2L });
        FOLLOW_insert_statement_in_sql_statement3346 = new BitSet(new long[] { 2L });
        FOLLOW_lock_table_statement_in_sql_statement3354 = new BitSet(new long[] { 2L });
        FOLLOW_rollback_statement_in_sql_statement3362 = new BitSet(new long[] { 2L });
        FOLLOW_savepoint_statement_in_sql_statement3370 = new BitSet(new long[] { 2L });
        FOLLOW_select_statement_in_sql_statement3378 = new BitSet(new long[] { 2L });
        FOLLOW_set_transaction_statement_in_sql_statement3386 = new BitSet(new long[] { 2L });
        FOLLOW_update_statement_in_sql_statement3394 = new BitSet(new long[] { 2L });
        FOLLOW_COMMIT_in_commit_statement3415 = new BitSet(new long[] { -46L, -1L, 63L });
        FOLLOW_swallow_to_semi_in_commit_statement3417 = new BitSet(new long[] { 2L });
        FOLLOW_DELETE_in_delete_statement3439 = new BitSet(new long[] { -48L, -1L, 63L });
        FOLLOW_swallow_to_semi_in_delete_statement3441 = new BitSet(new long[] { 2L });
        FOLLOW_INSERT_in_insert_statement3462 = new BitSet(new long[] { -48L, -1L, 63L });
        FOLLOW_swallow_to_semi_in_insert_statement3464 = new BitSet(new long[] { 2L });
        FOLLOW_LOCK_in_lock_table_statement3485 = new BitSet(new long[] { 2147483648L });
        FOLLOW_TABLE_in_lock_table_statement3487 = new BitSet(new long[] { -48L, -1L, 63L });
        FOLLOW_swallow_to_semi_in_lock_table_statement3489 = new BitSet(new long[] { 2L });
        FOLLOW_ROLLBACK_in_rollback_statement3510 = new BitSet(new long[] { -46L, -1L, 63L });
        FOLLOW_swallow_to_semi_in_rollback_statement3512 = new BitSet(new long[] { 2L });
        FOLLOW_SAVEPOINT_in_savepoint_statement3534 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_savepoint_statement3536 = new BitSet(new long[] { 2L });
        FOLLOW_SELECT_in_select_statement3557 = new BitSet(new long[] { -48L, -1L, 63L });
        FOLLOW_swallow_to_semi_in_select_statement3559 = new BitSet(new long[] { 2L });
        FOLLOW_SET_in_set_transaction_statement3580 = new BitSet(new long[] { 0L, 4194304L });
        FOLLOW_TRANSACTION_in_set_transaction_statement3582 = new BitSet(new long[] { -48L, -1L, 63L });
        FOLLOW_swallow_to_semi_in_set_transaction_statement3584 = new BitSet(new long[] { 2L });
        FOLLOW_UPDATE_in_update_statement3605 = new BitSet(new long[] { -48L, -1L, 63L });
        FOLLOW_swallow_to_semi_in_update_statement3607 = new BitSet(new long[] { 2L });
        FOLLOW_set_in_swallow_to_semi3628 = new BitSet(new long[] { -46L, -1L, 63L });
        FOLLOW_WHILE_in_while_loop_statement3655 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_expression_in_while_loop_statement3657 = new BitSet(new long[] { 1125899906842624L });
        FOLLOW_LOOP_in_while_loop_statement3659 = new BitSet(new long[] { 499622481743840224L, 29343430L });
        FOLLOW_statement_in_while_loop_statement3663 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_while_loop_statement3665 = new BitSet(new long[] { 499631277836862432L, 29343430L });
        FOLLOW_END_in_while_loop_statement3670 = new BitSet(new long[] { 1125899906842624L });
        FOLLOW_LOOP_in_while_loop_statement3672 = new BitSet(new long[] { 130L });
        FOLLOW_label_name_in_while_loop_statement3674 = new BitSet(new long[] { 2L });
        FOLLOW_set_in_match_parens3703 = new BitSet(new long[] { -17404974L, -1L, 63L });
        FOLLOW_RPAREN_in_match_parens3743 = new BitSet(new long[] { -17399856L, -1L, 63L });
        FOLLOW_match_parens_in_match_parens3745 = new BitSet(new long[] { 1024L });
        FOLLOW_LPAREN_in_match_parens3747 = new BitSet(new long[] { 2L });
        FOLLOW_ID_in_label_name3759 = new BitSet(new long[] { 2L });
        FOLLOW_or_expr_in_expression3771 = new BitSet(new long[] { 2L });
        FOLLOW_and_expr_in_or_expr3788 = new BitSet(new long[] { 35184372088834L });
        FOLLOW_OR_in_or_expr3792 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_and_expr_in_or_expr3794 = new BitSet(new long[] { 35184372088834L });
        FOLLOW_not_expr_in_and_expr3814 = new BitSet(new long[] { 2L, 32L });
        FOLLOW_AND_in_and_expr3818 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_not_expr_in_and_expr3820 = new BitSet(new long[] { 2L, 32L });
        FOLLOW_NOT_in_not_expr3840 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_compare_expr_in_not_expr3843 = new BitSet(new long[] { 2L });
        FOLLOW_is_null_expr_in_compare_expr3860 = new BitSet(new long[] { 2L, 2113929216L });
        FOLLOW_set_in_compare_expr3864 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_is_null_expr_in_compare_expr3890 = new BitSet(new long[] { 2L });
        FOLLOW_like_expr_in_is_null_expr3910 = new BitSet(new long[] { 524290L });
        FOLLOW_IS_in_is_null_expr3914 = new BitSet(new long[] { 3145728L });
        FOLLOW_NOT_in_is_null_expr3916 = new BitSet(new long[] { 2097152L });
        FOLLOW_NULL_in_is_null_expr3919 = new BitSet(new long[] { 2L });
        FOLLOW_between_expr_in_like_expr3938 = new BitSet(new long[] { 1048578L, 2147483648L });
        FOLLOW_NOT_in_like_expr3942 = new BitSet(new long[] { 0L, 2147483648L });
        FOLLOW_LIKE_in_like_expr3945 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_between_expr_in_like_expr3947 = new BitSet(new long[] { 2L });
        FOLLOW_in_expr_in_between_expr3967 = new BitSet(new long[] { 1048578L, 16L });
        FOLLOW_NOT_in_between_expr3971 = new BitSet(new long[] { 0L, 16L });
        FOLLOW_BETWEEN_in_between_expr3974 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_in_expr_in_between_expr3976 = new BitSet(new long[] { 0L, 32L });
        FOLLOW_AND_in_between_expr3978 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_in_expr_in_between_expr3980 = new BitSet(new long[] { 2L });
        FOLLOW_add_expr_in_in_expr4000 = new BitSet(new long[] { 1081346L });
        FOLLOW_NOT_in_in_expr4004 = new BitSet(new long[] { 32768L });
        FOLLOW_IN_in_in_expr4007 = new BitSet(new long[] { 1024L });
        FOLLOW_LPAREN_in_in_expr4009 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_add_expr_in_in_expr4011 = new BitSet(new long[] { 6144L });
        FOLLOW_COMMA_in_in_expr4015 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_add_expr_in_in_expr4017 = new BitSet(new long[] { 6144L });
        FOLLOW_RPAREN_in_in_expr4022 = new BitSet(new long[] { 2L });
        FOLLOW_add_expr_in_numeric_expression4042 = new BitSet(new long[] { 2L });
        FOLLOW_mul_expr_in_add_expr4059 = new BitSet(new long[] { 2L, 30064771072L });
        FOLLOW_set_in_add_expr4063 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_mul_expr_in_add_expr4077 = new BitSet(new long[] { 2L, 30064771072L });
        FOLLOW_unary_sign_expr_in_mul_expr4097 = new BitSet(new long[] { 146L, 34359738368L });
        FOLLOW_ASTERISK_in_mul_expr4103 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_DIVIDE_in_mul_expr4107 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_kMOD_in_mul_expr4111 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_unary_sign_expr_in_mul_expr4115 = new BitSet(new long[] { 146L, 34359738368L });
        FOLLOW_set_in_unary_sign_expr4135 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_exponent_expr_in_unary_sign_expr4146 = new BitSet(new long[] { 2L });
        FOLLOW_atom_in_exponent_expr4163 = new BitSet(new long[] { 2L, 68719476736L });
        FOLLOW_EXPONENT_in_exponent_expr4167 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_atom_in_exponent_expr4169 = new BitSet(new long[] { 2L });
        FOLLOW_variable_or_function_call_in_atom4189 = new BitSet(new long[] { 68719476738L });
        FOLLOW_PERCENT_in_atom4193 = new BitSet(new long[] { 128L, 1924145348608L });
        FOLLOW_attribute_in_atom4195 = new BitSet(new long[] { 2L });
        FOLLOW_SQL_in_atom4206 = new BitSet(new long[] { 68719476736L });
        FOLLOW_PERCENT_in_atom4208 = new BitSet(new long[] { 128L, 1924145348608L });
        FOLLOW_attribute_in_atom4210 = new BitSet(new long[] { 2L });
        FOLLOW_string_literal_in_atom4218 = new BitSet(new long[] { 2L });
        FOLLOW_numeric_atom_in_atom4226 = new BitSet(new long[] { 2L });
        FOLLOW_boolean_atom_in_atom4234 = new BitSet(new long[] { 2L });
        FOLLOW_NULL_in_atom4242 = new BitSet(new long[] { 2L });
        FOLLOW_LPAREN_in_atom4250 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_expression_in_atom4252 = new BitSet(new long[] { 4096L });
        FOLLOW_RPAREN_in_atom4254 = new BitSet(new long[] { 2L });
        FOLLOW_call_in_variable_or_function_call4275 = new BitSet(new long[] { 34359738370L });
        FOLLOW_DOT_in_variable_or_function_call4279 = new BitSet(new long[] { 281474976710784L });
        FOLLOW_call_in_variable_or_function_call4281 = new BitSet(new long[] { 34359738370L });
        FOLLOW_DOT_in_variable_or_function_call4288 = new BitSet(new long[] { 562949953421312L });
        FOLLOW_delete_call_in_variable_or_function_call4290 = new BitSet(new long[] { 2L });
        FOLLOW_BULK_ROWCOUNT_in_attribute4310 = new BitSet(new long[] { 1024L });
        FOLLOW_LPAREN_in_attribute4312 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_expression_in_attribute4314 = new BitSet(new long[] { 4096L });
        FOLLOW_RPAREN_in_attribute4316 = new BitSet(new long[] { 2L });
        FOLLOW_kFOUND_in_attribute4324 = new BitSet(new long[] { 2L });
        FOLLOW_ISOPEN_in_attribute4332 = new BitSet(new long[] { 2L });
        FOLLOW_NOTFOUND_in_attribute4340 = new BitSet(new long[] { 2L });
        FOLLOW_kROWCOUNT_in_attribute4348 = new BitSet(new long[] { 2L });
        FOLLOW_LPAREN_in_call_args4365 = new BitSet(new long[] { 281474979861632L, 1053482463264768L });
        FOLLOW_parameter_in_call_args4369 = new BitSet(new long[] { 6144L });
        FOLLOW_COMMA_in_call_args4373 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_parameter_in_call_args4375 = new BitSet(new long[] { 6144L });
        FOLLOW_RPAREN_in_call_args4383 = new BitSet(new long[] { 2L });
        FOLLOW_boolean_literal_in_boolean_atom4400 = new BitSet(new long[] { 2L });
        FOLLOW_collection_exists_in_boolean_atom4408 = new BitSet(new long[] { 2L });
        FOLLOW_conditional_predicate_in_boolean_atom4416 = new BitSet(new long[] { 2L });
        FOLLOW_numeric_literal_in_numeric_atom4433 = new BitSet(new long[] { 2L });
        FOLLOW_set_in_numeric_literal0 = new BitSet(new long[] { 2L });
        FOLLOW_set_in_boolean_literal0 = new BitSet(new long[] { 2L });
        FOLLOW_QUOTED_STRING_in_string_literal4500 = new BitSet(new long[] { 2L });
        FOLLOW_ID_in_collection_exists4517 = new BitSet(new long[] { 34359738368L });
        FOLLOW_DOT_in_collection_exists4519 = new BitSet(new long[] { 0L, 70368744177664L });
        FOLLOW_EXISTS_in_collection_exists4521 = new BitSet(new long[] { 1024L });
        FOLLOW_LPAREN_in_collection_exists4523 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_expression_in_collection_exists4525 = new BitSet(new long[] { 4096L });
        FOLLOW_RPAREN_in_collection_exists4527 = new BitSet(new long[] { 2L });
        FOLLOW_INSERTING_in_conditional_predicate4544 = new BitSet(new long[] { 2L });
        FOLLOW_UPDATING_in_conditional_predicate4552 = new BitSet(new long[] { 1026L });
        FOLLOW_LPAREN_in_conditional_predicate4556 = new BitSet(new long[] { 0L, 35184372088832L });
        FOLLOW_QUOTED_STRING_in_conditional_predicate4558 = new BitSet(new long[] { 4096L });
        FOLLOW_RPAREN_in_conditional_predicate4560 = new BitSet(new long[] { 2L });
        FOLLOW_DELETING_in_conditional_predicate4571 = new BitSet(new long[] { 2L });
        FOLLOW_ID_in_parameter4590 = new BitSet(new long[] { 0L, 1125899906842624L });
        FOLLOW_ARROW_in_parameter4592 = new BitSet(new long[] { 281474979857536L, 1053482463264768L });
        FOLLOW_expression_in_parameter4597 = new BitSet(new long[] { 2L });
        FOLLOW_expression_in_index4614 = new BitSet(new long[] { 2L });
        FOLLOW_CREATE_in_create_package4635 = new BitSet(new long[] { 35184372088832L, 4503599627370496L });
        FOLLOW_OR_in_create_package4639 = new BitSet(new long[] { 128L });
        FOLLOW_kREPLACE_in_create_package4641 = new BitSet(new long[] { 0L, 4503599627370496L });
        FOLLOW_PACKAGE_in_create_package4646 = new BitSet(new long[] { 128L });
        FOLLOW_package_full_name_in_create_package4648 = new BitSet(new long[] { 17301504L, 36028797018963968L });
        FOLLOW_invoker_rights_clause_in_create_package4660 = new BitSet(new long[] { 17301504L });
        FOLLOW_IS_in_create_package4675 = new BitSet(new long[] { 8796126839264L, 1024L });
        FOLLOW_AS_in_create_package4679 = new BitSet(new long[] { 8796126839264L, 1024L });
        FOLLOW_declare_section_in_create_package4685 = new BitSet(new long[] { 8796093022208L });
        FOLLOW_END_in_create_package4690 = new BitSet(new long[] { 160L });
        FOLLOW_ID_in_create_package4694 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_create_package4699 = new BitSet(new long[] { 2L });
        FOLLOW_ID_in_package_full_name4733 = new BitSet(new long[] { 34359738368L });
        FOLLOW_DOT_in_package_full_name4735 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_package_full_name4742 = new BitSet(new long[] { 2L });
        FOLLOW_CREATE_in_create_package_body4767 = new BitSet(new long[] { 35184372088832L, 4503599627370496L });
        FOLLOW_OR_in_create_package_body4771 = new BitSet(new long[] { 128L });
        FOLLOW_kREPLACE_in_create_package_body4773 = new BitSet(new long[] { 0L, 4503599627370496L });
        FOLLOW_PACKAGE_in_create_package_body4778 = new BitSet(new long[] { 0L, 9007199254740992L });
        FOLLOW_BODY_in_create_package_body4780 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_create_package_body4786 = new BitSet(new long[] { 34359738368L });
        FOLLOW_DOT_in_create_package_body4788 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_create_package_body4795 = new BitSet(new long[] { 17301504L });
        FOLLOW_set_in_create_package_body4805 = new BitSet(new long[] { 13194173350368L, 1024L });
        FOLLOW_declare_section_in_create_package_body4817 = new BitSet(new long[] { 13194173350368L, 1024L });
        FOLLOW_body_in_create_package_body4834 = new BitSet(new long[] { 32L });
        FOLLOW_END_in_create_package_body4838 = new BitSet(new long[] { 160L });
        FOLLOW_ID_in_create_package_body4844 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_create_package_body4859 = new BitSet(new long[] { 2L });
        FOLLOW_CREATE_in_create_procedure4885 = new BitSet(new long[] { 35184372088896L });
        FOLLOW_OR_in_create_procedure4889 = new BitSet(new long[] { 128L });
        FOLLOW_kREPLACE_in_create_procedure4891 = new BitSet(new long[] { 64L });
        FOLLOW_PROCEDURE_in_create_procedure4896 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_create_procedure4902 = new BitSet(new long[] { 34359738368L });
        FOLLOW_DOT_in_create_procedure4904 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_create_procedure4911 = new BitSet(new long[] { 17302528L, 36028797018963968L });
        FOLLOW_parameter_declarations_in_create_procedure4931 = new BitSet(new long[] { 17301504L, 36028797018963968L });
        FOLLOW_invoker_rights_clause_in_create_procedure4963 = new BitSet(new long[] { 17301504L });
        FOLLOW_IS_in_create_procedure4976 = new BitSet(new long[] { 4398080328160L, 306244774661194752L });
        FOLLOW_AS_in_create_procedure4980 = new BitSet(new long[] { 4398080328160L, 306244774661194752L });
        FOLLOW_declare_section_in_create_procedure4994 = new BitSet(new long[] { 4398080328160L, 1024L });
        FOLLOW_body_in_create_procedure4997 = new BitSet(new long[] { 32L });
        FOLLOW_call_spec_in_create_procedure5011 = new BitSet(new long[] { 32L });
        FOLLOW_EXTERNAL_in_create_procedure5038 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_create_procedure5067 = new BitSet(new long[] { 2L });
        FOLLOW_CREATE_in_create_function5109 = new BitSet(new long[] { 35184372089088L });
        FOLLOW_OR_in_create_function5113 = new BitSet(new long[] { 128L });
        FOLLOW_kREPLACE_in_create_function5115 = new BitSet(new long[] { 256L });
        FOLLOW_FUNCTION_in_create_function5120 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_create_function5126 = new BitSet(new long[] { 34359738368L });
        FOLLOW_DOT_in_create_function5128 = new BitSet(new long[] { 128L });
        FOLLOW_ID_in_create_function5135 = new BitSet(new long[] { 1536L });
        FOLLOW_parameter_declarations_in_create_function5155 = new BitSet(new long[] { 512L });
        FOLLOW_RETURN_in_create_function5175 = new BitSet(new long[] { 17179869312L });
        FOLLOW_datatype_in_create_function5177 = new BitSet(new long[] { 17301504L, 36028797018963968L });
        FOLLOW_invoker_rights_clause_in_create_function5197 = new BitSet(new long[] { 17301504L });
        FOLLOW_set_in_create_function5208 = new BitSet(new long[] { 4398080328160L, 306244774661194752L });
        FOLLOW_declare_section_in_create_function5228 = new BitSet(new long[] { 4398080328160L, 1024L });
        FOLLOW_body_in_create_function5231 = new BitSet(new long[] { 32L });
        FOLLOW_call_spec_in_create_function5243 = new BitSet(new long[] { 32L });
        FOLLOW_EXTERNAL_in_create_function5255 = new BitSet(new long[] { 32L });
        FOLLOW_SEMI_in_create_function5267 = new BitSet(new long[] { 2L });
        FOLLOW_AUTHID_in_invoker_rights_clause5288 = new BitSet(new long[] { 0L, 216172782113783808L });
        FOLLOW_set_in_invoker_rights_clause5290 = new BitSet(new long[] { 2L });
        FOLLOW_LANGUAGE_in_call_spec5315 = new BitSet(new long[] { -48L, -1L, 63L });
        FOLLOW_swallow_to_semi_in_call_spec5317 = new BitSet(new long[] { 2L });
        FOLLOW_CREATE_in_create_type5334 = new BitSet(new long[] { 35184372088960L });
        FOLLOW_OR_in_create_type5338 = new BitSet(new long[] { 128L });
        FOLLOW_kREPLACE_in_create_type5340 = new BitSet(new long[] { 128L });
        FOLLOW_type_definition_in_create_type5345 = new BitSet(new long[] { 2L });
        FOLLOW_ID_in_kERRORS5356 = new BitSet(new long[] { 2L });
        FOLLOW_ID_in_kEXCEPTIONS5365 = new BitSet(new long[] { 2L });
        FOLLOW_ID_in_kFOUND5374 = new BitSet(new long[] { 2L });
        FOLLOW_ID_in_kINDICES5383 = new BitSet(new long[] { 2L });
        FOLLOW_ID_in_kMOD5392 = new BitSet(new long[] { 2L });
        FOLLOW_ID_in_kNAME5401 = new BitSet(new long[] { 2L });
        FOLLOW_ID_in_kOF5410 = new BitSet(new long[] { 2L });
        FOLLOW_ID_in_kREPLACE5419 = new BitSet(new long[] { 2L });
        FOLLOW_ID_in_kROWCOUNT5428 = new BitSet(new long[] { 2L });
        FOLLOW_ID_in_kSAVE5437 = new BitSet(new long[] { 2L });
        FOLLOW_ID_in_kSHOW5446 = new BitSet(new long[] { 2L });
        FOLLOW_ID_in_kTYPE5455 = new BitSet(new long[] { 2L });
        FOLLOW_ID_in_kVALUES5464 = new BitSet(new long[] { 2L });
    }
    
    public PLSQL2Parser(final TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    
    public PLSQL2Parser(final TokenStream input, final RecognizerSharedState state) {
        super(input, state);
        this.adaptor = (TreeAdaptor)new CommonTreeAdaptor();
        this.m_procedureList = new ArrayList();
        this.m_functionList = new ArrayList();
        this.m_typeList = new ArrayList();
        this.dfa5 = new DFA5((BaseRecognizer)this);
        this.dfa15 = new DFA15((BaseRecognizer)this);
        this.dfa96 = new DFA96((BaseRecognizer)this);
        this.dfa139 = new DFA139((BaseRecognizer)this);
    }
    
    public void setTreeAdaptor(final TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    
    public TreeAdaptor getTreeAdaptor() {
        return this.adaptor;
    }
    
    public String[] getTokenNames() {
        return PLSQL2Parser.tokenNames;
    }
    
    public String getGrammarFileName() {
        return "generator/src/com/uframe/generator/provider/db/procedure/PLSQL2.g";
    }
    
    public List getProcedureList() {
        return this.m_procedureList;
    }
    
    public List getFunctionList() {
        return this.m_functionList;
    }
    
    public List getTypeList() {
        return this.m_typeList;
    }
    
    public String getErrorHeader(final RecognitionException e) {
        return String.valueOf(this.getSourceName()) + ":" + e.line + ":" + (e.charPositionInLine + 1) + ":";
    }
    
    public String getErrorMessage(final RecognitionException e, final String[] tokenNames) {
        final List stack = getRuleInvocationStack((Throwable)e, this.getClass().getName());
        String msg = null;
        if (e instanceof NoViableAltException) {
            final NoViableAltException nvae = (NoViableAltException)e;
            msg = " no viable alt; token=" + e.token + " (decision=" + nvae.decisionNumber + " state " + nvae.stateNumber + ")" + " decision=<<" + nvae.grammarDecisionDescription + ">>";
        }
        else {
            msg = super.getErrorMessage(e, tokenNames);
        }
        return stack + " " + msg;
    }
    
    public String getTokenErrorDisplay(final Token t) {
        return t.toString();
    }
    
    public final sqlplus_file_return sqlplus_file() throws RecognitionException {
        final sqlplus_file_return retval = new sqlplus_file_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token DIVIDE2 = null;
        Token DIVIDE3 = null;
        Token EOF5 = null;
        create_object_return create_object1 = null;
        show_errors_return show_errors3 = null;
        Object DIVIDE2_tree = null;
        Object DIVIDE4_tree = null;
        Object EOF5_tree = null;
        Label_0554: {
            try {
                root_0 = this.adaptor.nil();
                int cnt3 = 0;
                while (true) {
                    int alt3 = 2;
                    final int LA3_0 = this.input.LA(1);
                    if (LA3_0 == 115) {
                        alt3 = 1;
                    }
                    switch (alt3) {
                        case 1: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_create_object_in_sqlplus_file62);
                            create_object1 = this.create_object();
                            final RecognizerSharedState state = this.state;
                            --state._fsp;
                            this.adaptor.addChild(root_0, create_object1.getTree());
                            int alt4 = 2;
                            final int LA1_0 = this.input.LA(1);
                            if (LA1_0 == 4) {
                                final int LA1_2 = this.input.LA(2);
                                if (LA1_2 == 7) {
                                    alt4 = 1;
                                }
                            }
                            switch (alt4) {
                                case 1: {
                                    DIVIDE2 = (Token)this.match((IntStream)this.input, 4, PLSQL2Parser.FOLLOW_DIVIDE_in_sqlplus_file66);
                                    DIVIDE2_tree = this.adaptor.create(DIVIDE2);
                                    this.adaptor.addChild(root_0, DIVIDE2_tree);
                                    this.pushFollow(PLSQL2Parser.FOLLOW_show_errors_in_sqlplus_file68);
                                    show_errors3 = this.show_errors();
                                    final RecognizerSharedState state2 = this.state;
                                    --state2._fsp;
                                    this.adaptor.addChild(root_0, show_errors3.getTree());
                                    break;
                                }
                            }
                            int alt5 = 2;
                            final int LA2_0 = this.input.LA(1);
                            if (LA2_0 == 4) {
                                alt5 = 1;
                            }
                            switch (alt5) {
                                case 1: {
                                    DIVIDE3 = (Token)this.match((IntStream)this.input, 4, PLSQL2Parser.FOLLOW_DIVIDE_in_sqlplus_file73);
                                    DIVIDE4_tree = this.adaptor.create(DIVIDE3);
                                    this.adaptor.addChild(root_0, DIVIDE4_tree);
                                    break;
                                }
                            }
                            ++cnt3;
                            continue;
                        }
                        default: {
                            if (cnt3 >= 1) {
                                EOF5 = (Token)this.match((IntStream)this.input, -1, PLSQL2Parser.FOLLOW_EOF_in_sqlplus_file79);
                                EOF5_tree = this.adaptor.create(EOF5);
                                this.adaptor.addChild(root_0, EOF5_tree);
                                retval.stop = this.input.LT(-1);
                                retval.tree = this.adaptor.rulePostProcessing(root_0);
                                this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                                break Label_0554;
                            }
                            final EarlyExitException eee = new EarlyExitException(3, (IntStream)this.input);
                            throw eee;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final show_errors_return show_errors() throws RecognitionException {
        final show_errors_return retval = new show_errors_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token SEMI8 = null;
        kSHOW_return kSHOW6 = null;
        kERRORS_return kERRORS7 = null;
        Object SEMI8_tree = null;
        try {
            root_0 = this.adaptor.nil();
            this.pushFollow(PLSQL2Parser.FOLLOW_kSHOW_in_show_errors100);
            kSHOW6 = this.kSHOW();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, kSHOW6.getTree());
            this.pushFollow(PLSQL2Parser.FOLLOW_kERRORS_in_show_errors102);
            kERRORS7 = this.kERRORS();
            final RecognizerSharedState state2 = this.state;
            --state2._fsp;
            this.adaptor.addChild(root_0, kERRORS7.getTree());
            int alt4 = 2;
            final int LA4_0 = this.input.LA(1);
            if (LA4_0 == 5) {
                alt4 = 1;
            }
            switch (alt4) {
                case 1: {
                    SEMI8 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_show_errors104);
                    SEMI8_tree = this.adaptor.create(SEMI8);
                    this.adaptor.addChild(root_0, SEMI8_tree);
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final create_object_return create_object() throws RecognitionException {
        final create_object_return retval = new create_object_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        create_package_return create_package9 = null;
        create_package_body_return create_package_body10 = null;
        create_function_return create_function11 = null;
        create_procedure_return create_procedure12 = null;
        create_type_return create_type13 = null;
        try {
            int alt5 = 5;
            alt5 = this.dfa5.predict((IntStream)this.input);
            switch (alt5) {
                case 1: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_create_package_in_create_object122);
                    create_package9 = this.create_package();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    this.adaptor.addChild(root_0, create_package9.getTree());
                    break;
                }
                case 2: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_create_package_body_in_create_object130);
                    create_package_body10 = this.create_package_body();
                    final RecognizerSharedState state2 = this.state;
                    --state2._fsp;
                    this.adaptor.addChild(root_0, create_package_body10.getTree());
                    break;
                }
                case 3: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_create_function_in_create_object138);
                    create_function11 = this.create_function();
                    final RecognizerSharedState state3 = this.state;
                    --state3._fsp;
                    this.adaptor.addChild(root_0, create_function11.getTree());
                    break;
                }
                case 4: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_create_procedure_in_create_object146);
                    create_procedure12 = this.create_procedure();
                    final RecognizerSharedState state4 = this.state;
                    --state4._fsp;
                    this.adaptor.addChild(root_0, create_procedure12.getTree());
                    break;
                }
                case 5: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_create_type_in_create_object154);
                    create_type13 = this.create_type();
                    final RecognizerSharedState state5 = this.state;
                    --state5._fsp;
                    this.adaptor.addChild(root_0, create_type13.getTree());
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final procedure_heading_return procedure_heading() throws RecognitionException {
        final procedure_heading_return retval = new procedure_heading_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token PROCEDURE14 = null;
        Token ID15 = null;
        parameter_declarations_return temp3 = null;
        final Object PROCEDURE14_tree = null;
        final Object ID15_tree = null;
        final RewriteRuleTokenStream stream_ID = new RewriteRuleTokenStream(this.adaptor, "token ID");
        final RewriteRuleTokenStream stream_PROCEDURE = new RewriteRuleTokenStream(this.adaptor, "token PROCEDURE");
        final RewriteRuleSubtreeStream stream_parameter_declarations = new RewriteRuleSubtreeStream(this.adaptor, "rule parameter_declarations");
        try {
            retval.r_procedureDef = new HashMap();
            PROCEDURE14 = (Token)this.match((IntStream)this.input, 6, PLSQL2Parser.FOLLOW_PROCEDURE_in_procedure_heading182);
            stream_PROCEDURE.add((Object)PROCEDURE14);
            ID15 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_procedure_heading184);
            stream_ID.add((Object)ID15);
            retval.r_procedureDef.put("id", (ID15 != null) ? ID15.getText() : null);
            int alt6 = 2;
            final int LA6_0 = this.input.LA(1);
            if (LA6_0 == 10) {
                alt6 = 1;
            }
            switch (alt6) {
                case 1: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_parameter_declarations_in_procedure_heading207);
                    temp3 = this.parameter_declarations();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    stream_parameter_declarations.add(temp3.getTree());
                    break;
                }
            }
            retval.r_procedureDef.put("paramList", (temp3 != null) ? temp3.r_parameter_list : null);
            this.m_procedureList.add(retval.r_procedureDef);
            retval.tree = root_0;
            final RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(this.adaptor, "rule retval", (retval != null) ? retval.tree : null);
            root_0 = this.adaptor.nil();
            Object root_2 = this.adaptor.nil();
            root_2 = this.adaptor.becomeRoot(stream_PROCEDURE.nextNode(), root_2);
            this.adaptor.addChild(root_2, stream_ID.nextNode());
            if (stream_parameter_declarations.hasNext()) {
                this.adaptor.addChild(root_2, stream_parameter_declarations.nextTree());
            }
            stream_parameter_declarations.reset();
            this.adaptor.addChild(root_0, root_2);
            retval.tree = root_0;
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final function_heading_return function_heading() throws RecognitionException {
        final function_heading_return retval = new function_heading_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token FUNCTION16 = null;
        Token ID17 = null;
        Token RETURN18 = null;
        parameter_declarations_return temp4 = null;
        datatype_return datatype19 = null;
        final Object FUNCTION16_tree = null;
        final Object ID17_tree = null;
        final Object RETURN18_tree = null;
        final RewriteRuleTokenStream stream_FUNCTION = new RewriteRuleTokenStream(this.adaptor, "token FUNCTION");
        final RewriteRuleTokenStream stream_ID = new RewriteRuleTokenStream(this.adaptor, "token ID");
        final RewriteRuleTokenStream stream_RETURN = new RewriteRuleTokenStream(this.adaptor, "token RETURN");
        final RewriteRuleSubtreeStream stream_parameter_declarations = new RewriteRuleSubtreeStream(this.adaptor, "rule parameter_declarations");
        final RewriteRuleSubtreeStream stream_datatype = new RewriteRuleSubtreeStream(this.adaptor, "rule datatype");
        try {
            retval.r_functionDef = new HashMap();
            FUNCTION16 = (Token)this.match((IntStream)this.input, 8, PLSQL2Parser.FOLLOW_FUNCTION_in_function_heading282);
            stream_FUNCTION.add((Object)FUNCTION16);
            ID17 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_function_heading284);
            stream_ID.add((Object)ID17);
            retval.r_functionDef.put("id", (ID17 != null) ? ID17.getText() : null);
            int alt7 = 2;
            final int LA7_0 = this.input.LA(1);
            if (LA7_0 == 10) {
                alt7 = 1;
            }
            switch (alt7) {
                case 1: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_parameter_declarations_in_function_heading306);
                    temp4 = this.parameter_declarations();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    stream_parameter_declarations.add(temp4.getTree());
                    break;
                }
            }
            retval.r_functionDef.put("paramList", (temp4 != null) ? temp4.r_parameter_list : null);
            RETURN18 = (Token)this.match((IntStream)this.input, 9, PLSQL2Parser.FOLLOW_RETURN_in_function_heading327);
            stream_RETURN.add((Object)RETURN18);
            this.pushFollow(PLSQL2Parser.FOLLOW_datatype_in_function_heading329);
            datatype19 = this.datatype();
            final RecognizerSharedState state2 = this.state;
            --state2._fsp;
            stream_datatype.add(datatype19.getTree());
            retval.r_functionDef.put("returnType", (datatype19 != null) ? this.input.toString(datatype19.start, datatype19.stop) : null);
            this.m_functionList.add(retval.r_functionDef);
            retval.tree = root_0;
            final RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(this.adaptor, "rule retval", (retval != null) ? retval.tree : null);
            root_0 = this.adaptor.nil();
            Object root_2 = this.adaptor.nil();
            root_2 = this.adaptor.becomeRoot(stream_FUNCTION.nextNode(), root_2);
            this.adaptor.addChild(root_2, stream_ID.nextNode());
            if (stream_parameter_declarations.hasNext()) {
                this.adaptor.addChild(root_2, stream_parameter_declarations.nextTree());
            }
            stream_parameter_declarations.reset();
            this.adaptor.addChild(root_2, stream_datatype.nextTree());
            this.adaptor.addChild(root_0, root_2);
            retval.tree = root_0;
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final parameter_declarations_return parameter_declarations() throws RecognitionException {
        final parameter_declarations_return retval = new parameter_declarations_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token LPAREN20 = null;
        Token COMMA21 = null;
        Token RPAREN22 = null;
        parameter_declaration_return temp1 = null;
        parameter_declaration_return temp2 = null;
        final Object LPAREN20_tree = null;
        final Object COMMA21_tree = null;
        final Object RPAREN22_tree = null;
        final RewriteRuleTokenStream stream_RPAREN = new RewriteRuleTokenStream(this.adaptor, "token RPAREN");
        final RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(this.adaptor, "token COMMA");
        final RewriteRuleTokenStream stream_LPAREN = new RewriteRuleTokenStream(this.adaptor, "token LPAREN");
        final RewriteRuleSubtreeStream stream_parameter_declaration = new RewriteRuleSubtreeStream(this.adaptor, "rule parameter_declaration");
        Label_0583: {
            try {
                retval.r_parameter_list = new ArrayList();
                LPAREN20 = (Token)this.match((IntStream)this.input, 10, PLSQL2Parser.FOLLOW_LPAREN_in_parameter_declarations405);
                stream_LPAREN.add((Object)LPAREN20);
                this.pushFollow(PLSQL2Parser.FOLLOW_parameter_declaration_in_parameter_declarations410);
                temp1 = this.parameter_declaration();
                final RecognizerSharedState state = this.state;
                --state._fsp;
                stream_parameter_declaration.add(temp1.getTree());
                retval.r_parameter_list.add((temp1 != null) ? temp1.r_parameter : null);
                while (true) {
                    int alt8 = 2;
                    final int LA8_0 = this.input.LA(1);
                    if (LA8_0 == 11) {
                        alt8 = 1;
                    }
                    switch (alt8) {
                        case 1: {
                            COMMA21 = (Token)this.match((IntStream)this.input, 11, PLSQL2Parser.FOLLOW_COMMA_in_parameter_declarations434);
                            stream_COMMA.add((Object)COMMA21);
                            this.pushFollow(PLSQL2Parser.FOLLOW_parameter_declaration_in_parameter_declarations439);
                            temp2 = this.parameter_declaration();
                            final RecognizerSharedState state2 = this.state;
                            --state2._fsp;
                            stream_parameter_declaration.add(temp2.getTree());
                            retval.r_parameter_list.add((temp2 != null) ? temp2.r_parameter : null);
                            continue;
                        }
                        default: {
                            RPAREN22 = (Token)this.match((IntStream)this.input, 12, PLSQL2Parser.FOLLOW_RPAREN_in_parameter_declarations466);
                            stream_RPAREN.add((Object)RPAREN22);
                            retval.tree = root_0;
                            final RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(this.adaptor, "rule retval", (retval != null) ? retval.tree : null);
                            root_0 = this.adaptor.nil();
                            Object root_2 = this.adaptor.nil();
                            root_2 = this.adaptor.becomeRoot(stream_parameter_declaration.nextNode(), root_2);
                            while (stream_parameter_declaration.hasNext()) {
                                this.adaptor.addChild(root_2, stream_parameter_declaration.nextTree());
                            }
                            stream_parameter_declaration.reset();
                            this.adaptor.addChild(root_0, root_2);
                            retval.tree = root_0;
                            retval.stop = this.input.LT(-1);
                            retval.tree = this.adaptor.rulePostProcessing(root_0);
                            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                            break Label_0583;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final parameter_declaration_return parameter_declaration() throws RecognitionException {
        final parameter_declaration_return retval = new parameter_declaration_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ID23 = null;
        Token ASSIGN26 = null;
        Token DEFAULT27 = null;
        param_type_return param_type24 = null;
        datatype_return datatype25 = null;
        expression_return expression28 = null;
        final Object ID23_tree = null;
        final Object ASSIGN26_tree = null;
        final Object DEFAULT27_tree = null;
        final RewriteRuleTokenStream stream_ID = new RewriteRuleTokenStream(this.adaptor, "token ID");
        final RewriteRuleTokenStream stream_DEFAULT = new RewriteRuleTokenStream(this.adaptor, "token DEFAULT");
        final RewriteRuleTokenStream stream_ASSIGN = new RewriteRuleTokenStream(this.adaptor, "token ASSIGN");
        final RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(this.adaptor, "rule expression");
        final RewriteRuleSubtreeStream stream_param_type = new RewriteRuleSubtreeStream(this.adaptor, "rule param_type");
        final RewriteRuleSubtreeStream stream_datatype = new RewriteRuleSubtreeStream(this.adaptor, "rule datatype");
        try {
            retval.r_parameter = new HashMap();
            ID23 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_parameter_declaration522);
            stream_ID.add((Object)ID23);
            int alt9 = 2;
            final int LA9_0 = this.input.LA(1);
            if (LA9_0 >= 15 && LA9_0 <= 16) {
                alt9 = 1;
            }
            switch (alt9) {
                case 1: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_param_type_in_parameter_declaration524);
                    param_type24 = this.param_type();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    stream_param_type.add(param_type24.getTree());
                    break;
                }
            }
            this.pushFollow(PLSQL2Parser.FOLLOW_datatype_in_parameter_declaration527);
            datatype25 = this.datatype();
            final RecognizerSharedState state2 = this.state;
            --state2._fsp;
            stream_datatype.add(datatype25.getTree());
            int alt10 = 2;
            final int LA11_0 = this.input.LA(1);
            if (LA11_0 >= 13 && LA11_0 <= 14) {
                alt10 = 1;
            }
            switch (alt10) {
                case 1: {
                    int alt11 = 2;
                    final int LA10_0 = this.input.LA(1);
                    if (LA10_0 == 13) {
                        alt11 = 1;
                    }
                    else {
                        if (LA10_0 != 14) {
                            final NoViableAltException nvae = new NoViableAltException("", 10, 0, (IntStream)this.input);
                            throw nvae;
                        }
                        alt11 = 2;
                    }
                    switch (alt11) {
                        case 1: {
                            ASSIGN26 = (Token)this.match((IntStream)this.input, 13, PLSQL2Parser.FOLLOW_ASSIGN_in_parameter_declaration542);
                            stream_ASSIGN.add((Object)ASSIGN26);
                            break;
                        }
                        case 2: {
                            DEFAULT27 = (Token)this.match((IntStream)this.input, 14, PLSQL2Parser.FOLLOW_DEFAULT_in_parameter_declaration546);
                            stream_DEFAULT.add((Object)DEFAULT27);
                            break;
                        }
                    }
                    this.pushFollow(PLSQL2Parser.FOLLOW_expression_in_parameter_declaration550);
                    expression28 = this.expression();
                    final RecognizerSharedState state3 = this.state;
                    --state3._fsp;
                    stream_expression.add(expression28.getTree());
                    break;
                }
            }
            retval.tree = root_0;
            final RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(this.adaptor, "rule retval", (retval != null) ? retval.tree : null);
            root_0 = this.adaptor.nil();
            Object root_2 = this.adaptor.nil();
            root_2 = this.adaptor.becomeRoot(stream_ID.nextNode(), root_2);
            this.adaptor.addChild(root_2, (Object)retval.r_parameter.put("id", (ID23 != null) ? ID23.getText() : null));
            if (stream_param_type.hasNext()) {
                this.adaptor.addChild(root_2, stream_param_type.nextTree());
                this.adaptor.addChild(root_2, (Object)retval.r_parameter.put("paramType", (param_type24 != null) ? this.input.toString(param_type24.start, param_type24.stop) : null));
            }
            stream_param_type.reset();
            this.adaptor.addChild(root_2, stream_datatype.nextTree());
            this.adaptor.addChild(root_2, (Object)retval.r_parameter.put("dataType", (datatype25 != null) ? this.input.toString(datatype25.start, datatype25.stop) : null));
            this.adaptor.addChild(root_0, root_2);
            retval.tree = root_0;
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final param_type_return param_type() throws RecognitionException {
        final param_type_return retval = new param_type_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token IN29 = null;
        Token OUT30 = null;
        Token IN30 = null;
        Token OUT31 = null;
        Token NOCOPY33 = null;
        Object IN29_tree = null;
        Object OUT30_tree = null;
        Object IN31_tree = null;
        Object OUT32_tree = null;
        Object NOCOPY33_tree = null;
        try {
            root_0 = this.adaptor.nil();
            int alt14 = 2;
            final int LA14_0 = this.input.LA(1);
            if (LA14_0 == 15) {
                final int LA14_2 = this.input.LA(2);
                if (LA14_2 == 16) {
                    alt14 = 2;
                }
                else {
                    if (LA14_2 != 7 && LA14_2 != 34) {
                        final NoViableAltException nvae = new NoViableAltException("", 14, 1, (IntStream)this.input);
                        throw nvae;
                    }
                    alt14 = 1;
                }
            }
            else {
                if (LA14_0 != 16) {
                    final NoViableAltException nvae2 = new NoViableAltException("", 14, 0, (IntStream)this.input);
                    throw nvae2;
                }
                alt14 = 2;
            }
            Label_0563: {
                switch (alt14) {
                    case 1: {
                        IN29 = (Token)this.match((IntStream)this.input, 15, PLSQL2Parser.FOLLOW_IN_in_param_type681);
                        IN29_tree = this.adaptor.create(IN29);
                        this.adaptor.addChild(root_0, IN29_tree);
                        break;
                    }
                    case 2: {
                        int alt15 = 2;
                        final int LA12_0 = this.input.LA(1);
                        if (LA12_0 == 16) {
                            alt15 = 1;
                        }
                        else {
                            if (LA12_0 != 15) {
                                final NoViableAltException nvae3 = new NoViableAltException("", 12, 0, (IntStream)this.input);
                                throw nvae3;
                            }
                            alt15 = 2;
                        }
                        switch (alt15) {
                            case 1: {
                                OUT30 = (Token)this.match((IntStream)this.input, 16, PLSQL2Parser.FOLLOW_OUT_in_param_type689);
                                OUT30_tree = this.adaptor.create(OUT30);
                                this.adaptor.addChild(root_0, OUT30_tree);
                                break;
                            }
                            case 2: {
                                IN30 = (Token)this.match((IntStream)this.input, 15, PLSQL2Parser.FOLLOW_IN_in_param_type693);
                                IN31_tree = this.adaptor.create(IN30);
                                this.adaptor.addChild(root_0, IN31_tree);
                                OUT31 = (Token)this.match((IntStream)this.input, 16, PLSQL2Parser.FOLLOW_OUT_in_param_type695);
                                OUT32_tree = this.adaptor.create(OUT31);
                                this.adaptor.addChild(root_0, OUT32_tree);
                                break;
                            }
                        }
                        int alt16 = 2;
                        final int LA13_0 = this.input.LA(1);
                        if (LA13_0 == 17) {
                            alt16 = 1;
                        }
                        switch (alt16) {
                            case 1: {
                                NOCOPY33 = (Token)this.match((IntStream)this.input, 17, PLSQL2Parser.FOLLOW_NOCOPY_in_param_type699);
                                NOCOPY33_tree = this.adaptor.create(NOCOPY33);
                                this.adaptor.addChild(root_0, NOCOPY33_tree);
                                break Label_0563;
                            }
                        }
                        break;
                    }
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final declare_section_return declare_section() throws RecognitionException {
        final declare_section_return retval = new declare_section_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token SEMI35 = null;
        Token SEMI36 = null;
        Token SEMI37 = null;
        Token SEMI38 = null;
        Token SEMI39 = null;
        Token SEMI40 = null;
        Token SEMI41 = null;
        type_definition_return type_definition34 = null;
        subtype_definition_return subtype_definition36 = null;
        cursor_definition_return cursor_definition38 = null;
        item_declaration_return item_declaration40 = null;
        function_declaration_or_definition_return function_declaration_or_definition42 = null;
        procedure_declaration_or_definition_return procedure_declaration_or_definition44 = null;
        pragma_return pragma46 = null;
        final Object SEMI35_tree = null;
        final Object SEMI37_tree = null;
        final Object SEMI39_tree = null;
        final Object SEMI41_tree = null;
        final Object SEMI43_tree = null;
        final Object SEMI45_tree = null;
        final Object SEMI47_tree = null;
        Label_0800: {
            try {
                root_0 = this.adaptor.nil();
                int cnt15 = 0;
                while (true) {
                    int alt15 = 8;
                    alt15 = this.dfa15.predict((IntStream)this.input);
                    switch (alt15) {
                        case 1: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_type_definition_in_declare_section729);
                            type_definition34 = this.type_definition();
                            final RecognizerSharedState state = this.state;
                            --state._fsp;
                            this.adaptor.addChild(root_0, type_definition34.getTree());
                            SEMI35 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_declare_section731);
                            retval.construct = ((type_definition34 != null) ? this.input.toString(type_definition34.start, type_definition34.stop) : null);
                            break;
                        }
                        case 2: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_subtype_definition_in_declare_section743);
                            subtype_definition36 = this.subtype_definition();
                            final RecognizerSharedState state2 = this.state;
                            --state2._fsp;
                            this.adaptor.addChild(root_0, subtype_definition36.getTree());
                            SEMI36 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_declare_section745);
                            break;
                        }
                        case 3: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_cursor_definition_in_declare_section754);
                            cursor_definition38 = this.cursor_definition();
                            final RecognizerSharedState state3 = this.state;
                            --state3._fsp;
                            this.adaptor.addChild(root_0, cursor_definition38.getTree());
                            SEMI37 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_declare_section756);
                            break;
                        }
                        case 4: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_item_declaration_in_declare_section765);
                            item_declaration40 = this.item_declaration();
                            final RecognizerSharedState state4 = this.state;
                            --state4._fsp;
                            this.adaptor.addChild(root_0, item_declaration40.getTree());
                            SEMI38 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_declare_section767);
                            break;
                        }
                        case 5: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_function_declaration_or_definition_in_declare_section776);
                            function_declaration_or_definition42 = this.function_declaration_or_definition();
                            final RecognizerSharedState state5 = this.state;
                            --state5._fsp;
                            this.adaptor.addChild(root_0, function_declaration_or_definition42.getTree());
                            SEMI39 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_declare_section778);
                            retval.construct = ((function_declaration_or_definition42 != null) ? function_declaration_or_definition42.construct : null);
                            break;
                        }
                        case 6: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_procedure_declaration_or_definition_in_declare_section789);
                            procedure_declaration_or_definition44 = this.procedure_declaration_or_definition();
                            final RecognizerSharedState state6 = this.state;
                            --state6._fsp;
                            this.adaptor.addChild(root_0, procedure_declaration_or_definition44.getTree());
                            SEMI40 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_declare_section791);
                            retval.construct = ((procedure_declaration_or_definition44 != null) ? procedure_declaration_or_definition44.construct : null);
                            System.out.println(retval.construct);
                            break;
                        }
                        case 7: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_pragma_in_declare_section802);
                            pragma46 = this.pragma();
                            final RecognizerSharedState state7 = this.state;
                            --state7._fsp;
                            this.adaptor.addChild(root_0, pragma46.getTree());
                            SEMI41 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_declare_section804);
                            break;
                        }
                        default: {
                            if (cnt15 >= 1) {
                                retval.stop = this.input.LT(-1);
                                retval.tree = this.adaptor.rulePostProcessing(root_0);
                                this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                                break Label_0800;
                            }
                            final EarlyExitException eee = new EarlyExitException(15, (IntStream)this.input);
                            throw eee;
                        }
                    }
                    ++cnt15;
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final cursor_definition_return cursor_definition() throws RecognitionException {
        final cursor_definition_return retval = new cursor_definition_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token CURSOR48 = null;
        Token ID49 = null;
        Token IS51 = null;
        parameter_declarations_return parameter_declarations50 = null;
        select_statement_return select_statement52 = null;
        Object CURSOR48_tree = null;
        Object ID49_tree = null;
        Object IS51_tree = null;
        try {
            root_0 = this.adaptor.nil();
            CURSOR48 = (Token)this.match((IntStream)this.input, 18, PLSQL2Parser.FOLLOW_CURSOR_in_cursor_definition833);
            CURSOR48_tree = this.adaptor.create(CURSOR48);
            this.adaptor.addChild(root_0, CURSOR48_tree);
            ID49 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_cursor_definition835);
            ID49_tree = this.adaptor.create(ID49);
            this.adaptor.addChild(root_0, ID49_tree);
            int alt16 = 2;
            final int LA16_0 = this.input.LA(1);
            if (LA16_0 == 10) {
                alt16 = 1;
            }
            switch (alt16) {
                case 1: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_parameter_declarations_in_cursor_definition837);
                    parameter_declarations50 = this.parameter_declarations();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    this.adaptor.addChild(root_0, parameter_declarations50.getTree());
                    break;
                }
            }
            IS51 = (Token)this.match((IntStream)this.input, 19, PLSQL2Parser.FOLLOW_IS_in_cursor_definition840);
            IS51_tree = this.adaptor.create(IS51);
            this.adaptor.addChild(root_0, IS51_tree);
            this.pushFollow(PLSQL2Parser.FOLLOW_select_statement_in_cursor_definition842);
            select_statement52 = this.select_statement();
            final RecognizerSharedState state2 = this.state;
            --state2._fsp;
            this.adaptor.addChild(root_0, select_statement52.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final item_declaration_return item_declaration() throws RecognitionException {
        final item_declaration_return retval = new item_declaration_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        variable_declaration_return variable_declaration53 = null;
        constant_declaration_return constant_declaration54 = null;
        exception_declaration_return exception_declaration55 = null;
        try {
            int alt17 = 3;
            final int LA17_0 = this.input.LA(1);
            if (LA17_0 != 7) {
                final NoViableAltException nvae = new NoViableAltException("", 17, 0, (IntStream)this.input);
                throw nvae;
            }
            switch (this.input.LA(2)) {
                case 22: {
                    alt17 = 2;
                    break;
                }
                case 23: {
                    alt17 = 3;
                    break;
                }
                case 7:
                case 34: {
                    alt17 = 1;
                    break;
                }
                default: {
                    final NoViableAltException nvae = new NoViableAltException("", 17, 1, (IntStream)this.input);
                    throw nvae;
                }
            }
            switch (alt17) {
                case 1: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_variable_declaration_in_item_declaration859);
                    variable_declaration53 = this.variable_declaration();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    this.adaptor.addChild(root_0, variable_declaration53.getTree());
                    break;
                }
                case 2: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_constant_declaration_in_item_declaration867);
                    constant_declaration54 = this.constant_declaration();
                    final RecognizerSharedState state2 = this.state;
                    --state2._fsp;
                    this.adaptor.addChild(root_0, constant_declaration54.getTree());
                    break;
                }
                case 3: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_exception_declaration_in_item_declaration875);
                    exception_declaration55 = this.exception_declaration();
                    final RecognizerSharedState state3 = this.state;
                    --state3._fsp;
                    this.adaptor.addChild(root_0, exception_declaration55.getTree());
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final variable_declaration_return variable_declaration() throws RecognitionException {
        final variable_declaration_return retval = new variable_declaration_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ID56 = null;
        Token NOT58 = null;
        Token NULL59 = null;
        Token set60 = null;
        datatype_return datatype57 = null;
        expression_return expression61 = null;
        Object ID56_tree = null;
        Object NOT58_tree = null;
        Object NULL59_tree = null;
        final Object set60_tree = null;
        try {
            root_0 = this.adaptor.nil();
            ID56 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_variable_declaration896);
            ID56_tree = this.adaptor.create(ID56);
            this.adaptor.addChild(root_0, ID56_tree);
            this.pushFollow(PLSQL2Parser.FOLLOW_datatype_in_variable_declaration898);
            datatype57 = this.datatype();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, datatype57.getTree());
            int alt19 = 2;
            final int LA19_0 = this.input.LA(1);
            if ((LA19_0 >= 13 && LA19_0 <= 14) || LA19_0 == 20) {
                alt19 = 1;
            }
            switch (alt19) {
                case 1: {
                    int alt20 = 2;
                    final int LA18_0 = this.input.LA(1);
                    if (LA18_0 == 20) {
                        alt20 = 1;
                    }
                    switch (alt20) {
                        case 1: {
                            NOT58 = (Token)this.match((IntStream)this.input, 20, PLSQL2Parser.FOLLOW_NOT_in_variable_declaration906);
                            NOT58_tree = this.adaptor.create(NOT58);
                            this.adaptor.addChild(root_0, NOT58_tree);
                            NULL59 = (Token)this.match((IntStream)this.input, 21, PLSQL2Parser.FOLLOW_NULL_in_variable_declaration908);
                            NULL59_tree = this.adaptor.create(NULL59);
                            this.adaptor.addChild(root_0, NULL59_tree);
                            break;
                        }
                    }
                    set60 = this.input.LT(1);
                    if (this.input.LA(1) >= 13 && this.input.LA(1) <= 14) {
                        this.input.consume();
                        this.adaptor.addChild(root_0, this.adaptor.create(set60));
                        this.state.errorRecovery = false;
                        this.pushFollow(PLSQL2Parser.FOLLOW_expression_in_variable_declaration925);
                        expression61 = this.expression();
                        final RecognizerSharedState state2 = this.state;
                        --state2._fsp;
                        this.adaptor.addChild(root_0, expression61.getTree());
                        break;
                    }
                    final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                    throw mse;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final constant_declaration_return constant_declaration() throws RecognitionException {
        final constant_declaration_return retval = new constant_declaration_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ID62 = null;
        Token CONSTANT63 = null;
        Token NOT65 = null;
        Token NULL66 = null;
        Token set67 = null;
        datatype_return datatype64 = null;
        expression_return expression68 = null;
        Object ID62_tree = null;
        Object CONSTANT63_tree = null;
        Object NOT65_tree = null;
        Object NULL66_tree = null;
        final Object set67_tree = null;
        try {
            root_0 = this.adaptor.nil();
            ID62 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_constant_declaration950);
            ID62_tree = this.adaptor.create(ID62);
            this.adaptor.addChild(root_0, ID62_tree);
            CONSTANT63 = (Token)this.match((IntStream)this.input, 22, PLSQL2Parser.FOLLOW_CONSTANT_in_constant_declaration952);
            CONSTANT63_tree = this.adaptor.create(CONSTANT63);
            this.adaptor.addChild(root_0, CONSTANT63_tree);
            this.pushFollow(PLSQL2Parser.FOLLOW_datatype_in_constant_declaration954);
            datatype64 = this.datatype();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, datatype64.getTree());
            int alt20 = 2;
            final int LA20_0 = this.input.LA(1);
            if (LA20_0 == 20) {
                alt20 = 1;
            }
            switch (alt20) {
                case 1: {
                    NOT65 = (Token)this.match((IntStream)this.input, 20, PLSQL2Parser.FOLLOW_NOT_in_constant_declaration958);
                    NOT65_tree = this.adaptor.create(NOT65);
                    this.adaptor.addChild(root_0, NOT65_tree);
                    NULL66 = (Token)this.match((IntStream)this.input, 21, PLSQL2Parser.FOLLOW_NULL_in_constant_declaration960);
                    NULL66_tree = this.adaptor.create(NULL66);
                    this.adaptor.addChild(root_0, NULL66_tree);
                    break;
                }
            }
            set67 = this.input.LT(1);
            if (this.input.LA(1) < 13 || this.input.LA(1) > 14) {
                final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                throw mse;
            }
            this.input.consume();
            this.adaptor.addChild(root_0, this.adaptor.create(set67));
            this.state.errorRecovery = false;
            this.pushFollow(PLSQL2Parser.FOLLOW_expression_in_constant_declaration979);
            expression68 = this.expression();
            final RecognizerSharedState state2 = this.state;
            --state2._fsp;
            this.adaptor.addChild(root_0, expression68.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final exception_declaration_return exception_declaration() throws RecognitionException {
        final exception_declaration_return retval = new exception_declaration_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ID69 = null;
        Token EXCEPTION70 = null;
        Object ID69_tree = null;
        Object EXCEPTION70_tree = null;
        try {
            root_0 = this.adaptor.nil();
            ID69 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_exception_declaration1000);
            ID69_tree = this.adaptor.create(ID69);
            this.adaptor.addChild(root_0, ID69_tree);
            EXCEPTION70 = (Token)this.match((IntStream)this.input, 23, PLSQL2Parser.FOLLOW_EXCEPTION_in_exception_declaration1002);
            EXCEPTION70_tree = this.adaptor.create(EXCEPTION70);
            this.adaptor.addChild(root_0, EXCEPTION70_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final type_definition_return type_definition() throws RecognitionException {
        final type_definition_return retval = new type_definition_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ID72 = null;
        Token set73 = null;
        kTYPE_return kTYPE71 = null;
        record_type_definition_return record_type_definition74 = null;
        collection_type_definition_return collection_type_definition75 = null;
        ref_cursor_type_definition_return ref_cursor_type_definition76 = null;
        object_type_definition_return object_type_definition77 = null;
        Object ID72_tree = null;
        final Object set73_tree = null;
        try {
            root_0 = this.adaptor.nil();
            retval.r_typeDef = new HashMap();
            this.pushFollow(PLSQL2Parser.FOLLOW_kTYPE_in_type_definition1029);
            kTYPE71 = this.kTYPE();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, kTYPE71.getTree());
            ID72 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_type_definition1031);
            ID72_tree = this.adaptor.create(ID72);
            this.adaptor.addChild(root_0, ID72_tree);
            retval.r_typeDef.put("id", (ID72 != null) ? ID72.getText() : null);
            set73 = this.input.LT(1);
            if (this.input.LA(1) != 19 && this.input.LA(1) != 24) {
                final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                throw mse;
            }
            this.input.consume();
            this.adaptor.addChild(root_0, this.adaptor.create(set73));
            this.state.errorRecovery = false;
            int alt21 = 4;
            switch (this.input.LA(1)) {
                case 26: {
                    alt21 = 1;
                    break;
                }
                case 28:
                case 30:
                case 31: {
                    alt21 = 2;
                    break;
                }
                case 34: {
                    alt21 = 3;
                    break;
                }
                case 27: {
                    alt21 = 4;
                    break;
                }
                default: {
                    final NoViableAltException nvae = new NoViableAltException("", 21, 0, (IntStream)this.input);
                    throw nvae;
                }
            }
            switch (alt21) {
                case 1: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_record_type_definition_in_type_definition1062);
                    record_type_definition74 = this.record_type_definition();
                    final RecognizerSharedState state2 = this.state;
                    --state2._fsp;
                    this.adaptor.addChild(root_0, record_type_definition74.getTree());
                    break;
                }
                case 2: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_collection_type_definition_in_type_definition1066);
                    collection_type_definition75 = this.collection_type_definition();
                    final RecognizerSharedState state3 = this.state;
                    --state3._fsp;
                    this.adaptor.addChild(root_0, collection_type_definition75.getTree());
                    retval.r_typeDef.put("type", "collection");
                    retval.r_typeDef.put("collectionType", (collection_type_definition75 != null) ? collection_type_definition75.r_collectionType : null);
                    this.m_typeList.add(retval.r_typeDef);
                    break;
                }
                case 3: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_ref_cursor_type_definition_in_type_definition1104);
                    ref_cursor_type_definition76 = this.ref_cursor_type_definition();
                    final RecognizerSharedState state4 = this.state;
                    --state4._fsp;
                    this.adaptor.addChild(root_0, ref_cursor_type_definition76.getTree());
                    break;
                }
                case 4: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_object_type_definition_in_type_definition1119);
                    object_type_definition77 = this.object_type_definition();
                    final RecognizerSharedState state5 = this.state;
                    --state5._fsp;
                    this.adaptor.addChild(root_0, object_type_definition77.getTree());
                    retval.r_typeDef.put("type", "object");
                    retval.r_typeDef.put("fieldList", (object_type_definition77 != null) ? object_type_definition77.r_field_list : null);
                    this.m_typeList.add(retval.r_typeDef);
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final subtype_definition_return subtype_definition() throws RecognitionException {
        final subtype_definition_return retval = new subtype_definition_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token SUBTYPE78 = null;
        Token ID79 = null;
        Token IS80 = null;
        Token NOT82 = null;
        Token NULL83 = null;
        datatype_return datatype81 = null;
        Object SUBTYPE78_tree = null;
        Object ID79_tree = null;
        Object IS80_tree = null;
        Object NOT82_tree = null;
        Object NULL83_tree = null;
        try {
            root_0 = this.adaptor.nil();
            SUBTYPE78 = (Token)this.match((IntStream)this.input, 25, PLSQL2Parser.FOLLOW_SUBTYPE_in_subtype_definition1178);
            SUBTYPE78_tree = this.adaptor.create(SUBTYPE78);
            this.adaptor.addChild(root_0, SUBTYPE78_tree);
            ID79 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_subtype_definition1180);
            ID79_tree = this.adaptor.create(ID79);
            this.adaptor.addChild(root_0, ID79_tree);
            IS80 = (Token)this.match((IntStream)this.input, 19, PLSQL2Parser.FOLLOW_IS_in_subtype_definition1182);
            IS80_tree = this.adaptor.create(IS80);
            this.adaptor.addChild(root_0, IS80_tree);
            this.pushFollow(PLSQL2Parser.FOLLOW_datatype_in_subtype_definition1184);
            datatype81 = this.datatype();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, datatype81.getTree());
            int alt22 = 2;
            final int LA22_0 = this.input.LA(1);
            if (LA22_0 == 20) {
                alt22 = 1;
            }
            switch (alt22) {
                case 1: {
                    NOT82 = (Token)this.match((IntStream)this.input, 20, PLSQL2Parser.FOLLOW_NOT_in_subtype_definition1188);
                    NOT82_tree = this.adaptor.create(NOT82);
                    this.adaptor.addChild(root_0, NOT82_tree);
                    NULL83 = (Token)this.match((IntStream)this.input, 21, PLSQL2Parser.FOLLOW_NULL_in_subtype_definition1190);
                    NULL83_tree = this.adaptor.create(NULL83);
                    this.adaptor.addChild(root_0, NULL83_tree);
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final record_type_definition_return record_type_definition() throws RecognitionException {
        final record_type_definition_return retval = new record_type_definition_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token RECORD84 = null;
        Token LPAREN85 = null;
        Token COMMA87 = null;
        Token RPAREN89 = null;
        record_field_declaration_return record_field_declaration86 = null;
        record_field_declaration_return record_field_declaration87 = null;
        Object RECORD84_tree = null;
        Object LPAREN85_tree = null;
        Object COMMA87_tree = null;
        Object RPAREN89_tree = null;
        Label_0465: {
            try {
                root_0 = this.adaptor.nil();
                RECORD84 = (Token)this.match((IntStream)this.input, 26, PLSQL2Parser.FOLLOW_RECORD_in_record_type_definition1211);
                RECORD84_tree = this.adaptor.create(RECORD84);
                this.adaptor.addChild(root_0, RECORD84_tree);
                LPAREN85 = (Token)this.match((IntStream)this.input, 10, PLSQL2Parser.FOLLOW_LPAREN_in_record_type_definition1213);
                LPAREN85_tree = this.adaptor.create(LPAREN85);
                this.adaptor.addChild(root_0, LPAREN85_tree);
                this.pushFollow(PLSQL2Parser.FOLLOW_record_field_declaration_in_record_type_definition1215);
                record_field_declaration86 = this.record_field_declaration();
                final RecognizerSharedState state = this.state;
                --state._fsp;
                this.adaptor.addChild(root_0, record_field_declaration86.getTree());
                while (true) {
                    int alt23 = 2;
                    final int LA23_0 = this.input.LA(1);
                    if (LA23_0 == 11) {
                        alt23 = 1;
                    }
                    switch (alt23) {
                        case 1: {
                            COMMA87 = (Token)this.match((IntStream)this.input, 11, PLSQL2Parser.FOLLOW_COMMA_in_record_type_definition1219);
                            COMMA87_tree = this.adaptor.create(COMMA87);
                            this.adaptor.addChild(root_0, COMMA87_tree);
                            this.pushFollow(PLSQL2Parser.FOLLOW_record_field_declaration_in_record_type_definition1221);
                            record_field_declaration87 = this.record_field_declaration();
                            final RecognizerSharedState state2 = this.state;
                            --state2._fsp;
                            this.adaptor.addChild(root_0, record_field_declaration87.getTree());
                            continue;
                        }
                        default: {
                            RPAREN89 = (Token)this.match((IntStream)this.input, 12, PLSQL2Parser.FOLLOW_RPAREN_in_record_type_definition1226);
                            RPAREN89_tree = this.adaptor.create(RPAREN89);
                            this.adaptor.addChild(root_0, RPAREN89_tree);
                            retval.stop = this.input.LT(-1);
                            retval.tree = this.adaptor.rulePostProcessing(root_0);
                            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                            break Label_0465;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final record_field_declaration_return record_field_declaration() throws RecognitionException {
        final record_field_declaration_return retval = new record_field_declaration_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ID90 = null;
        Token NOT92 = null;
        Token NULL93 = null;
        Token set94 = null;
        datatype_return datatype91 = null;
        expression_return expression95 = null;
        Object ID90_tree = null;
        Object NOT92_tree = null;
        Object NULL93_tree = null;
        final Object set94_tree = null;
        try {
            root_0 = this.adaptor.nil();
            retval.r_field = new HashMap();
            ID90 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_record_field_declaration1250);
            ID90_tree = this.adaptor.create(ID90);
            this.adaptor.addChild(root_0, ID90_tree);
            retval.r_field.put("id", (ID90 != null) ? ID90.getText() : null);
            this.pushFollow(PLSQL2Parser.FOLLOW_datatype_in_record_field_declaration1257);
            datatype91 = this.datatype();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, datatype91.getTree());
            retval.r_field.put("dataType", (datatype91 != null) ? this.input.toString(datatype91.start, datatype91.stop) : null);
            int alt25 = 2;
            final int LA25_0 = this.input.LA(1);
            if ((LA25_0 >= 13 && LA25_0 <= 14) || LA25_0 == 20) {
                alt25 = 1;
            }
            switch (alt25) {
                case 1: {
                    int alt26 = 2;
                    final int LA24_0 = this.input.LA(1);
                    if (LA24_0 == 20) {
                        alt26 = 1;
                    }
                    switch (alt26) {
                        case 1: {
                            NOT92 = (Token)this.match((IntStream)this.input, 20, PLSQL2Parser.FOLLOW_NOT_in_record_field_declaration1268);
                            NOT92_tree = this.adaptor.create(NOT92);
                            this.adaptor.addChild(root_0, NOT92_tree);
                            NULL93 = (Token)this.match((IntStream)this.input, 21, PLSQL2Parser.FOLLOW_NULL_in_record_field_declaration1270);
                            NULL93_tree = this.adaptor.create(NULL93);
                            this.adaptor.addChild(root_0, NULL93_tree);
                            break;
                        }
                    }
                    set94 = this.input.LT(1);
                    if (this.input.LA(1) >= 13 && this.input.LA(1) <= 14) {
                        this.input.consume();
                        this.adaptor.addChild(root_0, this.adaptor.create(set94));
                        this.state.errorRecovery = false;
                        this.pushFollow(PLSQL2Parser.FOLLOW_expression_in_record_field_declaration1285);
                        expression95 = this.expression();
                        final RecognizerSharedState state2 = this.state;
                        --state2._fsp;
                        this.adaptor.addChild(root_0, expression95.getTree());
                        break;
                    }
                    final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                    throw mse;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final object_type_definition_return object_type_definition() throws RecognitionException {
        final object_type_definition_return retval = new object_type_definition_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token OBJECT96 = null;
        Token LPAREN97 = null;
        Token COMMA98 = null;
        Token RPAREN99 = null;
        record_field_declaration_return orecord1 = null;
        record_field_declaration_return orecord2 = null;
        Object OBJECT96_tree = null;
        Object LPAREN97_tree = null;
        Object COMMA98_tree = null;
        Object RPAREN99_tree = null;
        Label_0523: {
            try {
                root_0 = this.adaptor.nil();
                retval.r_field_list = new ArrayList();
                OBJECT96 = (Token)this.match((IntStream)this.input, 27, PLSQL2Parser.FOLLOW_OBJECT_in_object_type_definition1315);
                OBJECT96_tree = this.adaptor.create(OBJECT96);
                this.adaptor.addChild(root_0, OBJECT96_tree);
                LPAREN97 = (Token)this.match((IntStream)this.input, 10, PLSQL2Parser.FOLLOW_LPAREN_in_object_type_definition1317);
                LPAREN97_tree = this.adaptor.create(LPAREN97);
                this.adaptor.addChild(root_0, LPAREN97_tree);
                this.pushFollow(PLSQL2Parser.FOLLOW_record_field_declaration_in_object_type_definition1321);
                orecord1 = this.record_field_declaration();
                final RecognizerSharedState state = this.state;
                --state._fsp;
                this.adaptor.addChild(root_0, orecord1.getTree());
                retval.r_field_list.add((orecord1 != null) ? orecord1.r_field : null);
                while (true) {
                    int alt26 = 2;
                    final int LA26_0 = this.input.LA(1);
                    if (LA26_0 == 11) {
                        alt26 = 1;
                    }
                    switch (alt26) {
                        case 1: {
                            COMMA98 = (Token)this.match((IntStream)this.input, 11, PLSQL2Parser.FOLLOW_COMMA_in_object_type_definition1336);
                            COMMA98_tree = this.adaptor.create(COMMA98);
                            this.adaptor.addChild(root_0, COMMA98_tree);
                            this.pushFollow(PLSQL2Parser.FOLLOW_record_field_declaration_in_object_type_definition1340);
                            orecord2 = this.record_field_declaration();
                            final RecognizerSharedState state2 = this.state;
                            --state2._fsp;
                            this.adaptor.addChild(root_0, orecord2.getTree());
                            retval.r_field_list.add((orecord2 != null) ? orecord2.r_field : null);
                            continue;
                        }
                        default: {
                            RPAREN99 = (Token)this.match((IntStream)this.input, 12, PLSQL2Parser.FOLLOW_RPAREN_in_object_type_definition1360);
                            RPAREN99_tree = this.adaptor.create(RPAREN99);
                            this.adaptor.addChild(root_0, RPAREN99_tree);
                            retval.stop = this.input.LT(-1);
                            retval.tree = this.adaptor.rulePostProcessing(root_0);
                            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                            break Label_0523;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final collection_type_definition_return collection_type_definition() throws RecognitionException {
        final collection_type_definition_return retval = new collection_type_definition_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        varray_type_definition_return varray_type_definition100 = null;
        nested_table_type_definition_return nested_table_type_definition101 = null;
        try {
            root_0 = this.adaptor.nil();
            retval.r_collectionType = new HashMap();
            int alt27 = 2;
            final int LA27_0 = this.input.LA(1);
            if (LA27_0 == 28 || LA27_0 == 30) {
                alt27 = 1;
            }
            else {
                if (LA27_0 != 31) {
                    final NoViableAltException nvae = new NoViableAltException("", 27, 0, (IntStream)this.input);
                    throw nvae;
                }
                alt27 = 2;
            }
            switch (alt27) {
                case 1: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_varray_type_definition_in_collection_type_definition1388);
                    varray_type_definition100 = this.varray_type_definition();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    this.adaptor.addChild(root_0, varray_type_definition100.getTree());
                    break;
                }
                case 2: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_nested_table_type_definition_in_collection_type_definition1394);
                    nested_table_type_definition101 = this.nested_table_type_definition();
                    final RecognizerSharedState state2 = this.state;
                    --state2._fsp;
                    this.adaptor.addChild(root_0, nested_table_type_definition101.getTree());
                    retval.r_collectionType.putAll((nested_table_type_definition101 != null) ? nested_table_type_definition101.table_data_type : null);
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final varray_type_definition_return varray_type_definition() throws RecognitionException {
        final varray_type_definition_return retval = new varray_type_definition_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token VARYING102 = null;
        Token ARRAY103 = null;
        Token VARRAY104 = null;
        Token LPAREN105 = null;
        Token RPAREN107 = null;
        Token NOT110 = null;
        Token NULL111 = null;
        numeric_literal_return numeric_literal106 = null;
        kOF_return kOF108 = null;
        datatype_return datatype109 = null;
        Object VARYING102_tree = null;
        Object ARRAY103_tree = null;
        Object VARRAY104_tree = null;
        Object LPAREN105_tree = null;
        Object RPAREN107_tree = null;
        Object NOT110_tree = null;
        Object NULL111_tree = null;
        try {
            root_0 = this.adaptor.nil();
            int alt29 = 2;
            final int LA29_0 = this.input.LA(1);
            if (LA29_0 == 28) {
                alt29 = 1;
            }
            else {
                if (LA29_0 != 30) {
                    final NoViableAltException nvae = new NoViableAltException("", 29, 0, (IntStream)this.input);
                    throw nvae;
                }
                alt29 = 2;
            }
            switch (alt29) {
                case 1: {
                    VARYING102 = (Token)this.match((IntStream)this.input, 28, PLSQL2Parser.FOLLOW_VARYING_in_varray_type_definition1412);
                    VARYING102_tree = this.adaptor.create(VARYING102);
                    this.adaptor.addChild(root_0, VARYING102_tree);
                    int alt30 = 2;
                    final int LA28_0 = this.input.LA(1);
                    if (LA28_0 == 29) {
                        alt30 = 1;
                    }
                    switch (alt30) {
                        case 1: {
                            ARRAY103 = (Token)this.match((IntStream)this.input, 29, PLSQL2Parser.FOLLOW_ARRAY_in_varray_type_definition1414);
                            ARRAY103_tree = this.adaptor.create(ARRAY103);
                            this.adaptor.addChild(root_0, ARRAY103_tree);
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    VARRAY104 = (Token)this.match((IntStream)this.input, 30, PLSQL2Parser.FOLLOW_VARRAY_in_varray_type_definition1419);
                    VARRAY104_tree = this.adaptor.create(VARRAY104);
                    this.adaptor.addChild(root_0, VARRAY104_tree);
                    break;
                }
            }
            LPAREN105 = (Token)this.match((IntStream)this.input, 10, PLSQL2Parser.FOLLOW_LPAREN_in_varray_type_definition1423);
            LPAREN105_tree = this.adaptor.create(LPAREN105);
            this.adaptor.addChild(root_0, LPAREN105_tree);
            this.pushFollow(PLSQL2Parser.FOLLOW_numeric_literal_in_varray_type_definition1425);
            numeric_literal106 = this.numeric_literal();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, numeric_literal106.getTree());
            RPAREN107 = (Token)this.match((IntStream)this.input, 12, PLSQL2Parser.FOLLOW_RPAREN_in_varray_type_definition1427);
            RPAREN107_tree = this.adaptor.create(RPAREN107);
            this.adaptor.addChild(root_0, RPAREN107_tree);
            this.pushFollow(PLSQL2Parser.FOLLOW_kOF_in_varray_type_definition1429);
            kOF108 = this.kOF();
            final RecognizerSharedState state2 = this.state;
            --state2._fsp;
            this.adaptor.addChild(root_0, kOF108.getTree());
            this.pushFollow(PLSQL2Parser.FOLLOW_datatype_in_varray_type_definition1431);
            datatype109 = this.datatype();
            final RecognizerSharedState state3 = this.state;
            --state3._fsp;
            this.adaptor.addChild(root_0, datatype109.getTree());
            int alt31 = 2;
            final int LA30_0 = this.input.LA(1);
            if (LA30_0 == 20) {
                alt31 = 1;
            }
            switch (alt31) {
                case 1: {
                    NOT110 = (Token)this.match((IntStream)this.input, 20, PLSQL2Parser.FOLLOW_NOT_in_varray_type_definition1435);
                    NOT110_tree = this.adaptor.create(NOT110);
                    this.adaptor.addChild(root_0, NOT110_tree);
                    NULL111 = (Token)this.match((IntStream)this.input, 21, PLSQL2Parser.FOLLOW_NULL_in_varray_type_definition1437);
                    NULL111_tree = this.adaptor.create(NULL111);
                    this.adaptor.addChild(root_0, NULL111_tree);
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final nested_table_type_definition_return nested_table_type_definition() throws RecognitionException {
        final nested_table_type_definition_return retval = new nested_table_type_definition_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token TABLE112 = null;
        Token NOT115 = null;
        Token NULL116 = null;
        Token INDEX117 = null;
        Token BY118 = null;
        kOF_return kOF113 = null;
        datatype_return datatype114 = null;
        associative_index_type_return associative_index_type119 = null;
        Object TABLE112_tree = null;
        Object NOT115_tree = null;
        Object NULL116_tree = null;
        Object INDEX117_tree = null;
        Object BY118_tree = null;
        try {
            root_0 = this.adaptor.nil();
            retval.table_data_type = new HashMap();
            TABLE112 = (Token)this.match((IntStream)this.input, 31, PLSQL2Parser.FOLLOW_TABLE_in_nested_table_type_definition1461);
            TABLE112_tree = this.adaptor.create(TABLE112);
            this.adaptor.addChild(root_0, TABLE112_tree);
            this.pushFollow(PLSQL2Parser.FOLLOW_kOF_in_nested_table_type_definition1463);
            kOF113 = this.kOF();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, kOF113.getTree());
            this.pushFollow(PLSQL2Parser.FOLLOW_datatype_in_nested_table_type_definition1465);
            datatype114 = this.datatype();
            final RecognizerSharedState state2 = this.state;
            --state2._fsp;
            this.adaptor.addChild(root_0, datatype114.getTree());
            retval.table_data_type.put("dataType", (datatype114 != null) ? this.input.toString(datatype114.start, datatype114.stop) : null);
            int alt31 = 2;
            final int LA31_0 = this.input.LA(1);
            if (LA31_0 == 20) {
                alt31 = 1;
            }
            switch (alt31) {
                case 1: {
                    NOT115 = (Token)this.match((IntStream)this.input, 20, PLSQL2Parser.FOLLOW_NOT_in_nested_table_type_definition1474);
                    NOT115_tree = this.adaptor.create(NOT115);
                    this.adaptor.addChild(root_0, NOT115_tree);
                    NULL116 = (Token)this.match((IntStream)this.input, 21, PLSQL2Parser.FOLLOW_NULL_in_nested_table_type_definition1476);
                    NULL116_tree = this.adaptor.create(NULL116);
                    this.adaptor.addChild(root_0, NULL116_tree);
                    break;
                }
            }
            int alt32 = 2;
            final int LA32_0 = this.input.LA(1);
            if (LA32_0 == 32) {
                alt32 = 1;
            }
            switch (alt32) {
                case 1: {
                    INDEX117 = (Token)this.match((IntStream)this.input, 32, PLSQL2Parser.FOLLOW_INDEX_in_nested_table_type_definition1483);
                    INDEX117_tree = this.adaptor.create(INDEX117);
                    this.adaptor.addChild(root_0, INDEX117_tree);
                    BY118 = (Token)this.match((IntStream)this.input, 33, PLSQL2Parser.FOLLOW_BY_in_nested_table_type_definition1485);
                    BY118_tree = this.adaptor.create(BY118);
                    this.adaptor.addChild(root_0, BY118_tree);
                    this.pushFollow(PLSQL2Parser.FOLLOW_associative_index_type_in_nested_table_type_definition1487);
                    associative_index_type119 = this.associative_index_type();
                    final RecognizerSharedState state3 = this.state;
                    --state3._fsp;
                    this.adaptor.addChild(root_0, associative_index_type119.getTree());
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final associative_index_type_return associative_index_type() throws RecognitionException {
        final associative_index_type_return retval = new associative_index_type_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        datatype_return datatype120 = null;
        try {
            root_0 = this.adaptor.nil();
            this.pushFollow(PLSQL2Parser.FOLLOW_datatype_in_associative_index_type1501);
            datatype120 = this.datatype();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, datatype120.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final ref_cursor_type_definition_return ref_cursor_type_definition() throws RecognitionException {
        final ref_cursor_type_definition_return retval = new ref_cursor_type_definition_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token REF121 = null;
        Token CURSOR122 = null;
        Token RETURN123 = null;
        datatype_return datatype124 = null;
        Object REF121_tree = null;
        Object CURSOR122_tree = null;
        Object RETURN123_tree = null;
        try {
            root_0 = this.adaptor.nil();
            REF121 = (Token)this.match((IntStream)this.input, 34, PLSQL2Parser.FOLLOW_REF_in_ref_cursor_type_definition1512);
            REF121_tree = this.adaptor.create(REF121);
            this.adaptor.addChild(root_0, REF121_tree);
            CURSOR122 = (Token)this.match((IntStream)this.input, 18, PLSQL2Parser.FOLLOW_CURSOR_in_ref_cursor_type_definition1514);
            CURSOR122_tree = this.adaptor.create(CURSOR122);
            this.adaptor.addChild(root_0, CURSOR122_tree);
            int alt33 = 2;
            final int LA33_0 = this.input.LA(1);
            if (LA33_0 == 9) {
                alt33 = 1;
            }
            switch (alt33) {
                case 1: {
                    RETURN123 = (Token)this.match((IntStream)this.input, 9, PLSQL2Parser.FOLLOW_RETURN_in_ref_cursor_type_definition1518);
                    RETURN123_tree = this.adaptor.create(RETURN123);
                    this.adaptor.addChild(root_0, RETURN123_tree);
                    this.pushFollow(PLSQL2Parser.FOLLOW_datatype_in_ref_cursor_type_definition1520);
                    datatype124 = this.datatype();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    this.adaptor.addChild(root_0, datatype124.getTree());
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final datatype_return datatype() throws RecognitionException {
        final datatype_return retval = new datatype_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token REF125 = null;
        Token ID126 = null;
        Token DOT127 = null;
        Token ID127 = null;
        Token LPAREN129 = null;
        Token COMMA131 = null;
        Token RPAREN133 = null;
        Token PERCENT134 = null;
        Token ROWTYPE136 = null;
        numeric_literal_return numeric_literal130 = null;
        numeric_literal_return numeric_literal131 = null;
        kTYPE_return kTYPE135 = null;
        Object REF125_tree = null;
        Object ID126_tree = null;
        Object DOT127_tree = null;
        Object ID128_tree = null;
        Object LPAREN129_tree = null;
        Object COMMA131_tree = null;
        Object RPAREN133_tree = null;
        Object PERCENT134_tree = null;
        Object ROWTYPE136_tree = null;
        try {
            root_0 = this.adaptor.nil();
            int alt34 = 2;
            final int LA34_0 = this.input.LA(1);
            if (LA34_0 == 34) {
                alt34 = 1;
            }
            switch (alt34) {
                case 1: {
                    REF125 = (Token)this.match((IntStream)this.input, 34, PLSQL2Parser.FOLLOW_REF_in_datatype1539);
                    REF125_tree = this.adaptor.create(REF125);
                    this.adaptor.addChild(root_0, REF125_tree);
                    break;
                }
            }
            ID126 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_datatype1544);
            ID126_tree = this.adaptor.create(ID126);
            this.adaptor.addChild(root_0, ID126_tree);
            int alt35 = 2;
            final int LA35_0 = this.input.LA(1);
            if (LA35_0 == 35) {
                alt35 = 1;
            }
            switch (alt35) {
                case 1: {
                    DOT127 = (Token)this.match((IntStream)this.input, 35, PLSQL2Parser.FOLLOW_DOT_in_datatype1548);
                    DOT127_tree = this.adaptor.create(DOT127);
                    this.adaptor.addChild(root_0, DOT127_tree);
                    ID127 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_datatype1550);
                    ID128_tree = this.adaptor.create(ID127);
                    this.adaptor.addChild(root_0, ID128_tree);
                    break;
                }
            }
            int alt36 = 3;
            final int LA38_0 = this.input.LA(1);
            if (LA38_0 == 10) {
                alt36 = 1;
            }
            else if (LA38_0 == 36) {
                alt36 = 2;
            }
            Label_0895: {
                switch (alt36) {
                    case 1: {
                        LPAREN129 = (Token)this.match((IntStream)this.input, 10, PLSQL2Parser.FOLLOW_LPAREN_in_datatype1557);
                        LPAREN129_tree = this.adaptor.create(LPAREN129);
                        this.adaptor.addChild(root_0, LPAREN129_tree);
                        this.pushFollow(PLSQL2Parser.FOLLOW_numeric_literal_in_datatype1559);
                        numeric_literal130 = this.numeric_literal();
                        final RecognizerSharedState state = this.state;
                        --state._fsp;
                        this.adaptor.addChild(root_0, numeric_literal130.getTree());
                        while (true) {
                            int alt37 = 2;
                            final int LA36_0 = this.input.LA(1);
                            if (LA36_0 == 11) {
                                alt37 = 1;
                            }
                            switch (alt37) {
                                case 1: {
                                    COMMA131 = (Token)this.match((IntStream)this.input, 11, PLSQL2Parser.FOLLOW_COMMA_in_datatype1563);
                                    COMMA131_tree = this.adaptor.create(COMMA131);
                                    this.adaptor.addChild(root_0, COMMA131_tree);
                                    this.pushFollow(PLSQL2Parser.FOLLOW_numeric_literal_in_datatype1565);
                                    numeric_literal131 = this.numeric_literal();
                                    final RecognizerSharedState state2 = this.state;
                                    --state2._fsp;
                                    this.adaptor.addChild(root_0, numeric_literal131.getTree());
                                    continue;
                                }
                                default: {
                                    RPAREN133 = (Token)this.match((IntStream)this.input, 12, PLSQL2Parser.FOLLOW_RPAREN_in_datatype1570);
                                    RPAREN133_tree = this.adaptor.create(RPAREN133);
                                    this.adaptor.addChild(root_0, RPAREN133_tree);
                                    break Label_0895;
                                }
                            }
                        }
                        /*break;*/
                    }
                    case 2: {
                        PERCENT134 = (Token)this.match((IntStream)this.input, 36, PLSQL2Parser.FOLLOW_PERCENT_in_datatype1574);
                        PERCENT134_tree = this.adaptor.create(PERCENT134);
                        this.adaptor.addChild(root_0, PERCENT134_tree);
                        int alt38 = 2;
                        final int LA37_0 = this.input.LA(1);
                        if (LA37_0 == 7) {
                            alt38 = 1;
                        }
                        else {
                            if (LA37_0 != 37) {
                                final NoViableAltException nvae = new NoViableAltException("", 37, 0, (IntStream)this.input);
                                throw nvae;
                            }
                            alt38 = 2;
                        }
                        switch (alt38) {
                            case 1: {
                                this.pushFollow(PLSQL2Parser.FOLLOW_kTYPE_in_datatype1578);
                                kTYPE135 = this.kTYPE();
                                final RecognizerSharedState state3 = this.state;
                                --state3._fsp;
                                this.adaptor.addChild(root_0, kTYPE135.getTree());
                                break Label_0895;
                            }
                            case 2: {
                                ROWTYPE136 = (Token)this.match((IntStream)this.input, 37, PLSQL2Parser.FOLLOW_ROWTYPE_in_datatype1582);
                                ROWTYPE136_tree = this.adaptor.create(ROWTYPE136);
                                this.adaptor.addChild(root_0, ROWTYPE136_tree);
                                break Label_0895;
                            }
                        }
                        break;
                    }
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final function_declaration_or_definition_return function_declaration_or_definition() throws RecognitionException {
        final function_declaration_or_definition_return retval = new function_declaration_or_definition_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token set138 = null;
        Token set139 = null;
        function_heading_return function_heading137 = null;
        declare_section_return declare_section140 = null;
        body_return body141 = null;
        final Object set138_tree = null;
        final Object set139_tree = null;
        Label_0675: {
            try {
                root_0 = this.adaptor.nil();
                this.pushFollow(PLSQL2Parser.FOLLOW_function_heading_in_function_declaration_or_definition1612);
                function_heading137 = this.function_heading();
                final RecognizerSharedState state = this.state;
                --state._fsp;
                this.adaptor.addChild(root_0, function_heading137.getTree());
                while (true) {
                    int alt39 = 2;
                    final int LA39_0 = this.input.LA(1);
                    if (LA39_0 >= 38 && LA39_0 <= 41) {
                        alt39 = 1;
                    }
                    switch (alt39) {
                        case 1: {
                            set138 = this.input.LT(1);
                            if (this.input.LA(1) >= 38 && this.input.LA(1) <= 41) {
                                this.input.consume();
                                this.adaptor.addChild(root_0, this.adaptor.create(set138));
                                this.state.errorRecovery = false;
                                continue;
                            }
                            final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                            throw mse;
                        }
                        default: {
                            int alt40 = 2;
                            final int LA41_0 = this.input.LA(1);
                            if (LA41_0 == 19 || LA41_0 == 24) {
                                alt40 = 1;
                            }
                            switch (alt40) {
                                case 1: {
                                    set139 = this.input.LT(1);
                                    if (this.input.LA(1) == 19 || this.input.LA(1) == 24) {
                                        this.input.consume();
                                        this.adaptor.addChild(root_0, this.adaptor.create(set139));
                                        this.state.errorRecovery = false;
                                        int alt41 = 2;
                                        final int LA40_0 = this.input.LA(1);
                                        if ((LA40_0 >= 6 && LA40_0 <= 8) || LA40_0 == 18 || LA40_0 == 25 || LA40_0 == 74) {
                                            alt41 = 1;
                                        }
                                        switch (alt41) {
                                            case 1: {
                                                this.pushFollow(PLSQL2Parser.FOLLOW_declare_section_in_function_declaration_or_definition1661);
                                                declare_section140 = this.declare_section();
                                                final RecognizerSharedState state2 = this.state;
                                                --state2._fsp;
                                                this.adaptor.addChild(root_0, declare_section140.getTree());
                                                break;
                                            }
                                        }
                                        this.pushFollow(PLSQL2Parser.FOLLOW_body_in_function_declaration_or_definition1664);
                                        body141 = this.body();
                                        final RecognizerSharedState state3 = this.state;
                                        --state3._fsp;
                                        this.adaptor.addChild(root_0, body141.getTree());
                                        break;
                                    }
                                    final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                                    throw mse;
                                }
                            }
                            retval.construct = ((declare_section140 != null) ? declare_section140.construct : null);
                            retval.stop = this.input.LT(-1);
                            retval.tree = this.adaptor.rulePostProcessing(root_0);
                            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                            break Label_0675;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final function_declaration_return function_declaration() throws RecognitionException {
        final function_declaration_return retval = new function_declaration_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token set143 = null;
        function_heading_return function_heading142 = null;
        final Object set143_tree = null;
        Label_0337: {
            try {
                root_0 = this.adaptor.nil();
                this.pushFollow(PLSQL2Parser.FOLLOW_function_heading_in_function_declaration1687);
                function_heading142 = this.function_heading();
                final RecognizerSharedState state = this.state;
                --state._fsp;
                this.adaptor.addChild(root_0, function_heading142.getTree());
                while (true) {
                    int alt42 = 2;
                    final int LA42_0 = this.input.LA(1);
                    if (LA42_0 >= 38 && LA42_0 <= 41) {
                        alt42 = 1;
                    }
                    switch (alt42) {
                        case 1: {
                            set143 = this.input.LT(1);
                            if (this.input.LA(1) >= 38 && this.input.LA(1) <= 41) {
                                this.input.consume();
                                this.adaptor.addChild(root_0, this.adaptor.create(set143));
                                this.state.errorRecovery = false;
                                continue;
                            }
                            final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                            throw mse;
                        }
                        default: {
                            retval.stop = this.input.LT(-1);
                            retval.tree = this.adaptor.rulePostProcessing(root_0);
                            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                            break Label_0337;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final function_definition_return function_definition() throws RecognitionException {
        final function_definition_return retval = new function_definition_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token set145 = null;
        Token set146 = null;
        function_heading_return function_heading144 = null;
        declare_section_return declare_section147 = null;
        body_return body148 = null;
        final Object set145_tree = null;
        final Object set146_tree = null;
        Label_0605: {
            try {
                root_0 = this.adaptor.nil();
                this.pushFollow(PLSQL2Parser.FOLLOW_function_heading_in_function_definition1735);
                function_heading144 = this.function_heading();
                final RecognizerSharedState state = this.state;
                --state._fsp;
                this.adaptor.addChild(root_0, function_heading144.getTree());
                while (true) {
                    int alt43 = 2;
                    final int LA43_0 = this.input.LA(1);
                    if (LA43_0 >= 38 && LA43_0 <= 41) {
                        alt43 = 1;
                    }
                    switch (alt43) {
                        case 1: {
                            set145 = this.input.LT(1);
                            if (this.input.LA(1) >= 38 && this.input.LA(1) <= 41) {
                                this.input.consume();
                                this.adaptor.addChild(root_0, this.adaptor.create(set145));
                                this.state.errorRecovery = false;
                                continue;
                            }
                            final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                            throw mse;
                        }
                        default: {
                            set146 = this.input.LT(1);
                            if (this.input.LA(1) == 19 || this.input.LA(1) == 24) {
                                this.input.consume();
                                this.adaptor.addChild(root_0, this.adaptor.create(set146));
                                this.state.errorRecovery = false;
                                int alt44 = 2;
                                final int LA44_0 = this.input.LA(1);
                                if ((LA44_0 >= 6 && LA44_0 <= 8) || LA44_0 == 18 || LA44_0 == 25 || LA44_0 == 74) {
                                    alt44 = 1;
                                }
                                switch (alt44) {
                                    case 1: {
                                        this.pushFollow(PLSQL2Parser.FOLLOW_declare_section_in_function_definition1782);
                                        declare_section147 = this.declare_section();
                                        final RecognizerSharedState state2 = this.state;
                                        --state2._fsp;
                                        this.adaptor.addChild(root_0, declare_section147.getTree());
                                        break;
                                    }
                                }
                                this.pushFollow(PLSQL2Parser.FOLLOW_body_in_function_definition1785);
                                body148 = this.body();
                                final RecognizerSharedState state3 = this.state;
                                --state3._fsp;
                                this.adaptor.addChild(root_0, body148.getTree());
                                retval.stop = this.input.LT(-1);
                                retval.tree = this.adaptor.rulePostProcessing(root_0);
                                this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                                break Label_0605;
                            }
                            final MismatchedSetException mse2 = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                            throw mse2;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final procedure_declaration_or_definition_return procedure_declaration_or_definition() throws RecognitionException {
        final procedure_declaration_or_definition_return retval = new procedure_declaration_or_definition_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token set150 = null;
        procedure_heading_return procedure_heading149 = null;
        declare_section_return declare_section151 = null;
        body_return body152 = null;
        final Object set150_tree = null;
        try {
            root_0 = this.adaptor.nil();
            this.pushFollow(PLSQL2Parser.FOLLOW_procedure_heading_in_procedure_declaration_or_definition1807);
            procedure_heading149 = this.procedure_heading();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, procedure_heading149.getTree());
            int alt46 = 2;
            final int LA46_0 = this.input.LA(1);
            if (LA46_0 == 19 || LA46_0 == 24) {
                alt46 = 1;
            }
            switch (alt46) {
                case 1: {
                    set150 = this.input.LT(1);
                    if (this.input.LA(1) == 19 || this.input.LA(1) == 24) {
                        this.input.consume();
                        this.adaptor.addChild(root_0, this.adaptor.create(set150));
                        this.state.errorRecovery = false;
                        int alt47 = 2;
                        final int LA45_0 = this.input.LA(1);
                        if ((LA45_0 >= 6 && LA45_0 <= 8) || LA45_0 == 18 || LA45_0 == 25 || LA45_0 == 74) {
                            alt47 = 1;
                        }
                        switch (alt47) {
                            case 1: {
                                this.pushFollow(PLSQL2Parser.FOLLOW_declare_section_in_procedure_declaration_or_definition1829);
                                declare_section151 = this.declare_section();
                                final RecognizerSharedState state2 = this.state;
                                --state2._fsp;
                                this.adaptor.addChild(root_0, declare_section151.getTree());
                                break;
                            }
                        }
                        this.pushFollow(PLSQL2Parser.FOLLOW_body_in_procedure_declaration_or_definition1832);
                        body152 = this.body();
                        final RecognizerSharedState state3 = this.state;
                        --state3._fsp;
                        this.adaptor.addChild(root_0, body152.getTree());
                        break;
                    }
                    final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                    throw mse;
                }
            }
            retval.construct = "from  definition";
            System.out.println(retval.construct);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final procedure_declaration_return procedure_declaration() throws RecognitionException {
        final procedure_declaration_return retval = new procedure_declaration_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        procedure_heading_return procedure_heading153 = null;
        try {
            root_0 = this.adaptor.nil();
            this.pushFollow(PLSQL2Parser.FOLLOW_procedure_heading_in_procedure_declaration1852);
            procedure_heading153 = this.procedure_heading();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, procedure_heading153.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final procedure_definition_return procedure_definition() throws RecognitionException {
        final procedure_definition_return retval = new procedure_definition_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token set155 = null;
        procedure_heading_return procedure_heading154 = null;
        declare_section_return declare_section156 = null;
        body_return body157 = null;
        final Object set155_tree = null;
        try {
            root_0 = this.adaptor.nil();
            this.pushFollow(PLSQL2Parser.FOLLOW_procedure_heading_in_procedure_definition1863);
            procedure_heading154 = this.procedure_heading();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, procedure_heading154.getTree());
            set155 = this.input.LT(1);
            if (this.input.LA(1) != 19 && this.input.LA(1) != 24) {
                final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                throw mse;
            }
            this.input.consume();
            this.adaptor.addChild(root_0, this.adaptor.create(set155));
            this.state.errorRecovery = false;
            int alt47 = 2;
            final int LA47_0 = this.input.LA(1);
            if ((LA47_0 >= 6 && LA47_0 <= 8) || LA47_0 == 18 || LA47_0 == 25 || LA47_0 == 74) {
                alt47 = 1;
            }
            switch (alt47) {
                case 1: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_declare_section_in_procedure_definition1876);
                    declare_section156 = this.declare_section();
                    final RecognizerSharedState state2 = this.state;
                    --state2._fsp;
                    this.adaptor.addChild(root_0, declare_section156.getTree());
                    break;
                }
            }
            this.pushFollow(PLSQL2Parser.FOLLOW_body_in_procedure_definition1879);
            body157 = this.body();
            final RecognizerSharedState state3 = this.state;
            --state3._fsp;
            this.adaptor.addChild(root_0, body157.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final body_return body() throws RecognitionException {
        final body_return retval = new body_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token BEGIN158 = null;
        Token SEMI160 = null;
        Token SEMI161 = null;
        Token SEMI162 = null;
        Token EXCEPTION165 = null;
        Token END167 = null;
        Token ID168 = null;
        statement_return statement159 = null;
        statement_return statement160 = null;
        pragma_return pragma163 = null;
        exception_handler_return exception_handler166 = null;
        Object BEGIN158_tree = null;
        Object SEMI160_tree = null;
        Object SEMI162_tree = null;
        Object SEMI164_tree = null;
        Object EXCEPTION165_tree = null;
        Object END167_tree = null;
        Object ID168_tree = null;
        Label_1030: {
            try {
                root_0 = this.adaptor.nil();
                BEGIN158 = (Token)this.match((IntStream)this.input, 42, PLSQL2Parser.FOLLOW_BEGIN_in_body1893);
                BEGIN158_tree = this.adaptor.create(BEGIN158);
                this.adaptor.addChild(root_0, BEGIN158_tree);
                this.pushFollow(PLSQL2Parser.FOLLOW_statement_in_body1895);
                statement159 = this.statement();
                final RecognizerSharedState state = this.state;
                --state._fsp;
                this.adaptor.addChild(root_0, statement159.getTree());
                SEMI160 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_body1897);
                SEMI160_tree = this.adaptor.create(SEMI160);
                this.adaptor.addChild(root_0, SEMI160_tree);
                while (true) {
                    int alt48 = 3;
                    final int LA48_0 = this.input.LA(1);
                    if (LA48_0 == 7 || LA48_0 == 9 || LA48_0 == 21 || LA48_0 == 42 || (LA48_0 >= 48 && LA48_0 <= 51) || (LA48_0 >= 53 && LA48_0 <= 55) || (LA48_0 >= 57 && LA48_0 <= 58) || (LA48_0 >= 65 && LA48_0 <= 66) || (LA48_0 >= 70 && LA48_0 <= 71) || LA48_0 == 73 || (LA48_0 >= 75 && LA48_0 <= 77) || (LA48_0 >= 79 && LA48_0 <= 85) || (LA48_0 >= 87 && LA48_0 <= 88)) {
                        alt48 = 1;
                    }
                    else if (LA48_0 == 74) {
                        alt48 = 2;
                    }
                    switch (alt48) {
                        case 1: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_statement_in_body1901);
                            statement160 = this.statement();
                            final RecognizerSharedState state2 = this.state;
                            --state2._fsp;
                            this.adaptor.addChild(root_0, statement160.getTree());
                            SEMI161 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_body1903);
                            SEMI162_tree = this.adaptor.create(SEMI161);
                            this.adaptor.addChild(root_0, SEMI162_tree);
                            continue;
                        }
                        case 2: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_pragma_in_body1907);
                            pragma163 = this.pragma();
                            final RecognizerSharedState state3 = this.state;
                            --state3._fsp;
                            this.adaptor.addChild(root_0, pragma163.getTree());
                            SEMI162 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_body1909);
                            SEMI164_tree = this.adaptor.create(SEMI162);
                            this.adaptor.addChild(root_0, SEMI164_tree);
                            continue;
                        }
                        default: {
                            int alt49 = 2;
                            final int LA50_0 = this.input.LA(1);
                            if (LA50_0 == 23) {
                                alt49 = 1;
                            }
                            Label_0797: {
                                switch (alt49) {
                                    case 1: {
                                        EXCEPTION165 = (Token)this.match((IntStream)this.input, 23, PLSQL2Parser.FOLLOW_EXCEPTION_in_body1917);
                                        EXCEPTION165_tree = this.adaptor.create(EXCEPTION165);
                                        this.adaptor.addChild(root_0, EXCEPTION165_tree);
                                        int cnt49 = 0;
                                        while (true) {
                                            int alt50 = 2;
                                            final int LA49_0 = this.input.LA(1);
                                            if (LA49_0 == 44) {
                                                alt50 = 1;
                                            }
                                            switch (alt50) {
                                                case 1: {
                                                    this.pushFollow(PLSQL2Parser.FOLLOW_exception_handler_in_body1919);
                                                    exception_handler166 = this.exception_handler();
                                                    final RecognizerSharedState state4 = this.state;
                                                    --state4._fsp;
                                                    this.adaptor.addChild(root_0, exception_handler166.getTree());
                                                    ++cnt49;
                                                    continue;
                                                }
                                                default: {
                                                    if (cnt49 >= 1) {
                                                        break Label_0797;
                                                    }
                                                    final EarlyExitException eee = new EarlyExitException(49, (IntStream)this.input);
                                                    throw eee;
                                                }
                                            }
                                        }
                                        /*break;*/
                                    }
                                }
                            }
                            END167 = (Token)this.match((IntStream)this.input, 43, PLSQL2Parser.FOLLOW_END_in_body1925);
                            END167_tree = this.adaptor.create(END167);
                            this.adaptor.addChild(root_0, END167_tree);
                            int alt51 = 2;
                            final int LA51_0 = this.input.LA(1);
                            if (LA51_0 == 7) {
                                alt51 = 1;
                            }
                            switch (alt51) {
                                case 1: {
                                    ID168 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_body1927);
                                    ID168_tree = this.adaptor.create(ID168);
                                    this.adaptor.addChild(root_0, ID168_tree);
                                    break;
                                }
                            }
                            retval.stop = this.input.LT(-1);
                            retval.tree = this.adaptor.rulePostProcessing(root_0);
                            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                            break Label_1030;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final exception_handler_return exception_handler() throws RecognitionException {
        final exception_handler_return retval = new exception_handler_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token WHEN169 = null;
        Token OR171 = null;
        Token OTHERS173 = null;
        Token THEN174 = null;
        Token SEMI176 = null;
        qual_id_return qual_id170 = null;
        qual_id_return qual_id171 = null;
        statement_return statement175 = null;
        Object WHEN169_tree = null;
        Object OR171_tree = null;
        Object OTHERS173_tree = null;
        Object THEN174_tree = null;
        Object SEMI176_tree = null;
        Label_0882: {
            try {
                root_0 = this.adaptor.nil();
                WHEN169 = (Token)this.match((IntStream)this.input, 44, PLSQL2Parser.FOLLOW_WHEN_in_exception_handler1939);
                WHEN169_tree = this.adaptor.create(WHEN169);
                this.adaptor.addChild(root_0, WHEN169_tree);
                int alt53 = 2;
                final int LA53_0 = this.input.LA(1);
                if (LA53_0 == 7 || LA53_0 == 48) {
                    alt53 = 1;
                }
                else {
                    if (LA53_0 != 46) {
                        final NoViableAltException nvae = new NoViableAltException("", 53, 0, (IntStream)this.input);
                        throw nvae;
                    }
                    alt53 = 2;
                }
                Label_0429: {
                    switch (alt53) {
                        case 1: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_qual_id_in_exception_handler1943);
                            qual_id170 = this.qual_id();
                            final RecognizerSharedState state = this.state;
                            --state._fsp;
                            this.adaptor.addChild(root_0, qual_id170.getTree());
                            while (true) {
                                int alt54 = 2;
                                final int LA52_0 = this.input.LA(1);
                                if (LA52_0 == 45) {
                                    alt54 = 1;
                                }
                                switch (alt54) {
                                    case 1: {
                                        OR171 = (Token)this.match((IntStream)this.input, 45, PLSQL2Parser.FOLLOW_OR_in_exception_handler1947);
                                        OR171_tree = this.adaptor.create(OR171);
                                        this.adaptor.addChild(root_0, OR171_tree);
                                        this.pushFollow(PLSQL2Parser.FOLLOW_qual_id_in_exception_handler1949);
                                        qual_id171 = this.qual_id();
                                        final RecognizerSharedState state2 = this.state;
                                        --state2._fsp;
                                        this.adaptor.addChild(root_0, qual_id171.getTree());
                                        continue;
                                    }
                                    default: {
                                        break Label_0429;
                                    }
                                }
                            }
                            /*break;*/
                        }
                        case 2: {
                            OTHERS173 = (Token)this.match((IntStream)this.input, 46, PLSQL2Parser.FOLLOW_OTHERS_in_exception_handler1956);
                            OTHERS173_tree = this.adaptor.create(OTHERS173);
                            this.adaptor.addChild(root_0, OTHERS173_tree);
                            break;
                        }
                    }
                }
                THEN174 = (Token)this.match((IntStream)this.input, 47, PLSQL2Parser.FOLLOW_THEN_in_exception_handler1962);
                THEN174_tree = this.adaptor.create(THEN174);
                this.adaptor.addChild(root_0, THEN174_tree);
                int cnt54 = 0;
                while (true) {
                    int alt55 = 2;
                    final int LA54_0 = this.input.LA(1);
                    if (LA54_0 == 7 || LA54_0 == 9 || LA54_0 == 21 || LA54_0 == 42 || (LA54_0 >= 48 && LA54_0 <= 51) || (LA54_0 >= 53 && LA54_0 <= 55) || (LA54_0 >= 57 && LA54_0 <= 58) || (LA54_0 >= 65 && LA54_0 <= 66) || (LA54_0 >= 70 && LA54_0 <= 71) || LA54_0 == 73 || (LA54_0 >= 75 && LA54_0 <= 77) || (LA54_0 >= 79 && LA54_0 <= 85) || (LA54_0 >= 87 && LA54_0 <= 88)) {
                        alt55 = 1;
                    }
                    switch (alt55) {
                        case 1: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_statement_in_exception_handler1966);
                            statement175 = this.statement();
                            final RecognizerSharedState state3 = this.state;
                            --state3._fsp;
                            this.adaptor.addChild(root_0, statement175.getTree());
                            SEMI176 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_exception_handler1968);
                            SEMI176_tree = this.adaptor.create(SEMI176);
                            this.adaptor.addChild(root_0, SEMI176_tree);
                            ++cnt54;
                            continue;
                        }
                        default: {
                            if (cnt54 >= 1) {
                                retval.stop = this.input.LT(-1);
                                retval.tree = this.adaptor.rulePostProcessing(root_0);
                                this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                                break Label_0882;
                            }
                            final EarlyExitException eee = new EarlyExitException(54, (IntStream)this.input);
                            throw eee;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final statement_return statement() throws RecognitionException {
        final statement_return retval = new statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        label_return label177 = null;
        assign_or_call_statement_return assign_or_call_statement178 = null;
        case_statement_return case_statement179 = null;
        close_statement_return close_statement180 = null;
        continue_statement_return continue_statement181 = null;
        basic_loop_statement_return basic_loop_statement182 = null;
        execute_immediate_statement_return execute_immediate_statement183 = null;
        exit_statement_return exit_statement184 = null;
        fetch_statement_return fetch_statement185 = null;
        for_loop_statement_return for_loop_statement186 = null;
        forall_statement_return forall_statement187 = null;
        goto_statement_return goto_statement188 = null;
        if_statement_return if_statement189 = null;
        null_statement_return null_statement190 = null;
        open_statement_return open_statement191 = null;
        plsql_block_return plsql_block192 = null;
        raise_statement_return raise_statement193 = null;
        return_statement_return return_statement194 = null;
        sql_statement_return sql_statement195 = null;
        while_loop_statement_return while_loop_statement196 = null;
        Label_1620: {
            try {
                root_0 = this.adaptor.nil();
                while (true) {
                    int alt55 = 2;
                    final int LA55_0 = this.input.LA(1);
                    if (LA55_0 == 77) {
                        alt55 = 1;
                    }
                    switch (alt55) {
                        case 1: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_label_in_statement1986);
                            label177 = this.label();
                            final RecognizerSharedState state = this.state;
                            --state._fsp;
                            this.adaptor.addChild(root_0, label177.getTree());
                            continue;
                        }
                        default: {
                            int alt56 = 19;
                            switch (this.input.LA(1)) {
                                case 7:
                                case 48: {
                                    alt56 = 1;
                                    break;
                                }
                                case 51: {
                                    alt56 = 2;
                                    break;
                                }
                                case 53: {
                                    alt56 = 3;
                                    break;
                                }
                                case 54: {
                                    alt56 = 4;
                                    break;
                                }
                                case 50: {
                                    alt56 = 5;
                                    break;
                                }
                                case 55: {
                                    alt56 = 6;
                                    break;
                                }
                                case 57: {
                                    alt56 = 7;
                                    break;
                                }
                                case 58: {
                                    alt56 = 8;
                                    break;
                                }
                                case 65: {
                                    alt56 = 9;
                                    break;
                                }
                                case 66: {
                                    alt56 = 10;
                                    break;
                                }
                                case 70: {
                                    alt56 = 11;
                                    break;
                                }
                                case 71: {
                                    alt56 = 12;
                                    break;
                                }
                                case 21: {
                                    alt56 = 13;
                                    break;
                                }
                                case 73: {
                                    alt56 = 14;
                                    break;
                                }
                                case 42:
                                case 76: {
                                    alt56 = 15;
                                    break;
                                }
                                case 75: {
                                    alt56 = 16;
                                    break;
                                }
                                case 9: {
                                    alt56 = 17;
                                    break;
                                }
                                case 49:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                case 84:
                                case 85:
                                case 87: {
                                    alt56 = 18;
                                    break;
                                }
                                case 88: {
                                    alt56 = 19;
                                    break;
                                }
                                default: {
                                    final NoViableAltException nvae = new NoViableAltException("", 56, 0, (IntStream)this.input);
                                    throw nvae;
                                }
                            }
                            switch (alt56) {
                                case 1: {
                                    this.pushFollow(PLSQL2Parser.FOLLOW_assign_or_call_statement_in_statement1995);
                                    assign_or_call_statement178 = this.assign_or_call_statement();
                                    final RecognizerSharedState state2 = this.state;
                                    --state2._fsp;
                                    this.adaptor.addChild(root_0, assign_or_call_statement178.getTree());
                                    break;
                                }
                                case 2: {
                                    this.pushFollow(PLSQL2Parser.FOLLOW_case_statement_in_statement2003);
                                    case_statement179 = this.case_statement();
                                    final RecognizerSharedState state3 = this.state;
                                    --state3._fsp;
                                    this.adaptor.addChild(root_0, case_statement179.getTree());
                                    break;
                                }
                                case 3: {
                                    this.pushFollow(PLSQL2Parser.FOLLOW_close_statement_in_statement2011);
                                    close_statement180 = this.close_statement();
                                    final RecognizerSharedState state4 = this.state;
                                    --state4._fsp;
                                    this.adaptor.addChild(root_0, close_statement180.getTree());
                                    break;
                                }
                                case 4: {
                                    this.pushFollow(PLSQL2Parser.FOLLOW_continue_statement_in_statement2019);
                                    continue_statement181 = this.continue_statement();
                                    final RecognizerSharedState state5 = this.state;
                                    --state5._fsp;
                                    this.adaptor.addChild(root_0, continue_statement181.getTree());
                                    break;
                                }
                                case 5: {
                                    this.pushFollow(PLSQL2Parser.FOLLOW_basic_loop_statement_in_statement2027);
                                    basic_loop_statement182 = this.basic_loop_statement();
                                    final RecognizerSharedState state6 = this.state;
                                    --state6._fsp;
                                    this.adaptor.addChild(root_0, basic_loop_statement182.getTree());
                                    break;
                                }
                                case 6: {
                                    this.pushFollow(PLSQL2Parser.FOLLOW_execute_immediate_statement_in_statement2035);
                                    execute_immediate_statement183 = this.execute_immediate_statement();
                                    final RecognizerSharedState state7 = this.state;
                                    --state7._fsp;
                                    this.adaptor.addChild(root_0, execute_immediate_statement183.getTree());
                                    break;
                                }
                                case 7: {
                                    this.pushFollow(PLSQL2Parser.FOLLOW_exit_statement_in_statement2043);
                                    exit_statement184 = this.exit_statement();
                                    final RecognizerSharedState state8 = this.state;
                                    --state8._fsp;
                                    this.adaptor.addChild(root_0, exit_statement184.getTree());
                                    break;
                                }
                                case 8: {
                                    this.pushFollow(PLSQL2Parser.FOLLOW_fetch_statement_in_statement2051);
                                    fetch_statement185 = this.fetch_statement();
                                    final RecognizerSharedState state9 = this.state;
                                    --state9._fsp;
                                    this.adaptor.addChild(root_0, fetch_statement185.getTree());
                                    break;
                                }
                                case 9: {
                                    this.pushFollow(PLSQL2Parser.FOLLOW_for_loop_statement_in_statement2059);
                                    for_loop_statement186 = this.for_loop_statement();
                                    final RecognizerSharedState state10 = this.state;
                                    --state10._fsp;
                                    this.adaptor.addChild(root_0, for_loop_statement186.getTree());
                                    break;
                                }
                                case 10: {
                                    this.pushFollow(PLSQL2Parser.FOLLOW_forall_statement_in_statement2067);
                                    forall_statement187 = this.forall_statement();
                                    final RecognizerSharedState state11 = this.state;
                                    --state11._fsp;
                                    this.adaptor.addChild(root_0, forall_statement187.getTree());
                                    break;
                                }
                                case 11: {
                                    this.pushFollow(PLSQL2Parser.FOLLOW_goto_statement_in_statement2075);
                                    goto_statement188 = this.goto_statement();
                                    final RecognizerSharedState state12 = this.state;
                                    --state12._fsp;
                                    this.adaptor.addChild(root_0, goto_statement188.getTree());
                                    break;
                                }
                                case 12: {
                                    this.pushFollow(PLSQL2Parser.FOLLOW_if_statement_in_statement2083);
                                    if_statement189 = this.if_statement();
                                    final RecognizerSharedState state13 = this.state;
                                    --state13._fsp;
                                    this.adaptor.addChild(root_0, if_statement189.getTree());
                                    break;
                                }
                                case 13: {
                                    this.pushFollow(PLSQL2Parser.FOLLOW_null_statement_in_statement2091);
                                    null_statement190 = this.null_statement();
                                    final RecognizerSharedState state14 = this.state;
                                    --state14._fsp;
                                    this.adaptor.addChild(root_0, null_statement190.getTree());
                                    break;
                                }
                                case 14: {
                                    this.pushFollow(PLSQL2Parser.FOLLOW_open_statement_in_statement2099);
                                    open_statement191 = this.open_statement();
                                    final RecognizerSharedState state15 = this.state;
                                    --state15._fsp;
                                    this.adaptor.addChild(root_0, open_statement191.getTree());
                                    break;
                                }
                                case 15: {
                                    this.pushFollow(PLSQL2Parser.FOLLOW_plsql_block_in_statement2107);
                                    plsql_block192 = this.plsql_block();
                                    final RecognizerSharedState state16 = this.state;
                                    --state16._fsp;
                                    this.adaptor.addChild(root_0, plsql_block192.getTree());
                                    break;
                                }
                                case 16: {
                                    this.pushFollow(PLSQL2Parser.FOLLOW_raise_statement_in_statement2115);
                                    raise_statement193 = this.raise_statement();
                                    final RecognizerSharedState state17 = this.state;
                                    --state17._fsp;
                                    this.adaptor.addChild(root_0, raise_statement193.getTree());
                                    break;
                                }
                                case 17: {
                                    this.pushFollow(PLSQL2Parser.FOLLOW_return_statement_in_statement2123);
                                    return_statement194 = this.return_statement();
                                    final RecognizerSharedState state18 = this.state;
                                    --state18._fsp;
                                    this.adaptor.addChild(root_0, return_statement194.getTree());
                                    break;
                                }
                                case 18: {
                                    this.pushFollow(PLSQL2Parser.FOLLOW_sql_statement_in_statement2131);
                                    sql_statement195 = this.sql_statement();
                                    final RecognizerSharedState state19 = this.state;
                                    --state19._fsp;
                                    this.adaptor.addChild(root_0, sql_statement195.getTree());
                                    break;
                                }
                                case 19: {
                                    this.pushFollow(PLSQL2Parser.FOLLOW_while_loop_statement_in_statement2139);
                                    while_loop_statement196 = this.while_loop_statement();
                                    final RecognizerSharedState state20 = this.state;
                                    --state20._fsp;
                                    this.adaptor.addChild(root_0, while_loop_statement196.getTree());
                                    break;
                                }
                            }
                            retval.stop = this.input.LT(-1);
                            retval.tree = this.adaptor.rulePostProcessing(root_0);
                            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                            break Label_1620;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final lvalue_return lvalue() throws RecognitionException {
        final lvalue_return retval = new lvalue_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token DOT198 = null;
        call_return call197 = null;
        call_return call198 = null;
        Object DOT198_tree = null;
        Label_0344: {
            try {
                root_0 = this.adaptor.nil();
                this.pushFollow(PLSQL2Parser.FOLLOW_call_in_lvalue2162);
                call197 = this.call();
                final RecognizerSharedState state = this.state;
                --state._fsp;
                this.adaptor.addChild(root_0, call197.getTree());
                while (true) {
                    int alt57 = 2;
                    final int LA57_0 = this.input.LA(1);
                    if (LA57_0 == 35) {
                        final int LA57_2 = this.input.LA(2);
                        if (LA57_2 == 7 || LA57_2 == 48) {
                            alt57 = 1;
                        }
                    }
                    switch (alt57) {
                        case 1: {
                            DOT198 = (Token)this.match((IntStream)this.input, 35, PLSQL2Parser.FOLLOW_DOT_in_lvalue2166);
                            DOT198_tree = this.adaptor.create(DOT198);
                            this.adaptor.addChild(root_0, DOT198_tree);
                            this.pushFollow(PLSQL2Parser.FOLLOW_call_in_lvalue2168);
                            call198 = this.call();
                            final RecognizerSharedState state2 = this.state;
                            --state2._fsp;
                            this.adaptor.addChild(root_0, call198.getTree());
                            continue;
                        }
                        default: {
                            retval.stop = this.input.LT(-1);
                            retval.tree = this.adaptor.rulePostProcessing(root_0);
                            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                            break Label_0344;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final assign_or_call_statement_return assign_or_call_statement() throws RecognitionException {
        final assign_or_call_statement_return retval = new assign_or_call_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token DOT201 = null;
        Token ASSIGN203 = null;
        lvalue_return lvalue200 = null;
        delete_call_return delete_call202 = null;
        expression_return expression204 = null;
        Object DOT201_tree = null;
        Object ASSIGN203_tree = null;
        try {
            root_0 = this.adaptor.nil();
            this.pushFollow(PLSQL2Parser.FOLLOW_lvalue_in_assign_or_call_statement2188);
            lvalue200 = this.lvalue();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, lvalue200.getTree());
            int alt58 = 3;
            final int LA58_0 = this.input.LA(1);
            if (LA58_0 == 35) {
                alt58 = 1;
            }
            else if (LA58_0 == 13) {
                alt58 = 2;
            }
            switch (alt58) {
                case 1: {
                    DOT201 = (Token)this.match((IntStream)this.input, 35, PLSQL2Parser.FOLLOW_DOT_in_assign_or_call_statement2192);
                    DOT201_tree = this.adaptor.create(DOT201);
                    this.adaptor.addChild(root_0, DOT201_tree);
                    this.pushFollow(PLSQL2Parser.FOLLOW_delete_call_in_assign_or_call_statement2194);
                    delete_call202 = this.delete_call();
                    final RecognizerSharedState state2 = this.state;
                    --state2._fsp;
                    this.adaptor.addChild(root_0, delete_call202.getTree());
                    break;
                }
                case 2: {
                    ASSIGN203 = (Token)this.match((IntStream)this.input, 13, PLSQL2Parser.FOLLOW_ASSIGN_in_assign_or_call_statement2198);
                    ASSIGN203_tree = this.adaptor.create(ASSIGN203);
                    this.adaptor.addChild(root_0, ASSIGN203_tree);
                    this.pushFollow(PLSQL2Parser.FOLLOW_expression_in_assign_or_call_statement2200);
                    expression204 = this.expression();
                    final RecognizerSharedState state3 = this.state;
                    --state3._fsp;
                    this.adaptor.addChild(root_0, expression204.getTree());
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final call_return call() throws RecognitionException {
        final call_return retval = new call_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token COLON205 = null;
        Token ID206 = null;
        Token LPAREN207 = null;
        Token COMMA209 = null;
        Token RPAREN211 = null;
        parameter_return parameter208 = null;
        parameter_return parameter209 = null;
        Object COLON205_tree = null;
        Object ID206_tree = null;
        Object LPAREN207_tree = null;
        Object COMMA209_tree = null;
        Object RPAREN211_tree = null;
        try {
            root_0 = this.adaptor.nil();
            int alt59 = 2;
            final int LA59_0 = this.input.LA(1);
            if (LA59_0 == 48) {
                alt59 = 1;
            }
            switch (alt59) {
                case 1: {
                    COLON205 = (Token)this.match((IntStream)this.input, 48, PLSQL2Parser.FOLLOW_COLON_in_call2220);
                    COLON205_tree = this.adaptor.create(COLON205);
                    this.adaptor.addChild(root_0, COLON205_tree);
                    break;
                }
            }
            ID206 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_call2223);
            ID206_tree = this.adaptor.create(ID206);
            this.adaptor.addChild(root_0, ID206_tree);
            int alt60 = 2;
            final int LA62_0 = this.input.LA(1);
            if (LA62_0 == 10) {
                alt60 = 1;
            }
            switch (alt60) {
                case 1: {
                    LPAREN207 = (Token)this.match((IntStream)this.input, 10, PLSQL2Parser.FOLLOW_LPAREN_in_call2227);
                    LPAREN207_tree = this.adaptor.create(LPAREN207);
                    this.adaptor.addChild(root_0, LPAREN207_tree);
                    int alt61 = 2;
                    final int LA61_0 = this.input.LA(1);
                    if (LA61_0 == 7 || LA61_0 == 10 || (LA61_0 >= 20 && LA61_0 <= 21) || LA61_0 == 48 || (LA61_0 >= 96 && LA61_0 <= 97) || LA61_0 == 101 || (LA61_0 >= 105 && LA61_0 <= 109) || (LA61_0 >= 111 && LA61_0 <= 113)) {
                        alt61 = 1;
                    }
                    Label_0583: {
                        switch (alt61) {
                            case 1: {
                                this.pushFollow(PLSQL2Parser.FOLLOW_parameter_in_call2231);
                                parameter208 = this.parameter();
                                final RecognizerSharedState state = this.state;
                                --state._fsp;
                                this.adaptor.addChild(root_0, parameter208.getTree());
                                while (true) {
                                    int alt62 = 2;
                                    final int LA60_0 = this.input.LA(1);
                                    if (LA60_0 == 11) {
                                        alt62 = 1;
                                    }
                                    switch (alt62) {
                                        case 1: {
                                            COMMA209 = (Token)this.match((IntStream)this.input, 11, PLSQL2Parser.FOLLOW_COMMA_in_call2235);
                                            COMMA209_tree = this.adaptor.create(COMMA209);
                                            this.adaptor.addChild(root_0, COMMA209_tree);
                                            this.pushFollow(PLSQL2Parser.FOLLOW_parameter_in_call2237);
                                            parameter209 = this.parameter();
                                            final RecognizerSharedState state2 = this.state;
                                            --state2._fsp;
                                            this.adaptor.addChild(root_0, parameter209.getTree());
                                            continue;
                                        }
                                        default: {
                                            break Label_0583;
                                        }
                                    }
                                }
                                /*break;*/
                            }
                        }
                    }
                    RPAREN211 = (Token)this.match((IntStream)this.input, 12, PLSQL2Parser.FOLLOW_RPAREN_in_call2245);
                    RPAREN211_tree = this.adaptor.create(RPAREN211);
                    this.adaptor.addChild(root_0, RPAREN211_tree);
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final delete_call_return delete_call() throws RecognitionException {
        final delete_call_return retval = new delete_call_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token DELETE212 = null;
        Token LPAREN213 = null;
        Token RPAREN215 = null;
        parameter_return parameter214 = null;
        Object DELETE212_tree = null;
        Object LPAREN213_tree = null;
        Object RPAREN215_tree = null;
        try {
            root_0 = this.adaptor.nil();
            DELETE212 = (Token)this.match((IntStream)this.input, 49, PLSQL2Parser.FOLLOW_DELETE_in_delete_call2265);
            DELETE212_tree = this.adaptor.create(DELETE212);
            this.adaptor.addChild(root_0, DELETE212_tree);
            int alt64 = 2;
            final int LA64_0 = this.input.LA(1);
            if (LA64_0 == 10) {
                alt64 = 1;
            }
            switch (alt64) {
                case 1: {
                    LPAREN213 = (Token)this.match((IntStream)this.input, 10, PLSQL2Parser.FOLLOW_LPAREN_in_delete_call2269);
                    LPAREN213_tree = this.adaptor.create(LPAREN213);
                    this.adaptor.addChild(root_0, LPAREN213_tree);
                    int alt65 = 2;
                    final int LA63_0 = this.input.LA(1);
                    if (LA63_0 == 7 || LA63_0 == 10 || (LA63_0 >= 20 && LA63_0 <= 21) || LA63_0 == 48 || (LA63_0 >= 96 && LA63_0 <= 97) || LA63_0 == 101 || (LA63_0 >= 105 && LA63_0 <= 109) || (LA63_0 >= 111 && LA63_0 <= 113)) {
                        alt65 = 1;
                    }
                    switch (alt65) {
                        case 1: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_parameter_in_delete_call2271);
                            parameter214 = this.parameter();
                            final RecognizerSharedState state = this.state;
                            --state._fsp;
                            this.adaptor.addChild(root_0, parameter214.getTree());
                            break;
                        }
                    }
                    RPAREN215 = (Token)this.match((IntStream)this.input, 12, PLSQL2Parser.FOLLOW_RPAREN_in_delete_call2274);
                    RPAREN215_tree = this.adaptor.create(RPAREN215);
                    this.adaptor.addChild(root_0, RPAREN215_tree);
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final basic_loop_statement_return basic_loop_statement() throws RecognitionException {
        final basic_loop_statement_return retval = new basic_loop_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token LOOP216 = null;
        Token SEMI218 = null;
        Token END219 = null;
        Token LOOP217 = null;
        statement_return statement217 = null;
        label_name_return label_name221 = null;
        Object LOOP216_tree = null;
        Object SEMI218_tree = null;
        Object END219_tree = null;
        Object LOOP220_tree = null;
        Label_0688: {
            try {
                root_0 = this.adaptor.nil();
                LOOP216 = (Token)this.match((IntStream)this.input, 50, PLSQL2Parser.FOLLOW_LOOP_in_basic_loop_statement2298);
                LOOP216_tree = this.adaptor.create(LOOP216);
                this.adaptor.addChild(root_0, LOOP216_tree);
                int cnt65 = 0;
                while (true) {
                    int alt65 = 2;
                    final int LA65_0 = this.input.LA(1);
                    if (LA65_0 == 7 || LA65_0 == 9 || LA65_0 == 21 || LA65_0 == 42 || (LA65_0 >= 48 && LA65_0 <= 51) || (LA65_0 >= 53 && LA65_0 <= 55) || (LA65_0 >= 57 && LA65_0 <= 58) || (LA65_0 >= 65 && LA65_0 <= 66) || (LA65_0 >= 70 && LA65_0 <= 71) || LA65_0 == 73 || (LA65_0 >= 75 && LA65_0 <= 77) || (LA65_0 >= 79 && LA65_0 <= 85) || (LA65_0 >= 87 && LA65_0 <= 88)) {
                        alt65 = 1;
                    }
                    switch (alt65) {
                        case 1: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_statement_in_basic_loop_statement2302);
                            statement217 = this.statement();
                            final RecognizerSharedState state = this.state;
                            --state._fsp;
                            this.adaptor.addChild(root_0, statement217.getTree());
                            SEMI218 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_basic_loop_statement2304);
                            SEMI218_tree = this.adaptor.create(SEMI218);
                            this.adaptor.addChild(root_0, SEMI218_tree);
                            ++cnt65;
                            continue;
                        }
                        default: {
                            if (cnt65 >= 1) {
                                END219 = (Token)this.match((IntStream)this.input, 43, PLSQL2Parser.FOLLOW_END_in_basic_loop_statement2309);
                                END219_tree = this.adaptor.create(END219);
                                this.adaptor.addChild(root_0, END219_tree);
                                LOOP217 = (Token)this.match((IntStream)this.input, 50, PLSQL2Parser.FOLLOW_LOOP_in_basic_loop_statement2311);
                                LOOP220_tree = this.adaptor.create(LOOP217);
                                this.adaptor.addChild(root_0, LOOP220_tree);
                                int alt66 = 2;
                                final int LA66_0 = this.input.LA(1);
                                if (LA66_0 == 7) {
                                    alt66 = 1;
                                }
                                switch (alt66) {
                                    case 1: {
                                        this.pushFollow(PLSQL2Parser.FOLLOW_label_name_in_basic_loop_statement2313);
                                        label_name221 = this.label_name();
                                        final RecognizerSharedState state2 = this.state;
                                        --state2._fsp;
                                        this.adaptor.addChild(root_0, label_name221.getTree());
                                        break;
                                    }
                                }
                                retval.stop = this.input.LT(-1);
                                retval.tree = this.adaptor.rulePostProcessing(root_0);
                                this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                                break Label_0688;
                            }
                            final EarlyExitException eee = new EarlyExitException(65, (IntStream)this.input);
                            throw eee;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final case_statement_return case_statement() throws RecognitionException {
        final case_statement_return retval = new case_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token CASE222 = null;
        Token WHEN224 = null;
        Token THEN226 = null;
        Token SEMI228 = null;
        Token ELSE229 = null;
        Token SEMI229 = null;
        Token END232 = null;
        Token CASE223 = null;
        expression_return expression223 = null;
        expression_return expression224 = null;
        statement_return statement227 = null;
        statement_return statement228 = null;
        label_name_return label_name234 = null;
        Object CASE222_tree = null;
        Object WHEN224_tree = null;
        Object THEN226_tree = null;
        Object SEMI228_tree = null;
        Object ELSE229_tree = null;
        Object SEMI231_tree = null;
        Object END232_tree = null;
        Object CASE233_tree = null;
        Label_1260: {
            try {
                root_0 = this.adaptor.nil();
                CASE222 = (Token)this.match((IntStream)this.input, 51, PLSQL2Parser.FOLLOW_CASE_in_case_statement2335);
                CASE222_tree = this.adaptor.create(CASE222);
                this.adaptor.addChild(root_0, CASE222_tree);
                int alt67 = 2;
                final int LA67_0 = this.input.LA(1);
                if (LA67_0 == 7 || LA67_0 == 10 || (LA67_0 >= 20 && LA67_0 <= 21) || LA67_0 == 48 || (LA67_0 >= 96 && LA67_0 <= 97) || LA67_0 == 101 || (LA67_0 >= 105 && LA67_0 <= 109) || (LA67_0 >= 111 && LA67_0 <= 113)) {
                    alt67 = 1;
                }
                switch (alt67) {
                    case 1: {
                        this.pushFollow(PLSQL2Parser.FOLLOW_expression_in_case_statement2337);
                        expression223 = this.expression();
                        final RecognizerSharedState state = this.state;
                        --state._fsp;
                        this.adaptor.addChild(root_0, expression223.getTree());
                        break;
                    }
                }
                int cnt69 = 0;
            Label_0304:
                while (true) {
                    while (true) {
                        int alt68 = 2;
                        final int LA69_0 = this.input.LA(1);
                        if (LA69_0 == 44) {
                            alt68 = 1;
                        }
                        switch (alt68) {
                            case 1: {
                                WHEN224 = (Token)this.match((IntStream)this.input, 44, PLSQL2Parser.FOLLOW_WHEN_in_case_statement2350);
                                WHEN224_tree = this.adaptor.create(WHEN224);
                                this.adaptor.addChild(root_0, WHEN224_tree);
                                this.pushFollow(PLSQL2Parser.FOLLOW_expression_in_case_statement2352);
                                expression224 = this.expression();
                                final RecognizerSharedState state2 = this.state;
                                --state2._fsp;
                                this.adaptor.addChild(root_0, expression224.getTree());
                                THEN226 = (Token)this.match((IntStream)this.input, 47, PLSQL2Parser.FOLLOW_THEN_in_case_statement2354);
                                THEN226_tree = this.adaptor.create(THEN226);
                                this.adaptor.addChild(root_0, THEN226_tree);
                                int cnt70 = 0;
                                while (true) {
                                    int alt69 = 2;
                                    final int LA68_0 = this.input.LA(1);
                                    if (LA68_0 == 7 || LA68_0 == 9 || LA68_0 == 21 || LA68_0 == 42 || (LA68_0 >= 48 && LA68_0 <= 51) || (LA68_0 >= 53 && LA68_0 <= 55) || (LA68_0 >= 57 && LA68_0 <= 58) || (LA68_0 >= 65 && LA68_0 <= 66) || (LA68_0 >= 70 && LA68_0 <= 71) || LA68_0 == 73 || (LA68_0 >= 75 && LA68_0 <= 77) || (LA68_0 >= 79 && LA68_0 <= 85) || (LA68_0 >= 87 && LA68_0 <= 88)) {
                                        alt69 = 1;
                                    }
                                    switch (alt69) {
                                        case 1: {
                                            this.pushFollow(PLSQL2Parser.FOLLOW_statement_in_case_statement2358);
                                            statement227 = this.statement();
                                            final RecognizerSharedState state3 = this.state;
                                            --state3._fsp;
                                            this.adaptor.addChild(root_0, statement227.getTree());
                                            SEMI228 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_case_statement2360);
                                            SEMI228_tree = this.adaptor.create(SEMI228);
                                            this.adaptor.addChild(root_0, SEMI228_tree);
                                            ++cnt70;
                                            continue;
                                        }
                                        default: {
                                            if (cnt70 >= 1) {
                                                ++cnt69;
                                                continue Label_0304;
                                            }
                                            final EarlyExitException eee = new EarlyExitException(68, (IntStream)this.input);
                                            throw eee;
                                        }
                                    }
                                }
                                /*break;*/
                            }
                            default: {
                                if (cnt69 >= 1) {
                                    int alt70 = 2;
                                    final int LA70_0 = this.input.LA(1);
                                    if (LA70_0 == 52) {
                                        alt70 = 1;
                                    }
                                    switch (alt70) {
                                        case 1: {
                                            ELSE229 = (Token)this.match((IntStream)this.input, 52, PLSQL2Parser.FOLLOW_ELSE_in_case_statement2378);
                                            ELSE229_tree = this.adaptor.create(ELSE229);
                                            this.adaptor.addChild(root_0, ELSE229_tree);
                                            this.pushFollow(PLSQL2Parser.FOLLOW_statement_in_case_statement2380);
                                            statement228 = this.statement();
                                            final RecognizerSharedState state4 = this.state;
                                            --state4._fsp;
                                            this.adaptor.addChild(root_0, statement228.getTree());
                                            SEMI229 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_case_statement2382);
                                            SEMI231_tree = this.adaptor.create(SEMI229);
                                            this.adaptor.addChild(root_0, SEMI231_tree);
                                            break;
                                        }
                                    }
                                    END232 = (Token)this.match((IntStream)this.input, 43, PLSQL2Parser.FOLLOW_END_in_case_statement2395);
                                    END232_tree = this.adaptor.create(END232);
                                    this.adaptor.addChild(root_0, END232_tree);
                                    CASE223 = (Token)this.match((IntStream)this.input, 51, PLSQL2Parser.FOLLOW_CASE_in_case_statement2397);
                                    CASE233_tree = this.adaptor.create(CASE223);
                                    this.adaptor.addChild(root_0, CASE233_tree);
                                    int alt71 = 2;
                                    final int LA71_0 = this.input.LA(1);
                                    if (LA71_0 == 7) {
                                        alt71 = 1;
                                    }
                                    switch (alt71) {
                                        case 1: {
                                            this.pushFollow(PLSQL2Parser.FOLLOW_label_name_in_case_statement2399);
                                            label_name234 = this.label_name();
                                            final RecognizerSharedState state5 = this.state;
                                            --state5._fsp;
                                            this.adaptor.addChild(root_0, label_name234.getTree());
                                            break;
                                        }
                                    }
                                    retval.stop = this.input.LT(-1);
                                    retval.tree = this.adaptor.rulePostProcessing(root_0);
                                    this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                                    break Label_1260;
                                }
                                final EarlyExitException eee2 = new EarlyExitException(69, (IntStream)this.input);
                                throw eee2;
                            }
                        }
                    }
                    /*break;*/
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final close_statement_return close_statement() throws RecognitionException {
        final close_statement_return retval = new close_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token CLOSE235 = null;
        Token ID236 = null;
        Token DOT237 = null;
        Token ID237 = null;
        Object CLOSE235_tree = null;
        Object ID236_tree = null;
        Object DOT237_tree = null;
        Object ID238_tree = null;
        try {
            root_0 = this.adaptor.nil();
            CLOSE235 = (Token)this.match((IntStream)this.input, 53, PLSQL2Parser.FOLLOW_CLOSE_in_close_statement2421);
            CLOSE235_tree = this.adaptor.create(CLOSE235);
            this.adaptor.addChild(root_0, CLOSE235_tree);
            ID236 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_close_statement2423);
            ID236_tree = this.adaptor.create(ID236);
            this.adaptor.addChild(root_0, ID236_tree);
            int alt72 = 2;
            final int LA72_0 = this.input.LA(1);
            if (LA72_0 == 35) {
                alt72 = 1;
            }
            switch (alt72) {
                case 1: {
                    DOT237 = (Token)this.match((IntStream)this.input, 35, PLSQL2Parser.FOLLOW_DOT_in_close_statement2427);
                    DOT237_tree = this.adaptor.create(DOT237);
                    this.adaptor.addChild(root_0, DOT237_tree);
                    ID237 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_close_statement2429);
                    ID238_tree = this.adaptor.create(ID237);
                    this.adaptor.addChild(root_0, ID238_tree);
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final continue_statement_return continue_statement() throws RecognitionException {
        final continue_statement_return retval = new continue_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token lbl = null;
        Token CONTINUE239 = null;
        Token WHEN240 = null;
        expression_return expression241 = null;
        Object lbl_tree = null;
        Object CONTINUE239_tree = null;
        Object WHEN240_tree = null;
        try {
            root_0 = this.adaptor.nil();
            CONTINUE239 = (Token)this.match((IntStream)this.input, 54, PLSQL2Parser.FOLLOW_CONTINUE_in_continue_statement2453);
            CONTINUE239_tree = this.adaptor.create(CONTINUE239);
            this.adaptor.addChild(root_0, CONTINUE239_tree);
            int alt73 = 2;
            final int LA73_0 = this.input.LA(1);
            if (LA73_0 == 7) {
                alt73 = 1;
            }
            switch (alt73) {
                case 1: {
                    lbl = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_continue_statement2459);
                    lbl_tree = this.adaptor.create(lbl);
                    this.adaptor.addChild(root_0, lbl_tree);
                    break;
                }
            }
            int alt74 = 2;
            final int LA74_0 = this.input.LA(1);
            if (LA74_0 == 44) {
                alt74 = 1;
            }
            switch (alt74) {
                case 1: {
                    WHEN240 = (Token)this.match((IntStream)this.input, 44, PLSQL2Parser.FOLLOW_WHEN_in_continue_statement2466);
                    WHEN240_tree = this.adaptor.create(WHEN240);
                    this.adaptor.addChild(root_0, WHEN240_tree);
                    this.pushFollow(PLSQL2Parser.FOLLOW_expression_in_continue_statement2468);
                    expression241 = this.expression();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    this.adaptor.addChild(root_0, expression241.getTree());
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final execute_immediate_statement_return execute_immediate_statement() throws RecognitionException {
        final execute_immediate_statement_return retval = new execute_immediate_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token EXECUTE242 = null;
        Token IMMEDIATE243 = null;
        expression_return expression244 = null;
        into_clause_return into_clause245 = null;
        bulk_collect_into_clause_return bulk_collect_into_clause246 = null;
        using_clause_return using_clause247 = null;
        using_clause_return using_clause248 = null;
        dynamic_returning_clause_return dynamic_returning_clause249 = null;
        dynamic_returning_clause_return dynamic_returning_clause250 = null;
        Object EXECUTE242_tree = null;
        Object IMMEDIATE243_tree = null;
        try {
            root_0 = this.adaptor.nil();
            EXECUTE242 = (Token)this.match((IntStream)this.input, 55, PLSQL2Parser.FOLLOW_EXECUTE_in_execute_immediate_statement2492);
            EXECUTE242_tree = this.adaptor.create(EXECUTE242);
            this.adaptor.addChild(root_0, EXECUTE242_tree);
            IMMEDIATE243 = (Token)this.match((IntStream)this.input, 56, PLSQL2Parser.FOLLOW_IMMEDIATE_in_execute_immediate_statement2494);
            IMMEDIATE243_tree = this.adaptor.create(IMMEDIATE243);
            this.adaptor.addChild(root_0, IMMEDIATE243_tree);
            this.pushFollow(PLSQL2Parser.FOLLOW_expression_in_execute_immediate_statement2496);
            expression244 = this.expression();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, expression244.getTree());
            int alt78 = 4;
            switch (this.input.LA(1)) {
                case 60:
                case 61: {
                    alt78 = 1;
                    break;
                }
                case 63: {
                    alt78 = 2;
                    break;
                }
                case 9:
                case 64: {
                    alt78 = 3;
                    break;
                }
            }
            switch (alt78) {
                case 1: {
                    int alt79 = 2;
                    final int LA75_0 = this.input.LA(1);
                    if (LA75_0 == 60) {
                        alt79 = 1;
                    }
                    else {
                        if (LA75_0 != 61) {
                            final NoViableAltException nvae = new NoViableAltException("", 75, 0, (IntStream)this.input);
                            throw nvae;
                        }
                        alt79 = 2;
                    }
                    switch (alt79) {
                        case 1: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_into_clause_in_execute_immediate_statement2510);
                            into_clause245 = this.into_clause();
                            final RecognizerSharedState state2 = this.state;
                            --state2._fsp;
                            this.adaptor.addChild(root_0, into_clause245.getTree());
                            break;
                        }
                        case 2: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_bulk_collect_into_clause_in_execute_immediate_statement2514);
                            bulk_collect_into_clause246 = this.bulk_collect_into_clause();
                            final RecognizerSharedState state3 = this.state;
                            --state3._fsp;
                            this.adaptor.addChild(root_0, bulk_collect_into_clause246.getTree());
                            break;
                        }
                    }
                    int alt80 = 2;
                    final int LA76_0 = this.input.LA(1);
                    if (LA76_0 == 63) {
                        alt80 = 1;
                    }
                    switch (alt80) {
                        case 1: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_using_clause_in_execute_immediate_statement2517);
                            using_clause247 = this.using_clause();
                            final RecognizerSharedState state4 = this.state;
                            --state4._fsp;
                            this.adaptor.addChild(root_0, using_clause247.getTree());
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_using_clause_in_execute_immediate_statement2530);
                    using_clause248 = this.using_clause();
                    final RecognizerSharedState state5 = this.state;
                    --state5._fsp;
                    this.adaptor.addChild(root_0, using_clause248.getTree());
                    int alt81 = 2;
                    final int LA77_0 = this.input.LA(1);
                    if (LA77_0 == 9 || LA77_0 == 64) {
                        alt81 = 1;
                    }
                    switch (alt81) {
                        case 1: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_dynamic_returning_clause_in_execute_immediate_statement2532);
                            dynamic_returning_clause249 = this.dynamic_returning_clause();
                            final RecognizerSharedState state6 = this.state;
                            --state6._fsp;
                            this.adaptor.addChild(root_0, dynamic_returning_clause249.getTree());
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_dynamic_returning_clause_in_execute_immediate_statement2545);
                    dynamic_returning_clause250 = this.dynamic_returning_clause();
                    final RecognizerSharedState state7 = this.state;
                    --state7._fsp;
                    this.adaptor.addChild(root_0, dynamic_returning_clause250.getTree());
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final exit_statement_return exit_statement() throws RecognitionException {
        final exit_statement_return retval = new exit_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token lbl = null;
        Token EXIT251 = null;
        Token WHEN252 = null;
        expression_return expression253 = null;
        Object lbl_tree = null;
        Object EXIT251_tree = null;
        Object WHEN252_tree = null;
        try {
            root_0 = this.adaptor.nil();
            EXIT251 = (Token)this.match((IntStream)this.input, 57, PLSQL2Parser.FOLLOW_EXIT_in_exit_statement2577);
            EXIT251_tree = this.adaptor.create(EXIT251);
            this.adaptor.addChild(root_0, EXIT251_tree);
            int alt79 = 2;
            final int LA79_0 = this.input.LA(1);
            if (LA79_0 == 7) {
                alt79 = 1;
            }
            switch (alt79) {
                case 1: {
                    lbl = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_exit_statement2583);
                    lbl_tree = this.adaptor.create(lbl);
                    this.adaptor.addChild(root_0, lbl_tree);
                    break;
                }
            }
            int alt80 = 2;
            final int LA80_0 = this.input.LA(1);
            if (LA80_0 == 44) {
                alt80 = 1;
            }
            switch (alt80) {
                case 1: {
                    WHEN252 = (Token)this.match((IntStream)this.input, 44, PLSQL2Parser.FOLLOW_WHEN_in_exit_statement2590);
                    WHEN252_tree = this.adaptor.create(WHEN252);
                    this.adaptor.addChild(root_0, WHEN252_tree);
                    this.pushFollow(PLSQL2Parser.FOLLOW_expression_in_exit_statement2592);
                    expression253 = this.expression();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    this.adaptor.addChild(root_0, expression253.getTree());
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final fetch_statement_return fetch_statement() throws RecognitionException {
        final fetch_statement_return retval = new fetch_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token FETCH254 = null;
        Token LIMIT258 = null;
        qual_id_return qual_id255 = null;
        into_clause_return into_clause256 = null;
        bulk_collect_into_clause_return bulk_collect_into_clause257 = null;
        numeric_expression_return numeric_expression259 = null;
        Object FETCH254_tree = null;
        Object LIMIT258_tree = null;
        try {
            root_0 = this.adaptor.nil();
            FETCH254 = (Token)this.match((IntStream)this.input, 58, PLSQL2Parser.FOLLOW_FETCH_in_fetch_statement2616);
            FETCH254_tree = this.adaptor.create(FETCH254);
            this.adaptor.addChild(root_0, FETCH254_tree);
            this.pushFollow(PLSQL2Parser.FOLLOW_qual_id_in_fetch_statement2618);
            qual_id255 = this.qual_id();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, qual_id255.getTree());
            int alt82 = 2;
            final int LA82_0 = this.input.LA(1);
            if (LA82_0 == 60) {
                alt82 = 1;
            }
            else {
                if (LA82_0 != 61) {
                    final NoViableAltException nvae = new NoViableAltException("", 82, 0, (IntStream)this.input);
                    throw nvae;
                }
                alt82 = 2;
            }
            Label_0444: {
                switch (alt82) {
                    case 1: {
                        this.pushFollow(PLSQL2Parser.FOLLOW_into_clause_in_fetch_statement2622);
                        into_clause256 = this.into_clause();
                        final RecognizerSharedState state2 = this.state;
                        --state2._fsp;
                        this.adaptor.addChild(root_0, into_clause256.getTree());
                        break;
                    }
                    case 2: {
                        this.pushFollow(PLSQL2Parser.FOLLOW_bulk_collect_into_clause_in_fetch_statement2626);
                        bulk_collect_into_clause257 = this.bulk_collect_into_clause();
                        final RecognizerSharedState state3 = this.state;
                        --state3._fsp;
                        this.adaptor.addChild(root_0, bulk_collect_into_clause257.getTree());
                        int alt83 = 2;
                        final int LA81_0 = this.input.LA(1);
                        if (LA81_0 == 59) {
                            alt83 = 1;
                        }
                        switch (alt83) {
                            case 1: {
                                LIMIT258 = (Token)this.match((IntStream)this.input, 59, PLSQL2Parser.FOLLOW_LIMIT_in_fetch_statement2630);
                                LIMIT258_tree = this.adaptor.create(LIMIT258);
                                this.adaptor.addChild(root_0, LIMIT258_tree);
                                this.pushFollow(PLSQL2Parser.FOLLOW_numeric_expression_in_fetch_statement2632);
                                numeric_expression259 = this.numeric_expression();
                                final RecognizerSharedState state4 = this.state;
                                --state4._fsp;
                                this.adaptor.addChild(root_0, numeric_expression259.getTree());
                                break Label_0444;
                            }
                        }
                        break;
                    }
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final into_clause_return into_clause() throws RecognitionException {
        final into_clause_return retval = new into_clause_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token INTO260 = null;
        Token COMMA262 = null;
        lvalue_return lvalue261 = null;
        lvalue_return lvalue262 = null;
        Object INTO260_tree = null;
        Object COMMA262_tree = null;
        Label_0370: {
            try {
                root_0 = this.adaptor.nil();
                INTO260 = (Token)this.match((IntStream)this.input, 60, PLSQL2Parser.FOLLOW_INTO_in_into_clause2662);
                INTO260_tree = this.adaptor.create(INTO260);
                this.adaptor.addChild(root_0, INTO260_tree);
                this.pushFollow(PLSQL2Parser.FOLLOW_lvalue_in_into_clause2664);
                lvalue261 = this.lvalue();
                final RecognizerSharedState state = this.state;
                --state._fsp;
                this.adaptor.addChild(root_0, lvalue261.getTree());
                while (true) {
                    int alt83 = 2;
                    final int LA83_0 = this.input.LA(1);
                    if (LA83_0 == 11) {
                        alt83 = 1;
                    }
                    switch (alt83) {
                        case 1: {
                            COMMA262 = (Token)this.match((IntStream)this.input, 11, PLSQL2Parser.FOLLOW_COMMA_in_into_clause2668);
                            COMMA262_tree = this.adaptor.create(COMMA262);
                            this.adaptor.addChild(root_0, COMMA262_tree);
                            this.pushFollow(PLSQL2Parser.FOLLOW_lvalue_in_into_clause2670);
                            lvalue262 = this.lvalue();
                            final RecognizerSharedState state2 = this.state;
                            --state2._fsp;
                            this.adaptor.addChild(root_0, lvalue262.getTree());
                            continue;
                        }
                        default: {
                            retval.stop = this.input.LT(-1);
                            retval.tree = this.adaptor.rulePostProcessing(root_0);
                            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                            break Label_0370;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final bulk_collect_into_clause_return bulk_collect_into_clause() throws RecognitionException {
        final bulk_collect_into_clause_return retval = new bulk_collect_into_clause_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token BULK264 = null;
        Token COLLECT265 = null;
        Token INTO266 = null;
        Token COMMA268 = null;
        lvalue_return lvalue267 = null;
        lvalue_return lvalue268 = null;
        Object BULK264_tree = null;
        Object COLLECT265_tree = null;
        Object INTO266_tree = null;
        Object COMMA268_tree = null;
        Label_0466: {
            try {
                root_0 = this.adaptor.nil();
                BULK264 = (Token)this.match((IntStream)this.input, 61, PLSQL2Parser.FOLLOW_BULK_in_bulk_collect_into_clause2698);
                BULK264_tree = this.adaptor.create(BULK264);
                this.adaptor.addChild(root_0, BULK264_tree);
                COLLECT265 = (Token)this.match((IntStream)this.input, 62, PLSQL2Parser.FOLLOW_COLLECT_in_bulk_collect_into_clause2700);
                COLLECT265_tree = this.adaptor.create(COLLECT265);
                this.adaptor.addChild(root_0, COLLECT265_tree);
                INTO266 = (Token)this.match((IntStream)this.input, 60, PLSQL2Parser.FOLLOW_INTO_in_bulk_collect_into_clause2702);
                INTO266_tree = this.adaptor.create(INTO266);
                this.adaptor.addChild(root_0, INTO266_tree);
                this.pushFollow(PLSQL2Parser.FOLLOW_lvalue_in_bulk_collect_into_clause2704);
                lvalue267 = this.lvalue();
                final RecognizerSharedState state = this.state;
                --state._fsp;
                this.adaptor.addChild(root_0, lvalue267.getTree());
                while (true) {
                    int alt84 = 2;
                    final int LA84_0 = this.input.LA(1);
                    if (LA84_0 == 11) {
                        alt84 = 1;
                    }
                    switch (alt84) {
                        case 1: {
                            COMMA268 = (Token)this.match((IntStream)this.input, 11, PLSQL2Parser.FOLLOW_COMMA_in_bulk_collect_into_clause2708);
                            COMMA268_tree = this.adaptor.create(COMMA268);
                            this.adaptor.addChild(root_0, COMMA268_tree);
                            this.pushFollow(PLSQL2Parser.FOLLOW_lvalue_in_bulk_collect_into_clause2710);
                            lvalue268 = this.lvalue();
                            final RecognizerSharedState state2 = this.state;
                            --state2._fsp;
                            this.adaptor.addChild(root_0, lvalue268.getTree());
                            continue;
                        }
                        default: {
                            retval.stop = this.input.LT(-1);
                            retval.tree = this.adaptor.rulePostProcessing(root_0);
                            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                            break Label_0466;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final using_clause_return using_clause() throws RecognitionException {
        final using_clause_return retval = new using_clause_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token USING270 = null;
        Token COMMA273 = null;
        param_modifiers_return param_modifiers271 = null;
        expression_return expression272 = null;
        param_modifiers_return param_modifiers272 = null;
        expression_return expression273 = null;
        Object USING270_tree = null;
        Object COMMA273_tree = null;
        Label_0564: {
            try {
                root_0 = this.adaptor.nil();
                USING270 = (Token)this.match((IntStream)this.input, 63, PLSQL2Parser.FOLLOW_USING_in_using_clause2734);
                USING270_tree = this.adaptor.create(USING270);
                this.adaptor.addChild(root_0, USING270_tree);
                int alt85 = 2;
                final int LA85_0 = this.input.LA(1);
                if (LA85_0 >= 15 && LA85_0 <= 16) {
                    alt85 = 1;
                }
                switch (alt85) {
                    case 1: {
                        this.pushFollow(PLSQL2Parser.FOLLOW_param_modifiers_in_using_clause2736);
                        param_modifiers271 = this.param_modifiers();
                        final RecognizerSharedState state = this.state;
                        --state._fsp;
                        this.adaptor.addChild(root_0, param_modifiers271.getTree());
                        break;
                    }
                }
                this.pushFollow(PLSQL2Parser.FOLLOW_expression_in_using_clause2739);
                expression272 = this.expression();
                final RecognizerSharedState state2 = this.state;
                --state2._fsp;
                this.adaptor.addChild(root_0, expression272.getTree());
                while (true) {
                    int alt86 = 2;
                    final int LA87_0 = this.input.LA(1);
                    if (LA87_0 == 11) {
                        alt86 = 1;
                    }
                    switch (alt86) {
                        case 1: {
                            COMMA273 = (Token)this.match((IntStream)this.input, 11, PLSQL2Parser.FOLLOW_COMMA_in_using_clause2743);
                            COMMA273_tree = this.adaptor.create(COMMA273);
                            this.adaptor.addChild(root_0, COMMA273_tree);
                            int alt87 = 2;
                            final int LA86_0 = this.input.LA(1);
                            if (LA86_0 >= 15 && LA86_0 <= 16) {
                                alt87 = 1;
                            }
                            switch (alt87) {
                                case 1: {
                                    this.pushFollow(PLSQL2Parser.FOLLOW_param_modifiers_in_using_clause2745);
                                    param_modifiers272 = this.param_modifiers();
                                    final RecognizerSharedState state3 = this.state;
                                    --state3._fsp;
                                    this.adaptor.addChild(root_0, param_modifiers272.getTree());
                                    break;
                                }
                            }
                            this.pushFollow(PLSQL2Parser.FOLLOW_expression_in_using_clause2748);
                            expression273 = this.expression();
                            final RecognizerSharedState state4 = this.state;
                            --state4._fsp;
                            this.adaptor.addChild(root_0, expression273.getTree());
                            continue;
                        }
                        default: {
                            retval.stop = this.input.LT(-1);
                            retval.tree = this.adaptor.rulePostProcessing(root_0);
                            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                            break Label_0564;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final param_modifiers_return param_modifiers() throws RecognitionException {
        final param_modifiers_return retval = new param_modifiers_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token IN276 = null;
        Token OUT277 = null;
        Token OUT278 = null;
        Object IN276_tree = null;
        Object OUT277_tree = null;
        Object OUT278_tree = null;
        try {
            int alt89 = 2;
            final int LA89_0 = this.input.LA(1);
            if (LA89_0 == 15) {
                alt89 = 1;
            }
            else {
                if (LA89_0 != 16) {
                    final NoViableAltException nvae = new NoViableAltException("", 89, 0, (IntStream)this.input);
                    throw nvae;
                }
                alt89 = 2;
            }
            switch (alt89) {
                case 1: {
                    root_0 = this.adaptor.nil();
                    IN276 = (Token)this.match((IntStream)this.input, 15, PLSQL2Parser.FOLLOW_IN_in_param_modifiers2765);
                    IN276_tree = this.adaptor.create(IN276);
                    this.adaptor.addChild(root_0, IN276_tree);
                    int alt90 = 2;
                    final int LA88_0 = this.input.LA(1);
                    if (LA88_0 == 16) {
                        alt90 = 1;
                    }
                    switch (alt90) {
                        case 1: {
                            OUT277 = (Token)this.match((IntStream)this.input, 16, PLSQL2Parser.FOLLOW_OUT_in_param_modifiers2767);
                            OUT277_tree = this.adaptor.create(OUT277);
                            this.adaptor.addChild(root_0, OUT277_tree);
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    root_0 = this.adaptor.nil();
                    OUT278 = (Token)this.match((IntStream)this.input, 16, PLSQL2Parser.FOLLOW_OUT_in_param_modifiers2772);
                    OUT278_tree = this.adaptor.create(OUT278);
                    this.adaptor.addChild(root_0, OUT278_tree);
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final dynamic_returning_clause_return dynamic_returning_clause() throws RecognitionException {
        final dynamic_returning_clause_return retval = new dynamic_returning_clause_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token set279 = null;
        into_clause_return into_clause280 = null;
        bulk_collect_into_clause_return bulk_collect_into_clause281 = null;
        final Object set279_tree = null;
        try {
            root_0 = this.adaptor.nil();
            set279 = this.input.LT(1);
            if (this.input.LA(1) != 9 && this.input.LA(1) != 64) {
                final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                throw mse;
            }
            this.input.consume();
            this.adaptor.addChild(root_0, this.adaptor.create(set279));
            this.state.errorRecovery = false;
            int alt90 = 2;
            final int LA90_0 = this.input.LA(1);
            if (LA90_0 == 60) {
                alt90 = 1;
            }
            else {
                if (LA90_0 != 61) {
                    final NoViableAltException nvae = new NoViableAltException("", 90, 0, (IntStream)this.input);
                    throw nvae;
                }
                alt90 = 2;
            }
            switch (alt90) {
                case 1: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_into_clause_in_dynamic_returning_clause2802);
                    into_clause280 = this.into_clause();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    this.adaptor.addChild(root_0, into_clause280.getTree());
                    break;
                }
                case 2: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_bulk_collect_into_clause_in_dynamic_returning_clause2806);
                    bulk_collect_into_clause281 = this.bulk_collect_into_clause();
                    final RecognizerSharedState state2 = this.state;
                    --state2._fsp;
                    this.adaptor.addChild(root_0, bulk_collect_into_clause281.getTree());
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final for_loop_statement_return for_loop_statement() throws RecognitionException {
        final for_loop_statement_return retval = new for_loop_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token FOR282 = null;
        Token ID283 = null;
        Token IN284 = null;
        Token set285 = null;
        Token LOOP286 = null;
        Token SEMI288 = null;
        Token END289 = null;
        Token LOOP287 = null;
        statement_return statement287 = null;
        label_name_return label_name291 = null;
        Object FOR282_tree = null;
        Object ID283_tree = null;
        Object IN284_tree = null;
        final Object set285_tree = null;
        Object LOOP286_tree = null;
        Object SEMI288_tree = null;
        Object END289_tree = null;
        Object LOOP290_tree = null;
        Label_1076: {
            try {
                root_0 = this.adaptor.nil();
                FOR282 = (Token)this.match((IntStream)this.input, 65, PLSQL2Parser.FOLLOW_FOR_in_for_loop_statement2829);
                FOR282_tree = this.adaptor.create(FOR282);
                this.adaptor.addChild(root_0, FOR282_tree);
                ID283 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_for_loop_statement2831);
                ID283_tree = this.adaptor.create(ID283);
                this.adaptor.addChild(root_0, ID283_tree);
                IN284 = (Token)this.match((IntStream)this.input, 15, PLSQL2Parser.FOLLOW_IN_in_for_loop_statement2833);
                IN284_tree = this.adaptor.create(IN284);
                this.adaptor.addChild(root_0, IN284_tree);
                int cnt91 = 0;
                while (true) {
                    int alt91 = 2;
                    final int LA91_0 = this.input.LA(1);
                    if ((LA91_0 >= 4 && LA91_0 <= 49) || (LA91_0 >= 51 && LA91_0 <= 133)) {
                        alt91 = 1;
                    }
                    switch (alt91) {
                        case 1: {
                            set285 = this.input.LT(1);
                            if ((this.input.LA(1) >= 4 && this.input.LA(1) <= 49) || (this.input.LA(1) >= 51 && this.input.LA(1) <= 133)) {
                                this.input.consume();
                                this.adaptor.addChild(root_0, this.adaptor.create(set285));
                                this.state.errorRecovery = false;
                                ++cnt91;
                                continue;
                            }
                            final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                            throw mse;
                        }
                        default: {
                            if (cnt91 < 1) {
                                final EarlyExitException eee = new EarlyExitException(91, (IntStream)this.input);
                                throw eee;
                            }
                            LOOP286 = (Token)this.match((IntStream)this.input, 50, PLSQL2Parser.FOLLOW_LOOP_in_for_loop_statement2845);
                            LOOP286_tree = this.adaptor.create(LOOP286);
                            this.adaptor.addChild(root_0, LOOP286_tree);
                            int cnt92 = 0;
                            while (true) {
                                int alt92 = 2;
                                final int LA92_0 = this.input.LA(1);
                                if (LA92_0 == 7 || LA92_0 == 9 || LA92_0 == 21 || LA92_0 == 42 || (LA92_0 >= 48 && LA92_0 <= 51) || (LA92_0 >= 53 && LA92_0 <= 55) || (LA92_0 >= 57 && LA92_0 <= 58) || (LA92_0 >= 65 && LA92_0 <= 66) || (LA92_0 >= 70 && LA92_0 <= 71) || LA92_0 == 73 || (LA92_0 >= 75 && LA92_0 <= 77) || (LA92_0 >= 79 && LA92_0 <= 85) || (LA92_0 >= 87 && LA92_0 <= 88)) {
                                    alt92 = 1;
                                }
                                switch (alt92) {
                                    case 1: {
                                        this.pushFollow(PLSQL2Parser.FOLLOW_statement_in_for_loop_statement2849);
                                        statement287 = this.statement();
                                        final RecognizerSharedState state = this.state;
                                        --state._fsp;
                                        this.adaptor.addChild(root_0, statement287.getTree());
                                        SEMI288 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_for_loop_statement2851);
                                        SEMI288_tree = this.adaptor.create(SEMI288);
                                        this.adaptor.addChild(root_0, SEMI288_tree);
                                        ++cnt92;
                                        continue;
                                    }
                                    default: {
                                        if (cnt92 >= 1) {
                                            END289 = (Token)this.match((IntStream)this.input, 43, PLSQL2Parser.FOLLOW_END_in_for_loop_statement2856);
                                            END289_tree = this.adaptor.create(END289);
                                            this.adaptor.addChild(root_0, END289_tree);
                                            LOOP287 = (Token)this.match((IntStream)this.input, 50, PLSQL2Parser.FOLLOW_LOOP_in_for_loop_statement2858);
                                            LOOP290_tree = this.adaptor.create(LOOP287);
                                            this.adaptor.addChild(root_0, LOOP290_tree);
                                            int alt93 = 2;
                                            final int LA93_0 = this.input.LA(1);
                                            if (LA93_0 == 7) {
                                                alt93 = 1;
                                            }
                                            switch (alt93) {
                                                case 1: {
                                                    this.pushFollow(PLSQL2Parser.FOLLOW_label_name_in_for_loop_statement2860);
                                                    label_name291 = this.label_name();
                                                    final RecognizerSharedState state2 = this.state;
                                                    --state2._fsp;
                                                    this.adaptor.addChild(root_0, label_name291.getTree());
                                                    break;
                                                }
                                            }
                                            retval.stop = this.input.LT(-1);
                                            retval.tree = this.adaptor.rulePostProcessing(root_0);
                                            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                                            break Label_1076;
                                        }
                                        final EarlyExitException eee2 = new EarlyExitException(92, (IntStream)this.input);
                                        throw eee2;
                                    }
                                }
                            }
                            /*break;*/
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final forall_statement_return forall_statement() throws RecognitionException {
        final forall_statement_return retval = new forall_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token FORALL292 = null;
        Token ID293 = null;
        Token IN294 = null;
        bounds_clause_return bounds_clause295 = null;
        sql_statement_return sql_statement296 = null;
        kSAVE_return kSAVE297 = null;
        kEXCEPTIONS_return kEXCEPTIONS298 = null;
        Object FORALL292_tree = null;
        Object ID293_tree = null;
        Object IN294_tree = null;
        try {
            root_0 = this.adaptor.nil();
            FORALL292 = (Token)this.match((IntStream)this.input, 66, PLSQL2Parser.FOLLOW_FORALL_in_forall_statement2882);
            FORALL292_tree = this.adaptor.create(FORALL292);
            this.adaptor.addChild(root_0, FORALL292_tree);
            ID293 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_forall_statement2884);
            ID293_tree = this.adaptor.create(ID293);
            this.adaptor.addChild(root_0, ID293_tree);
            IN294 = (Token)this.match((IntStream)this.input, 15, PLSQL2Parser.FOLLOW_IN_in_forall_statement2886);
            IN294_tree = this.adaptor.create(IN294);
            this.adaptor.addChild(root_0, IN294_tree);
            this.pushFollow(PLSQL2Parser.FOLLOW_bounds_clause_in_forall_statement2888);
            bounds_clause295 = this.bounds_clause();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, bounds_clause295.getTree());
            this.pushFollow(PLSQL2Parser.FOLLOW_sql_statement_in_forall_statement2890);
            sql_statement296 = this.sql_statement();
            final RecognizerSharedState state2 = this.state;
            --state2._fsp;
            this.adaptor.addChild(root_0, sql_statement296.getTree());
            int alt94 = 2;
            final int LA94_0 = this.input.LA(1);
            if (LA94_0 == 7) {
                alt94 = 1;
            }
            switch (alt94) {
                case 1: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_kSAVE_in_forall_statement2894);
                    kSAVE297 = this.kSAVE();
                    final RecognizerSharedState state3 = this.state;
                    --state3._fsp;
                    this.adaptor.addChild(root_0, kSAVE297.getTree());
                    this.pushFollow(PLSQL2Parser.FOLLOW_kEXCEPTIONS_in_forall_statement2896);
                    kEXCEPTIONS298 = this.kEXCEPTIONS();
                    final RecognizerSharedState state4 = this.state;
                    --state4._fsp;
                    this.adaptor.addChild(root_0, kEXCEPTIONS298.getTree());
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final bounds_clause_return bounds_clause() throws RecognitionException {
        final bounds_clause_return retval = new bounds_clause_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token DOUBLEDOT300 = null;
        Token BETWEEN305 = null;
        Token AND307 = null;
        numeric_expression_return numeric_expression299 = null;
        numeric_expression_return numeric_expression300 = null;
        kINDICES_return kINDICES302 = null;
        kOF_return kOF303 = null;
        atom_return atom304 = null;
        numeric_expression_return numeric_expression301 = null;
        numeric_expression_return numeric_expression302 = null;
        kVALUES_return kVALUES309 = null;
        kOF_return kOF304 = null;
        atom_return atom305 = null;
        Object DOUBLEDOT300_tree = null;
        Object BETWEEN305_tree = null;
        Object AND307_tree = null;
        try {
            int alt96 = 3;
            alt96 = this.dfa96.predict((IntStream)this.input);
            switch (alt96) {
                case 1: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_numeric_expression_in_bounds_clause2918);
                    numeric_expression299 = this.numeric_expression();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    this.adaptor.addChild(root_0, numeric_expression299.getTree());
                    DOUBLEDOT300 = (Token)this.match((IntStream)this.input, 67, PLSQL2Parser.FOLLOW_DOUBLEDOT_in_bounds_clause2920);
                    DOUBLEDOT300_tree = this.adaptor.create(DOUBLEDOT300);
                    this.adaptor.addChild(root_0, DOUBLEDOT300_tree);
                    this.pushFollow(PLSQL2Parser.FOLLOW_numeric_expression_in_bounds_clause2922);
                    numeric_expression300 = this.numeric_expression();
                    final RecognizerSharedState state2 = this.state;
                    --state2._fsp;
                    this.adaptor.addChild(root_0, numeric_expression300.getTree());
                    break;
                }
                case 2: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_kINDICES_in_bounds_clause2930);
                    kINDICES302 = this.kINDICES();
                    final RecognizerSharedState state3 = this.state;
                    --state3._fsp;
                    this.adaptor.addChild(root_0, kINDICES302.getTree());
                    this.pushFollow(PLSQL2Parser.FOLLOW_kOF_in_bounds_clause2932);
                    kOF303 = this.kOF();
                    final RecognizerSharedState state4 = this.state;
                    --state4._fsp;
                    this.adaptor.addChild(root_0, kOF303.getTree());
                    this.pushFollow(PLSQL2Parser.FOLLOW_atom_in_bounds_clause2934);
                    atom304 = this.atom();
                    final RecognizerSharedState state5 = this.state;
                    --state5._fsp;
                    this.adaptor.addChild(root_0, atom304.getTree());
                    int alt97 = 2;
                    final int LA95_0 = this.input.LA(1);
                    if (LA95_0 == 68) {
                        alt97 = 1;
                    }
                    switch (alt97) {
                        case 1: {
                            BETWEEN305 = (Token)this.match((IntStream)this.input, 68, PLSQL2Parser.FOLLOW_BETWEEN_in_bounds_clause2938);
                            BETWEEN305_tree = this.adaptor.create(BETWEEN305);
                            this.adaptor.addChild(root_0, BETWEEN305_tree);
                            this.pushFollow(PLSQL2Parser.FOLLOW_numeric_expression_in_bounds_clause2940);
                            numeric_expression301 = this.numeric_expression();
                            final RecognizerSharedState state6 = this.state;
                            --state6._fsp;
                            this.adaptor.addChild(root_0, numeric_expression301.getTree());
                            AND307 = (Token)this.match((IntStream)this.input, 69, PLSQL2Parser.FOLLOW_AND_in_bounds_clause2942);
                            AND307_tree = this.adaptor.create(AND307);
                            this.adaptor.addChild(root_0, AND307_tree);
                            this.pushFollow(PLSQL2Parser.FOLLOW_numeric_expression_in_bounds_clause2944);
                            numeric_expression302 = this.numeric_expression();
                            final RecognizerSharedState state7 = this.state;
                            --state7._fsp;
                            this.adaptor.addChild(root_0, numeric_expression302.getTree());
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_kVALUES_in_bounds_clause2955);
                    kVALUES309 = this.kVALUES();
                    final RecognizerSharedState state8 = this.state;
                    --state8._fsp;
                    this.adaptor.addChild(root_0, kVALUES309.getTree());
                    this.pushFollow(PLSQL2Parser.FOLLOW_kOF_in_bounds_clause2957);
                    kOF304 = this.kOF();
                    final RecognizerSharedState state9 = this.state;
                    --state9._fsp;
                    this.adaptor.addChild(root_0, kOF304.getTree());
                    this.pushFollow(PLSQL2Parser.FOLLOW_atom_in_bounds_clause2959);
                    atom305 = this.atom();
                    final RecognizerSharedState state10 = this.state;
                    --state10._fsp;
                    this.adaptor.addChild(root_0, atom305.getTree());
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final goto_statement_return goto_statement() throws RecognitionException {
        final goto_statement_return retval = new goto_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token GOTO312 = null;
        label_name_return label_name313 = null;
        Object GOTO312_tree = null;
        try {
            root_0 = this.adaptor.nil();
            GOTO312 = (Token)this.match((IntStream)this.input, 70, PLSQL2Parser.FOLLOW_GOTO_in_goto_statement2980);
            GOTO312_tree = this.adaptor.create(GOTO312);
            this.adaptor.addChild(root_0, GOTO312_tree);
            this.pushFollow(PLSQL2Parser.FOLLOW_label_name_in_goto_statement2982);
            label_name313 = this.label_name();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, label_name313.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final if_statement_return if_statement() throws RecognitionException {
        final if_statement_return retval = new if_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token IF314 = null;
        Token THEN316 = null;
        Token SEMI318 = null;
        Token ELSIF319 = null;
        Token THEN317 = null;
        Token SEMI319 = null;
        Token ELSE324 = null;
        Token SEMI320 = null;
        Token END327 = null;
        Token IF315 = null;
        expression_return expression315 = null;
        statement_return statement317 = null;
        expression_return expression316 = null;
        statement_return statement318 = null;
        statement_return statement319 = null;
        Object IF314_tree = null;
        Object THEN316_tree = null;
        Object SEMI318_tree = null;
        Object ELSIF319_tree = null;
        Object THEN321_tree = null;
        Object SEMI323_tree = null;
        Object ELSE324_tree = null;
        Object SEMI326_tree = null;
        Object END327_tree = null;
        Object IF328_tree = null;
        Label_1604: {
            try {
                root_0 = this.adaptor.nil();
                IF314 = (Token)this.match((IntStream)this.input, 71, PLSQL2Parser.FOLLOW_IF_in_if_statement3003);
                IF314_tree = this.adaptor.create(IF314);
                this.adaptor.addChild(root_0, IF314_tree);
                this.pushFollow(PLSQL2Parser.FOLLOW_expression_in_if_statement3005);
                expression315 = this.expression();
                final RecognizerSharedState state = this.state;
                --state._fsp;
                this.adaptor.addChild(root_0, expression315.getTree());
                THEN316 = (Token)this.match((IntStream)this.input, 47, PLSQL2Parser.FOLLOW_THEN_in_if_statement3007);
                THEN316_tree = this.adaptor.create(THEN316);
                this.adaptor.addChild(root_0, THEN316_tree);
                int cnt97 = 0;
            Label_0539_Outer:
                while (true) {
                    int alt97 = 2;
                    final int LA97_0 = this.input.LA(1);
                    if (LA97_0 == 7 || LA97_0 == 9 || LA97_0 == 21 || LA97_0 == 42 || (LA97_0 >= 48 && LA97_0 <= 51) || (LA97_0 >= 53 && LA97_0 <= 55) || (LA97_0 >= 57 && LA97_0 <= 58) || (LA97_0 >= 65 && LA97_0 <= 66) || (LA97_0 >= 70 && LA97_0 <= 71) || LA97_0 == 73 || (LA97_0 >= 75 && LA97_0 <= 77) || (LA97_0 >= 79 && LA97_0 <= 85) || (LA97_0 >= 87 && LA97_0 <= 88)) {
                        alt97 = 1;
                    }
                    switch (alt97) {
                        case 1: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_statement_in_if_statement3011);
                            statement317 = this.statement();
                            final RecognizerSharedState state2 = this.state;
                            --state2._fsp;
                            this.adaptor.addChild(root_0, statement317.getTree());
                            SEMI318 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_if_statement3013);
                            SEMI318_tree = this.adaptor.create(SEMI318);
                            this.adaptor.addChild(root_0, SEMI318_tree);
                            ++cnt97;
                            continue;
                        }
                        default: {
                            if (cnt97 < 1) {
                                final EarlyExitException eee = new EarlyExitException(97, (IntStream)this.input);
                                throw eee;
                            }
                        Label_0539:
                            while (true) {
                                while (true) {
                                    int alt98 = 2;
                                    final int LA99_0 = this.input.LA(1);
                                    if (LA99_0 == 72) {
                                        alt98 = 1;
                                    }
                                    switch (alt98) {
                                        case 1: {
                                            ELSIF319 = (Token)this.match((IntStream)this.input, 72, PLSQL2Parser.FOLLOW_ELSIF_in_if_statement3028);
                                            ELSIF319_tree = this.adaptor.create(ELSIF319);
                                            this.adaptor.addChild(root_0, ELSIF319_tree);
                                            this.pushFollow(PLSQL2Parser.FOLLOW_expression_in_if_statement3030);
                                            expression316 = this.expression();
                                            final RecognizerSharedState state3 = this.state;
                                            --state3._fsp;
                                            this.adaptor.addChild(root_0, expression316.getTree());
                                            THEN317 = (Token)this.match((IntStream)this.input, 47, PLSQL2Parser.FOLLOW_THEN_in_if_statement3032);
                                            THEN321_tree = this.adaptor.create(THEN317);
                                            this.adaptor.addChild(root_0, THEN321_tree);
                                            int cnt98 = 0;
                                            while (true) {
                                                int alt99 = 2;
                                                final int LA98_0 = this.input.LA(1);
                                                if (LA98_0 == 7 || LA98_0 == 9 || LA98_0 == 21 || LA98_0 == 42 || (LA98_0 >= 48 && LA98_0 <= 51) || (LA98_0 >= 53 && LA98_0 <= 55) || (LA98_0 >= 57 && LA98_0 <= 58) || (LA98_0 >= 65 && LA98_0 <= 66) || (LA98_0 >= 70 && LA98_0 <= 71) || LA98_0 == 73 || (LA98_0 >= 75 && LA98_0 <= 77) || (LA98_0 >= 79 && LA98_0 <= 85) || (LA98_0 >= 87 && LA98_0 <= 88)) {
                                                    alt99 = 1;
                                                }
                                                switch (alt99) {
                                                    case 1: {
                                                        this.pushFollow(PLSQL2Parser.FOLLOW_statement_in_if_statement3036);
                                                        statement318 = this.statement();
                                                        final RecognizerSharedState state4 = this.state;
                                                        --state4._fsp;
                                                        this.adaptor.addChild(root_0, statement318.getTree());
                                                        SEMI319 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_if_statement3038);
                                                        SEMI323_tree = this.adaptor.create(SEMI319);
                                                        this.adaptor.addChild(root_0, SEMI323_tree);
                                                        ++cnt98;
                                                        continue Label_0539_Outer;
                                                    }
                                                    default: {
                                                        if (cnt98 >= 1) {
                                                            continue Label_0539;
                                                        }
                                                        final EarlyExitException eee2 = new EarlyExitException(98, (IntStream)this.input);
                                                        throw eee2;
                                                    }
                                                }
                                            }
                                            /*break;*/
                                        }
                                        default: {
                                            int alt100 = 2;
                                            final int LA101_0 = this.input.LA(1);
                                            if (LA101_0 == 52) {
                                                alt100 = 1;
                                            }
                                            Label_1415: {
                                                switch (alt100) {
                                                    case 1: {
                                                        ELSE324 = (Token)this.match((IntStream)this.input, 52, PLSQL2Parser.FOLLOW_ELSE_in_if_statement3056);
                                                        ELSE324_tree = this.adaptor.create(ELSE324);
                                                        this.adaptor.addChild(root_0, ELSE324_tree);
                                                        int cnt99 = 0;
                                                        while (true) {
                                                            int alt101 = 2;
                                                            final int LA100_0 = this.input.LA(1);
                                                            if (LA100_0 == 7 || LA100_0 == 9 || LA100_0 == 21 || LA100_0 == 42 || (LA100_0 >= 48 && LA100_0 <= 51) || (LA100_0 >= 53 && LA100_0 <= 55) || (LA100_0 >= 57 && LA100_0 <= 58) || (LA100_0 >= 65 && LA100_0 <= 66) || (LA100_0 >= 70 && LA100_0 <= 71) || LA100_0 == 73 || (LA100_0 >= 75 && LA100_0 <= 77) || (LA100_0 >= 79 && LA100_0 <= 85) || (LA100_0 >= 87 && LA100_0 <= 88)) {
                                                                alt101 = 1;
                                                            }
                                                            switch (alt101) {
                                                                case 1: {
                                                                    this.pushFollow(PLSQL2Parser.FOLLOW_statement_in_if_statement3060);
                                                                    statement319 = this.statement();
                                                                    final RecognizerSharedState state5 = this.state;
                                                                    --state5._fsp;
                                                                    this.adaptor.addChild(root_0, statement319.getTree());
                                                                    SEMI320 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_if_statement3062);
                                                                    SEMI326_tree = this.adaptor.create(SEMI320);
                                                                    this.adaptor.addChild(root_0, SEMI326_tree);
                                                                    ++cnt99;
                                                                    continue Label_0539_Outer;
                                                                }
                                                                default: {
                                                                    if (cnt99 >= 1) {
                                                                        break Label_1415;
                                                                    }
                                                                    final EarlyExitException eee2 = new EarlyExitException(100, (IntStream)this.input);
                                                                    throw eee2;
                                                                }
                                                            }
                                                        }
                                                        /*break;*/
                                                    }
                                                }
                                            }
                                            END327 = (Token)this.match((IntStream)this.input, 43, PLSQL2Parser.FOLLOW_END_in_if_statement3078);
                                            END327_tree = this.adaptor.create(END327);
                                            this.adaptor.addChild(root_0, END327_tree);
                                            IF315 = (Token)this.match((IntStream)this.input, 71, PLSQL2Parser.FOLLOW_IF_in_if_statement3080);
                                            IF328_tree = this.adaptor.create(IF315);
                                            this.adaptor.addChild(root_0, IF328_tree);
                                            retval.stop = this.input.LT(-1);
                                            retval.tree = this.adaptor.rulePostProcessing(root_0);
                                            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                                            break Label_1604;
                                        }
                                    }
                                }
                                /*break;*/
                            }
                            /*break;*/
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final null_statement_return null_statement() throws RecognitionException {
        final null_statement_return retval = new null_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token NULL329 = null;
        Object NULL329_tree = null;
        try {
            root_0 = this.adaptor.nil();
            NULL329 = (Token)this.match((IntStream)this.input, 21, PLSQL2Parser.FOLLOW_NULL_in_null_statement3101);
            NULL329_tree = this.adaptor.create(NULL329);
            this.adaptor.addChild(root_0, NULL329_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final open_statement_return open_statement() throws RecognitionException {
        final open_statement_return retval = new open_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token OPEN330 = null;
        Token ID331 = null;
        Token DOT332 = null;
        Token ID332 = null;
        Token FOR335 = null;
        call_args_return call_args334 = null;
        select_statement_return select_statement336 = null;
        Object OPEN330_tree = null;
        Object ID331_tree = null;
        Object DOT332_tree = null;
        Object ID333_tree = null;
        Object FOR335_tree = null;
        Label_0611: {
            try {
                root_0 = this.adaptor.nil();
                OPEN330 = (Token)this.match((IntStream)this.input, 73, PLSQL2Parser.FOLLOW_OPEN_in_open_statement3122);
                OPEN330_tree = this.adaptor.create(OPEN330);
                this.adaptor.addChild(root_0, OPEN330_tree);
                ID331 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_open_statement3124);
                ID331_tree = this.adaptor.create(ID331);
                this.adaptor.addChild(root_0, ID331_tree);
                while (true) {
                    int alt102 = 2;
                    final int LA102_0 = this.input.LA(1);
                    if (LA102_0 == 35) {
                        alt102 = 1;
                    }
                    switch (alt102) {
                        case 1: {
                            DOT332 = (Token)this.match((IntStream)this.input, 35, PLSQL2Parser.FOLLOW_DOT_in_open_statement3128);
                            DOT332_tree = this.adaptor.create(DOT332);
                            this.adaptor.addChild(root_0, DOT332_tree);
                            ID332 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_open_statement3130);
                            ID333_tree = this.adaptor.create(ID332);
                            this.adaptor.addChild(root_0, ID333_tree);
                            continue;
                        }
                        default: {
                            int alt103 = 2;
                            final int LA103_0 = this.input.LA(1);
                            if (LA103_0 == 10) {
                                alt103 = 1;
                            }
                            switch (alt103) {
                                case 1: {
                                    this.pushFollow(PLSQL2Parser.FOLLOW_call_args_in_open_statement3135);
                                    call_args334 = this.call_args();
                                    final RecognizerSharedState state = this.state;
                                    --state._fsp;
                                    this.adaptor.addChild(root_0, call_args334.getTree());
                                    break;
                                }
                            }
                            int alt104 = 2;
                            final int LA104_0 = this.input.LA(1);
                            if (LA104_0 == 65) {
                                alt104 = 1;
                            }
                            switch (alt104) {
                                case 1: {
                                    FOR335 = (Token)this.match((IntStream)this.input, 65, PLSQL2Parser.FOLLOW_FOR_in_open_statement3140);
                                    FOR335_tree = this.adaptor.create(FOR335);
                                    this.adaptor.addChild(root_0, FOR335_tree);
                                    this.pushFollow(PLSQL2Parser.FOLLOW_select_statement_in_open_statement3142);
                                    select_statement336 = this.select_statement();
                                    final RecognizerSharedState state2 = this.state;
                                    --state2._fsp;
                                    this.adaptor.addChild(root_0, select_statement336.getTree());
                                    break;
                                }
                            }
                            retval.stop = this.input.LT(-1);
                            retval.tree = this.adaptor.rulePostProcessing(root_0);
                            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                            break Label_0611;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final pragma_return pragma() throws RecognitionException {
        final pragma_return retval = new pragma_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token PRAGMA337 = null;
        swallow_to_semi_return swallow_to_semi338 = null;
        Object PRAGMA337_tree = null;
        try {
            root_0 = this.adaptor.nil();
            PRAGMA337 = (Token)this.match((IntStream)this.input, 74, PLSQL2Parser.FOLLOW_PRAGMA_in_pragma3166);
            PRAGMA337_tree = this.adaptor.create(PRAGMA337);
            this.adaptor.addChild(root_0, PRAGMA337_tree);
            this.pushFollow(PLSQL2Parser.FOLLOW_swallow_to_semi_in_pragma3168);
            swallow_to_semi338 = this.swallow_to_semi();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, swallow_to_semi338.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final raise_statement_return raise_statement() throws RecognitionException {
        final raise_statement_return retval = new raise_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token RAISE339 = null;
        Token ID340 = null;
        Token DOT341 = null;
        Token ID341 = null;
        Object RAISE339_tree = null;
        Object ID340_tree = null;
        Object DOT341_tree = null;
        Object ID342_tree = null;
        try {
            root_0 = this.adaptor.nil();
            RAISE339 = (Token)this.match((IntStream)this.input, 75, PLSQL2Parser.FOLLOW_RAISE_in_raise_statement3189);
            RAISE339_tree = this.adaptor.create(RAISE339);
            this.adaptor.addChild(root_0, RAISE339_tree);
            int alt106 = 2;
            final int LA106_0 = this.input.LA(1);
            if (LA106_0 == 7) {
                alt106 = 1;
            }
            Label_0321: {
                switch (alt106) {
                    case 1: {
                        ID340 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_raise_statement3193);
                        ID340_tree = this.adaptor.create(ID340);
                        this.adaptor.addChild(root_0, ID340_tree);
                        while (true) {
                            int alt107 = 2;
                            final int LA105_0 = this.input.LA(1);
                            if (LA105_0 == 35) {
                                alt107 = 1;
                            }
                            switch (alt107) {
                                case 1: {
                                    DOT341 = (Token)this.match((IntStream)this.input, 35, PLSQL2Parser.FOLLOW_DOT_in_raise_statement3197);
                                    DOT341_tree = this.adaptor.create(DOT341);
                                    this.adaptor.addChild(root_0, DOT341_tree);
                                    ID341 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_raise_statement3199);
                                    ID342_tree = this.adaptor.create(ID341);
                                    this.adaptor.addChild(root_0, ID342_tree);
                                    continue;
                                }
                                default: {
                                    break Label_0321;
                                }
                            }
                        }
                        /*break;*/
                    }
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final return_statement_return return_statement() throws RecognitionException {
        final return_statement_return retval = new return_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token RETURN343 = null;
        expression_return expression344 = null;
        Object RETURN343_tree = null;
        try {
            root_0 = this.adaptor.nil();
            RETURN343 = (Token)this.match((IntStream)this.input, 9, PLSQL2Parser.FOLLOW_RETURN_in_return_statement3226);
            RETURN343_tree = this.adaptor.create(RETURN343);
            this.adaptor.addChild(root_0, RETURN343_tree);
            int alt107 = 2;
            final int LA107_0 = this.input.LA(1);
            if (LA107_0 == 7 || LA107_0 == 10 || (LA107_0 >= 20 && LA107_0 <= 21) || LA107_0 == 48 || (LA107_0 >= 96 && LA107_0 <= 97) || LA107_0 == 101 || (LA107_0 >= 105 && LA107_0 <= 109) || (LA107_0 >= 111 && LA107_0 <= 113)) {
                alt107 = 1;
            }
            switch (alt107) {
                case 1: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_expression_in_return_statement3228);
                    expression344 = this.expression();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    this.adaptor.addChild(root_0, expression344.getTree());
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final plsql_block_return plsql_block() throws RecognitionException {
        final plsql_block_return retval = new plsql_block_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token DECLARE345 = null;
        declare_section_return declare_section346 = null;
        body_return body347 = null;
        Object DECLARE345_tree = null;
        try {
            root_0 = this.adaptor.nil();
            int alt108 = 2;
            final int LA108_0 = this.input.LA(1);
            if (LA108_0 == 76) {
                alt108 = 1;
            }
            switch (alt108) {
                case 1: {
                    DECLARE345 = (Token)this.match((IntStream)this.input, 76, PLSQL2Parser.FOLLOW_DECLARE_in_plsql_block3252);
                    DECLARE345_tree = this.adaptor.create(DECLARE345);
                    this.adaptor.addChild(root_0, DECLARE345_tree);
                    this.pushFollow(PLSQL2Parser.FOLLOW_declare_section_in_plsql_block3254);
                    declare_section346 = this.declare_section();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    this.adaptor.addChild(root_0, declare_section346.getTree());
                    break;
                }
            }
            this.pushFollow(PLSQL2Parser.FOLLOW_body_in_plsql_block3259);
            body347 = this.body();
            final RecognizerSharedState state2 = this.state;
            --state2._fsp;
            this.adaptor.addChild(root_0, body347.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final label_return label() throws RecognitionException {
        final label_return retval = new label_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token LLABEL348 = null;
        Token RLABEL350 = null;
        label_return label349 = null;
        Object LLABEL348_tree = null;
        Object RLABEL350_tree = null;
        try {
            root_0 = this.adaptor.nil();
            LLABEL348 = (Token)this.match((IntStream)this.input, 77, PLSQL2Parser.FOLLOW_LLABEL_in_label3280);
            LLABEL348_tree = this.adaptor.create(LLABEL348);
            this.adaptor.addChild(root_0, LLABEL348_tree);
            this.pushFollow(PLSQL2Parser.FOLLOW_label_in_label3282);
            label349 = this.label();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, label349.getTree());
            RLABEL350 = (Token)this.match((IntStream)this.input, 78, PLSQL2Parser.FOLLOW_RLABEL_in_label3284);
            RLABEL350_tree = this.adaptor.create(RLABEL350);
            this.adaptor.addChild(root_0, RLABEL350_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final qual_id_return qual_id() throws RecognitionException {
        final qual_id_return retval = new qual_id_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token COLON351 = null;
        Token ID352 = null;
        Token DOT353 = null;
        Token COLON352 = null;
        Token ID353 = null;
        Object COLON351_tree = null;
        Object ID352_tree = null;
        Object DOT353_tree = null;
        Object COLON354_tree = null;
        Object ID355_tree = null;
        Label_0516: {
            try {
                root_0 = this.adaptor.nil();
                int alt109 = 2;
                final int LA109_0 = this.input.LA(1);
                if (LA109_0 == 48) {
                    alt109 = 1;
                }
                switch (alt109) {
                    case 1: {
                        COLON351 = (Token)this.match((IntStream)this.input, 48, PLSQL2Parser.FOLLOW_COLON_in_qual_id3298);
                        COLON351_tree = this.adaptor.create(COLON351);
                        this.adaptor.addChild(root_0, COLON351_tree);
                        break;
                    }
                }
                ID352 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_qual_id3301);
                ID352_tree = this.adaptor.create(ID352);
                this.adaptor.addChild(root_0, ID352_tree);
                while (true) {
                    int alt110 = 2;
                    final int LA111_0 = this.input.LA(1);
                    if (LA111_0 == 35) {
                        alt110 = 1;
                    }
                    switch (alt110) {
                        case 1: {
                            DOT353 = (Token)this.match((IntStream)this.input, 35, PLSQL2Parser.FOLLOW_DOT_in_qual_id3305);
                            DOT353_tree = this.adaptor.create(DOT353);
                            this.adaptor.addChild(root_0, DOT353_tree);
                            int alt111 = 2;
                            final int LA110_0 = this.input.LA(1);
                            if (LA110_0 == 48) {
                                alt111 = 1;
                            }
                            switch (alt111) {
                                case 1: {
                                    COLON352 = (Token)this.match((IntStream)this.input, 48, PLSQL2Parser.FOLLOW_COLON_in_qual_id3307);
                                    COLON354_tree = this.adaptor.create(COLON352);
                                    this.adaptor.addChild(root_0, COLON354_tree);
                                    break;
                                }
                            }
                            ID353 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_qual_id3310);
                            ID355_tree = this.adaptor.create(ID353);
                            this.adaptor.addChild(root_0, ID355_tree);
                            continue;
                        }
                        default: {
                            retval.stop = this.input.LT(-1);
                            retval.tree = this.adaptor.rulePostProcessing(root_0);
                            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                            break Label_0516;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final sql_statement_return sql_statement() throws RecognitionException {
        final sql_statement_return retval = new sql_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        commit_statement_return commit_statement356 = null;
        delete_statement_return delete_statement357 = null;
        insert_statement_return insert_statement358 = null;
        lock_table_statement_return lock_table_statement359 = null;
        rollback_statement_return rollback_statement360 = null;
        savepoint_statement_return savepoint_statement361 = null;
        select_statement_return select_statement362 = null;
        set_transaction_statement_return set_transaction_statement363 = null;
        update_statement_return update_statement364 = null;
        try {
            int alt112 = 9;
            switch (this.input.LA(1)) {
                case 79: {
                    alt112 = 1;
                    break;
                }
                case 49: {
                    alt112 = 2;
                    break;
                }
                case 80: {
                    alt112 = 3;
                    break;
                }
                case 81: {
                    alt112 = 4;
                    break;
                }
                case 82: {
                    alt112 = 5;
                    break;
                }
                case 83: {
                    alt112 = 6;
                    break;
                }
                case 84: {
                    alt112 = 7;
                    break;
                }
                case 85: {
                    alt112 = 8;
                    break;
                }
                case 87: {
                    alt112 = 9;
                    break;
                }
                default: {
                    final NoViableAltException nvae = new NoViableAltException("", 112, 0, (IntStream)this.input);
                    throw nvae;
                }
            }
            switch (alt112) {
                case 1: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_commit_statement_in_sql_statement3330);
                    commit_statement356 = this.commit_statement();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    this.adaptor.addChild(root_0, commit_statement356.getTree());
                    break;
                }
                case 2: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_delete_statement_in_sql_statement3338);
                    delete_statement357 = this.delete_statement();
                    final RecognizerSharedState state2 = this.state;
                    --state2._fsp;
                    this.adaptor.addChild(root_0, delete_statement357.getTree());
                    break;
                }
                case 3: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_insert_statement_in_sql_statement3346);
                    insert_statement358 = this.insert_statement();
                    final RecognizerSharedState state3 = this.state;
                    --state3._fsp;
                    this.adaptor.addChild(root_0, insert_statement358.getTree());
                    break;
                }
                case 4: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_lock_table_statement_in_sql_statement3354);
                    lock_table_statement359 = this.lock_table_statement();
                    final RecognizerSharedState state4 = this.state;
                    --state4._fsp;
                    this.adaptor.addChild(root_0, lock_table_statement359.getTree());
                    break;
                }
                case 5: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_rollback_statement_in_sql_statement3362);
                    rollback_statement360 = this.rollback_statement();
                    final RecognizerSharedState state5 = this.state;
                    --state5._fsp;
                    this.adaptor.addChild(root_0, rollback_statement360.getTree());
                    break;
                }
                case 6: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_savepoint_statement_in_sql_statement3370);
                    savepoint_statement361 = this.savepoint_statement();
                    final RecognizerSharedState state6 = this.state;
                    --state6._fsp;
                    this.adaptor.addChild(root_0, savepoint_statement361.getTree());
                    break;
                }
                case 7: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_select_statement_in_sql_statement3378);
                    select_statement362 = this.select_statement();
                    final RecognizerSharedState state7 = this.state;
                    --state7._fsp;
                    this.adaptor.addChild(root_0, select_statement362.getTree());
                    break;
                }
                case 8: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_set_transaction_statement_in_sql_statement3386);
                    set_transaction_statement363 = this.set_transaction_statement();
                    final RecognizerSharedState state8 = this.state;
                    --state8._fsp;
                    this.adaptor.addChild(root_0, set_transaction_statement363.getTree());
                    break;
                }
                case 9: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_update_statement_in_sql_statement3394);
                    update_statement364 = this.update_statement();
                    final RecognizerSharedState state9 = this.state;
                    --state9._fsp;
                    this.adaptor.addChild(root_0, update_statement364.getTree());
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final commit_statement_return commit_statement() throws RecognitionException {
        final commit_statement_return retval = new commit_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token COMMIT365 = null;
        swallow_to_semi_return swallow_to_semi366 = null;
        Object COMMIT365_tree = null;
        try {
            root_0 = this.adaptor.nil();
            COMMIT365 = (Token)this.match((IntStream)this.input, 79, PLSQL2Parser.FOLLOW_COMMIT_in_commit_statement3415);
            COMMIT365_tree = this.adaptor.create(COMMIT365);
            this.adaptor.addChild(root_0, COMMIT365_tree);
            int alt113 = 2;
            final int LA113_0 = this.input.LA(1);
            if (LA113_0 == 7) {
                final int LA113_2 = this.input.LA(2);
                if ((LA113_2 >= 4 && LA113_2 <= 6) || (LA113_2 >= 8 && LA113_2 <= 133)) {
                    alt113 = 1;
                }
                else if (LA113_2 == 7) {
                    final int LA113_3 = this.input.LA(3);
                    if (!this.input.LT(1).getText().equalsIgnoreCase("save")) {
                        alt113 = 1;
                    }
                }
            }
            else if (LA113_0 == 4 || LA113_0 == 6 || (LA113_0 >= 8 && LA113_0 <= 133)) {
                alt113 = 1;
            }
            switch (alt113) {
                case 1: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_swallow_to_semi_in_commit_statement3417);
                    swallow_to_semi366 = this.swallow_to_semi();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    this.adaptor.addChild(root_0, swallow_to_semi366.getTree());
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final delete_statement_return delete_statement() throws RecognitionException {
        final delete_statement_return retval = new delete_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token DELETE367 = null;
        swallow_to_semi_return swallow_to_semi368 = null;
        Object DELETE367_tree = null;
        try {
            root_0 = this.adaptor.nil();
            DELETE367 = (Token)this.match((IntStream)this.input, 49, PLSQL2Parser.FOLLOW_DELETE_in_delete_statement3439);
            DELETE367_tree = this.adaptor.create(DELETE367);
            this.adaptor.addChild(root_0, DELETE367_tree);
            this.pushFollow(PLSQL2Parser.FOLLOW_swallow_to_semi_in_delete_statement3441);
            swallow_to_semi368 = this.swallow_to_semi();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, swallow_to_semi368.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final insert_statement_return insert_statement() throws RecognitionException {
        final insert_statement_return retval = new insert_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token INSERT369 = null;
        swallow_to_semi_return swallow_to_semi370 = null;
        Object INSERT369_tree = null;
        try {
            root_0 = this.adaptor.nil();
            INSERT369 = (Token)this.match((IntStream)this.input, 80, PLSQL2Parser.FOLLOW_INSERT_in_insert_statement3462);
            INSERT369_tree = this.adaptor.create(INSERT369);
            this.adaptor.addChild(root_0, INSERT369_tree);
            this.pushFollow(PLSQL2Parser.FOLLOW_swallow_to_semi_in_insert_statement3464);
            swallow_to_semi370 = this.swallow_to_semi();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, swallow_to_semi370.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final lock_table_statement_return lock_table_statement() throws RecognitionException {
        final lock_table_statement_return retval = new lock_table_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token LOCK371 = null;
        Token TABLE372 = null;
        swallow_to_semi_return swallow_to_semi373 = null;
        Object LOCK371_tree = null;
        Object TABLE372_tree = null;
        try {
            root_0 = this.adaptor.nil();
            LOCK371 = (Token)this.match((IntStream)this.input, 81, PLSQL2Parser.FOLLOW_LOCK_in_lock_table_statement3485);
            LOCK371_tree = this.adaptor.create(LOCK371);
            this.adaptor.addChild(root_0, LOCK371_tree);
            TABLE372 = (Token)this.match((IntStream)this.input, 31, PLSQL2Parser.FOLLOW_TABLE_in_lock_table_statement3487);
            TABLE372_tree = this.adaptor.create(TABLE372);
            this.adaptor.addChild(root_0, TABLE372_tree);
            this.pushFollow(PLSQL2Parser.FOLLOW_swallow_to_semi_in_lock_table_statement3489);
            swallow_to_semi373 = this.swallow_to_semi();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, swallow_to_semi373.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final rollback_statement_return rollback_statement() throws RecognitionException {
        final rollback_statement_return retval = new rollback_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ROLLBACK374 = null;
        swallow_to_semi_return swallow_to_semi375 = null;
        Object ROLLBACK374_tree = null;
        try {
            root_0 = this.adaptor.nil();
            ROLLBACK374 = (Token)this.match((IntStream)this.input, 82, PLSQL2Parser.FOLLOW_ROLLBACK_in_rollback_statement3510);
            ROLLBACK374_tree = this.adaptor.create(ROLLBACK374);
            this.adaptor.addChild(root_0, ROLLBACK374_tree);
            int alt114 = 2;
            final int LA114_0 = this.input.LA(1);
            if (LA114_0 == 7) {
                final int LA114_2 = this.input.LA(2);
                if ((LA114_2 >= 4 && LA114_2 <= 6) || (LA114_2 >= 8 && LA114_2 <= 133)) {
                    alt114 = 1;
                }
                else if (LA114_2 == 7) {
                    final int LA114_3 = this.input.LA(3);
                    if (!this.input.LT(1).getText().equalsIgnoreCase("save")) {
                        alt114 = 1;
                    }
                }
            }
            else if (LA114_0 == 4 || LA114_0 == 6 || (LA114_0 >= 8 && LA114_0 <= 133)) {
                alt114 = 1;
            }
            switch (alt114) {
                case 1: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_swallow_to_semi_in_rollback_statement3512);
                    swallow_to_semi375 = this.swallow_to_semi();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    this.adaptor.addChild(root_0, swallow_to_semi375.getTree());
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final savepoint_statement_return savepoint_statement() throws RecognitionException {
        final savepoint_statement_return retval = new savepoint_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token SAVEPOINT376 = null;
        Token ID377 = null;
        Object SAVEPOINT376_tree = null;
        Object ID377_tree = null;
        try {
            root_0 = this.adaptor.nil();
            SAVEPOINT376 = (Token)this.match((IntStream)this.input, 83, PLSQL2Parser.FOLLOW_SAVEPOINT_in_savepoint_statement3534);
            SAVEPOINT376_tree = this.adaptor.create(SAVEPOINT376);
            this.adaptor.addChild(root_0, SAVEPOINT376_tree);
            ID377 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_savepoint_statement3536);
            ID377_tree = this.adaptor.create(ID377);
            this.adaptor.addChild(root_0, ID377_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final select_statement_return select_statement() throws RecognitionException {
        final select_statement_return retval = new select_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token SELECT378 = null;
        swallow_to_semi_return swallow_to_semi379 = null;
        Object SELECT378_tree = null;
        try {
            root_0 = this.adaptor.nil();
            SELECT378 = (Token)this.match((IntStream)this.input, 84, PLSQL2Parser.FOLLOW_SELECT_in_select_statement3557);
            SELECT378_tree = this.adaptor.create(SELECT378);
            this.adaptor.addChild(root_0, SELECT378_tree);
            this.pushFollow(PLSQL2Parser.FOLLOW_swallow_to_semi_in_select_statement3559);
            swallow_to_semi379 = this.swallow_to_semi();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, swallow_to_semi379.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final set_transaction_statement_return set_transaction_statement() throws RecognitionException {
        final set_transaction_statement_return retval = new set_transaction_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token SET380 = null;
        Token TRANSACTION381 = null;
        swallow_to_semi_return swallow_to_semi382 = null;
        Object SET380_tree = null;
        Object TRANSACTION381_tree = null;
        try {
            root_0 = this.adaptor.nil();
            SET380 = (Token)this.match((IntStream)this.input, 85, PLSQL2Parser.FOLLOW_SET_in_set_transaction_statement3580);
            SET380_tree = this.adaptor.create(SET380);
            this.adaptor.addChild(root_0, SET380_tree);
            TRANSACTION381 = (Token)this.match((IntStream)this.input, 86, PLSQL2Parser.FOLLOW_TRANSACTION_in_set_transaction_statement3582);
            TRANSACTION381_tree = this.adaptor.create(TRANSACTION381);
            this.adaptor.addChild(root_0, TRANSACTION381_tree);
            this.pushFollow(PLSQL2Parser.FOLLOW_swallow_to_semi_in_set_transaction_statement3584);
            swallow_to_semi382 = this.swallow_to_semi();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, swallow_to_semi382.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final update_statement_return update_statement() throws RecognitionException {
        final update_statement_return retval = new update_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token UPDATE383 = null;
        swallow_to_semi_return swallow_to_semi384 = null;
        Object UPDATE383_tree = null;
        try {
            root_0 = this.adaptor.nil();
            UPDATE383 = (Token)this.match((IntStream)this.input, 87, PLSQL2Parser.FOLLOW_UPDATE_in_update_statement3605);
            UPDATE383_tree = this.adaptor.create(UPDATE383);
            this.adaptor.addChild(root_0, UPDATE383_tree);
            this.pushFollow(PLSQL2Parser.FOLLOW_swallow_to_semi_in_update_statement3607);
            swallow_to_semi384 = this.swallow_to_semi();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, swallow_to_semi384.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final swallow_to_semi_return swallow_to_semi() throws RecognitionException {
        final swallow_to_semi_return retval = new swallow_to_semi_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token set385 = null;
        final Object set385_tree = null;
        Label_0461: {
            try {
                root_0 = this.adaptor.nil();
                int cnt115 = 0;
                while (true) {
                    int alt115 = 2;
                    final int LA115_0 = this.input.LA(1);
                    if (LA115_0 == 7) {
                        final int LA115_2 = this.input.LA(2);
                        if ((LA115_2 >= 4 && LA115_2 <= 6) || (LA115_2 >= 8 && LA115_2 <= 133)) {
                            alt115 = 1;
                        }
                        else if (LA115_2 == 7) {
                            final int LA115_3 = this.input.LA(3);
                            if (!this.input.LT(1).getText().equalsIgnoreCase("save")) {
                                alt115 = 1;
                            }
                        }
                    }
                    else if (LA115_0 == 4 || LA115_0 == 6 || (LA115_0 >= 8 && LA115_0 <= 133)) {
                        alt115 = 1;
                    }
                    switch (alt115) {
                        case 1: {
                            set385 = this.input.LT(1);
                            if (this.input.LA(1) == 4 || (this.input.LA(1) >= 6 && this.input.LA(1) <= 133)) {
                                this.input.consume();
                                this.adaptor.addChild(root_0, this.adaptor.create(set385));
                                this.state.errorRecovery = false;
                                ++cnt115;
                                continue;
                            }
                            final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                            throw mse;
                        }
                        default: {
                            if (cnt115 >= 1) {
                                retval.stop = this.input.LT(-1);
                                retval.tree = this.adaptor.rulePostProcessing(root_0);
                                this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                                break Label_0461;
                            }
                            final EarlyExitException eee = new EarlyExitException(115, (IntStream)this.input);
                            throw eee;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final while_loop_statement_return while_loop_statement() throws RecognitionException {
        final while_loop_statement_return retval = new while_loop_statement_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token WHILE386 = null;
        Token LOOP388 = null;
        Token SEMI390 = null;
        Token END391 = null;
        Token LOOP389 = null;
        expression_return expression387 = null;
        statement_return statement389 = null;
        label_name_return label_name393 = null;
        Object WHILE386_tree = null;
        Object LOOP388_tree = null;
        Object SEMI390_tree = null;
        Object END391_tree = null;
        Object LOOP392_tree = null;
        Label_0780: {
            try {
                root_0 = this.adaptor.nil();
                WHILE386 = (Token)this.match((IntStream)this.input, 88, PLSQL2Parser.FOLLOW_WHILE_in_while_loop_statement3655);
                WHILE386_tree = this.adaptor.create(WHILE386);
                this.adaptor.addChild(root_0, WHILE386_tree);
                this.pushFollow(PLSQL2Parser.FOLLOW_expression_in_while_loop_statement3657);
                expression387 = this.expression();
                final RecognizerSharedState state = this.state;
                --state._fsp;
                this.adaptor.addChild(root_0, expression387.getTree());
                LOOP388 = (Token)this.match((IntStream)this.input, 50, PLSQL2Parser.FOLLOW_LOOP_in_while_loop_statement3659);
                LOOP388_tree = this.adaptor.create(LOOP388);
                this.adaptor.addChild(root_0, LOOP388_tree);
                int cnt116 = 0;
                while (true) {
                    int alt116 = 2;
                    final int LA116_0 = this.input.LA(1);
                    if (LA116_0 == 7 || LA116_0 == 9 || LA116_0 == 21 || LA116_0 == 42 || (LA116_0 >= 48 && LA116_0 <= 51) || (LA116_0 >= 53 && LA116_0 <= 55) || (LA116_0 >= 57 && LA116_0 <= 58) || (LA116_0 >= 65 && LA116_0 <= 66) || (LA116_0 >= 70 && LA116_0 <= 71) || LA116_0 == 73 || (LA116_0 >= 75 && LA116_0 <= 77) || (LA116_0 >= 79 && LA116_0 <= 85) || (LA116_0 >= 87 && LA116_0 <= 88)) {
                        alt116 = 1;
                    }
                    switch (alt116) {
                        case 1: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_statement_in_while_loop_statement3663);
                            statement389 = this.statement();
                            final RecognizerSharedState state2 = this.state;
                            --state2._fsp;
                            this.adaptor.addChild(root_0, statement389.getTree());
                            SEMI390 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_while_loop_statement3665);
                            SEMI390_tree = this.adaptor.create(SEMI390);
                            this.adaptor.addChild(root_0, SEMI390_tree);
                            ++cnt116;
                            continue;
                        }
                        default: {
                            if (cnt116 >= 1) {
                                END391 = (Token)this.match((IntStream)this.input, 43, PLSQL2Parser.FOLLOW_END_in_while_loop_statement3670);
                                END391_tree = this.adaptor.create(END391);
                                this.adaptor.addChild(root_0, END391_tree);
                                LOOP389 = (Token)this.match((IntStream)this.input, 50, PLSQL2Parser.FOLLOW_LOOP_in_while_loop_statement3672);
                                LOOP392_tree = this.adaptor.create(LOOP389);
                                this.adaptor.addChild(root_0, LOOP392_tree);
                                int alt117 = 2;
                                final int LA117_0 = this.input.LA(1);
                                if (LA117_0 == 7) {
                                    alt117 = 1;
                                }
                                switch (alt117) {
                                    case 1: {
                                        this.pushFollow(PLSQL2Parser.FOLLOW_label_name_in_while_loop_statement3674);
                                        label_name393 = this.label_name();
                                        final RecognizerSharedState state3 = this.state;
                                        --state3._fsp;
                                        this.adaptor.addChild(root_0, label_name393.getTree());
                                        break;
                                    }
                                }
                                retval.stop = this.input.LT(-1);
                                retval.tree = this.adaptor.rulePostProcessing(root_0);
                                this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                                break Label_0780;
                            }
                            final EarlyExitException eee = new EarlyExitException(116, (IntStream)this.input);
                            throw eee;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final match_parens_return match_parens() throws RecognitionException {
        final match_parens_return retval = new match_parens_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token set394 = null;
        Token RPAREN395 = null;
        Token LPAREN397 = null;
        match_parens_return match_parens396 = null;
        final Object set394_tree = null;
        Object RPAREN395_tree = null;
        Object LPAREN397_tree = null;
        try {
            int alt119 = 2;
            final int LA119_0 = this.input.LA(1);
            if (LA119_0 == 4 || (LA119_0 >= 6 && LA119_0 <= 11) || (LA119_0 >= 13 && LA119_0 <= 14) || (LA119_0 >= 17 && LA119_0 <= 18) || (LA119_0 >= 20 && LA119_0 <= 23) || (LA119_0 >= 25 && LA119_0 <= 133)) {
                alt119 = 1;
            }
            else {
                if (LA119_0 != 12) {
                    final NoViableAltException nvae = new NoViableAltException("", 119, 0, (IntStream)this.input);
                    throw nvae;
                }
                alt119 = 2;
            }
            Label_0732: {
                switch (alt119) {
                    case 1: {
                        root_0 = this.adaptor.nil();
                        while (true) {
                            int alt120 = 2;
                            final int LA118_0 = this.input.LA(1);
                            if (LA118_0 == 4 || (LA118_0 >= 6 && LA118_0 <= 9) || LA118_0 == 11 || (LA118_0 >= 13 && LA118_0 <= 14) || (LA118_0 >= 17 && LA118_0 <= 18) || (LA118_0 >= 20 && LA118_0 <= 23) || (LA118_0 >= 25 && LA118_0 <= 133)) {
                                alt120 = 1;
                            }
                            else if (LA118_0 == 10) {
                                alt120 = 2;
                            }
                            switch (alt120) {
                                case 1: {
                                    set394 = this.input.LT(1);
                                    if (this.input.LA(1) == 4 || (this.input.LA(1) >= 6 && this.input.LA(1) <= 9) || this.input.LA(1) == 11 || (this.input.LA(1) >= 13 && this.input.LA(1) <= 14) || (this.input.LA(1) >= 17 && this.input.LA(1) <= 18) || (this.input.LA(1) >= 20 && this.input.LA(1) <= 23) || (this.input.LA(1) >= 25 && this.input.LA(1) <= 133)) {
                                        this.input.consume();
                                        this.adaptor.addChild(root_0, this.adaptor.create(set394));
                                        this.state.errorRecovery = false;
                                        continue;
                                    }
                                    final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                                    throw mse;
                                }
                                default: {
                                    break Label_0732;
                                }
                            }
                        }
                        /*break;*/
                    }
                    case 2: {
                        root_0 = this.adaptor.nil();
                        RPAREN395 = (Token)this.match((IntStream)this.input, 12, PLSQL2Parser.FOLLOW_RPAREN_in_match_parens3743);
                        RPAREN395_tree = this.adaptor.create(RPAREN395);
                        this.adaptor.addChild(root_0, RPAREN395_tree);
                        this.pushFollow(PLSQL2Parser.FOLLOW_match_parens_in_match_parens3745);
                        match_parens396 = this.match_parens();
                        final RecognizerSharedState state = this.state;
                        --state._fsp;
                        this.adaptor.addChild(root_0, match_parens396.getTree());
                        LPAREN397 = (Token)this.match((IntStream)this.input, 10, PLSQL2Parser.FOLLOW_LPAREN_in_match_parens3747);
                        LPAREN397_tree = this.adaptor.create(LPAREN397);
                        this.adaptor.addChild(root_0, LPAREN397_tree);
                        break;
                    }
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final label_name_return label_name() throws RecognitionException {
        final label_name_return retval = new label_name_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ID398 = null;
        Object ID398_tree = null;
        try {
            root_0 = this.adaptor.nil();
            ID398 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_label_name3759);
            ID398_tree = this.adaptor.create(ID398);
            this.adaptor.addChild(root_0, ID398_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final expression_return expression() throws RecognitionException {
        final expression_return retval = new expression_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        or_expr_return or_expr399 = null;
        try {
            root_0 = this.adaptor.nil();
            this.pushFollow(PLSQL2Parser.FOLLOW_or_expr_in_expression3771);
            or_expr399 = this.or_expr();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, or_expr399.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final or_expr_return or_expr() throws RecognitionException {
        final or_expr_return retval = new or_expr_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token OR401 = null;
        and_expr_return and_expr400 = null;
        and_expr_return and_expr401 = null;
        Object OR401_tree = null;
        Label_0320: {
            try {
                root_0 = this.adaptor.nil();
                this.pushFollow(PLSQL2Parser.FOLLOW_and_expr_in_or_expr3788);
                and_expr400 = this.and_expr();
                final RecognizerSharedState state = this.state;
                --state._fsp;
                this.adaptor.addChild(root_0, and_expr400.getTree());
                while (true) {
                    int alt120 = 2;
                    final int LA120_0 = this.input.LA(1);
                    if (LA120_0 == 45) {
                        alt120 = 1;
                    }
                    switch (alt120) {
                        case 1: {
                            OR401 = (Token)this.match((IntStream)this.input, 45, PLSQL2Parser.FOLLOW_OR_in_or_expr3792);
                            OR401_tree = this.adaptor.create(OR401);
                            this.adaptor.addChild(root_0, OR401_tree);
                            this.pushFollow(PLSQL2Parser.FOLLOW_and_expr_in_or_expr3794);
                            and_expr401 = this.and_expr();
                            final RecognizerSharedState state2 = this.state;
                            --state2._fsp;
                            this.adaptor.addChild(root_0, and_expr401.getTree());
                            continue;
                        }
                        default: {
                            retval.stop = this.input.LT(-1);
                            retval.tree = this.adaptor.rulePostProcessing(root_0);
                            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                            break Label_0320;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final and_expr_return and_expr() throws RecognitionException {
        final and_expr_return retval = new and_expr_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token AND404 = null;
        not_expr_return not_expr403 = null;
        not_expr_return not_expr404 = null;
        Object AND404_tree = null;
        Label_0320: {
            try {
                root_0 = this.adaptor.nil();
                this.pushFollow(PLSQL2Parser.FOLLOW_not_expr_in_and_expr3814);
                not_expr403 = this.not_expr();
                final RecognizerSharedState state = this.state;
                --state._fsp;
                this.adaptor.addChild(root_0, not_expr403.getTree());
                while (true) {
                    int alt121 = 2;
                    final int LA121_0 = this.input.LA(1);
                    if (LA121_0 == 69) {
                        alt121 = 1;
                    }
                    switch (alt121) {
                        case 1: {
                            AND404 = (Token)this.match((IntStream)this.input, 69, PLSQL2Parser.FOLLOW_AND_in_and_expr3818);
                            AND404_tree = this.adaptor.create(AND404);
                            this.adaptor.addChild(root_0, AND404_tree);
                            this.pushFollow(PLSQL2Parser.FOLLOW_not_expr_in_and_expr3820);
                            not_expr404 = this.not_expr();
                            final RecognizerSharedState state2 = this.state;
                            --state2._fsp;
                            this.adaptor.addChild(root_0, not_expr404.getTree());
                            continue;
                        }
                        default: {
                            retval.stop = this.input.LT(-1);
                            retval.tree = this.adaptor.rulePostProcessing(root_0);
                            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                            break Label_0320;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final not_expr_return not_expr() throws RecognitionException {
        final not_expr_return retval = new not_expr_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token NOT406 = null;
        compare_expr_return compare_expr407 = null;
        Object NOT406_tree = null;
        try {
            root_0 = this.adaptor.nil();
            int alt122 = 2;
            final int LA122_0 = this.input.LA(1);
            if (LA122_0 == 20) {
                alt122 = 1;
            }
            switch (alt122) {
                case 1: {
                    NOT406 = (Token)this.match((IntStream)this.input, 20, PLSQL2Parser.FOLLOW_NOT_in_not_expr3840);
                    NOT406_tree = this.adaptor.create(NOT406);
                    this.adaptor.addChild(root_0, NOT406_tree);
                    break;
                }
            }
            this.pushFollow(PLSQL2Parser.FOLLOW_compare_expr_in_not_expr3843);
            compare_expr407 = this.compare_expr();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, compare_expr407.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final compare_expr_return compare_expr() throws RecognitionException {
        final compare_expr_return retval = new compare_expr_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token set409 = null;
        is_null_expr_return is_null_expr408 = null;
        is_null_expr_return is_null_expr409 = null;
        final Object set409_tree = null;
        try {
            root_0 = this.adaptor.nil();
            this.pushFollow(PLSQL2Parser.FOLLOW_is_null_expr_in_compare_expr3860);
            is_null_expr408 = this.is_null_expr();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, is_null_expr408.getTree());
            int alt123 = 2;
            final int LA123_0 = this.input.LA(1);
            if (LA123_0 >= 89 && LA123_0 <= 94) {
                alt123 = 1;
            }
            switch (alt123) {
                case 1: {
                    set409 = this.input.LT(1);
                    if (this.input.LA(1) >= 89 && this.input.LA(1) <= 94) {
                        this.input.consume();
                        this.adaptor.addChild(root_0, this.adaptor.create(set409));
                        this.state.errorRecovery = false;
                        this.pushFollow(PLSQL2Parser.FOLLOW_is_null_expr_in_compare_expr3890);
                        is_null_expr409 = this.is_null_expr();
                        final RecognizerSharedState state2 = this.state;
                        --state2._fsp;
                        this.adaptor.addChild(root_0, is_null_expr409.getTree());
                        break;
                    }
                    final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                    throw mse;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final is_null_expr_return is_null_expr() throws RecognitionException {
        final is_null_expr_return retval = new is_null_expr_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token IS412 = null;
        Token NOT413 = null;
        Token NULL414 = null;
        like_expr_return like_expr411 = null;
        Object IS412_tree = null;
        Object NOT413_tree = null;
        Object NULL414_tree = null;
        try {
            root_0 = this.adaptor.nil();
            this.pushFollow(PLSQL2Parser.FOLLOW_like_expr_in_is_null_expr3910);
            like_expr411 = this.like_expr();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, like_expr411.getTree());
            int alt125 = 2;
            final int LA125_0 = this.input.LA(1);
            if (LA125_0 == 19) {
                alt125 = 1;
            }
            switch (alt125) {
                case 1: {
                    IS412 = (Token)this.match((IntStream)this.input, 19, PLSQL2Parser.FOLLOW_IS_in_is_null_expr3914);
                    IS412_tree = this.adaptor.create(IS412);
                    this.adaptor.addChild(root_0, IS412_tree);
                    int alt126 = 2;
                    final int LA124_0 = this.input.LA(1);
                    if (LA124_0 == 20) {
                        alt126 = 1;
                    }
                    switch (alt126) {
                        case 1: {
                            NOT413 = (Token)this.match((IntStream)this.input, 20, PLSQL2Parser.FOLLOW_NOT_in_is_null_expr3916);
                            NOT413_tree = this.adaptor.create(NOT413);
                            this.adaptor.addChild(root_0, NOT413_tree);
                            break;
                        }
                    }
                    NULL414 = (Token)this.match((IntStream)this.input, 21, PLSQL2Parser.FOLLOW_NULL_in_is_null_expr3919);
                    NULL414_tree = this.adaptor.create(NULL414);
                    this.adaptor.addChild(root_0, NULL414_tree);
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final like_expr_return like_expr() throws RecognitionException {
        final like_expr_return retval = new like_expr_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token NOT416 = null;
        Token LIKE417 = null;
        between_expr_return between_expr415 = null;
        between_expr_return between_expr416 = null;
        Object NOT416_tree = null;
        Object LIKE417_tree = null;
        try {
            root_0 = this.adaptor.nil();
            this.pushFollow(PLSQL2Parser.FOLLOW_between_expr_in_like_expr3938);
            between_expr415 = this.between_expr();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, between_expr415.getTree());
            int alt127 = 2;
            final int LA127_0 = this.input.LA(1);
            if (LA127_0 == 20 || LA127_0 == 95) {
                alt127 = 1;
            }
            switch (alt127) {
                case 1: {
                    int alt128 = 2;
                    final int LA126_0 = this.input.LA(1);
                    if (LA126_0 == 20) {
                        alt128 = 1;
                    }
                    switch (alt128) {
                        case 1: {
                            NOT416 = (Token)this.match((IntStream)this.input, 20, PLSQL2Parser.FOLLOW_NOT_in_like_expr3942);
                            NOT416_tree = this.adaptor.create(NOT416);
                            this.adaptor.addChild(root_0, NOT416_tree);
                            break;
                        }
                    }
                    LIKE417 = (Token)this.match((IntStream)this.input, 95, PLSQL2Parser.FOLLOW_LIKE_in_like_expr3945);
                    LIKE417_tree = this.adaptor.create(LIKE417);
                    this.adaptor.addChild(root_0, LIKE417_tree);
                    this.pushFollow(PLSQL2Parser.FOLLOW_between_expr_in_like_expr3947);
                    between_expr416 = this.between_expr();
                    final RecognizerSharedState state2 = this.state;
                    --state2._fsp;
                    this.adaptor.addChild(root_0, between_expr416.getTree());
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final between_expr_return between_expr() throws RecognitionException {
        final between_expr_return retval = new between_expr_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token NOT420 = null;
        Token BETWEEN421 = null;
        Token AND423 = null;
        in_expr_return in_expr419 = null;
        in_expr_return in_expr420 = null;
        in_expr_return in_expr421 = null;
        Object NOT420_tree = null;
        Object BETWEEN421_tree = null;
        Object AND423_tree = null;
        try {
            root_0 = this.adaptor.nil();
            this.pushFollow(PLSQL2Parser.FOLLOW_in_expr_in_between_expr3967);
            in_expr419 = this.in_expr();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, in_expr419.getTree());
            int alt129 = 2;
            final int LA129_0 = this.input.LA(1);
            if (LA129_0 == 20) {
                final int LA129_2 = this.input.LA(2);
                if (LA129_2 == 68) {
                    alt129 = 1;
                }
            }
            else if (LA129_0 == 68) {
                alt129 = 1;
            }
            switch (alt129) {
                case 1: {
                    int alt130 = 2;
                    final int LA128_0 = this.input.LA(1);
                    if (LA128_0 == 20) {
                        alt130 = 1;
                    }
                    switch (alt130) {
                        case 1: {
                            NOT420 = (Token)this.match((IntStream)this.input, 20, PLSQL2Parser.FOLLOW_NOT_in_between_expr3971);
                            NOT420_tree = this.adaptor.create(NOT420);
                            this.adaptor.addChild(root_0, NOT420_tree);
                            break;
                        }
                    }
                    BETWEEN421 = (Token)this.match((IntStream)this.input, 68, PLSQL2Parser.FOLLOW_BETWEEN_in_between_expr3974);
                    BETWEEN421_tree = this.adaptor.create(BETWEEN421);
                    this.adaptor.addChild(root_0, BETWEEN421_tree);
                    this.pushFollow(PLSQL2Parser.FOLLOW_in_expr_in_between_expr3976);
                    in_expr420 = this.in_expr();
                    final RecognizerSharedState state2 = this.state;
                    --state2._fsp;
                    this.adaptor.addChild(root_0, in_expr420.getTree());
                    AND423 = (Token)this.match((IntStream)this.input, 69, PLSQL2Parser.FOLLOW_AND_in_between_expr3978);
                    AND423_tree = this.adaptor.create(AND423);
                    this.adaptor.addChild(root_0, AND423_tree);
                    this.pushFollow(PLSQL2Parser.FOLLOW_in_expr_in_between_expr3980);
                    in_expr421 = this.in_expr();
                    final RecognizerSharedState state3 = this.state;
                    --state3._fsp;
                    this.adaptor.addChild(root_0, in_expr421.getTree());
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final in_expr_return in_expr() throws RecognitionException {
        final in_expr_return retval = new in_expr_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token NOT426 = null;
        Token IN427 = null;
        Token LPAREN428 = null;
        Token COMMA430 = null;
        Token RPAREN432 = null;
        add_expr_return add_expr425 = null;
        add_expr_return add_expr426 = null;
        add_expr_return add_expr427 = null;
        Object NOT426_tree = null;
        Object IN427_tree = null;
        Object LPAREN428_tree = null;
        Object COMMA430_tree = null;
        Object RPAREN432_tree = null;
        try {
            root_0 = this.adaptor.nil();
            this.pushFollow(PLSQL2Parser.FOLLOW_add_expr_in_in_expr4000);
            add_expr425 = this.add_expr();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, add_expr425.getTree());
            int alt132 = 2;
            final int LA132_0 = this.input.LA(1);
            if (LA132_0 == 20) {
                final int LA132_2 = this.input.LA(2);
                if (LA132_2 == 15) {
                    alt132 = 1;
                }
            }
            else if (LA132_0 == 15) {
                alt132 = 1;
            }
            Label_0578: {
                switch (alt132) {
                    case 1: {
                        int alt133 = 2;
                        final int LA130_0 = this.input.LA(1);
                        if (LA130_0 == 20) {
                            alt133 = 1;
                        }
                        switch (alt133) {
                            case 1: {
                                NOT426 = (Token)this.match((IntStream)this.input, 20, PLSQL2Parser.FOLLOW_NOT_in_in_expr4004);
                                NOT426_tree = this.adaptor.create(NOT426);
                                this.adaptor.addChild(root_0, NOT426_tree);
                                break;
                            }
                        }
                        IN427 = (Token)this.match((IntStream)this.input, 15, PLSQL2Parser.FOLLOW_IN_in_in_expr4007);
                        IN427_tree = this.adaptor.create(IN427);
                        this.adaptor.addChild(root_0, IN427_tree);
                        LPAREN428 = (Token)this.match((IntStream)this.input, 10, PLSQL2Parser.FOLLOW_LPAREN_in_in_expr4009);
                        LPAREN428_tree = this.adaptor.create(LPAREN428);
                        this.adaptor.addChild(root_0, LPAREN428_tree);
                        this.pushFollow(PLSQL2Parser.FOLLOW_add_expr_in_in_expr4011);
                        add_expr426 = this.add_expr();
                        final RecognizerSharedState state2 = this.state;
                        --state2._fsp;
                        this.adaptor.addChild(root_0, add_expr426.getTree());
                        while (true) {
                            int alt134 = 2;
                            final int LA131_0 = this.input.LA(1);
                            if (LA131_0 == 11) {
                                alt134 = 1;
                            }
                            switch (alt134) {
                                case 1: {
                                    COMMA430 = (Token)this.match((IntStream)this.input, 11, PLSQL2Parser.FOLLOW_COMMA_in_in_expr4015);
                                    COMMA430_tree = this.adaptor.create(COMMA430);
                                    this.adaptor.addChild(root_0, COMMA430_tree);
                                    this.pushFollow(PLSQL2Parser.FOLLOW_add_expr_in_in_expr4017);
                                    add_expr427 = this.add_expr();
                                    final RecognizerSharedState state3 = this.state;
                                    --state3._fsp;
                                    this.adaptor.addChild(root_0, add_expr427.getTree());
                                    continue;
                                }
                                default: {
                                    RPAREN432 = (Token)this.match((IntStream)this.input, 12, PLSQL2Parser.FOLLOW_RPAREN_in_in_expr4022);
                                    RPAREN432_tree = this.adaptor.create(RPAREN432);
                                    this.adaptor.addChild(root_0, RPAREN432_tree);
                                    break Label_0578;
                                }
                            }
                        }
                        /*break;*/
                    }
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final numeric_expression_return numeric_expression() throws RecognitionException {
        final numeric_expression_return retval = new numeric_expression_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        add_expr_return add_expr433 = null;
        try {
            root_0 = this.adaptor.nil();
            this.pushFollow(PLSQL2Parser.FOLLOW_add_expr_in_numeric_expression4042);
            add_expr433 = this.add_expr();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, add_expr433.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final add_expr_return add_expr() throws RecognitionException {
        final add_expr_return retval = new add_expr_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token set435 = null;
        mul_expr_return mul_expr434 = null;
        mul_expr_return mul_expr435 = null;
        final Object set435_tree = null;
        Label_0385: {
            try {
                root_0 = this.adaptor.nil();
                this.pushFollow(PLSQL2Parser.FOLLOW_mul_expr_in_add_expr4059);
                mul_expr434 = this.mul_expr();
                final RecognizerSharedState state = this.state;
                --state._fsp;
                this.adaptor.addChild(root_0, mul_expr434.getTree());
                while (true) {
                    int alt133 = 2;
                    final int LA133_0 = this.input.LA(1);
                    if (LA133_0 >= 96 && LA133_0 <= 98) {
                        alt133 = 1;
                    }
                    switch (alt133) {
                        case 1: {
                            set435 = this.input.LT(1);
                            if (this.input.LA(1) >= 96 && this.input.LA(1) <= 98) {
                                this.input.consume();
                                this.adaptor.addChild(root_0, this.adaptor.create(set435));
                                this.state.errorRecovery = false;
                                this.pushFollow(PLSQL2Parser.FOLLOW_mul_expr_in_add_expr4077);
                                mul_expr435 = this.mul_expr();
                                final RecognizerSharedState state2 = this.state;
                                --state2._fsp;
                                this.adaptor.addChild(root_0, mul_expr435.getTree());
                                continue;
                            }
                            final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                            throw mse;
                        }
                        default: {
                            retval.stop = this.input.LT(-1);
                            retval.tree = this.adaptor.rulePostProcessing(root_0);
                            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                            break Label_0385;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final mul_expr_return mul_expr() throws RecognitionException {
        final mul_expr_return retval = new mul_expr_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ASTERISK438 = null;
        Token DIVIDE439 = null;
        unary_sign_expr_return unary_sign_expr437 = null;
        kMOD_return kMOD440 = null;
        unary_sign_expr_return unary_sign_expr438 = null;
        Object ASTERISK438_tree = null;
        Object DIVIDE439_tree = null;
        Label_0545: {
            try {
                root_0 = this.adaptor.nil();
                this.pushFollow(PLSQL2Parser.FOLLOW_unary_sign_expr_in_mul_expr4097);
                unary_sign_expr437 = this.unary_sign_expr();
                final RecognizerSharedState state = this.state;
                --state._fsp;
                this.adaptor.addChild(root_0, unary_sign_expr437.getTree());
                while (true) {
                    int alt135 = 2;
                    final int LA135_0 = this.input.LA(1);
                    if (LA135_0 == 4 || LA135_0 == 7 || LA135_0 == 99) {
                        alt135 = 1;
                    }
                    switch (alt135) {
                        case 1: {
                            int alt136 = 3;
                            switch (this.input.LA(1)) {
                                case 99: {
                                    alt136 = 1;
                                    break;
                                }
                                case 4: {
                                    alt136 = 2;
                                    break;
                                }
                                case 7: {
                                    alt136 = 3;
                                    break;
                                }
                                default: {
                                    final NoViableAltException nvae = new NoViableAltException("", 134, 0, (IntStream)this.input);
                                    throw nvae;
                                }
                            }
                            switch (alt136) {
                                case 1: {
                                    ASTERISK438 = (Token)this.match((IntStream)this.input, 99, PLSQL2Parser.FOLLOW_ASTERISK_in_mul_expr4103);
                                    ASTERISK438_tree = this.adaptor.create(ASTERISK438);
                                    this.adaptor.addChild(root_0, ASTERISK438_tree);
                                    break;
                                }
                                case 2: {
                                    DIVIDE439 = (Token)this.match((IntStream)this.input, 4, PLSQL2Parser.FOLLOW_DIVIDE_in_mul_expr4107);
                                    DIVIDE439_tree = this.adaptor.create(DIVIDE439);
                                    this.adaptor.addChild(root_0, DIVIDE439_tree);
                                    break;
                                }
                                case 3: {
                                    this.pushFollow(PLSQL2Parser.FOLLOW_kMOD_in_mul_expr4111);
                                    kMOD440 = this.kMOD();
                                    final RecognizerSharedState state2 = this.state;
                                    --state2._fsp;
                                    this.adaptor.addChild(root_0, kMOD440.getTree());
                                    break;
                                }
                            }
                            this.pushFollow(PLSQL2Parser.FOLLOW_unary_sign_expr_in_mul_expr4115);
                            unary_sign_expr438 = this.unary_sign_expr();
                            final RecognizerSharedState state3 = this.state;
                            --state3._fsp;
                            this.adaptor.addChild(root_0, unary_sign_expr438.getTree());
                            continue;
                        }
                        default: {
                            retval.stop = this.input.LT(-1);
                            retval.tree = this.adaptor.rulePostProcessing(root_0);
                            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                            break Label_0545;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final unary_sign_expr_return unary_sign_expr() throws RecognitionException {
        final unary_sign_expr_return retval = new unary_sign_expr_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token set442 = null;
        exponent_expr_return exponent_expr443 = null;
        final Object set442_tree = null;
        try {
            root_0 = this.adaptor.nil();
            int alt136 = 2;
            final int LA136_0 = this.input.LA(1);
            if (LA136_0 >= 96 && LA136_0 <= 97) {
                alt136 = 1;
            }
            switch (alt136) {
                case 1: {
                    set442 = this.input.LT(1);
                    if (this.input.LA(1) >= 96 && this.input.LA(1) <= 97) {
                        this.input.consume();
                        this.adaptor.addChild(root_0, this.adaptor.create(set442));
                        this.state.errorRecovery = false;
                        break;
                    }
                    final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                    throw mse;
                }
            }
            this.pushFollow(PLSQL2Parser.FOLLOW_exponent_expr_in_unary_sign_expr4146);
            exponent_expr443 = this.exponent_expr();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, exponent_expr443.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final exponent_expr_return exponent_expr() throws RecognitionException {
        final exponent_expr_return retval = new exponent_expr_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token EXPONENT445 = null;
        atom_return atom444 = null;
        atom_return atom445 = null;
        Object EXPONENT445_tree = null;
        try {
            root_0 = this.adaptor.nil();
            this.pushFollow(PLSQL2Parser.FOLLOW_atom_in_exponent_expr4163);
            atom444 = this.atom();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, atom444.getTree());
            int alt137 = 2;
            final int LA137_0 = this.input.LA(1);
            if (LA137_0 == 100) {
                alt137 = 1;
            }
            switch (alt137) {
                case 1: {
                    EXPONENT445 = (Token)this.match((IntStream)this.input, 100, PLSQL2Parser.FOLLOW_EXPONENT_in_exponent_expr4167);
                    EXPONENT445_tree = this.adaptor.create(EXPONENT445);
                    this.adaptor.addChild(root_0, EXPONENT445_tree);
                    this.pushFollow(PLSQL2Parser.FOLLOW_atom_in_exponent_expr4169);
                    atom445 = this.atom();
                    final RecognizerSharedState state2 = this.state;
                    --state2._fsp;
                    this.adaptor.addChild(root_0, atom445.getTree());
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final atom_return atom() throws RecognitionException {
        final atom_return retval = new atom_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token PERCENT448 = null;
        Token SQL450 = null;
        Token PERCENT449 = null;
        Token NULL456 = null;
        Token LPAREN457 = null;
        Token RPAREN459 = null;
        variable_or_function_call_return variable_or_function_call447 = null;
        attribute_return attribute449 = null;
        attribute_return attribute450 = null;
        string_literal_return string_literal453 = null;
        numeric_atom_return numeric_atom454 = null;
        boolean_atom_return boolean_atom455 = null;
        expression_return expression458 = null;
        Object PERCENT448_tree = null;
        Object SQL450_tree = null;
        Object PERCENT451_tree = null;
        Object NULL456_tree = null;
        Object LPAREN457_tree = null;
        Object RPAREN459_tree = null;
        try {
            int alt139 = 7;
            alt139 = this.dfa139.predict((IntStream)this.input);
            switch (alt139) {
                case 1: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_variable_or_function_call_in_atom4189);
                    variable_or_function_call447 = this.variable_or_function_call();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    this.adaptor.addChild(root_0, variable_or_function_call447.getTree());
                    int alt140 = 2;
                    final int LA138_0 = this.input.LA(1);
                    if (LA138_0 == 36) {
                        alt140 = 1;
                    }
                    switch (alt140) {
                        case 1: {
                            PERCENT448 = (Token)this.match((IntStream)this.input, 36, PLSQL2Parser.FOLLOW_PERCENT_in_atom4193);
                            PERCENT448_tree = this.adaptor.create(PERCENT448);
                            this.adaptor.addChild(root_0, PERCENT448_tree);
                            this.pushFollow(PLSQL2Parser.FOLLOW_attribute_in_atom4195);
                            attribute449 = this.attribute();
                            final RecognizerSharedState state2 = this.state;
                            --state2._fsp;
                            this.adaptor.addChild(root_0, attribute449.getTree());
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    root_0 = this.adaptor.nil();
                    SQL450 = (Token)this.match((IntStream)this.input, 101, PLSQL2Parser.FOLLOW_SQL_in_atom4206);
                    SQL450_tree = this.adaptor.create(SQL450);
                    this.adaptor.addChild(root_0, SQL450_tree);
                    PERCENT449 = (Token)this.match((IntStream)this.input, 36, PLSQL2Parser.FOLLOW_PERCENT_in_atom4208);
                    PERCENT451_tree = this.adaptor.create(PERCENT449);
                    this.adaptor.addChild(root_0, PERCENT451_tree);
                    this.pushFollow(PLSQL2Parser.FOLLOW_attribute_in_atom4210);
                    attribute450 = this.attribute();
                    final RecognizerSharedState state3 = this.state;
                    --state3._fsp;
                    this.adaptor.addChild(root_0, attribute450.getTree());
                    break;
                }
                case 3: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_string_literal_in_atom4218);
                    string_literal453 = this.string_literal();
                    final RecognizerSharedState state4 = this.state;
                    --state4._fsp;
                    this.adaptor.addChild(root_0, string_literal453.getTree());
                    break;
                }
                case 4: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_numeric_atom_in_atom4226);
                    numeric_atom454 = this.numeric_atom();
                    final RecognizerSharedState state5 = this.state;
                    --state5._fsp;
                    this.adaptor.addChild(root_0, numeric_atom454.getTree());
                    break;
                }
                case 5: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_boolean_atom_in_atom4234);
                    boolean_atom455 = this.boolean_atom();
                    final RecognizerSharedState state6 = this.state;
                    --state6._fsp;
                    this.adaptor.addChild(root_0, boolean_atom455.getTree());
                    break;
                }
                case 6: {
                    root_0 = this.adaptor.nil();
                    NULL456 = (Token)this.match((IntStream)this.input, 21, PLSQL2Parser.FOLLOW_NULL_in_atom4242);
                    NULL456_tree = this.adaptor.create(NULL456);
                    this.adaptor.addChild(root_0, NULL456_tree);
                    break;
                }
                case 7: {
                    root_0 = this.adaptor.nil();
                    LPAREN457 = (Token)this.match((IntStream)this.input, 10, PLSQL2Parser.FOLLOW_LPAREN_in_atom4250);
                    LPAREN457_tree = this.adaptor.create(LPAREN457);
                    this.adaptor.addChild(root_0, LPAREN457_tree);
                    this.pushFollow(PLSQL2Parser.FOLLOW_expression_in_atom4252);
                    expression458 = this.expression();
                    final RecognizerSharedState state7 = this.state;
                    --state7._fsp;
                    this.adaptor.addChild(root_0, expression458.getTree());
                    RPAREN459 = (Token)this.match((IntStream)this.input, 12, PLSQL2Parser.FOLLOW_RPAREN_in_atom4254);
                    RPAREN459_tree = this.adaptor.create(RPAREN459);
                    this.adaptor.addChild(root_0, RPAREN459_tree);
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final variable_or_function_call_return variable_or_function_call() throws RecognitionException {
        final variable_or_function_call_return retval = new variable_or_function_call_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token DOT461 = null;
        Token DOT462 = null;
        call_return call460 = null;
        call_return call461 = null;
        delete_call_return delete_call464 = null;
        Object DOT461_tree = null;
        Object DOT463_tree = null;
        Label_0487: {
            try {
                root_0 = this.adaptor.nil();
                this.pushFollow(PLSQL2Parser.FOLLOW_call_in_variable_or_function_call4275);
                call460 = this.call();
                final RecognizerSharedState state = this.state;
                --state._fsp;
                this.adaptor.addChild(root_0, call460.getTree());
                while (true) {
                    int alt140 = 2;
                    final int LA140_0 = this.input.LA(1);
                    if (LA140_0 == 35) {
                        final int LA140_2 = this.input.LA(2);
                        if (LA140_2 == 7 || LA140_2 == 48) {
                            alt140 = 1;
                        }
                    }
                    switch (alt140) {
                        case 1: {
                            DOT461 = (Token)this.match((IntStream)this.input, 35, PLSQL2Parser.FOLLOW_DOT_in_variable_or_function_call4279);
                            DOT461_tree = this.adaptor.create(DOT461);
                            this.adaptor.addChild(root_0, DOT461_tree);
                            this.pushFollow(PLSQL2Parser.FOLLOW_call_in_variable_or_function_call4281);
                            call461 = this.call();
                            final RecognizerSharedState state2 = this.state;
                            --state2._fsp;
                            this.adaptor.addChild(root_0, call461.getTree());
                            continue;
                        }
                        default: {
                            int alt141 = 2;
                            final int LA141_0 = this.input.LA(1);
                            if (LA141_0 == 35) {
                                alt141 = 1;
                            }
                            switch (alt141) {
                                case 1: {
                                    DOT462 = (Token)this.match((IntStream)this.input, 35, PLSQL2Parser.FOLLOW_DOT_in_variable_or_function_call4288);
                                    DOT463_tree = this.adaptor.create(DOT462);
                                    this.adaptor.addChild(root_0, DOT463_tree);
                                    this.pushFollow(PLSQL2Parser.FOLLOW_delete_call_in_variable_or_function_call4290);
                                    delete_call464 = this.delete_call();
                                    final RecognizerSharedState state3 = this.state;
                                    --state3._fsp;
                                    this.adaptor.addChild(root_0, delete_call464.getTree());
                                    break;
                                }
                            }
                            retval.stop = this.input.LT(-1);
                            retval.tree = this.adaptor.rulePostProcessing(root_0);
                            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
                            break Label_0487;
                        }
                    }
                }
            }
            catch (RecognitionException re) {
                this.reportError(re);
                this.recover((IntStream)this.input, re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            }
        }
        return retval;
    }
    
    public final attribute_return attribute() throws RecognitionException {
        final attribute_return retval = new attribute_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token BULK_ROWCOUNT465 = null;
        Token LPAREN466 = null;
        Token RPAREN468 = null;
        Token ISOPEN470 = null;
        Token NOTFOUND471 = null;
        expression_return expression467 = null;
        kFOUND_return kFOUND469 = null;
        kROWCOUNT_return kROWCOUNT472 = null;
        Object BULK_ROWCOUNT465_tree = null;
        Object LPAREN466_tree = null;
        Object RPAREN468_tree = null;
        Object ISOPEN470_tree = null;
        Object NOTFOUND471_tree = null;
        try {
            int alt142 = 5;
            switch (this.input.LA(1)) {
                case 102: {
                    alt142 = 1;
                    break;
                }
                case 7: {
                    final int LA142_2 = this.input.LA(2);
                    if (this.input.LT(1).getText().equalsIgnoreCase("found")) {
                        alt142 = 2;
                        break;
                    }
                    if (this.input.LT(1).getText().equalsIgnoreCase("rowcount")) {
                        alt142 = 5;
                        break;
                    }
                    final NoViableAltException nvae = new NoViableAltException("", 142, 2, (IntStream)this.input);
                    throw nvae;
                }
                case 103: {
                    alt142 = 3;
                    break;
                }
                case 104: {
                    alt142 = 4;
                    break;
                }
                default: {
                    final NoViableAltException nvae2 = new NoViableAltException("", 142, 0, (IntStream)this.input);
                    throw nvae2;
                }
            }
            switch (alt142) {
                case 1: {
                    root_0 = this.adaptor.nil();
                    BULK_ROWCOUNT465 = (Token)this.match((IntStream)this.input, 102, PLSQL2Parser.FOLLOW_BULK_ROWCOUNT_in_attribute4310);
                    BULK_ROWCOUNT465_tree = this.adaptor.create(BULK_ROWCOUNT465);
                    this.adaptor.addChild(root_0, BULK_ROWCOUNT465_tree);
                    LPAREN466 = (Token)this.match((IntStream)this.input, 10, PLSQL2Parser.FOLLOW_LPAREN_in_attribute4312);
                    LPAREN466_tree = this.adaptor.create(LPAREN466);
                    this.adaptor.addChild(root_0, LPAREN466_tree);
                    this.pushFollow(PLSQL2Parser.FOLLOW_expression_in_attribute4314);
                    expression467 = this.expression();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    this.adaptor.addChild(root_0, expression467.getTree());
                    RPAREN468 = (Token)this.match((IntStream)this.input, 12, PLSQL2Parser.FOLLOW_RPAREN_in_attribute4316);
                    RPAREN468_tree = this.adaptor.create(RPAREN468);
                    this.adaptor.addChild(root_0, RPAREN468_tree);
                    break;
                }
                case 2: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_kFOUND_in_attribute4324);
                    kFOUND469 = this.kFOUND();
                    final RecognizerSharedState state2 = this.state;
                    --state2._fsp;
                    this.adaptor.addChild(root_0, kFOUND469.getTree());
                    break;
                }
                case 3: {
                    root_0 = this.adaptor.nil();
                    ISOPEN470 = (Token)this.match((IntStream)this.input, 103, PLSQL2Parser.FOLLOW_ISOPEN_in_attribute4332);
                    ISOPEN470_tree = this.adaptor.create(ISOPEN470);
                    this.adaptor.addChild(root_0, ISOPEN470_tree);
                    break;
                }
                case 4: {
                    root_0 = this.adaptor.nil();
                    NOTFOUND471 = (Token)this.match((IntStream)this.input, 104, PLSQL2Parser.FOLLOW_NOTFOUND_in_attribute4340);
                    NOTFOUND471_tree = this.adaptor.create(NOTFOUND471);
                    this.adaptor.addChild(root_0, NOTFOUND471_tree);
                    break;
                }
                case 5: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_kROWCOUNT_in_attribute4348);
                    kROWCOUNT472 = this.kROWCOUNT();
                    final RecognizerSharedState state3 = this.state;
                    --state3._fsp;
                    this.adaptor.addChild(root_0, kROWCOUNT472.getTree());
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final call_args_return call_args() throws RecognitionException {
        final call_args_return retval = new call_args_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token LPAREN473 = null;
        Token COMMA475 = null;
        Token RPAREN477 = null;
        parameter_return parameter474 = null;
        parameter_return parameter475 = null;
        Object LPAREN473_tree = null;
        Object COMMA475_tree = null;
        Object RPAREN477_tree = null;
        try {
            root_0 = this.adaptor.nil();
            LPAREN473 = (Token)this.match((IntStream)this.input, 10, PLSQL2Parser.FOLLOW_LPAREN_in_call_args4365);
            LPAREN473_tree = this.adaptor.create(LPAREN473);
            this.adaptor.addChild(root_0, LPAREN473_tree);
            int alt144 = 2;
            final int LA144_0 = this.input.LA(1);
            if (LA144_0 == 7 || LA144_0 == 10 || (LA144_0 >= 20 && LA144_0 <= 21) || LA144_0 == 48 || (LA144_0 >= 96 && LA144_0 <= 97) || LA144_0 == 101 || (LA144_0 >= 105 && LA144_0 <= 109) || (LA144_0 >= 111 && LA144_0 <= 113)) {
                alt144 = 1;
            }
            Label_0395: {
                switch (alt144) {
                    case 1: {
                        this.pushFollow(PLSQL2Parser.FOLLOW_parameter_in_call_args4369);
                        parameter474 = this.parameter();
                        final RecognizerSharedState state = this.state;
                        --state._fsp;
                        this.adaptor.addChild(root_0, parameter474.getTree());
                        while (true) {
                            int alt145 = 2;
                            final int LA143_0 = this.input.LA(1);
                            if (LA143_0 == 11) {
                                alt145 = 1;
                            }
                            switch (alt145) {
                                case 1: {
                                    COMMA475 = (Token)this.match((IntStream)this.input, 11, PLSQL2Parser.FOLLOW_COMMA_in_call_args4373);
                                    COMMA475_tree = this.adaptor.create(COMMA475);
                                    this.adaptor.addChild(root_0, COMMA475_tree);
                                    this.pushFollow(PLSQL2Parser.FOLLOW_parameter_in_call_args4375);
                                    parameter475 = this.parameter();
                                    final RecognizerSharedState state2 = this.state;
                                    --state2._fsp;
                                    this.adaptor.addChild(root_0, parameter475.getTree());
                                    continue;
                                }
                                default: {
                                    break Label_0395;
                                }
                            }
                        }
                        /*break;*/
                    }
                }
            }
            RPAREN477 = (Token)this.match((IntStream)this.input, 12, PLSQL2Parser.FOLLOW_RPAREN_in_call_args4383);
            RPAREN477_tree = this.adaptor.create(RPAREN477);
            this.adaptor.addChild(root_0, RPAREN477_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final boolean_atom_return boolean_atom() throws RecognitionException {
        final boolean_atom_return retval = new boolean_atom_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        boolean_literal_return boolean_literal478 = null;
        collection_exists_return collection_exists479 = null;
        conditional_predicate_return conditional_predicate480 = null;
        try {
            int alt145 = 3;
            switch (this.input.LA(1)) {
                case 107:
                case 108: {
                    alt145 = 1;
                    break;
                }
                case 7: {
                    alt145 = 2;
                    break;
                }
                case 111:
                case 112:
                case 113: {
                    alt145 = 3;
                    break;
                }
                default: {
                    final NoViableAltException nvae = new NoViableAltException("", 145, 0, (IntStream)this.input);
                    throw nvae;
                }
            }
            switch (alt145) {
                case 1: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_boolean_literal_in_boolean_atom4400);
                    boolean_literal478 = this.boolean_literal();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    this.adaptor.addChild(root_0, boolean_literal478.getTree());
                    break;
                }
                case 2: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_collection_exists_in_boolean_atom4408);
                    collection_exists479 = this.collection_exists();
                    final RecognizerSharedState state2 = this.state;
                    --state2._fsp;
                    this.adaptor.addChild(root_0, collection_exists479.getTree());
                    break;
                }
                case 3: {
                    root_0 = this.adaptor.nil();
                    this.pushFollow(PLSQL2Parser.FOLLOW_conditional_predicate_in_boolean_atom4416);
                    conditional_predicate480 = this.conditional_predicate();
                    final RecognizerSharedState state3 = this.state;
                    --state3._fsp;
                    this.adaptor.addChild(root_0, conditional_predicate480.getTree());
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final numeric_atom_return numeric_atom() throws RecognitionException {
        final numeric_atom_return retval = new numeric_atom_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        numeric_literal_return numeric_literal481 = null;
        try {
            root_0 = this.adaptor.nil();
            this.pushFollow(PLSQL2Parser.FOLLOW_numeric_literal_in_numeric_atom4433);
            numeric_literal481 = this.numeric_literal();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, numeric_literal481.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final numeric_literal_return numeric_literal() throws RecognitionException {
        final numeric_literal_return retval = new numeric_literal_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token set482 = null;
        final Object set482_tree = null;
        try {
            root_0 = this.adaptor.nil();
            set482 = this.input.LT(1);
            if (this.input.LA(1) < 105 || this.input.LA(1) > 106) {
                final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                throw mse;
            }
            this.input.consume();
            this.adaptor.addChild(root_0, this.adaptor.create(set482));
            this.state.errorRecovery = false;
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final boolean_literal_return boolean_literal() throws RecognitionException {
        final boolean_literal_return retval = new boolean_literal_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token set483 = null;
        final Object set483_tree = null;
        try {
            root_0 = this.adaptor.nil();
            set483 = this.input.LT(1);
            if (this.input.LA(1) < 107 || this.input.LA(1) > 108) {
                final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                throw mse;
            }
            this.input.consume();
            this.adaptor.addChild(root_0, this.adaptor.create(set483));
            this.state.errorRecovery = false;
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final string_literal_return string_literal() throws RecognitionException {
        final string_literal_return retval = new string_literal_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token QUOTED_STRING484 = null;
        Object QUOTED_STRING484_tree = null;
        try {
            root_0 = this.adaptor.nil();
            QUOTED_STRING484 = (Token)this.match((IntStream)this.input, 109, PLSQL2Parser.FOLLOW_QUOTED_STRING_in_string_literal4500);
            QUOTED_STRING484_tree = this.adaptor.create(QUOTED_STRING484);
            this.adaptor.addChild(root_0, QUOTED_STRING484_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final collection_exists_return collection_exists() throws RecognitionException {
        final collection_exists_return retval = new collection_exists_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ID485 = null;
        Token DOT486 = null;
        Token EXISTS487 = null;
        Token LPAREN488 = null;
        Token RPAREN490 = null;
        expression_return expression489 = null;
        Object ID485_tree = null;
        Object DOT486_tree = null;
        Object EXISTS487_tree = null;
        Object LPAREN488_tree = null;
        Object RPAREN490_tree = null;
        try {
            root_0 = this.adaptor.nil();
            ID485 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_collection_exists4517);
            ID485_tree = this.adaptor.create(ID485);
            this.adaptor.addChild(root_0, ID485_tree);
            DOT486 = (Token)this.match((IntStream)this.input, 35, PLSQL2Parser.FOLLOW_DOT_in_collection_exists4519);
            DOT486_tree = this.adaptor.create(DOT486);
            this.adaptor.addChild(root_0, DOT486_tree);
            EXISTS487 = (Token)this.match((IntStream)this.input, 110, PLSQL2Parser.FOLLOW_EXISTS_in_collection_exists4521);
            EXISTS487_tree = this.adaptor.create(EXISTS487);
            this.adaptor.addChild(root_0, EXISTS487_tree);
            LPAREN488 = (Token)this.match((IntStream)this.input, 10, PLSQL2Parser.FOLLOW_LPAREN_in_collection_exists4523);
            LPAREN488_tree = this.adaptor.create(LPAREN488);
            this.adaptor.addChild(root_0, LPAREN488_tree);
            this.pushFollow(PLSQL2Parser.FOLLOW_expression_in_collection_exists4525);
            expression489 = this.expression();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, expression489.getTree());
            RPAREN490 = (Token)this.match((IntStream)this.input, 12, PLSQL2Parser.FOLLOW_RPAREN_in_collection_exists4527);
            RPAREN490_tree = this.adaptor.create(RPAREN490);
            this.adaptor.addChild(root_0, RPAREN490_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final conditional_predicate_return conditional_predicate() throws RecognitionException {
        final conditional_predicate_return retval = new conditional_predicate_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token INSERTING491 = null;
        Token UPDATING492 = null;
        Token LPAREN493 = null;
        Token QUOTED_STRING494 = null;
        Token RPAREN495 = null;
        Token DELETING496 = null;
        Object INSERTING491_tree = null;
        Object UPDATING492_tree = null;
        Object LPAREN493_tree = null;
        Object QUOTED_STRING494_tree = null;
        Object RPAREN495_tree = null;
        Object DELETING496_tree = null;
        try {
            int alt147 = 3;
            switch (this.input.LA(1)) {
                case 111: {
                    alt147 = 1;
                    break;
                }
                case 112: {
                    alt147 = 2;
                    break;
                }
                case 113: {
                    alt147 = 3;
                    break;
                }
                default: {
                    final NoViableAltException nvae = new NoViableAltException("", 147, 0, (IntStream)this.input);
                    throw nvae;
                }
            }
            switch (alt147) {
                case 1: {
                    root_0 = this.adaptor.nil();
                    INSERTING491 = (Token)this.match((IntStream)this.input, 111, PLSQL2Parser.FOLLOW_INSERTING_in_conditional_predicate4544);
                    INSERTING491_tree = this.adaptor.create(INSERTING491);
                    this.adaptor.addChild(root_0, INSERTING491_tree);
                    break;
                }
                case 2: {
                    root_0 = this.adaptor.nil();
                    UPDATING492 = (Token)this.match((IntStream)this.input, 112, PLSQL2Parser.FOLLOW_UPDATING_in_conditional_predicate4552);
                    UPDATING492_tree = this.adaptor.create(UPDATING492);
                    this.adaptor.addChild(root_0, UPDATING492_tree);
                    int alt148 = 2;
                    final int LA146_0 = this.input.LA(1);
                    if (LA146_0 == 10) {
                        alt148 = 1;
                    }
                    switch (alt148) {
                        case 1: {
                            LPAREN493 = (Token)this.match((IntStream)this.input, 10, PLSQL2Parser.FOLLOW_LPAREN_in_conditional_predicate4556);
                            LPAREN493_tree = this.adaptor.create(LPAREN493);
                            this.adaptor.addChild(root_0, LPAREN493_tree);
                            QUOTED_STRING494 = (Token)this.match((IntStream)this.input, 109, PLSQL2Parser.FOLLOW_QUOTED_STRING_in_conditional_predicate4558);
                            QUOTED_STRING494_tree = this.adaptor.create(QUOTED_STRING494);
                            this.adaptor.addChild(root_0, QUOTED_STRING494_tree);
                            RPAREN495 = (Token)this.match((IntStream)this.input, 12, PLSQL2Parser.FOLLOW_RPAREN_in_conditional_predicate4560);
                            RPAREN495_tree = this.adaptor.create(RPAREN495);
                            this.adaptor.addChild(root_0, RPAREN495_tree);
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    root_0 = this.adaptor.nil();
                    DELETING496 = (Token)this.match((IntStream)this.input, 113, PLSQL2Parser.FOLLOW_DELETING_in_conditional_predicate4571);
                    DELETING496_tree = this.adaptor.create(DELETING496);
                    this.adaptor.addChild(root_0, DELETING496_tree);
                    break;
                }
            }
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final parameter_return parameter() throws RecognitionException {
        final parameter_return retval = new parameter_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ID497 = null;
        Token ARROW498 = null;
        expression_return expression499 = null;
        Object ID497_tree = null;
        Object ARROW498_tree = null;
        try {
            root_0 = this.adaptor.nil();
            int alt148 = 2;
            final int LA148_0 = this.input.LA(1);
            if (LA148_0 == 7) {
                final int LA148_2 = this.input.LA(2);
                if (LA148_2 == 114) {
                    alt148 = 1;
                }
            }
            switch (alt148) {
                case 1: {
                    ID497 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_parameter4590);
                    ID497_tree = this.adaptor.create(ID497);
                    this.adaptor.addChild(root_0, ID497_tree);
                    ARROW498 = (Token)this.match((IntStream)this.input, 114, PLSQL2Parser.FOLLOW_ARROW_in_parameter4592);
                    ARROW498_tree = this.adaptor.create(ARROW498);
                    this.adaptor.addChild(root_0, ARROW498_tree);
                    break;
                }
            }
            this.pushFollow(PLSQL2Parser.FOLLOW_expression_in_parameter4597);
            expression499 = this.expression();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, expression499.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final index_return index() throws RecognitionException {
        final index_return retval = new index_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        expression_return expression500 = null;
        try {
            root_0 = this.adaptor.nil();
            this.pushFollow(PLSQL2Parser.FOLLOW_expression_in_index4614);
            expression500 = this.expression();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, expression500.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final create_package_return create_package() throws RecognitionException {
        final create_package_return retval = new create_package_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token CREATE501 = null;
        Token OR502 = null;
        Token PACKAGE504 = null;
        Token IS507 = null;
        Token AS508 = null;
        Token END510 = null;
        Token ID511 = null;
        Token SEMI512 = null;
        kREPLACE_return kREPLACE503 = null;
        package_full_name_return package_full_name505 = null;
        invoker_rights_clause_return invoker_rights_clause506 = null;
        declare_section_return declare_section509 = null;
        final Object CREATE501_tree = null;
        final Object OR502_tree = null;
        final Object PACKAGE504_tree = null;
        final Object IS507_tree = null;
        final Object AS508_tree = null;
        final Object END510_tree = null;
        final Object ID511_tree = null;
        final Object SEMI512_tree = null;
        final RewriteRuleTokenStream stream_PACKAGE = new RewriteRuleTokenStream(this.adaptor, "token PACKAGE");
        final RewriteRuleTokenStream stream_AS = new RewriteRuleTokenStream(this.adaptor, "token AS");
        final RewriteRuleTokenStream stream_CREATE = new RewriteRuleTokenStream(this.adaptor, "token CREATE");
        final RewriteRuleTokenStream stream_END = new RewriteRuleTokenStream(this.adaptor, "token END");
        final RewriteRuleTokenStream stream_ID = new RewriteRuleTokenStream(this.adaptor, "token ID");
        final RewriteRuleTokenStream stream_IS = new RewriteRuleTokenStream(this.adaptor, "token IS");
        final RewriteRuleTokenStream stream_SEMI = new RewriteRuleTokenStream(this.adaptor, "token SEMI");
        final RewriteRuleTokenStream stream_OR = new RewriteRuleTokenStream(this.adaptor, "token OR");
        final RewriteRuleSubtreeStream stream_package_full_name = new RewriteRuleSubtreeStream(this.adaptor, "rule package_full_name");
        final RewriteRuleSubtreeStream stream_invoker_rights_clause = new RewriteRuleSubtreeStream(this.adaptor, "rule invoker_rights_clause");
        final RewriteRuleSubtreeStream stream_declare_section = new RewriteRuleSubtreeStream(this.adaptor, "rule declare_section");
        final RewriteRuleSubtreeStream stream_kREPLACE = new RewriteRuleSubtreeStream(this.adaptor, "rule kREPLACE");
        try {
            CREATE501 = (Token)this.match((IntStream)this.input, 115, PLSQL2Parser.FOLLOW_CREATE_in_create_package4635);
            stream_CREATE.add((Object)CREATE501);
            int alt149 = 2;
            final int LA149_0 = this.input.LA(1);
            if (LA149_0 == 45) {
                alt149 = 1;
            }
            switch (alt149) {
                case 1: {
                    OR502 = (Token)this.match((IntStream)this.input, 45, PLSQL2Parser.FOLLOW_OR_in_create_package4639);
                    stream_OR.add((Object)OR502);
                    this.pushFollow(PLSQL2Parser.FOLLOW_kREPLACE_in_create_package4641);
                    kREPLACE503 = this.kREPLACE();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    stream_kREPLACE.add(kREPLACE503.getTree());
                    break;
                }
            }
            PACKAGE504 = (Token)this.match((IntStream)this.input, 116, PLSQL2Parser.FOLLOW_PACKAGE_in_create_package4646);
            stream_PACKAGE.add((Object)PACKAGE504);
            this.pushFollow(PLSQL2Parser.FOLLOW_package_full_name_in_create_package4648);
            package_full_name505 = this.package_full_name();
            final RecognizerSharedState state2 = this.state;
            --state2._fsp;
            stream_package_full_name.add(package_full_name505.getTree());
            int alt150 = 2;
            final int LA150_0 = this.input.LA(1);
            if (LA150_0 == 119) {
                alt150 = 1;
            }
            switch (alt150) {
                case 1: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_invoker_rights_clause_in_create_package4660);
                    invoker_rights_clause506 = this.invoker_rights_clause();
                    final RecognizerSharedState state3 = this.state;
                    --state3._fsp;
                    stream_invoker_rights_clause.add(invoker_rights_clause506.getTree());
                    break;
                }
            }
            int alt151 = 2;
            final int LA151_0 = this.input.LA(1);
            if (LA151_0 == 19) {
                alt151 = 1;
            }
            else {
                if (LA151_0 != 24) {
                    final NoViableAltException nvae = new NoViableAltException("", 151, 0, (IntStream)this.input);
                    throw nvae;
                }
                alt151 = 2;
            }
            switch (alt151) {
                case 1: {
                    IS507 = (Token)this.match((IntStream)this.input, 19, PLSQL2Parser.FOLLOW_IS_in_create_package4675);
                    stream_IS.add((Object)IS507);
                    break;
                }
                case 2: {
                    AS508 = (Token)this.match((IntStream)this.input, 24, PLSQL2Parser.FOLLOW_AS_in_create_package4679);
                    stream_AS.add((Object)AS508);
                    break;
                }
            }
            int alt152 = 2;
            final int LA152_0 = this.input.LA(1);
            if ((LA152_0 >= 6 && LA152_0 <= 8) || LA152_0 == 18 || LA152_0 == 25 || LA152_0 == 74) {
                alt152 = 1;
            }
            switch (alt152) {
                case 1: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_declare_section_in_create_package4685);
                    declare_section509 = this.declare_section();
                    final RecognizerSharedState state4 = this.state;
                    --state4._fsp;
                    stream_declare_section.add(declare_section509.getTree());
                    break;
                }
            }
            END510 = (Token)this.match((IntStream)this.input, 43, PLSQL2Parser.FOLLOW_END_in_create_package4690);
            stream_END.add((Object)END510);
            int alt153 = 2;
            final int LA153_0 = this.input.LA(1);
            if (LA153_0 == 7) {
                alt153 = 1;
            }
            switch (alt153) {
                case 1: {
                    ID511 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_create_package4694);
                    stream_ID.add((Object)ID511);
                    break;
                }
            }
            SEMI512 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_create_package4699);
            stream_SEMI.add((Object)SEMI512);
            retval.tree = root_0;
            final RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(this.adaptor, "rule retval", (retval != null) ? retval.tree : null);
            root_0 = this.adaptor.nil();
            Object root_2 = this.adaptor.nil();
            root_2 = this.adaptor.becomeRoot(stream_PACKAGE.nextNode(), root_2);
            this.adaptor.addChild(root_2, stream_package_full_name.nextTree());
            if (stream_declare_section.hasNext()) {
                this.adaptor.addChild(root_2, stream_declare_section.nextTree());
            }
            stream_declare_section.reset();
            this.adaptor.addChild(root_0, root_2);
            retval.tree = root_0;
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final package_full_name_return package_full_name() throws RecognitionException {
        final package_full_name_return retval = new package_full_name_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token schema_name = null;
        Token package_name = null;
        Token DOT513 = null;
        Object schema_name_tree = null;
        Object package_name_tree = null;
        Object DOT513_tree = null;
        try {
            root_0 = this.adaptor.nil();
            int alt154 = 2;
            final int LA154_0 = this.input.LA(1);
            if (LA154_0 == 7) {
                final int LA154_2 = this.input.LA(2);
                if (LA154_2 == 35) {
                    alt154 = 1;
                }
            }
            switch (alt154) {
                case 1: {
                    schema_name = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_package_full_name4733);
                    schema_name_tree = this.adaptor.create(schema_name);
                    this.adaptor.addChild(root_0, schema_name_tree);
                    DOT513 = (Token)this.match((IntStream)this.input, 35, PLSQL2Parser.FOLLOW_DOT_in_package_full_name4735);
                    DOT513_tree = this.adaptor.create(DOT513);
                    this.adaptor.addChild(root_0, DOT513_tree);
                    break;
                }
            }
            package_name = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_package_full_name4742);
            package_name_tree = this.adaptor.create(package_name);
            this.adaptor.addChild(root_0, package_name_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final create_package_body_return create_package_body() throws RecognitionException {
        final create_package_body_return retval = new create_package_body_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token schema_name = null;
        Token package_name = null;
        Token package_name2 = null;
        Token CREATE514 = null;
        Token OR515 = null;
        Token PACKAGE517 = null;
        Token BODY518 = null;
        Token DOT519 = null;
        Token set520 = null;
        Token END522 = null;
        Token SEMI523 = null;
        body_return initialize_section = null;
        kREPLACE_return kREPLACE516 = null;
        declare_section_return declare_section521 = null;
        Object schema_name_tree = null;
        Object package_name_tree = null;
        Object package_name2_tree = null;
        Object CREATE514_tree = null;
        Object OR515_tree = null;
        Object PACKAGE517_tree = null;
        Object BODY518_tree = null;
        Object DOT519_tree = null;
        final Object set520_tree = null;
        Object END522_tree = null;
        Object SEMI523_tree = null;
        try {
            root_0 = this.adaptor.nil();
            CREATE514 = (Token)this.match((IntStream)this.input, 115, PLSQL2Parser.FOLLOW_CREATE_in_create_package_body4767);
            CREATE514_tree = this.adaptor.create(CREATE514);
            this.adaptor.addChild(root_0, CREATE514_tree);
            int alt155 = 2;
            final int LA155_0 = this.input.LA(1);
            if (LA155_0 == 45) {
                alt155 = 1;
            }
            switch (alt155) {
                case 1: {
                    OR515 = (Token)this.match((IntStream)this.input, 45, PLSQL2Parser.FOLLOW_OR_in_create_package_body4771);
                    OR515_tree = this.adaptor.create(OR515);
                    this.adaptor.addChild(root_0, OR515_tree);
                    this.pushFollow(PLSQL2Parser.FOLLOW_kREPLACE_in_create_package_body4773);
                    kREPLACE516 = this.kREPLACE();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    this.adaptor.addChild(root_0, kREPLACE516.getTree());
                    break;
                }
            }
            PACKAGE517 = (Token)this.match((IntStream)this.input, 116, PLSQL2Parser.FOLLOW_PACKAGE_in_create_package_body4778);
            PACKAGE517_tree = this.adaptor.create(PACKAGE517);
            this.adaptor.addChild(root_0, PACKAGE517_tree);
            BODY518 = (Token)this.match((IntStream)this.input, 117, PLSQL2Parser.FOLLOW_BODY_in_create_package_body4780);
            BODY518_tree = this.adaptor.create(BODY518);
            this.adaptor.addChild(root_0, BODY518_tree);
            int alt156 = 2;
            final int LA156_0 = this.input.LA(1);
            if (LA156_0 == 7) {
                final int LA156_2 = this.input.LA(2);
                if (LA156_2 == 35) {
                    alt156 = 1;
                }
            }
            switch (alt156) {
                case 1: {
                    schema_name = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_create_package_body4786);
                    schema_name_tree = this.adaptor.create(schema_name);
                    this.adaptor.addChild(root_0, schema_name_tree);
                    DOT519 = (Token)this.match((IntStream)this.input, 35, PLSQL2Parser.FOLLOW_DOT_in_create_package_body4788);
                    DOT519_tree = this.adaptor.create(DOT519);
                    this.adaptor.addChild(root_0, DOT519_tree);
                    break;
                }
            }
            package_name = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_create_package_body4795);
            package_name_tree = this.adaptor.create(package_name);
            this.adaptor.addChild(root_0, package_name_tree);
            set520 = this.input.LT(1);
            if (this.input.LA(1) != 19 && this.input.LA(1) != 24) {
                final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                throw mse;
            }
            this.input.consume();
            this.adaptor.addChild(root_0, this.adaptor.create(set520));
            this.state.errorRecovery = false;
            int alt157 = 2;
            final int LA157_0 = this.input.LA(1);
            if ((LA157_0 >= 6 && LA157_0 <= 8) || LA157_0 == 18 || LA157_0 == 25 || LA157_0 == 74) {
                alt157 = 1;
            }
            switch (alt157) {
                case 1: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_declare_section_in_create_package_body4817);
                    declare_section521 = this.declare_section();
                    final RecognizerSharedState state2 = this.state;
                    --state2._fsp;
                    this.adaptor.addChild(root_0, declare_section521.getTree());
                    break;
                }
            }
            int alt158 = 2;
            final int LA159_0 = this.input.LA(1);
            if (LA159_0 == 42) {
                alt158 = 1;
            }
            else {
                if (LA159_0 != 43) {
                    final NoViableAltException nvae = new NoViableAltException("", 159, 0, (IntStream)this.input);
                    throw nvae;
                }
                alt158 = 2;
            }
            Label_1035: {
                switch (alt158) {
                    case 1: {
                        this.pushFollow(PLSQL2Parser.FOLLOW_body_in_create_package_body4834);
                        initialize_section = this.body();
                        final RecognizerSharedState state3 = this.state;
                        --state3._fsp;
                        this.adaptor.addChild(root_0, initialize_section.getTree());
                        break;
                    }
                    case 2: {
                        END522 = (Token)this.match((IntStream)this.input, 43, PLSQL2Parser.FOLLOW_END_in_create_package_body4838);
                        END522_tree = this.adaptor.create(END522);
                        this.adaptor.addChild(root_0, END522_tree);
                        int alt159 = 2;
                        final int LA158_0 = this.input.LA(1);
                        if (LA158_0 == 7) {
                            alt159 = 1;
                        }
                        switch (alt159) {
                            case 1: {
                                package_name2 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_create_package_body4844);
                                package_name2_tree = this.adaptor.create(package_name2);
                                this.adaptor.addChild(root_0, package_name2_tree);
                                break Label_1035;
                            }
                        }
                        break;
                    }
                }
            }
            SEMI523 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_create_package_body4859);
            SEMI523_tree = this.adaptor.create(SEMI523);
            this.adaptor.addChild(root_0, SEMI523_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final create_procedure_return create_procedure() throws RecognitionException {
        final create_procedure_return retval = new create_procedure_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token schema_name = null;
        Token procedure_name = null;
        Token CREATE524 = null;
        Token OR525 = null;
        Token PROCEDURE527 = null;
        Token DOT528 = null;
        Token IS531 = null;
        Token AS532 = null;
        Token EXTERNAL536 = null;
        Token SEMI537 = null;
        kREPLACE_return kREPLACE526 = null;
        parameter_declarations_return parameter_declarations529 = null;
        invoker_rights_clause_return invoker_rights_clause530 = null;
        declare_section_return declare_section533 = null;
        body_return body534 = null;
        call_spec_return call_spec535 = null;
        final Object schema_name_tree = null;
        final Object procedure_name_tree = null;
        final Object CREATE524_tree = null;
        final Object OR525_tree = null;
        final Object PROCEDURE527_tree = null;
        final Object DOT528_tree = null;
        final Object IS531_tree = null;
        final Object AS532_tree = null;
        final Object EXTERNAL536_tree = null;
        final Object SEMI537_tree = null;
        final RewriteRuleTokenStream stream_AS = new RewriteRuleTokenStream(this.adaptor, "token AS");
        final RewriteRuleTokenStream stream_EXTERNAL = new RewriteRuleTokenStream(this.adaptor, "token EXTERNAL");
        final RewriteRuleTokenStream stream_CREATE = new RewriteRuleTokenStream(this.adaptor, "token CREATE");
        final RewriteRuleTokenStream stream_ID = new RewriteRuleTokenStream(this.adaptor, "token ID");
        final RewriteRuleTokenStream stream_DOT = new RewriteRuleTokenStream(this.adaptor, "token DOT");
        final RewriteRuleTokenStream stream_IS = new RewriteRuleTokenStream(this.adaptor, "token IS");
        final RewriteRuleTokenStream stream_SEMI = new RewriteRuleTokenStream(this.adaptor, "token SEMI");
        final RewriteRuleTokenStream stream_PROCEDURE = new RewriteRuleTokenStream(this.adaptor, "token PROCEDURE");
        final RewriteRuleTokenStream stream_OR = new RewriteRuleTokenStream(this.adaptor, "token OR");
        final RewriteRuleSubtreeStream stream_body = new RewriteRuleSubtreeStream(this.adaptor, "rule body");
        final RewriteRuleSubtreeStream stream_invoker_rights_clause = new RewriteRuleSubtreeStream(this.adaptor, "rule invoker_rights_clause");
        final RewriteRuleSubtreeStream stream_call_spec = new RewriteRuleSubtreeStream(this.adaptor, "rule call_spec");
        final RewriteRuleSubtreeStream stream_parameter_declarations = new RewriteRuleSubtreeStream(this.adaptor, "rule parameter_declarations");
        final RewriteRuleSubtreeStream stream_declare_section = new RewriteRuleSubtreeStream(this.adaptor, "rule declare_section");
        final RewriteRuleSubtreeStream stream_kREPLACE = new RewriteRuleSubtreeStream(this.adaptor, "rule kREPLACE");
        try {
            retval.r_procedureDef = new HashMap();
            CREATE524 = (Token)this.match((IntStream)this.input, 115, PLSQL2Parser.FOLLOW_CREATE_in_create_procedure4885);
            stream_CREATE.add((Object)CREATE524);
            int alt160 = 2;
            final int LA160_0 = this.input.LA(1);
            if (LA160_0 == 45) {
                alt160 = 1;
            }
            switch (alt160) {
                case 1: {
                    OR525 = (Token)this.match((IntStream)this.input, 45, PLSQL2Parser.FOLLOW_OR_in_create_procedure4889);
                    stream_OR.add((Object)OR525);
                    this.pushFollow(PLSQL2Parser.FOLLOW_kREPLACE_in_create_procedure4891);
                    kREPLACE526 = this.kREPLACE();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    stream_kREPLACE.add(kREPLACE526.getTree());
                    break;
                }
            }
            PROCEDURE527 = (Token)this.match((IntStream)this.input, 6, PLSQL2Parser.FOLLOW_PROCEDURE_in_create_procedure4896);
            stream_PROCEDURE.add((Object)PROCEDURE527);
            int alt161 = 2;
            final int LA161_0 = this.input.LA(1);
            if (LA161_0 == 7) {
                final int LA161_2 = this.input.LA(2);
                if (LA161_2 == 35) {
                    alt161 = 1;
                }
            }
            switch (alt161) {
                case 1: {
                    schema_name = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_create_procedure4902);
                    stream_ID.add((Object)schema_name);
                    DOT528 = (Token)this.match((IntStream)this.input, 35, PLSQL2Parser.FOLLOW_DOT_in_create_procedure4904);
                    stream_DOT.add((Object)DOT528);
                    break;
                }
            }
            procedure_name = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_create_procedure4911);
            stream_ID.add((Object)procedure_name);
            retval.r_procedureDef.put("id", (procedure_name != null) ? procedure_name.getText() : null);
            int alt162 = 2;
            final int LA162_0 = this.input.LA(1);
            if (LA162_0 == 10) {
                alt162 = 1;
            }
            switch (alt162) {
                case 1: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_parameter_declarations_in_create_procedure4931);
                    parameter_declarations529 = this.parameter_declarations();
                    final RecognizerSharedState state2 = this.state;
                    --state2._fsp;
                    stream_parameter_declarations.add(parameter_declarations529.getTree());
                    break;
                }
            }
            retval.r_procedureDef.put("paramList", (parameter_declarations529 != null) ? parameter_declarations529.r_parameter_list : null);
            this.m_procedureList.add(retval.r_procedureDef);
            int alt163 = 2;
            final int LA163_0 = this.input.LA(1);
            if (LA163_0 == 119) {
                alt163 = 1;
            }
            switch (alt163) {
                case 1: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_invoker_rights_clause_in_create_procedure4963);
                    invoker_rights_clause530 = this.invoker_rights_clause();
                    final RecognizerSharedState state3 = this.state;
                    --state3._fsp;
                    stream_invoker_rights_clause.add(invoker_rights_clause530.getTree());
                    break;
                }
            }
            int alt164 = 2;
            final int LA164_0 = this.input.LA(1);
            if (LA164_0 == 19) {
                alt164 = 1;
            }
            else {
                if (LA164_0 != 24) {
                    final NoViableAltException nvae = new NoViableAltException("", 164, 0, (IntStream)this.input);
                    throw nvae;
                }
                alt164 = 2;
            }
            switch (alt164) {
                case 1: {
                    IS531 = (Token)this.match((IntStream)this.input, 19, PLSQL2Parser.FOLLOW_IS_in_create_procedure4976);
                    stream_IS.add((Object)IS531);
                    break;
                }
                case 2: {
                    AS532 = (Token)this.match((IntStream)this.input, 24, PLSQL2Parser.FOLLOW_AS_in_create_procedure4980);
                    stream_AS.add((Object)AS532);
                    break;
                }
            }
            int alt165 = 3;
            switch (this.input.LA(1)) {
                case 6:
                case 7:
                case 8:
                case 18:
                case 25:
                case 42:
                case 74: {
                    alt165 = 1;
                    break;
                }
                case 122: {
                    alt165 = 2;
                    break;
                }
                case 118: {
                    alt165 = 3;
                    break;
                }
                default: {
                    final NoViableAltException nvae2 = new NoViableAltException("", 166, 0, (IntStream)this.input);
                    throw nvae2;
                }
            }
            switch (alt165) {
                case 1: {
                    int alt166 = 2;
                    final int LA165_0 = this.input.LA(1);
                    if ((LA165_0 >= 6 && LA165_0 <= 8) || LA165_0 == 18 || LA165_0 == 25 || LA165_0 == 74) {
                        alt166 = 1;
                    }
                    switch (alt166) {
                        case 1: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_declare_section_in_create_procedure4994);
                            declare_section533 = this.declare_section();
                            final RecognizerSharedState state4 = this.state;
                            --state4._fsp;
                            stream_declare_section.add(declare_section533.getTree());
                            break;
                        }
                    }
                    this.pushFollow(PLSQL2Parser.FOLLOW_body_in_create_procedure4997);
                    body534 = this.body();
                    final RecognizerSharedState state5 = this.state;
                    --state5._fsp;
                    stream_body.add(body534.getTree());
                    break;
                }
                case 2: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_call_spec_in_create_procedure5011);
                    call_spec535 = this.call_spec();
                    final RecognizerSharedState state6 = this.state;
                    --state6._fsp;
                    stream_call_spec.add(call_spec535.getTree());
                    break;
                }
                case 3: {
                    EXTERNAL536 = (Token)this.match((IntStream)this.input, 118, PLSQL2Parser.FOLLOW_EXTERNAL_in_create_procedure5038);
                    stream_EXTERNAL.add((Object)EXTERNAL536);
                    break;
                }
            }
            SEMI537 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_create_procedure5067);
            stream_SEMI.add((Object)SEMI537);
            retval.tree = root_0;
            final RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(this.adaptor, "rule retval", (retval != null) ? retval.tree : null);
            root_0 = this.adaptor.nil();
            Object root_2 = this.adaptor.nil();
            root_2 = this.adaptor.becomeRoot(stream_ID.nextNode(), root_2);
            this.adaptor.addChild(root_2, stream_parameter_declarations.nextTree());
            this.adaptor.addChild(root_0, root_2);
            retval.tree = root_0;
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final create_function_return create_function() throws RecognitionException {
        final create_function_return retval = new create_function_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token schema_name = null;
        Token function_name = null;
        Token CREATE538 = null;
        Token OR539 = null;
        Token FUNCTION541 = null;
        Token DOT542 = null;
        Token RETURN543 = null;
        Token set546 = null;
        Token EXTERNAL550 = null;
        Token SEMI551 = null;
        parameter_declarations_return temp9 = null;
        kREPLACE_return kREPLACE540 = null;
        datatype_return datatype544 = null;
        invoker_rights_clause_return invoker_rights_clause545 = null;
        declare_section_return declare_section547 = null;
        body_return body548 = null;
        call_spec_return call_spec549 = null;
        Object schema_name_tree = null;
        Object function_name_tree = null;
        Object CREATE538_tree = null;
        Object OR539_tree = null;
        Object FUNCTION541_tree = null;
        Object DOT542_tree = null;
        Object RETURN543_tree = null;
        final Object set546_tree = null;
        Object EXTERNAL550_tree = null;
        Object SEMI551_tree = null;
        try {
            root_0 = this.adaptor.nil();
            retval.r_functionDef = new HashMap();
            CREATE538 = (Token)this.match((IntStream)this.input, 115, PLSQL2Parser.FOLLOW_CREATE_in_create_function5109);
            CREATE538_tree = this.adaptor.create(CREATE538);
            this.adaptor.addChild(root_0, CREATE538_tree);
            int alt167 = 2;
            final int LA167_0 = this.input.LA(1);
            if (LA167_0 == 45) {
                alt167 = 1;
            }
            switch (alt167) {
                case 1: {
                    OR539 = (Token)this.match((IntStream)this.input, 45, PLSQL2Parser.FOLLOW_OR_in_create_function5113);
                    OR539_tree = this.adaptor.create(OR539);
                    this.adaptor.addChild(root_0, OR539_tree);
                    this.pushFollow(PLSQL2Parser.FOLLOW_kREPLACE_in_create_function5115);
                    kREPLACE540 = this.kREPLACE();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    this.adaptor.addChild(root_0, kREPLACE540.getTree());
                    break;
                }
            }
            FUNCTION541 = (Token)this.match((IntStream)this.input, 8, PLSQL2Parser.FOLLOW_FUNCTION_in_create_function5120);
            FUNCTION541_tree = this.adaptor.create(FUNCTION541);
            this.adaptor.addChild(root_0, FUNCTION541_tree);
            int alt168 = 2;
            final int LA168_0 = this.input.LA(1);
            if (LA168_0 == 7) {
                final int LA168_2 = this.input.LA(2);
                if (LA168_2 == 35) {
                    alt168 = 1;
                }
            }
            switch (alt168) {
                case 1: {
                    schema_name = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_create_function5126);
                    schema_name_tree = this.adaptor.create(schema_name);
                    this.adaptor.addChild(root_0, schema_name_tree);
                    DOT542 = (Token)this.match((IntStream)this.input, 35, PLSQL2Parser.FOLLOW_DOT_in_create_function5128);
                    DOT542_tree = this.adaptor.create(DOT542);
                    this.adaptor.addChild(root_0, DOT542_tree);
                    break;
                }
            }
            function_name = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_create_function5135);
            function_name_tree = this.adaptor.create(function_name);
            this.adaptor.addChild(root_0, function_name_tree);
            retval.r_functionDef.put("id", (function_name != null) ? function_name.getText() : null);
            int alt169 = 2;
            final int LA169_0 = this.input.LA(1);
            if (LA169_0 == 10) {
                alt169 = 1;
            }
            switch (alt169) {
                case 1: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_parameter_declarations_in_create_function5155);
                    temp9 = this.parameter_declarations();
                    final RecognizerSharedState state2 = this.state;
                    --state2._fsp;
                    this.adaptor.addChild(root_0, temp9.getTree());
                    break;
                }
            }
            retval.r_functionDef.put("paramList", (temp9 != null) ? temp9.r_parameter_list : null);
            RETURN543 = (Token)this.match((IntStream)this.input, 9, PLSQL2Parser.FOLLOW_RETURN_in_create_function5175);
            RETURN543_tree = this.adaptor.create(RETURN543);
            this.adaptor.addChild(root_0, RETURN543_tree);
            this.pushFollow(PLSQL2Parser.FOLLOW_datatype_in_create_function5177);
            datatype544 = this.datatype();
            final RecognizerSharedState state3 = this.state;
            --state3._fsp;
            this.adaptor.addChild(root_0, datatype544.getTree());
            retval.r_functionDef.put("returnType", (datatype544 != null) ? this.input.toString(datatype544.start, datatype544.stop) : null);
            int alt170 = 2;
            final int LA170_0 = this.input.LA(1);
            if (LA170_0 == 119) {
                alt170 = 1;
            }
            switch (alt170) {
                case 1: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_invoker_rights_clause_in_create_function5197);
                    invoker_rights_clause545 = this.invoker_rights_clause();
                    final RecognizerSharedState state4 = this.state;
                    --state4._fsp;
                    this.adaptor.addChild(root_0, invoker_rights_clause545.getTree());
                    break;
                }
            }
            set546 = this.input.LT(1);
            if (this.input.LA(1) != 19 && this.input.LA(1) != 24) {
                final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                throw mse;
            }
            this.input.consume();
            this.adaptor.addChild(root_0, this.adaptor.create(set546));
            this.state.errorRecovery = false;
            int alt171 = 3;
            switch (this.input.LA(1)) {
                case 6:
                case 7:
                case 8:
                case 18:
                case 25:
                case 42:
                case 74: {
                    alt171 = 1;
                    break;
                }
                case 122: {
                    alt171 = 2;
                    break;
                }
                case 118: {
                    alt171 = 3;
                    break;
                }
                default: {
                    final NoViableAltException nvae = new NoViableAltException("", 172, 0, (IntStream)this.input);
                    throw nvae;
                }
            }
            switch (alt171) {
                case 1: {
                    int alt172 = 2;
                    final int LA171_0 = this.input.LA(1);
                    if ((LA171_0 >= 6 && LA171_0 <= 8) || LA171_0 == 18 || LA171_0 == 25 || LA171_0 == 74) {
                        alt172 = 1;
                    }
                    switch (alt172) {
                        case 1: {
                            this.pushFollow(PLSQL2Parser.FOLLOW_declare_section_in_create_function5228);
                            declare_section547 = this.declare_section();
                            final RecognizerSharedState state5 = this.state;
                            --state5._fsp;
                            this.adaptor.addChild(root_0, declare_section547.getTree());
                            break;
                        }
                    }
                    this.pushFollow(PLSQL2Parser.FOLLOW_body_in_create_function5231);
                    body548 = this.body();
                    final RecognizerSharedState state6 = this.state;
                    --state6._fsp;
                    this.adaptor.addChild(root_0, body548.getTree());
                    break;
                }
                case 2: {
                    this.pushFollow(PLSQL2Parser.FOLLOW_call_spec_in_create_function5243);
                    call_spec549 = this.call_spec();
                    final RecognizerSharedState state7 = this.state;
                    --state7._fsp;
                    this.adaptor.addChild(root_0, call_spec549.getTree());
                    break;
                }
                case 3: {
                    EXTERNAL550 = (Token)this.match((IntStream)this.input, 118, PLSQL2Parser.FOLLOW_EXTERNAL_in_create_function5255);
                    EXTERNAL550_tree = this.adaptor.create(EXTERNAL550);
                    this.adaptor.addChild(root_0, EXTERNAL550_tree);
                    break;
                }
            }
            SEMI551 = (Token)this.match((IntStream)this.input, 5, PLSQL2Parser.FOLLOW_SEMI_in_create_function5267);
            SEMI551_tree = this.adaptor.create(SEMI551);
            this.adaptor.addChild(root_0, SEMI551_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final invoker_rights_clause_return invoker_rights_clause() throws RecognitionException {
        final invoker_rights_clause_return retval = new invoker_rights_clause_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token AUTHID552 = null;
        Token set553 = null;
        Object AUTHID552_tree = null;
        final Object set553_tree = null;
        try {
            root_0 = this.adaptor.nil();
            AUTHID552 = (Token)this.match((IntStream)this.input, 119, PLSQL2Parser.FOLLOW_AUTHID_in_invoker_rights_clause5288);
            AUTHID552_tree = this.adaptor.create(AUTHID552);
            this.adaptor.addChild(root_0, AUTHID552_tree);
            set553 = this.input.LT(1);
            if (this.input.LA(1) < 120 || this.input.LA(1) > 121) {
                final MismatchedSetException mse = new MismatchedSetException((BitSet)null, (IntStream)this.input);
                throw mse;
            }
            this.input.consume();
            this.adaptor.addChild(root_0, this.adaptor.create(set553));
            this.state.errorRecovery = false;
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final call_spec_return call_spec() throws RecognitionException {
        final call_spec_return retval = new call_spec_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token LANGUAGE554 = null;
        swallow_to_semi_return swallow_to_semi555 = null;
        Object LANGUAGE554_tree = null;
        try {
            root_0 = this.adaptor.nil();
            LANGUAGE554 = (Token)this.match((IntStream)this.input, 122, PLSQL2Parser.FOLLOW_LANGUAGE_in_call_spec5315);
            LANGUAGE554_tree = this.adaptor.create(LANGUAGE554);
            this.adaptor.addChild(root_0, LANGUAGE554_tree);
            this.pushFollow(PLSQL2Parser.FOLLOW_swallow_to_semi_in_call_spec5317);
            swallow_to_semi555 = this.swallow_to_semi();
            final RecognizerSharedState state = this.state;
            --state._fsp;
            this.adaptor.addChild(root_0, swallow_to_semi555.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final create_type_return create_type() throws RecognitionException {
        final create_type_return retval = new create_type_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token CREATE556 = null;
        Token OR557 = null;
        kREPLACE_return kREPLACE558 = null;
        type_definition_return type_definition559 = null;
        Object CREATE556_tree = null;
        Object OR557_tree = null;
        try {
            root_0 = this.adaptor.nil();
            CREATE556 = (Token)this.match((IntStream)this.input, 115, PLSQL2Parser.FOLLOW_CREATE_in_create_type5334);
            CREATE556_tree = this.adaptor.create(CREATE556);
            this.adaptor.addChild(root_0, CREATE556_tree);
            int alt173 = 2;
            final int LA173_0 = this.input.LA(1);
            if (LA173_0 == 45) {
                alt173 = 1;
            }
            switch (alt173) {
                case 1: {
                    OR557 = (Token)this.match((IntStream)this.input, 45, PLSQL2Parser.FOLLOW_OR_in_create_type5338);
                    OR557_tree = this.adaptor.create(OR557);
                    this.adaptor.addChild(root_0, OR557_tree);
                    this.pushFollow(PLSQL2Parser.FOLLOW_kREPLACE_in_create_type5340);
                    kREPLACE558 = this.kREPLACE();
                    final RecognizerSharedState state = this.state;
                    --state._fsp;
                    this.adaptor.addChild(root_0, kREPLACE558.getTree());
                    break;
                }
            }
            this.pushFollow(PLSQL2Parser.FOLLOW_type_definition_in_create_type5345);
            type_definition559 = this.type_definition();
            final RecognizerSharedState state2 = this.state;
            --state2._fsp;
            this.adaptor.addChild(root_0, type_definition559.getTree());
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final kERRORS_return kERRORS() throws RecognitionException {
        final kERRORS_return retval = new kERRORS_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ID560 = null;
        Object ID560_tree = null;
        try {
            root_0 = this.adaptor.nil();
            if (this.input.LT(1).getText().length() < 3 || !"errors".startsWith(this.input.LT(1).getText().toLowerCase())) {
                throw new FailedPredicateException((IntStream)this.input, "kERRORS", "input.LT(1).getText().length() >= 3 && \"errors\".startsWith(input.LT(1).getText().toLowerCase())");
            }
            ID560 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_kERRORS5356);
            ID560_tree = this.adaptor.create(ID560);
            this.adaptor.addChild(root_0, ID560_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final kEXCEPTIONS_return kEXCEPTIONS() throws RecognitionException {
        final kEXCEPTIONS_return retval = new kEXCEPTIONS_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ID561 = null;
        Object ID561_tree = null;
        try {
            root_0 = this.adaptor.nil();
            if (!this.input.LT(1).getText().equalsIgnoreCase("exceptions")) {
                throw new FailedPredicateException((IntStream)this.input, "kEXCEPTIONS", "input.LT(1).getText().equalsIgnoreCase(\"exceptions\")");
            }
            ID561 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_kEXCEPTIONS5365);
            ID561_tree = this.adaptor.create(ID561);
            this.adaptor.addChild(root_0, ID561_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final kFOUND_return kFOUND() throws RecognitionException {
        final kFOUND_return retval = new kFOUND_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ID562 = null;
        Object ID562_tree = null;
        try {
            root_0 = this.adaptor.nil();
            if (!this.input.LT(1).getText().equalsIgnoreCase("found")) {
                throw new FailedPredicateException((IntStream)this.input, "kFOUND", "input.LT(1).getText().equalsIgnoreCase(\"found\")");
            }
            ID562 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_kFOUND5374);
            ID562_tree = this.adaptor.create(ID562);
            this.adaptor.addChild(root_0, ID562_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final kINDICES_return kINDICES() throws RecognitionException {
        final kINDICES_return retval = new kINDICES_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ID563 = null;
        Object ID563_tree = null;
        try {
            root_0 = this.adaptor.nil();
            if (!this.input.LT(1).getText().equalsIgnoreCase("indices")) {
                throw new FailedPredicateException((IntStream)this.input, "kINDICES", "input.LT(1).getText().equalsIgnoreCase(\"indices\")");
            }
            ID563 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_kINDICES5383);
            ID563_tree = this.adaptor.create(ID563);
            this.adaptor.addChild(root_0, ID563_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final kMOD_return kMOD() throws RecognitionException {
        final kMOD_return retval = new kMOD_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ID564 = null;
        Object ID564_tree = null;
        try {
            root_0 = this.adaptor.nil();
            if (!this.input.LT(1).getText().equalsIgnoreCase("mod")) {
                throw new FailedPredicateException((IntStream)this.input, "kMOD", "input.LT(1).getText().equalsIgnoreCase(\"mod\")");
            }
            ID564 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_kMOD5392);
            ID564_tree = this.adaptor.create(ID564);
            this.adaptor.addChild(root_0, ID564_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final kNAME_return kNAME() throws RecognitionException {
        final kNAME_return retval = new kNAME_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ID565 = null;
        Object ID565_tree = null;
        try {
            root_0 = this.adaptor.nil();
            if (!this.input.LT(1).getText().equalsIgnoreCase("name")) {
                throw new FailedPredicateException((IntStream)this.input, "kNAME", "input.LT(1).getText().equalsIgnoreCase(\"name\")");
            }
            ID565 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_kNAME5401);
            ID565_tree = this.adaptor.create(ID565);
            this.adaptor.addChild(root_0, ID565_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final kOF_return kOF() throws RecognitionException {
        final kOF_return retval = new kOF_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ID566 = null;
        Object ID566_tree = null;
        try {
            root_0 = this.adaptor.nil();
            if (!this.input.LT(1).getText().equalsIgnoreCase("of")) {
                throw new FailedPredicateException((IntStream)this.input, "kOF", "input.LT(1).getText().equalsIgnoreCase(\"of\")");
            }
            ID566 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_kOF5410);
            ID566_tree = this.adaptor.create(ID566);
            this.adaptor.addChild(root_0, ID566_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final kREPLACE_return kREPLACE() throws RecognitionException {
        final kREPLACE_return retval = new kREPLACE_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ID567 = null;
        Object ID567_tree = null;
        try {
            root_0 = this.adaptor.nil();
            if (!this.input.LT(1).getText().equalsIgnoreCase("replace")) {
                throw new FailedPredicateException((IntStream)this.input, "kREPLACE", "input.LT(1).getText().equalsIgnoreCase(\"replace\")");
            }
            ID567 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_kREPLACE5419);
            ID567_tree = this.adaptor.create(ID567);
            this.adaptor.addChild(root_0, ID567_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final kROWCOUNT_return kROWCOUNT() throws RecognitionException {
        final kROWCOUNT_return retval = new kROWCOUNT_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ID568 = null;
        Object ID568_tree = null;
        try {
            root_0 = this.adaptor.nil();
            if (!this.input.LT(1).getText().equalsIgnoreCase("rowcount")) {
                throw new FailedPredicateException((IntStream)this.input, "kROWCOUNT", "input.LT(1).getText().equalsIgnoreCase(\"rowcount\")");
            }
            ID568 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_kROWCOUNT5428);
            ID568_tree = this.adaptor.create(ID568);
            this.adaptor.addChild(root_0, ID568_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final kSAVE_return kSAVE() throws RecognitionException {
        final kSAVE_return retval = new kSAVE_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ID569 = null;
        Object ID569_tree = null;
        try {
            root_0 = this.adaptor.nil();
            if (!this.input.LT(1).getText().equalsIgnoreCase("save")) {
                throw new FailedPredicateException((IntStream)this.input, "kSAVE", "input.LT(1).getText().equalsIgnoreCase(\"save\")");
            }
            ID569 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_kSAVE5437);
            ID569_tree = this.adaptor.create(ID569);
            this.adaptor.addChild(root_0, ID569_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final kSHOW_return kSHOW() throws RecognitionException {
        final kSHOW_return retval = new kSHOW_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ID570 = null;
        Object ID570_tree = null;
        try {
            root_0 = this.adaptor.nil();
            if (!this.input.LT(1).getText().equalsIgnoreCase("show")) {
                throw new FailedPredicateException((IntStream)this.input, "kSHOW", "input.LT(1).getText().equalsIgnoreCase(\"show\")");
            }
            ID570 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_kSHOW5446);
            ID570_tree = this.adaptor.create(ID570);
            this.adaptor.addChild(root_0, ID570_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final kTYPE_return kTYPE() throws RecognitionException {
        final kTYPE_return retval = new kTYPE_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ID571 = null;
        Object ID571_tree = null;
        try {
            root_0 = this.adaptor.nil();
            if (!this.input.LT(1).getText().equalsIgnoreCase("type")) {
                throw new FailedPredicateException((IntStream)this.input, "kTYPE", "input.LT(1).getText().equalsIgnoreCase(\"type\")");
            }
            ID571 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_kTYPE5455);
            ID571_tree = this.adaptor.create(ID571);
            this.adaptor.addChild(root_0, ID571_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public final kVALUES_return kVALUES() throws RecognitionException {
        final kVALUES_return retval = new kVALUES_return();
        retval.start = this.input.LT(1);
        Object root_0 = null;
        Token ID572 = null;
        Object ID572_tree = null;
        try {
            root_0 = this.adaptor.nil();
            if (!this.input.LT(1).getText().equalsIgnoreCase("values")) {
                throw new FailedPredicateException((IntStream)this.input, "kVALUES", "input.LT(1).getText().equalsIgnoreCase(\"values\")");
            }
            ID572 = (Token)this.match((IntStream)this.input, 7, PLSQL2Parser.FOLLOW_ID_in_kVALUES5464);
            ID572_tree = this.adaptor.create(ID572);
            this.adaptor.addChild(root_0, ID572_tree);
            retval.stop = this.input.LT(-1);
            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
        }
        catch (RecognitionException re) {
            this.reportError(re);
            this.recover((IntStream)this.input, re);
            retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
        }
        return retval;
    }
    
    public static class sqlplus_file_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class show_errors_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class create_object_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class procedure_heading_return extends ParserRuleReturnScope
    {
        public HashMap r_procedureDef;
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class function_heading_return extends ParserRuleReturnScope
    {
        public HashMap r_functionDef;
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class parameter_declarations_return extends ParserRuleReturnScope
    {
        public ArrayList r_parameter_list;
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class parameter_declaration_return extends ParserRuleReturnScope
    {
        public HashMap r_parameter;
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class param_type_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class declare_section_return extends ParserRuleReturnScope
    {
        public String construct;
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class cursor_definition_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class item_declaration_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class variable_declaration_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class constant_declaration_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class exception_declaration_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class type_definition_return extends ParserRuleReturnScope
    {
        public HashMap r_typeDef;
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class subtype_definition_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class record_type_definition_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class record_field_declaration_return extends ParserRuleReturnScope
    {
        public HashMap r_field;
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class object_type_definition_return extends ParserRuleReturnScope
    {
        public ArrayList r_field_list;
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class collection_type_definition_return extends ParserRuleReturnScope
    {
        public HashMap r_collectionType;
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class varray_type_definition_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class nested_table_type_definition_return extends ParserRuleReturnScope
    {
        public HashMap table_data_type;
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class associative_index_type_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class ref_cursor_type_definition_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class datatype_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class function_declaration_or_definition_return extends ParserRuleReturnScope
    {
        public String construct;
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class function_declaration_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class function_definition_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class procedure_declaration_or_definition_return extends ParserRuleReturnScope
    {
        public String construct;
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class procedure_declaration_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class procedure_definition_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class body_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class exception_handler_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class lvalue_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class assign_or_call_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class call_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class delete_call_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class basic_loop_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class case_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class close_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class continue_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class execute_immediate_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class exit_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class fetch_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class into_clause_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class bulk_collect_into_clause_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class using_clause_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class param_modifiers_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class dynamic_returning_clause_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class for_loop_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class forall_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class bounds_clause_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class goto_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class if_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class null_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class open_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class pragma_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class raise_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class return_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class plsql_block_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class label_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class qual_id_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class sql_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class commit_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class delete_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class insert_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class lock_table_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class rollback_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class savepoint_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class select_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class set_transaction_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class update_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class swallow_to_semi_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class while_loop_statement_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class match_parens_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class label_name_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class expression_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class or_expr_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class and_expr_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class not_expr_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class compare_expr_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class is_null_expr_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class like_expr_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class between_expr_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class in_expr_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class numeric_expression_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class add_expr_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class mul_expr_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class unary_sign_expr_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class exponent_expr_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class atom_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class variable_or_function_call_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class attribute_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class call_args_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class boolean_atom_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class numeric_atom_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class numeric_literal_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class boolean_literal_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class string_literal_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class collection_exists_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class conditional_predicate_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class parameter_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class index_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class create_package_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class package_full_name_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class create_package_body_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class create_procedure_return extends ParserRuleReturnScope
    {
        public HashMap r_procedureDef;
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class create_function_return extends ParserRuleReturnScope
    {
        public HashMap r_functionDef;
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class invoker_rights_clause_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class call_spec_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class create_type_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class kERRORS_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class kEXCEPTIONS_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class kFOUND_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class kINDICES_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class kMOD_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class kNAME_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class kOF_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class kREPLACE_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class kROWCOUNT_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class kSAVE_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class kSHOW_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class kTYPE_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    public static class kVALUES_return extends ParserRuleReturnScope
    {
        Object tree;
        
        public Object getTree() {
            return this.tree;
        }
    }
    
    class DFA5 extends DFA
    {
        public DFA5(final BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = PLSQL2Parser.DFA5_eot;
            this.eof = PLSQL2Parser.DFA5_eof;
            this.min = PLSQL2Parser.DFA5_min;
            this.max = PLSQL2Parser.DFA5_max;
            this.accept = PLSQL2Parser.DFA5_accept;
            this.special = PLSQL2Parser.DFA5_special;
            this.transition = PLSQL2Parser.DFA5_transition;
        }
        
        public String getDescription() {
            return "100:1: create_object : ( create_package | create_package_body | create_function | create_procedure | create_type );";
        }
    }
    
    class DFA15 extends DFA
    {
        public DFA15(final BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = PLSQL2Parser.DFA15_eot;
            this.eof = PLSQL2Parser.DFA15_eof;
            this.min = PLSQL2Parser.DFA15_min;
            this.max = PLSQL2Parser.DFA15_max;
            this.accept = PLSQL2Parser.DFA15_accept;
            this.special = PLSQL2Parser.DFA15_special;
            this.transition = PLSQL2Parser.DFA15_transition;
        }
        
        public String getDescription() {
            return "()+ loopback of 191:5: ( type_definition SEMI | subtype_definition SEMI | cursor_definition SEMI | item_declaration SEMI | function_declaration_or_definition SEMI | procedure_declaration_or_definition SEMI | pragma SEMI )+";
        }
    }
    
    class DFA96 extends DFA
    {
        public DFA96(final BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 96;
            this.eot = PLSQL2Parser.DFA96_eot;
            this.eof = PLSQL2Parser.DFA96_eof;
            this.min = PLSQL2Parser.DFA96_min;
            this.max = PLSQL2Parser.DFA96_max;
            this.accept = PLSQL2Parser.DFA96_accept;
            this.special = PLSQL2Parser.DFA96_special;
            this.transition = PLSQL2Parser.DFA96_transition;
        }
        
        public String getDescription() {
            return "472:1: bounds_clause : ( numeric_expression DOUBLEDOT numeric_expression | kINDICES kOF atom ( BETWEEN numeric_expression AND numeric_expression )? | kVALUES kOF atom );";
        }
        
        public int specialStateTransition(int s, final IntStream _input) throws NoViableAltException {
            final TokenStream input = (TokenStream)_input;
            final int _s = s;
            switch (s) {
                case 0: {
                    final int LA96_3 = input.LA(1);
                    final int index96_3 = input.index();
                    input.rewind();
                    s = -1;
                    if (!input.LT(1).getText().equalsIgnoreCase("indices") && !input.LT(1).getText().equalsIgnoreCase("values")) {
                        s = 1;
                    }
                    else if (input.LT(1).getText().equalsIgnoreCase("indices")) {
                        s = 13;
                    }
                    else if (input.LT(1).getText().equalsIgnoreCase("values")) {
                        s = 14;
                    }
                    input.seek(index96_3);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                }
            }
            final NoViableAltException nvae = new NoViableAltException(this.getDescription(), 96, _s, (IntStream)input);
            this.error(nvae);
            throw nvae;
        }
    }
    
    class DFA139 extends DFA
    {
        public DFA139(final BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 139;
            this.eot = PLSQL2Parser.DFA139_eot;
            this.eof = PLSQL2Parser.DFA139_eof;
            this.min = PLSQL2Parser.DFA139_min;
            this.max = PLSQL2Parser.DFA139_max;
            this.accept = PLSQL2Parser.DFA139_accept;
            this.special = PLSQL2Parser.DFA139_special;
            this.transition = PLSQL2Parser.DFA139_transition;
        }
        
        public String getDescription() {
            return "640:1: atom : ( variable_or_function_call ( PERCENT attribute )? | SQL PERCENT attribute | string_literal | numeric_atom | boolean_atom | NULL | LPAREN expression RPAREN );";
        }
    }
}
