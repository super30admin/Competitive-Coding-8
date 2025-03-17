// Time Complexity: O(n) where n is the number of nodes in the tree
// Space Complexity: O(h) where h is the height of the tree

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
class FlattenLinkedList {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        preorder(root);
    }

    private void preorder(TreeNode root){
        // base
        if(root == null){
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        if(prev != null){
            prev.right = root;
            prev.left = null;
        }
        prev = root;

        preorder(left);
        // if(left != null){
        //     left.right = root.right;
        // }
        preorder(right);
        //return right;
    }
}
