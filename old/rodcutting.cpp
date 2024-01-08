#include<bits/stdc++.h>
using namespace std;
int maxPrice(int price[], int n){
	
   int val[n+1]; 
   val[0] = 0; 
    for(int i=1;i<=n;i++)
    	val[i] = INT_MIN;
   for (int i = 1; i<=n; i++) 
   { 
       for (int j = 0; j < i; j++) 
         val[i] = max(val[i], price[j] + val[i-j-1]); 
   } 
  	for(int i=0;i<n;i++)
  		cout<<val[i]<<" ";
   return val[n]; 
}
int main(){
	int n;
	cin >> n;
	int arr[n];
	for(int i=0;i<n;i++)
		cin >> arr[i];
	cout<<maxPrice(arr,n)<<endl;	
}
