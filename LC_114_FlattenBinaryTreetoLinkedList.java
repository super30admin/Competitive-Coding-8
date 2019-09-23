// Time Complexity :O(N)/
// Space Complexity :O(1)// 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No was being helped during mock interview
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
      //base condition 
        if(root == null) return;
        TreeNode curr= root;
        while(curr != null){
            //check left subtree-exists
            if(curr.left!=null){
                //Connect left subtree to the nodes right and set nodes left to null
                TreeNode temp= curr.right;
                curr.right= curr.left;
                curr.left = null;
                TreeNode p= curr.right;
                //Finally attach the previous right subtree, to the newly connected left-subtrees rightmost                     node
                while(p.right !=null) p= p.right;
                p.right = temp;   
            }
            curr= curr.right;
        }
        
    }
}