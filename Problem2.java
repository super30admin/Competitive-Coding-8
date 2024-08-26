// Time : O(n), number of nodes
// Space : O(1)

public class Solution {
    
    public void flatten(TreeNode root) {
        // Base case: if the tree is empty, there's nothing to flatten.
        if (root == null) return;

        // Start flattening from the root node.
        TreeNode curr = root;

        while (curr != null) {
            // If the current node has a left child, we need to re-arrange the links.
            if (curr.left != null) {
                // Find the rightmost node in the left subtree.
                TreeNode rightmost = curr.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                // Connect the rightmost node of the left subtree to the current node's right subtree.
                rightmost.right = curr.right;

                // Move the left subtree to the right, and set the left child to null.
                curr.right = curr.left;
                curr.left = null;
            }

            // Move on to the next node (right child of the current node).
            curr = curr.right;
        }
    }
}
