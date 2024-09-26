//TC:O(N), N->no.of nodes
//SC:O(H), H-> height of the tree
//Did it run successfully on Leetcode?:Yes
class Solution {
    public void flatten(TreeNode root) {
        //base
        if ( root == null || (root.left == null && root.right == null))
            return;
        
        //logic
        if (root.left != null ){
            flatten(root.left);
            TreeNode tempRight = root.right;
            root.right = root.left;
            root.left = null;
            while ( root.right != null){
                root = root.right;
            }
            root.right = tempRight;
        }
        flatten(root.right);
    }
}
