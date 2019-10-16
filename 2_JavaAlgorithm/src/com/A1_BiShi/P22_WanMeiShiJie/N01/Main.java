package com.A1_BiShi.P22_WanMeiShiJie.N01;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        MyStack stack = new MyStack();
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            stack.push(temp);
        }

        stack.pop();
        int max = stack.max();
        int min = stack.min();
        System.out.println(max + "," + min);
    }

    static class MyStack {

        private Stack<Integer> stack = new Stack();
        private Stack<Integer> min = new Stack();
        private Stack<Integer> max = new Stack();

        public void push(int data) {
            if (min.isEmpty() || data < min.peek()) {
                min.push(data);
            } else {
                min.push(min.peek());
            }

            if (max.isEmpty() || data > max.peek()) {
                max.push(data);
            } else {
                max.push(max.peek());
            }
            stack.push(data);
        }

        public int pop() {
            min.pop();
            max.pop();
            return stack.pop();
        }

        public int min() {
            return min.peek();
        }

        public int max() {
            return max.peek();
        }
    }
}
