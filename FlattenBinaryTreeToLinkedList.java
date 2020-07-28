class Solution {
            // Time Complexity : O(N*N) N: nodes of Tree; worst case of skewed tree
// Space Complexity : O(logN)     recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

 /* 
 Postorder:
 1. Use postorder traversal and keep updating the left and right child's next pointers.
 */
    public void flatten(TreeNode root) {
        //base
        if(root == null) return;
        
        //logic
        flatten(root.right);
        flatten(root.left);
        if(root.right != null && root.left != null){
            TreeNode temp = root.right;
            root.right = root.left;
            TreeNode temp1 = root.right;
            while( temp1.right!= null){ 
              temp1 = temp1.right;
        }
            temp1.right = temp;
        }
        else if(root.left!= null && root.right == null){
            root.right = root.left;
        }
        root.left = null;
    }
}