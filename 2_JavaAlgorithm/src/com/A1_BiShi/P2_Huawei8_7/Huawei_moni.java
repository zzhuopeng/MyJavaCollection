package com.A1_BiShi.P2_Huawei8_7;

import java.util.Scanner;

public class Huawei_moni {
    /**
     * 华为模拟题1：a+b
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            String[] tmp = string.split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            if (0 < a && a < 1000000 && 0 < b && b < 1000000) {
                System.out.println(a + b);
            }
        }
    }

    /**
     * 华为模拟题2：排序（只能和0交换）
     *
     * @param array
     * @param len
     */
    public void sort(int[] array, int len) {

        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length; i++) {
                if (i == array[i]) {
                    continue;
                } else {
                    //swapWithZero(array, len, i);
                }
            }
        }
    }
}
