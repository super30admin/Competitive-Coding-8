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
class FlatternBinaryTreeToLinkedList {    
    // Morris Tree Traversal
    // Time Complexity: O(n)    (where n -> no. of nodes in the tree)
    // Space Complexity: O(1)
    
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        
        while(curr != null){
            if(curr.left != null){
                TreeNode left = curr.left;
                while(left.right != null)
                    left = left.right;
                left.right = curr.right;        
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}