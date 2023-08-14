/**
 * Time complexity - O(n) where n is the number of nodes in binary tree.
 * Space complexity - O(h) where h is the height of the binary tree.
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root == null)
            return;

        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
            if(prev != null)
                prev.right = cur;
            cur.left = null;
            prev = cur;
        }
    }
}
