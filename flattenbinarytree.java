// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    TreeNode prev= null;
    public void flatten(TreeNode root) {
      

        helper(root);
        
    }
    private void helper(TreeNode root){
        if(root==null) return;
        
       
        helper(root.left);
        
        helper(root.right);
        System.out.println(root.val);
        root.right=prev;
        root.left=null;
        prev=root;
    }
}