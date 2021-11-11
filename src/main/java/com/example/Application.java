package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * Application
 *
 * @author wliduo[i@dolyw.com]
 * @date 2018/11/16 19:29
 */
@SpringBootApplication
@tk.mybatis.spring.annotation.MapperScan({"com.example.mapper", "com.example.dao"})
@PropertySource(value = {"classpath:config/generator.properties"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
