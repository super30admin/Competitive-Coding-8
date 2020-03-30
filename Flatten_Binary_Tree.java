/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Time: O(n)
//Space: O(h)

//Iterartive Solution
class Solution {

    public void flatten(TreeNode root) {
        
        if(root == null)
            return;
        
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        
        while(!stk.isEmpty())
        {
           TreeNode current = stk.pop();
           if(current.right != null)
               stk.push(current.right);
           if(current.left != null)
               stk.push(current.left);
           if(!stk.isEmpty())
           {
             current.right = stk.peek();  
           }
            current.left = null;
        }

        
    }
}
