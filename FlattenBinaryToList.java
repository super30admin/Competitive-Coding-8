/*
time complexity O(n)
space complexity O(n) we are storing right side of tree in a temp node
approach: using recursion first we flatten the left side of tree and attach it to right of root node by storing right in temp node and then go to end of current right and attach flattened right tree */

class Solution {
    public void flatten(TreeNode root) {
        if(root==null)return;
        helper( root);
    }
    private void helper(TreeNode root){
        //base
        
        TreeNode temp=null;
        if(root.right!=null){
            temp=root.right;
        }
        if(root.left!=null){
            helper(root.left);
        }
        root.right=root.left;
        root.left=null;
        while(root.right!=null){
            root=root.right;
        }
        root.right=temp;
        if(root.right!=null){
            helper(root.right);
        }
    }
}