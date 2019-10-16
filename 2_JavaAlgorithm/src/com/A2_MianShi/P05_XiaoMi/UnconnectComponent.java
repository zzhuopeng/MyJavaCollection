package com.A2_MianShi.P05_XiaoMi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 说明：6表示顶点个数，4表示边个数，为了简便，0,1,2,3,4,5分别表示A,B,C,D,E,F
 *
 * 6
 * 4
 * 0 1
 * 0 2
 * 3 4
 * 3 5
 */
public class UnconnectComponent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt(); //顶点
        int E = scanner.nextInt(); //边

        //邻接表初始化
        Graph graph = new Graph(V);
        for (int i = 0; i < E; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.addEdge(a, b);
        }
        //打印
        graph.printGraph();

        //DFS查找联通节点
        graph.printUnconnectComponent(0);
    }
}

/**
 * 无向图
 */
class Graph {
    private int V; //顶点
    private int E; //边
    private ArrayList<Integer>[] list;

    private int start;    //起点
    private boolean[] marked; //标记

    public Graph(int V) {
        this.V = V;
        list = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            list[i] = new ArrayList<>();
        }
    }

    public void addEdge(int a, int b) {
        if (list == null)
            return;

        list[a].add(b);
        list[b].add(a); //无向图（双向）
        E++;
    }

    public void printGraph() {
        for (int i = 0; i < list.length; i++) {
            System.out.print(i + ": ");
            for (int j : list[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public void printUnconnectComponent(int start) {
        depthFirstSearch(start);
        System.out.print("与" + start + "不连通节点有:");
        for (int i = 0; i < marked.length; i++) {
            if (!marked[i])
                System.out.print(i + " ");
        }
    }

    /**
     * DFS标记联通节点
     * @param start 起点
     */
    private void depthFirstSearch(int start) {
        this.start = start;
        marked = new boolean[V];
        dfs(start);
    }

    private void dfs(int start) {
        marked[start] = true;
        for (int i = 0; i < list[start].size(); i++) {
            int tmp = list[start].get(i);
            if (!marked[tmp]) {
                dfs(tmp);
            }
        }
    }
}
