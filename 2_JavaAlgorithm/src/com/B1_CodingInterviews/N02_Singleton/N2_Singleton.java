package com.B1_CodingInterviews.N02_Singleton;

/**
 * 懒汉模式(非线程安全)
 */
class N2_Singleton {
    public static N2_Singleton instance = null;

    private N2_Singleton() {
    }

    public static N2_Singleton getInstance() {
        if (null == instance)
            instance = new N2_Singleton();
        return instance;
    }
}
