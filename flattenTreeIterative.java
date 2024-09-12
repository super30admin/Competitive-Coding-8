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
// Time: O(n) in the worst case there is full binary tree and we have to traverse all nodes to flatten it.
// Space: O(h) which can be O(n) if there is left aligned tree
// Idea here is to use stack and push root. Pop the root, check if right subtree is not null
// push it to stack then push left subtree to stack.
// each time we peek the topmost element which would be left most element in tree 
// and assign it to right of current subtree and make current's left null.
class Solution {
    public void flatten(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode curr = st.pop();
            if(curr.right!=null) {
                st.push(curr.right);
            }
            if(curr.left!=null) {
                st.push(curr.left);
            }
            if(!st.isEmpty()) {
                curr.right = st.peek();                
            }
            curr.left = null;
        }
        
    }
}