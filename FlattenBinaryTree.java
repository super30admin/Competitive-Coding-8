// Time Complexity : O(d)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class FlattenBinaryTree {
    public void flatten(TreeNode root) {
        if(root == null || root.left == null && root.right == null){
            return;
        }

        if(root.left != null){
            flatten(root.left);
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            while(root.right != null){
                root = root.right;
            }

            root.right = temp;
        }

        flatten(root.right);
    }
}
