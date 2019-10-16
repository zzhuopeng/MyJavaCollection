package com.A1_BiShi.P10_YongYou_ZT;

import java.util.Scanner;

/**
 * 已知前序中序，求后序(重建二叉树)
 * A BCDE FGH, BDCE A FHG
 */
public class Main {
    /**
     * ABCDEFGH,BDCEAFHG
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String[] array = s.split(",");

        char[] pre = array[0].toCharArray();
        char[] mid = array[1].toCharArray();

        Node root = init(pre, 0, pre.length - 1, mid, 0, mid.length - 1);
        postOrder(root); //打印后序遍历
    }

    //后序遍历
    private static void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.print(localRoot.data);
        }
    }

    private static Node init(char[] pre, int start1, int end1, char[] mid, int start2, int end2) {
        if (start1 > end1 || start2 > end2) {
            return null;
        }
        char rootData = pre[start1];
        Node head = new Node(rootData);
        int rootIndex = findIndex(mid, rootData, start2, end2);//找到根节点所在位置
        int leftLength = rootIndex-start2; //左子树节点数

        Node left = init(pre, start1 + 1, start1 + leftLength, mid, start2, rootIndex - 1);//构建左子树
        Node right = init(pre, start1 + leftLength + 1, end1, mid, rootIndex + 1, end2);//构建右子树
        head.left = left;
        head.right = right;
        return head;
    }

    private static int findIndex(char[] a, int x, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            if (a[i] == x) {
                return i;
            }
        }
        return -1;
    }

    static class Node {
        public Node left;
        public Node right;
        char data;

        Node(char data) {
            this.data = data;
        }
    }
}
