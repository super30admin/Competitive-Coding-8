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

// TC : O(n)
// SC : O(1)
// Recursive approach
class Solution {
    
    private void order(TreeNode root) {
        
        if(root == null) return;
        
        
        order(root.left);
        order(root.right);
        
        //System.out.println(root.val);
        
        TreeNode temp = root.left;
        if(temp == null)
            return;
        
        while(temp.right != null) {
            temp = temp.right;
        }
        temp.right = root.right;
        root.right = root.left;
        root.left = null;
        
        
    }
    
    public void flatten(TreeNode root) {
        
        if(root == null) return;
        
        order(root);
        
    }
}
