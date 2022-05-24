/**
 * Time complexity : O(n) n is the number of nodes in the tree
 * Space complexity : O(1) - Internally space is used for recursive stack
 * Did this code successfully run on Leet code : Yes
 * Any problem you faced while coding this : No
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTree {
    public void flatten(TreeNode root) {
        //base case
        if(root == null || root.left == null && root.right == null)
            return;

        //recursive case
        if(root.left != null){
            flatten(root.left);
            TreeNode tempRight = root.right; // storing right node in a temporary reference
            root.right = root.left; // make left node as the right node
            root.left = null; // and then we make left child as null
            // traverse through the tree until we get right child as null and make
            // the right child with null as root
            while(root.right != null) {
                root = root.right;
            }
            // then tempRight will be marked as the root's right - till now the left sub tree is processed
            root.right = tempRight;
        }
        // now we flatten the right child of root
        //we flatten the right child whether if left is null or not
        //so this is placed outside of the if condition
        flatten(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}