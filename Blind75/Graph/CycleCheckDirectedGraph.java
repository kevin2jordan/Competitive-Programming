package Blind75.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleCheckDirectedGraph {
    private List<Integer> adjList[];
    private int V;
    static int WHITE = 0, GRAY = 1, BLACK = 2;

    CycleCheckDirectedGraph(int v) {
        this.V = v;
        adjList = new LinkedList[V];
        for(int i=0;i<V;i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v) {
        adjList[u].add(v);
    }

    boolean checkCycle(int src, boolean[] visited, boolean recStack[]) {
        visited[src] = true;
        recStack[src] = true;

        for(int node : adjList[src]) {
            if(!visited[node]) {
                if(checkCycle(node, visited, recStack)) {
                    return true;
                }
            } else if(recStack[node]) {
                return true;
            }
        }
        recStack[src] = false;

        return false;
    }

    boolean isCyclic(int src) {
        boolean[] visited = new boolean[V+1];
        boolean[] recStack = new boolean[V+1];

        return checkCycle(src, visited, recStack);
    }

    void dfsUtil(int src , boolean visited[]) {
        visited[src] = true;
        System.out.print(src + " ");
        for(int node : adjList[src]) {
            if(!visited[node]) {
                dfsUtil(node, visited);
            }
        }
    }

    void dfs(int src) {
        boolean[] visited = new boolean[V+1];
        dfsUtil(src, visited);
    }

    void bfs(int src) {
        boolean visited[] = new boolean[V+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;

        while(!queue.isEmpty()) {
            int topEle = queue.poll();
            System.out.print(topEle + " ");
            for(int node : adjList[topEle]) {
                if(!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
    }

    private boolean isCyclicColor(int src, int[] color) {
        color[src] = GRAY;

        for(int node: adjList[src]) {
            if(color[node] == WHITE) {
                if(isCyclicColor(node, color)) {
                    return true;
                }
            } else if(color[node] == GRAY) {
                return true;
            }
        }
        color[src] = BLACK;
        return false;
    }

    private boolean cyclicCheckWithColors() {
        int[] color = new int[V+1];
        for(int i=0;i<=V;i++) {
            color[i] = WHITE;
        }

        for(int i=0;i<V;i++) {
            if(color[i] == WHITE) {
                if(isCyclicColor(i, color)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        CycleCheckDirectedGraph graph = new CycleCheckDirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Dfs is ");
        graph.dfs(0);
        System.out.println();
        System.out.println("Bfs is ");
        graph.bfs(0);

        System.out.println();
        if (graph.isCyclic(0)) {
            System.out.println("Cycle exist");
        } else {
            System.out.println("Cycle doesn't exist");
        }

        if(graph.cyclicCheckWithColors()) {
            System.out.println("Cycle exist");
        } else {
            System.out.println("Cycle doesn't exist");
        }

    }
}

