//TC: O(n)
//SC:O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    Stack<TreeNode> st;
    public void flatten(TreeNode root) {
        if(root==null)
        return;
        this.st=new Stack<>();
        dfs(root);
        root=st.pop();
        root.left=null;
        root.right=null;
        TreeNode curr=root;
        while(!st.isEmpty())
        {
            TreeNode temp=st.pop();
            temp.left=null;
            temp.right=curr;
            curr=temp;
        }

        return;
    }
    private void dfs(TreeNode root)
    {
        if(root==null)
        return;
        st.push(root);
        dfs(root.left);
        dfs(root.right);
    }
}