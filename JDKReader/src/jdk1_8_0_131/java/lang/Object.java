/*
 * Copyright (c) 1994, 2012, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.lang;

/**
 * Object是所有类的父类，是类关系图的根节点。
 */
public class Object {

    private static native void registerNatives();

    static {
        registerNatives();
    }

    /**
     * 返回该Object的运行时Class对象
     */
    public final native Class<?> getClass();

    /**
     * 返回该Object的hashCode
     */
    public native int hashCode();

    /**
     * 判断该Object是否equals to obj
     */
    public boolean equals(Object obj) {
        return (this == obj);
    }

    /**
     * 产生并返回该Object的拷贝对象
     */
    protected native Object clone() throws CloneNotSupportedException;

    /**
     * 返回代表该Object的String文字
     */
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    /**
     * 唤醒正在此Object监视器上等待的单个线程
     */
    public final native void notify();

    /**
     * 唤醒正在此Object监视器上等待的所有线程
     */
    public final native void notifyAll();

    /**
     * 导致当前线程等待，直到另一个线程为该Object调用notify()方法或者notifyAll()方法，或者timeout时间过去
     */
    public final native void wait(long timeout) throws InterruptedException;

    /**
     * 导致当前线程等待，直到另一个线程为该Object调用notify()方法或者notifyAll()方法，
     * 或者其他线程中断当前线程，或者timeout时间过去
     */
    public final void wait(long timeout, int nanos) throws InterruptedException {
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout value is negative");
        }

        if (nanos < 0 || nanos > 999999) {
            throw new IllegalArgumentException(
                    "nanosecond timeout value out of range");
        }

        if (nanos > 0) {
            timeout++;
        }

        wait(timeout);
    }

    /**
     * 导致当前线程等待，直到另一个线程为该Object调用notify()方法或者notifyAll()方法
     */
    public final void wait() throws InterruptedException {
        wait(0);
    }

    /**
     * 当垃圾回收器发现没有对该Object的引用，调用垃圾回收器
     */
    protected void finalize() throws Throwable {
    }
}
