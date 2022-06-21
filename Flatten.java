/**
Time Complexity : O(N)
Space Complexity : O(D) depth of the tree
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    public void flatten(TreeNode root) 
    {
        dfs(root);
    }
    
    private void dfs(TreeNode root)
    {
        if(root == null || (root.left == null && root.right ==null))
            return;
        
        dfs(root.left);
        TreeNode right = root.right;
        
        root.right = root.left;
        root.left = null;
        
        TreeNode temp = root;
        while(temp.right != null)
        {
            temp = temp.right;
        }
        
        temp.right = right;
        
        dfs(right);
        
    }
    
}