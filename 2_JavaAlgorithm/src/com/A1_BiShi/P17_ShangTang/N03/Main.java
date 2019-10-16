package com.A1_BiShi.P17_ShangTang.N03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();

        while (scanner.hasNext())


        System.out.println(Math.pow(2, M + N - 2) + M + N);

    }
}
