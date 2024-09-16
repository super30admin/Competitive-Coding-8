
// Time Complexity : O(n) n = number of nodes in tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :none


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
    List<TreeNode> tree;
    
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        tree = new LinkedList<>();
        dfs(root);
        
        TreeNode head = new TreeNode(-1);
        TreeNode curr = head;
        
        for(TreeNode node : tree){
            curr.right = node;
            curr.left = null;
            curr = node;
        }
        
    }
    
    private void dfs(TreeNode root){
        if(root == null) return;
        
        tree.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}