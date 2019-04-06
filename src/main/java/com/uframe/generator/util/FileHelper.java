package com.uframe.generator.util;

import com.uframe.generator.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class FileHelper
{
    public static List ignoreList;
    public static Set binaryExtentionsList;

    // 项目在硬盘上的基础路径
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    // binary_filelist.txt位置
    private static final String FILE_PATH = PROJECT_PATH + "/src/main/resources/config/binary_filelist.txt";
    
    static {
        (FileHelper.ignoreList = new ArrayList()).add(".svn");
        FileHelper.ignoreList.add("CVS");
        FileHelper.ignoreList.add(".cvsignore");
        FileHelper.ignoreList.add(".copyarea.db");
        FileHelper.ignoreList.add("SCCS");
        FileHelper.ignoreList.add("vssver.scc");
        FileHelper.ignoreList.add(".DS_Store");
        FileHelper.ignoreList.add(".git");
        FileHelper.ignoreList.add(".gitignore");
        FileHelper.binaryExtentionsList = new HashSet();
        // loadBinaryExtentionsList("binary_filelist.txt", true);
        loadBinaryExtentionsList(FILE_PATH, false);
    }
    
    public static String getRelativePath(final File baseDir, final File file) {
        if (baseDir.equals(file)) {
            return "";
        }
        if (baseDir.getParentFile() == null) {
            return file.getAbsolutePath().substring(baseDir.getAbsolutePath().length());
        }
        return file.getAbsolutePath().substring(baseDir.getAbsolutePath().length() + 1);
    }
    
    public static List<File> searchAllNotIgnoreFile(final File dir) throws IOException {
        final ArrayList arrayList = new ArrayList();
        searchAllNotIgnoreFile(dir, arrayList);
        Collections.sort((List<File>)arrayList, (Comparator<? super File>)new Comparator<File>() {
            @Override
            public int compare(final File o1, final File o2) {
                return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
            }
        });
        return (List<File>)arrayList;
    }
    
    public static InputStream getInputStream(final String file) throws FileNotFoundException {
        InputStream inputStream = null;
        if (file.startsWith("classpath:")) {
            inputStream = FileHelper.class.getClassLoader().getResourceAsStream(file.substring("classpath:".length()));
        }
        else {
            inputStream = new FileInputStream(file);
        }
        return inputStream;
    }
    
    public static void searchAllNotIgnoreFile(final File dir, final List<File> collector) throws IOException {
        collector.add(dir);
        if (!dir.isHidden() && dir.isDirectory() && !isIgnoreFile(dir)) {
            final File[] subFiles = dir.listFiles();
            for (int i = 0; i < subFiles.length; ++i) {
                searchAllNotIgnoreFile(subFiles[i], collector);
            }
        }
    }
    
    public static File mkdir(final String dir, final String file) {
        if (dir == null) {
            throw new IllegalArgumentException("dir must be not null");
        }
        final File result = new File(dir, file);
        parnetMkdir(result);
        return result;
    }
    
    public static File parentMkdir(final String file) {
        if (file == null) {
            throw new IllegalArgumentException("file must be not null");
        }
        final File result = new File(file);
        parnetMkdir(result);
        return result;
    }
    
    public static void parnetMkdir(final File outputFile) {
        if (outputFile.getParentFile() != null) {
            outputFile.getParentFile().mkdirs();
        }
    }
    
    public static File getFileByClassLoader(final String resourceName) throws IOException {
        final Enumeration<URL> urls = GeneratorProperties.class.getClassLoader().getResources(resourceName);
        if (urls.hasMoreElements()) {
            return new File(urls.nextElement().getFile());
        }
        throw new FileNotFoundException(resourceName);
    }
    
    private static boolean isIgnoreFile(final File file) {
        for (int i = 0; i < FileHelper.ignoreList.size(); ++i) {
            if (file.getName().equals(FileHelper.ignoreList.get(i))) {
                return true;
            }
        }
        return false;
    }
    
    public static void loadBinaryExtentionsList(final String resourceName, final boolean ignoreException) {
        try {
            // final InputStream input = GeneratorProperties.class.getClassLoader().getResourceAsStream(resourceName);
            // FileHelper.binaryExtentionsList.addAll(IOHelper.readLines(new InputStreamReader(input)));
            // input.close();
            File filename = new File(resourceName);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
            FileHelper.binaryExtentionsList.addAll(IOHelper.readLines(reader));
            reader.close();
        }
        catch (Exception e) {
            if (!ignoreException) {
                throw new RuntimeException(e);
            }
        }
    }
    
    public static boolean isBinaryFile(final File file) {
        return !file.isDirectory() && isBinaryFile(file.getName());
    }
    
    public static boolean isBinaryFile(final String filename) {
        return !StringHelper.isBlank(getExtension(filename)) && FileHelper.binaryExtentionsList.contains(getExtension(filename).toLowerCase());
    }
    
    public static String getExtension(final String filename) {
        if (filename == null) {
            return null;
        }
        final int index = filename.indexOf(".");
        if (index == -1) {
            return "";
        }
        return filename.substring(index + 1);
    }
    
    public static void deleteDirectory(final File directory) throws IOException {
        if (!directory.exists()) {
            return;
        }
        cleanDirectory(directory);
        if (!directory.delete()) {
            final String message = "Unable to delete directory " + directory + ".";
            throw new IOException(message);
        }
    }
    
    public static boolean deleteQuietly(final File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                cleanDirectory(file);
            }
        }
        catch (Exception ex) {}
        try {
            return file.delete();
        }
        catch (Exception e) {
            return false;
        }
    }
    
    public static void cleanDirectory(final File directory) throws IOException {
        if (!directory.exists()) {
            final String message = directory + " does not exist";
            throw new IllegalArgumentException(message);
        }
        if (!directory.isDirectory()) {
            final String message = directory + " is not a directory";
            throw new IllegalArgumentException(message);
        }
        final File[] files = directory.listFiles();
        if (files == null) {
            throw new IOException("Failed to list contents of " + directory);
        }
        IOException exception = null;
        for (int i = 0; i < files.length; ++i) {
            final File file = files[i];
            try {
                forceDelete(file);
            }
            catch (IOException ioe) {
                exception = ioe;
            }
        }
        if (exception != null) {
            throw exception;
        }
    }
    
    public static void forceDelete(final File file) throws IOException {
        if (file.isDirectory()) {
            deleteDirectory(file);
        }
        else {
            final boolean filePresent = file.exists();
            if (!file.delete()) {
                if (!filePresent) {
                    throw new FileNotFoundException("File does not exist: " + file);
                }
                final String message = "Unable to delete file: " + file;
                throw new IOException(message);
            }
        }
    }
}
