drop database dev;

create database dev;

use dev;

create table user (
id int primary key auto_increment COMMENT "ID",
account varchar(20) not null COMMENT "帐号",
password varchar(80) not null COMMENT "密码",
reg_time datetime not null COMMENT "注册时间"
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "用户表";

CREATE TABLE role (
id int primary key auto_increment COMMENT "ID",
name varchar(128) not null COMMENT "角色名称"
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "角色表";


CREATE TABLE permission (
id int primary key auto_increment COMMENT "ID",
name varchar(128) COMMENT '资源名称',
per_code varchar(128) not null COMMENT '权限代码字符串'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "资源表";


insert into user values(null, "admin", "admin", now());
insert into user values(null, "wang", "wang", now());
insert into user values(null, "guest", "guest", now());

insert into role values(null, "admin");
insert into role values(null, "customer");

insert into permission values(null, "查看用户", "user:view");
insert into permission values(null, "操作用户", "user:edit");

