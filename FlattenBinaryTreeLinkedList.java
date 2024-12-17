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
// Time : O(n) # visiting all the nodes in a tree
// Space : O(h)
class Solution {
    public void flatten(TreeNode root) {
        if(root == null || root.left==null && root.right == null ) return;
        if(root.left!=null){
            flatten(root.left);
            TreeNode tempRight = root.right;
            root.right = root.left;
            root.left = null; // remove the connection
            while(root.right!=null){ // as the flatten left attached to root's right link we have to do this
                root = root.right;
            }
            root.right = tempRight;
        }
        flatten(root.right);
        
    }
}