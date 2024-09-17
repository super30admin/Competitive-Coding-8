// Time Complexity : O(N)
// Space Complexity : O(N)
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

class Problem1 {
        public void flatten(TreeNode root) {
            dfs(root);
        }

        TreeNode dfs(TreeNode root){

            //Base conditions
            if(root == null)
                return null;

            //leaf nodes - base case
            if(root.left == null && root.right == null){
                return root;
            }

            //find the last left node and last right node
            TreeNode leftTail = dfs(root.left);
            TreeNode rightTail = dfs(root.right);

            //if left tree is present, remove and put it on root's right -> leftTail's right will connect to root's right
            if(leftTail!=null){
                leftTail.right = root.right;
                root.right = root.left;
                root.left = null;

                return rightTail == null?leftTail: rightTail;
            }
            //if rightTail is null, return root
            return rightTail == null? root: rightTail;

        }
    } 