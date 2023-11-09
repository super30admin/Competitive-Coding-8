// Time Complexity : O(n) where n is the number of total nodes in the tree
// Space Complexity : O(1) we do not use any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        preorder(root);
    }
    public void preorder(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        if(root.left != null){
            if(root.right != null){
                TreeNode temp = root.right;
                TreeNode curr = root.left;
                root.right = curr;
                while(curr.right != null){
                    curr = curr.right;
                }
                curr.right = temp;
            }else{
                root.right = root.left;
            }
            root.left = null;
        }
        preorder(root.right);
    }
}
