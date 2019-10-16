package com.B1_MyNotes.P3_Graph;

import java.util.*;

public class N01_DFS {
    /**
     * Algorithm 4th P340 测试用例：
     * 6
     * 8
     * 0 5
     * 2 4
     * 2 3
     * 1 2
     * 0 1
     * 3 4
     * 3 5
     * 0 2
     * <p>
     * （为了构成的邻接表和书本相同）
     * 6
     * 8
     * 0 2
     * 3 5
     * 3 4
     * 0 1
     * 1 2
     * 2 3
     * 2 4
     * 0 5
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt(); //顶点
        int E = scanner.nextInt(); //边

        //邻接表初始化
        Graph graph = new Graph(V, E);
        for (int i = 0; i < E; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.addEdge(a, b);
        }
        //打印
        graph.printGraph();

        //DFS
//        graph.depthFirstSearch(0);
        graph.depthFirstSearchStack(0);

//        System.out.println();
        graph.printfPathTo(5);
    }
}

/**
 * 无向图
 */
class Graph {
    private int V; //顶点
    private int E; //边
    private ArrayList<Integer>[] list;

    private int[] edgeTo; //从start到一个顶点的已知路径
    private int start;    //起点
    private boolean[] marked; //标记

    public Graph(int V, int E) {
        this.V = V;
        //this.E = E;
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

    //递归
    public void depthFirstSearch(int start) {
        this.start = start;
        marked = new boolean[V];
        edgeTo = new int[V];

        dfs(start);
    }

    private void dfs(int start) {
        marked[start] = true;
        for (int i = 0; i < list[start].size(); i++) {
            int tmp = list[start].get(i);
            if (!marked[tmp]) {
                edgeTo[tmp] = start;//edgeTo[start] = tmp  ????? 反着往回指
                dfs(tmp);
            }
        }
    }

    //非递归：栈
    public void depthFirstSearchStack(int start) {
        this.start = start;
        marked = new boolean[V];
        edgeTo = new int[V];

        Stack<Integer> stack = new Stack<>();
        marked[start] = true;
        stack.push(start);

        while (!stack.empty()) {
            int tmp = stack.pop();
            for (int i = 0; i < list[tmp].size(); i++) {
                int j = list[tmp].get(i);
                if (!marked[j]) {
                    stack.push(tmp); //注意这个也要入栈(回溯)
                    stack.push(j);
                    marked[j] = true;
                    edgeTo[j] = tmp;
                    break;
                }
            }
        }
    }

    public void BreadFirstPath(int start) {
        this.start = start;
        edgeTo = new int[V];
        marked = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(start);

        while (!queue.isEmpty()) {

        }

    }

    //打印路径
    public void printfPathTo(int v) {
        System.out.print(start + "-" + v + ": ");
        Stack<Integer> path = new Stack<>();
        for (int i = v; i != start; i = edgeTo[i]) {
            path.push(i);
        }
        path.push(start);
        //千万不要在for中修改容器（i++,而size--） for (int i = 0; i < path.size(); i++)
        while (!path.empty()) {
            System.out.print(path.pop() + " ");
        }
//        for (int i = 0; i < path.size(); i++) {
//            System.out.print(path.pop() + " ");
//        }
    }
}
