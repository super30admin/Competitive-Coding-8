//Time complexity:- O(n)
//Space complexity:- O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        
        //Inorder traversal:- First flatten the left subtree -> root -> right subtree
        //base condition
        if(root == null)
            return;
        
        //Leaf node
        if(root.left == null && root.right == null)
            return;

        //Left subtree
        flatten(root.left);

        //restructure the subtree and go up
        TreeNode tempRight = root.right;
        root.right = root.left;
        root.left = null;

        while(root.right != null)
            root = root.right;
        
        root.right = tempRight;

        //Right subtree :- same as traversing temp right
        flatten(root.right);
    }
}