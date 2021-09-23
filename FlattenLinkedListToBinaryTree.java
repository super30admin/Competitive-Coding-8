

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*Approach
1) in this we use a stack and a pre order traversal
2) Here we use a modified traversal
3) We create a node pre and assign it to -1
4) Once we do we start pushing elements in stack starting with root
5) we pop and append it to linked list
6) Once we do that we proceed with putting the right node first and then the left node

TreeNode node = stack.pop();
            pre.right = node;
            pre.left=null;
            

            // we put the right node first if not null
            if(node.right!=null)
            {
                stack.push(node.right);
            }
            if(node.left!=null)
            {
                stack.push(node.left);
            }


7) as it is a stack, LIFO Approach we need left first thus we dont want them to go down the stack.
*/


public class FlattenLinkedListToBinaryTree{
    public void flatten(TreeNode root) {
        
        if(root==null)
            return ;
        
        
        
        Stack<TreeNode> stack = new Stack();
        
        TreeNode pre = new TreeNode(-1);
        
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            pre.right = node;
            pre.left=null;
            
            if(node.right!=null)
            {
                stack.push(node.right);
            }
            if(node.left!=null)
            {
                stack.push(node.left);
            }
            
            pre=node;
            
            
        }
        
        
        
    }
}
