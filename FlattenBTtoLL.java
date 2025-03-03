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
       if (root == null)
       return; 
               inorder (root);
    }

    private TreeNode inorder (TreeNode node){
        if (node == null)
        return null;
        TreeNode left = inorder (node.left);
       TreeNode right = inorder (node.right);
       if (left != null){
        traversal (left, right);
            node.left = null;
        node.right = left;
       }
              return node;
    }
    private void traversal (TreeNode left, TreeNode right){
        if (left.right == null){
            left.right = right;
            return;
        }
        traversal (left.right, right);
    }
}
//Time Complexity:O(n)
//Space Complexity:O(h)
