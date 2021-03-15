// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// Used modified Morris traversal 
class Solution {
   
    public void flatten(TreeNode root) {
        
        if (root == null) {
            return;
        }
        
        TreeNode node = root;
        
        while (node != null) {
            
            if (node.left != null) {
                
                TreeNode curr = node.left;
                while (curr.right != null) {
                    curr = curr.right;
                }
                
                curr.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            
            node = node.right;
        }
    }
}
