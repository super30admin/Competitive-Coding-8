// In this problem, using two pointers prev and curr initially set to null and root of the tree respectively. Then at each call, 
// checking if curr is null then returning, else if prev is not null, then setting the prev.right to curr and prev.left to null.
// Then storing the curr.right in temp variable, and moving prev pointer to curr. Then making recursive call with curr.left and
// then recursive call with curr.right which was stored in temp variable.

// Time Complexity : O(n) n is the number of nodes
// Space Complexity : O(h) recursive stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    TreeNode prev;

    public void flatten(TreeNode root) {
        // Base case
        if (root == null) {
            return;
        }
        // Recursive call
        preorder(root);
    }

    private void preorder(TreeNode curr) {
        // Base
        if (curr == null) {
            return;
        }
        // Check if prev is not null, set it's left and right pointer correctly
        if (prev != null) {
            prev.left = null;
            prev.right = curr;
        }
        // Then store the right node of curr pointer bcoz we are moving our prev pointer
        // to curr and in next call we are updating prev pointer's left and right.
        TreeNode r = curr.right;
        // Move the pointer
        prev = curr;
        // Move the curr to curr.left and make a call
        preorder(curr.left);
        // Then make a right recursive call
        preorder(r);
    }
}