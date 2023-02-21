// Time Compexity = O(n)
// Space Complexity = O(1)

class Solution {
    public void flatten(TreeNode root) {
        
        if(root==null) return;
        
        if(root.left==null && root.right==null) return;
            
        if(root.left!=null){
            
            flatten(root.left);
            TreeNode temp=root.right;
            root.right=root.left;
            root.left=null;
            TreeNode temp1=root;
            while(temp1.right!=null){
                temp1=temp1.right;
            }
            temp1.right=temp;
        }
        
        flatten(root.right);
        
    }
}