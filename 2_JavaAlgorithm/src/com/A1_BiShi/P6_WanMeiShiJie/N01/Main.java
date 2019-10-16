package com.A1_BiShi.P6_WanMeiShiJie.N01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 完美世界笔试第一题（AC）
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s =  scanner.nextLine();
            int limit = scanner.nextInt();

            String[] array = s.split(" ");
            Integer[] weights = new Integer[array.length];
            for (int i = 0; i < array.length; i++) {
                weights[i] = Integer.parseInt(array[i]);
            }

            int res = 0;
            //排序
            Arrays.sort(weights);
            int l = 0, r = weights.length-1;
            while (l<r) {
                if (weights[l] + weights[r] <= limit) {
                    l++;
                    r--;
                } else {
                    r--;
                }
                res++;
            }
            //刚好剩一个
            if (l==r)
                res++;
            System.out.println(res);
        }
    }
}
