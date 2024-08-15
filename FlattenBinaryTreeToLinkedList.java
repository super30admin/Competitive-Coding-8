// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class FlattenBinaryTreeToLinkedList {
    // using Morris Traversal
    public void flatten(TreeNode root) {
        while(root != null) {
            if(root.left != null) {
                TreeNode pred = root.left;
                while(pred.right != null) {
                    pred = pred.right;
                }
                //rewiring the connections here
                pred.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

}