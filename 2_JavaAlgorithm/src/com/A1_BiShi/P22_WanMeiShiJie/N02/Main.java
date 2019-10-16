package com.A1_BiShi.P22_WanMeiShiJie.N02;

import java.util.Scanner;

/**
 * 没提交上，没验证是否可行
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[] path = dijkstra(matrix, p);
        for (int i = 0; i < n; i++) {
            if (i == p)
                continue;
            System.out.println(path[i]);
            if (i != n - 1)
                System.out.println(",");
        }
    }

    private static int[] dijkstra(int[][] matrix, int s) {
        int length = matrix.length;
        int[] paths = new int[length];
        int[] visited = new int[length];

        paths[s] = 0;
        visited[s] = 1;
        for (int i = 0; i < length; i++) {
            int k = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < length; j++) {
                if (0 == visited[i] && matrix[s][i] < min && matrix[s][i] != -1) {
                    min = matrix[s][i];
                    k = i;
                }
            }
            paths[k] = min;
            visited[k] = 1;

            for (int j = 0; j < length; j++) {
                if (0 == visited[j] && matrix[s][k] + matrix[k][j] < matrix[s][j] && matrix[s][k] != -1&& matrix[k][j] != -1&& matrix[s][j] != -1) {
                    matrix[s][j] = matrix[s][k] + matrix[k][j];
                }
            }
        }
        return paths;
    }
}
