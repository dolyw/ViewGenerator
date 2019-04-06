package com.uframe.generator.util;

import java.util.*;

public class AntPathMatcher
{
    public static final String DEFAULT_PATH_SEPARATOR = "/";
    private String pathSeparator;
    
    public AntPathMatcher() {
        this.pathSeparator = "/";
    }
    
    public void setPathSeparator(final String pathSeparator) {
        this.pathSeparator = ((pathSeparator != null) ? pathSeparator : "/");
    }
    
    public boolean isPattern(final String path) {
        return path.indexOf(42) != -1 || path.indexOf(63) != -1;
    }
    
    public boolean match(final String pattern, final String path) {
        return this.doMatch(pattern, path, true, null);
    }
    
    public boolean matchStart(final String pattern, final String path) {
        return this.doMatch(pattern, path, false, null);
    }
    
    protected boolean doMatch(final String pattern, final String path, final boolean fullMatch, final Map<String, String> uriTemplateVariables) {
        if (path.startsWith(this.pathSeparator) != pattern.startsWith(this.pathSeparator)) {
            return false;
        }
        final String[] pattDirs = StringHelper.tokenizeToStringArray(pattern, this.pathSeparator);
        final String[] pathDirs = StringHelper.tokenizeToStringArray(path, this.pathSeparator);
        int pattIdxStart;
        int pattIdxEnd;
        int pathIdxStart;
        int pathIdxEnd;
        for (pattIdxStart = 0, pattIdxEnd = pattDirs.length - 1, pathIdxStart = 0, pathIdxEnd = pathDirs.length - 1; pattIdxStart <= pattIdxEnd && pathIdxStart <= pathIdxEnd; ++pattIdxStart, ++pathIdxStart) {
            final String patDir = pattDirs[pattIdxStart];
            if ("**".equals(patDir)) {
                break;
            }
            if (!this.matchStrings(patDir, pathDirs[pathIdxStart], uriTemplateVariables)) {
                return false;
            }
        }
        if (pathIdxStart > pathIdxEnd) {
            if (pattIdxStart > pattIdxEnd) {
                return pattern.endsWith(this.pathSeparator) ? path.endsWith(this.pathSeparator) : (!path.endsWith(this.pathSeparator));
            }
            if (!fullMatch) {
                return true;
            }
            if (pattIdxStart == pattIdxEnd && pattDirs[pattIdxStart].equals("*") && path.endsWith(this.pathSeparator)) {
                return true;
            }
            for (int i = pattIdxStart; i <= pattIdxEnd; ++i) {
                if (!pattDirs[i].equals("**")) {
                    return false;
                }
            }
            return true;
        }
        else {
            if (pattIdxStart > pattIdxEnd) {
                return false;
            }
            if (!fullMatch && "**".equals(pattDirs[pattIdxStart])) {
                return true;
            }
            while (pattIdxStart <= pattIdxEnd && pathIdxStart <= pathIdxEnd) {
                final String patDir = pattDirs[pattIdxEnd];
                if (patDir.equals("**")) {
                    break;
                }
                if (!this.matchStrings(patDir, pathDirs[pathIdxEnd], uriTemplateVariables)) {
                    return false;
                }
                --pattIdxEnd;
                --pathIdxEnd;
            }
            if (pathIdxStart > pathIdxEnd) {
                for (int i = pattIdxStart; i <= pattIdxEnd; ++i) {
                    if (!pattDirs[i].equals("**")) {
                        return false;
                    }
                }
                return true;
            }
            while (pattIdxStart != pattIdxEnd && pathIdxStart <= pathIdxEnd) {
                int patIdxTmp = -1;
                for (int j = pattIdxStart + 1; j <= pattIdxEnd; ++j) {
                    if (pattDirs[j].equals("**")) {
                        patIdxTmp = j;
                        break;
                    }
                }
                if (patIdxTmp == pattIdxStart + 1) {
                    ++pattIdxStart;
                }
                else {
                    final int patLength = patIdxTmp - pattIdxStart - 1;
                    final int strLength = pathIdxEnd - pathIdxStart + 1;
                    int foundIdx = -1;
                    int k = 0;
                Label_0529:
                    while (k <= strLength - patLength) {
                        for (int l = 0; l < patLength; ++l) {
                            final String subPat = pattDirs[pattIdxStart + l + 1];
                            final String subStr = pathDirs[pathIdxStart + k + l];
                            if (!this.matchStrings(subPat, subStr, uriTemplateVariables)) {
                                ++k;
                                continue Label_0529;
                            }
                        }
                        foundIdx = pathIdxStart + k;
                        break;
                    }
                    if (foundIdx == -1) {
                        return false;
                    }
                    pattIdxStart = patIdxTmp;
                    pathIdxStart = foundIdx + patLength;
                }
            }
            for (int i = pattIdxStart; i <= pattIdxEnd; ++i) {
                if (!pattDirs[i].equals("**")) {
                    return false;
                }
            }
            return true;
        }
    }
    
    private boolean matchStrings(final String pattern, final String str, final Map<String, String> uriTemplateVariables) {
        final AntPathStringMatcher matcher = new AntPathStringMatcher(pattern, str, uriTemplateVariables);
        return matcher.matchStrings();
    }
    
    public String extractPathWithinPattern(final String pattern, final String path) {
        final String[] patternParts = StringHelper.tokenizeToStringArray(pattern, this.pathSeparator);
        final String[] pathParts = StringHelper.tokenizeToStringArray(path, this.pathSeparator);
        final StringBuilder builder = new StringBuilder();
        int puts = 0;
        for (int i = 0; i < patternParts.length; ++i) {
            final String patternPart = patternParts[i];
            if ((patternPart.indexOf(42) > -1 || patternPart.indexOf(63) > -1) && pathParts.length >= i + 1) {
                if (puts > 0 || (i == 0 && !pattern.startsWith(this.pathSeparator))) {
                    builder.append(this.pathSeparator);
                }
                builder.append(pathParts[i]);
                ++puts;
            }
        }
        for (int i = patternParts.length; i < pathParts.length; ++i) {
            if (puts > 0 || i > 0) {
                builder.append(this.pathSeparator);
            }
            builder.append(pathParts[i]);
        }
        return builder.toString();
    }
    
    public Map<String, String> extractUriTemplateVariables(final String pattern, final String path) {
        final Map<String, String> variables = new LinkedHashMap<String, String>();
        final boolean result = this.doMatch(pattern, path, true, variables);
        if (!result) {
            throw new IllegalStateException("Pattern \"" + pattern + "\" is not a match for \"" + path + "\"");
        }
        return variables;
    }
    
    public String combine(final String pattern1, final String pattern2) {
        if (StringHelper.isBlank(pattern1) && StringHelper.isBlank(pattern2)) {
            return "";
        }
        if (StringHelper.isBlank(pattern1)) {
            return pattern2;
        }
        if (StringHelper.isBlank(pattern2)) {
            return pattern1;
        }
        if (this.match(pattern1, pattern2)) {
            return pattern2;
        }
        if (pattern1.endsWith("/*")) {
            if (pattern2.startsWith("/")) {
                return String.valueOf(pattern1.substring(0, pattern1.length() - 1)) + pattern2.substring(1);
            }
            return String.valueOf(pattern1.substring(0, pattern1.length() - 1)) + pattern2;
        }
        else if (pattern1.endsWith("/**")) {
            if (pattern2.startsWith("/")) {
                return String.valueOf(pattern1) + pattern2;
            }
            return String.valueOf(pattern1) + "/" + pattern2;
        }
        else {
            final int dotPos1 = pattern1.indexOf(46);
            if (dotPos1 != -1) {
                final String fileName1 = pattern1.substring(0, dotPos1);
                final String extension1 = pattern1.substring(dotPos1);
                final int dotPos2 = pattern2.indexOf(46);
                String fileName2;
                String extension2;
                if (dotPos2 != -1) {
                    fileName2 = pattern2.substring(0, dotPos2);
                    extension2 = pattern2.substring(dotPos2);
                }
                else {
                    fileName2 = pattern2;
                    extension2 = "";
                }
                final String fileName3 = fileName1.endsWith("*") ? fileName2 : fileName1;
                final String extension3 = extension1.startsWith("*") ? extension2 : extension1;
                return String.valueOf(fileName3) + extension3;
            }
            if (pattern1.endsWith("/") || pattern2.startsWith("/")) {
                return String.valueOf(pattern1) + pattern2;
            }
            return String.valueOf(pattern1) + "/" + pattern2;
        }
    }
    
    public Comparator<String> getPatternComparator(final String path) {
        return new AntPatternComparator(path);
    }
    
    private static class AntPatternComparator implements Comparator<String>
    {
        private final String path;
        
        private AntPatternComparator(final String path) {
            this.path = path;
        }
        
        @Override
        public int compare(final String pattern1, final String pattern2) {
            if (pattern1 == null && pattern2 == null) {
                return 0;
            }
            if (pattern1 == null) {
                return 1;
            }
            if (pattern2 == null) {
                return -1;
            }
            final boolean pattern1EqualsPath = pattern1.equals(this.path);
            final boolean pattern2EqualsPath = pattern2.equals(this.path);
            if (pattern1EqualsPath && pattern2EqualsPath) {
                return 0;
            }
            if (pattern1EqualsPath) {
                return -1;
            }
            if (pattern2EqualsPath) {
                return 1;
            }
            final int wildCardCount1 = StringHelper.countOccurrencesOf(pattern1, "*");
            final int wildCardCount2 = StringHelper.countOccurrencesOf(pattern2, "*");
            if (wildCardCount1 < wildCardCount2) {
                return -1;
            }
            if (wildCardCount2 < wildCardCount1) {
                return 1;
            }
            final int bracketCount1 = StringHelper.countOccurrencesOf(pattern1, "{");
            final int bracketCount2 = StringHelper.countOccurrencesOf(pattern2, "{");
            if (bracketCount1 < bracketCount2) {
                return -1;
            }
            if (bracketCount2 < bracketCount1) {
                return 1;
            }
            return 0;
        }
    }
}
