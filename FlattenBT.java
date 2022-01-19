// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// approach

// Performed preorder traversal
// stored the right subtree in temp variable
// stored the preorder of the root.left in the root.right
// made root.left as null
// then went till the leaf node in the resultant root
// did the traversal on the previously stored temp and appended it to the leaf node
class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        preorder(root);

    }

    public TreeNode preorder(TreeNode root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return root;

        TreeNode temp = root.right;
        root.right = preorder(root.left);

        root.left = null;

        TreeNode rightTemp = root;

        while (rightTemp.right != null) {
            rightTemp = rightTemp.right;
        }
        rightTemp.right = preorder(temp);
        return root;
    }
}