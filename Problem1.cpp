/* Problem Statement:

VERIFIED ON LEETCODE PLATFORM 
114. Flatten Binary Tree to Linked List
Medium

Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6

The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6



 * Solution 1: scan all the nodes in tree and
   Time Complexity : O(n), (worst case we have time complexity as O(2*n) as for each node we may need to traverse the subtree for that node as root again )
 * Space complexity :O(1)
 */

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
/*
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    
    void flatten(TreeNode* root) {
        TreeNode *temp_node = NULL;
        /* base condition, if we reach the end or we have a node whose left and right child are NULL */
        if (root == NULL || (root->left == NULL && root->right == NULL)) {
            return;
        }
        
        if (root->left != NULL) {
            /* Keep going to the left of the tree */
            flatten(root->left);
            
            /* Save the right subtree */
            temp_node = root->right;
            
            /* Connect right to the left subtree */
            root->right = root->left;
            
            /* Disconnect the left subtree */
            root->left = NULL;
            
            /* Now we know that the last node in the left subtree is going to be connected to the first node in the right subtree, hence
             * traverse the left subtree to get that node */
            while (root->right != NULL) {
                root = root->right;
            }
            /* Now safely connect it to the right subtree */
            root->right = temp_node;         
        }
        /* Once we reach to the left most, then we should start going the right way. hence its moving in LEFT RIGHT way*/
        flatten(root->right);
        
    }
};
/* Execute on leetcode platform */


