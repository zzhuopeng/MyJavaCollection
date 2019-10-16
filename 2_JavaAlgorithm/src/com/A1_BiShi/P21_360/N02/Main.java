package com.A1_BiShi.P21_360.N02;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int max = 0;
        for (int i = 0; i < array.length - 6; i++) {
            int temp = 0;
            for (int j = i; j < i + 6; j++) {
                temp += array[j];
            }
            if (temp > max)
                max = temp;
        }
        double result = max/6.0;

        System.out.println(new DecimalFormat("0.000").format(result)); //四舍五入保留3位小数
    }
}
