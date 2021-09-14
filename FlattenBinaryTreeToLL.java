//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
/*
Time: O(N) where N is the number of nodes in the tree
Space: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class FlattenBinaryTreeToLL {

    public void flatten(TreeNode root) {
        if (root == null)
            return;

        while (root != null) {
            if (root.left != null) {
                // Store root's left and right nodes first
                TreeNode rootLeft = root.left;
                TreeNode rootRight = root.right;

                // Find rightmost
                TreeNode curr = rootLeft;
                while (curr.right != null) {
                    curr = curr.right;
                }

                curr.right = rootRight;
                root.left = null;
                root.right = rootLeft;
            }

            else // root.left is null, go right
            {
                root = root.right;
            }
        }

    }

}
