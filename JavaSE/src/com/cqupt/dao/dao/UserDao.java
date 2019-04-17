package com.cqupt.dao.dao;

public interface UserDao {

    /**
     * 登录
     *
     * @param username 账号
     * @param password 密码
     */
    void loginWithStatement(String username, String password);

    /**
     * 登录
     *
     * @param username 账号
     * @param password 密码
     */
    void loginWithPrepareStatement(String username, String password);

    /**
     * 插入数据
     *
     * @param username 账号
     * @param password 密码
     */
    void insert(String username, String password);

    /**
     * 删除数据
     * @param id 数据id
     */
    void delete(int id);

    /**
     * 插入数据
     *
     * @param username 账号
     * @param password 密码
     */
    void update(String username, String password, String newPassword);
}
