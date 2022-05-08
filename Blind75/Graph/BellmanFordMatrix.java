package Blind75.Graph;

import java.util.Arrays;

public class BellmanFordMatrix {
    private static void BellmanFordAlgo(int[][] graph, int V, int E, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        for(int i=0;i<V-1;i++) {
            for(int j=0;j<E;j++) {
                if(dist[graph[j][0]] != Integer.MAX_VALUE &&
                        dist[graph[j][0]] + graph[j][2] < dist[graph[j][1]]) {
                    dist[graph[j][1]] = dist[graph[j][0]] + graph[j][2];
                }
            }
        }

        for(int i=0;i<E;i++) {
            int x = graph[i][0];
            int y = graph[i][1];
            int w = graph[i][2];

            if(dist[x] != Integer.MAX_VALUE && dist[x] + w < dist[y]) {
                System.out.println("Graph contains negative"
                        +" weight cycle");
            }
        }
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5;
        int E = 8;

        int graph[][] = {
                { 0, 1, -1 }, { 0, 2, 4 },
                { 1, 2, 3 }, { 1, 3, 2 },
                { 1, 4, 2 }, { 3, 2, 5 },
                { 3, 1, 1 }, { 4, 3, -3 } };

        BellmanFordAlgo(graph, V, E, 0);
    }
}
