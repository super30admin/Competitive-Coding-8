// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private TreeNode prev;

    public void flatten(TreeNode root) {
        preorder(root);
    }

    private void preorder(TreeNode root) {
        if (root == null)
            return;
        preorder(root.right);
        preorder(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}