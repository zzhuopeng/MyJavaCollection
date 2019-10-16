package com.A1_BiShi.P5_zuoyebang.N01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 第一题：使用HashMap存储中间值，时间复杂度为O(N)，空间复杂度为O(N)
 * 数组越界 没做出来
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            int target = scanner.nextInt();

            //异常检查
            if (s == null || 0 == s.length()) {
                System.out.println("");
                return;
            }

            //去除首尾中括号
            String b = s.replaceAll("\\[([^\\]]*)\\]", "$1");

            String[] array = b.split(",");
            int[] a = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                a[i] = Integer.parseInt(array[i]);
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < a.length; i++) {
                map.put(a[i], i);
            }

            int[] result = {-1, -1};
            for (int i = 0; i < a.length; i++) {
                int tmp = target - a[i];
                if (map.containsKey(tmp) && target != 2 * tmp) {
                    map.put(a[i], i);
                    result[0] = i;
                    result[1] = map.get(tmp);

                    System.out.println(result[0]+","+result[1]);
                }
            }

            System.out.println("");
        }
    }
}
