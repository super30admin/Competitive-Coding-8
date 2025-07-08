// Time Complexity - O(n)
// Space complexity - O(n)
// Solved on leetcode - yes
// Faced any issues - no
// Solving the problem using DFS recursively. At every node, we are doing the left and right binary tree as flatted, then we are updating node's left to null to make left side null and then attaching the right of root to the left flatten tree. And then travesing till the end of the tree and attaching the right flatten tree to the end of the left tree
class Solution {
    public void flatten(TreeNode root) {
        TreeNode t = helper(root);
    }

    public TreeNode helper(TreeNode root) {
        if (root == null) return ;
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        root.left = null;
        root.right = left;
        TreeNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = right;
        return root;
    }
}
