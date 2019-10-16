package com.A1_BiShi.P3_QuShiKeJi;

import java.util.Scanner;

public class Adder {
    private static String add(String num1, String num2) {
        if (num1.length() == 0)
            return num2;
        if (num2.length() == 0)
            return num1;

        StringBuilder resX = new StringBuilder();
        StringBuilder resZ = new StringBuilder();
        int flag = 0;//进位标志

        //计算小数部分
        String[] array1 = num1.split("\\.");
        String[] array2 = num2.split("\\.");

        if (1 != array1.length && 1 != array2.length) {

            int length1 = array1[1].length() - 1;
            int length2 = array2[1].length() - 1;
            while (length1 >= 0 || length2 >= 0) {
                if (length1 > length2) {
                    resX.append(array1[1].charAt(length1));
                    length1--;
                } else if (length1 < length2) {
                    resX.append(array2[1].charAt(length2));
                    length2--;
                } else {
                    int sum = flag + array1[1].charAt(length1) + array2[1].charAt(length2);
                    flag = sum / 10;
                    resX.append(sum % 10);
                    length1--;
                    length2--;
                }
            }
        } else if (1 != array1.length && 1 == array2.length) {
            resX.append(array1[1]);
        } else if (1 == array1.length && 1 != array2.length) {
            resX.append(array2[1]);
        }

        //计算整数(需要将整数部分反转，再计算)
        StringBuilder s1 = new StringBuilder();
        array1[0] = s1.append(array1[0]).reverse().toString();
        StringBuilder s2 = new StringBuilder();
        array2[0] = s2.append(array2[0]).reverse().toString();

        int length1 = 0;
        int length2 = 0;
        while (length1 < array1[0].length() || length2 < array2[0].length()) {
            if (length1 > length2) {
                resZ.append(array1[0].charAt(length1));
                length1++;
            } else if (length1 < length2) {
                resZ.append(array2[0].charAt(length2));
                length2++;
            } else {
                int sum = flag + array1[0].charAt(length1) + array2[0].charAt(length2);
                flag = sum / 10;
                resZ.append(sum % 10);
                length1++;
                length2++;
            }
        }

        return resZ.reverse().append(".").append(resX.toString()).toString();
    }

    // please don't modify any code below.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num1 = sc.nextLine();
        String num2 = sc.nextLine();

        String sum = add(num1, num2);
        System.out.println(sum);
    }
}