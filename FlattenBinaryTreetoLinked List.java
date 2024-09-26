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
//Time Complexity-O(n^2)
//Space Complexity-O(n)

class Solution {
    public void flatten(TreeNode root) {
        if(root==null)
        {
            return;
        }
        if(root.left==null && root.right==null)
        {
            return;
        }
        if(root.left!=null)
        {
            flatten(root.left);
            TreeNode temp=root.right;
            TreeNode cur=root.left; 
            root.right=root.left;
            root.left=null;                         
            while(cur.right!=null)
            {
                cur=cur.right;
            }
            cur.right=temp;
        }
        if(root.right!=null)
        {
            flatten(root.right);  
        }
    }
}