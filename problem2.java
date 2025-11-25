
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : the recusion logic is still fuzzy

class Solution {
    public void flatten(TreeNode root) {
        helper(root);

    }

    private TreeNode helper(TreeNode root) {
        if (root == null)
            return root;

        TreeNode leftTail = helper(root.left);
        TreeNode rightTail = helper(root.right);

        if (root.left != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (rightTail != null) {
            return rightTail;
        }
        if (leftTail != null) {
            return leftTail;
        }
        if (root != null) {
            return root;
        }
        return null;
    }
}