//TC: O(n) where is the total nodes in the tree
//SC: O(1) ,there is space for recursion stack under hood

//CODE:

class Solution {
    public void flatten(TreeNode root) {
        // base case
        if (root == null || root.left == null && root.right == null)
            return;

        // recursive case
        if (root.left != null) {
            flatten(root.left);
            TreeNode tempR = root.right; // storing right node in a temporary reference
            root.right = root.left; // making left node as the right node
            root.left = null; // and then making left child as null
            while (root.right != null)
                root = root.right; // traversing through the tree till we get right child as null and making root
                                   // as the right child with null
            root.right = tempR; // connecting tempR that stored right node earlier with the right child of root
        }
        flatten(root.right); // calling the function for right child of root
    }
}
