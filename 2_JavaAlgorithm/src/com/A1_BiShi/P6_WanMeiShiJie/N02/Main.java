package com.A1_BiShi.P6_WanMeiShiJie.N02;

import java.util.Scanner;

/**
 * 完美世界笔试第二题(没通过，估计是-1权重没替换成无穷大)
 * 最短路径 Dijkstra
 */
public class Main {

    private static final int LENGTH = 6;

    public static void main(String[] args) {
        //邻接矩阵
        Integer[][] Adj = new Integer[LENGTH][LENGTH];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < LENGTH; i++) {
            String s = scanner.nextLine();
            String[] array = s.split(" ");
            for (int j = 0; j < LENGTH; j++) {
                Adj[i][j] = Integer.parseInt(array[j]);
            }
        }

        //初始化
        int[] dis = new int[LENGTH];
        boolean[] tmp = new boolean[LENGTH];
        tmp[0] = true;
        for (int i = 0; i < LENGTH; i++) {
            dis[i] = Adj[0][i];
        }

        //最短路径
        minDis(Adj, dis, tmp);
        for (int i = 0; i < dis.length; i++) {
            System.out.println(dis[i]);
        }
    }

    private static void minDis(Integer[][] adj, int[] dis, boolean[] tmp) {
        while (true) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int i = 0; i < dis.length; i++) {
                if (tmp[i] == true)
                    continue;
                else {
                    if (dis[i] < min) {
                        idx = i;
                        min = dis[i];
                    }
                }
            }

            if (idx == -1)
                break;
            tmp[idx] = true;
            for (int i = 0; i < LENGTH; i++) {
                if (adj[idx][i] != Integer.MAX_VALUE) {
                    if (dis[i] < min + adj[idx][i]) {
                        dis[i] = dis[i];
                    } else {
                        dis[i] = min + adj[idx][i];
                    }
                }
            }
        }
    }
}
