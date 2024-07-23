 //TC - O(n)
 //SC - O(h) - recursive stack space
 //Approach - Recurse to the left most subtree and flatten it into a LL. Then recurse right. (Bottom up approach)
 class Solution {
    public void flatten(TreeNode root) {
        if(root == null || root.left == null && root.right == null){
            return;
        }
        while(root.left != null){
            flatten(root.left);
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            while(root.right != null){
                root = root.right;
            }
            root.right = temp;
        }
        flatten(root.right);

        
    }
}