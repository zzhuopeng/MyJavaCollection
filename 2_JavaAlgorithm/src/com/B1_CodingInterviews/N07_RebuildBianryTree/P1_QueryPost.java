package com.B1_CodingInterviews.N07_RebuildBianryTree;

import org.junit.Test;

import java.util.Scanner;

/**
 * N7:重建二叉树。
 * 根据前序遍历和中序遍历，重建二叉树(74258631)
 * 12473568,47215386
 */
public class P1_QueryPost {

    @Test
    public void test() {
//        Scanner sc = new Scanner(System.in);
//        String[] s = sc.nextLine().split(",");
        String[] s = new String[]{"12473568","47215386"};
        String[] preString = s[0].split("|"); //每个字符分割成字符串
        String[] midString = s[1].split("|");

        //转换为int数组
        int[] pre = new int[preString.length];
        int[] mid = new int[midString.length];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = Integer.parseInt(preString[i]);
        }
        for (int i = 0; i < mid.length; i++) {
            mid[i] = Integer.parseInt(midString[i]);
        }

        TreeNode root = init(pre, 0, pre.length-1, mid, 0, mid.length-1); //注意不要越界
        postOrder(root); //后序遍历
    }

    public void postOrder(TreeNode root) {
        if (null == root)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val);
    }

    public TreeNode init(int[] pre, int start1, int end1, int[] mid, int start2, int end2) {
        if (start1 > end1 || start2 > end2)
            return null;

        TreeNode root = new TreeNode(pre[start1]); //下标为start1的节点为根节点
        int rootIndex = findRootIndex(mid, start2, end2, pre[start1]);
        int leftLength = rootIndex - start2;

        root.left = init(pre, start1 + 1, start1 + leftLength, mid, start2, rootIndex - 1);
        root.right = init(pre, start1 + leftLength + 1, end1, mid, rootIndex + 1, end2);
        return root;
    }

    private int findRootIndex(int[] mid, int start2, int end2, int root) {
        for (int i = start2; i <= end2; i++) {
            if (root == mid[i])
                return i;
        }
        return -1;
    }

    public class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
