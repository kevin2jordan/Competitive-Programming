package Blind75.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class PrimsAdjList {

     class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    private static int V;
    private static List<Edge> adjList[];

    PrimsAdjList(int v) {
        V = v;
        adjList = new ArrayList[V];
        for(int i=0;i<V;i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v, int w) {
        adjList[u].add(new Edge(v,w));
        adjList[v].add(new Edge(u,w));
    }

    public void primsMST() {

        boolean[] mstset = new boolean[V];
        Edge[] dist = new Edge[V];

        int[] parent = new int[V];

        for (int i = 0; i < V; i++) {
            dist[i] =  new Edge(i, Integer.MAX_VALUE);
            parent[i] = -1;
        }

        mstset[0] = true;

        dist[0].weight = 0;

        TreeSet<Edge> queue = new TreeSet<>(Comparator.comparingInt((Edge x) -> x.weight));

        for (int i = 0; i < V; i++) {
            queue.add(dist[i]);
        }

        while (!queue.isEmpty()) {

            int srcNode = queue.pollFirst().dest;
            mstset[srcNode] = true;

            for (Edge destination : adjList[srcNode]) {
                int destNode = destination.dest;
                int weight = destination.weight;

                if (!mstset[destNode]) {

                    if (dist[destNode].weight > weight) {

                        queue.remove(dist[destNode]);
                        dist[destNode].weight = weight;
                        queue.add(dist[destNode]);
                        parent[destNode] = srcNode;
                        }
                    }
                }
            }

        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }

    public static void main(String[] args) {
        PrimsAdjList graph = new PrimsAdjList(9);

        graph.addEdge( 0, 1, 4);
        graph.addEdge( 0, 7, 8);
        graph.addEdge( 1, 2, 8);
        graph.addEdge( 1, 7, 11);
        graph.addEdge( 2, 3, 7);
        graph.addEdge( 2, 8, 2);
        graph.addEdge( 2, 5, 4);
        graph.addEdge( 3, 4, 9);
        graph.addEdge( 3, 5, 14);
        graph.addEdge( 4, 5, 10);
        graph.addEdge( 5, 6, 2);
        graph.addEdge( 6, 7, 1);
        graph.addEdge( 6, 8, 6);
        graph.addEdge( 7, 8, 7);

        graph.primsMST();
    }
}
