package com.cqupt.dao.impl;

import com.cqupt.dao.dao.UserDao;
import com.cqupt.utils.JDBCCloseUtils;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    /**
     * 登录
     *
     * @param username 账号
     * @param password 密码
     */
    @Override
    public void loginWithStatement(String username, String password) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;


        try {
            //获取连接
            connection = JDBCCloseUtils.getConnection();
            //获取Statement
            statement = connection.createStatement();

            //执行SQL语句
//            String sql = "SELECT * from User where username='AA'";
            String sql = "SELECT * from User where username='" + username + "' and password='" + password + "'";
            resultSet = statement.executeQuery(sql);

            //遍历查询结果
//            while (resultSet.next()) {
//                if (resultSet.getString("password").equals(password)) {
//                    System.out.println("登录成功");
//                } else {
//                    System.out.println("登录失败");
//                }
//            }
            if (resultSet.next()) {
                System.out.println("登录成功");
            } else {
                System.out.println("登录失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCCloseUtils.releaseJDBC(resultSet, statement, connection);
        }
    }

    /**
     * 登录
     *
     * @param username 账号
     * @param password 密码
     */
    @Override
    public void loginWithPrepareStatement(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            //获取连接
            connection = new JDBCCloseUtils().getConnection();
            //获取PrepareStatement
            String sql = "select * from User where username = ? and password = ?";
            //预先对sql预计执行语法进行校验，?对应的内容，不管后面传递什么进来，都看作是字符串。
            preparedStatement = connection.prepareStatement(sql);
            //?对应的Index从1开始
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            //执行查询sql
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("登录成功");
            } else {
                System.out.println("登录失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCCloseUtils.releaseJDBC(resultSet, preparedStatement, connection);
        }

    }

    /**
     * 插入数据
     *
     * @param username 账号
     * @param password 密码
     */
    @Override
    public void insert(String username, String password) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            //获取连接
            connection = JDBCCloseUtils.getConnection();
            //获取PrepareStatement
            String sql = "insert into User values (null, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            //添加参数。 ?号为占位符
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            //执行sql语句
            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("插入成功");
            } else {
                System.out.println("插入失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCCloseUtils.releaseJDBC(preparedStatement, connection);
        }
    }

    /**
     * 删除数据
     *
     * @param id 数据id
     */
    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            //获取连接
            connection = JDBCCloseUtils.getConnection();
            //获取PrepareStatement
            String sql = "delete from User where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            //添加参数。 ?号为占位符
            preparedStatement.setInt(1, id);

            //执行sql语句
            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCCloseUtils.releaseJDBC(preparedStatement, connection);
        }
    }

    /**
     * 插入数据
     *
     * @param username    账号
     * @param password    密码
     * @param newPassword
     */
    @Override
    public void update(String username, String password, String newPassword) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //获取Connection
            connection = JDBCCloseUtils.getConnection();
            //获取PrepareStatement
            String sql = "UPDATE User set password=? where username=? and password=?";
            preparedStatement = connection.prepareStatement(sql);
            //设置参数
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);

            //执行sql语句
            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("更新成功");
            } else {
                System.out.println("更新失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
