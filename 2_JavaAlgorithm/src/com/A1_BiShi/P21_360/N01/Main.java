package com.A1_BiShi.P21_360.N01;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        HashMap<Integer, Integer> relations = new HashMap<>();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int t = scanner.nextInt();
            relations.put(a, t);
            array[i] = a;
        }
        Arrays.sort(array);

        double S = 0.0;
        long V = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            int a = array[i];
            int t = relations.get(a);
            S += V * t + 0.5 * a * Math.pow(t, 2);
            V += a * t;
        }

        System.out.println(new DecimalFormat("0.0").format(S)); //四舍五入保留一位小数
    }
}
