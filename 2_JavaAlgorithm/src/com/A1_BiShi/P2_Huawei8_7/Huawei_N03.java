package com.A1_BiShi.P2_Huawei8_7;

import java.util.*;

/**
 * 华为笔试第三题：计算与或非表达式
 */
public class Huawei_N03 {
    public static void main(String[] args) {
        //运算符的优先级
        Map<Character, Integer> map = new HashMap<>();
        map.put('(', 4);
        map.put(')', 4);
        map.put('!', 3);
        map.put('&', 2);
        map.put('|', 1);
        map.put('0', 0);
        map.put('1', 0);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();

            boolean flag = true;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < string.length(); i++) {
                if (map.containsKey(string.charAt(i))) {
                    if (0 == map.get(string.charAt(i))) {
                        stack.add(string.charAt(i));
                    }
                }
            }

            if (flag)
                System.out.println(0);
        }
    }
}
