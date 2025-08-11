// Time Complexity : O(n)
// Space Complexity : O(height of the tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I simply did a DFS - went to the left most node, swapped right with null and stored right in temp -> after that I went to the right most point of the subtree and re attached the right part. 

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
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left; 
        root.left = null;
        TreeNode curr = root;
        while(curr.right!=null){
            curr = curr.right;
        }
        curr.right = temp;
    }
}