package com.books.CodingInterviews;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class P145_Merge {

    public static void main(String[] args) {
        //初始化两个测试链表
        ListNode list1, list2, tail;
        list1 = list2 = tail = null;
        int[] test1 = {1, 2, 3};
        int[] test2 = {1, 1, 3};
        for (int i = 0; i < test1.length; i++) {
            ListNode tmp = new ListNode(test1[i]);
            if (null == list1) {
                list1 = tmp;
                tail = tmp;
            } else {
                tail.next = tmp;
                tail = tail.next;
            }
        }
        for (int i = 0; i < test2.length; i++) {
            ListNode tmp = new ListNode(test2[i]);
            if (null == list2) {
                list2 = tmp;
                tail = tmp;
            } else {
                tail.next = tmp;
                tail = tail.next;
            }
        }

        //测试
        ListNode result = Merge(list1, list2);
        //打印
        while (null != result) {
            System.out.print(result.val + ' ');
            result = result.next;
        }
    }


    //考虑将list2的内容并入list1中
    public static ListNode Merge(ListNode list1, ListNode list2) {
        //异常检测
        if (null == list1) {
            return list2;
        }
        if (null == list2) {
            return list1;
        }

        ListNode pre1 = list1;//用于记录p1的前节点
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (null != p1 && null != p2) {
            //list1中找更大的来进行对比
            if (p1.val < p2.val) {
                pre1 = p1;
                p1 = p1.next;
            } else {
                //如果p2更小，则插到p1前面
                ListNode tmp = p2;
                p2 = p2.next;
                //插入
                if (pre1 == p1) {
                    tmp.next = p1;
                    list1 = tmp;
                    pre1 = tmp;
                } else {
                    tmp.next = p1;
                    pre1.next = tmp;
                    //pre下移一格
                    pre1 = pre1.next;
                }
            }
        }

        //把p2中剩下的加到list1的末尾
        if (null == p1) {
            pre1.next = p2;
        }
        return list1;
    }

    //考虑新建一个链表将两个链表装起来
    public static ListNode Merge1(ListNode list1, ListNode list2) {
        //异常检测
        if (null == list1) {
            return list2;
        }
        if (null == list2) {
            return list1;
        }

        ListNode result, tail;//新链表头尾节点
        ListNode tmp;//临时
        result = tail = tmp = null;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (null != p1 && null != p2) {
            if (p1.val < p2.val) {
                tmp = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                tmp = new ListNode(p2.val);
                p2 = p2.next;
            }
            if (null == result) {
                result = tmp;
                tail = tmp;
            } else {
                //尾部插入节点
                tail.next = tmp;
                tail = tail.next;
            }
        }

        //把p2中剩下的加到list1的末尾
        if (null == p1) {
            while (null != p2) {
                tmp = new ListNode(p2.val);
                p2 = p2.next;
                //尾部插入节点
                tail.next = tmp;
                tail = tail.next;
            }
        }
        //把p1中剩下的加到list1的末尾
        if (null == p2) {
            while (null != p1) {
                tmp = new ListNode(p1.val);
                p1 = p1.next;
                //尾部插入节点
                tail.next = tmp;
                tail = tail.next;
            }
        }
        return result;
    }
}