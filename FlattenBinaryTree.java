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
    TreeNode last;

    public void flatten(TreeNode root) {
        this.last = root;
        // helperPreOrder(root);
        // helperPreOrderInplace(root, null);
        helperPostOrderInplace(root, null);

    }

    private TreeNode helperPostOrderInplace(TreeNode root, TreeNode prev) {
        if (root == null) {
            return prev;
        }

        //Tc: O(n)
        //Sc: O(n)
        TreeNode right = helperPostOrderInplace(root.right, prev);
        TreeNode left = helperPostOrderInplace(root.left, right);
        root.right = left;
        root.left = null;

        return root;
    }

    //Tc: O(n)
    //Sc: O(n)
    private TreeNode helperPreOrderInplace(TreeNode root, TreeNode prev) {
        if (root == null) {
            return prev;
        }

        if (prev != null) {
            prev.right = root;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = null;
        root.left = null;

        TreeNode newPrev = helperPreOrderInplace(left, root);
        return helperPreOrderInplace(right, newPrev);
    }

    //Tc: O(n)
    //Sc: O(n)
    private void helperPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = null;
        root.left = null;

        if (last != root) {
            last.right = root;
            last = last.right;
        }

        // left
        if (left != null) {
            helperPreOrder(left);

        }

        // right
        if (right != null) {
            helperPreOrder(right);
        }
    }
}