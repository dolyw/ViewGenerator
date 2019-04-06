package com.uframe.generator;

import com.uframe.generator.provider.db.table.*;
import com.uframe.generator.provider.db.table.model.*;
import com.uframe.generator.provider.db.sql.model.*;
import com.uframe.generator.provider.db.procedure.*;
import com.uframe.generator.provider.db.procedure.model.*;
import com.uframe.generator.provider.java.model.*;
import java.util.*;
import java.io.*;
import com.uframe.generator.util.*;

public class GeneratorFacade
{
    public Generator g;
    
    public GeneratorFacade() {
        (this.g = new Generator()).setOutRootDir(GeneratorProperties.getProperty("outRoot"));
    }

    public GeneratorFacade(String outRootDir) {
        (this.g = new Generator()).setOutRootDir(outRootDir);
    }
    
    public static void printAllTableNames() throws Exception {
        PrintUtils.printAllTableNames(TableFactory.getInstance().getAllTables());
    }
    
    public void deleteOutRootDir() throws IOException {
        this.g.deleteOutRootDir();
    }
    
    public void generateByMap(final Map map, final String templateRootDir) throws Exception {
        new ProcessUtils().processByMap(map, templateRootDir, false);
    }
    
    public void deleteByMap(final Map map, final String templateRootDir) throws Exception {
        new ProcessUtils().processByMap(map, templateRootDir, true);
    }
    
    public void generateByAllTable(final String templateRootDir) throws Exception {
        new ProcessUtils().processByAllTable(templateRootDir, false);
    }
    
    public void deleteByAllTable(final String templateRootDir) throws Exception {
        new ProcessUtils().processByAllTable(templateRootDir, true);
    }
    
    public void generateByTable(final String tableName, final String templateRootDir) throws Exception {
        new ProcessUtils().processByTable(tableName, templateRootDir, false);
    }
    
    public void deleteByTable(final String tableName, final String templateRootDir) throws Exception {
        new ProcessUtils().processByTable(tableName, templateRootDir, true);
    }
    
    public void generateByProcedure(final String procedureName, final String templateRootDir) throws Exception {
        new ProcessUtils().processByProcedure(procedureName, templateRootDir, false);
    }
    
    public void generateByClass(final Class clazz, final String templateRootDir) throws Exception {
        new ProcessUtils().processByClass(clazz, templateRootDir, false);
    }
    
    public void deleteByClass(final Class clazz, final String templateRootDir) throws Exception {
        new ProcessUtils().processByClass(clazz, templateRootDir, true);
    }
    
    public void generateBySql(final Sql sql, final String templateRootDir) throws Exception {
        new ProcessUtils().processBySql(sql, templateRootDir, false);
    }
    
    public void deleteBySql(final Sql sql, final String templateRootDir) throws Exception {
        new ProcessUtils().processBySql(sql, templateRootDir, true);
    }
    
    private Generator getGenerator(final String templateRootDir) {
        this.g.setTemplateRootDir(new File(templateRootDir).getAbsoluteFile());
        return this.g;
    }
    
    public static class GeneratorContext
    {
        static ThreadLocal<Map> context;
        
        static {
            GeneratorContext.context = new ThreadLocal<Map>();
        }
        
        public static void clear() {
            final Map m = GeneratorContext.context.get();
            if (m != null) {
                m.clear();
            }
        }
        
        public static Map getContext() {
            final Map map = GeneratorContext.context.get();
            if (map == null) {
                setContext(new HashMap());
            }
            return GeneratorContext.context.get();
        }
        
        public static void setContext(final Map map) {
            GeneratorContext.context.set(map);
        }
        
        public static void put(final String key, final Object value) {
            getContext().put(key, value);
        }
    }
    
    public class ProcessUtils
    {
        public void processByMap(final Map params, final String templateRootDir, final boolean isDelete) throws Exception, FileNotFoundException {
            final Generator g = GeneratorFacade.this.getGenerator(templateRootDir);
            final Generator.GeneratorModel m = GeneratorModelUtils.newFromMap(params);
            this.processByGeneratorModel(templateRootDir, isDelete, g, m);
        }
        
        public void processBySql(final Sql sql, final String templateRootDir, final boolean isDelete) throws Exception {
            final Generator g = GeneratorFacade.this.getGenerator(templateRootDir);
            final Generator.GeneratorModel m = GeneratorModelUtils.newFromSql(sql);
            PrintUtils.printBeginProcess("sql:" + sql.getSourceSql(), isDelete);
            this.processByGeneratorModel(templateRootDir, isDelete, g, m);
        }
        
        public void processByClass(final Class clazz, final String templateRootDir, final boolean isDelete) throws Exception, FileNotFoundException {
            final Generator g = GeneratorFacade.this.getGenerator(templateRootDir);
            final Generator.GeneratorModel m = GeneratorModelUtils.newFromClass(clazz);
            PrintUtils.printBeginProcess("JavaClass:" + clazz.getSimpleName(), isDelete);
            this.processByGeneratorModel(templateRootDir, isDelete, g, m);
        }
        
        private void processByGeneratorModel(final String templateRootDir, final boolean isDelete, final Generator g, final Generator.GeneratorModel m) throws Exception, FileNotFoundException {
            try {
                if (isDelete) {
                    g.deleteBy(m.templateModel, m.filePathModel);
                }
                else {
                    g.generateBy(m.templateModel, m.filePathModel);
                }
            }
            catch (GeneratorException ge) {
                PrintUtils.printExceptionsSumary(ge.getMessage(), GeneratorFacade.this.getGenerator(templateRootDir).getOutRootDir(), ge.getExceptions());
            }
        }
        
        public void processByTable(final String tableName, final String templateRootDir, final boolean isDelete) throws Exception {
            if ("*".equals(tableName)) {
                if (isDelete) {
                    GeneratorFacade.this.deleteByAllTable(templateRootDir);
                }
                else {
                    GeneratorFacade.this.generateByAllTable(templateRootDir);
                }
                return;
            }
            final Generator g = GeneratorFacade.this.getGenerator(templateRootDir);
            final Table table = TableFactory.getInstance().getTable(tableName);
            try {
                this.processByTable(g, table, isDelete);
            }
            catch (GeneratorException ge) {
                PrintUtils.printExceptionsSumary(ge.getMessage(), GeneratorFacade.this.getGenerator(templateRootDir).getOutRootDir(), ge.getExceptions());
            }
        }
        
        public void processByAllTable(final String templateRootDir, final boolean isDelete) throws Exception {
            final List<Table> tables = (List<Table>)TableFactory.getInstance().getAllTables();
            final List exceptions = new ArrayList();
            for (int i = 0; i < tables.size(); ++i) {
                try {
                    this.processByTable(GeneratorFacade.this.getGenerator(templateRootDir), tables.get(i), isDelete);
                }
                catch (GeneratorException ge) {
                    exceptions.addAll(ge.getExceptions());
                }
            }
            PrintUtils.printExceptionsSumary("", GeneratorFacade.this.getGenerator(templateRootDir).getOutRootDir(), exceptions);
        }
        
        public void processByTable(final Generator g, final Table table, final boolean isDelete) throws Exception {
            final Generator.GeneratorModel m = GeneratorModelUtils.newFromTable(table);
            PrintUtils.printBeginProcess(String.valueOf(table.getSqlName()) + " => " + table.getClassName(), isDelete);
            if (isDelete) {
                g.deleteBy(m.templateModel, m.filePathModel);
            }
            else {
                g.generateBy(m.templateModel, m.filePathModel);
            }
        }
        
        public void processByProcedure(final String procedureName, final String templateRootDir, final boolean isDelete) throws Exception {
            final Generator g = GeneratorFacade.this.getGenerator(templateRootDir);
            final Procedure procedure = ProcedureFactory.getInstance().getProcedure(procedureName);
            try {
                this.processByProcedure(g, procedure, isDelete);
            }
            catch (GeneratorException ge) {
                PrintUtils.printExceptionsSumary(ge.getMessage(), GeneratorFacade.this.getGenerator(templateRootDir).getOutRootDir(), ge.getExceptions());
            }
        }
        
        public void processByProcedure(final Generator g, final Procedure procedure, final boolean isDelete) throws Exception {
            final Generator.GeneratorModel m = GeneratorModelUtils.newFromProcedure(procedure);
            PrintUtils.printBeginProcess(String.valueOf(procedure.getPackageName()) + " => " + procedure.getProcedureName(), isDelete);
            if (isDelete) {
                g.deleteBy(m.templateModel, m.filePathModel);
            }
            else {
                g.generateBy(m.templateModel, m.filePathModel);
            }
        }
    }
    
    public static class GeneratorModelUtils
    {
        public static Generator.GeneratorModel newFromTable(final Table table) {
            final Map templateModel = new HashMap();
            templateModel.put("table", table);
            setShareVars(templateModel);
            final Map filePathModel = new HashMap();
            setShareVars(filePathModel);
            filePathModel.putAll(BeanHelper.describe(table));
            return new Generator.GeneratorModel(templateModel, filePathModel);
        }
        
        public static Generator.GeneratorModel newFromProcedure(final Procedure procedure) throws Exception {
            final Map templateModel = new HashMap();
            templateModel.put("procedure", procedure);
            setShareVars(templateModel);
            final Map filePathModel = new HashMap();
            setShareVars(filePathModel);
            filePathModel.putAll(BeanHelper.describe(procedure));
            return new Generator.GeneratorModel(templateModel, filePathModel);
        }
        
        public static Generator.GeneratorModel newFromSql(final Sql sql) throws Exception {
            final Map templateModel = new HashMap();
            templateModel.put("sql", sql);
            setShareVars(templateModel);
            final Map filePathModel = new HashMap();
            setShareVars(filePathModel);
            filePathModel.putAll(BeanHelper.describe(sql));
            return new Generator.GeneratorModel(templateModel, filePathModel);
        }
        
        public static Generator.GeneratorModel newFromClass(final Class clazz) {
            final Map templateModel = new HashMap();
            templateModel.put("clazz", new JavaClass(clazz));
            setShareVars(templateModel);
            final Map filePathModel = new HashMap();
            setShareVars(filePathModel);
            filePathModel.putAll(BeanHelper.describe(new JavaClass(clazz)));
            return new Generator.GeneratorModel(templateModel, filePathModel);
        }
        
        public static Generator.GeneratorModel newFromMap(final Map params) {
            final Map templateModel = new HashMap();
            templateModel.putAll(params);
            setShareVars(templateModel);
            final Map filePathModel = new HashMap();
            setShareVars(filePathModel);
            filePathModel.putAll(params);
            return new Generator.GeneratorModel(templateModel, filePathModel);
        }
        
        public static void setShareVars(final Map templateModel) {
            templateModel.putAll(GeneratorProperties.getProperties());
            templateModel.putAll(System.getProperties());
            templateModel.put("env", System.getenv());
            templateModel.put("now", new Date());
            templateModel.putAll(GeneratorContext.getContext());
        }
    }
    
    private static class PrintUtils
    {
        public static void printExceptionsSumary(final String msg, final String outRoot, final List<Exception> exceptions) throws FileNotFoundException {
            final File errorFile = new File(outRoot, "generator_error.log");
            if (exceptions != null && exceptions.size() > 0) {
                System.err.println("[Generate Error Summary] : " + msg);
                final PrintStream output = new PrintStream(new FileOutputStream(errorFile));
                for (int i = 0; i < exceptions.size(); ++i) {
                    final Exception e = exceptions.get(i);
                    System.err.println("[GENERATE ERROR]:" + e);
                    if (i == 0) {
                        e.printStackTrace();
                    }
                    e.printStackTrace(output);
                }
                output.close();
                System.err.println("***************************************************************");
                System.err.println("* * \u8f93\u51fa\u76ee\u5f55\u5df2\u7ecf\u751f\u6210generator_error.log\u7528\u4e8e\u67e5\u770b\u9519\u8bef ");
                System.err.println("***************************************************************");
            }
        }
        
        public static void printBeginProcess(final String displayText, final boolean isDatele) {
            GLogger.println("***************************************************************");
            GLogger.println("* BEGIN " + (isDatele ? " delete by " : " generate by ") + displayText);
            GLogger.println("***************************************************************");
        }
        
        public static void printAllTableNames(final List<Table> tables) throws Exception {
            GLogger.println("\n----All TableNames BEGIN----");
            for (int i = 0; i < tables.size(); ++i) {
                final String sqlName = tables.get(i).getSqlName();
                GLogger.println("g.generateTable(\"" + sqlName + "\");");
            }
            GLogger.println("----All TableNames END----");
        }
    }
}
