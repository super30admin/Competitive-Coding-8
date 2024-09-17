//Time Complexity : O(n)
//Space Complexity : O(h) for recursive stack

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

//store right in temp
//make left as right
// add right as the rightmost node

class Solution {
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        
        flatten(root.left);
        flatten(root.right);
        
        if(root.left!=null){
            TreeNode temp = root.right;
            root.right=root.left;
            root.left=null;
            while(root.right!=null){
                root=root.right;
            }
            root.right=temp;
        }
        
    }
}