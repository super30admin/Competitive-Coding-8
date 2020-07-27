// Time Complexity : O(n)
// Space Complexity : recursive - O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * 
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
    TreeNode tail;
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        helper(root);
    }
    
    private void helper(TreeNode root) {
        //base
        if(root == null) return;
        
        //logic
        
        if(tail != null) {
            tail.right = root;
            tail = null;
        }
        
        TreeNode right = root.right;
        TreeNode left = root.left;
        
        if(root.left != null){
           root.right = root.left; 
           root.left = null;
        }
        
        helper(left);
        helper(right);
        
        if(root.left == null && root.right == null) {
            tail = root;
        }
        
    }
    
    public void flattenIterative(TreeNode root) {
        //edge case
        if(root == null) return;
        
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            
            if(curr.right != null) {
                st.push(curr.right);
            }
            
            if(curr.left != null) {
                st.push(curr.left);
            }
            
            if(!st.isEmpty()){
                curr.right = st.peek();
            }
            
            curr.left = null;
        }
    }
}