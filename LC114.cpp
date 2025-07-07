// Time complexity O(n)
// Space complexity O(h)

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
    TreeNode* cache = nullptr;

    void helper(TreeNode* node) {
        if (node == nullptr) return;

        helper(node->right);
        helper(node->left);

        node->right = cache;
        node->left = nullptr;
        cache = node;
    }

public:
    void flatten(TreeNode* root) {
        helper(root);
    }

};

