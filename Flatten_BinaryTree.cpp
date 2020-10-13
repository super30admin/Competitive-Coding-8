// Time Complexity : O(n) for the traversal on tree 
// Space Complexity : O(n) for the recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning

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
        
        //base case
        //if(root == NULL) return root;
        
        recursion(root);
        
        
    }
    
    void recursion(TreeNode* root){
        
        if(root == NULL) return;
        //if(root->left == NULL && root-> right == NULL){
         //   return ;
       // }
        
           
           
        
            recursion(root->left);
        
            recursion(root->right);

            TreeNode* temp = root->right;
            
            root->right = root->left;
        
      
        
            TreeNode* temp3 = root;

            while(temp3->right!=NULL){
                temp3 = temp3->right;
            }
        
            temp3->right = temp;
            root->left = NULL;
                
        
      
           
    
        
        
    }
};
