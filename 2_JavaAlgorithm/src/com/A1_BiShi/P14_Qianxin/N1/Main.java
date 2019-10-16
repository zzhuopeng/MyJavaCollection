package com.A1_BiShi.P14_Qianxin.N1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int smallestRange(ArrayList<Integer> list, int K) {
        Integer[] array = (Integer[]) list.toArray(new Integer[list.size()]);
        Arrays.sort(list.toArray());

        return array[array.length - 1] - K - (array[0] + K);
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int K = in.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            while (in.hasNext()) {
                list.add(in.nextInt());
            }
            int res = smallestRange(list, K);
            System.out.println(String.valueOf(res));
        }
    }
}
