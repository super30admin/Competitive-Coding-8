/**
 * 
 * approach - 
 * take left tree, flaten it completely.
 * 
 * now take right tree, flatten it as well 
 * 
 * at last move to the last node of left tree, and assign the entire right treee.
 * tc:O(n) + 2pass
 * sc : O(h) 
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {

        // base case
        if (root == null)
            return;

        TreeNode ltree = root.left;
        root.left = null;

        TreeNode rtree = root.right;

        // recusrive calls
        flatten(ltree);

        // make link, with finalized left tree
        root.right = ltree;

        // recusre to right tree and flatten it
        flatten(rtree);

        // here we have flattened right part, to assign it, travese to the right most
        // child of ltree.

        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }

        curr.right = rtree;

        return;

    }
}