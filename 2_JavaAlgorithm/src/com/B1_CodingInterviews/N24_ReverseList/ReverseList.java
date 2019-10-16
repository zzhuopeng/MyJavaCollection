package com.B1_CodingInterviews.N24_ReverseList;

public class ReverseList {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 7, 4, 0, 2, 7, 5, 1, 3};
        ListNode head = new ListNode(array[0]);
        ListNode temp = head;
        for (int i = 1; i < array.length; i++) {
            temp.next = new ListNode(array[i]);
            temp = temp.next;
        }

        ListNode res = reverseList(head);
        while (null != res) {
            System.out.print(res.value + " ");
            res = res.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = head;
        ListNode cur = null;
        while (null != pre) {
            ListNode temp = pre;
            pre = pre.next;
            temp.next = cur;
            cur = temp;
        }
        return cur;
    }

    static class ListNode {
        public ListNode next;
        public int value;

        public ListNode(int value) {
            this.value = value;
        }
    }
}
