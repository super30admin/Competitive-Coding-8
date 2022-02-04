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
// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// do to the leaf node, set the right to the leaf node, and then traverse the new right to the end and attach the old right to it.
// Your code here along with comments explaining your approach
class Solution {
    public void flatten(TreeNode root) {
        // null
        if( root == null || (root.left == null && root.right == null)) return;
        // logic
        flatten(root.left);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null){
            root = root.right;
        }
        root.right = temp;
        flatten(root.right);
    }

}