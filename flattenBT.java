//Time Complexity : O(N) 
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * One approach is to find the preorder of the tree and just append all nodes to
 * the root on the right and move the root to root.right.
 * 
 * Second approach is to start from the root. If there is a left node, then find
 * the right most node on the left subtree. Attach the right of root to this
 * node and move the entire left subtree to the right and make left as null and
 * then move root to root.right.
 *
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode prev = curr.left;
                while(prev.right != null){
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
