/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode*temp=NULL;
    void flatten(TreeNode* root) {
        //base case
        if(root==NULL)
            return;
        recursion(root);
    }
    void recursion(TreeNode* root)
    {
        //base case
        if(root==NULL)
            return;
        recursion(root->right);
        recursion(root->left);
        root->left=NULL;
        root->right=temp;
        temp=root;
    }
};