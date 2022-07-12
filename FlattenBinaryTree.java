// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public void flatten(TreeNode root) {
        // edge case
        if (root == null || root.left == null && root.right == null)
            return;
        // check if left is null
        if (root.left != null) {
            // flatten left tree
            flatten(root.left);
            // store right node
            TreeNode temp = root.right;
            // make flattened left as right
            root.right = root.left;
            // and left null
            root.left = null;
            // go to last element from left flattened tree
            while (root.right != null) {
                root = root.right;
            }
            // and add stored right to its right
            root.right = temp;

        }
        // at last flatten right subtree
        flatten(root.right);
    }
}