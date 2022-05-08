package Blind75.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UndirectedGraphCycle {
    private List<Integer> adjList[];
    private int V;

    UndirectedGraphCycle(int v) {
        this.V = v;
        adjList = new LinkedList[V];
        for(int i=0;i<V;i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
    }

    void dfs() {
        boolean visited[] = new boolean[V+1];
        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                dfsUtil(i, visited);
            }
        }
    }

    void dfsUtil(int src, boolean[] visited) {
        visited[src] = true;

        System.out.print(src + " ");
        for(int node : adjList[src]) {
            if(!visited[node]) {
                dfsUtil(node, visited);
            }
        }
    }

    void bfs() {
        boolean visited[] = new boolean[V+1];
        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                bfsUtil(i, visited);
            }
        }
    }

    void bfsUtil(int src, boolean[] visited) {
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

    boolean isCyclicUtil(int src, boolean[] visited, int parent) {
        visited[src] = true;
        for(int node : adjList[src]) {
            if(!visited[node]) {
                if(isCyclicUtil(node, visited, src)) {
                    return true;
                }
            } else if(node != parent) {
                return true;
            }
        }
        return false;
    }

    boolean isCyclic() {
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                if (isCyclicUtil(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isCyclicBFS() {
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                if (isCyclicUtilBFS(i, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isCyclicUtilBFS(int src, boolean visited[]){
        visited[src] = true;

        Queue<Integer> queue = new LinkedList<>();
        int[] parentArr = new int[V];
        parentArr[src] = -1;

        queue.add(src);

        while(!queue.isEmpty()) {
            int topEle = queue.poll();
            for(int node : adjList[topEle]) {
                if(!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    parentArr[node] = topEle;
                } else if(parentArr[topEle] != node) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        UndirectedGraphCycle graph = new UndirectedGraphCycle(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(2,1);
        graph.addEdge(2,3);
      //  graph.addEdge(3,4);

        graph.bfs();
        System.out.println();
        graph.dfs();
        System.out.println();
        if (graph.isCyclic()) {
            System.out.println("Cycle exist");
        } else {
            System.out.println("Cycle doesn't exist");
        }
        if (graph.isCyclicBFS()) {
            System.out.println("Cycle exist");
        } else {
            System.out.println("Cycle doesn't exist");
        }
    }
}
