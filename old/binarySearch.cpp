#include<bits/stdc++.h>
using namespace std;
int binarySearch(int arr[], int n, int key){
	int low = 0;
	int high = n;
	int mid;
	while(low < high){
		mid = low + (high-low)/2;
		if(arr[mid] == key)
			return mid;
		else if(arr[mid] < key){
			low = mid+1;
		}else high = mid-1;	
	}
	return mid+1;
}
int main(){
	int n;
	cin >> n;
	int arr[n];
	for(int i=0;i<n;i++)
		cin >> arr[i];
	int key;
	cin >> key;
	cout<<binarySearch(arr,n,key)<<endl;
}
