package com.cqupt.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 释放JDBC资源类
 */
public class JDBCCloseUtils {
    //具体值应该放于jdbc.properties文件中
    private static String driverClass = null;
    private static String url = null;
    private static String name = null;
    private static String password = null;

    static {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            //注意不能用这种方式加载配置文件
//            inputStream = new FileInputStream("jdbc.properties");
            //用类加载器读取src文件夹下的资源文件。在加载类的时候，同时在out文件夹中加载jdbc.properties文件
            inputStream = JDBCCloseUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //导入输入流
            properties.load(inputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //读取属性
        driverClass = properties.getProperty("driverClass");
        url = properties.getProperty("url");
        name = properties.getProperty("name");
        password = properties.getProperty("password");
    }

    /**
     * 获取Connection连接
     *
     * @return Connection
     */
    public static Connection getConnection() {

        Connection connection = null;

        try {
            // 在Driver类中，有一段相同代码的静态代码块，只要Driver类被加载，就执行
//             DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Class.forName(driverClass);
            //2.建立连接
            connection = DriverManager.getConnection(url, name, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * 释放JDBC相关资源
     *
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void releaseJDBC(ResultSet resultSet, Statement statement, Connection connection) {
        closeResultSet(resultSet);
        closeStatement(statement);
        closeConnection(connection);
    }

    /**
     * 释放JDBC相关资源
     *
     * @param statement
     * @param connection
     */
    public static void releaseJDBC(Statement statement, Connection connection) {
        closeStatement(statement);
        closeConnection(connection);
    }


    private static void closeResultSet(ResultSet resultSet) {
        try {
            if (null != resultSet) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            resultSet = null;
        }
    }

    private static void closeStatement(Statement statement) {
        try {
            if (null != statement) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            statement = null;
        }

    }

    private static void closeConnection(Connection connection) {
        try {
            if (null != connection) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection = null;
        }
    }
}
