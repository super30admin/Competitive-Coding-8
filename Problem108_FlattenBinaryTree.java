
// Time Complexity : O(2n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        TreeNode node = root;
        while(node != null) {
            if(node.left != null) {
                TreeNode rightMost = node.left;
                while(rightMost.right != null) {
                    rightMost = rightMost.right;
                }
                rightMost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }
}