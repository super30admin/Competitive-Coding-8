// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes

class Solution {
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        
        TreeNode curr = root;
        while(curr != null) {
            if(curr.left != null) {
                TreeNode left = curr.left;
                while(left.right != null) 
                    left = left.right;
                left.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
        
    }
}