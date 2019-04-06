/*
 * PDMS wliduo https://github.com/wang926454
 * Created By Wang926454
 * Date By (2019-04-05 18:00:26)
 */
package com.example.controller;

import com.example.dao.GeneratorDao;
import com.example.exception.SystemException;
import com.example.util.SafeProperties;
import com.example.util.ZipUtil;
import com.uframe.generator.GeneratorFacade;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.common.ResponseBean;
import com.example.exception.CustomException;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

/**
 * DataBaseController
 * @author Generator
 * @date 2019-04-05 18:00:26
 */
@RestController
@RequestMapping("database")
public class DataBaseController {

    /**
     * 项目在硬盘上的基础路径
     */
    private static final String PROJECT_PATH = System.getProperty("user.dir");

    /**
     * 代码生成的文件输出路径
     */
    @Value("${outRoot}")
    private String outRoot;

    /**
     * 模板代码位置(项目相对路径)
     */
    @Value("${template}")
    private String template;

    /**
     * GeneratorDao
     */
    private final GeneratorDao generatorDao;

    @Autowired
    public DataBaseController(GeneratorDao generatorDao) {
        this.generatorDao = generatorDao;
    }

    /**
     * 列表
     * @author Generator
     * @date 2019-04-05 18:00:26
     */
    @GetMapping
    public ResponseBean list(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer rows,
                             String tableName) {
        if (page <= 0 || rows <= 0) {
            page = 1;
            rows = 10;
        }
        Map<String, Object> map = new HashMap<String, Object>(16);
        map.put("tableName", tableName);
        PageHelper.startPage(page, rows);
        List<Map<String, Object>> list = generatorDao.queryList(map);
        if (list == null || list.size() <= 0) {
            throw new CustomException("查询失败(Query Failure)");
        }
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
        Map<String, Object> result = new HashMap<String, Object>(16);
        result.put("count", pageInfo.getTotal());
        result.put("data", pageInfo.getList());
        return new ResponseBean(HttpStatus.OK.value(), "查询成功", result);
    }

    /**
     * 表详细字段信息
     * @author Generator
     * @date 2019-04-05 18:00:26
     */
    @GetMapping("/{tableName}")
    public ResponseBean detail(@PathVariable("tableName") String tableName) {
        // 查询表信息
        Map<String, String> table = generatorDao.queryTable(tableName);
        // 查询列信息
        List<Map<String, String>> columns = generatorDao.queryColumns(tableName);
        return new ResponseBean(HttpStatus.OK.value(), "查询成功", columns);
    }

    /**
     * 打开Windows的代码输出文件夹
     * @author Generator
     * @date 2019-04-05 18:00:26
     */
    @GetMapping("/open")
    public ResponseBean open() {
        try {
            // 有:应该是全路径
            String[] array = outRoot.split(":");
            if (array.length - 1 >= 0) {
                Runtime.getRuntime().exec("cmd.exe /c start " + outRoot);
            } else {
                // 项目在硬盘上的基础路径
                Runtime.getRuntime().exec("cmd.exe /c start " + System.getProperty("user.dir") + outRoot);
            }
        } catch (IOException e) {
            throw new SystemException("操作失败");
        }
        return new ResponseBean(HttpStatus.OK.value(), "操作成功", null);
    }

    /**
     * 生成代码到输出路径
     * @author Generator
     * @date 2019-04-05 18:00:26
     */
    @PostMapping("/{tableName}")
    public ResponseBean genTable(@PathVariable("tableName") String tableName) {
        // 配置表名
        String[] tableNames = tableName.split("-");
        if (genCode(tableNames, null)) {
            System.out.println("----- 生成成功 -----");
            // 获得系统属性集
            Properties props = System.getProperties();
            // 操作系统名称
            String osName = props.getProperty("os.name");
            // 操作系统构架
            String osArch = props.getProperty("os.arch");
            // 操作系统版本
            String osVersion = props.getProperty("os.version");
            // 判断是否为Windows系统，如果是返回前端
            String[] array = osName.split("Windows");
            if (array.length - 1 > 0) {
                return new ResponseBean(HttpStatus.OK.value(), "生成代码成功", osName);
            }
            return new ResponseBean(HttpStatus.OK.value(), "生成代码成功", null);
        }
        return new ResponseBean(HttpStatus.BAD_REQUEST.value(), "生成失败，请检查数据库是否连接正常及表名是否正确以及权限是否缺失", null);
    }

    /**
     * 生成代码为Zip文件下载
     * @author Generator
     * @date 2019-04-05 18:00:26
     */
    @GetMapping("/zip/{tableName}")
    public void genTableToZip(@PathVariable("tableName") String tableName,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws IOException {
        // 配置表名
        String[] tableNames = tableName.split("-");
        // 获得临时路径
        String loadPath = request.getSession().getServletContext().getRealPath("/");
        // 创建临时路径
        File tempDir = new File(loadPath + "/code");
        if(!tempDir.exists()){
            tempDir.mkdirs();
        }
        // 生成代码到临时路径
        if (genCode(tableNames, tempDir.getPath())) {
            StringBuilder comment = new StringBuilder("项目地址：https://github.com/wang926454/SpringBootGenerator\r\n\r\n");
            for (String tempName : tableNames) {
                comment.append(tempName + "\r\n");
            }
            // 压缩文件下载
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ZipUtil.toZip(tempDir.getPath(), outputStream, comment.toString(), true);
            byte[] data = outputStream.toByteArray();
            response.reset();
            response.setHeader("Content-Disposition", "attachment; filename=\"GeneratorCode.zip\"");
            response.addHeader("Content-Length", "" + data.length);
            response.setContentType("application/octet-stream; charset=UTF-8");
            IOUtils.write(data, response.getOutputStream());
            // 删除临时路径下所有临时文件
            FileUtils.deleteDirectory(tempDir);
        }
    }

    /**
     * 通过表名称生成代码
     * @param tableNames
     */
    public boolean genCode(String[] tableNames, String outRootDir) {
        // GeneratorFacade
        GeneratorFacade generatorFacade = null;
        if (outRootDir == null) {
            generatorFacade = new GeneratorFacade();
        } else {
            generatorFacade = new GeneratorFacade(outRootDir);
        }
        // 开始执行
        try {
            for (String tableName : tableNames) {
                // 有设置输出路径说明为临时路径，不需要旧删除文件
                if (outRootDir == null) {
                    // 删除旧文件
                    generatorFacade.deleteByTable(tableName, PROJECT_PATH + template);
                }
                // 生成新文件
                generatorFacade.generateByTable(tableName, PROJECT_PATH + template);
            }
        } catch (Exception e) {
            System.out.println("----- 生成失败 请检查数据库是否连接正常及表名是否正确以及权限是否缺失 -----");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 读取更新配置文件generator.properties
     * @author Generator
     * @date 2019-04-05 18:00:26
     */
    @PutMapping("/config")
    public ResponseBean config(@RequestBody Map<String, String> map) {
        try {
            final Enumeration urls = DataBaseController.class.getClassLoader().getResources("config/generator.properties");
            while (urls.hasMoreElements()) {
                final URL url = (URL) urls.nextElement();
                InputStream input = null;
                OutputStream output = null;
                try {
                    final URLConnection con = url.openConnection();
                    con.setUseCaches(false);
                    input = con.getInputStream();
                    SafeProperties safeProperties = new SafeProperties();
                    if (Boolean.parseBoolean(map.get("isRead"))) {
                        // 读
                        safeProperties.load(input);
                        map = (Map) safeProperties;
                    } else {
                        // 写
                        safeProperties.load(input);
                        // 遍历map写入
                        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
                        while (entries.hasNext()) {
                            Map.Entry<String, String> entry = entries.next();
                            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                            safeProperties.setProperty(entry.getKey(), entry.getValue());
                        }
                        output = new FileOutputStream(url.getPath());
                        // 更新，服务器热重启
                        safeProperties.store(output, null);
                    }
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
        } catch (IOException e) {
            throw new SystemException("操作失败");
        }
        return new ResponseBean(HttpStatus.OK.value(), "操作成功", map);
    }

}