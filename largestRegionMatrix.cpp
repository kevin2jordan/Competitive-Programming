#include<bits/stdc++.h>
using namespace std;
#define ROW 4
#define COL 5
bool isSafe(int M[][COL],int row, int col, bool visited[][COL]){
	return (row>=0 && row<ROW) && (col >=0 && col<COL)&&
			 (M[row][col] && !visited[row][col]);
}
void DFS(int M[][COL],int row,int col,bool visited[][COL],int &cntww){
	static int rowNbr[] = {-1,-1,-1,0,0,1,1,1};
	static int colNbr[] = {-1,0,1,-1,1,-1,0,1};
	visited[row][col] = true;
	for(int k=0;k<8;k++){
		if(isSafe(M,row+rowNbr[k],col+colNbr[k],visited))
			DFS(M,row+rowNbr[k],col+colNbr[k],visited);
	}
}
int largestRegion(int M[][COL]){
	bool visited[ROW][COL];
	int result = INT_MIN;
	memset(visited,0,sizeof(visited));
	int cnt=0;
	for(int i=0;i<ROW;i++){
		for(int j=0;j<COL;j++){
		
			if(M[i][j] && !visited[i][j]){
				int cnt=1;
				DFS(M,i,j,visited,cnt);
				result = max(result,cnt);
			}
				
		}
	}
	return result;
}
int main(){
	int arr[ROW][COL];
	for(int i=0;i<ROW;i++){
		for(int j=0;j<COL;j++)
			cin >> arr[i][j];
	}
	cout<<largestRegion(arr)<<endl;
}
