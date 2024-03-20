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
        TreeNode current = root;
        TreeNode prev;
       while(current != null) {
       if(current.left != null) {
        prev = current.left;
        while(prev.right  != null) {
            prev = prev.right;
        }
        prev.right = current.right;
        current.right = current.left;
        current.left = null;
        }
       current = current.right;
       }   
    }
}