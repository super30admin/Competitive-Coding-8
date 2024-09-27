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


// Time Complexity : 0(n) where n is the nodes in the tree
// Space Complexity : 0(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:


    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode lefthalf = root.left;  //copying left and right half of the tree
        TreeNode righthalf = root.right;
        root.left = null;   //breaking the association of the left node of the tree
        flatten(lefthalf);  //recursively calling flatten to flatten the left half of the tree
        flatten(righthalf); //recursively calling flatten to flatten the right half of the tree
        root.right = lefthalf;  //associating the left half of the tree to the right
        TreeNode current = root;    //declaring a new treenode current to navigate to the last node in the flattened
        while(current.right != null){
            current = current.right;
        }
        current.right = righthalf;  //associating the right flattened tree to the last node of the left flattened half.
    }
}