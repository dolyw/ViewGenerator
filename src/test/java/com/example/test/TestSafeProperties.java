package com.example.test;

import com.example.base.BaseTest;
import com.example.util.SafeProperties;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;

/**
 * 参考https://blog.csdn.net/xiaosemei/article/details/77334677
 *
 * @author wliduo[i@dolyw.com]
 * @date 2018/11/15 17:13
 */
public class TestSafeProperties extends BaseTest {

    /**
     * SafeProperties读写
     * @throws Exception
     */
    @Test
    public void write() throws Exception {
        final Enumeration urls = TestSafeProperties.class.getClassLoader().getResources("config/generator.properties");
        while (urls.hasMoreElements()) {
            final URL url = (URL) urls.nextElement();
            InputStream input = null;
            OutputStream output = null;
            try {
                final URLConnection con = url.openConnection();
                con.setUseCaches(false);
                input = con.getInputStream();
                SafeProperties safeProperties = new SafeProperties();
                // 读
                safeProperties.load(input);
                // 写
                safeProperties.setProperty("outRoot", "/src2");
                output = new FileOutputStream(url.getPath());
                safeProperties.store(output, null);
            }
            finally {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
            }
        }
    }
}
