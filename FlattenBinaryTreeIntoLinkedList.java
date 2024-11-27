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
//Approach - Recursion - get the leftmost (bottom-most) nodes
//           connect the leftmost's right to node's right
//           connect node's right = node's left
//           make the node's left to null, so that all nodes are moved to the right side
//Time Complexity - O(N) - N is the number of nodes in the tree
//Space Complexity - O(N) - implicitly for the recursion stack
class Solution {

  public void flatten(TreeNode root){
    flattenTree(root);
    return;
  }
  public TreeNode flattenTree(TreeNode node){
    if(node == null || (node.left == null && node.right == null)){
      return node;
    }
    TreeNode leftmost = flattenTree(node.left);
    TreeNode rightmost = flattenTree(node.right);
    if(leftmost != null){
      leftmost.right = node.right;
      node.right = node.left;
      node.left = null;
    }
    return rightmost == null? leftmost: rightmost;
  }
}
