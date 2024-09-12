
/*

https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

Worked on LC = YES

Time complexity : O(N)
space complexity : O(1)
Recursion space : O(H)  Max depth of three Tree

*/
class Solution {
    public void flatten(TreeNode root) {
        
        if(root == null || (root.left == null && root.right == null) ) {
            return ;
        }
        
        if(root.left != null) {
            
            flatten(root.left);
            TreeNode tempRight = root.right;
            root.right = root.left;
            root.left = null;
            while(root.right !=null) {
                root = root.right;
            }
            root.right = tempRight;
            
        }
        
        flatten(root.right);
    }
    
   
}
