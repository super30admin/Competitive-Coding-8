//Time complexity: O(N)
//Space complexity: O(N)
class Solution {
    public void flatten(TreeNode root) {
        //base
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            return;
        }

        //logic
        if(root.left != null) {
            flatten(root.left);
            //store the right node in temp
            TreeNode temp = root.right;
            //the left will become the right
            root.right = root.left;
            root.left = null;
            while(root.right != null) {
                root = root.right;
            }
            root.right = temp;
        }
        flatten(root.right);
    }
}