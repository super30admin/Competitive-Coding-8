/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        
        if(root == null){
            return;
        }
        
        TreeNode node = root;
        
        while(node != null){
            if(node.left != null){
                TreeNode rightmost = node.left;
                //find right most element of left sub tree
                while(rightmost.right != null){
                    rightmost = rightmost.right;
                }
                // attach nodes right sub tree to rightmost node of left sub tree
                // change left subtree to right of node and make left null
                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }
}
//Time Complexity : O(n)
//Space Complexity: O(1)