
// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I dint face any problem while coding this


// Your code here along with comments explaining your approach


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
