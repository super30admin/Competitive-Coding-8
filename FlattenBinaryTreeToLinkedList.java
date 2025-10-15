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

/*
* Morris Traversal Algorithm: 
    - It applies on any form of binary tree
    - The approach is to find the left child of the root and go to the right most node of the subtree
    - point the right(null) pointer of the rightmost leafnode to root.right to create a new link and do further manipulations
    TC: for leaf nodes the TC is O(1) and in any BT leaf nodes are n/2 so its amortized O(n)
    SC: O(1) -> no additional space required
*/
class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                // assign a predecessor node to be the left child of root
                TreeNode pred = curr.left;
                // go right until the rightmost leaf node is found
                while (pred.right != null) {
                    pred = pred.right;
                }

                //once the leaf node is found, link the leaf node to curr's right
                pred.right = curr.right;
                //once the link is established, change currs right to currs left to flatten the right side of curr subtree
                curr.right = curr.left;
                //free the left pointer
                curr.left = null;
            }
            // move the curr pointer to the next(right) child to flatten that subtree
            curr = curr.right;
        }

    }
}
