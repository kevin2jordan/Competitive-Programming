#include<bits/stdc++.h>
using namespace std;
int findPlatform(int arr[], int dept[], int n){
	sort(arr,arr+n);
	sort(dept,dept+n);
	int i=1,j=0;
	int platform=1,temp=1;
	while(i < n && j < n){
		if(arr[i] <= dept[j]){
			temp++;
			i++;
			platform = max(temp,platform);
		}else{
			temp--;
			j++;
		}
		
	}
	return platform;
}
int main(){
	int n;
	cin >> n;
	int arr[n];
	for(int i=0;i<n;i++)
		cin >> arr[i];
	int dept[n];
	for(int i=0;i<n;i++)
		cin >> dept[i];
	cout<<findPlatform(arr,dept,n);		
}
