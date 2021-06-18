/* Approach: 
1. Since we want to modify the left child of evry node and set it to null, it is better to traverse the tree in right, left, node manner.
2. We need to keep the track of every nodes right child and use it later on, so we can just add it to the stack. 

Time complexity: O(N)
Space complexity: O(very few nodes will be in the stack at a particular time)
*/
public class FlattenBinaryTreeIterative {
    Stack<TreeNode> stack = new Stack<>();
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        stack.add(root);
        traverseAndModify(root);
    }
    
    private void traverseAndModify(TreeNode root)
    {
        TreeNode tempNode;
        TreeNode currentNode;
        while(!stack.isEmpty())
        {
            currentNode = stack.pop();
            if(currentNode.right!=null)
                stack.push(currentNode.right);
            if(currentNode.left!=null)
                stack.push(currentNode.left);
            if(!stack.isEmpty()) //we are checking if the stack is empty here because in the end, for the last element, stack would be empty.
            {
                tempNode = stack.peek(); //we just peek here because we need the node left node here to make it the right node (top element will always be the left child of the current root), but we don't want to remove it because its children have not been processed 
                currentNode.right = tempNode;
                currentNode.left = null;
            }
        }
    }
}
