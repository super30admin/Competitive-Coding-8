//APPROACH-1
// Time Complexity : O(N)...
// Space Complexity :O(H) where h is the height of the stack
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
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
        Stack<TreeNode> stack = new Stack<>();
      
      TreeNode current = root;
      
      while(current != null)
      {
            //first put the right child to the stack
            if(current.right!= null)
            {
              stack.push(current.right);
            }
            //put the left child to the stack
            if(current.left!= null)
            {
              stack.push(current.left);
            }
            //we have the left child of the current node at the top of the stack so move it to the right
	        if(!stack.isEmpty())
	        {
	           current.right = stack.pop();
	        }
	        //nullify the left side of the tree
          current.left = null;
          //move to the next level
          current = current.right;
      }
     
    }
}

//APPROACH-2
// Time Complexity : O(N)...
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


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
      
      //get the root
      TreeNode node = root;
      //until we reach the end while making it right skewed tree
      while(node != null)
      {
      	//if we have a left child for the current node
        if(node.left != null)
        {
        //for that left child we want to find the right most element which we will use to connect the right tree to the left tree
          TreeNode current = node.left;
          while(current.right!=null)
          {
          	//here we get the right most element of the left tree for the current node
            current = current.right;
          }
          //get the right subtree in temp
          TreeNode temp = node.right;
          //make the left subtree at the right tree
          node.right = node.left;
          //connect the previous right tree to the right most node
          current.right= temp;
          //nullify the left tree
          node.left=null;
          
        }
        //go to the next level towards the right as we already nullified the left for the current node
        node = node.right;
      }
        
    }
}