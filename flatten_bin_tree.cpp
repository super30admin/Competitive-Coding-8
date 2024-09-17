//TC: O(N)
//SC: O(N)

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
        
        if(root == NULL){
            return;
        }
        
        stack<TreeNode*> s;
        
        s.push(root);
        
        while(!s.empty()){
            TreeNode* curr = s.top();
            s.pop();
            
            if(curr->right!=NULL){
                s.push(curr->right);
            }
            
            if(curr->left!=NULL){
                s.push(curr->left);
            }
            
            curr->left = NULL;
            
            if(!s.empty()){
                curr->right = s.top();
            } else {
                curr->right = NULL;
            }
            
        }
        
        return;
        
        
    }
};