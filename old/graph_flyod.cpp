#include<bits/stdc++.h>
using namespace std;
#define INF 99999
#define V 4
void flyod(int graph[V][V])
{
	int dist[V][V];
	for(int i=0;i<V;i++)
	{
		for(int j=0;j<V;j++)
		dist[i][j] = graph[i][j];
	}
	for(int k=0;k<V;k++)
	{
		for(int i=0;i<V;i++)
		{
			for(int j=0;j<V;j++)
			{
				if(dist[i][k] + dist[k][j] < dist[i][j])
				dist[i][j] = dist[i][k] + dist[k][j];
			}
		}
	}
	for(int i=0;i<V;i++)
	{
		for(int j=0;j<V;j++)
		{
			if (dist[i][j] == INF)
                printf("%7s", "INF");
            else
                printf ("%7d", dist[i][j]);
		}
		printf("\n");
	}
}
int main()
{
	
	//cin>>V;
//	int graph[V][V];
//	for(int i=0;i<V;i++)
//	{
//		for(int j=0;j<V;j++)
//		cin>>graph[i][j];
//	}
int graph[V][V] = { {0,   5,  INF, 10},
                        {INF, 0,   3, INF},
                        {INF, INF, 0,   1},
                        {INF, INF, INF, 0}
                      };
	flyod(graph);
}
