package com.B1_MyNotes.P1_Sort;

/**
 * 相邻元素两两比较
 */
public class N04_BubbleSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    exchange(array, j - 1, j);
                }
            }
        }
    }

    private static void exchange(int[] array, int i, int j) {
        if (i == j) return;
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }
}
