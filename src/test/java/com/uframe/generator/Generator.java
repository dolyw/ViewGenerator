package com.uframe.generator;

import java.util.*;
import java.sql.*;
import freemarker.template.*;
import com.uframe.generator.util.*;
import freemarker.cache.*;
import java.io.*;

public class Generator
{
    private static final String GENERATOR_INSERT_LOCATION = "generator-insert-location";
    private List templateRootDirs;
    private static String outRootDir;
    private boolean ignoreTemplateGenerateException;
    private String removeExtensions;
    private boolean isCopyBinaryFile;
    private String includes;
    private String excludes;
    private String sourceEncoding;
    private String outputEncoding;
    
    public Generator() {
        this.templateRootDirs = new ArrayList();
        this.ignoreTemplateGenerateException = true;
        this.removeExtensions = System.getProperty("generator.removeExtensions", ".ftl,.vm");
        this.isCopyBinaryFile = true;
        this.includes = System.getProperty("generator.includes");
        this.excludes = System.getProperty("generator.excludes");
        this.sourceEncoding = System.getProperty("generator.sourceEncoding", "UTF-8");
        this.outputEncoding = System.getProperty("generator.outputEncoding", "UTF-8");
    }
    
    public void setTemplateRootDir(final File templateRootDir) {
        this.setTemplateRootDirs(templateRootDir);
    }
    
    public void setTemplateRootDirs(final File... templateRootDirs) {
        this.templateRootDirs = Arrays.asList(templateRootDirs);
    }
    
    public void addTemplateRootDir(final File f) {
        this.templateRootDirs.add(f);
    }
    
    public boolean isIgnoreTemplateGenerateException() {
        return this.ignoreTemplateGenerateException;
    }
    
    public void setIgnoreTemplateGenerateException(final boolean ignoreTemplateGenerateException) {
        this.ignoreTemplateGenerateException = ignoreTemplateGenerateException;
    }
    
    public boolean isCopyBinaryFile() {
        return this.isCopyBinaryFile;
    }
    
    public void setCopyBinaryFile(final boolean isCopyBinaryFile) {
        this.isCopyBinaryFile = isCopyBinaryFile;
    }
    
    public String getSourceEncoding() {
        return this.sourceEncoding;
    }
    
    public void setSourceEncoding(final String sourceEncoding) {
        if (sourceEncoding == null) {
            throw new IllegalArgumentException("sourceEncoding must be not null");
        }
        this.sourceEncoding = sourceEncoding;
    }
    
    public String getOutputEncoding() {
        return this.outputEncoding;
    }
    
    public void setOutputEncoding(final String outputEncoding) {
        if (outputEncoding == null) {
            throw new IllegalArgumentException("outputEncoding must be not null");
        }
        this.outputEncoding = outputEncoding;
    }
    
    public void setIncludes(final String includes) {
        this.includes = includes;
    }
    
    public void setExcludes(final String excludes) {
        this.excludes = excludes;
    }
    
    public void setOutRootDir(final String v) {
        if (v == null) {
            throw new IllegalArgumentException("outRootDir must be not null");
        }
        if (v.indexOf(":") >= 0) {
            outRootDir = v;
        } else {
            // 项目在硬盘上的基础路径
            outRootDir = System.getProperty("user.dir") + v;
        }
    }
    
    public static String getOutRootDir() {
        return outRootDir;
    }
    
    public void setRemoveExtensions(final String removeExtensions) {
        this.removeExtensions = removeExtensions;
    }
    
    public void deleteOutRootDir() throws IOException {
        if (StringHelper.isBlank(this.getOutRootDir())) {
            throw new IllegalStateException("'outRootDir' property must be not null.");
        }
        GLogger.println("[delete dir]    " + this.getOutRootDir());
        FileHelper.deleteDirectory(new File(this.getOutRootDir()));
    }
    
    public Generator generateBy(final Map templateModel, final Map filePathModel) throws Exception {
        this.processTemplateRootDirs(templateModel, filePathModel, false);
        return this;
    }
    
    public Generator deleteBy(final Map templateModel, final Map filePathModel) throws Exception {
        this.processTemplateRootDirs(templateModel, filePathModel, true);
        return this;
    }
    
    private void processTemplateRootDirs(final Map templateModel, final Map filePathModel, final boolean isDelete) throws Exception {
        if (StringHelper.isBlank(this.getOutRootDir())) {
            throw new IllegalStateException("'outRootDir' property must be not null.");
        }
        if (this.templateRootDirs.size() == 0) {
            throw new IllegalStateException("'templateRootDirs' cannot empty");
        }
        final GeneratorException ge = new GeneratorException("generator occer error, Generator BeanInfo:" + BeanHelper.describe(this));
        for (int i = 0; i < this.templateRootDirs.size(); ++i) {
            final File templateRootDir = (File) this.templateRootDirs.get(i);
            final List<Exception> exceptions = this.scanTemplatesAndProcess(templateRootDir, templateModel, filePathModel, isDelete);
            ge.addAll(exceptions);
        }
        if (!ge.exceptions.isEmpty()) {
            throw ge;
        }
    }
    
    private List<Exception> scanTemplatesAndProcess(final File templateRootDir, final Map templateModel, final Map filePathModel, final boolean isDelete) throws Exception {
        if (templateRootDir == null) {
            throw new IllegalStateException("'templateRootDir' must be not null");
        }
        GLogger.println("-------------------load template from templateRootDir = '" + templateRootDir.getAbsolutePath() + "' outRootDir:" + new File(this.outRootDir).getAbsolutePath());
        final List srcFiles = FileHelper.searchAllNotIgnoreFile(templateRootDir);
        final List<Exception> exceptions = new ArrayList<Exception>();
        for (int i = 0; i < srcFiles.size(); ++i) {
            final File srcFile = (File) srcFiles.get(i);
            try {
                if (isDelete) {
                    new TemplateProcessor().executeDelete(templateRootDir, templateModel, filePathModel, srcFile);
                }
                else {
                    new TemplateProcessor().executeGenerate(templateRootDir, templateModel, filePathModel, srcFile);
                }
            }
            catch (Exception e) {
                if (!this.ignoreTemplateGenerateException) {
                    throw e;
                }
                GLogger.warn("iggnore generate error,template is:" + srcFile + " cause:" + e);
                exceptions.add(e);
            }
        }
        return exceptions;
    }
    
    private class TemplateProcessor
    {
        private GeneratorControl gg;
        
        private TemplateProcessor() {
            this.gg = new GeneratorControl();
        }
        
        private void executeGenerate(final File templateRootDir, final Map templateModel, final Map filePathModel, final File srcFile) throws SQLException, IOException, TemplateException {
            final String templateFile = FileHelper.getRelativePath(templateRootDir, srcFile);
            if (GeneratorHelper.isIgnoreTemplateProcess(srcFile, templateFile, Generator.this.includes, Generator.this.excludes)) {
                return;
            }
            if (Generator.this.isCopyBinaryFile && FileHelper.isBinaryFile(srcFile)) {
                final String outputFilepath = this.proceeForOutputFilepath(filePathModel, templateFile);
                GLogger.println("[copy binary file by extention] from:" + srcFile + " => " + new File(Generator.this.getOutRootDir(), outputFilepath));
                IOHelper.copyAndClose(new FileInputStream(srcFile), new FileOutputStream(new File(Generator.this.getOutRootDir(), outputFilepath)));
                return;
            }
            try {
                final String outputFilepath = this.proceeForOutputFilepath(filePathModel, templateFile);
                this.initGeneratorControlProperties(srcFile, outputFilepath);
                this.processTemplateForGeneratorControl(templateModel, templateFile);
                if (this.gg.isIgnoreOutput()) {
                    GLogger.println("[not generate] by gg.isIgnoreOutput()=true on template:" + templateFile);
                    return;
                }
                if (StringHelper.isNotBlank(this.gg.getOutputFile())) {
                    this.generateNewFileOrInsertIntoFile(templateFile, this.gg.getOutputFile(), templateModel);
                }
            }
            catch (Exception e) {
                throw new RuntimeException("generate oucur error,templateFile is:" + templateFile + " => " + this.gg.getOutputFile() + " cause:" + e, e);
            }
        }
        
        private void executeDelete(final File templateRootDir, final Map templateModel, final Map filePathModel, final File srcFile) throws SQLException, IOException, TemplateException {
            final String templateFile = FileHelper.getRelativePath(templateRootDir, srcFile);
            if (GeneratorHelper.isIgnoreTemplateProcess(srcFile, templateFile, Generator.this.includes, Generator.this.excludes)) {
                return;
            }
            final String outputFilepath = this.proceeForOutputFilepath(filePathModel, templateFile);
            this.initGeneratorControlProperties(srcFile, outputFilepath);
            this.gg.deleteGeneratedFile = true;
            this.processTemplateForGeneratorControl(templateModel, templateFile);
            GLogger.println("[delete file] file:" + new File(this.gg.getOutputFile()).getAbsolutePath());
            new File(this.gg.getOutputFile()).delete();
        }
        
        private void initGeneratorControlProperties(final File srcFile, final String outputFile) throws SQLException {
            this.gg.setSourceFile(srcFile.getAbsolutePath());
            this.gg.setSourceFileName(srcFile.getName());
            this.gg.setSourceDir(srcFile.getParent());
            this.gg.setOutRoot(Generator.this.getOutRootDir());
            this.gg.setOutputEncoding(Generator.this.outputEncoding);
            this.gg.setSourceEncoding(Generator.this.sourceEncoding);
            this.gg.setMergeLocation("generator-insert-location");
            this.gg.setOutputFile(outputFile);
        }
        
        private void processTemplateForGeneratorControl(final Map templateModel, final String templateFile) throws IOException, TemplateException {
            templateModel.put("gg", this.gg);
            final Template template = this.getFreeMarkerTemplate(templateFile);
            template.process((Object)templateModel, IOHelper.NULL_WRITER);
        }
        
        private String proceeForOutputFilepath(final Map filePathModel, final String templateFile) throws IOException {
            String outputFilePath = templateFile;
            int testExpressionIndex = -1;
            if ((testExpressionIndex = templateFile.indexOf(64)) != -1) {
                outputFilePath = templateFile.substring(0, testExpressionIndex);
                final String testExpressionKey = templateFile.substring(testExpressionIndex + 1);
                final Object expressionValue = filePathModel.get(testExpressionKey);
                if (expressionValue == null) {
                    System.err.println("[not-generate] WARN: test expression is null by key:[" + testExpressionKey + "] on template:[" + templateFile + "]");
                    return null;
                }
                if (!"true".equals(String.valueOf(expressionValue))) {
                    GLogger.println("[not-generate]\t test expression '@" + testExpressionKey + "' is false,template:" + templateFile);
                    return null;
                }
            }
            String[] split;
            for (int length = (split = Generator.this.removeExtensions.split(",")).length, i = 0; i < length; ++i) {
                final String removeExtension = split[i];
                if (outputFilePath.endsWith(removeExtension)) {
                    outputFilePath = outputFilePath.substring(0, outputFilePath.length() - removeExtension.length());
                    break;
                }
            }
            final Configuration conf = GeneratorHelper.newFreeMarkerConfiguration(Generator.this.templateRootDirs, Generator.this.sourceEncoding, "/filepath/processor/");
            return FreemarkerHelper.processTemplateString(outputFilePath, filePathModel, conf);
        }
        
        private Template getFreeMarkerTemplate(final String templateName) throws IOException {
            return GeneratorHelper.newFreeMarkerConfiguration(Generator.this.templateRootDirs, Generator.this.sourceEncoding, templateName).getTemplate(templateName);
        }
        
        private void generateNewFileOrInsertIntoFile(final String templateFile, final String outputFilepath, final Map templateModel) throws Exception {
            final Template template = this.getFreeMarkerTemplate(templateFile);
            template.setOutputEncoding(this.gg.getOutputEncoding());
            final File absoluteOutputFilePath = FileHelper.parentMkdir(outputFilepath);
            if (absoluteOutputFilePath.exists()) {
                final StringWriter newFileContentCollector = new StringWriter();
                if (GeneratorHelper.isFoundInsertLocation(this.gg, template, templateModel, absoluteOutputFilePath, newFileContentCollector)) {
                    GLogger.println("[insert]\t generate content into:" + outputFilepath);
                    IOHelper.saveFile(absoluteOutputFilePath, newFileContentCollector.toString(), this.gg.getOutputEncoding());
                    return;
                }
            }
            if (absoluteOutputFilePath.exists() && !this.gg.isOverride()) {
                GLogger.println("[not generate]\t by gg.isOverride()=false and outputFile exist:" + outputFilepath);
                return;
            }
            GLogger.println("[generate]\t template:" + templateFile + " ==> " + outputFilepath);
            FreemarkerHelper.processTemplate(template, templateModel, absoluteOutputFilePath, this.gg.getOutputEncoding());
        }
    }
    
    static class GeneratorHelper
    {
        public static boolean isIgnoreTemplateProcess(final File srcFile, String templateFile, final String includes, final String excludes) {
            if (srcFile.isDirectory() || srcFile.isHidden()) {
                return true;
            }
            if (templateFile.trim().equals("")) {
                return true;
            }
            if (srcFile.getName().toLowerCase().endsWith(".include")) {
                GLogger.println("[skip]\t\t endsWith '.include' template:" + templateFile);
                return true;
            }
            templateFile = templateFile.replace('\\', '/');
            String[] tokenizeToStringArray;
            for (int length = (tokenizeToStringArray = StringHelper.tokenizeToStringArray(excludes, ",")).length, i = 0; i < length; ++i) {
                final String exclude = tokenizeToStringArray[i];
                if (new AntPathMatcher().match(exclude.replace('\\', '/'), templateFile)) {
                    return true;
                }
            }
            if (includes == null) {
                return false;
            }
            String[] tokenizeToStringArray2;
            for (int length2 = (tokenizeToStringArray2 = StringHelper.tokenizeToStringArray(includes, ",")).length, j = 0; j < length2; ++j) {
                final String include = tokenizeToStringArray2[j];
                if (new AntPathMatcher().match(include.replace('\\', '/'), templateFile)) {
                    return false;
                }
            }
            return true;
        }

        public static boolean isFoundInsertLocation(final GeneratorControl gg, final Template template, final Map model, final File outputFile, final StringWriter newFileContent) throws IOException, TemplateException {
            final LineNumberReader reader = new LineNumberReader(new FileReader(outputFile));
            String line = null;
            boolean isFoundInsertLocation = false;
            final PrintWriter writer = new PrintWriter(newFileContent);
            while ((line = reader.readLine()) != null) {
                writer.println(line);
                if (!isFoundInsertLocation && line.indexOf(gg.getMergeLocation()) >= 0) {
                    template.process((Object)model, (Writer)writer);
                    writer.println();
                    isFoundInsertLocation = true;
                }
            }
            writer.close();
            reader.close();
            return isFoundInsertLocation;
        }
        
        public static Configuration newFreeMarkerConfiguration(final List<File> templateRootDirs, final String defaultEncoding, final String templateName) throws IOException {
            final Configuration conf = new Configuration();
            final FileTemplateLoader[] templateLoaders = new FileTemplateLoader[templateRootDirs.size()];
            for (int i = 0; i < templateRootDirs.size(); ++i) {
                templateLoaders[i] = new FileTemplateLoader((File)templateRootDirs.get(i));
            }
            final MultiTemplateLoader multiTemplateLoader = new MultiTemplateLoader((TemplateLoader[])templateLoaders);
            conf.setTemplateLoader((TemplateLoader)multiTemplateLoader);
            conf.setNumberFormat("###############");
            conf.setBooleanFormat("true,false");
            conf.setDefaultEncoding(defaultEncoding);
            final List<String> autoIncludes = getParentPaths(templateName, "macro.include");
            final List<String> availableAutoInclude = FreemarkerHelper.getAvailableAutoInclude(conf, autoIncludes);
            conf.setAutoIncludes((List)availableAutoInclude);
            GLogger.trace("set Freemarker.autoIncludes:" + availableAutoInclude + " for templateName:" + templateName + " autoIncludes:" + autoIncludes);
            return conf;
        }
        
        public static List<String> getParentPaths(final String templateName, final String suffix) {
            final String[] array = StringHelper.tokenizeToStringArray(templateName, "\\/");
            final List<String> list = new ArrayList<String>();
            list.add(suffix);
            list.add(String.valueOf(File.separator) + suffix);
            String path = "";
            for (int i = 0; i < array.length; ++i) {
                path = String.valueOf(path) + File.separator + array[i];
                list.add(String.valueOf(path) + File.separator + suffix);
            }
            return list;
        }
    }
    
    public static class GeneratorModel implements Serializable
    {
        public Map filePathModel;
        public Map templateModel;
        
        public GeneratorModel(final Map templateModel, final Map filePathModel) {
            this.templateModel = templateModel;
            this.filePathModel = filePathModel;
        }
    }
}
