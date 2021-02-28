/**

LeetCode 114 Flatten Binary Tree to Linked List

This question is being solved by inorder tree traversal

if (root == null) || (root.left == null && root.right == null)
return;

**/
class Solution 
{
    public void flatten(TreeNode root) 
    {
        if( root == null || ( root.left == null && root.right == null))
            return;
            
        flatten(root.left);
        
        TreeNode tempNode = root.right;
        
        root.right = root.left;
        
        root.left = null;
        
        TreeNode temp = root.right;
        
        while(root.right != null)
        {
            root = root.right;
        }
        
        root.right = tempNode;
        
        flatten(root.right);
    }
}