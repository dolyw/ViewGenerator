package com.example.generator;

import cn.org.rapid_framework.generator.Generator;
import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;
import com.example.base.BaseTest;
import com.generator.CustomGeneratorFacade;

/**
 * Test类生成代码
 *
 * @author wliduo[i@dolyw.com]
 * @date 2019/04/08 09:21
 */
public class GeneratorCode extends BaseTest {

    /**
     * 项目在硬盘上的基础路径
     */
    private static final String PROJECT_PATH = System.getProperty("user.dir");

    /**
     * 生成代码板位置
     */
    private static final String OUT_ROOT = "E:/work/outRoot";

    /**
     * 配置文件位置
     */
    private static final String CONFIG_PATH = PROJECT_PATH + "/src/main/resources/config/generator.properties";

    /**
     * 代码模板位置
     */
    private static final String TEMPLATE_FILE_PATH = PROJECT_PATH + "/src/main/resources/template/two/RESTful";

    /**
     * 有三点需要引起特别的注意
     * (1)配置resource下config/generator.properties数据库信息
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
    public static void genCode(String... tableNames) throws Exception {
        // GeneratorFacade
        GeneratorFacade generatorFacade = new CustomGeneratorFacade(OUT_ROOT);
        // 配置信息
        GeneratorProperties.load(CONFIG_PATH);
        // 模板位置
        Generator generator = generatorFacade.getGenerator();
        generator.addTemplateRootDir(TEMPLATE_FILE_PATH);
        // 开始执行
        try {
            for (String tableName : tableNames) {
                // 删除旧文件
                generatorFacade.deleteByTable(tableName);
                // 生成新文件
                generatorFacade.generateByTable(tableName);
            }
            // 打开文件夹
            Runtime.getRuntime().exec("cmd.exe /c start " + OUT_ROOT);
        } catch (Exception e) {
            System.out.println("----- 生成失败 请检查数据库是否连接正常及表名是否正确以及权限是否缺失 -----");
            e.printStackTrace();
        }
    }
}
