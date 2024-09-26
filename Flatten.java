// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // We recursively flatten the left subtree
 // We do the following:
 // TreeNode temp = root.right
 // root.right = root.left
 // root.left = null
 // then we attach temp to the tail edge of root.right
 // We recursively flatten right subtree


class Solution {
    public void flatten(TreeNode root) {
        
        if(root == null || root.left == null && root.right == null) return;
        
        if(root.left != null) {
            
            flatten(root.left);
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            while (root.right != null) {
                root = root.right;
            }
            root.right = temp;
        }
        flatten(root.right);
        
    }
}