/*
Time: O(H) height of tree
Space: O(1) No extra space is used
*/
class Solution {
    public void flatten(TreeNode root) {
        construct(root);
    }
    
    public void construct(TreeNode root) {
        //Base
        if (root == null) return;
        
        //Logic
        //if no left then we can go ahead with right node
        if (root.left == null) {
            construct(root.right);
        }
        else {
            //Otherwise store the right in temp variable
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            construct(root.right);
            while (root.right != null) {
                root = root.right;
            }
            root.right = temp;
            construct(root.right);
        }
    }

}
