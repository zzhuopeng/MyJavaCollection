package com.B1_CodingInterviews.N02_Singleton;

/**
 * 饿汉模式（线程安全，但没使用都会创建，类加载时期创建，浪费内存）
 */
class N1_Singleton {
    public static N1_Singleton instance = new N1_Singleton();

    private N1_Singleton() {
    }

    public static N1_Singleton getInstance() {
        return instance;
    }
}
