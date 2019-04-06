package com.uframe.generator.util.sqlparse;

import com.uframe.generator.util.StringHelper;

import java.util.*;
import java.util.regex.*;

public abstract class NamedParameterUtils
{
    private static final char[] PARAMETER_SEPARATORS;
    private static final String[] START_SKIP;
    private static final String[] STOP_SKIP;
    static Pattern PATTERN;
    
    static {
        PARAMETER_SEPARATORS = new char[] { '\"', '\'', ':', '&', ',', ';', '(', ')', '|', '=', '+', '-', '*', '%', '/', '\\', '<', '>', '^' };
        START_SKIP = new String[] { "'", "\"", "--", "/*" };
        STOP_SKIP = new String[] { "'", "\"", "\n", "*/" };
        NamedParameterUtils.PATTERN = Pattern.compile(":([\\w_]*):([\\w_]*)");
    }
    
    public static ParsedSql parseSqlStatement(final String sql) throws IllegalArgumentException {
        if (sql == null) {
            new IllegalArgumentException("SQL must not be null");
        }
        final Set<String> namedParameters = new HashSet<String>();
        final ParsedSql parsedSql = new ParsedSql(sql);
        final char[] statement = sql.toCharArray();
        int namedParameterCount = 0;
        int unnamedParameterCount = 0;
        int totalParameterCount = 0;
        int i = 0;
        while (i < statement.length) {
            final int skipToPosition = skipCommentsAndQuotes(statement, i);
            if (i != skipToPosition) {
                if (skipToPosition >= statement.length) {
                    break;
                }
                i = skipToPosition;
            }
            final char c = statement[i];
            if (c == ':' || c == '&' || c == '#' || c == '$') {
                int j = i + 1;
                if (j < statement.length && statement[j] == ':' && c == ':') {
                    i += 2;
                    continue;
                }
                while (j < statement.length && !isParameterSeparator(statement[j])) {
                    ++j;
                }
                if (j - i > 1) {
                    final String parameter = sql.substring(i + 1, j);
                    if (!namedParameters.contains(parameter)) {
                        namedParameters.add(parameter);
                        ++namedParameterCount;
                    }
                    final String removedPrefixAndSuffixParameter = removePrefixAndSuffix(c, parameter, sql);
                    parsedSql.addNamedParameter(removedPrefixAndSuffixParameter, String.valueOf(c) + parameter, i, j);
                    ++totalParameterCount;
                }
                i = j - 1;
            }
            else if (c == '?') {
                ++unnamedParameterCount;
                ++totalParameterCount;
            }
            ++i;
        }
        parsedSql.setNamedParameterCount(namedParameterCount);
        parsedSql.setUnnamedParameterCount(unnamedParameterCount);
        parsedSql.setTotalParameterCount(totalParameterCount);
        return parsedSql;
    }
    
    private static String removePrefixAndSuffix(final char startPrifix, String parameter, final String sql) {
        if (startPrifix == ':' || startPrifix == '&') {
            return parameter;
        }
        if (parameter.startsWith("{") || parameter.endsWith("}")) {
            if (parameter.startsWith("{") && parameter.endsWith("}")) {
                parameter = parameter.substring(1, parameter.length() - 1);
                return parameter.replaceAll("\\[.*?\\]", "");
            }
            throw new IllegalArgumentException("parameter error:" + parameter + ",must wrap with {param},sql:" + sql);
        }
        else if (startPrifix == '#') {
            if (!parameter.endsWith("#")) {
                throw new IllegalArgumentException("parameter error:" + parameter + ",must wrap with #param#,sql:" + sql);
            }
            parameter = parameter.substring(0, parameter.length() - 1);
            if (parameter.endsWith("[]")) {
                return parameter.substring(0, parameter.length() - 2);
            }
            return parameter;
        }
        else {
            if (startPrifix != '$') {
                throw new IllegalArgumentException("cannot reach this");
            }
            if (parameter.endsWith("$")) {
                parameter = parameter.substring(0, parameter.length() - 1);
                return parameter;
            }
            throw new IllegalArgumentException("parameter error:" + parameter + ",must wrap with $param$,sql:" + sql);
        }
    }
    
    private static int skipCommentsAndQuotes(final char[] statement, final int position) {
        for (int i = 0; i < NamedParameterUtils.START_SKIP.length; ++i) {
            if (statement[position] == NamedParameterUtils.START_SKIP[i].charAt(0)) {
                boolean match = true;
                for (int j = 1; j < NamedParameterUtils.START_SKIP[i].length(); ++j) {
                    if (statement[position + j] != NamedParameterUtils.START_SKIP[i].charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    final int offset = NamedParameterUtils.START_SKIP[i].length();
                    for (int m = position + offset; m < statement.length; ++m) {
                        if (statement[m] == NamedParameterUtils.STOP_SKIP[i].charAt(0)) {
                            boolean endMatch = true;
                            int endPos = m;
                            for (int n = 1; n < NamedParameterUtils.STOP_SKIP[i].length(); ++n) {
                                if (m + n >= statement.length) {
                                    return statement.length;
                                }
                                if (statement[m + n] != NamedParameterUtils.STOP_SKIP[i].charAt(n)) {
                                    endMatch = false;
                                    break;
                                }
                                endPos = m + n;
                            }
                            if (endMatch) {
                                return endPos + 1;
                            }
                        }
                    }
                    return statement.length;
                }
            }
        }
        return position;
    }
    
    public static String substituteNamedParameters(final ParsedSql parsedSql) {
        final String originalSql = parsedSql.getOriginalSql();
        final StringBuilder actualSql = new StringBuilder();
        final List paramNames = parsedSql.getParameterNames();
        int lastIndex = 0;
        for (int i = 0; i < paramNames.size(); ++i) {
            final String paramName = StringHelper.convertType(paramNames.get(i));
            final int[] indexes = parsedSql.getParameterIndexes(i);
            final int startIndex = indexes[0];
            final int endIndex = indexes[1];
            actualSql.append(originalSql.substring(lastIndex, startIndex));
            actualSql.append("?");
            lastIndex = endIndex;
        }
        actualSql.append(originalSql.substring(lastIndex, originalSql.length()));
        return actualSql.toString();
    }
    
    private static boolean isParameterSeparator(final char c) {
        if (Character.isWhitespace(c)) {
            return true;
        }
        char[] parameter_SEPARATORS;
        for (int length = (parameter_SEPARATORS = NamedParameterUtils.PARAMETER_SEPARATORS).length, i = 0; i < length; ++i) {
            final char separator = parameter_SEPARATORS[i];
            if (c == separator) {
                return true;
            }
        }
        return false;
    }
    
    public static Map getNamedParameters(final String sql) {
        final Map map = new LinkedHashMap();
        final Matcher m = NamedParameterUtils.PATTERN.matcher(sql);
        if (m.find()) {
            map.put(m.group(1), m.group(2));
        }
        return map;
    }
}
