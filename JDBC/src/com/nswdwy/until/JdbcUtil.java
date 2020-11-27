package com.nswdwy.until;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author yycstart
 * @create 2020-08-30 15:59
 */
public class JdbcUtil {
        //连接池对象只需要创建一个
        private static DataSource dataSource;
        static{
            //在类加载时候读取配置文件并创建连接池：只创造一个连接对象
            Properties properties = new Properties();
            InputStream is = JdbcUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            try {
                properties.load(is);
                is.close();
                dataSource = DruidDataSourceFactory.createDataSource(properties);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static Connection getConnection() throws SQLException {
            Connection connection = dataSource.getConnection();
            return connection;
        }

        public static void close(Connection connection, Statement statement, ResultSet result){
            if(result != null){
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void close(Connection connection,Statement statement){
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void close(Connection connection){
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


}
