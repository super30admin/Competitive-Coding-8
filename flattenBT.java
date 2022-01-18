// Time Complexity : O(n), where n is the no. of nodes in the tree
// Space Complexity : O(h), for recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had trouble connecting the last element in the left branch of tree
// to the right branchs first element

// Your code here along with comments explaining your approach
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        preorder(root);
    }

    private TreeNode preorder(TreeNode root) {
        // base
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        //logic: preorder
        // node
        TreeNode temp = root.right;

        //traverse left
        root.right = preorder(root.left);
        root.left = null;

        // we create rightTemp to traverse till the leadt node and connect to the right half of the root
        TreeNode rightTemp = root;
        while (rightTemp.right != null) {
            rightTemp = rightTemp.right;
        }

        //traverse right
        rightTemp.right = preorder(temp);
        return root;
    }
}