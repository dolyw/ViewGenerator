package com.uframe.generator.provider.db;

import javax.sql.*;
import com.uframe.generator.*;
import java.sql.*;
import java.io.*;
import java.util.logging.Logger;

public class DataSourceProvider
{
    private static Connection connection;
    private static DataSource dataSource;
    
    public static synchronized Connection getConnection() {
        try {
            if (DataSourceProvider.connection == null || DataSourceProvider.connection.isClosed()) {
                DataSourceProvider.connection = getDataSource().getConnection();
            }
            return DataSourceProvider.connection;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void setDataSource(final DataSource dataSource) {
        DataSourceProvider.dataSource = dataSource;
    }
    
    public static synchronized DataSource getDataSource() {
        if (DataSourceProvider.dataSource == null) {
            DataSourceProvider.dataSource = new DriverManagerDataSource(GeneratorProperties.getRequiredProperty("jdbc.url"), GeneratorProperties.getRequiredProperty("jdbc.username"), GeneratorProperties.getProperty("jdbc.password"), GeneratorProperties.getRequiredProperty("jdbc.driver"));
            System.out.println(String.valueOf(GeneratorProperties.getRequiredProperty("jdbc.username")) + "," + GeneratorProperties.getProperty("jdbc.password"));
        }
        return DataSourceProvider.dataSource;
    }
    
    public static class DriverManagerDataSource implements DataSource
    {
        private String url;
        private String username;
        private String password;
        private String driverClass;
        
        private static void loadJdbcDriver(final String driver) {
            try {
                Class.forName(driver);
            }
            catch (ClassNotFoundException e) {
                throw new RuntimeException("not found jdbc driver class:[" + driver + "]", e);
            }
        }
        
        public DriverManagerDataSource(final String url, final String username, final String password, final String driverClass) {
            this.url = url;
            this.username = username;
            this.password = password;
            loadJdbcDriver(this.driverClass = driverClass);
        }
        
        @Override
        public Connection getConnection() throws SQLException {
            return DriverManager.getConnection(this.url, this.username, this.password);
        }
        
        @Override
        public Connection getConnection(final String username, final String password) throws SQLException {
            return DriverManager.getConnection(this.url, username, password);
        }
        
        @Override
        public PrintWriter getLogWriter() throws SQLException {
            throw new UnsupportedOperationException("getLogWriter");
        }
        
        @Override
        public int getLoginTimeout() throws SQLException {
            throw new UnsupportedOperationException("getLoginTimeout");
        }
        
        @Override
        public void setLogWriter(final PrintWriter out) throws SQLException {
            throw new UnsupportedOperationException("setLogWriter");
        }
        
        @Override
        public void setLoginTimeout(final int seconds) throws SQLException {
            throw new UnsupportedOperationException("setLoginTimeout");
        }
        
        @Override
        public <T> T unwrap(final Class<T> iface) throws SQLException {
            if (iface == null) {
                throw new IllegalArgumentException("Interface argument must not be null");
            }
            if (!DataSource.class.equals(iface)) {
                throw new SQLException("DataSource of type [" + this.getClass().getName() + "] can only be unwrapped as [javax.sql.DataSource], not as [" + iface.getName());
            }
            return (T)this;
        }
        
        @Override
        public boolean isWrapperFor(final Class<?> iface) throws SQLException {
            return DataSource.class.equals(iface);
        }

        @Override
        public Logger getParentLogger() throws SQLFeatureNotSupportedException {
            return null;
        }
    }
}
