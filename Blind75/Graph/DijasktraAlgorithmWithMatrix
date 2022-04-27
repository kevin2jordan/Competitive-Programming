package Blind75.Graph;

import java.util.Arrays;

public class Dijasktra {
    private static final int V = 9;

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

    private static void printSolution(int[] dist) {
        for(int i=0;i<V;i++) {
            System.out.println(i + "  " + dist[i]);
        }
    }

    private static void getShortestPath(int[][] graph, int src) {

        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i=0;i<V;i++) {
            int u = getMinimumVal(dist, visited);
            visited[u] = true;

            for(int v=0;v<V;v++) {
                if(graph[u][v] !=0 && !visited[v] && dist[u] != Integer.MAX_VALUE
                && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        printSolution(dist);

    }
    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        getShortestPath(graph, 0);
    }
}
