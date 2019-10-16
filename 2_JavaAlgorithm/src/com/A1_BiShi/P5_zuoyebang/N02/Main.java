package com.A1_BiShi.P5_zuoyebang.N02;

import java.util.Scanner;
import java.util.Stack;

/**
 * 第二题
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();

            //异常检查
            if (s == null || 0 == s.length())
                System.out.println("");

            //转存到Stack中
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                stack.add(s.charAt(i));
            }

            //用StringBuilder拼接起来
            StringBuilder stringBuilder = new StringBuilder();
            while (!stack.empty()) {
                stringBuilder.append(stack.pop());
            }

            System.out.println(stringBuilder.toString());
        }
    }
}
