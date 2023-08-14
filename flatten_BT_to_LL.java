// Time Complexity : O(H)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left=root.left;
        TreeNode right=root.right;
        root.left=null;
        root.right=left;
        TreeNode p=root;
        while(p.right!=null){
            p=p.right;
        }
        p.right=right;
    }
}