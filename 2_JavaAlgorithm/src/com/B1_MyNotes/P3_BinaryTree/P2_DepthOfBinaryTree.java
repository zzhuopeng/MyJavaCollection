package com.B1_MyNotes.P3_BinaryTree;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 1.计算二叉树深度，递归和非递归
 */
public class P2_DepthOfBinaryTree {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.left.left.right = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        root.right.left.right.left = new TreeNode(7);
        root.right.left.right.left.right = new TreeNode(7);

        int depth = DepthofBT2(root);
        System.out.println("深度为" + depth);
    }

    //递归
    public int DepthofBT(TreeNode root) {
        //递归边界
        if (null == root)
            return 0;

        return Math.max(DepthofBT(root.left), DepthofBT(root.right)) + 1;
    }

    //非递归
    public int DepthofBT2(TreeNode root) {
        int level = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);

        while (!queue.isEmpty()) {
            int num = queue.size(); //该层节点个数
            while (num>0) {
                TreeNode node = queue.poll();
                if (null != node.left) queue.push(node.left);
                if (null != node.right) queue.push(node.right);
                num--;
            }
            level++;
        }
        return level;
    }


    class TreeNode {
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
