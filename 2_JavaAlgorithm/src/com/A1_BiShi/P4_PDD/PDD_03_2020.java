package com.A1_BiShi.P4_PDD;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * PDD学霸批：第三题：求序列组合的可能性（未完成）
 */
public class PDD_03_2020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            int S = scanner.nextInt();
            int res = 0;

            for (int i = 1; i < S; i++) {
                int wanted = S - i;
                Map<Integer, Integer> map = new HashMap<>();

                for (int j = i + 1; j < wanted; j++) {

                    if (map.containsKey(wanted - j))
                        res++;
                    else
                        map.put(j, j);
                }
            }

            System.out.println(res);
        }
    }
}
