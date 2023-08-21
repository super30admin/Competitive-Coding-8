// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes

public class FlattenBT {
    public void flatten(TreeNode root) {

        helper(root);

    }

    public void helper(TreeNode root){
        //base
        if(root == null) return ;

        //logic
        helper(root.left);
        helper(root.right);

        TreeNode curr = root.left;
        while(curr!=null && curr.right!=null)
        {
            curr = curr.right;  // find the rightmost element
        }

        if(curr!=null)  // append left to right
        {
            curr.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}