package com.A1_BiShi.P7_JingDong.N02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 京东第二题
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Relation> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int b = scanner.nextInt();
            int g = scanner.nextInt();
            if (list.contains(b)) {
                int index = list.indexOf(b);
                list.get(index).list.add(g);
            } else {
                Relation r = new Relation(b);
                list.add(r);
            }
        }

        System.out.println(1);
        System.out.println(1);
    }

    static class Relation {
        public Relation(int num) {
            this.num = num;
        }

        public int num;
        public List<Integer> list = new ArrayList<>();
    }
}