#include<bits/stdc++.h>
using namespace std;
int subsetSum(int arr[],int n,int sum){
	bool T[n+1][sum+1];
	for(int i=0;i<=n;i++){
		for(int j=0;j<=sum;j++){
			if(i==0 && j>0)
				T[i][j]=false;
			else if(j==0)
				T[i][j]=true;	
			else if(j<arr[i-1])
				T[i][j]=T[i-1][j];
			else T[i][j] = T[i-1][j-arr[i-1]] || T[i-1][j];			
		}
	}
	for(int i=0;i<=n;i++){
		for(int j=0;j<=sum;j++)
			cout<<T[i][j]<<" ";
		cout<<endl;	
	}
	return T[n][sum];
}
int main(){
	int n;
	cin >> n;
	int arr[n];
	for(int i=0;i<n;i++)
		cin >> arr[i];
	int sum;
	cin >> sum;
	subsetSum(arr,n,sum)?cout<<"Yes\n":cout<<"No\n";	
}
