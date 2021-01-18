/* Given the root of a binary tree, flatten it to a linked list in-place.
/* TC O(N). SC O(N)
*/
class Solution {
    public void flatten(TreeNode root) {
        if ( root == null) {
            return;
        }
        flatten(root.left);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null) {
            root = root.right;
        }
        root.right = temp;
        flatten(root.right);
    }
}
