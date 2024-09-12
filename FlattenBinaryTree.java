<---Recursive---> TC: O(n) SC: O(h)
class Solution {
    public void flatten(TreeNode root) {
	//base
        if(root==null || root.left==null && root.right==null)
            return;
	//logic
        if(root.left!=null) //convert left part into singly linked list
        {
            flatten(root.left); // recursive funtion on left subtree
            TreeNode tempright = root.right; // pointing right node of the root node
            root.right = root.left; // singly list which we have converted
            root.left=null; // make left null
            while(root.right!=null)
		 root = root.right; // keep iterating
            root.right = tempright; // make the tempright as our right node
        }
        flatten(root.right); // call recursively on the right part
    }
}

<----Iterative-----> TC: O(n), SC: O(n)
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