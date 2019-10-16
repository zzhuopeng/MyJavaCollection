package com.B1_CodingInterviews.N02_Singleton;

/**
 * 懒汉模式(线程安全，但高并发场景下，效率低)
 */
class N3_Singleton {
    public static N3_Singleton instance = null;

    private N3_Singleton() {
    }

    public static synchronized N3_Singleton getInstance() {
        if (null == instance)
            instance = new N3_Singleton();
        return instance;
    }
}
