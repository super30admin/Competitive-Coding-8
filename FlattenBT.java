// Time Complexity : O(n*2) n for recursive calls and n for finding the end of right to place the temp node.
// Space Complexity : O(n) for recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//check the base cases and recursively call the left and right of root till last root which have children
//and then store the root's right as temp, make the root's left as right
//have to find the end of curr root's right now to append the temp node(old right)

class Solution {
    public void flatten(TreeNode root) {
        
        if (root==null) return;
        if (root.left==null && root.right==null) return;
        
        flatten(root.left);
        flatten(root.right);
        //recursive
        
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left=null;
        while(root.right!=null){
            root=root.right;
        }
        root.right=tmp;
        
        return;
        
    }
}