## SpringBootGenerator(2.1版)

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](https://github.com/wang926454/SpringBootGenerator/pulls)
[![GitHub stars](https://img.shields.io/github/stars/wang926454/SpringBootGenerator.svg?style=social&label=Stars)](https://github.com/wang926454/SpringBootGenerator)
[![GitHub forks](https://img.shields.io/github/forks/wang926454/SpringBootGenerator.svg?style=social&label=Fork)](https://github.com/wang926454/SpringBootGenerator)

> SpringBoot2.1版(Test类生成代码)

#### 项目相关

版本 | 操作 | 链接
-----|-----|----
SpringBoot1.5 | Test类生成代码  | [https://github.com/wang926454/SpringBootGenerator/tree/springboot1.5](https://github.com/wang926454/SpringBootGenerator/tree/springboot1.5)
SpringBoot2.1 | Test类生成代码  | 当前
SpringBoot1.5 | 可视化界面操作生成代码  | [https://github.com/wang926454/SpringBootGenerator/tree/viewgenerator](https://github.com/wang926454/SpringBootGenerator/tree/viewgenerator)

#### 项目介绍

SpringBootGenerator是一个基于SpringBoot & MyBatis的种子项目，用于快速构建中小型项目，稳定、简单、快速，使我们摆脱那些重复劳动，专注于业务代码的编写，能在短短几十秒钟内实现一套简单的基础代码(自动生成Model、Mapper、MapperXML、Service、ServiceImpl、Controller、JS、Vue等自定义模板代码)，并运行提供服务

1. 统一响应结果封装
2. 统一异常处理
3. 集成通用Mapper插件、PageHelper分页插件，实现单表业务零SQL
4. 优化Controller方法
5. 通用BaseService

#### 软件架构

SpringBoot + Mybatis + PageHelper + 通用Mapper

##### 组织结构

``` lua
src
├─main -- main运行主体代码
│  ├─java
│  └─resources
└─test -- test单元测试
    ├─java
    │  └─com
    │     ├─example
    │     │  ├─base -- 通用单元测试基础类
    │     │  ├─generator -- 代码生成器第一版，第二版执行Main函数
    │     │  └─test -- test代码
    │     └─uframe -- 代码生成器第二版核心代码
    │        └─generator -- 代码生成器第二版核心代码
    └─resources -- test resources
        ├─config -- 代码生成器第二版配置代码
        ├─sql -- SQL文件示例
        └─template
            ├─one -- 代码生成器第一版模板
            └─two -- 代码生成器第二版模板
                ├─LayUI -- 代码生成器第二版LayUI模板示例
                └─RESTful -- 代码生成器第二版RESTful模板示例
```

#### 安装教程

##### 第一版

1. 解压后执行src\test\resources\sql\MySQL.sql脚本创建数据库和表
2. src\test\java\com\example\generator\CodeGeneratorOne.java运行Main方法生成代码
3. 可以自行修改src\test\resources\template\one下的模板
4. Controller模板提供POST和RESTful两套
5. 修改src\test\java\com\example\generator\CodeGenerator.java下的CONTROLLER_TYPE可以生成REST或者POST的Controller模板

##### 第二版

1. 解压后执行src\test\resources\sql\MySQL.sql脚本创建数据库和表
2. src\test\java\com\example\generator\CodeGeneratorTwo.java运行Main方法生成代码
3. 可以自行修改src\test\resources\template\two下的模板
4. 模板提供两套示例LayUI和RESTful，可以自行添加模板
5. 修改src\test\java\com\example\generator\CodeGeneratorTwo.java下的模板路径即可

#### 使用说明

1. 数据库要配置好，且必须有帐号权限

#### SpringBoot1.5升级2.1

* SpringBoot官方文档:[https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/htmlsingle/#common-application-properties](https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/htmlsingle/#common-application-properties)
* 感谢清风丿自来的java.sql.SQLException: The server time zone value 'ÖÐ¹ú±ê×¼Ê±¼ä' is unrecognized:[https://blog.csdn.net/qq_39098813/article/details/81138648](https://blog.csdn.net/qq_39098813/article/details/81138648)
* 感谢不信成不了大牛的Loading class 'com.mysql.jdbc.Driver'. This is deprecated. The new driver class is 'com.mysql.cj.jdb:[https://blog.csdn.net/anaini1314/article/details/71157791](https://blog.csdn.net/anaini1314/article/details/71157791)

#### 参与贡献

1. Fork 本项目
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request