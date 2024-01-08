#include<bits/stdc++.h>
using namespace std;
int kadane(int arr[],int n){
	int temp = arr[0];
	int res = arr[0];
	for(int i=1;i<n;i++){
		temp = max(arr[i],arr[i]+temp);
		res = max(res,temp);
	}
	return res;
}
int main(){
	int n;
	cin >> n;
	int arr[n];
	for(int i=0;i<n;i++)
		cin >> arr[i];
	cout<<kadane(arr,n)<<endl;	
}
