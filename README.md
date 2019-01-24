# SpringBootGenerator(SpringBoot2.1版)

> SpringBoot2.1版(SpringBoot1.5版切换分支(springboot1.5))
> 参考:[https://github.com/lihengming/spring-boot-api-project-seed](https://github.com/lihengming/spring-boot-api-project-seed)

### 项目相关

* JavaDoc:[https://apidoc.gitee.com/wang926454/SpringBootGenerator](https://apidoc.gitee.com/wang926454/SpringBootGenerator)

#### 项目介绍

SpringBootGenerator是一个基于SpringBoot & MyBatis的种子项目，用于快速构建中小型API、RESTful API项目，稳定、简单、快速，使我们摆脱那些重复劳动，专注于业务代码的编写，能在短短几十秒钟内实现一套简单的API(自动生成Model、Mapper、MapperXML、Service、ServiceImpl、Controller基础代码)，并运行提供服务

1. 统一响应结果封装
2. 统一异常处理
3. 集成通用Mapper插件、PageHelper分页插件，实现单表业务零SQL
4. Controller模板提供POST和RESTful两套
5. 通用BaseService

在原项目上修改

1. 改为SpringBoot的通用Mapper插件、PageHelper分页插件，配置更少
2. 提供更完整的通用BaseService
3. 优化Controller方法

#### 软件架构

SpringBoot + Mybatis + PageHelper + 通用Mapper

#### 安装教程

1. 解压后执行src\test\resources\sql\MySQL.sql脚本创建数据库和表
2. src\test\java\com\example\generator\CodeGenerator.java运行Main方法生成代码

#### 使用说明

1. 可以自行修改src\test\resources\template下的模板
2. 修改src\test\java\com\example\generator\CodeGenerator.java下的CONTROLLER_TYPE可以生成REST或者POST的Controller模板

#### SpringBoot1.5升级2.1

* SpringBoot官方文档:[https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/htmlsingle/#common-application-properties](https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/htmlsingle/#common-application-properties)
* 感谢清风丿自来的java.sql.SQLException: The server time zone value 'ÖÐ¹ú±ê×¼Ê±¼ä' is unrecognized:[https://blog.csdn.net/qq_39098813/article/details/81138648](https://blog.csdn.net/qq_39098813/article/details/81138648)
* 感谢不信成不了大牛的Loading class 'com.mysql.jdbc.Driver'. This is deprecated. The new driver class is 'com.mysql.cj.jdb:[https://blog.csdn.net/anaini1314/article/details/71157791](https://blog.csdn.net/anaini1314/article/details/71157791)

#### 参与贡献

1. Fork 本项目
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request