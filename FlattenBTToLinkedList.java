/*
 * #114. Flatten Binary Tree to Linked List
 * 
 * Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6

The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

*/

/*
 * Time Complexity: O (N) -> where 'N' is the number of nodes in a Binary tree
 * 
 * Space Complexity: O (N)-> where 'N' is the child nodes of a popped node
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.competitivecoding8;

import java.util.Stack;

// Definition for a binary tree node.
class TreeNode40 {
     int val;
     TreeNode40 left;
     TreeNode40 right;
     TreeNode40() {}
     TreeNode40(int val) { this.val = val; }
     TreeNode40(int val, TreeNode40 left, TreeNode40 right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

public class FlattenBTToLinkedList {
	public void flatten(TreeNode40 root) {
        
        // #1. Base condition
        if(root == null){
            return;
        }
        
        // #2. Create a stack
        Stack<TreeNode40> stack = new Stack<>();
        
        // #3. Initiate a stack with root node
        stack.push(root);
        
        // #4. Traverse the nodes of a binary tree to flatten it
        while(!stack.isEmpty()){
            
            // #4.1. Pop the top from stack
            TreeNode40 popped = stack.pop();
            
            // #4.2. Process the children of popped node, meaning we want left node to the right of popped node, so first push right node then left node as left should be on the top of stack
            if(popped.right != null){
                stack.push(popped.right);
            }
            
            if(popped.left != null){
                stack.push(popped.left);
            }
            
            // 4.3. Get the top from stack(left node of popped) and make it as a right child of popped node
            // Check if stack is not empty before getting the top from stack
            if(!stack.isEmpty()){
                popped.right = stack.peek();
            }
            
            // 4.4. Set the left of popped node to null
            // Repeat above steps until stack is empty
            popped.left = null;
            
        }
        
    }
    
}
