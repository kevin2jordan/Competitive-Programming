#include<bits/stdc++.h>
using namespace std;
#define pi pair<int,int>
vector<pi>  *adj;
void dijasktra(int src,int V)
{
	priority_queue<pi,vector<pi>,greater<pi> >Q;
	Q.push(make_pair(0,src));
	vector<int> dist(V,INT_MAX);
	dist[src]=0;
	while(!Q.empty())
	{
		int u=Q.top().second;
		Q.pop();
		for(int i=0;i<adj[u].size();i++)
		{
			int y = adj[u][i].first;
			int w = adj[u][i].second;
			if(dist[y]>dist[u]+w)
			{
				dist[y]  = dist[u] + w;
				Q.push(make_pair(dist[y],y));
			}
		}
	}
	
	for(int i=0;i<V;i++)
	cout<<i<<"   "<<dist[i]<<endl;
}
int main()
{
	int nodes,edges;
	cin>>nodes>>edges;
	adj = new vector<pi>[nodes+1];
	for(int i=0;i<edges;i++)
	{
		int x,y,wt;
		cin>>x>>y>>wt;
		adj[x].push_back(make_pair(y,wt));
		adj[y].push_back(make_pair(x,wt));
	}
	int src;
	cin>>src;
	dijasktra(src,nodes);
}
