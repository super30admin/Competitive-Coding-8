// Time Complexity -> O(n)
// Space Complexity -> O(h)
class Solution {
    TreeNode prev;
    public void flatten(TreeNode root) {
        prev = null;
        helper(root);
        return;
    }

    private void helper(TreeNode root){
        if(root == null) return;

        // recursion
        helper(root.right);
        helper(root.left);
        // logic
        root.left = null;
        root.right = prev;
        prev = root;
    }
}
