// Time Complexity : O(n); n = #nodes
// Space Complexity : O(n); recursion stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class FlattenBinarytreeLinkedList {
    public void flatten(TreeNode root) {
        helper(root);
    }
    private TreeNode helper(TreeNode root) {
        //edge case
        if (root == null) return null;

        //base case
        if (root.left == null && root.right == null) return root;

        //logic

        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);

        if (left != null) {
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        if (right != null) return right;
        else return left;
    }
}