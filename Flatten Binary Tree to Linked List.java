/*
class Solution:
    def flatten(self, root: TreeNode) -> None:
        # base
        if root is None or (root.left is None and root.right is None):
            return
        
        # action
        self.flatten(root.left)
        temp = root.right
        root.right = root.left
        root.left = None
        
        while root.right is not None:
            root = root.right
        root.right = temp
        
        self.flatten(root.right)
*/

// Time - O(n) where n is no of nodes
// Space - O(h) since recursive stack would grow upto height of tree
// Logic - Just following the preorder traversal but after stack starts unwinding I change the children to right and make left child null

class Solution {
    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;
        
        // normal preorder 
        flatten(root.left);

        // changing the child
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) root = root.right;
        
        root.right = temp;
        
        flatten(root.right);
    }
}