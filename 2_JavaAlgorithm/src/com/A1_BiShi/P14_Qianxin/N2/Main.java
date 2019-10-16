package com.A1_BiShi.P14_Qianxin.N2;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String find_longest_num_str(String input) {
        int maxLength = 0;
        StringBuffer maxStringBuffer = null;
        int curLength = 0;
        StringBuffer curStringBuffer = null;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) <= 57 && input.charAt(i) >= 48) {
                if (curLength == 0) {
                    curStringBuffer = new StringBuffer(String.valueOf(input.charAt(i)));
                    curLength++;
                } else {
                    curStringBuffer.append(input.charAt(i));
                    curLength++;
                }

                if (curLength > maxLength) {
                    maxStringBuffer = curStringBuffer;
                    maxLength = curLength;
                }
            } else {
                curStringBuffer = null;
                curLength = 0;
            }
        }

        return maxStringBuffer.toString();
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        res = find_longest_num_str(_input);
        System.out.println(String.format("%d/%s", res.length(), res));
    }
}
