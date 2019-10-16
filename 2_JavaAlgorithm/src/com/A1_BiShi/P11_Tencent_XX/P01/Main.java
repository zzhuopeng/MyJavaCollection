package com.A1_BiShi.P11_Tencent_XX.P01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int A[] = new int[n];
        int B[] = new int[m];
        int jin = 0;
        int oun = 0;
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
            if (A[i] % 2 == 0) oun++;
            else {
                jin++;
            }
        }
        int jim = 0;
        int oum = 0;
        for (int i = 0; i < m; i++) {
            A[i] = in.nextInt();
            if (A[i] % 2 == 0) oum++;
            else {
                jim++;
            }
        }
        int result = Math.min(jim, oun) + Math.min(jin, oum);
        System.out.println(result);
    }
}
