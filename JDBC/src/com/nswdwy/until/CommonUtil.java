package com.nswdwy.until;

import java.io.IOException;
import java.sql.*;

/**
 * @author yycstart
 * @create 2020-08-30 19:17
 */
public class CommonUtil {
    /**
     * @param connection
     * @param sql
     */
    public static void View(Connection connection, String sql) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            //metaData保存虚表信息(元数据)
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            System.out.println("---------------------------------------");
            for (int i = 0; i < columnCount; i++) {
                String columnLabel = metaData.getColumnLabel(i + 1);
                System.out.println(columnLabel + "\t");
            }
            System.out.println();
            System.out.println("---------------------------------------");
            while (resultSet.next()) {
                for (int i = 0; i < columnCount; i++) {
                    String columnLable = metaData.getColumnLabel(i + 1);
                    Object value = resultSet.getObject(columnLable);
                    System.out.println(value + "\t");
                }
                System.out.println();
            }
            System.out.println("---------------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, preparedStatement, resultSet);
        }
    }

    /**
     * 通用的更新操作
     * @param sql 要执行的SQL, DDL, DML中除了select
     * @param args 用于替换SQL中的?的实参列表, 可变参数, 如果sql中没有?, 则可以忽略它
     * @return 影响的行数
     */
    public static int update(String sql, Object... args) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection(); // 获取连接对象
            preparedStatement = connection.prepareStatement(sql); // 预编译
            // 批量统一替换SQL中的?
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            int rows = preparedStatement.executeUpdate(); // 执行这个SQL
            return rows;
        } finally {
            JdbcUtil.close(connection, preparedStatement);
        }
    }
    /**
     * 通用的更新操作
     *
     * @param connection 调用者要传入的连接对象
     * @param sql        要执行的sql语句
     * @param args       用于替换SQL中?的实参列表,可变参数，如果sql中没有?,则可以忽略
     * @return 返回影响的行数
     */
    public static int update(Connection connection, String sql, Object... args) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            //预编译
            preparedStatement = connection.prepareStatement(sql);
            //批量统一替换SQL中的?
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            int rows = preparedStatement.executeUpdate();
            return rows;
        } finally {
            JdbcUtil.close(null, preparedStatement);
        }
    }


}
