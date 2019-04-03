package com.uframe.generator.util;

import java.io.*;

public class GLogger
{
    public static final int TRACE = 60;
    public static final int DEBUG = 70;
    public static final int INFO = 80;
    public static final int WARN = 90;
    public static final int ERROR = 100;
    public static int logLevel;
    public static PrintStream out;
    public static PrintStream err;
    public static boolean perf;
    
    static {
        GLogger.logLevel = 80;
        GLogger.out = System.out;
        GLogger.err = System.err;
        GLogger.perf = false;
    }
    
    public static void trace(final String s) {
        if (GLogger.logLevel <= 60) {
            GLogger.out.println("[Generator TRACE] " + s);
        }
    }
    
    public static void debug(final String s) {
        if (GLogger.logLevel <= 70) {
            GLogger.out.println("[Generator DEBUG] " + s);
        }
    }
    
    public static void info(final String s) {
        if (GLogger.logLevel <= 80) {
            GLogger.out.println("[Generator INFO] " + s);
        }
    }
    
    public static void warn(final String s) {
        if (GLogger.logLevel <= 90) {
            GLogger.err.println("[Generator WARN] " + s);
        }
    }
    
    public static void warn(final String s, final Throwable e) {
        if (GLogger.logLevel <= 90) {
            GLogger.err.println("[Generator WARN] " + s + " cause:" + e);
            e.printStackTrace(GLogger.err);
        }
    }
    
    public static void error(final String s) {
        if (GLogger.logLevel <= 100) {
            GLogger.err.println("[Generator ERROR] " + s);
        }
    }
    
    public static void error(final String s, final Throwable e) {
        if (GLogger.logLevel <= 100) {
            GLogger.err.println("[Generator ERROR] " + s + " cause:" + e);
            e.printStackTrace(GLogger.err);
        }
    }
    
    public static void perf(final String s) {
        if (GLogger.perf) {
            GLogger.out.println("[Generator Performance] " + s);
        }
    }
    
    public static void println(final String s) {
        if (GLogger.logLevel <= 80) {
            GLogger.out.println(s);
        }
    }
}
