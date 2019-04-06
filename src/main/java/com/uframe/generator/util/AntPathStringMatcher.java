package com.uframe.generator.util;

import java.util.*;
import java.util.regex.*;

class AntPathStringMatcher
{
    private static final Pattern GLOB_PATTERN;
    private static final String DEFAULT_VARIABLE_PATTERN = "(.*)";
    private final Pattern pattern;
    private String str;
    private final List<String> variableNames;
    private final Map<String, String> uriTemplateVariables;
    
    static {
        GLOB_PATTERN = Pattern.compile("\\?|\\*|\\{([^/]+?)\\}");
    }
    
    AntPathStringMatcher(final String pattern, final String str, final Map<String, String> uriTemplateVariables) {
        this.variableNames = new LinkedList<String>();
        this.str = str;
        this.uriTemplateVariables = uriTemplateVariables;
        this.pattern = this.createPattern(pattern);
    }
    
    private Pattern createPattern(final String pattern) {
        final StringBuilder patternBuilder = new StringBuilder();
        final Matcher m = AntPathStringMatcher.GLOB_PATTERN.matcher(pattern);
        int end = 0;
        while (m.find()) {
            patternBuilder.append(this.quote(pattern, end, m.start()));
            final String match = m.group();
            if ("?".equals(match)) {
                patternBuilder.append('.');
            }
            else if ("*".equals(match)) {
                patternBuilder.append(".*");
            }
            else if (match.startsWith("{") && match.endsWith("}")) {
                final int colonIdx = match.indexOf(58);
                if (colonIdx == -1) {
                    patternBuilder.append("(.*)");
                    this.variableNames.add(m.group(1));
                }
                else {
                    final String variablePattern = match.substring(colonIdx + 1, match.length() - 1);
                    patternBuilder.append('(');
                    patternBuilder.append(variablePattern);
                    patternBuilder.append(')');
                    final String variableName = match.substring(1, colonIdx);
                    this.variableNames.add(variableName);
                }
            }
            end = m.end();
        }
        patternBuilder.append(this.quote(pattern, end, pattern.length()));
        return Pattern.compile(patternBuilder.toString());
    }
    
    private String quote(final String s, final int start, final int end) {
        if (start == end) {
            return "";
        }
        return Pattern.quote(s.substring(start, end));
    }
    
    public boolean matchStrings() {
        final Matcher matcher = this.pattern.matcher(this.str);
        if (matcher.matches()) {
            if (this.uriTemplateVariables != null) {
                for (int i = 1; i <= matcher.groupCount(); ++i) {
                    final String name = this.variableNames.get(i - 1);
                    final String value = matcher.group(i);
                    this.uriTemplateVariables.put(name, value);
                }
            }
            return true;
        }
        return false;
    }
}
