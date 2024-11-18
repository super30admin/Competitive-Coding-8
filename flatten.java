class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
        if(root.left!=null){
            flatten(root.left);
            TreeNode temp=root.right;
            TreeNode curr=root;
            curr.right=curr.left;
            while(curr.right!=null){
                curr=curr.right;
            }
            root.left=null;
            curr.right=temp;
            root=curr;
        }
        flatten(root.right);
    }

}
