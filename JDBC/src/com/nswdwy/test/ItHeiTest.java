package com.nswdwy.test;

import com.nswdwy.java.Customer;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @author yycstart
 * @create 2020-08-31 20:29
 */
public class ItHeiTest {
    @Test
    public void test(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //1.建立连接
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Class.forName("com.mysql.jdbc.Driver");
            //2.建立连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "123456");
           //3.创建数据库连接对象
            statement = connection.createStatement();
            //4.执行sql得到结果集
            resultSet  = statement.executeQuery("select * from customer");
            /**
             * --------+-----------------+------+-----+---------+----------------+
             * | Field  | Type            | Null | Key | Default | Extra          |
             * +--------+-----------------+------+-----+---------+----------------+
             * | id     | int(11)         | NO   | PRI | NULL    | auto_increment |
             * | name   | varchar(20)     | YES  |     | NULL    |                |
             * | age    | int(11)         | YES  |     | NULL    |                |
             * | gender | enum('男','女') | YES  |     | 男      |                |
             * | email  | varchar(50)     | YES  |     | NULL    |                |
             * +--------+-----------------+------+-----+---------+----------------+
             */
            while(resultSet.next()){
                Object id = resultSet.getObject("id");
                Object name = resultSet.getObject("name");
                Object gender = resultSet.getObject("gender");
                Object age = resultSet.getObject("age");
                Object email = resultSet.getObject("email");
                System.out.println(id + "--" + name + "--" + gender + "---" + age + "---" + email);

            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(resultSet != null){
                try {
                    resultSet.close();
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


    }
}
