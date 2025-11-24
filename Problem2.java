// Time Complexity : O(n).
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : The result of the flattened tree wont have any left subtree. We can do it by performing pre order traversal first and store in a List and then
// construct a tree. But this is O(n) space. We can do better by performing the operations on the same given tree in O(1) space by -
// We find the rightmost node in the left subtree to attach it to the first right of the right subtree. And move towards right and continue the steps
// as we have to make left as null as well.

class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode rightmost = curr.left;// find rightmost of left subtree
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                //move the right most node to the first right of the root.
                rightmost.right = curr.right; //update curr right to rightmost ones's right
                curr.right = curr.left;//update curr right with left one
                curr.left = null; //make left as null we dont need left part
            }
            curr = curr.right;//move to the next right node
        }
    }
}