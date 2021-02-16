// Time Complexity : The time complexity is O(n) where n is the number of tree nodes
// Space Complexity : The space complexity is O(h)
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
class Solution {
    public void flatten(TreeNode root) {

        if(root == null){
            return;
        }

        traverse(root);
    }

    public TreeNode traverse(TreeNode root){

        //base case
        if(root == null){
            return null;
        }

        //logic
        //Always return node to which next has to be connected
        TreeNode left = traverse(root.left);
        TreeNode right = traverse(root.right);

        if(left == null && right == null){
            return root;
        }

        if(left != null && right != null){
            left.right = root.right;
            root.right = root.left;
            root.left = null;
            return right;
        }

        if(left != null){
            root.right = root.left;
            root.left = null;
            return left;
        }

        if(right != null){
            return right;
        }

        return null;
    }
}
