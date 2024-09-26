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
        helper(root);
    }
    
    private TreeNode helper(TreeNode node) {
        if(node == null){
            return null;
        }
        if(node.right==null && node.left==null){
            return node;
        }
        TreeNode left_ptr = helper(node.left);
        TreeNode right_ptr = helper(node.right);
        
        if(left_ptr!=null){
            left_ptr.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        
        if(right_ptr!=null) return right_ptr;
        
        return left_ptr;
    }
}

//Time complexity : O(N)
//Space complexity : O(N)
