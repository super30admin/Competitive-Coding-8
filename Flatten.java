public class Flatten {
    // TC O(N)
    // SC O(N)
    public class TreeNode {
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

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root);
    }

    private TreeNode helper(TreeNode curr) {
        if (curr == null) {
            return null;
        }
        if (curr.left == null && curr.right == null) {
            return curr;
        }

        TreeNode leftT = helper(curr.left);
        TreeNode rightT = helper(curr.right);
        if (leftT != null) {
            leftT.right = curr.right;
            curr.right = curr.left;
            curr.left = null;
        }

        return rightT == null ? leftT : rightT;
    }
}
