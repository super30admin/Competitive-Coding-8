//Time Complexity: O(N);
//Space Complexity:O(logN);
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode temp;
    public TreeNode flatten(TreeNode node) {
        helper(node);
        return temp;
    }
    public void helper(TreeNode node){
        if(node == null){
            return;
        }
        helper(node.right);
        helper(node.left);
        node.right = temp;
        node.left = null;
        temp = node;
    }

}