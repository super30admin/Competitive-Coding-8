// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Traverse the tree in preorder traversal 
// Add the nodes in a queue, now take out nodes from the queue one by one
// Assign right to the next node and left to null

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
    Queue<TreeNode> q = new LinkedList<>();
    public void flatten(TreeNode root) {
        preorder(root);
        TreeNode node = null;
        TreeNode root1 = null;
        while(!q.isEmpty()){
            node = q.poll();
            if(root1 == null){
                root1  = node;
            }
            else{
                root1.left = null;
                root1.right = node;
                root1 = root1.right;
            }
        } 
        if(root1 != null){
            root1.left = null;
            root1.right = null;    
        }    
    }
    private void preorder(TreeNode root){
        if(root != null)
            {
        q.add(root);
        preorder(root.left);
        preorder(root.right);
        }
    }
}