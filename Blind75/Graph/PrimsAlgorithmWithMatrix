package Blind75.Graph;

import java.util.Arrays;

public class PrimsMatrix {
    private static final int V = 5;

    private static int getMinimumVal(int[] dist, boolean[] visited) {
        int minVal = Integer.MAX_VALUE, minInd = -1;
        for(int i=0;i<V;i++) {
            if(!visited[i] && dist[i] < minVal) {
                minVal = dist[i];
                minInd = i;
            }
        }
        return minInd;
    }

    private static void printSolution(int[] parent, int graph[][]) {
        for(int i=1;i<V;i++) {
            System.out.println(parent[i] + " - " + i + " \t" + graph[i][parent[i]]);
        }
    }

    private static void getMST(int[][] graph, int src) {

        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        parent[src] = -1;

        for(int i=0;i<V;i++) {
            int u = getMinimumVal(dist, visited);
            visited[u] = true;

            for(int v=0;v<V;v++) {
                if(graph[u][v] != 0 && !visited[v] && graph[u][v] < dist[v]) {
                    dist[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }
        printSolution(parent, graph);

    }
    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };

        getMST(graph, 0);
    }
}
