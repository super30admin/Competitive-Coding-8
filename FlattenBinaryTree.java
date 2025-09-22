import javax.swing.tree.TreeNode;

public class FlattenBinaryTree {
    //Idea is to use Morris Inorder traversal to find the left sub child's right most child point.
    //Make the right child of original node become the right child of found node
    //and make the left sub tree to be right sub tree. In this way all the elements on the left sub tree 
    //move to right side
    
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public TreeNode findlast(TreeNode root)
    {
        while(root.right!=null)
        {
            root=root.right;
        }
        return root;
    }
    public void helper(TreeNode root)
    {
        if(root.left != null)
        {
            TreeNode last = findlast(root.left);
            last.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        root = root.right;
        if(root!= null)
        {
            helper(root);
        }
    }
    public void flatten(TreeNode root)
    {
        if(root!= null)
        {
            helper(root);
        }
    }
}
