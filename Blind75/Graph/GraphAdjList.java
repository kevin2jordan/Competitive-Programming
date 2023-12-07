package Blind75.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class GraphAdjList {
    private List<Integer> adjList[];
    private int V;

    GraphAdjList(int v) {
        this.V = v;
        adjList = new ArrayList[V];
        for(int i=0;i<V;i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        adjList[u].add(v);
      //  adjList[v].add(u);
    }

    public void dfs() {
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                dfsUtil(i, visited);
            }
        }

    }

    private void dfsUtil(int src, boolean[] visited) {
        visited[src] = true;

        System.out.print(src + " ");
        for(int node : adjList[src]) {
            if(!visited[node]) {
                dfsUtil(node, visited);
            }
        }
    }

    public void dfsIterative(int src) {
        boolean[] visited = new boolean[V];

        Stack<Integer> stack = new Stack<>();
        stack.add(src);
        visited[src] = true;

        while(!stack.isEmpty()) {
            int temp = stack.pop();
            System.out.print(temp + " ");
            for(int node : adjList[temp]) {
                if(!visited[node]){
                    visited[node] = true;
                    stack.add(node);
                }
            }
        }
    }

    public void bfs(int src) {
        boolean[] visited = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;

        while(!queue.isEmpty()) {
            int top = queue.poll();
            System.out.print(top + " ");
            for(int node : adjList[top]) {
                if(!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphAdjList graph = new GraphAdjList(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("DFS is ");
        graph.dfs();
        System.out.println("\nIterative DFS is ");
        graph.dfsIterative(0);
        System.out.println();
        System.out.println("BFS is ");
        graph.bfs(0);
    }

}
