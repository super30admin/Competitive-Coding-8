//Time Complexity: O(N)
//Space Complexity: O(1)
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
//Time Complexiy: O(N), where N is the number of nodes in the tree;
//Space Complexity: O(1) iaf we are not considering the recurseive stack as extra space.
    
class Solution {
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        
        //recursive
        if(root.left != null){
            flatten(root.left);
            TreeNode prev = root.right;
            root.right = root.left;
            root.left = null;
            while(root.right != null){
                root = root.right;
            }
            root.right = prev;
        }
        flatten(root.right);
    }
}