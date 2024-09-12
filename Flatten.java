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
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){   // 1 2 5
            TreeNode curr = stack.pop(); // 5

            if(curr.right != null) {
                stack.push(curr.right); // 1 2 5
            }
            if(curr.left != null) {
                stack.push(curr.left); // 6
            }

            if(!stack.isEmpty()) { // if condition
                curr.right = stack.peek(); // 1 2
            }

            curr.left = null; // dont miss this

        }
    }
}