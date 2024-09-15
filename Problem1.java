//Time complexity: O(N)
//Space complexity: O(N) 


class Solution {
    
    private TreeNode flattenTree(TreeNode node) {
        
        if (node == null) {
            return null;
        }
            
        
        if (node.left == null && node.right == null) {
            return node;
        }
        
        TreeNode leftTail = this.flattenTree(node.left);
        
        TreeNode rightTail = this.flattenTree(node.right);

        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        
        
        return rightTail == null ? leftTail : rightTail;
    }
    
    public void flatten(TreeNode root) {
        
        this.flattenTree(root);
    }
}