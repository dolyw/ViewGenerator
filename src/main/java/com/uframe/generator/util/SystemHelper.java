package com.uframe.generator.util;

public class SystemHelper
{
    public static boolean isWindowsOS;
    
    static {
        SystemHelper.isWindowsOS = (System.getProperty("os.name").toLowerCase().indexOf("windows") >= 0);
    }
}
