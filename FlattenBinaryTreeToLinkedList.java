// Time Complexity: O(n)
// Space Complexity: O(1)

public class FlattenBinaryTreeToLinkedList {

    // Definition for a binary tree node.
    public static class TreeNode {
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

    static class Solution {
        public void flatten(TreeNode root) {
            // base case
            if (root == null || root.left == null && root.right == null)
                return;
            // recursive case
            if (root.left != null) {
                flatten(root.left);
                TreeNode Tempright = root.right;
                root.right = root.left;
                root.left = null;
                while (root.right != null) {
                    root = root.right;

                }
                root.right = Tempright;

            }
            flatten(root.right);

        }
    }
}
