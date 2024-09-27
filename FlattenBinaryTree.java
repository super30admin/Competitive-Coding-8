
// Time Complexity :  O(N) maze dimensions
// Space Complexity : O(1) total elements in the pattern string
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


class Solution {
    public void flatten(TreeNode root) {
         TreeNode cur = root;
         TreeNode prev = null;
         while(cur != null){
             if(cur.left == null) cur = cur.right;
             else {
                 prev = cur.left;
                 while(prev.right != null) prev = prev.right;
                 prev.right = cur.right;
                 cur.right = cur.left;
                 cur.left = null;
             }
         }
     }
 }

 //Postorder soln O(N) SpaceO(N)
// class Solution{
//     private TreeNode prev = null;

//     public void flatten(TreeNode root) {
//         if (root == null)
//             return;
//         flatten(root.right);
//         flatten(root.left);
//         root.right = prev;
//         root.left = null;
//         prev = root;
//     }
// }