package com.B1_MyNotes.P1_Sort;

/**
 * 从后面一个个向前比较，如果大于则往后移动，如果小于则退出循环再插入赋值；
 */
public class N05_InsertSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (array[j] > tmp) array[j + 1] = array[j];
                else {
//                    array[j + 1] = tmp;  //在这里赋值后break有什么区别？
                    break;              // 如果第一个较大，会导致无法用tmp替代第一个，因为此时j=0已经在上一个判断用过了
                }
            }
            array[j + 1] = tmp;
        }
    }
}
