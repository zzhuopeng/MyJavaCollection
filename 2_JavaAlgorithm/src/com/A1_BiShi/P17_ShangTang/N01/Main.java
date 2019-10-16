package com.A1_BiShi.P17_ShangTang.N01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (2 == n)
            System.out.print(3);
        if (3 == n)
            System.out.print(4);

        int times3 = n / 3;
        int result = 0;
        if (0 == n % 3) {
            result = (int) (Math.pow(3, times3) + times3);
        } else if (1 == n % 3) {
            times3 -= 1;
            result = (int) (Math.pow(3, times3) * 4 + times3 + 2);
        } else {
            result = (int) (Math.pow(3, times3) * 2 + times3 + 1);
        }
        System.out.print(result);
    }
}
