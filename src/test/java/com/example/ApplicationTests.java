package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(value = {"classpath:config/generator.properties"})
public class ApplicationTests {

    @Test
    public void contextLoads() {
    }

}
