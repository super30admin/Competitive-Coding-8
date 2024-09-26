// Time Complexity : o(n) where n is number of nodes in tree
// Space Complexity : o(h) h is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Use dummy pointer and and when you visit a node in preorder atatch it to dummy and increment dummy
class Solution {

    TreeNode dummy = new TreeNode(-1);
    public void flatten(TreeNode root) {
       if(root==null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        dummy.right = root;
        dummy = root;
        root.left = null;
        //root.right = null;

        flatten(left);
        flatten(right);
    }

    public void helper(TreeNode root){
        if(root==null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        dummy.right = root;
        dummy = root;
        root.left = null;
        //root.right = null;

        helper(left);
        helper(right);

    }
}
