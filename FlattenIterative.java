//Time Complexity: O(n)
//Space Complexity: O(n) due to stack frames
public class FlattenIterative {
    public void flatten(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return;

        if (root.left != null) {
            flatten(root.left);
            TreeNode tempright = root.right;
            root.right = root.left;
            root.left = null;
            while (root.right != null)
                root = root.right;
            root.right = tempright;
        }

        flatten(root.right);
    }
}

class FlattenRecursive {
    public void flatten(TreeNode root) {
        dfs(root);
    }

    private TreeNode dfs(TreeNode node) {
        if (node == null)
            return null;

        TreeNode leftTail = dfs(node.left);
        TreeNode rightTail = dfs(node.right);

        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        return rightTail != null ? rightTail : leftTail != null ? leftTail : node;
    }
}