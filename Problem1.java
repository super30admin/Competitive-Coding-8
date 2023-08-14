// Time Complexity : O(n) where n is the no of nodes in the tree, as we need to visit each node of the tree once
// Space Complexity : O(1_, no auxiliary space is used
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class FlattenBinaryTree {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root);
    }

    private TreeNode dfs(TreeNode root){
        //base
        if(root == null) return null;

        //leftEnd
        TreeNode leftEnd = dfs(root.left);

        //rightEnd
        TreeNode rightEnd = dfs(root.right);
        if(leftEnd == null && rightEnd == null){
            return root;
        }
        //relink
        if(leftEnd != null){
            leftEnd.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if(rightEnd != null){
            return rightEnd;
        }else
            return leftEnd;
    }
}