#include<bits/stdc++.h>
using namespace std;
int sqrtFloor(int n){
	int l = 1,r=n/2,ans=0;
	while(l<=r){
		int mid = l+(r-l)/2;
		if(mid*mid == n)
			return mid;
		else if(mid*mid < n){
			l = mid+1;
			ans = mid;
		}
		else r = mid-1;
				
	}
	return ans;
}
int main(){
	int t;
	cin >> t;
	while(t--){
	int n;
	cin >> n;
	cout<<sqrtFloor(n)<<endl;
}
return 0;
}
