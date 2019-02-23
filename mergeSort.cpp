#include<bits/stdc++.h>
using namespace std;
void merge(int arr[], int low, int mid, int high){
	int nL = mid-low + 1;
	int nR = high-mid;
	int left[nL];
	int right[nR];
	for(int i=0;i<nL;i++)
		left[i] = arr[i+low];
	for(int j=0;j<nR;j++)
		right[j] = arr[j+mid+1];
	int i=0,j=0,k=low;
	while(i<nL && j<nR){
		if(left[i] <= right[j]){
			arr[k] = left[i];
			i++;
		}else{
			arr[k] = right[j];
			j++;
		}
		k++;
	}	
	while(i<nL){
		arr[k] = left[i];
		i++;
		k++;
	}
	while(j<nL){
		arr[k] = right[j];
		j++;
		k++;
	}
			
}
void mergeSort(int arr[], int low, int high){
	if(low < high){
		int mid  = low + (high-low)/2;
		mergeSort(arr,low,mid);
		mergeSort(arr,mid+1,high);
		merge(arr,low,mid,high);
	}
}
int main(){
	int n;
	cin >> n;
	int arr[n];
	for(int i=0;i<n;i++)
		cin >> arr[i];
	mergeSort(arr,0,n-1);
	for(int i=0;i<n;i++)
	cout<<arr[i]<<" ";
	cout<<endl;	
}
