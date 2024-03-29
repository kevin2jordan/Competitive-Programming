package Blind75.Graph;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Comparator;

public class prims {
	class Edge {

		int dest, weight;

		Edge(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
	}

	private int V;
	private LinkedList<Edge>[] adj;

	prims(int e) {
			V = e;
			adj = new LinkedList[V];
			for (int i = 0; i < V; i++)
				adj[i] = new LinkedList<>();
		}
	

	void addEdge(int src, int dest, int weight)
	{
		adj[src].add(new Edge(dest, weight));
		adj[dest].add(new Edge(src, weight));
	}

	void prims_mst()
	{

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

			Edge node0 = queue.pollFirst();

			mstset[node0.dest] = true;

			for (Edge iterator : adj[node0.dest]) {

				if (!mstset[iterator.dest]) {

					if (dist[iterator.dest].weight > iterator.weight) {

						queue.remove(dist[iterator.dest]);
						dist[iterator.dest].weight = iterator.weight;

						queue.add(dist[iterator.dest]);
						parent[iterator.dest] = node0.dest;
					}
				}
			}
		}

		for (int i = 1; i < V; i++)
			System.out.println(parent[i] + " - " + i);
	}

	public static void main(String[] args)
	{
		prims graph = new prims(9);

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

		graph.prims_mst();
	}
}
