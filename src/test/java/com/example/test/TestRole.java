package com.example.test;

import com.example.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

/**
 * 参考https://my.oschina.net/zjllovecode/blog/1605981
 * @author Wang926454
 * @date 2018/11/15 17:13
 */
public class TestRole extends BaseTest {

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * 测试REST类型Controller列表
     * @throws Exception
     */
    @Test
    public void get() throws Exception {
        String body = this.restTemplate.getForObject("/role", String.class);
        System.out.println(body);
    }

    /**
     * 测试POST类型Controller列表
     * @throws Exception
     */
    @Test
    public void post() throws Exception {
        ResponseEntity<String> body = this.restTemplate.postForEntity("/role/list", "", String.class);
        System.out.println(body);
    }
}
