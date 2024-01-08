#include<bits/stdc++.h>
using  namespace std;
vector<int> adj[100];
bool visited[100];
void bfs(int s)
{
	queue<int> Q;
	Q.push(s);
	visited[s]=true;
	while(!Q.empty())
	{
		int u  = Q.front();
		cout<<u<<endl;
		Q.pop();
		for(int i=0;i<adj[u].size();i++)
		{
			if(!visited[adj[u][i]])
			{
				Q.push(adj[u][i]);
				visited[adj[u][i]] = true;
			}
		}
	}
	
}
int main()
{
	int nodes,edges;
	cin>>nodes>>edges;
	for(int i=0;i<edges;i++)
	{
		int x,y,wt;
		cin>>x>>y;
		adj[x].push_back(y);
	}
	int src;
	cin>>src;
	bfs(src);
	
//4 6
//0 1
//0 2
//1 2
//2 0
//2 3
//3 3
//2
//output: 2 0 3 1
}
