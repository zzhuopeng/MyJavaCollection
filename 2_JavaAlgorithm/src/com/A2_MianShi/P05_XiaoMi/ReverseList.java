package com.A2_MianShi.P05_XiaoMi;

import java.util.Scanner;

public class ReverseList {

    /**
     * 1234567
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] as = s.nextLine().split("|");
        int[] array = new int[as.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(as[i]);
        }

        ListNode head = new ListNode(array[0]);
        ListNode p = head;
        for (int i = 1; i < array.length; i++) {
            p.next = new ListNode(array[i]);
            p = p.next;
        }

        ListNode res = reverseList(head);
        while (null != res) {
            System.out.print(res.val);
            res = res.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = head;
        ListNode cur = null;
        while (null != pre) {
            ListNode tmp = pre;
            pre = pre.next;

            tmp.next = cur;
            cur = tmp;
        }
        return cur;
    }

    static class ListNode {
        public ListNode next;
        public int val;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
