#include<bits/stdc++.h>
using namespace std;
bool isnumeric(char x){
	return x>='0' && x<='9';
}
int atoi(string str){
	int val=0;
	int sign = 1,i=0;
	if(str[i]=='-'){
		sign = -1;
		i++;
	}
		
	for(;i<str.length();i++){
		if(!isnumeric(str[i])){
			return 0;
		}
		val = val*10+str[i]-'0';
	}
	return sign*val;
}
int myAtoi(string str){
	int val = 0;
	int sign=1,i=0;
	while(str[i] == ' ')
		i++;
	if(str[i]=='-' || str[i]=='+')
		sign = 1-2*(str[i++]=='-');	
	while(str[i]>='0' && str[i] <= '9'){
		if(val > INT_MAX/10 || (val == INT_MAX && str[i]-'0'>7)){
			if(sign ==1)
				return INT_MAX;
			else return INT_MIN;
		}
		val = val*10+str[i++]-'0';
	}
	return sign*val;	
}
int main(){
	string str;
	cin >> str;
	cout<<atoi(str)<<endl;
	cout<<myAtoi(str)<<endl;
	return 0;
}
