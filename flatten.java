/**
 * Time Complexity: O(n^2) in the worst case where the tree is skewed.
 * - Finding the rightmost node of the left subtree involves traversing potentially down the entire height of the tree for each node.

 * Space Complexity: O(1)
 * - The algorithm uses only a constant amount of extra space for pointers and does not require additional space proportional to the input size.
 */

class Solution {
    public void flatten(TreeNode root) {
        
        TreeNode current=root;
        while(current!=null){
            if(current.left!=null){
                TreeNode pred=current.left;
                while(pred.right!=null){
                    pred=pred.right;
                }
                pred.right=current.right;
                current.right=current.left;
                current.left=null;
            }
            current=current.right;
        }
        
        
    }
}