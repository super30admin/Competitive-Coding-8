// Time Complexity :
// Space Complexity :
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
        dfs(root);
    }
    
    public TreeNode dfs(TreeNode node){
        if(node==null){
            return null;
        }
        if(node.left==null && node.right==null){
            return node;
        }
        
        TreeNode left=dfs(node.left);
        TreeNode right=dfs(node.right);
        if(left!=null){
            left.right=node.right;
            node.right=node.left;
            node.left=null;
        }
        
        return right==null?left:right;
        
    }
}