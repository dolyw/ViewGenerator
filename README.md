## ViewGenerator

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](https://github.com/dolyw/ViewGenerator/pulls)
[![GitHub stars](https://img.shields.io/github/stars/dolyw/ViewGenerator.svg?style=social&label=Stars)](https://github.com/dolyw/ViewGenerator)
[![GitHub forks](https://img.shields.io/github/forks/dolyw/ViewGenerator.svg?style=social&label=Fork)](https://github.com/dolyw/ViewGenerator)

> 可视化自定义模板代码生成系统

#### 项目相关

版本 | 描述
----|------
SpringBoot1.5 | Test类生成代码
SpringBoot2.1 | 可视化界面及Test类两种
SpringBoot2.5 | 可视化界面及Test类，在线切换数据库

#### 项目介绍

ViewGenerator是一个基于SpringBoot & FreeMarker的自定义模板代码生成系统，用于快速构建中小型项目，稳定、简单、快速，使我们摆脱那些重复劳动，专注于业务代码的编写，能在短短几十秒钟内实现一套简单的基础代码(自动生成Model、Mapper、MapperXML、Service、ServiceImpl、Controller、JS、Vue等自定义模板代码)

1. 可视化界面，上手操作简单
2. 高度灵活的代码模板配置(提供两套模板参考)，可以自行添加N套代码模板
3. 支持多数据库，在线切换数据库，支持在线生成代码且可提供ZIP文件下载

#### 软件架构

SpringBoot + Mybatis + PageHelper + 通用Mapper + Thymeleaf(Amaze UI(布局) + Element UI(数据操作Vue.js))

#### 安装教程

1. 配置resource下config/generator.properties数据库信息启动Application即可，也可以本地直接执行Test类在src\test\java\com\example\generator\GeneratorCode
2. 模板提供两套示例LayUI和RESTful，自行添加模板路径\template\
3. 可视化界面操作访问[http://localhost:8080](http://localhost:8080)，可以在线设置生成代码的配置
4. 服务器部署，下载代码到本地打包成jar包上传到服务器启动即可
5. 服务器部署后需要自行复制template文件夹到与jar包同级目录下

#### 使用说明

```
数据库要配置好，且必须有帐号权限(resource下config/generator.properties数据库信息)
```

##### 系统预览
```
启动首页界面
```
![image text](https://docs.dolyw.com/Project/ViewGenerator/image/20190406001.png)
```
生成代码界面如下
```
![image text](https://docs.dolyw.com/Project/ViewGenerator/image/20190406002.png)
```
查看表详细信息界面如下
```
![image text](https://docs.dolyw.com/Project/ViewGenerator/image/20190406003.png)
```
输入表名生成代码界面如下
```
![image text](https://docs.dolyw.com/Project/ViewGenerator/image/20190406004.png)
```
配置更新界面如下
```
![image text](https://docs.dolyw.com/Project/ViewGenerator/image/20190406005.png)

#### 搭建参考

1. 感谢zeng1994的Java实现将文件或者文件夹压缩成zip:[https://www.cnblogs.com/zeng1994/p/7862288.html](https://www.cnblogs.com/zeng1994/p/7862288.html)

#### 参与贡献

1. Fork 本项目
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request