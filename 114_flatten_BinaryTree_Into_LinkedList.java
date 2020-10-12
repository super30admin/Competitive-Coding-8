    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/minimum-window-substring/
    Time Complexity for operators : o(n) .. n is the length of the string
    Extra Space Complexity for operators : o(n)
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Two for loops and find the minimum window that has string. o(n*2) time complexity
        # Optimized approach: 
                              
            # 1. 
                    A) 
    */ 
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
        

           helper(root);
        
//         Stack<TreeNode> stack = new Stack<>();
        
//         TreeNode curr = root;
//         stack.push(root);
        
//         while(!stack.isEmpty()){
//             System.out.println(stack.peek().val);
//             TreeNode popped = stack.pop();
            
//             curr = popped;
//             curr = curr.right;

//             if(popped.right!=null)
//                 stack.push(popped.right);
            
//             if(popped.left!=null)
//                 stack.push(popped.left);
//         } 
        
    }
    
    private TreeNode helper(TreeNode root){
        
        if(root == null)
            return null;
       
        if(root.left == null && root.right == null)
            return root;
        
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        
        if(left!=null){
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        return right == null ? left : right;
    }
}