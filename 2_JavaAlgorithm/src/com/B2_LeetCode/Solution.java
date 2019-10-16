package com.B2_LeetCode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 判断括号是否合法
 */
public class Solution {

    private static final String S = "()()()()(){}{}{}[][][][]";

    @Test
    public void test() {
        System.out.println(isValid(S));
    }


    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsValue(c)) {
                stack.push(c);
            } else {
                char r = stack.empty() ? '#' : stack.pop();
                if (r != map.get(c))
                    return false;
            }
        }

        return stack.empty();
    }
}
