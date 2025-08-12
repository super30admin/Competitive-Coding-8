// TC: O(n)
// SC : O(1) - no additional space

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
        TreeNode temp;
        TreeNode current = root;
        if(root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        temp = root.right;
        root.right = root.left;
        current = root;
        root.left = null;

        while(current.right!=null){
            current = current.right;
        }

        current.right = temp;
    }
}
