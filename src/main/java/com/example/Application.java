package com.example;

import cn.hutool.setting.dialect.Props;
import com.example.constant.Constant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Application
 *
 * @author wliduo[i@dolyw.com]
 * @date 2018/11/16 19:29
 */
@SpringBootApplication
@tk.mybatis.spring.annotation.MapperScan({"com.example.mapper", "com.example.dao"})
/*@PropertySource(value = {"classpath:config/generator.properties"})*/
public class Application {

    public static String[] args;
    public static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.setDefaultProperties(config());
        Application.args = args;
        Application.context = application.run(args);
    }

    /**
     * 配置选择
     *
     * @param
     * @return cn.hutool.setting.dialect.Props
     * @throws
     * @author wliduo[i@dolyw.com]
     * @date 2021/11/17 13:50
     */
    public static Props config() {
        File file = new File(Constant.CONFIG_PATH_TEMP);
        if (file.exists()) {
            return new Props(Constant.CONFIG_PATH_TEMP);
        } else {
            return new Props("classpath:config/generator.properties");
        }
    }

    /**
     * 重启项目方法，注意，必须将maven的spring-boot-devtools开发热部署包去除
     * 不然重启后ConfigurableApplicationContext会为空
     *
     * https://blog.csdn.net/weixin_44695125/article/details/108059877
     */
    public static void restart() {
        ExecutorService threadPool = new ThreadPoolExecutor(1, 1, 0,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.DiscardOldestPolicy());
        threadPool.execute(() -> {
            // SpringApplication.exit(context);
            context.close();
            SpringApplication application = new SpringApplication(Application.class);
            application.setDefaultProperties(config());
            Application.context = application.run(args);
        });
        threadPool.shutdown();
    }
}
