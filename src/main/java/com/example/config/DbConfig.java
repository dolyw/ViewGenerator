package com.example.config;

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
public class DbConfig {

    /**
     * MYSQL
     */
    private static final String MYSQL = "mysql";

    /**
     * ORACLE
     */
    private static final String ORACLE = "oracle";

    /**
     * POSTGRESQL
     */
    private static final String POSTGRESQL = "postgresql";

    /**
     * SQLSERVER
     */
    private static final String SQLSERVER = "sqlserver";

    @Value("${jdbc.driver}")
    private String driver;

    @Autowired
    private MySQLGeneratorDao mySQLGeneratorDao;

    @Autowired
    private OracleGeneratorDao oracleGeneratorDao;

    @Autowired
    private PostgreSQLGeneratorDao postgreSQLGeneratorDao;

    @Autowired
    private SQLServerGeneratorDao sqlServerGeneratorDao;

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
        if(driver.indexOf(MYSQL) > 0) {
            return mySQLGeneratorDao;
        } else if (driver.indexOf(ORACLE) > 0) {
            return oracleGeneratorDao;
        } else if (driver.indexOf(POSTGRESQL) > 0) {
            return postgreSQLGeneratorDao;
        } else if (driver.indexOf(SQLSERVER) > 0) {
            return sqlServerGeneratorDao;
        }
        return null;
    }
}
