// Time Complexity :O(n)
// Space Complexity :O(max depth)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach-
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
        if(root==null)
            return ;
        TreeNode start = root;
        while(start!=null){
            if(start.left!=null){//traversing left subtree and finding the right most in left subtree.
                TreeNode p=start.left;
                while(p.right!=null){
                    p=p.right;
                }
                TreeNode temp=start.right;
                start.right=start.left;
                p.right=temp;
                start.left=null;
            }
            start=start.right;//traversing to the right
        }
  
    }
}
