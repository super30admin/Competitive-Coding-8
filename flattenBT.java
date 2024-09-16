// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//Time complexity : O(N)
//Space complexity : O(H)
// Did this code successfully run on Leetcode : YES

class Solution {
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            if(node.right != null)
                st.push(node.right);
            if(node.left != null)
                st.push(node.left);
            
            node.left = null;
            if(!st.isEmpty())                
                node.right = st.peek();
        }
        
    }
}
