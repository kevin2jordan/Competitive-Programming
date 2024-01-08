#include<bits/stdc++.h>
using namespace std;
int tiling(int n){
	int cnt=0;
	if(n<=2)
		return n;
	int a=1,b=2;
	for(int i=3;i<=n;i++){
		cnt = a+b;
		a = b;
		b = cnt;
	}	
	return cnt;
}
int main(){
	int t;
	cin >> t;
	while(t--){
	
	int n;
	cin >> n;
	cout<<tiling(n)<<endl;
	
}
return 0;
}
