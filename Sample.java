
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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
    Stack<TreeNode> s = new Stack<>();
    TreeNode node=null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        node = root;
        while (node != null) {
            if (node.left != null) {
                TreeNode rightmost= node.left;
                while(rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                rightmost.right=node.right;
                node.right=node.left;
                node.left=null;
            }
            node = node.right;
        }
    }
}
