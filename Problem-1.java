//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// swaping nodes
class Solution {
    public void flatten(TreeNode root) {
        
        if(root == null) return;       
       
        
        while(root!=null){
            
            if(root.left !=null){
                
                TreeNode temp = root.left;
                
                while(temp.right!=null){
                    
                    temp = temp.right;
                }
                
                temp.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            
            root = root.right;
        }
        
    }
}