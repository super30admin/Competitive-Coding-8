// Time Complexity : O(n) number of nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/*
 * we traverse in preorder traversal technique and then at every root, 
 * we make the leftmost child'd right to root's right
 * then root's right to root's left
 * root's left to null
 * in the end, if rightMost child is present we return right, else leftEnd.
 */


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
        if(root == null ) return;
        helper(root);
    }

    private TreeNode helper(TreeNode root){
        if(root == null) return root;
        if(root.left == null && root.right == null ) return root;
        
        TreeNode leftEnd = helper(root.left);
        TreeNode rightEnd = helper(root.right);
        
        if(leftEnd != null){
            //leftend 
            leftEnd.right = root.right;
            root.right = root.left;
            root.left = null;
        } 
        
        return rightEnd == null? leftEnd : rightEnd;
        
    }
}