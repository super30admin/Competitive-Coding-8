// Time Complexity : O(n)
// Space Complexity : 1 - O(n), 2- O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
/*class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if(current.right!=null) stack.push(current.right);
            if(current.left!=null) stack.push(current.left);
            if(!stack.isEmpty()) current.right = stack.peek();
            current.left = null;
        }
    }
}*/

class Solution {
  public void flatten(TreeNode root) {
    if(root == null) return;
    TreeNode current = root;
    while(current!=null) {
      if(current.left!=null) {
        TreeNode rightmost = current.left;
        while(rightmost.right!=null) {
          rightmost = rightmost.right;
        }
        rightmost.right = current.right;
        current.right = current.left;
        current.left = null;
      }
      current = current.right;
    }
  }
}