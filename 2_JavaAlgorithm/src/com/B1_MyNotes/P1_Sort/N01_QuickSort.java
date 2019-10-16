package com.B1_MyNotes.P1_Sort;

/**
 * 前后指针中间靠
 */
public class N01_QuickSort {

    public static void sort(int[] array) {
        if (null != array)
            quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int partition = partition(array, left, right);
            quickSort(array, left, partition - 1);
            quickSort(array, partition + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right + 1;
        int key = array[i];

        while (true) {
            while (array[++i] <= key) if (i == right) break;
            while (array[--j] >= key) if (j == left) break;
            if (i >= j) break;
            exchange(array, i, j);
        }
        exchange(array, left, j);

        return j;
    }

    private static void exchange(int[] array, int i, int j) {
        if (i == j) return;
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }
}
