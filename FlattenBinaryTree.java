// Time Complexity : O(n) --> where n is the number of nodes in the binary tree
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (114): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public void flatten(TreeNode root) {
        // base case
        if (root == null || (root.left == null && root.right == null)) return;
        // logic
        if (root.left != null) {
            flatten(root.left);
            TreeNode tempRight = root.right;
            root.right = root.left;
            root.left = null;
            while (root.right != null) root = root.right;
            root.right = tempRight;
        }
        flatten(root.right);
    }
}