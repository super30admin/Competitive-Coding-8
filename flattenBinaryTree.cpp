/*
First flatten the left subtree and then attach it to the right subtree
Make a temp vairable to store the right subtree.

///////////////////////////////////////////
Time Complexity : O(N), Total number of nodes
Space Complexity : O(H), Height of the tree
///////////////////////////////////////////

*/
class Solution {
public:
    void flatten(TreeNode* root) {
        
        if ( root == NULL or (root->left == NULL and root->right == NULL) ) return;
        
            
        //recurse
        if ( root->left != NULL){
            flatten(root->left);
            TreeNode* temp = root->right;
            root->right = root->left;
            root->left = NULL;
            while ( root->right != NULL) root = root->right;
            root->right = temp;
        }
        flatten(root->right);
    }
};