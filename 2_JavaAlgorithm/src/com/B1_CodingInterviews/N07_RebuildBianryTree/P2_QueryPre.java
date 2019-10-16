package com.B1_CodingInterviews.N07_RebuildBianryTree;

import java.util.Scanner;

/**
 * N7:重建二叉树。
 * 根据后序遍历和中序遍历，重建二叉树(12473568)
 * 74258631,47215386
 */
public class P2_QueryPre {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        String[] postString = s[0].split("|"); //每个字符分割成字符串
        String[] midString = s[1].split("|");

        //转换为int数组
        int[] post = new int[postString.length];
        int[] mid = new int[midString.length];
        for (int i = 0; i < post.length; i++) {
            post[i] = Integer.parseInt(postString[i]);
        }
        for (int i = 0; i < mid.length; i++) {
            mid[i] = Integer.parseInt(midString[i]);
        }

        TreeNode root = init(post, 0, post.length-1, mid, 0, mid.length-1); //注意不要越界
        preOrder(root); //前序遍历
    }

    private static void preOrder(TreeNode root) {
        if (null == root)
            return;
        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    private static TreeNode init(int[] post, int start1, int end1, int[] mid, int start2, int end2) {
        if (start1 > end1 || start2 > end2)
            return null;

        TreeNode root = new TreeNode(post[end1]); //下标为end1的节点为根节点
        int rootIndex = findRootIndex(mid, start2, end2, post[end1]);
        int leftLength = rootIndex - start2;

        root.left = init(post, start1, start1 + leftLength-1, mid, start2, rootIndex - 1);
        root.right = init(post, start1 + leftLength, end1-1, mid, rootIndex + 1, end2);
        return root;
    }

    private static int findRootIndex(int[] mid, int start2, int end2, int root) {
        for (int i = start2; i <= end2; i++) {
            if (root == mid[i])
                return i;
        }
        return -1;
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
