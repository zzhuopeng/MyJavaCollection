package com.B1_CodingInterviews.N02_Singleton;

/**
 * 单例模式：内部静态类（线程安全，使用到内部类的时候才会加载，类加载是线程安全的）
 */
public class N5_Singleton {

    private N5_Singleton() {
    }

    public static class SingletonHolder {
        public static N5_Singleton instance = new N5_Singleton();
    }

    public N5_Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
