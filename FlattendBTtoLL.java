// Time Complexity : O(n) to traverse all nodes
// Space Complexity : O(h) h is the height of the tree, h is logn
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class FlattenBTtoLL {
    TreeNode newroot;
    public void flatten(TreeNode root) {
        recursion(root);
    }

    private TreeNode recursion(TreeNode root){
        if(root==null){
            return null;
        }
        if(root.left==null && root.right==null){
            return root;
        }

        //newroot = new TreeNode(root.val);

        TreeNode l = recursion(root.left);
        TreeNode r = recursion(root.right);

        if(l!=null){
            l.right=root.right;
            root.right = root.left;
            root.left = null;
            return r==null?l:r;
        }
        //if(r!=null){

        //}
        //return root;
        return r;
    }
}

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