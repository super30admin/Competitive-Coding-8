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
class LongestUnivaluePath {

    // Time Complexity: O(n)    (where n -> no. of nodes in the tree)
    // Space Complexity: O(h)   (where h -> height of the tree)

    private int maxLen = Integer.MIN_VALUE;
    public int longestUnivaluePath(TreeNode root) {
        // Edge Case Checking
        if(root == null)
            return 0;
        postorder(root);
        return maxLen;
    }

    private int postorder(TreeNode root){
        // Base Case
        if(root == null)
            return 0;
        int len = 0;
        // left call
        int left = postorder(root.left);   
        //right call
        int right = postorder(root.right); 
        
        // If the left value matches with the current node value --> increment the length from the left subtree
        if(root.left != null && root.left.val == root.val)
            len += left;
        // else reset the left length
        else
            left = 0;
        
        // If the right value matches with the current node value --> increment the length from the right subtree
        if(root.right != null && root.right.val == root.val)
            len += right;
        // else reset the right length
        else 
            right = 0;
        
        // Calculate the maxLength
        maxLen = Math.max(maxLen, len);
        
        // return the max of the length value from left and right subtrees + 1 (for current node)
        return Math.max(left,right)+1;
    }
}