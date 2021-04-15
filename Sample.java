//Time Complexity : O(n)
//Space Complexity : O(1)

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
      
      TreeNode node = root;
      
      while(node != null)
      {
        if(node.left != null)
        {
          TreeNode current = node.left;
          while(current.right!=null)
          {
            current = current.right;
          }
          
          TreeNode temp = node.right;
          node.right = node.left;
          current.right= temp;
          node.left=null;
          
        }
        node = node.right;
      }
        
    }
}