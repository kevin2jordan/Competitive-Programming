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
int sum(struct Node *root){
	if(root == NULL)
		return 0;
	return sum(root->left)+root->data+sum(root->right);	
}
bool sumTree(struct Node *root){
	if(root == NULL || (root->left == NULL && root->right == NULL))
		return true;
	int ls = sum(root->left);
	int rs = sum(root->right);
	return (root->data == ls+rs) && sumTree(root->left) && sumTree(root->right);	
}
int main(){
	struct Node *root = getNewNode(26);
	root->left = getNewNode(10);
	root->right = getNewNode(3);
	root->left->left = getNewNode(4);
	root->left->right = getNewNode(6);
	root->right->right = getNewNode(3);
	sumTree(root) ? cout<<"Yes\n" : cout<<"No\n";
	cout<<sum(root)<<endl;
}
