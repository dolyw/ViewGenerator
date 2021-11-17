package com.example.constant;

import java.io.File;

/**
 * Constant
 *
 * @author wliduo[i@dolyw.com]
 * @date 2019/4/6 19:50
 */
public interface Constant {

    /**
     * 项目在硬盘上的基础路径
     */
    String PROJECT_PATH = System.getProperty("user.dir");

    /**
     * 冒号
     */
    String COLON = ":";

    /**
     * 模板
     */
    String TEMPLATE = "template";

    /**
     * OS_NAME
     */
    String OS_NAME = "os.name";

    /**
     * Windows
     */
    String WINDOWS = "Windows";

    /**
     * TMEP_DIR
     */
    String TMEP_DIR = PROJECT_PATH + File.separator + "temp" + File.separator;

    /**
     * CONFIG_PATH
     */
    String CONFIG_PATH = "config" + File.separator + "generator.properties";

    /**
     * CONFIG_PATH_TEMP
     */
    String CONFIG_PATH_TEMP = TMEP_DIR + File.separator + CONFIG_PATH;

}
