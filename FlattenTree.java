
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Recursive
class Solution {
    
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode root){
        if(root == null)
            return null;
        
        if(root.left==null && root.right==null)
            return root;
        
        TreeNode leftNode = helper(root.left);
        TreeNode rightNode = helper(root.right);
        
        if(leftNode!=null){
            leftNode.right=root.right;
            root.right = root.left;
            root.left=null;  
        }
        
        return rightNode==null ? leftNode : rightNode;
    }
}
