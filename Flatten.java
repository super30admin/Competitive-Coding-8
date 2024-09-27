//Time Complexity: O(n)
//Space Complexity:O(h)
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
/*
public void flatten(TreeNode root) {
    flatten(root,null);
}
private TreeNode flatten(TreeNode root, TreeNode pre) {
    if(root==null) return pre;
    pre=flatten(root.right,pre);    
    pre=flatten(root.left,pre);
    root.right=pre;
    root.left=null;
    pre=root;
    return pre;
}*/
class Solution {
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        
        if(root== null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
        return ;
    }
    
}
