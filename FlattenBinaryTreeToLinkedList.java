// Time Complexity : O(n) n--> no. of nodes in tree
// Space Complexity : O(n), n no of nodes will be there in recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// The flattening can be done recursively by assigning the left nodes as null and connecting left node on the right side. 
// This can be visualized in a bottom up way wherein the leaf node's rearrangement is done on the right side.
// Additional pointers will be required to keep track of left and right references.

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
        // edge cases
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        
        // Main logic
        
        flatten(root.left);
        flatten(root.right);
        // since there will be reassignments of links, i will need references of left and right nodes
        TreeNode currLeft = root.left;
        TreeNode currRight = root.right;
        
        root.left = null; // assigning left as null
        root.right = currLeft; // assigning current left as the right node
        
        // logic for getting last node of flattened left subtree
        while(currLeft != null && currLeft.right != null) {
            currLeft = currLeft.right;
        }
        
        if(currLeft != null)
            currLeft.right = currRight;
        else
            root.right = currRight;
    }
}

