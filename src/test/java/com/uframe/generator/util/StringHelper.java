package com.uframe.generator.util;

import java.util.regex.*;
import com.uframe.generator.provider.db.table.model.*;
import java.util.*;

public class StringHelper
{
    private static final Map<String, String> XML;
    private static final Random RANDOM;
    static Pattern three;
    static Pattern two;
    
    static {
        (XML = new HashMap<String, String>()).put("apos", "'");
        StringHelper.XML.put("quot", "\"");
        StringHelper.XML.put("amp", "&");
        StringHelper.XML.put("lt", "<");
        StringHelper.XML.put("gt", ">");
        RANDOM = new Random();
        StringHelper.three = Pattern.compile("(.*)\\((.*),(.*)\\)");
        StringHelper.two = Pattern.compile("(.*)\\((.*)\\)");
    }
    
    public static String removeCrlf(final String str) {
        if (str == null) {
            return null;
        }
        return join(tokenizeToStringArray(str, "\t\n\r\f"), " ");
    }
    
    public static String unescapeXml(String str) {
        if (str == null) {
            return null;
        }
        for (final String key : StringHelper.XML.keySet()) {
            final String value = StringHelper.XML.get(key);
            str = replace(str, "&" + key + ";", value);
        }
        return str;
    }
    
    public static String escapeXml(final String str) {
        if (str == null) {
            return null;
        }
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); ++i) {
            final char c = str.charAt(i);
            final String escapedStr = getEscapedStringByChar(c);
            if (escapedStr == null) {
                sb.append(c);
            }
            else {
                sb.append(escapedStr);
            }
        }
        return sb.toString();
    }
    
    public static String escapeXml(final String str, final String escapeChars) {
        if (str == null) {
            return null;
        }
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); ++i) {
            final char c = str.charAt(i);
            if (escapeChars.indexOf(c) < 0) {
                sb.append(c);
            }
            else {
                final String escapedStr = getEscapedStringByChar(c);
                if (escapedStr == null) {
                    sb.append(c);
                }
                else {
                    sb.append(escapedStr);
                }
            }
        }
        return sb.toString();
    }
    
    private static String getEscapedStringByChar(final char c) {
        String escapedStr = null;
        for (final String key : StringHelper.XML.keySet()) {
            final String value = StringHelper.XML.get(key);
            if (c == value.charAt(0)) {
                escapedStr = "&" + key + ";";
            }
        }
        return escapedStr;
    }
    
    public static String removePrefix(final String str, final String prefix) {
        return removePrefix(str, prefix, false);
    }
    
    public static String removePrefix(final String str, final String prefix, final boolean ignoreCase) {
        if (str == null) {
            return null;
        }
        if (prefix == null) {
            return str;
        }
        if (ignoreCase) {
            if (str.toLowerCase().startsWith(prefix.toLowerCase())) {
                return str.substring(prefix.length());
            }
        }
        else if (str.startsWith(prefix)) {
            return str.substring(prefix.length());
        }
        return str;
    }
    
    public static boolean isBlank(final String str) {
        return str == null || str.trim().length() == 0;
    }
    
    public static boolean isNotBlank(final String str) {
        return !isBlank(str);
    }
    
    public static boolean isEmpty(final String str) {
        return str == null || str.length() == 0;
    }
    
    public static boolean isNotEmpty(final String str) {
        return !isEmpty(str);
    }
    
    public static String getExtension(final String str) {
        if (str == null) {
            return null;
        }
        final int i = str.lastIndexOf(46);
        if (i >= 0) {
            return str.substring(i + 1);
        }
        return null;
    }
    
    public static String insertBefore(final String content, final String compareToken, final String insertString) {
        if (content.indexOf(insertString) >= 0) {
            return content;
        }
        final int index = content.indexOf(compareToken);
        if (index >= 0) {
            return new StringBuffer(content).insert(index, insertString).toString();
        }
        throw new IllegalArgumentException("not found insert location by compareToken:" + compareToken + " content:" + content);
    }
    
    public static String insertAfter(final String content, final String compareToken, final String insertString) {
        if (content.indexOf(insertString) >= 0) {
            return content;
        }
        final int index = content.indexOf(compareToken);
        if (index >= 0) {
            return new StringBuffer(content).insert(index + compareToken.length(), insertString).toString();
        }
        throw new IllegalArgumentException("not found insert location by compareToken:" + compareToken + " content:" + content);
    }
    
    public static int countOccurrencesOf(final String str, final String sub) {
        if (str == null || sub == null || str.length() == 0 || sub.length() == 0) {
            return 0;
        }
        int count = 0;
        int idx;
        for (int pos = 0; (idx = str.indexOf(sub, pos)) != -1; pos = idx + sub.length()) {
            ++count;
        }
        return count;
    }
    
    public static boolean contains(final String str, final String... keywords) {
        if (str == null) {
            return false;
        }
        if (keywords == null) {
            throw new IllegalArgumentException("'keywords' must be not null");
        }
        for (final String keyword : keywords) {
            if (str.contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    
    public static String defaultString(final Object value) {
        if (value == null) {
            return "";
        }
        return value.toString();
    }
    
    public static String defaultIfEmpty(final Object value, final String defaultValue) {
        if (value == null || "".equals(value)) {
            return defaultValue;
        }
        return value.toString();
    }
    
    public static String makeAllWordFirstLetterUpperCase(final String sqlName) {
        final String[] strs = sqlName.toLowerCase().split("_");
        String result = "";
        String preStr = "";
        for (int i = 0; i < strs.length; ++i) {
            if (preStr.length() == 1) {
                result = String.valueOf(result) + capitalize(strs[i]);
            }
            else {
                result = String.valueOf(result) + capitalize(strs[i]);
            }
            preStr = strs[i];
        }
        return result;
    }
    
    public static int indexOfByRegex(final String input, final String regex) {
        final Pattern p = Pattern.compile(regex);
        final Matcher m = p.matcher(input);
        if (m.find()) {
            return m.start();
        }
        return -1;
    }
    
    public static String toJavaVariableName(final String str) {
        return uncapitalize(toJavaClassName(str));
    }
    
    public static String toJavaClassName(final String str) {
        return makeAllWordFirstLetterUpperCase(toUnderscoreName(str));
    }
    
    public static String getJavaClassSimpleName(final String clazz) {
        if (clazz == null) {
            return null;
        }
        if (clazz.lastIndexOf(".") >= 0) {
            return clazz.substring(clazz.lastIndexOf(".") + 1);
        }
        return clazz;
    }
    
    public static String removeMany(String inString, final String... keywords) {
        if (inString == null) {
            return null;
        }
        for (final String k : keywords) {
            inString = replace(inString, k, "");
        }
        return inString;
    }
    
    public static void appendReplacement(final Matcher m, final StringBuffer sb, String replacement) {
        replacement = replace(replacement, "$", "\\$");
        m.appendReplacement(sb, replacement);
    }
    
    public static String replace(final String inString, final String oldPattern, final String newPattern) {
        if (inString == null) {
            return null;
        }
        if (oldPattern == null || newPattern == null) {
            return inString;
        }
        final StringBuffer sbuf = new StringBuffer();
        int pos = 0;
        int index = inString.indexOf(oldPattern);
        final int patLen = oldPattern.length();
        while (index >= 0) {
            sbuf.append(inString.substring(pos, index));
            sbuf.append(newPattern);
            pos = index + patLen;
            index = inString.indexOf(oldPattern, pos);
        }
        sbuf.append(inString.substring(pos));
        return sbuf.toString();
    }
    
    public static String capitalize(final String str) {
        return changeFirstCharacterCase(str, true);
    }
    
    public static String uncapitalize(final String str) {
        return changeFirstCharacterCase(str, false);
    }
    
    private static String changeFirstCharacterCase(final String str, final boolean capitalize) {
        if (str == null || str.length() == 0) {
            return str;
        }
        final StringBuffer buf = new StringBuffer(str.length());
        if (capitalize) {
            buf.append(Character.toUpperCase(str.charAt(0)));
        }
        else {
            buf.append(Character.toLowerCase(str.charAt(0)));
        }
        buf.append(str.substring(1));
        return buf.toString();
    }
    
    public static String randomNumeric(final int count) {
        return random(count, false, true);
    }
    
    public static String random(final int count, final boolean letters, final boolean numbers) {
        return random(count, 0, 0, letters, numbers);
    }
    
    public static String random(final int count, final int start, final int end, final boolean letters, final boolean numbers) {
        return random(count, start, end, letters, numbers, null, StringHelper.RANDOM);
    }
    
    public static String random(int count, int start, int end, final boolean letters, final boolean numbers, final char[] chars, final Random random) {
        if (count == 0) {
            return "";
        }
        if (count < 0) {
            throw new IllegalArgumentException("Requested random string length " + count + " is less than 0.");
        }
        if (start == 0 && end == 0) {
            end = 123;
            start = 32;
            if (!letters && !numbers) {
                start = 0;
                end = Integer.MAX_VALUE;
            }
        }
        final char[] buffer = new char[count];
        final int gap = end - start;
        while (count-- != 0) {
            char ch;
            if (chars == null) {
                ch = (char)(random.nextInt(gap) + start);
            }
            else {
                ch = chars[random.nextInt(gap) + start];
            }
            if ((letters && Character.isLetter(ch)) || (numbers && Character.isDigit(ch)) || (!letters && !numbers)) {
                if (ch >= '\udc00' && ch <= '\udfff') {
                    if (count == 0) {
                        ++count;
                    }
                    else {
                        buffer[count] = ch;
                        --count;
                        buffer[count] = (char)(55296 + random.nextInt(128));
                    }
                }
                else if (ch >= '\ud800' && ch <= '\udb7f') {
                    if (count == 0) {
                        ++count;
                    }
                    else {
                        buffer[count] = (char)(56320 + random.nextInt(128));
                        --count;
                        buffer[count] = ch;
                    }
                }
                else if (ch >= '\udb80' && ch <= '\udbff') {
                    ++count;
                }
                else {
                    buffer[count] = ch;
                }
            }
            else {
                ++count;
            }
        }
        return new String(buffer);
    }
    
    public static String toUnderscoreName(final String name) {
        if (name == null) {
            return null;
        }
        String filteredName = name;
        if (filteredName.indexOf("_") >= 0 && filteredName.equals(filteredName.toUpperCase())) {
            filteredName = filteredName.toLowerCase();
        }
        if (filteredName.indexOf("_") == -1 && filteredName.equals(filteredName.toUpperCase())) {
            filteredName = filteredName.toLowerCase();
        }
        final StringBuffer result = new StringBuffer();
        if (filteredName != null && filteredName.length() > 0) {
            result.append(filteredName.substring(0, 1).toLowerCase());
            for (int i = 1; i < filteredName.length(); ++i) {
                final String preChart = filteredName.substring(i - 1, i);
                final String c = filteredName.substring(i, i + 1);
                if (c.equals("_")) {
                    result.append("_");
                }
                else if (preChart.equals("_")) {
                    result.append(c.toLowerCase());
                }
                else if (c.matches("\\d")) {
                    result.append(c);
                }
                else if (c.equals(c.toUpperCase())) {
                    result.append("_");
                    result.append(c.toLowerCase());
                }
                else {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }
    
    public static String removeEndWiths(final String inputString, final String... endWiths) {
        for (final String endWith : endWiths) {
            if (inputString.endsWith(endWith)) {
                return inputString.substring(0, inputString.length() - endWith.length());
            }
        }
        return inputString;
    }
    
    public static List<Column.EnumMetaDada> string2EnumMetaData(final String data) {
        if (data == null || data.trim().length() == 0) {
            return new ArrayList<Column.EnumMetaDada>();
        }
        final List<Column.EnumMetaDada> list = new ArrayList<Column.EnumMetaDada>();
        final Pattern p = Pattern.compile("\\w+\\(.*?\\)");
        final Matcher m = p.matcher(data);
        while (m.find()) {
            final String str = m.group();
            final Matcher three_m = StringHelper.three.matcher(str);
            if (three_m.find()) {
                list.add(new Column.EnumMetaDada(three_m.group(1), three_m.group(2), three_m.group(3)));
            }
            else {
                final Matcher two_m = StringHelper.two.matcher(str);
                if (!two_m.find()) {
                    throw new IllegalArgumentException("error enumString format:" + data + " expected format:F(1,Female);M(0,Male) or F(Female);M(Male)");
                }
                list.add(new Column.EnumMetaDada(two_m.group(1), two_m.group(1), two_m.group(2)));
            }
        }
        return list;
    }
    
    public static boolean substringMatch(final CharSequence str, final int index, final CharSequence substring) {
        for (int j = 0; j < substring.length(); ++j) {
            final int i = index + j;
            if (i >= str.length() || str.charAt(i) != substring.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    
    public static String[] tokenizeToStringArray(final String str, final String seperators) {
        if (str == null) {
            return new String[0];
        }
        final StringTokenizer tokenlizer = new StringTokenizer(str, seperators);
        final List result = new ArrayList();
        while (tokenlizer.hasMoreElements()) {
            final Object s = tokenlizer.nextElement();
            result.add(s);
        }
        return (String[]) result.toArray(new String[result.size()]);
    }
    
    public static String join(final List list, final String seperator) {
        return join(list.toArray(new Object[0]), seperator);
    }
    
    public static String replace(final int start, final int end, final String str, final String replacement) {
        final String before = str.substring(0, start);
        final String after = str.substring(end);
        return String.valueOf(before) + replacement + after;
    }
    
    public static String join(final Object[] array, final String seperator) {
        if (array == null) {
            return null;
        }
        final StringBuffer result = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
            result.append(array[i]);
            if (i != array.length - 1) {
                result.append(seperator);
            }
        }
        return result.toString();
    }
    
    public static int containsCount(final String string, final String keyword) {
        if (string == null) {
            return 0;
        }
        int count = 0;
        int indexOf;
        for (int i = 0; i < string.length(); i = indexOf, ++i) {
            indexOf = string.indexOf(keyword, i);
            if (indexOf < 0) {
                break;
            }
            ++count;
        }
        return count;
    }
    
    public static String getByRegex(final String str, final String regex) {
        return getByRegex(str, regex, 0);
    }
    
    public static String getByRegex(final String str, final String regex, final int group) {
        if (regex == null) {
            throw new NullPointerException();
        }
        if (group < 0) {
            throw new IllegalArgumentException();
        }
        if (str == null) {
            return null;
        }
        final Pattern p = Pattern.compile(regex);
        final Matcher m = p.matcher(str);
        if (m.find()) {
            return m.group(group);
        }
        return null;
    }
    
    public static String removeIbatisOrderBy(final String sql) {
        final String orderByRemovedSql = sql.replaceAll("(?si)<\\w+[^>]*?>\\s*order\\s+by\\s+[^<]+?</\\w+>", "").replaceAll("(?i)<\\w+[\\w\\s='\"]+prepend[\\w\\s='\"]*?order\\s+by\\s*['\"][^>]*?>[^<]+</\\w+>", "").replaceAll("(?i)\\s*order\\s+by\\s+.*", "");
        return removeXmlTagIfBodyEmpty(removeXmlTagIfBodyEmpty(removeXmlTagIfBodyEmpty(removeXmlTagIfBodyEmpty(orderByRemovedSql))));
    }
    
    public static String removeXmlTagIfBodyEmpty(final String sql) {
        return sql.replaceAll("<\\w+[^>]*?>\\s+</\\w+>", "");
    }
    
    public static String convertToClassName(final String proName) {
        final String[] names = proName.split("_");
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < names.length; ++i) {
            final String name = String.valueOf(names[i].substring(0, 1).toUpperCase()) + names[i].substring(1);
            sb.append(name);
        }
        return sb.toString();
    }
    
    public static String convertToParameterJavaName(final String parameterName) {
        final String[] names = parameterName.split("_");
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < names.length; ++i) {
            if (i == 0 || i == 1) {
                sb.append(names[i]);
            }
            else {
                final String name = String.valueOf(names[i].substring(0, 1).toUpperCase()) + names[i].substring(1);
                sb.append(name);
            }
        }
        return sb.toString();
    }
    
    public static String convertToRuleDataType(String dataType) {
        final int i = dataType.indexOf("(");
        if (i > 0) {
            dataType = dataType.substring(0, i);
        }
        return dataType;
    }

    public static String convertType(Object str) {
        if (str != null) {
            return str.toString();
        }
        return null;
    }
}
