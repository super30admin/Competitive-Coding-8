//time: O(n)
//space: O(h)

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
        if(root == NULL || (root -> left == NULL && root -> right == NULL)) return;
        stack<TreeNode*> stk;
        while(root -> left != NULL  || root -> right != NULL || !stk.empty()) {
            if(root -> left != NULL  && root -> right != NULL) {
                stk.push(root -> right); 
                root -> right = root -> left;
                root -> left = NULL;
                root = root -> right;
            }
            else if(root -> left == NULL  && root -> right == NULL) {
                TreeNode* rC = stk.top();
                stk.pop();
                root -> right = rC;
                root = root -> right;
            }
            else if(root -> left == NULL) root = root -> right;
            else if(root -> right == NULL) {
                root -> right = root -> left;
                root -> left = NULL;
                root = root -> right;
            }
        }    
    }
};