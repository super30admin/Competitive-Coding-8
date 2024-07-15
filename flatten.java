// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public void flatten(TreeNode root) {
        flattentree(root);
    }
    private TreeNode flattentree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftchild = flattentree(root.left);
        TreeNode rightchild = flattentree(root.right);
        TreeNode temp = root.right;
        if (leftchild != null) {
            root.right = root.left;
            root.left = null;
            leftchild.right = temp;
        }
        if (rightchild != null) {
            return rightchild;
        } else if (leftchild != null) {
            return leftchild;
        } else {
            return root;
        }
    }
}
