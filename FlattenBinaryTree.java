// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        flatten(root.left);

        TreeNode temp = root.right;
        if (root.left != null) {
            root.right = root.left;
            root.left = null;
            while (root.right != null)
                root = root.right;
            root.right = temp;
        }

        flatten(temp);

    }
}