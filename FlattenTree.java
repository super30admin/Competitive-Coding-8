import java.util.*;

    // Time Complexity : O(N) N is number of nodes in tree 
    // Space Complexity : O(H) H is height of the tree
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    /**
     * Approach:
     * 1. Flatten left children tree and add as right children of the node.
     * 2. Meanwhile store the right children of the node in stack which gets flattened later and gets assigned as
     * flatten left tree's right child.
     */


public class FlattenTree {

    public void flatten(TreeNode root) {
        
        if(root == null)
            return;
        
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root);
        
        while(!stack.isEmpty()) {
            
            TreeNode node = stack.pop();
            
            if(node.right != null){
                stack.push(node.right);
            }
            
            if(node.left != null) {
                stack.push(node.left);
            }
            
            if(!stack.isEmpty()) {
                node.right = stack.peek();
            }
            
            node.left = null;
            
        }
        
    }
    
}