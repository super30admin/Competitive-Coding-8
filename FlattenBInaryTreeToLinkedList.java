
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// go to the left most subtree, recursively change pointers
// flattens left subtree, keeps track of tail node to link the right subtree to 

class Solution {
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode node){
        if(node==null){
            return node;
        }
        
        if(node.left==null && node.right==null){
            return node;
        }
        
        TreeNode lTail = helper(node.left);
        TreeNode rTail = helper(node.right);
        
        if(lTail!=null){
            lTail.right = node.right;
            node.right = node.left;
            node.left = null;
        } 
        
        if(rTail==null){
            rTail = lTail;
        }
        
        return rTail;
    }
}