// Used the idea of Morris Traversal

// TC: O(n)
// SC: O(1)

class Solution {
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        TreeNode curr, temp;
        curr = root;
        while(curr != null) {
            if(curr.left == null) {
                curr = curr.right;
            } else {
                temp = curr.left;
                while(temp.right != null) {
                    temp = temp.right;
                }
                // break and make links
                temp.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
        }
    }
}