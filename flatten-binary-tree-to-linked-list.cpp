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
    void helper(TreeNode* node) {
        //base
        if(node == nullptr || (node->left == nullptr && node->right == nullptr)) {
            return;
        }
        //logic
        helper(node->left);
        TreeNode* temp = node->right;
        node->right = node->left;
        node->left = nullptr;
        while(node->right != nullptr) {
            node = node->right;
        }
        node->right = temp;
        helper(node->right);
    }
    void flatten(TreeNode* root) {
        if(root == nullptr) return;
        
        helper(root);
    }
};
