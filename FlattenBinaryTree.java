//Time complexity is O(N)
//Space complexity is O(1)
class Solution {
   
    public void flatten(TreeNode root) {
        
        if (root == null) {
            return;
        }
        
        TreeNode node = root;
        
        while (node != null) {
            
            if (node.left != null) {
                
                TreeNode rightmost = node.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                
                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            
            node = node.right;
        }
    }
}