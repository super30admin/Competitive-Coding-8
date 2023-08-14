/*
Flatten Binary Tree to Linked List
approach:
1. recursion, take a prev, if prev not null then make prev.right = curr left and repeat
2. iterative, idea is to connect right of curr.left to right of curr
time: both O(n)
space: 1. O(h) 2. O(1)
 */
public class Problem1 {
    /*
    TreeNode prev;
    public void flatten(TreeNode root) {
        if(root==null) return;
        helper(root);
    }

    private void helper(TreeNode root) {
        System.out.println("Node "+root.val);
        if(prev!=null) {
            prev.right = root;
            prev.left = null;
        }
        prev = root;
        TreeNode right = root.right;
        root.right = root.left;
        if(root.left!=null) helper(root.left);
        if(right!=null) helper(right);
    }

     //iterative
    public void flatten(TreeNode root) {
        if(root==null) return;
        TreeNode curr = root;
        while(curr!=null) {
            TreeNode prev = curr.left;
            if(prev!=null) {
                while(prev.right!=null) prev = prev.right;
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left=null;
            }
            curr = curr.right;
        }
    }

     */
}
