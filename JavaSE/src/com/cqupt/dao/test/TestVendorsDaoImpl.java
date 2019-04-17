package com.cqupt.dao.test;

import com.cqupt.dao.dao.VendorsDao;
import com.cqupt.dao.impl.VendorsDaoImpl;
import org.junit.Test;

public class TestVendorsDaoImpl {

    @Test
    public void testQueryAll() {
        //测试
        VendorsDao vendorsDao = new VendorsDaoImpl();
        vendorsDao.queryAll();
    }

    @Test
    public void testInsert() {
        VendorsDao vendorsDao = new VendorsDaoImpl();
        vendorsDao.insert();
    }

    @Test
    public void testDelete() {
        VendorsDao vendorsDao = new VendorsDaoImpl();
        vendorsDao.delete();
    }

    @Test
    public void testUpdate(){
        VendorsDao vendorsDao = new VendorsDaoImpl();
        vendorsDao.update();
    }
}
