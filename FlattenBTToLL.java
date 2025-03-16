/*
 * TC: O(n)
 * SC: O(h)
 */
public class FlattenBTToLL {
    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode right = root.right;
        TreeNode left = root.left;

        // flatten right
        flatten(right);
        // flatten left
        flatten(left);

        // node's left becomes null
        root.left = null;
        // node's right becomes left
        root.right = left;
        // go all the way to the end of left
        // and attach right
        TreeNode ptr = root;
        while (ptr.right != null) ptr = ptr.right;
        ptr.right = right;
    }
}
