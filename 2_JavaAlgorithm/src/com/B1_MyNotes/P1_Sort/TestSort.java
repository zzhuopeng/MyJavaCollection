package com.B1_MyNotes.P1_Sort;

import org.junit.Test;

public class TestSort {

    public static final int LENGTH = 15;

    @Test
    public void test() {
        int[] array = new int[LENGTH];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * LENGTH * 2);
        }
        System.out.print("排序前：");
        printArray(array);

        //交换排序：冒泡、快排
//        N04_BubbleSort.sort(array);
//        N01_QuickSort.sort(array);

        //插入排序：简单插入排序、希尔排序
//        N05_InsertSort.sort(array);

        //选择排序：简单选择排序、堆排序
        N03_HeapSort.sort(array);
//        N06_SelectSort.sort(array);

        //归并排序
//        N02_MergeSort.sort(array);

        //非比较排序：计数排序、桶排序、基数排序


        System.out.print("排序后：");
        printArray(array);
    }

    /**
     * 4.希尔排序
     */
    public int[] Shells(int[] array) {

        return array;
    }

    //非比较类排序（稳定）

    /**
     * 8.计数排序
     */
    public int[] Counting(int[] array) {

        return array;
    }

    /**
     * 9.桶排序
     */
    public int[] Bucket(int[] array) {

        return array;
    }

    /**
     * 10.基数排序
     */
    public int[] Radix(int[] array) {

        return array;
    }

    /**
     * 打印数组
     */
    private void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}
