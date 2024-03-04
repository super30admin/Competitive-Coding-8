// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

// Time: O(n)
// Space: O(h)

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
        if (root == null) return;
        TreeNode tmp = root.right;
        helper(root, tmp);
    }

    private void helper(TreeNode root, TreeNode tmp) {
        //base
        if(root == null ) return;

        //logic

        tmp = root.right;

        helper(root.left, tmp);

        // if(root.right != null) {
        // tmp = root.right;
        root.right = root.left;
        root.left = null;
        // }

        while(root.right != null) {
            root = root.right;
        }

        root.right = tmp;

        helper(root.right, tmp);
    }
}