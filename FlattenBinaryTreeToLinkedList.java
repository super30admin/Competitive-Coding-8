// Time Complexity : Add : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
class Solution {
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        
        TreeNode curr = root;
        
        while(curr != null){  // S.C - O(1), T.C - O(N)
            
            if(curr.left != null){
                TreeNode rightMost = curr.left;  // go to the left node
                while(rightMost.right != null){
                    rightMost = rightMost.right;  // find the rightMost node of left node
                }
                
                rightMost.right = curr.right;  // link righMost's right node to curr.right
                curr.right = curr.left;  // make the left nodes to curr.right
                curr.left = null; // nullify them
            }
            
            curr = curr.right;  // keep repeating until curr is null
        }
    }
}
