package com.cqupt.crud;

import com.cqupt.utils.JDBCCloseUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 一般要进行测试的话，都需要有类的main函数，从这里引出单元测试概念Junit
 */
public class MainTest {

    public static void main(String[] args) {

        try {
            //获取数据库连接对象
            Connection connection = JDBCCloseUtils.getConnection();
            //根据连接对象获取Statement
            Statement statement = connection.createStatement();
            String sql = "SELECT * from Vendors where vend_id=5";
            //执行sql语句
            ResultSet resultSet = statement.executeQuery(sql);
            //遍历结果
            while (resultSet.next()) {
                System.out.println("Vendors name is:" + resultSet.getString("vend_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
