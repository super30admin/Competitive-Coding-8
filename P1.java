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

//o(n)-time
//o(h)-space

class Solution {
    public void flatten(TreeNode root) {
        //edge
        if(root==null) return;
        
        //preorder
        helper(root);
        
    }
    
    public TreeNode helper(TreeNode root)
    {
        if(root==null) return null;
        
        if(root.left==null && root.right==null) return root;
        //recursion
        
        TreeNode bottomLeft = helper(root.left);
        TreeNode bottomRight = helper(root.right);
        
        if(bottomLeft!=null)
        {
            bottomLeft.right = root.right;   
            root.right = root.left;
            root.left=null;
        }

        if(bottomRight==null)
        {
            return bottomLeft;
        }
        
        return bottomRight;       
        
    }
}