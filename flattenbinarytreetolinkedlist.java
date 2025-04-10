// TC: O(n ^ 2)
// SC: O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;

        if (root.left != null) {
            flatten(root.left);
            TreeNode tempRight = root.right;
            root.right = root.left;
            root.left = null;
            while (root.right != null)
                root = root.right;
            root.right = tempRight;
        }
        flatten(root.right);
    }
}
