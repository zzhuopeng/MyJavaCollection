package com.A1_BiShi.P15_DiDi.N01;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        HashMap<Integer, Integer> carA = new HashMap<>();
        HashMap<Integer, Integer> carB = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            carA.put(a, b);
            carB.put(b, a);
        }

        int min = Math.min(carA.size(), carB.size());
        int max = Math.max(carA.size(), carB.size());

        if (2 * (n - max) <= n)
            System.out.print(2 * (n - max));
        else {
            if (n%2 == 0)
                System.out.print(n);
            else
                System.out.print(n-1);
        }
    }
}
