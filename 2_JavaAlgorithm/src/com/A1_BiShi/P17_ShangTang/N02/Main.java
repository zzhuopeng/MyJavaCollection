package com.A1_BiShi.P17_ShangTang.N02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        HashMap<Integer, Integer> relation = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            relation.put(a, b);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int temp = scanner.nextInt();
            result.add(relation.get(temp));
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
