package com.B1_CodingInterviews.N09_TwoStackQueue;

import java.util.Stack;

/**
 * 两个栈实现队列
 */
public class TwoStackQueue {
    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    public static void push(Integer node) {
        stack1.push(node);
    }

    public static int pop() throws Exception {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                Integer temp = stack1.pop();
                stack2.push(temp);
            }
        }

        if (stack2.isEmpty())
            throw new Exception("Queue is empty.");
        return stack2.pop();
    }
}
