package com.nswdwy.test;

import com.nswdwy.until.JdbcUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author yycstart
 * @create 2020-08-30 15:06
 *
 */
public class Test01 {
    @Test
    public void test4(){
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(connection);
        }

    }

    @Test
    public void test3() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","123456");
        System.out.println(connection);
    }

    @Test
    public void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Driver driver = (Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();
        DriverManager.deregisterDriver(driver);  //注册驱动
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc", "root", "123456");
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void test1() throws SQLException {

         Driver driver =  new com.mysql.jdbc.Driver();
         String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }
}
