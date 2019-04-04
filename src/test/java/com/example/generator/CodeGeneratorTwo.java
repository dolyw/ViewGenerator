package com.example.generator;

import com.uframe.generator.Generator;
import com.uframe.generator.GeneratorFacade;
import com.uframe.generator.GeneratorProperties;

/**
 * 代码生成2.0(根据表生成对应模板的的Model、Mapper、Service、Controller、JS、JSP)
 * @author Wang926454
 * @date 2019/4/1 18:38
 */
public class CodeGeneratorTwo {

    /**
     * 项目在硬盘上的基础路径
     */
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    /**
     * 生成代码模板位置
     */
    private static final String TEMPLATE_FILE_PATH = PROJECT_PATH + "/src/test/resources/template/two/RESTful";

    /**
     * 有三点需要引起特别的注意
     * (1)数据库连接必须配置
     * (2)表无主键，无法生成
     * (3)外键关联的表无读权限，无法生成
     */
    public static void main(String[] args) throws Exception {
        // 配置表名
        genCode("user", "role");
    }

    /**
     * 通过表名称生成代码
     * @param tableNames
     */
    public static void genCode(String... tableNames) {
        // GeneratorFacade
        GeneratorFacade generatorFacade = new GeneratorFacade();
        // 开始执行
        try {
            // 删除旧文件
            generatorFacade.deleteByAllTable(TEMPLATE_FILE_PATH);
            for (String tableName : tableNames) {
                // 生成新文件
                generatorFacade.generateByTable(tableName, TEMPLATE_FILE_PATH);
            }
            System.out.println("----- 生成成功 -----");
            // 打开生成目录
            // Runtime.getRuntime().exec("cmd.exe /c start " + GeneratorProperties.getRequiredProperty("outRoot"));
            Runtime.getRuntime().exec("cmd.exe /c start " + Generator.getOutRootDir());
        } catch (Exception e) {
            System.out.println("----- 生成失败 请检查数据库是否连接正常及表名是否正确以及权限是否缺失 -----");
            e.printStackTrace();
        }
    }
}
