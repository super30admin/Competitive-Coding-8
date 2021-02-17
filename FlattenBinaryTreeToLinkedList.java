//Problem 108: Flatten Binary Tree to Linked List
//TC: O(N), N stands for number of nodes
//SC: O(H), height of recursive stack.

import java.util.*;
class Solution {

    class TreeNode{
      TreeNode left,right;
      
    }

    public void flatten(TreeNode root) {
        
        if(root==null) return;
        //Ist way
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            
            TreeNode curr = stack.pop();
            
            if(curr.right!=null) stack.push(curr.right);
            
            if(curr.left!=null) stack.push(curr.left);
            
            if(!stack.isEmpty())  curr.right = stack.peek();
            
            curr.left = null;
        }
        //helper(root);
    }
    
    //2nd way
    //Single traversal
    private TreeNode helper(TreeNode root){
        
        if(root==null) return null;
         
        if(root.left==null && root.right==null) return root;
       
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        
        if(left!=null){
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        return right == null ? left : right;
        
    }
    
    
    /*//Traversing left side twice because when u will attach left to the right, then again whole right will be traversed
    //3rd way
    private void helper(TreeNode root){
        
        if(root==null) return;
        
        if(root.left==null && root.right==null) return;
        
        helper(root.left);
       
        TreeNode temp = root.right;
        
        root.right = root.left;
        root.left = null;//making left null;
        
        while(root.right!=null) root = root.right;//go to last node of new right(originally left) for attaching older right tree to the new right tree
        
        root.right = temp;
        
        helper(root.right);
       
    }*/
    
}