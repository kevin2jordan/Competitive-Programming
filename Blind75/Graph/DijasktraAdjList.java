package Blind75.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijasktraAdjList {

    static class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    private static List<Edge>[] adjList;
    private static int  V;

    DijasktraAdjList(int v) {
        V = v;
        adjList = new ArrayList[V];
        for(int i=0;i<V;i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v, int w) {
        adjList[u].add(new Edge(v,w));
    }

    public static int[] dijasktraAlgo(int src) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        PriorityQueue<Edge> queue = new PriorityQueue<>((Edge a, Edge b) -> a.weight - b.weight);
        queue.add(new Edge(src, 0));

        while(!queue.isEmpty()) {

            int u = queue.poll().dest;

            for(Edge node : adjList[u]) {
                int v = node.dest;
                int w = node.weight;
                if(distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                    queue.add(new Edge(v, distance[v]));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        DijasktraAdjList graph = new DijasktraAdjList(9);
        graph.addEdge(0,1,4);
        graph.addEdge(0,7,8);
        graph.addEdge(1,2,8);
        graph.addEdge(1,7,11);
        graph.addEdge(1,0,7);
        graph.addEdge(2,1,8);
        graph.addEdge(2,3,7);
        graph.addEdge(2,8,2);
        graph.addEdge(2,5,4);
        graph.addEdge(3,2,7);
        graph.addEdge(3,4,9);
        graph.addEdge(3,5,14);
        graph.addEdge(4,3,9);
        graph.addEdge(4,5,10);
        graph.addEdge(5,4,10);
        graph.addEdge(5,6,2);
        graph.addEdge(6,5,2);
        graph.addEdge(6,7,1);
        graph.addEdge(6,8,6);
        graph.addEdge(7,0,8);
        graph.addEdge(7,1,11);
        graph.addEdge(7,6,1);
        graph.addEdge(7,8,7);
        graph.addEdge(8,2,2);
        graph.addEdge(8,6,6);
        graph.addEdge(8,7,1);

        int[] dist = dijasktraAlgo(0);

        for(int i=0;i<V;i++) {
            System.out.println(i + "  " + dist[i]);
        }
    }
}
