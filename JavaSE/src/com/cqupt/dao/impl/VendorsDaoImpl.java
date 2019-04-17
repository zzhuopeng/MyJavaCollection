package com.cqupt.dao.impl;

import com.cqupt.dao.dao.VendorsDao;
import com.cqupt.utils.JDBCCloseUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VendorsDaoImpl implements VendorsDao {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    @Override
    public void insert() {
        try {
            //获取数据库连接对象
            connection = JDBCCloseUtils.getConnection();
            //根据连接对象获取Statement
            statement = connection.createStatement();
            String sql = "INSERT into Vendors values (null,'abcd','abcd','abcd','abcd','abcd','abcd')";
            //执行sql语句。影响的行数，>0表示成功；否则失败。
            int result = statement.executeUpdate(sql);
            //遍历结果
            if (result > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCCloseUtils.releaseJDBC(statement, connection);
        }

    }

    @Override
    public void delete() {
        try {
            //获取数据库连接对象
            connection = JDBCCloseUtils.getConnection();
            //根据连接对象获取Statement
            statement = connection.createStatement();
            String sql = "DELETE FROM Vendors where vend_name='abcd'";
            //执行sql语句。影响的行数，>0表示成功；否则失败。
            int result = statement.executeUpdate(sql);
            //遍历结果
            if (result > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCCloseUtils.releaseJDBC(statement, connection);
        }
    }

    @Override
    public void queryAll() {
        try {
            //获取连接对象
            connection = JDBCCloseUtils.getConnection();
            //获取Statement
            statement = connection.createStatement();
            //执行sql语句
            String sql = "select * from Vendors;";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String name = resultSet.getString("vend_name");
                String city = resultSet.getString("vend_city");
                String country = resultSet.getString("vend_country");
                System.out.println("姓名：" + name + "，城市：" + city + "，国家：" + country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCCloseUtils.releaseJDBC(resultSet, statement, connection);
        }
    }

    @Override
    public void update() {
        try {
            //获取数据库连接对象
            connection = JDBCCloseUtils.getConnection();
            //根据连接对象获取Statement
            statement = connection.createStatement();
//            String sql = "UPDATE Vendors set vend_name='tomatotomato' where vend_name='tomato'";
            String sql = "UPDATE Vendors set vend_name='tomato' where vend_name='tomatotomato'";
            //执行sql语句。影响的行数，>0表示成功；否则失败。
            int result = statement.executeUpdate(sql);
            //遍历结果
            if (result > 0) {
                System.out.println("更新成功");
            } else {
                System.out.println("更新失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCCloseUtils.releaseJDBC(statement, connection);
        }
    }
}
