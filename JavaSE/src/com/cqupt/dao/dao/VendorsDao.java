package com.cqupt.dao.dao;

/**
 * Vendors供应商的DAO接口。定义操作数据库方法：增删查改
 */
public interface VendorsDao {

    /**
     * 增加
     */
    void insert();

    /**
     * 删除
     */
    void delete();

    /**
     * 查询
     */
    void queryAll();

    /**
     * 更新
     */
    void update();

}
