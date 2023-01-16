// Approach: Traverse all the left nodes then all the right nodes while maintaining nodes leftTail
// and rightTail. Re-wire the connections as -
// 1. leftmost leaf will have its child as the parent's right child
// 2. new formed leftmost's subtree is copied to its right sibling
// 3. leftmost leaf is set to null
// 4. return the rightTail
// Time: O(n)
// Space: O(n)
class FlattenBinaryTree {
    public void flatten(TreeNode root) {
        this.flattenTree(root);
    }

    private TreeNode flattenTree(TreeNode node) {
        if (node == null) return null;

        if (node.left == null && node.right == null) return node;

        TreeNode leftTail = this.flattenTree(node.left);
        TreeNode rightTail = this.flattenTree(node.right);

        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        return rightTail == null ? leftTail : rightTail;
    }
}