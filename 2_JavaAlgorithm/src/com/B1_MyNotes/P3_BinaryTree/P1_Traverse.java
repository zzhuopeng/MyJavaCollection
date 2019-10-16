package com.B1_MyNotes.P3_BinaryTree;

import com.B1_CodingInterviews.N07_RebuildBianryTree.P1_QueryPost;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 二叉树各种遍历方式
 * 12473568,47215386,74258631
 */
public class P1_Traverse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
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
        //构建二叉树
        P1_QueryPost buildTree = new P1_QueryPost();
        P1_QueryPost.TreeNode root = buildTree.init(pre, 0, pre.length - 1, mid, 0, mid.length - 1); //注意不要越界
        //遍历
        preOrder(root);
        System.out.println();
        preOrder2(root);
        System.out.println();

        midOrder(root);
        System.out.println();
        midOrder2(root);
        System.out.println();

        postOrder(root);
        System.out.println();
        postOrder2(root);
        System.out.println();

        levelOrder(root);
        System.out.println();
    }

    public static void preOrder(P1_QueryPost.TreeNode root) {
        if (null == root)
            return;
        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void preOrder2(P1_QueryPost.TreeNode root) {
        Stack<P1_QueryPost.TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            P1_QueryPost.TreeNode p = stack.pop();
            System.out.print(p.val);
            if (null != p.right) stack.push(p.right);
            if (null != p.left) stack.push(p.left);
        }
    }

    public static void midOrder(P1_QueryPost.TreeNode root) {
        if (null == root)
            return;
        midOrder(root.left);
        System.out.print(root.val);
        midOrder(root.right);
    }

    public static void midOrder2(P1_QueryPost.TreeNode root) {
        Stack<P1_QueryPost.TreeNode> stack = new Stack<>();
        P1_QueryPost.TreeNode p = root;
        while (null != p || !stack.isEmpty()) {
            while (null != p) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                System.out.print(p.val);
                p = p.right;
            }
        }
    }

    public static void postOrder(P1_QueryPost.TreeNode root) {
        if (null == root)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val);
    }

    public static void postOrder2(P1_QueryPost.TreeNode root) {
        List<Integer> res = new Stack<>();
        if (root == null)
            return;
        Stack<P1_QueryPost.TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            P1_QueryPost.TreeNode node = stack.pop();
            res.add(0, node.val);                        //逆序添加结点值
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        //打印结果
        for (Integer i : res) {
            System.out.print(i);
        }
    }

    public static void levelOrder(P1_QueryPost.TreeNode root) {
        if (null == root)
            return;
        LinkedList<P1_QueryPost.TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            P1_QueryPost.TreeNode node = queue.pop();
            System.out.print(node.val);
            if (null != node.left)
                queue.push(node.left);
            if (null != node.right)
                queue.push(node.right);
        }
    }
}
