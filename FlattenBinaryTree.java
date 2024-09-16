// Time complexity: O(N)
// Space Complexity: O(max Depth)

class Solution {
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    public void flatten(TreeNode root) {
        TreeNode node= root;
        
        while(node != null)   
        {
            if (node.left!=null)
            {
                TreeNode rightmost = node.left;
                while(rightmost.right != null)
                    rightmost = rightmost.right;
                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            else
            {
                node = node.right;
            }
        }
        
    }
}