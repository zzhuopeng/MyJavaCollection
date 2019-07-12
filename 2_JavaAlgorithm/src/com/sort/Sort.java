package com.sort;

import org.junit.Test;

public class Sort {

    public static final int LENGTH = 3000000;

    @Test
    public void test() {
        int[] array = new int[LENGTH];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * LENGTH * 2);
        }

        //交换排序：冒泡、快排
        Bubble(array);
        //Quick(array);

        //插入排序：简单插入排序、希尔排序

        //选择排序：简单选择排序、堆排序

        //归并排序

        //非比较排序
    }

    //比较类排序（3种稳定，4种不稳定）

    /**
     * 1.冒泡排序（稳定）
     */
    public void Bubble(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    array[j] = array[j] + array[j + 1];
                    array[j + 1] = array[j] - array[j + 1];
                    array[j] = array[j] - array[j + 1];
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * 2.选择排序
     */
    public void Select(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int max = array[j];
            for (int j = 0; j < array.length - 1 - i; j++) {

            }
        }
    }

    /**
     * 3.插入排序（稳定）
     */
    public void Insert(int[] array) {

    }

    /**
     * 4.希尔排序
     */
    public void Shells(int[] array) {

    }

    /**
     * 5.归并排序（稳定）
     */
    public void Merge(int[] array) {

    }

    /**
     * 6.快速排序
     */
    public void Quick(int[] array) {

    }

    /**
     * 7.堆排序
     */
    public void Heap(int[] array) {

    }

    //非比较类排序（稳定）

    /**
     * 8.计数排序
     */
    public void Counting(int[] array) {

    }

    /**
     * 9.桶排序
     */
    public void Bucket(int[] array) {

    }

    /**
     * 10.基数排序
     */
    public void Radix(int[] array) {

    }
}
