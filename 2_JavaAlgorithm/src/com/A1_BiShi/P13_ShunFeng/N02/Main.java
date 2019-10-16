package com.A1_BiShi.P13_ShunFeng.N02;

import java.util.Scanner;

public class Main {
    /**
     * 00002:00130
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sa = scanner.nextLine().split(":");

        char[] hour = sa[0].toCharArray();
        char[] min = sa[1].toCharArray();

        int[] hourInt = new int[hour.length];
        int[] minInt = new int[min.length];

        for (int i = 0; i < hour.length; i++) {
            if (hour[i] <= 57)
                hourInt[i] = hour[i] - 48;
            else
                hourInt[i] = hour[i] - 65;
        }
        int hourMax = hourInt[0];
        for (int i = 0; i < hourInt.length; i++) {
            if (hourMax < hourInt[i])
                hourMax = hourInt[i];
        }

        for (int i = 0; i < min.length; i++) {
            if (min[i] <= 57)
                minInt[i] = min[i] - 48;
            else
                minInt[i] = min[i] - 65;
        }
        int minMax = minInt[0];
        for (int i = 0; i < minInt.length; i++) {
            if (minMax < minInt[i])
                minMax = minInt[i];
        }

        int L = Math.max(hourMax, minMax) + 1;

        int hMin = L - 1;
        int hSum = 0;
        do {
            hMin++;
            hSum = 0;
            for (int i = hourInt.length - 1; i >= 0; i--) {
                hSum += hourInt[i] * Math.pow(hMin, hourInt.length - 1 - i);
            }
        } while (hMin < 24 && hSum < 24);

        int mMin = L - 1;
        int mSum = 0;
        do {
            mMin++;
            mSum = 0;
            for (int i = minInt.length - 1; i >= 0; i--) {
                mSum += minInt[i] * Math.pow(mMin, minInt.length - 1 - i);
            }
        } while (mMin < 60 && mSum < 60);

        int H = Math.min(hMin, mMin) - 1;

        if (L > H)
            System.out.print("-1");
        else if (L <= H)
            for (int i = L; i <= H; i++) {
                System.out.print(i + " ");
            }
    }
}
