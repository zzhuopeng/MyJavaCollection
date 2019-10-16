package com.A1_BiShi.P16_ShenXinFu.N01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if (0 == N)
            return;

        char[] array = new char[N];
        for (int i = 0; i < N; i++) {
            String s = scanner.nextLine();
            array[i] = s.charAt(0);
        }

        TreeNode root = new TreeNode(array[0]);
//        root.left = buildTree();
//        root.right = buildTree();
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        char value;

        public TreeNode(char value) {
            this.value = value;
        }
    }
}
