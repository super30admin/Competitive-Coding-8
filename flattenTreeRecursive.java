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
// Time: O(n) in the worst case there is full binary tree and we have to traverse all nodes to flatten it.
// Space: O(h) which can be O(n) if there is left aligned tree
// Idea here is to take right subtrees into a temporary node and once all the left subtrees are flattened
// and assigned to right of root we traverse through current tree to reach the leaf and assign temp node to right of that leaf.
// we recurse on right tree to do the same flattening.
class Solution {
    public void flatten(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return;
        
        if(root.left!=null) {
            flatten(root.left);
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            
            TreeNode curr = root.right;
            while(curr.right!=null) {
                curr = curr.right;
            }
            curr.right = temp;
        }
        if(root.right!=null) {
            flatten(root.right);
        }
    }
}