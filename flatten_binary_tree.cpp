// Time Complexity : O(2n) // Two time traversal
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
//Understanding how to continue the tree was a bit difficult
// Your code here along with comments explaining your approach
//1. Do inorder traversal and reach the first left node which is has ***(left node)*** as null. Make this as your appending node. Till here mark all the previous nodes as visited by using a flag.
//2. Now add all the next nodes in the inorder traversal to the appending node and change the appending node.
//3. Travesrse through the constructed tree to delete all the right elements 
//4. Place all the left elements to the right.


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
    TreeNode* prev=NULL;
    void flatten(TreeNode* root) {
        //edge
        if(root == NULL) return;
        
        //logic
        inorder(root,0);
        
        //go through the structure once again to correct the tree
        TreeNode* curr = root; TreeNode*  next = root->left;
        while(next!=NULL){
            curr->right=next;
            curr->left=NULL;
            curr=curr->right;
            next=next->left;
        }
    }
    
     TreeNode* inorder(TreeNode*  root, bool visited){
        //return condition
        if(root==NULL) return NULL;
        
        //logic
         if(prev==NULL) visited = true;
         if(prev!=NULL && visited==false) {
             prev->left=root;
             prev=prev->left;
         }
         
         TreeNode* left = inorder(root->left, false);
         if(left==NULL && prev==NULL) prev=root;
         TreeNode* right = inorder(root->right, false);
         
         return left;
    }
    
};
