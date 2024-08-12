// TC - O(n), sc-O(n)
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
        dfs(root);
    }

    private TreeNode dfs(TreeNode root){
        if (root == null) return null;

        if(root.left==null && root.right==null){
            return root;
        }
        TreeNode leftN = dfs(root.left);
        TreeNode rightN = dfs(root.right);
    
        if(leftN!=null){
        leftN.right=root.right;
        root.right=root.left;
        root.left=null;
        }
        if(rightN!=null){
            return rightN;
        }else if(leftN!=null){
            return leftN;
        }

        return null;
    }
}