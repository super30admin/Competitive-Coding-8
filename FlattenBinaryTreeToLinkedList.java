// Time Complexity : O(n)
// Space Complexity : O(depth)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return;
        
            flatten(root.left);
            
            TreeNode tempRight = root.right;
            root.right = root.left;
            root.left = null;
            
            while(root.right !=null) {
                root = root.right;
            }
            
            root.right = tempRight;

            flatten(root.right);
    }
}