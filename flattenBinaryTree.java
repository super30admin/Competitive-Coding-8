//Time complexity O(n)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//Logic is to iterate over the root in preorder method and attaching the left node on the right and having a pointer temp to store the right child of the root node
//then iterating over the new right child and attaching the temp right node to the rightmost child and continuing the recursive stack.
class Solution {
    public void flatten(TreeNode root) {
        
        if(root == null){
            
            return;
        }
        
        //using a helper function
        helper(root);
        
    }
    
    private void helper(TreeNode root){
        
        if(root == null){
            
            return;
        }
       //logic 
       
        //root.left = null;
        //  System.out.println(root.val);  
    //recurse
        helper(root.left);
         if(root.left != null ){
            
            TreeNode temp = root.right;
            
            
            root.right = root.left;
            root.left = null;
            while(root.right != null){
                
                root = root.right;
            }
            root.right = temp;
        }
        helper(root.right);
    }
}