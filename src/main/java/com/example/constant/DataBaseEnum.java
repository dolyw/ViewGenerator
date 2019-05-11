package com.example.constant;

/**
 * 数据库类型
 * @author dolyw.com
 * @date 2019/4/6 19:53
 */
public enum DataBaseEnum {
    /**
     * MYSQL
     */
    MYSQL("mysql"),
    /**
     * ORACLE
     */
    ORACLE("oracle"),
    /**
     * POSTGRESQL
     */
    POSTGRESQL("postgresql"),
    /**
     * SQLSERVER
     */
    SQLSERVER("sqlserver");

    private String value;

    DataBaseEnum(String type) {
        value = type;
    }

    public String getValue() {
        return value;
    }

}
