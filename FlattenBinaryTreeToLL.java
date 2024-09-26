//TC = O(N)
//SC = O(1)
public class FlattenBinaryTreeToLL
{
    public static void flatten(TreeNode root) {
        
        
        if(root == null) return;
        
        TreeNode tempLeft = root.left;
        TreeNode tempRight = root.right;
        
        
        root.left = null;
        
        
        flatten(tempLeft);
        flatten(tempRight);
        
        
        root.right = tempLeft;
        
        TreeNode curr = root;
        
        while(root.right!=null)
        {
            root=root.right;
        }
        
        root.right = tempRight;
    }

    public static void main(String args[])
    {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);

        one.left=two;
        one.right=five;

        two.left=three;

        flatten(one);

        
    }
}