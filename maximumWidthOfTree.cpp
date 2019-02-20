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
int maximumWidth(struct Node *root){
	if(root == NULL)
		return 0;
	queue<Node*> q;
	q.push(root);
	int result = 0;
	while(!q.empty()){
		
		int cnt = q.size();
		result = max(cnt,result);
		while(cnt--){
			Node *temp = q.front();
			q.pop();
			if(temp->left)
				q.push(temp->left);
			if(temp->right)
				q.push(temp->right);	
		}
	}	
	return result;
}
int main(){
	struct Node *root = getNewNode(1);
	root->left = getNewNode(2);
	root->right = getNewNode(3);
	root->left->left = getNewNode(4);
	root->left->right = getNewNode(5);
	root->right->left = getNewNode(6);
	root->right->right = getNewNode(7);
	cout<<maximumWidth(root)<<endl;
}
