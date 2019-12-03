// Time Complexity : O(N)
// Space Complexity : O(1) + recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
class FlattenBinaryTreetoLinkedList {
    TreeNode result = new TreeNode(Integer.MIN_VALUE), current = result;
    public void flatten(TreeNode root) {
        if(null == root){return;}
        flattenHelper(root);
    }
    public void flattenHelper(TreeNode root){
        if(null == root){return;}
        current.right = root;
        current = current.right;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = null; root.left = null;
        flattenHelper(left);
        flattenHelper(right);
    }
}