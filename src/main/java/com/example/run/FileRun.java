package com.example.run;

import com.example.constant.Constant;
import com.example.controller.DataBaseController;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;

/**
 * FileRun
 *
 * @author wliduo[i@dolyw.com]
 * @date 2021/11/15 15:07
 */
@Component
public class FileRun implements CommandLineRunner {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(FileRun.class);

    @Override
    public void run(String... strings) throws Exception {
        File file = new File(Constant.CONFIG_PATH_TEMP);
        if (!file.exists()) {
            InputStream properties = FileRun.class.getClassLoader().getResourceAsStream(Constant.CONFIG_PATH);
            FileUtils.copyInputStreamToFile(properties, file);
        }
    }

    /**
     * 递归获取文件
     *
     * @param files
	 * @param tmpDir
     * @return void
     * @throws
     * @author wliduo[i@dolyw.com]
     * @date 2021/11/16 17:21
     */
    public void getFile(File[] files, String tmpDir) {
        if (files == null) {
            return;
        }
        for (int i = 0; i < files.length; i++) {
            // 如果是文件
            if (files[i].isFile()) {
                // FileUtil.copy(files[i], new File(tmpDir + files[i].getAbsolutePath().substring(files[i].getAbsolutePath().indexOf("template" + File.separator + "two"))), true);
            } else if (files[i].isDirectory()) {
                // 如果是文件夹需要调用递归，深度+1
                getFile(files[i].listFiles(), tmpDir);
            }
        }
    }
}
