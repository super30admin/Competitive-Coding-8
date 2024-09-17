//TC: O(N)
//SC: O(H)
class Solution {
    TreeNode prev;
    public void flatten(TreeNode root) {
        if(root == null) return;
        helper(root);
    }
    
    private void helper(TreeNode root) {
        //base
        if(root == null) return;
        
        //logic
        helper(root.right);
        helper(root.left);
        
        root.right = prev;
        root.left = null;
        prev = root;
    }
}