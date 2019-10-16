package com.A2_MianShi.P02_Baidu;

/**
 * 百度电话面 第一题
 * 快排
 */
public class N1_QuickSort {
    public static void main(String args[]) {
        int[] array = {1, 3, 7, 4, 0, 2, 7, 5, 1, 3};
        //int []array = null;

        quickSort(array, 0, array.length - 1);
        for (int i1 : array) System.out.print(i1 + " ");
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            //int privote = findPrivote(array, left, right);
            int privote = findPrivoteByExchange(array, left, right);
            quickSort(array, left, privote - 1);
            quickSort(array, privote + 1, right);
        }
    }

    /**
     * 根据基准点，分割两段(交换)
     * 尽量以交换为准，上面那个忘了等于就会进入死循环（两个相同的基准数之间不停交换）。
     *
     * @return
     */
    private static int findPrivoteByExchange(int[] array, int left, int right) {
        int i = left;
        int j = right + 1; //为后面的自减做准备

        int key = array[left];
        while (true) {
            //先自加自减，再判断
            while (array[++i] <= key) if (i == right) break;
            while (array[--j] >= key) if (j == left) break;
            //等于时，也要跳出循环
            if (i >= j) break;
            exchange(array, i, j);
        }
        exchange(array, left, j);
        return j;
    }








    /**
     * 根据基准点，分割两段(非交换)
     *
     * @return
     */
    private static int findPrivote(int[] array, int left, int right) {
        int key = array[left];
        while (left < right) {
            while (left < right && array[right] >= key) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= key) {
                left++;
            }
            array[right] = array[left];
        }
        //将基准数放到中间
        array[left] = key;
        return left;
    }

    /**
     * 交换两个数
     */
    private static void exchange(int[] array, int left, int right) {
//        int tmp = array[left];
//        array[left] = array[right];
//        array[right] = tmp;

        if (left == right) return;
        array[left] = array[left] ^ array[right];
        array[right] = array[left] ^ array[right];
        array[left] = array[left] ^ array[right];
    }
}
