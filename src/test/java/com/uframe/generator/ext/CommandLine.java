package com.uframe.generator.ext;

import freemarker.log.*;
import java.util.*;
import com.uframe.generator.*;
import com.uframe.generator.util.*;

public class CommandLine
{
    public static void main(final String[] args) throws Exception {
        Logger.selectLoggerLibrary(0);
        startProcess();
    }
    
    private static void startProcess() throws Exception {
        final Scanner sc = new Scanner(System.in);
        printUsages();
        while (sc.hasNextLine()) {
            try {
                processLine(sc);
            }
            catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            finally {
                Thread.sleep(700L);
                printUsages();
            }
            Thread.sleep(700L);
            printUsages();
        }
    }
    
    private static void processLine(final Scanner sc) throws Exception {
        final GeneratorFacade facade = new GeneratorFacade();
        final String cmd = sc.next();
        if ("geni".equals(cmd)) {
            final String[] args = nextArguments(sc);
            if (args.length == 0) {
                return;
            }
            facade.g.setIncludes(getIncludes(args, 1));
            facade.generateByTable(args[0], getTemplateRootDir("template_umsfi"));
            if (SystemHelper.isWindowsOS) {
                Runtime.getRuntime().exec("cmd.exe /c start " + GeneratorProperties.getRequiredProperty("outRoot").replace('/', '\\'));
            }
        }
        else if ("genh".equals(cmd)) {
            final String[] args = nextArguments(sc);
            if (args.length == 0) {
                return;
            }
            facade.g.setIncludes(getIncludes(args, 1));
            facade.generateByTable(args[0], getTemplateRootDir("template_sfh"));
            if (SystemHelper.isWindowsOS) {
                Runtime.getRuntime().exec("cmd.exe /c start " + GeneratorProperties.getRequiredProperty("outRoot").replace('/', '\\'));
            }
        }
        else if (!"genpi".equals(cmd)) {
            if ("deli".equals(cmd)) {
                final String[] args = nextArguments(sc);
                if (args.length == 0) {
                    return;
                }
                facade.g.setIncludes(getIncludes(args, 1));
                facade.deleteByTable(args[0], getTemplateRootDir("template_umsfi"));
            }
            else if ("delh".equals(cmd)) {
                final String[] args = nextArguments(sc);
                if (args.length == 0) {
                    return;
                }
                facade.g.setIncludes(getIncludes(args, 1));
                facade.deleteByTable(args[0], getTemplateRootDir("template_sfh"));
            }
            else if ("quit".equals(cmd)) {
                System.exit(0);
            }
            else {
                System.err.println(" [ERROR] unknow command:" + cmd);
            }
        }
    }
    
    private static String getIncludes(final String[] args, final int i) {
        final String includes = ArrayHelper.getValue(args, i);
        if (includes == null) {
            return null;
        }
        return (includes.indexOf("*") >= 0 || includes.indexOf(",") >= 0) ? includes : (String.valueOf(includes) + "/**");
    }
    
    private static String getTemplateRootDir(final String templateType) {
        return System.getProperty("templateRootDir", templateType);
    }
    
    private static void printUsages() {
        System.out.println("Usage:");
        System.out.println("\tgeni  table_name : \u6839\u636e\u6570\u636e\u5e93\u4e2d\u7684\u8868\u540d\u751f\u6210ibatis\u4ee3\u7801");
        System.out.println("\tgenh  table_name : \u6839\u636e\u6570\u636e\u5e93\u4e2d\u7684\u8868\u540d\u751f\u6210hibernate\u4ee3\u7801");
        System.out.println("\tdeli  table_name : \u6839\u636e\u6570\u636e\u5e93\u4e2d\u7684\u8868\u5220\u9664\u751f\u6210\u7684ibatis\u4ee3\u7801");
        System.out.println("\tdelh  table_name : \u6839\u636e\u6570\u636e\u5e93\u4e2d\u7684\u8868\u5220\u9664\u751f\u6210\u7684hibernate\u4ee3\u7801");
        System.out.println("\tquit : quit");
        System.out.println("\t[include_path] subdir of templateRootDir,example: 1. dao  2. dao/**,service/**");
        System.out.print("please input command:");
    }
    
    private static void printBaseInfo() {
        final String targetObject = GeneratorProperties.getRequiredProperty("targetObject");
        final String templateType = GeneratorProperties.getRequiredProperty("templateType");
        final String basepackage = GeneratorProperties.getRequiredProperty("basepackage");
        final String namespace = GeneratorProperties.getRequiredProperty("namespace");
        final String outRoot = GeneratorProperties.getRequiredProperty("outRoot");
        System.out.println("\u4ee3\u7801\u751f\u6210\u5668\u914d\u7f6e\u4fe1\u606f:");
        System.out.println("\t \u76ee\u6807\u5bf9\u8c61\uff1a" + targetObject);
        System.out.println("\t \u6a21\u677f\u7c7b\u578b\uff1a" + templateType);
        System.out.println("\t \u57fa\u672c\u5305\u8def\u5f84\uff1a" + basepackage);
        System.out.println("\t \u89c6\u56fe\u5305\uff1a\uff1a" + namespace);
        System.out.println("\t \u8f93\u51fa\u8def\u5f84\uff1a\uff1a" + outRoot);
    }
    
    private static String[] nextArguments(final Scanner sc) {
        return StringHelper.tokenizeToStringArray(sc.nextLine(), " ");
    }
}
