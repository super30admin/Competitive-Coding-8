// Time Complexity : O(n)
// Space Complexity : O(n) - recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Traverse the tree in post order fashion. Right, Left, Root
 * 2. Keep track of previous node and assign it to current node's right and left to null.
 * 3. Assign current node to previous node.
 */
class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        flat(root);
    }

    private void flat(TreeNode root){
        if(root == null){
            return;
        }

        flat(root.right);
        flat(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}