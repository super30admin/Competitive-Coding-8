public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        // flattenIterative(root);
        flattenRecursive(root);
    }

    // TC: O(N) where N is number of nodes
    // SC: O(H) where H is height of tree
    private void flattenRecursive(TreeNode root) {
        helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;

        TreeNode leftTail = helper(root.left);
        TreeNode rightTail = helper(root.right);

        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return rightTail == null ? leftTail : rightTail;
    }

    // TC: O(N) where N is number of nodes
    // SC: O(1)
    private void flattenIterative(TreeNode root) {
        while (root != null) {
            TreeNode curr = root.left;
            if (curr != null) {
                while (curr.right != null) {
                    curr = curr.right;
                }
                curr.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
