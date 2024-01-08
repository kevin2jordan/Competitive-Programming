#include<bits/stdc++.h>
using namespace std;
int minCoinChange(int coin[],int n, int sum){
	int T[n+1][sum+1];
	for(int i=0;i<=n;i++){
		for(int j=0;j<=sum;j++){
			if(i==0 && j>0)
				T[i][j] = INT_MAX;
			else if(j==0)
				T[i][j] = 0;
			else if(coin[i-1] > j)
				T[i][j] = T[i-1][j];
			else
				T[i][j] = min(T[i-1][j],1+T[i][j-coin[i-1]]);	
		}
	}
	for(int i=1;i<=n;i++){
		for(int j=0;j<=sum;j++)
			cout<<T[i][j]<<" ";
		cout<<endl;	
	}
	return T[n][sum];
}
int main(){
	int n;
	cin >> n;
	int coin[n];
	for(int i=0;i<n;i++)
		cin >> coin[i];
	sort(coin,coin+n);	
	int changes;
	cin >> changes;
	cout<<minCoinChange(coin,n,changes)<<endl;	
}

