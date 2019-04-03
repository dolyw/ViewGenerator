package com.uframe.generator;

import freemarker.ext.dom.*;
import org.xml.sax.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import com.uframe.generator.provider.db.*;
import com.uframe.generator.util.*;
import java.sql.*;
import java.util.List;

public class GeneratorControl
{
    private boolean isOverride;
    private boolean isAppend;
    private boolean ignoreOutput;
    private boolean isMergeIfExists;
    private String mergeLocation;
    private String outRoot;
    private String outputEncoding;
    private String sourceFile;
    private String sourceDir;
    private String sourceFileName;
    private String sourceEncoding;
    private String outputFile;
    boolean deleteGeneratedFile;
    
    public GeneratorControl() {
        this.isOverride = Boolean.parseBoolean(System.getProperty("gg.isOverride", "false"));
        this.isAppend = false;
        this.ignoreOutput = false;
        this.isMergeIfExists = true;
        this.deleteGeneratedFile = false;
    }
    
    public NodeModel loadXml(final String file) {
        return this.loadXml(file, true);
    }
    
    public NodeModel loadXml(final String file, final boolean removeXmlNamespace) {
        try {
            if (removeXmlNamespace) {
                final InputStream forEncodingInput = FileHelper.getInputStream(file);
                final String encoding = XMLHelper.getXMLEncoding(forEncodingInput);
                forEncodingInput.close();
                final InputStream input = FileHelper.getInputStream(file);
                String xml = IOHelper.toString(encoding, input);
                xml = XMLHelper.removeXmlns(xml);
                input.close();
                return NodeModel.parse(new InputSource(new StringReader(xml.trim())));
            }
            return NodeModel.parse(new InputSource(FileHelper.getInputStream(file)));
        }
        catch (Exception e) {
            throw new IllegalArgumentException("loadXml error,file:" + file, e);
        }
    }
    
    public Properties loadProperties(final String file) {
        try {
            final Properties p = new Properties();
            final InputStream in = FileHelper.getInputStream(file);
            if (file.endsWith(".xml")) {
                p.loadFromXML(in);
            }
            else {
                p.load(in);
            }
            in.close();
            return p;
        }
        catch (Exception e) {
            throw new IllegalArgumentException("loadProperties error,file:" + file, e);
        }
    }
    
    public void generateFile(final String outputFile, final String content) {
        this.generateFile(outputFile, content, false);
    }
    
    public void generateFile(final String outputFile, final String content, final boolean append) {
        try {
            String realOutputFile = null;
            if (new File(outputFile).isAbsolute()) {
                realOutputFile = outputFile;
            }
            else {
                realOutputFile = new File(this.getOutRoot(), outputFile).getAbsolutePath();
            }
            if (this.deleteGeneratedFile) {
                GLogger.println("[delete gg.generateFile()] file:" + realOutputFile + " by template:" + this.getSourceFile());
                new File(realOutputFile).delete();
            }
            else {
                final File file = new File(realOutputFile);
                FileHelper.parnetMkdir(file);
                GLogger.println("[gg.generateFile()] outputFile:" + realOutputFile + " append:" + append + " by template:" + this.getSourceFile());
                IOHelper.saveFile(file, content, this.getOutputEncoding(), append);
            }
        }
        catch (Exception e) {
            GLogger.warn("gg.generateFile() occer error,outputFile:" + outputFile + " caused by:" + e, e);
            throw new RuntimeException("gg.generateFile() occer error,outputFile:" + outputFile + " caused by:" + e, e);
        }
    }
    
    public boolean isOverride() {
        return this.isOverride;
    }
    
    public void setOverride(final boolean isOverride) {
        this.isOverride = isOverride;
    }
    
    public boolean isIgnoreOutput() {
        return this.ignoreOutput;
    }
    
    public void setIgnoreOutput(final boolean ignoreOutput) {
        this.ignoreOutput = ignoreOutput;
    }
    
    public boolean isMergeIfExists() {
        return this.isMergeIfExists;
    }
    
    public void setMergeIfExists(final boolean isMergeIfExists) {
        this.isMergeIfExists = isMergeIfExists;
    }
    
    public String getMergeLocation() {
        return this.mergeLocation;
    }
    
    public void setMergeLocation(final String mergeLocation) {
        this.mergeLocation = mergeLocation;
    }
    
    public String getOutRoot() {
        return this.outRoot;
    }
    
    public void setOutRoot(final String outRoot) {
        this.outRoot = outRoot;
    }
    
    public String getOutputEncoding() {
        return this.outputEncoding;
    }
    
    public void setOutputEncoding(final String outputEncoding) {
        this.outputEncoding = outputEncoding;
    }
    
    public String getSourceFile() {
        return this.sourceFile;
    }
    
    public void setSourceFile(final String sourceFile) {
        this.sourceFile = sourceFile;
    }
    
    public String getSourceDir() {
        return this.sourceDir;
    }
    
    public void setSourceDir(final String sourceDir) {
        this.sourceDir = sourceDir;
    }
    
    public String getSourceFileName() {
        return this.sourceFileName;
    }
    
    public void setSourceFileName(final String sourceFileName) {
        this.sourceFileName = sourceFileName;
    }
    
    public String getSourceEncoding() {
        return this.sourceEncoding;
    }
    
    public void setSourceEncoding(final String sourceEncoding) {
        this.sourceEncoding = sourceEncoding;
    }
    
    public String getOutputFile() {
        if (this.outputFile != null && new File(this.outputFile).isAbsolute()) {
            return this.outputFile;
        }
        return new File(this.getOutRoot(), this.outputFile).getAbsolutePath();
    }
    
    public void setOutputFile(final String outputFile) {
        this.outputFile = outputFile;
    }
    
    public boolean isExistsOutputFile() {
        return new File(this.outRoot, this.outputFile).exists();
    }
    
    public boolean outputFileMatchs(final String regex) throws IOException {
        if (this.isExistsOutputFile()) {
            final String content = IOHelper.readFile(new File(this.outRoot, this.outputFile), this.sourceEncoding);
            if (StringHelper.indexOfByRegex(content, regex) >= 0) {
                return true;
            }
        }
        return false;
    }
    
    public boolean outputFileContains(final String s) throws IOException {
        if (this.isExistsOutputFile()) {
            final String content = IOHelper.readFile(new File(this.outRoot, this.outputFile), this.sourceEncoding);
            return content.contains(s);
        }
        return false;
    }
    
    public String getProperty(final String key, final String defaultValue) {
        return GeneratorProperties.getProperty(key, defaultValue);
    }
    
    public String insertAfter(final String compareToken, final String str) throws IOException {
        final String content = IOHelper.readFile(new File(this.outRoot, this.outputFile).getAbsoluteFile(), this.sourceEncoding);
        if (StringHelper.isBlank(content)) {
            throw new IllegalArgumentException(String.valueOf(new File(this.outRoot, this.outputFile).getAbsolutePath()) + " is blank");
        }
        return StringHelper.insertAfter(content, compareToken, str);
    }
    
    public String insertBefore(final String compareToken, final String str) throws IOException {
        final String content = IOHelper.readFile(new File(this.outRoot, this.outputFile), this.sourceEncoding);
        if (StringHelper.isBlank(content)) {
            throw new IllegalArgumentException(String.valueOf(new File(this.outRoot, this.outputFile).getAbsolutePath()) + " is blank");
        }
        return StringHelper.insertBefore(content, compareToken, str);
    }
    
    public String append(final String str) throws IOException {
        final String content = IOHelper.readFile(new File(this.outRoot, this.outputFile), this.sourceEncoding);
        if (StringHelper.isBlank(content)) {
            throw new IllegalArgumentException(String.valueOf(new File(this.outRoot, this.outputFile).getAbsolutePath()) + " is blank");
        }
        return new StringBuffer(content).append(str).toString();
    }
    
    public String prepend(final String str) throws IOException {
        final String content = IOHelper.readFile(new File(this.outRoot, this.outputFile), this.sourceEncoding);
        if (StringHelper.isBlank(content)) {
            throw new IllegalArgumentException(String.valueOf(new File(this.outRoot, this.outputFile).getAbsolutePath()) + " is blank");
        }
        return new StringBuffer(content).insert(0, str).toString();
    }
    
    public String getInputProperty(final String key) throws IOException {
        return this.getInputProperty(key, "Please input value for " + key + ":");
    }
    
    public String getInputProperty(final String key, final String message) throws IOException {
        String v = GeneratorProperties.getProperty(key);
        if (v == null) {
            if (SystemHelper.isWindowsOS) {
                v = JOptionPane.showInputDialog(null, message, "template:" + this.getSourceFileName(), 0);
            }
            else {
                System.out.print("template:" + this.getSourceFileName() + "," + message);
                v = new BufferedReader(new InputStreamReader(System.in)).readLine();
            }
            GeneratorProperties.setProperty(key, v);
        }
        return v;
    }
    
    public List<Map> queryForList(final String sql, final int limit) throws SQLException {
        final Connection conn = DataSourceProvider.getConnection();
        return SqlExecutorHelper.queryForList(conn, sql, limit);
    }
}
