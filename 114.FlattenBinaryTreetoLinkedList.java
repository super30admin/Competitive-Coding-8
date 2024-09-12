// SC: O(N)
//TC: O(N)

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
        if(root == null || root.left == null && root.right == null) return;
        
        if(root.left != null){
            flatten(root.left);
            TreeNode tempright = root.right;
            root.right = root.left;
            root.left = null;
            while(root.right != null)root = root.right;
            root.right = tempright;
                
        }
        
        flatten(root.right);
        
        
    }
}



//using stack

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
        
        if(root == null) return;
        
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode current_node = stack.pop();
            if(current_node.right != null){
                stack.push(current_node.right);
            }
            if(current_node.left != null){
                stack.push(current_node.left);
            }
            
            if(!stack.isEmpty()){
                current_node.right = stack.peek();
            }
            current_node.left = null;
        }
        
    }
}