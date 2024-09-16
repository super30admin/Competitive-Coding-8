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
//Time -O(n)
//Space -O(n) stack 
class Solution {
    public void flatten(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        if(root == null) return;
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            if(curr.right!=null){
                st.push(curr.right);
            }if(curr.left!=null){
                st.push(curr.left);
            }
            if(!st.isEmpty()){
                curr.right= st.peek();
            }
            curr.left = null;
        }
    }

}