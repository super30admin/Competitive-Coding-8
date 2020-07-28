//Time complexity:O(n)
//Space complexity:O(h)
//ITERATIVE
class Solution {
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        Stack<TreeNode> st=new Stack();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node=st.pop();
            if(node.right!=null){
                st.push(node.right);
            }
            if(node.left!=null){
                st.push(node.left);
            }
            if(!st.isEmpty()){
                node.right=st.peek();
            }
            node.left=null;
        }
    }
}
//Time complexity:O(n)
//Space complexity:O(h)
//RECURSIVE
class Solution {
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        if(root.left!=null){
            TreeNode temp=root.right;
            root.right=root.left;
            root.left=null;
            while(root.right!=null){
                root=root.right;
            }
            root.right=temp;
        }
    }
}