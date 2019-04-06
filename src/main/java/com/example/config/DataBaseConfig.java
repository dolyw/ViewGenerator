package com.example.config;

import com.example.constant.DataBaseEnum;
import com.example.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Dao配置注入
 * @author Wang926454
 * @date 2019/4/5 17:56
 */
@Configuration
public class DataBaseConfig {

    @Value("${jdbc_driver}")
    private String driver;

    @Autowired
    private MySqlGeneratorDao mySqlGeneratorDao;

    @Autowired
    private OracleGeneratorDao oracleGeneratorDao;

    @Autowired
    private PostgreSqlGeneratorDao postgreSqlGeneratorDao;

    @Autowired
    private SqlServerGeneratorDao sqlServerGeneratorDao;

    /**
     * 根据驱动判断注入那个类型数据库
     * @param
     * @throws
     * @return com.example.dao.GeneratorDao
     * @author Wang926454
     * @date 2019/4/5 17:59
     */
    @Bean
    @Primary
    public GeneratorDao getGeneratorDao() {
        String str = DataBaseEnum.MYSQL.getValue();
        if(driver.indexOf(DataBaseEnum.MYSQL.getValue()) > 0) {
            return mySqlGeneratorDao;
        } else if (driver.indexOf(DataBaseEnum.ORACLE.getValue()) > 0) {
            return oracleGeneratorDao;
        } else if (driver.indexOf(DataBaseEnum.POSTGRESQL.getValue()) > 0) {
            return postgreSqlGeneratorDao;
        } else if (driver.indexOf(DataBaseEnum.SQLSERVER.getValue()) > 0) {
            return sqlServerGeneratorDao;
        }
        return null;
    }
}
