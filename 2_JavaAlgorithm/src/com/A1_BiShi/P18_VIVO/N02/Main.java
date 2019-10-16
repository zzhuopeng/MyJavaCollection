package com.A1_BiShi.P18_VIVO.N02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 第二题：报数（AC）
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        String output = solution(input);
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

    private static String solution(int[] input) {

        if(null == input || 2 != input.length)
            return null;
        int N = input[0];
        int M = input[1];

        List<Integer> list = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }


        ArrayList<Integer> record = new ArrayList<>();
        int count = 1;
        while (!list.isEmpty()) {
            for (Integer temp : list) {
                if (0 == count % M) {
                    result.append(temp);
                    result.append(" ");
                    record.add(temp);
                }
                count++;
            }
            for (Integer integer : record) {
                list.remove(integer);
            }
            record.clear();
        }

        return result.toString();
    }

}