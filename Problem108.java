// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
        TreeNode current = root;
        
        while (current != null) {
            // If the current node has a left child
            if (current.left != null) {
                // Find the rightmost node in the left subtree (predecessor)
                TreeNode predecessor = current.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                
                // Connect the right subtree of the current node to the right of the predecessor
                predecessor.right = current.right;
                
                // Move the left subtree to the right
                current.right = current.left;
                current.left = null;  // Set the left child to null
            }
            
            // Move to the next node (right child)
            current = current.right;
        }
    }
}
