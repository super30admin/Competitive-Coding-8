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
//tc: o(n) sc: o(1)
class FlattenBinaryTree {
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode curr = root;
        while(curr != null){
            TreeNode node = curr.left;
            if(curr.left != null){
                while(node.right != null){
                    node = node.right;
                }
                node.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
