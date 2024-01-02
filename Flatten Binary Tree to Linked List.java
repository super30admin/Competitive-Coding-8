// Time Complexity: O(n)
// Space Complexity: O(1)
// Iterative Approach
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode curr = root;

        while(curr != null){
            TreeNode temp = curr.left;
            if(curr.left != null){
                while(temp.right != null){
                    temp = temp.right;
                }
                temp.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
       
        
    }
}

// Time Complexity: O(n)
// Space Complexity: O(h)
// Recursive Approach
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode temp;
        if(root.left != null){
            temp = root.left;
            while(temp.right != null) temp = temp.right;
            temp.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
    }
}