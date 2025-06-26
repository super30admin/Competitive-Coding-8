// Time: O(n), Space: O(1)
public class FlattenBinaryTree {

    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }

                prev.right = curr.right;

                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
}
