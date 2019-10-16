package com.B1_MyNotes.P1_Sort;

/**
 * 每次找出剩余元素最小值，交换到已排序区最后一个位置
 */
public class N06_SelectSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            exchange(array, i, minIndex);
        }
    }

    private static void exchange(int[] array, int i, int minIndex) {
        if (i == minIndex) return;
        array[i] = array[i] ^ array[minIndex];
        array[minIndex] = array[i] ^ array[minIndex];
        array[i] = array[i] ^ array[minIndex];
    }
}
