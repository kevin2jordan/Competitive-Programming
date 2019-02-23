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
void addGreaterValueToEveryNode(struct Node *root, int &sum){
	if(root == NULL)
		return;
	addGreaterValueToEveryNode(root->right,sum);
	sum +=root->data;
	root->data = sum;	
	addGreaterValueToEveryNode(root->left,sum);	
		
}
void inorder(struct Node *root){
	if(root == NULL)
		return;
	inorder(root->left);
		cout<<root->data<<" ";
	inorder(root->right);		
}
int main(){
	struct Node *root = getNewNode(50);
	root->left = getNewNode(30);
	root->right = getNewNode(70);
	root->left->left = getNewNode(20);
	root->left->right = getNewNode(40);
	root->right->left = getNewNode(60);
	root->right->right = getNewNode(80);
	cout<<"Before modifying tree \n";
	inorder(root);
	int sum=0;
	addGreaterValueToEveryNode(root,sum);
	cout<<"\n After modifying tree \n";
	inorder(root);
}
