#include<bits/stdc++.h>
using namespace std;
int minJump(int arr[],int n){
	int temp[n];
	for(int i=0;i<n;i++)
		temp[i] = INT_MAX;
	temp[0] = 0;
	for(int i=1;i<n;i++){
		for(int j=0;j<i;j++){
			if(j+arr[j] >= i ){
				temp[i] = min(temp[i],temp[j]+1);
			}
		}
	}	
	for(int i=0;i<n;i++)
		cout<<temp[i]<<" ";
	return temp[n-1];	
}
int main(){
	int n;
	cin >> n;
	int arr[n];
	for(int i=0;i<n;i++)
		cin >> arr[i];
	cout<<minJump(arr,n)<<endl;	
}
