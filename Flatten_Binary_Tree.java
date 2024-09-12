
// Time Complexity :O(n)
// Space Complexity :O(maxDepth)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public void flatten(TreeNode root) {
        if(root==null||root.left==null && root.right==null){
            return;
        }
        if(root.left!=null){
            flatten(root.left);
            TreeNode temp = root.right;
            root.right=root.left;
            root.left=null;
            while(root.right!=null){
                root=root.right;
            }
            root.right=temp;
        }
        flatten(root.right);
    }
}