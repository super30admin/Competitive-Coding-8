//Flatten Tree to Linked List
//TC - O(n)
//SC - O(h)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public void flatten(TreeNode root) {
        dfs(root);
    }
    
    private TreeNode dfs(TreeNode root)
    {
        //base
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;
        
        //logic
        TreeNode l = dfs(root.left);
        TreeNode r = dfs(root.right);
        
        TreeNode temp = l;
        
        if(temp != null)
        {
            while(temp.right != null)
                temp = temp.right;
            
            temp.right = r;
            
            root.right = l;
        }
        
        root.left = null;
        
        return root;
    }
}
