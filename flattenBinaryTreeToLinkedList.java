// Time Complexity: O(n) where n is the number of nodes in the tree
// Space Complexity: O(1) ; we are using Morris Traversal which doesnt take up any additional space
//executed on leetcode: yes

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
        TreeNode current = root;
        while(current!=null)
        {
            if(current.left==null) current=current.right;
            else
            {
              TreeNode rightmost = current.left; //we are finding the rightmost node with no right child
                while(rightmost.right!=null) 
                {
                    rightmost = rightmost.right;
                }
                rightmost.right = current.right;
                
                current.right = current.left;
                current.left = null;
                current = current.right;
            }
            
        }
    }
}


// Time Complexity: O(n) 
// Space Complexity: O(n)
//executed on leetcode: yes
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
        if(root==null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty())
        {
            TreeNode current = stack.pop();
            if(current.right!=null) stack.push(current.right);
            if(current.left!=null) stack.push(current.left);
            if(!stack.isEmpty()) current.right = stack.peek();
            current.left = null;
        }
    }
}