/*
 * Time complexity: O(n)
 * Space complexity: O(n)
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

 class Node {
    int val;
    Node next;
    public void node(int val) {
        this.val = val;
    }
}

class Solution {
    public void flatten(TreeNode root) {
        //base
        if(root == null || root.left == null && root.right == null) {
            return;
        }

        //logic
        if (root.left != null) {
            flatten(root.left);
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            while(root.right != null) root = root.right;
            root.right = temp;
        }
        flatten(root.right);
    }
}