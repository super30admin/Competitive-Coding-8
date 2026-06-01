// Time Complexity : O(n) because every node is visited and rewired at most once
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use an iterative Morris-style traversal to flatten the binary tree into a linked list in preorder.
// For each node with a left subtree, we find the rightmost node of that left subtree and connect it to the current node’s right subtree.
// Then we move the left subtree to the right, nullify the left pointer, and continue traversing through the right pointers.

class Solution {

    public void flatten(TreeNode root) {

        TreeNode curr = root;

        while (curr != null) {

            // left subtree exists
            if (curr.left != null) {

                TreeNode pre = curr.left;

                // find rightmost node of left subtree
                while (pre.right != null) {

                    pre = pre.right;
                }

                // connect original right subtree
                pre.right = curr.right;

                // move left subtree to right
                curr.right = curr.left;

                // remove left pointer
                curr.left = null;
            }

            // move forward
            curr = curr.right;
        }
    }
}