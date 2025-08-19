// Time Complexity : O(n), where n is the number of nodes. Each node is visited exactly once during the reverse-preorder traversal.
// Space Complexity : O(h) for the recursion stack, where h is the height of the tree (O(log n) for balanced, O(n) for skewed).
// Did this code successfully run on Leetcode : Yes

// Approach :

// Perform a reverse preorder traversal (right → left → root) so that when you process a node, the previously processed node is exactly the next node in the desired flattened list. 
//   Maintain a prev pointer to the head of the already-flattened portion, initially null. 
//   Recursively flatten the right subtree, then the left subtree, ensuring prev always points to the next node in preorder sequence. 
//   After processing children, set root.right = prev and root.left = null to link current node to the flattened list and remove left pointers. 
//   Update prev = root and unwind the recursion to complete the in-place transformation.


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
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return ;
        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}
