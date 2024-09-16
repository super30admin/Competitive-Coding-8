//Time Complexity- O(n)
//Space Complexity- O(n)

class Solution {
public:
    void flatten(TreeNode* root) {
        
        helper(root,root);
    }
    
    void helper(TreeNode *&root,TreeNode *temp){
        
        if(temp==NULL){
            return;
        }
        TreeNode* left=temp->left;
        TreeNode* right=temp->right;
        if(root!=temp){
            root->right=temp;
            root->left=NULL;
            root=temp;
        }
        helper(root,left);
        helper(root,right);
    }
};