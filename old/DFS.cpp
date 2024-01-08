#include<bits/stdc++.h>
using namespace std;
vector<int> *adj;
bool *visited;
void DFS(int src){
	visited[src] = true;
	cout<<src<<" ";
	for(int i=0;i<adj[src].size();i++){
		if(!visited[adj[src][i]])
			DFS(adj[src][i]);
	}
}
int main(){
	int nodes,edges;
	cin >> nodes >> edges;
	adj = new vector<int>[nodes+1];
	visited = new bool[nodes]+1;
	for(int i=0;i<=nodes;i++)
		visited[i] = false;
	for(int i=0;i<edges;i++){
		int x,y;
		cin >> x >> y;
		adj[x].push_back(y);
	//	adj[y].push_back(x);
	}
	DFS(2);	
//	for(int i=0;i<nodes;i++){
//		if(!visited[i])
//			DFS(i); 
//	}
}
