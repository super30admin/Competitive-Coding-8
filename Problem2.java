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

//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    TreeNode prev;
    public void flatten(TreeNode root) {
        prev = null;
        driver(root);
    }

    public void driver(TreeNode root){
        if(root!=null){
            driver(root.right);
            driver(root.left);
            helper(root);
        }
    }

    public void helper(TreeNode node){
        node.right = prev;
        node.left = null;
        prev = node;
    }
}