package com.B1_CodingInterviews.N09_TwoStackQueue;

import java.util.LinkedList;

/**
 * 两个队列实现栈
 */
public class TwoQueueStack<T> {

    public static void main(String[] args) {
        TwoQueueStack<Integer> stack = new TwoQueueStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(4);
        stack.push(5);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    private LinkedList<T> queue1 = new LinkedList<>();  //LinkedList当成Queue时对应使用add和poll方法
    private LinkedList<T> queue2 = new LinkedList<>();  //当成Stack时对应使用push和pop方法

    public void push(T node) {
        if (!queue1.isEmpty()) {
            queue1.add(node);
        } else {
            queue2.add(node);
        }
    }

    public T pop() {
        if (!queue1.isEmpty()) {
            while (1 != queue1.size()) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        } else if (!queue2.isEmpty()) {
            while (1 != queue2.size()) {
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        } else {
            return null;
        }
    }
}
