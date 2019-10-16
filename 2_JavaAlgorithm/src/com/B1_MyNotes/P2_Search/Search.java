package com.B1_MyNotes.P2_Search;

import com.B1_MyNotes.P1_Sort.N01_QuickSort;
import org.junit.Test;

/**
 * 二分查找
 */
public class Search {

    private static final int LENGTH = 20;

    @Test
    public void test() {
        int[] array = new int[LENGTH];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * LENGTH * 2);
        }

        printArray(array);
        N01_QuickSort.sort(array);
        printArray(array);
        System.out.println(binarySearch1(array, 4));//结果为-1则表示没找到目标
    }

    /**
     * 二分查找的迭代实现
     */
    public int binarySearch1(int[] array, int key) {
        int lo = 0;
        int hi = array.length - 1;

        while (lo <= hi) {
            //int mid = lo + (hi - lo) / 2;
            int mid = (hi + lo) >> 1;
            int c = key - array[mid];
            if (c > 0)
                lo = mid + 1;
            else if (c < 0)
                hi = mid - 1;
            else
                return mid;
        }
        //没找到
        return -1;
    }


    /**
     * 交换数组中两个数(这里尽量用异或法)
     *
     * @param array 数组
     * @param i     下标
     * @param j     下标
     */
    private void switch2Num(int[] array, int i, int j) {
        //异常检测, (i==j)会使得结果为0
        if (i == j) return;
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
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
