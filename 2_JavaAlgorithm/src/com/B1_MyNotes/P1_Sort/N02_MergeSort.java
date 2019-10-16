package com.B1_MyNotes.P1_Sort;

/**
 * 两个指针的数组比大小
 */
public class N02_MergeSort {

    private static int[] tmp; //辅助数组

    public static void sort(int[] array) {
        if (array != null) {
            tmp = new int[array.length];
            mergeSort(array, 0, array.length - 1);
        }
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) >> 1;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    //合并
    private static void merge(int[] array, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {   //循环范围为left到right
            tmp[k] = array[k];
        }
        for (int k = left; k <= right; k++) {   //循环范围为left到right
            if (i > mid) array[k] = tmp[j++];
            else if (j > right) array[k] = tmp[i++];
            else if (tmp[i] < tmp[j]) array[k] = tmp[i++];
            else array[k] = tmp[j++];
        }
    }
}
