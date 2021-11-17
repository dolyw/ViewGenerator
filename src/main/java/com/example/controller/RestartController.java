package com.example.controller;

import com.example.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 重新启动项目
 *
 * @author wliduo[i@dolyw.com]
 * @date 2021/11/17 11:14
 */
@RestController
public class RestartController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(RestartController.class);

    /**
     * 重新启动项目
     *
     * @param
     * @return java.lang.String
     * @throws
     * @author wliduo[i@dolyw.com]
     * @date 2021/11/17 11:14
     */
    @GetMapping("/restart")
    public String restart() {
        Application.restart();
        return "success";
    }

}
