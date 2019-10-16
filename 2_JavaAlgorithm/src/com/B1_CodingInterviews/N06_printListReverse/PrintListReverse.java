package com.B1_CodingInterviews.N06_printListReverse;

import java.util.Stack;

/**
 * 从尾到头打印链表
 */
public class PrintListReverse {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 7, 4, 0, 2, 7, 5, 1, 3};
        ListNode head = new ListNode(array[0]);
        ListNode temp = head;
        for (int i = 1; i < array.length; i++) {
            temp.next = new ListNode(array[i]);
            temp = temp.next;
        }

        printListReverse(head);
    }

    public static void printListReverse(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (null != head) {
            stack.push(head.value);
            head = head.next;
        }
        //打印
        while(!stack.isEmpty()) {
            int i = stack.pop();
            System.out.print(i + " ");
        }
    }

    static class ListNode {
        public ListNode next;
        public int value;

        public ListNode(int value) {
            this.value = value;
        }
    }
}
