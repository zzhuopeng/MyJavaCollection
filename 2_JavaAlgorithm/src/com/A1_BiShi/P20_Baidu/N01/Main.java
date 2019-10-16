package com.A1_BiShi.P20_Baidu.N01;

import java.util.Scanner;

//只通过55%
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        long n = scanner.nextLong();

        int temp = a * b;
        int res = temp % 10 + temp / 10;
        long sum = res*n;

        System.out.println(sum);

    }
}
