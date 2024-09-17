/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    /**
     Inorder traverse and flatten left most tree.
     - Store right in temp, attach left to right. traverse till null and attach right on null.
     - While attaching left to right lark left as null
     */
    public void flatten(TreeNode root) {
        if (root == null) return;

        if (root.left == null && root.right == null) return;

        flatten(root.left);
        // stack.pop
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = temp;
        flatten(root.right);
    }
}
