/*
 * PDMS wliduo https://github.com/dolyw
 * Created By dolyw.com
 * Date By (2019-04-05 18:00:26)
 */
package com.example.controller;

import cn.org.rapid_framework.generator.Generator;
import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;
import com.example.constant.Constant;
import com.example.dao.GeneratorDao;
import com.example.exception.SystemException;
import com.example.util.SafeProperties;
import com.example.util.ZipUtil;
import com.generator.CustomGeneratorFacade;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
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
 *
 * @author Generator
 * @date 2019-04-05 18:00:26
 */
@RestController
@RequestMapping("database")
public class DataBaseController {

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
     *
     * @author wliduo[i@dolyw.com]
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
        if (list == null) {
            throw new CustomException("查询失败(Query Failure)");
        }
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
        Map<String, Object> result = new HashMap<String, Object>(16);
        result.put("count", pageInfo.getTotal());
        result.put("data", pageInfo.getList());
        return new ResponseBean(HttpStatus.OK.value(), "查询成功", result);
    }

    /**
     * 获取所有表名
     *
     * @author wliduo[i@dolyw.com]
     * @date 2019-04-08 16:00:26
     */
    @GetMapping("/tableNames/all")
    public ResponseBean all() {
        // 获取所有表名
        List<Map<String, Object>> list = generatorDao.queryList(null);
        for (Map<String, Object> table : list) {
            if (StringUtils.isNoneBlank(table.get("tableComment").toString())) {
                table.put("label", table.get("tableName") + "---" + table.get("tableComment") + "---" + table.get("engine"));
            } else {
                table.put("label", table.get("tableName") + "---" + table.get("engine"));
            }
            table.put("value", table.get("tableName"));
        }
        return new ResponseBean(HttpStatus.OK.value(), "查询成功", list);
    }

    /**
     * 表详细字段信息
     *
     * @author wliduo[i@dolyw.com]
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
     * 生成代码到输出路径
     *
     * @author wliduo[i@dolyw.com]
     * @date 2019-04-05 18:00:26
     */
    @PostMapping("/{tableName}")
    public ResponseBean genTable(@PathVariable("tableName") String tableName) throws IOException {
        if (!System.getProperties().getProperty(Constant.OS_NAME).contains(Constant.WINDOWS)) {
            throw new SystemException("操作失败，非" + Constant.WINDOWS + "系统操作环境");
        }
        // 配置表名
        String[] tableNames = tableName.split("-");
        if (outRoot == null) {
            throw new IllegalArgumentException("outRootDir must be not null");
        } else if (outRoot.indexOf(Constant.COLON) < 0) {
            // 项目在硬盘上的基础路径
            outRoot = System.getProperty("user.dir") + outRoot;
        }
        if (genCode(tableNames, outRoot)) {
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
     *
     * @author wliduo[i@dolyw.com]
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
        if (!tempDir.exists()) {
            tempDir.mkdirs();
        }
        // 生成代码到临时路径
        if (genCode(tableNames, tempDir.getPath())) {
            StringBuilder comment = new StringBuilder("项目地址：https://github.com/dolyw/ViewGenerator\r\n\r\n");
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
        } else {
            throw new SystemException("生成失败，请检查数据库是否连接正常及表名是否正确以及权限是否缺失");
        }
    }

    /**
     * 打开Windows系统的代码输出文件夹
     *
     * @author wliduo[i@dolyw.com]
     * @date 2019-04-05 18:00:26
     */
    @GetMapping("/open")
    public ResponseBean open() {
        if (!System.getProperties().getProperty(Constant.OS_NAME).contains(Constant.WINDOWS)) {
            throw new SystemException("操作失败，非" + Constant.WINDOWS + "系统操作环境");
        }
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
     * 读取更新配置文件generator.properties
     *
     * @author wliduo[i@dolyw.com]
     * @date 2019-04-05 18:00:26
     */
    @PutMapping("/config")
    public ResponseBean config(@RequestBody Map<String, String> config) {
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
                    if (Boolean.parseBoolean(config.get("isRead"))) {
                        // 读
                        safeProperties.load(input);
                        config = (Map) safeProperties;
                    } else {
                        // 写
                        safeProperties.load(input);
                        // 遍历map写入
                        Iterator<Map.Entry<String, String>> entries = config.entrySet().iterator();
                        while (entries.hasNext()) {
                            Map.Entry<String, String> entry = entries.next();
                            if (Constant.TEMPLATE.equals(entry.getKey())) {
                                // 查看配置路径下macro.includ文件是否存在
                                File file = new File(Constant.PROJECT_PATH + entry.getValue() + "/macro.include");
                                if (!file.exists()) {
                                    // 模板代码位置不存在
                                    return new ResponseBean(HttpStatus.BAD_REQUEST.value(), "当前填写的模板代码位置不存在", null);
                                }
                            }
                            safeProperties.setProperty(entry.getKey(), entry.getValue());
                        }
                        output = new FileOutputStream(url.getPath());
                        // 更新，服务器热重启
                        safeProperties.store(output, null);
                    }
                } finally {
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
        return new ResponseBean(HttpStatus.OK.value(), "操作成功", config);
    }

    /**
     * 通过表名生成代码
     *
     * @param tableNames 表名数组
     * @param outRoot    代码输出文件夹
     * @return boolean
     * @throws IOException
     * @author wliduo[i@dolyw.com]
     * @date 2019/4/8 17:19
     */
    public boolean genCode(String[] tableNames, String outRoot) throws IOException {
        GeneratorFacade generatorFacade = new CustomGeneratorFacade(outRoot);
        // 配置信息
        GeneratorProperties.load(new String[]{"classpath:config/generator.properties"});
        // 模板位置
        Generator generator = generatorFacade.getGenerator();
        generator.addTemplateRootDir(Constant.PROJECT_PATH + template);
        // 开始执行
        try {
            for (String tableName : tableNames) {
                // 删除旧文件
                generatorFacade.deleteByTable(tableName);
                // 生成新文件
                generatorFacade.generateByTable(tableName);
            }
        } catch (Exception e) {
            System.out.println("----- 生成失败 请检查数据库是否连接正常及表名是否正确以及权限是否缺失 -----");
            e.printStackTrace();
            return false;
        }
        return true;
    }

}