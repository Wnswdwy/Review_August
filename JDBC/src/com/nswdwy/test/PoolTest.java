package com.nswdwy.test;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.nswdwy.until.JdbcUtil;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author yycstart
 * @create 2020-08-31 23:19
 */
public class PoolTest {
    @Test
    public void test02() throws SQLException {
        Connection connection = JdbcUtil.getConnection();
        System.out.println(connection);
    }
    @Test
    public void test01() throws Exception {
        //1.创建properties
        Properties properties = new Properties();
        //2.类加载器加载
        InputStream is = PoolTest.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(is);
        is.close();
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
