// TC - O(N)
// SC - O(N)
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
        helper(root);
    }
    private TreeNode helper(TreeNode root){
        if(root == null) return null;
        
        TreeNode temp = null;
        if(root.right != null){
            temp = root.right;
        }
        //System.out.println(root.val);
        
        
        root.right = helper(root.left);
        root.left = null;
        TreeNode temp_root = root;
        
        while(temp_root.right != null){
            temp_root = temp_root.right;
        }
        temp_root.right = helper(temp);
        
        return root;
    }
}