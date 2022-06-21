
// Time Complexity :O(H)
// Space Complexity : O(N)
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
    
    ArrayList<Integer> result = new ArrayList<>();
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        helper(root);
        TreeNode temp =  root;
        for(int i=1;i<result.size();i++){
            temp.right = new TreeNode(result.get(i));
            temp.left = null;
            temp = temp.right;
        }
    }
    
    private void helper(TreeNode root){
        if(root==null){
            return;
        }
        result.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}