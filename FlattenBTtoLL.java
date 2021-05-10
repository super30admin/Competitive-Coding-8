// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here  with comments explaining your approach

class Solution {
  public void flatten(TreeNode root) {
    if (root == null)
      return;
    if (root.left == null && root.right == null)
      return;

    // Recurse to left subtree
    flatten(root.left);
    // Store the right tree in temp and swap
    TreeNode temp = root.right;
    root.right = root.left;
    root.left = null;
    while (root.right != null) {
      root = root.right;
    }
    // recurse to left
    root.right = temp;
    flatten(root.right);
  }
}