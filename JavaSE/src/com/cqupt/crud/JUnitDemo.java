package com.cqupt.crud;

import com.cqupt.utils.JDBCCloseUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 使用Junit执行单元测试
 * 注：需要通过添加JAR的方式从【IDEA安装目录/lib】中添加junit.jar和hamcrest.jar
 */
public class JUnitDemo {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    /**
     * 查询
     */
    @Test
    public void testQuery() {
        try {
            //获取数据库连接对象
            connection = JDBCCloseUtils.getConnection();
            //根据连接对象获取Statement
            statement = connection.createStatement();
            String sql = "SELECT * from Vendors";
            //执行sql语句
            resultSet = statement.executeQuery(sql);
            //遍历结果
            while (resultSet.next()) {
                System.out.println("Vendors name is:" + resultSet.getString("vend_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCCloseUtils.releaseJDBC(resultSet, statement, connection);
        }
    }

    /**
     * 插入数据
     */
    @Test
    public void testInsert() {
        try {
            //获取数据库连接对象
             connection = JDBCCloseUtils.getConnection();
            //根据连接对象获取Statement
             statement = connection.createStatement();
            String sql = "INSERT into Vendors values (null,'tomato','CC','CCC','CCCC','CCCC','ccccCCCC')";
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

    /**
     * 删除数据
     */
    @Test
    public void testDelete() {
        try {
            //获取数据库连接对象
             connection = JDBCCloseUtils.getConnection();
            //根据连接对象获取Statement
             statement = connection.createStatement();
            String sql = "DELETE FROM Vendors where vend_id=5";
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

    /**
     * 更新数据
     */
    @Test
    public void testUpdate() {
        try {
            //获取数据库连接对象
            connection = JDBCCloseUtils.getConnection();
            //根据连接对象获取Statement
            statement = connection.createStatement();
            String sql = "UPDATE Vendors set vend_name='tomatotomato' where vend_id=6";
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
