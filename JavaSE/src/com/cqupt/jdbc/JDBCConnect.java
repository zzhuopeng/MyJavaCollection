package com.cqupt.jdbc;

import com.cqupt.utils.JDBCCloseUtils;
import com.mysql.jdbc.Driver;

import java.sql.*;

public class JDBCConnect {

    public static void main(String[] args) {
        //用于在finally中关闭
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //1.注册JDBC驱动
            connection = JDBCCloseUtils.getConnection();
            //3.创建statement,用于和数据库交流
            statement = connection.createStatement();
            //4.执行查询
            String sql = "SELECT * FROM Vendors";
            resultSet = statement.executeQuery(sql);
            //5.打印结果
            while (resultSet.next()) {
                System.out.println("供应商的名称为" + resultSet.getString("vend_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            JDBCCloseUtils.releaseJDBC(resultSet, statement, connection);
        }
    }
}
