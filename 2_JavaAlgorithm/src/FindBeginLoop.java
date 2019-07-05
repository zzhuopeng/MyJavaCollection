import org.junit.Test;

import java.util.HashSet;
import java.util.Random;

/**
 * 笔记：数据结构与算法->a3.判断一个链表是否成环
 */
public class FindBeginLoop {

    /**
     * 无环测试
     */
    @Test
    public void testNoCycle() {
        ListNode headNode = new ListNode(0);
        ListNode p = headNode;
        for (int i = 0; i < 10; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        if (hasCycle(headNode)) {//if (findBeginLoop(headNode)) {
            System.out.println("链表有环");
        } else {
            System.out.println("链表无环");
        }
    }

    /**
     * 有环测试
     */
    @Test
    public void testCycle() {
        final int LENGTH = 100;
        //生成一个链表
        ListNode headNode = new ListNode(0);
        ListNode p = headNode;
        for (int i = 0; i < LENGTH; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        //取链表中间节点，连接链表尾部
        ListNode rand = headNode;
        for (int i = 0; i < (int) LENGTH * Math.random(); i++) {
            rand = rand.next;
        }
        p.next = rand;
        if (hasCycle(headNode)) {//if (findBeginLoop(headNode)) {
            System.out.println("链表有环");
        } else {
            System.out.println("链表无环");
        }
    }

    /**
     * 快慢指针
     * @param head 链表头
     * @return 判断结果
     */
    public boolean findBeginLoop(ListNode head) {
        if (null == head || null == head.next)
            return false;
        ListNode cur = head;
        ListNode pre = head;
        while (null != pre.next && null != pre.next.next) {
            cur = cur.next;
            pre = pre.next.next;
            if (cur == pre)
                return true;
        }
        return false;
    }

    /**
     * 哈希表法
     * @param head 链表头
     * @return 判断结果
     */
    public boolean hasCycle(ListNode head) {
        HashSet hashSet = new HashSet();
        ListNode p = head;
        while (null != p) {
            if (!hashSet.contains(p)) {
                hashSet.add(p);
            } else {
                return true;
            }
            p = p.next;
        }
        return false;
    }
}

class ListNode {
    public ListNode next;
    public int val;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
