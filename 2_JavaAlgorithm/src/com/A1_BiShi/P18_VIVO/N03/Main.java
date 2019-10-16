package com.A1_BiShi.P18_VIVO.N03;

import java.io.*;

/**
 * 第三题：砝码（最后没时间调试了，写完就交上去，结果发现--写成了++）
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static int solution(int[] input) {

        int left = input[input.length - 1];
        int right = input[input.length - 2];

        for (int i = input.length - 3; i >= 0; i--) {
            if (left < right)
                left += input[i];
            else
                right += input[i];
        }

        return Math.abs(left - right);
    }
}