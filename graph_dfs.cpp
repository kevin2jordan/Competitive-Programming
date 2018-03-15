#include<bits/stdc++.h>
using namespace std;
vector<int> *adj;
bool *visited;
void dfs(int src)
{
	visited[src]=true;
	cout<<src<<endl;
	for(int i=0;i<adj[src].size();i++)
	if(!visited[adj[src][i]])
		dfs(adj[src][i]);
}
int main()
{
	int nodes,edges;
	cin>>nodes>>edges;
	adj = new vector<int>[nodes+1];
	visited = new bool[nodes+1];
	for(int i=0;i<edges;i++)
	{
		int x,y,wt;
		cin>>x>>y;
		adj[x].push_back(y);
	}
	int src;
	cin>>src;
	dfs(src);
	
//input	
//4 6
//0 1
//0 2
//1 2
//2 0
//2 3
//3 3
//2
//output : 2 0 1 3
}
