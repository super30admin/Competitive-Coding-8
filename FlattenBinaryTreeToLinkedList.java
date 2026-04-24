// O(n) time, O(h) space
class Solution {
    public void flatten(TreeNode root) {
        helper(root);
    }
    private void helper(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = left;
        root.left = null;

        helper(left);

        while (root.right != null) {
            root = root.right;
        }
        root.right = right;
        
        helper(right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
