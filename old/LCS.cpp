#include<bits/stdc++.h>
using namespace std;
int LCS(string str1, string str2){
	int n = str1.length();
	int m = str2.length();
	int T[n+1][m+1];
	for(int i=0;i<=n;i++){
		for(int j=0;j<=m;j++){
			if(i==0 || j==0)
				T[i][j]=0;
			else if(str1[i-1] == str2[j-1])
				T[i][j] = T[i-1][j-1]+1;
			else T[i][j] = max(T[i-1][j],T[i][j-1]);		
		}
	}
//	for(int i=0;i<=n;i++){
//		for(int j=0;j<=m;j++)
//			cout<<T[i][j]<<" ";
//		cout<<endl;	
//	}
	return T[n][m];
}
int main(){
	string str1,str2;
	cin >> str1 >> str2;
	cout<<LCS(str1,str2)<<endl;
}
