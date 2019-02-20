#include<bits/stdc++.h>
using namespace std;
void peakElement(int arr[], int n){
	if(arr[0]>arr[1])
		cout<<arr[0]<<" ";
	for(int i=1;i<n-1;i++){
	//	cout<<arr[i-1]<<" "<<arr[i]<<" "<<arr[i+1]<<endl;
		if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
			cout<<arr[i]<<" ";
		}
	}
	if(arr[n-1] > arr[n-2])
		cout<<arr[n-1]<<" ";
}
int findPeakElement(int arr[], int low, int high, int n){
	int mid  = low + (high-low)/2;
	if((mid == 0 || (arr[mid-1]<=arr[mid]) &&
	(mid == n-1) || (arr[mid+1] <= arr[mid])))
		return arr[mid];
		
	else if(mid > 0 && arr[mid-1] > arr[mid])	
		return findPeakElement(arr,low, mid-1, n);
	else return findPeakElement(arr,mid+1,high,n);	
}
int main(){
	int n;
	cin >> n;
	int arr[n];
	for(int i=0;i<n;i++)
		cin >> arr[i];	
	
	//cout<<peakElement(arr,n)<<endl;	
	cout<<findPeakElement(arr,0,n-1,n);	
}
