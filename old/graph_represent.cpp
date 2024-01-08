#include<bits/stdc++.h>
using namespace std;
int main()
{
	int nodes,edges;
	vector<int > *adj;
	cin>>nodes>>edges;
	adj = new vector<int >[nodes+1];
	for(int i=0;i<edges;i++)
	{
		int x,y,wt;
		cin>>x>>y;
		adj[x].push_back(y);
	
	}
	
	for(int i=1;i<=nodes;i++)
	{
		cout << "Adjacency list of node " << i << ": ";
		for(int j=0;j<adj[i].size();j++)
		{
			if(j==adj[i].size()-1)
			cout<<adj[i][j]<<endl;
			else cout<<adj[i][j]<<" ->";
		}
	}
	
}
