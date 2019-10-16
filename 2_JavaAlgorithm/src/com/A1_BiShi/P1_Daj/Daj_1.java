package com.A1_BiShi.P1_Daj;

import java.util.*;

/**
 * 大疆第一题（未完成）
 */
public class Daj_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //保存结果
            List<Integer> res = new ArrayList<>();

            int cNum = scanner.nextInt();
            for (int i = 0; i < cNum; i++) {

                String[] nums = scanner.nextLine().split(" ");
                int categorys = Integer.parseInt(nums[0]);
                int times = Integer.parseInt(nums[1]);

                //游戏信息
                int[] key = new int[categorys + 1];
                int[] value = new int[categorys + 1];
                for (int j = 1; j < categorys + 1; j++) {
                    String[] tmp = scanner.nextLine().split(" ");
                    key[j] = Integer.parseInt(tmp[0]);
                    value[j] = Integer.parseInt(tmp[1]);
                }

                res.add(findMax(key, value, categorys, times));
            }

            //输出
            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.get(i));
            }
        }
    }

    static int findMax(int[] key, int[] value, int categorys, int times) {

        int[][] d = new int[11][1000];
        for (int i = 0; i < categorys + 1; i++) {
            for (int j = 0; j < times + 1; j++) {
                if (0 == i) {
                    d[i][j] = 0;
                } else {
                    if (j < value[i]) {
                        d[i][j] = 0;
                    } else {
                        d[i][j] = key[i] + d[i - 1][j - value[i]];
                    }
                    if (d[i][j] < d[i - 1][j]) {
                        d[i][j] = d[i - 1][j];
                    }
                }
            }
        }

        return d[categorys][times];
    }
}
