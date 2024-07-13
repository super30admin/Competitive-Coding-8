// Time Complexity : O(N)
// Space Complexity : O(N) stack space
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
    public void flatten(TreeNode root) {

        // base case
        if(root == null || (root.left == null && root.right == null)) return;

       // recursive approach
        if(root.left != null) {
            flatten(root.left);
            TreeNode tempRight = root.right;
            root.right = root.left;
            root.left = null;
            while(root.right != null) root = root.right;
            root.right = tempRight;
        }
        flatten(root.right);
    }
}


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
        this.flattenTree(root);
    }

    private TreeNode flattenTree(TreeNode root){
        if(root == null) return null;

        if(root.left == null && root.right == null){
            return root;
        }

        TreeNode leftTail = this.flattenTree(root.left);

        TreeNode rightTail = this.flattenTree(root.right);

        if(leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        return rightTail == null? leftTail : rightTail;
    }
}