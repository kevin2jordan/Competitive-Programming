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
void TopView(struct Node *root){
	if(root == NULL)
		return ;
	queue<pair<Node*,int> > q;
	q.push(make_pair(root,0));
	map<int,int> mp;
	while(!q.empty()){
		pair<Node*,int> p = q.front();
		q.pop();
		Node *temp = p.first;
		int hd = p.second;
		if(mp.find(hd) == mp.end()){
			mp[hd] = temp->data;
			cout<<temp->data<<" ";
		}
		if(temp->left)
			q.push(make_pair(temp->left,hd+1));
		if(temp->right)
			q.push(make_pair(temp->right,hd-1));	
	}	
}
int main(){
	struct Node *root = getNewNode(1);
	root->left = getNewNode(2);
	root->right = getNewNode(3);
	root->left->left = getNewNode(4);
	root->left->right = getNewNode(5);
	root->right->left = getNewNode(6);
	root->right->right = getNewNode(7);
	TopView(root);
}

