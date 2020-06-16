//time o(n)
//space o(n)
class Solution { 
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode root){
        //base case
        if(root == null)
            return null;
        if(root.left == null && root.right == null)
            return root;
        //logic
        TreeNode leftTail = helper(root.left);
        TreeNode rightTail = helper(root.right);
        if(leftTail != null){
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return rightTail == null ? leftTail : rightTail;
    }
}