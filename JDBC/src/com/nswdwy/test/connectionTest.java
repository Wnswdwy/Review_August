package com.nswdwy.test;

import com.nswdwy.until.CommonUtil;
import com.nswdwy.until.JdbcUtil;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author yycstart
 * @create 2020-08-30 17:13
 */
public class connectionTest {


    @Test
    public void test02() throws SQLException, IOException, ClassNotFoundException {
        String sql = "create table if not exists teacher(" +
                "id int auto_increment," +
                "name varchar(20)," +
                "age int," +
                "salary double," +
                "gender char(1)," +
                "primary key(id)" +
                ")";
        CommonUtil.update(sql);

        int rows = CommonUtil.update("insert into teacher(name, age, salary, gender) values (?, ?, ?, ?)", "宋宋", 30, 5000, "男");
        System.out.println(rows + " rows");
    }
    @Test
    public void test01(){
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "create table if not exits student (" +
                    "id int,"+
                    "name varchar(20),"+
                    "age int,"+
                    "score int,"+
                    "grade int"+
                    ")";
            CommonUtil.update(connection,sql);
            sql = "insert into student(name,age,score,grade) values (?,?,?,?)";
            int rows = CommonUtil.update(connection, sql, "小明", 20, 80, 5);
            System.out.println(rows + "rows");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(connection);
        }
    }
}
