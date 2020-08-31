/*
  Time: O(n)
  Space: O(h) h = height of the tree.
  Run on LeetCode: Yes
*/
class Solution {
    //prev to store prev node.
    TreeNode prev;
    public void flatten(TreeNode root) {
        if(root == null)
            return;

        //store right node.
        TreeNode right = root.right;

        //make connection between prev and this node.
        //make this node prev.
        if(prev == null)
            prev = root;
        else{
            prev.right = root;
            prev.left = null;
            prev = root;
        }

        //walk in perorder manner.
        flatten(root.left);
        flatten(right);
    }
}
