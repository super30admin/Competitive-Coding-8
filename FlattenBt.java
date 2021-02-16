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
//time complexity: O(n)
//algorithm:
//flatten left subtree of root
//then, assign a temp variable to root.right
//make the left flattended subtree the right of root.
//then traverse till end of new right and join the temp right 
//flateen the right subtree


class Solution {
    public void flatten(TreeNode root) {
        //base case
        if(root == null || root.left == null && root.right == null)return ;
        
        
        //logic
       if(root.left != null){
           flatten(root.left);
           TreeNode temp = root.right;
           root.right = root.left;
           root.left = null;
           while(root.right !=null)root = root.right;
           root.right = temp;
       }
        flatten(root.right);
    }
   
}