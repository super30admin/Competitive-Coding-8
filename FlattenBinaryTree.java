// Optimised soln : Time: O(N) | Space: O(1)

class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        // we first go to the immediate left of root,
        // then dig to its extreme right,
        // once the extreme left node is found, we direct its right to the right of root,
        // now we make the immediate left of root to the right root, and make left to null
        // we keep performing the same until all the nodes are right aligned in a skewed manner
        while(curr != null) {
            if(curr.left != null) {
                TreeNode pre = curr.left;
                while(pre.right != null) {
                    pre = pre.right;
                }
                pre.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}

//Brute force: space : O(N) as well
class Solution {
    List<TreeNode> lists;
    public void flatten(TreeNode root) {
        lists = new ArrayList<>();
        dfs(root);
        TreeNode prev = null;
        for(TreeNode li: lists) {
            if(prev != null) {
                prev.right = li;
                prev.left = null;
            }
            prev = li;
        }

    }
    private void dfs(TreeNode root) {
        if(root == null) return;
        lists.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}