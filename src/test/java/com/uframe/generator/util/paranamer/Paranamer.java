package com.uframe.generator.util.paranamer;

import java.lang.reflect.*;

public interface Paranamer
{
    public static final String[] EMPTY_NAMES = new String[0];
    
    String[] lookupParameterNames(final AccessibleObject p0);
    
    String[] lookupParameterNames(final AccessibleObject p0, final boolean p1);
}
