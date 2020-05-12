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
// Time COmplexity: O(n)
// Space Complexity: O(max depth of tree)
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        helper(root); //1
    }

    private void helper(TreeNode root) {
        if(root == null) {
            return;
        }

        if(root.left != null) {
            helper(root.left); //3
        }
        // root = 2
        TreeNode temp = root.right;  // 4
        root.right = root.left; // 2 - 3 - 4
        root.left = null;

        while(root.right != null) { // 4
            root = root.right;
        }
        root.right = temp;

        helper(root.right);

    }
}