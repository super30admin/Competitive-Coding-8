// Time Complexity : O(n) will visit all nodes once
// Space Complexity : O(h) height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Recursively call flatten for left subtree. Store right subtree address in temp
// 2. Make right of root equal to flattened left subtree and make left subtree as nullptr
// 3. Go to end of added flattened tree and place the right subtree
// 4. Flatten the right subtree  

class Solution {
public:
    void flatten(TreeNode* root) {
        // base
        if(root==nullptr || (root->left==nullptr && root->right==nullptr))
            return;
        // logic
        flatten(root->left);
        TreeNode* temp = root->right;
        root->right = root->left;
        root->left = nullptr;
        while(root->right != nullptr)
            root = root->right;
        root->right = temp;
        flatten(root->right);
    }
};