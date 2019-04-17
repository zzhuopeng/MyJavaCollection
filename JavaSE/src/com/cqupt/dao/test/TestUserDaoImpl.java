package com.cqupt.dao.test;

import com.cqupt.dao.dao.UserDao;
import com.cqupt.dao.impl.UserDaoImpl;
import org.junit.Test;

public class TestUserDaoImpl {

    @Test
    public void testLogin() {
        UserDao userDao = new UserDaoImpl();
//        userDao.login("AA", "12");
        //注入式攻击
//        userDao.loginWithStatement("AA", "12' or '1=1");
        //防止注入式攻击
        userDao.loginWithPrepareStatement("AA", "12' or '1=1");
    }

    @Test
    public void testInsert() {
        UserDao userDao = new UserDaoImpl();
        userDao.insert("DD", "DD123");
    }

    @Test
    public void testDelete() {
        UserDao userDao = new UserDaoImpl();
        userDao.delete(1);
    }

    @Test
    public void testUpdate() {
        UserDao userDao = new UserDaoImpl();
        userDao.update("DD", "DD123", "DD456");
    }
}
