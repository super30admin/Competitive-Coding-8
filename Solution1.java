
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Flatten Binary tree into linked list
// Time complexity - O(n) space - O(n)
class Solution1 {
    public void flatten(TreeNode root) {
       
        flattenNode(root);
    }
    
    private TreeNode flattenNode(TreeNode root){
        if(root == null)
            return root;
        
        TreeNode left = flattenNode(root.left);
        TreeNode right = flattenNode(root.right);
        root.right = left;
        if(left != null){
            TreeNode rightmost = left;
            while(rightmost.right != null){
                rightmost = rightmost.right;
            }
        
            rightmost.right = root.right;
        }
        
        
        root.left = null;
        
        return root;
    }
}