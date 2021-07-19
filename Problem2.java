
// Time - O(N)
// Space - O(N)



// Used bottom-up recursion technique
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(root.left != null) {
            flatten(root.left);
            TreeNode temp = root.right; // store the bottom rightmost child
            System.out.println(temp.val + "Temp value");
            root.right = root.left; // flattening starts by making left child as right
            root.left = null;
            while(root.right != null) { // traverse the root.right list
                System.out.println(root.right.val + " root val inside while");
                root = root.right;
            }
            root.right = temp; // copy the right child with the flattened list
        }
        flatten(root.right);
    }
}