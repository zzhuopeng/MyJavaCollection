package com.B1_MyNotes.P1_Sort;

public class N03_HeapSort {
    public static void sort(int[] array) {
        //堆有序
        for (int i = array.length / 2; i >= 0; i--) {
            sink(array, i, array.length);  //N限制了下沉操作数组的长度
        }

        //完全有序
        for (int i = array.length - 1; i >= 0; i--) {  //每次将数组最大值交互到最后，再根节点下沉
            exchange(array, 0, i);
            sink(array, 0, i);
        }
    }

    private static void exchange(int[] array, int i, int j) {
        if (i == j) return;
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

    private static void sink(int[] array, int index, int N) {

        while (2 * index + 1 < N) {
            int child = 2 * index + 1;   //根节点从0开始，则左子结点为2i+1
            if (child + 1 < N && array[child] < array[child + 1]) {
                child++;
            }
            if (array[child] < array[index])
                break;
            exchange(array, index, child);
            index = child;
        }
    }
}
