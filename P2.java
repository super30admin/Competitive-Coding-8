/*
 * DFS

Time Complexity (TC):
O(N), since each node is visited once.
Space Complexity (SC):
O(H), where H is the height of the tree (recursion stack). In a balanced tree, H = logN; in a skewed tree, H = N.

Recursive DFS Traversal:

If root is null, return null.
Recursively process the left and right subtrees.
Rearranging Nodes:

If there is a left subtree (leftTail exists),
Move the right subtree to leftTail.right.
Move the left subtree to the right.
Set root.left to null.
Returning the Last Node:

The last node in the flattened list is either rightTail, leftTail, or root.

 */

class Solution {
    public void flatten(TreeNode root) {
        dfs(root);
    }

    public TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftTail = dfs(root.left);
        TreeNode rightTail = dfs(root.right);

        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        return (rightTail != null) ? rightTail : (leftTail != null) ? leftTail : root;
    }
}
