/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
LeetCode Submitted : YES
Space Complexity : O(1) //Ignoring Recursion Stack
Time Complexity : O(N)

The idea is to recursively traverse left part of the tree till we reach end of the tree . Once left part is traversed. Copy right node to temp node and then traverse right part by pointing left node to the right of root and lastly pointing the right part to the temp node.

**/


class Solution {
    public void flatten(TreeNode root) {
        
        callRecursion(root);
    }
    
    private void callRecursion(TreeNode root){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        
        if(root.left != null){
            //Traverse Left Part of the Tree
            callRecursion(root.left);
            TreeNode rightNode = root.right;
            root.right = root.left;
            root.left = null;
            while(root.right != null) root = root.right;
            root.right = rightNode;
        }
        
        callRecursion(root.right);
        
       
    }
}
