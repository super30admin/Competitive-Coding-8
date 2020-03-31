/**
 ========================= Iterative ==============================
Time: O(N), space: O(H) space
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root == null)
            return; 
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            
            // push node's right first and then left to stack
            if(curr.right != null)
                stack.push(curr.right);
            
            if(curr.left != null)
                stack.push(curr.left);
            
            //connect current node to top of the stack
            if(!stack.isEmpty()) {
                curr.right = stack.peek();
            }
            //make left node null
            curr.left = null;
        }
    }
}

/*
 ========================= Recursive ==============================
 Time: O(N), space: O(H) recursive stack space
*/
class Solution {
    public void flatten(TreeNode root) {
        if(root == null)
            return; 
        if(root.left == null && root.right == null)
            return;
        // flatten left subtree first and initialize left child to right and iterate till the rightmost node in tree
        // Now connect its right to the right subtree and process it
        if(root.left != null) {
            flatten(root.left);
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;
            while(root.right != null)
                root = root.right;
            root.right = right;
            }
        flatten(root.right);
    }
}