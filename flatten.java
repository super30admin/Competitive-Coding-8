// Time Complexity : O(n) max of n can be seen
// Space Complexity : O(n) or O(h) // h could be n for a skewed tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    
    
    public void flatten(TreeNode root) {
     
        if(root==null || root.left==null && root.right==null)
            return;
        
        /* Store left and right */
        TreeNode left=root.left;
        TreeNode right=root.right;
        
        /* Set left to null */
        root.left=null;
        
        /* Recurse */
        flatten(left);
        flatten(right);
        
        /* Set the right pointer to left */
        root.right=left;
        
        /* Find the rightmost element and point it to the right we flattened */
        TreeNode current=root;
        while(current.right!=null)
            current=current.right;
        
        current.right=right;
    }
}