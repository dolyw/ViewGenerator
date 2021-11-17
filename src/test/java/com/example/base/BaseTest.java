package com.example.base;

import com.example.Application;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

/**
 * 单元测试继承该类即可
 */
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional(rollbackFor = Exception.class)
@TestPropertySource(value = {"classpath:config/generator.properties"})
@Rollback
public abstract class BaseTest {}