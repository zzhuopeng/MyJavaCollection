package com.A1_BiShi.P5_zuoyebang.N03;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 第三题
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();

            //异常检查
            if (s == null || 0 == s.length()) {
                System.out.println("");
                return;
            }

            //去除首尾中括号
            String b = s.replaceAll("\\[([^\\]]*)\\]","$1");

            String[] array = b.split(", ");
            int[] a = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                a[i] = Integer.parseInt(array[i]);
            }

            Set<Integer> hashset = new HashSet<>();
            int maxNum = 0;
            for(int i:a) {
                hashset.add(i);
            }
            for(int i:a)
                if (!hashset.contains(i-1)) {
                    int v = i;
                    while (hashset.remove(v++));
                    maxNum = Math.max(maxNum, v-i-1);
                }
            System.out.println(maxNum);
        }
    }
}
