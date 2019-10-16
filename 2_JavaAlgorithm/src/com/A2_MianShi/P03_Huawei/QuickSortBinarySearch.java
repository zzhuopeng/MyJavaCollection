package com.A2_MianShi.P03_Huawei;

import java.util.Scanner;

/**
 * 准备华为面试练习：快排+二分查找
 */
public class QuickSortBinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] sarray = s.split(" ");

            //待排序数组
            int[] array = new int[sarray.length];
            for (int i = 0; i < sarray.length; i++) {
                array[i] = Integer.parseInt(sarray[i]);
            }

            //快排
            quickSort(array, 0, array.length - 1);

            //打印排序结果
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();

            //二分查找
            int target = scanner.nextInt();
            int index = binarySearch(array, target);
            if (index == -1)
                System.out.println("未找到target");
            else
                System.out.println(index);
        }
    }

    private static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) { //这里需要相等
            int mid = (left + right) >> 1;
            int c = target - array[mid];
            if (c > 0) {
                left = mid + 1;
            } else if (c < 0) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) { //这里千万不要用while，切分一次即可
            int partition = partition(array, left, right);
            quickSort(array, left, partition - 1);
            quickSort(array, partition + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {

        int i = left;
        int j = right + 1;
        int key = array[left];
        while (true) {
            while (array[++i] <= key) if (i == right) break; //<=
            while (array[--j] >= key) if (j == left) break; //>=
            if (i >= j) break; //>=
            exchange(array, i, j);
        }
        exchange(array, left, j);
        return j;
    }

    private static void exchange(int[] array, int left, int right) {
        if (left == right) return;
        array[left] = array[left] ^ array[right];
        array[right] = array[left] ^ array[right];
        array[left] = array[left] ^ array[right];
    }
}
