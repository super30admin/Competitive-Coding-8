// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


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
    //To keep track of current and previous node
    TreeNode curr;
    TreeNode prev;
    public void flatten(TreeNode root) {
        //Recursive function
        dfs(root);
        //making all node.left = null and node.right = node.left
        curr = root;
        while(curr != null){
            curr.right = curr.left;
            curr.left = null;
            curr = curr.right;
        }
    }
    //Pre order traversal and storing the order by using root.left
    private void dfs(TreeNode root){
        if(root == null) return;

        prev = curr;
        curr = root;
        if(prev != null) prev.left = curr;
        dfs(root.left);
        dfs(root.right);
        
    }
}