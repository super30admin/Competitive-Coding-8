// Problem1 https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, start with making right most element of left sub tree of root pointed rightly towards roots right and roots right to roots left and
 * roots left to null. 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// 1
class Solution {
    LinkedList<TreeNode> list;
    public void flatten(TreeNode root) {
        this.list = new LinkedList<>();
        preorder(root);
        TreeNode prev = null;
        for(TreeNode node: list){
            if(prev != null){
                prev.left = null;
                prev.right = node;
            }
            prev = node;
        }
    }
    private void preorder(TreeNode root){
        if(root == null) return;
        list.add(root);
        preorder(root.left);
        preorder(root.right);
    }
}
// 2
class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;

    }
}
// 3
class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            if(curr.right!=null){
                st.push(curr.right);
            }
            if(curr.left!=null){
                st.push(curr.left);
            }
            if(!st.isEmpty()) curr.right = st.peek();
            curr.left = null;
        }

    }
}
// 4
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode prev = curr.left;
                while(prev.right!=null){
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}