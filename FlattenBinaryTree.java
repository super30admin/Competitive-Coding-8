/*TC , SC O(N)*/

class Solution {

    public void flatten(TreeNode root) {
       // iterative preorder
       if (root == null) return;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode elem = st.pop();

            if (elem.right != null){
                st.push(elem.right);
            }
            if (elem.left != null){
                st.push(elem.left);
            }
            if (!st.isEmpty()){
		    // the nest elemement in the stack should be the right elem
                 elem.right = st.peek();
            }
	    // no left child in resultanant list
            elem.left = null;
        }

    }

}
