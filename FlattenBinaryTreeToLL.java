Time Complexity - O(n*n)
Space Complexity - O(n)

class Solution {
    public void flatten(TreeNode root) {
        if(root == null)return;
        
        preorder(root);        
    }
    
    private void preorder(TreeNode root){
        if(root.left != null){
            preorder(root.left);
        }
        
        //store right in temp var
        TreeNode temp = root.right;
        
        //shift to right
        root.right = root.left;
        
        root.left = null;
        
        if(temp != null){
            preorder(temp);
        }
        
        //
        while(root.right != null){
            root = root.right;
            
        }       
        root.right  = temp;
                
    }
}