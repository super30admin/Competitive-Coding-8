
// Time Complexity : O(n^2)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Passing in parameters to the recusion


// Your code here along with comments explaining your approach

class Solution {
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        
        preorder(root);
    }
    private void preorder(TreeNode root){
        if(root==null)
            return;
        
        //process root
      
        TreeNode temp = root.right;
        root.right = root.left;
        

        preorder(root.left);
        TreeNode right_temp = root;
        while(right_temp.right!=null){
            right_temp=right_temp.right;
        }
        right_temp.right = temp;
        root.left=null;

        preorder(temp);
        
    }
}