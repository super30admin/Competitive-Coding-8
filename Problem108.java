// Time Complexity : O(n)
// Space Complexity : O(h)

class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;

        TreeNode curr = root;
        while(curr.right != null) {
            curr = curr.right;
        }
        curr.right = tmp;
    }
}