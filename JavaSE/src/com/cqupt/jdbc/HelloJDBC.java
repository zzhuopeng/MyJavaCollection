package com.cqupt.jdbc;


import java.sql.*;

/**
 * 1.用于测试JDBC连接MySQL数据库
 */
public class HelloJDBC {

    //mysql驱动包名
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    //数据库连接地址
    private static final String URL = "jdbc:mysql://207.246.109.8:3306/1.LearnSQLIn10m?useUnicode=true&characterEncoding=utf-8";
    //用户名
    private static final String USER_NAME = "root";
    //密码
    private static final String PASSWORD = "admin";

    public static void main(String[] args) {

        System.out.println("Hello JBDC 哈哈");

        Connection connection = null;
        try {
            //加载mysql的驱动类
            Class.forName(DRIVER_NAME);
            //获取数据库连接
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            //mysql查询语句
            String sql = "SELECT * FROM Vendors";
            PreparedStatement prst = connection.prepareStatement(sql);
            //结果集
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                System.out.println("供应商名" + rs.getString("vend_name"));
            }
            rs.close();
            prst.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
