//Time complexity: O(N)
//Space complexity: O(N)

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
        
        //base
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            return;
        }

        //logic
        if(root.left != null) {
            flatten(root.left);
            //store the right node in temp
            TreeNode temp = root.right;
            //the left will become the right
            root.right = root.left;
            root.left = null;
            while(root.right != null) {
                root = root.right;
            }
            root.right = temp;
        }
        flatten(root.right);
    }
}