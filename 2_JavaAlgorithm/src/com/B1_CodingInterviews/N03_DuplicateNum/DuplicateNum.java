package com.B1_CodingInterviews.N03_DuplicateNum;

import java.util.ArrayList;
import java.util.List;

/**
 * 第三题：长度为N的数组所有数字都在0~n-1范围，求数组中重复数字(任意一个)
 */
public class DuplicateNum {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 0, 2, 5, 3};

        int duplicateNum = DuplicateNum2(array);
        System.out.print(duplicateNum);
    }

    /**
     * 修改数组方式
     */
    public static int DuplicateNum(int[] array) {
        if (null == array || array.length <= 1)
            return -1;
        for (int i = 0; i < array.length; i++) {
            if (0 > array[i] || array[i] > array.length - 1)
                return -1;
        }

        int res = -1;
        for (int i = 0; i < array.length; i++) {
            while (i != array[i]) {
                if (array[i] == array[array[i]]) {  //不同下标出现了两次
                    return res;
                }
                exchange(array, i, array[i]);
            }
        }
        return res;
    }

    /**
     * 不修改数组方式
     */
    public static int DuplicateNum2(int[] array) {
        if (null == array || array.length <= 1)
            return -1;
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int middle = (start + end) >> 1;

            int count = countRange(array, start, middle);

            if (start == end) { //递归结束
                if (count > 1)
                    return start;
                else
                    break;
            }

            if (count > (middle - start + 1))
                end = middle;
            else
                start = middle + 1;
        }
        return -1;
    }

    private static int countRange(int[] array, int start, int end) {
        if (null == array)
            return -1;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (start <= array[i] && array[i] <= end)
                count++;
        }
        return count;
    }


    public static void exchange(int[] array, int i, int j) {
        if (i == j)
            return;
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }
}
