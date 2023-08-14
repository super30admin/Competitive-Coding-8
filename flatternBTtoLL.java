// Time Complexity : O(N) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

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
class Solution {
    public void flatten(TreeNode root) {
        //base
        if(root == null || root.left == null && root.right == null)return;
        //recursive case
        if(root.left != null){
            flatten(root.left);
            TreeNode tempright = root.right;
            root.right = root.left;
            root.left = null;
            while(root.right != null) root = root.right;
            root.right = tempright;
        }
        flatten(root.right);
    }
}