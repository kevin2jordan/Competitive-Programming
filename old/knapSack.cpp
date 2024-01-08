#include<bits/stdc++.h>
using namespace std;
int knapSack(int wt[], int val[], int n, int W){
	int T[n+1][W+1];
	for(int i=0;i<=n;i++){
		for(int j=0;j<=W;j++){
			if(i==0 || j==0)
				T[i][j]=0;
			else if(wt[i-1] <= j){
				T[i][j] = max(T[i-1][j],T[i-1][j-wt[i-1]]+val[i-1]);
			//	cout<<wt[i-1]<<" "<<i<<" "<<j<<endl;
			}
				
			else T[i][j] = T[i-1][j];		
		}
	}
//	for(int i=0;i<=n;i++){
//		for(int j=0;j<=W;j++)
//			cout<<T[i][j]<<" ";
//		cout<<endl;
//	}
	return T[n][W];
}
int main(){
	int n;
	cin >> n;
	int wt[n];
	int val[n];
	for(int i=0;i<n;i++){
		cin >> wt[i];
	}
	for(int i=0;i<n;i++){
		cin >> val[i];
	}
	int totalWeight;
	cin >>totalWeight;
	cout<<knapSack(wt,val,n,totalWeight)<<endl;
}
