// Time Complexity : O(n) number of elements in BT
// Space Complexity : O(h) height of BT for recursive calls stack
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

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
        if(root == null) return;
        TreeNode temp = null;
        flatten(root.left);
        if(root.right == null) {
            root.right = root.left;
            root.left = null;
        } else {
            temp = root.right;
            root.right = root.left;
            root.left = null;
            while(root.right != null){
                root = root.right;
            }
            root.right = temp;
        }

        if(root.left == null && root.right != null) {
            flatten(root.right);
        }
    }
}