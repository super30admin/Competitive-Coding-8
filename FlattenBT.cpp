#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
struct TreeNode{
    public:
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};
/*
We recursively flatten the right and left subtrees first, working in postorder.
Then, we set the current node's right to the last visited node (prev) and nullify the left.
Finally, we move prev to the current node so the chain builds backward.
*/
class Solution{
    TreeNode* prev = nullptr;
public:
    void flattenBT(TreeNode* root){
        if(root == nullptr) return;

        flattenBT(root->right);
        flattenBT(root->left);

        root->right = prev;
        root->left = nullptr;
        prev = root;
    }
};
