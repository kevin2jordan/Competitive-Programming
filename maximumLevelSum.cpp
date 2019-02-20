#include<bits/stdc++.h>
using namespace std;
struct Node{
	int data;
	Node *left;
	Node *right;
};
struct Node *getNewNode(int data){
	struct Node *temp = (Node*)malloc(sizeof(Node));
	temp->data = data;
	temp->left = NULL;
	temp->right = NULL;
	return temp;
}
void maxLevelSum(struct Node *root){
	if(root == NULL)
		return;
	queue<Node*> q;
	q.push(root);
	int result = root->data;
	int sum=0;
	while(!q.empty()){
		int cnt = q.size();
		int sum=0;
		while(cnt--){
			Node *temp = q.front();
			q.pop();
			sum+=temp->data;
			if(temp->left)
				q.push(temp->left);
			if(temp->right)
				q.push(temp->right);
	}
	result = max(result,sum);
		
	}
	cout<<"Result ki val "<<result<<endl;	
}
int main(){
	struct Node *root = getNewNode(4);
	root->left = getNewNode(2);
	root->right = getNewNode(-5);
	root->left->left = getNewNode(-1);
	root->left->right = getNewNode(3);
	root->right->left = getNewNode(-2);
	root->right->right = getNewNode(6);
	maxLevelSum(root);
}
