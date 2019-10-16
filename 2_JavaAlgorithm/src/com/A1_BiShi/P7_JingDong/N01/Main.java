package com.A1_BiShi.P7_JingDong.N01;

import java.util.*;

/**
 * 京东第一题
 */
public class Main {
    /**
     * 2 1 3 2
     * 69079936 236011312 77957850 653604087 443890802 277126428 755625552 768751840 993860213 882053548
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(scanner.nextInt());
        }

        int res = 0; //组数
        int pre = 0; //上一个数
        for (Integer i : list) {
            if (i>pre) {
                pre = i;
                res++;
            } else {
                pre = i;
            }
        }

        System.out.println(res);
        //System.out.println(2);
    }
}
