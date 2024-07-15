// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// This recursive method flattens a binary tree into a linked list in-place.
// It processes the right subtree first, then the left subtree, setting the current node's right pointer to the previously processed node (prev) and its left pointer to null.
// Finally, it updates prev to the current node to maintain the linked list structure.

class Solution {
    TreeNode prev ;
    public void flatten(TreeNode root) {
        if(root == null){
            return ;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;

        prev = root;
    }
}

// Method 2:
// This iterative method flattens a binary tree into a linked list using a stack.
// It starts by pushing the root node onto the stack and then processes nodes in a loop, always pushing the right child first and then the left child to ensure the left subtree is processed before the right subtree.
// The current node's right pointer is set to the next node in the stack, and its left pointer is set to null, flattening the tree in-place.

class Solution {
    public void flatten(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }

        Stack<TreeNode> s = new Stack<>();
        s.add(root);

        while (!s.isEmpty()) {
            TreeNode curr = s.pop();

            // Push right child first so that left child is processed first
            if (curr.right != null) {
                s.push(curr.right);
            }

            if (curr.left != null) {
                s.push(curr.left);
            }

            // Link the current node's right to the next node in the stack
            if (!s.isEmpty()) {
                curr.right = s.peek();
            }

            // Set the left child to null as per the problem statement
            curr.left = null;
        }
    }
}