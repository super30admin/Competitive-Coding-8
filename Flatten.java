// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
        if(root == null){
            return;
        }
        
        TreeNode left = root.left;	// take left of the root
        if(left != null){			// if not null, traverse to right most end of the left root.
            while(left.right != null){
                left = left.right;
            }
            TreeNode right = root.right;	// before removing the connection to right node, copy the address of it 
            root.right = root.left;			// assign left to right side of the root
            left.right = right;				// connect the right end of the left root to right 
            root.left = null;				// make the side equal to null
        }
        
        flatten(root.right);		// recursively call this function on right of the root to traverse completely
    }
}