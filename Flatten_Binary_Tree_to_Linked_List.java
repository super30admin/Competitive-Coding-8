// Time Complexity : O(n), number of nodes
// Space Complexity : O(logn) stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



//TC : O(n)
//SC : stack space
//Recursively, flatten left subtree first and then right subtree
//after flattening left st, store right subtree in temp node and make root.right = root.left and make root.left = null
//then move to leaf and then attach the tempnode (root.right) to the leaf node and call flatten on this
class Solution {
    public void flatten(TreeNode root) {
        //base case,
        //if root is null or root is leaf return 
        if(root == null || root.left == null && root.right == null) return;
        
        //go to left subtress
        while(root.left != null) {
            //and call flatten method
            flatten(root.left);
            //when returned from base case,
            //store right subtree in a temp node
            TreeNode tempRight = root.right;
            //and make the roots right = the flattened left subtree
            root.right = root.left;
            //point the roots left to null
            root.left = null; 
            //go to the leaf node 
            while(root.right != null) {
                root = root.right;
            }
            //and attach the temp node here
            root.right = tempRight;
            //flatten this part now
            //root left is null (as subtress are already flattened)
            //so comes out of while loop and calls flatten on root.right
        }
        //calls flatten on right subtree tree (which was saved in temp Node)
        flatten(root.right);
               
    }
}
