package com.example.dao;

import java.util.List;
import java.util.Map;

/**
 * GeneratorDao
 * @author Wang926454
 * @date 2019/4/5 17:51
 */
public interface GeneratorDao {

    /**
     * 查询数据库所有表
     * @param map
     * @throws
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @author Wang926454
     * @date 2019/4/5 17:51
     */
    List<Map<String, Object>> queryList(Map<String, Object> map);

    /**
     * 查询表信息
     * @param tableName
     * @throws
     * @return java.util.Map<java.lang.String,java.lang.String>
     * @author Wang926454
     * @date 2019/4/5 17:52
     */
    Map<String, String> queryTable(String tableName);

    /**
     * 查询列信息
     * @param tableName
     * @throws
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.String>>
     * @author Wang926454
     * @date 2019/4/5 17:52
     */
    List<Map<String, String>> queryColumns(String tableName);
}
