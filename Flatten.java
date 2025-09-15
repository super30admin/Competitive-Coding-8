// Time Complexity : O(n), n -> no. of nodes
// Space Complexity : O(n) due to recursion stack in skewed tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach:
// 1. Recursively flatten left and right subtree
// 2. For left tail of current node, change the pointers
//  - cur node's left tail.right = cur node's right
//  - cur node's right = cur node's left
//  - cur node's left = null

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
public class Flatten {
    public void flatten(TreeNode root) {
        helper(root);
    }

    public TreeNode helper(TreeNode root) {
        if(root == null) {
            return root;
        }

        if(root.left == null && root.right == null) {
            return root;
        }

        TreeNode lt = helper(root.left);
        TreeNode rt = helper(root.right);

        if(lt != null) {
            lt.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return rt == null ? lt : rt;
    }
}
