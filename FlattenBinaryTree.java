
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
class Solution {
    public void flatten(TreeNode root) {
        
        helper(root);
        
    }
    private TreeNode helper(TreeNode root)
    {
        if(root == null) return null;
        if(root.left == null && root.right == null ) return root;
        
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        
        if(left!=null)
        {
            left.right= root.right;
            root.right = root.left;
            root.left = null;
        }
        return right==null?left:right;
    }
}