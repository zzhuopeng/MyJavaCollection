package com.B1_CodingInterviews.N02_Singleton;

/**
 * Double Check, 双重检测，懒汉模式(线程安全)
 */
class N4_Singleton {
    public static N4_Singleton instance = null;

    private N4_Singleton() {
    }

    public static N4_Singleton getInstance() {
        if (null == instance) {
            synchronized (N4_Singleton.class) { //类对象作为锁
                if (null == instance)           //防止A刚释放锁，已经有B判断为null，然后再次初始化
                    instance = new N4_Singleton();
            }
        }
        return instance;
    }

}
