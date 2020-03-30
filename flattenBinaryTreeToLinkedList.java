/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
Time complexity: O(N)
Space Complexity: O(H) where H is the height of tree
*/
class Solution {
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        
        flattenUtil(root);
    }
    private TreeNode flattenUtil(TreeNode root){
        if(root ==null) return null;
        //leaf node
        if(root.left == null && root.right ==null)  return root;
        //for any node recursively flatten left and right subtree. 
        //I would be getting left and right from the children
        TreeNode left = flattenUtil(root.left);
        TreeNode right = flattenUtil(root.right);
        //establishing required links. 
        if(left != null){
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return (right != null) ? right : left;
    }
}


