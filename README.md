## SpringBootGenerator

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](https://github.com/wang926454/SpringBootGenerator/pulls)
[![GitHub stars](https://img.shields.io/github/stars/wang926454/SpringBootGenerator.svg?style=social&label=Stars)](https://github.com/wang926454/SpringBootGenerator)
[![GitHub forks](https://img.shields.io/github/forks/wang926454/SpringBootGenerator.svg?style=social&label=Fork)](https://github.com/wang926454/SpringBootGenerator)

> 可视化自定义模板代码生成系统

#### 项目相关

版本 | 操作 | 链接
----|------|----
SpringBoot1.5(第一版) | Test类生成代码  | [https://github.com/wang926454/SpringBootGenerator/releases](https://github.com/wang926454/SpringBootGenerator/releases)
SpringBoot2.1(第二版) | Test类生成代码  | [https://github.com/wang926454/SpringBootGenerator/releases](https://github.com/wang926454/SpringBootGenerator/releases)
SpringBoot1.5(第三版) | 可视化界面生成代码  | 当前

#### 项目介绍

SpringBootGenerator是一个基于SpringBoot & FreeMarker的自定义模板代码生成系统，用于快速构建中小型项目，稳定、简单、快速，使我们摆脱那些重复劳动，专注于业务代码的编写，能在短短几十秒钟内实现一套简单的基础代码(自动生成Model、Mapper、MapperXML、Service、ServiceImpl、Controller、JS、Vue等自定义模板代码)

1. 可视化界面，上手操作简单
2. 高度灵活的代码模板配置(提供两套模板参考)，可以自行添加N套代码模板
3. 支持多数据库，支持在线生成代码且可提供ZIP文件下载

#### 软件架构

SpringBoot + Mybatis + PageHelper + 通用Mapper + Thymeleaf(Amaze UI(布局) + Element UI(数据操作Vue.js))

#### 安装教程

1. 配置resource下config/generator.properties数据库信息
2. 模板提供两套示例LayUI和RESTful，自行添加模板路径src\test\resources\template\two
3. 运行项目src\main\java\com\example\Application.java即可，访问http://localhost:8080，可以在线设置生成代码的配置

#### 使用说明

1. 数据库要配置好，且必须有帐号权限(resource下config/generator.properties数据库信息)
2. 启动首页界面如下
![image text](https://docs.wang64.cn/Project/SpringBootGenerator/image/20190406001.png)
3. 生成代码界面如下
![image text](https://docs.wang64.cn/Project/SpringBootGenerator/image/20190406002.png)
4. 查看表详细信息界面如下
![image text](https://docs.wang64.cn/Project/SpringBootGenerator/image/20190406003.png)
5. 配置更新界面如下
![image text](https://docs.wang64.cn/Project/SpringBootGenerator/image/20190406004.png)

#### 搭建参考

1. 感谢:[https://blog.csdn.net/bruce128/article/details/79072260](https://blog.csdn.net/bruce128/article/details/79072260)
2. 感谢zeng1994的Java实现将文件或者文件夹压缩成zip:[https://www.cnblogs.com/zeng1994/p/7862288.html](https://www.cnblogs.com/zeng1994/p/7862288.html)

#### 参与贡献

1. Fork 本项目
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request