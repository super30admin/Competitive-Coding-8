//TC = O(N)
//SC = O(N)
//--Here we are using stack to store the left and right child. 
//--Then will peek these from stack and attach to the right and will keep left null.

class FlattenBT{
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            if(curr.right != null){
                st.add(curr.right);
            }
            if(curr.left != null){
                st.add(curr.left);
            }
            if(!st.isEmpty()){
                curr.right = st.peek();
                curr.left = null;
            }
        }
    }

}