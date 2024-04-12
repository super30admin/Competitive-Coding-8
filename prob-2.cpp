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
    void flatten(TreeNode* root) {
        if(root == NULL) return;
        vector<TreeNode*> tree;
        preorder(root, tree);
        for(int i = 0; i < tree.size()-1; i++){
            tree[i]->left = NULL;
            tree[i]->right = tree[i+1];
        }
        return;
    }
    void preorder(TreeNode* root, vector<TreeNode*>& tree){
        if(root == NULL) return;
        tree.push_back(root);
        preorder(root->left, tree);
        preorder(root->right, tree);
    }
};
