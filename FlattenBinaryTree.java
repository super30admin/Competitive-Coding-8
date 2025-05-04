import java.util.Stack;

//Approach - 1 : Recursive
public class FlattenBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public void flatten(TreeNode root) {
        if (root == null)
            return;

        helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return root;

        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);

        if (left != null) {
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        return right != null ? right : left;
    }
}

//TC: O(n), SC: O(n) - worst case

//Approach - 2 : Iterative

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode curr = st.pop();

            if (curr.right != null)
                st.push(curr.right);

            if (curr.left != null)
                st.push(curr.left);

            if (!st.isEmpty()) {
                curr.right = st.peek();
            }
            curr.left = null;
        }
    }
}

//TC:O(n), SC:O(n)-worst case