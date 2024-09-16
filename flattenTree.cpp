// Time Complexity :O(n) n is the number of nodes in the tree
// Space Complexity : O(logn)   
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        helper(root);
        return;
    }
    void helper(TreeNode* root){
        //base
        if (!root) return;
        //logic
        flatten(root->left);
        if (root->left) {
            TreeNode* curr = root->right;
            root->right = root->left;
            root->left = NULL;
            while (root->right) root = root->right;
            root->right = curr;
        }
        flatten(root->right);
    }
};