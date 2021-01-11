// Time - O(N)
// Space - O(N)

class Solution {
    
    public void flatten(TreeNode root) {
        
       helper(root);
        
        return;
    }
    private TreeNode helper(TreeNode root){
        if(root==null) {
            return root;
        }
         if(root.left == null && root.right == null) {
            return root;
        }
        
        TreeNode lRail = helper(root.left);
        TreeNode rRail = helper(root.right);
        
        if(lRail!=null) {
            lRail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        w
        if(rRail==null){
            rRail = lRail;
        }
        
        return rRail;
    }
}
