package com.B1_CodingInterviews.N31_StackPushPop;

import java.util.Stack;

public class StackPushPop {
    public static void main(String[] args) {
        int[] push = new int[]{1, 2, 3, 4, 5};
//        int[] pop = new int[]{4, 5, 3, 2, 1};
        int[] pop = new int[]{4, 3, 5, 1, 2};

        System.out.print(isPopOrder(push, pop));
    }

    public static boolean isPopOrder(int[] pushA, int[] popA) {

        if (null == pushA || null == popA || 0 == pushA.length
                || 0 == popA.length || pushA.length != popA.length)
            return false;
        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        while (j <= popA.length - 1) { //只判断j的大小
            while (stack.isEmpty() || stack.peek() != popA[j]) { //空的话也直接push
                if (i == pushA.length) return false;
                stack.push(pushA[i]);
                i++;
            }
            if(stack.peek() != popA[j]) return false;
            stack.pop();
            j++;
        }

        return true;
    }
}
