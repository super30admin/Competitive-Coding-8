/*
    LC - 114. Flatten Binary Tree to Linked List
    TC - O(n)
    SC - O(h)
    Approach -
        Using bottom up
        recurse to left most sub tree and flatten it recursively 
        and then recursse through right
*/

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
        if(root == null) {
            return;
        }
        dfs(root);
    }
    public TreeNode dfs(TreeNode root) {
        // base
        if(root == null) {
            return null;
        }
        
        if(root.left == null && root.right == null) {
            return root;
        }

        // logic
        TreeNode temp = root.right;
        TreeNode left = dfs(root.left);
        
        if(left != null) {
            root.right = root.left;
            root.left = null;
            left.right = temp;
        }

        TreeNode right = dfs(root.right);
        
        if (right != null) {
            return right;
        }
        if (left != null) {
            return left;
        }

        return root;
    }
}