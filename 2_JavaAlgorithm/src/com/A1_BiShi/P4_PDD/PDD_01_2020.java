package com.A1_BiShi.P4_PDD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * PDD学霸批：第一题：求最小方差（只通过85%）
 */
public class PDD_01_2020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int length = scanner.nextInt();

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                list.add(scanner.nextInt());
            }
            if (length >= 3000 || length <= 2)
                return;
            //排序
            Collections.sort(list);
            //找出最“内聚”的相邻三个数
            float min = 300000;
            int index = 0;
            for (int i = 0; i < list.size() - 2; i++) {
                int sum = list.get(i) + list.get(i + 1) + list.get(i + 2);
                float ave = (float) (sum / 3.0);
                float compare = Math.abs(list.get(i) - ave) + Math.abs(list.get(i + 1) - ave) + Math.abs(list.get(i + 2) - ave);
                if (compare < min) {
                    min = compare;
                    index = i;
                }
            }
            //计算方差
            int sum = list.get(index) + list.get(index + 1) + list.get(index + 2);
            float ave = (float) (sum / 3.0);

            double res = (Math.pow(Math.abs(list.get(index) - ave), 2) + Math.pow(Math.abs(list.get(index + 1) - ave), 2)
                    + Math.pow(Math.abs(list.get(index + 2) - ave), 2)) / 3;

            System.out.printf("%.2f\n", res);
        }
    }
}