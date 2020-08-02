// Time Complexity : O(n), n is number of nodes
// Space Complexity : O(logn) height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



//TC : O(n)
//SC : O(logn) height of tree
//Using DFS
class Solution {
    //keep a global max 
    int maxsum;
    public int maxPathSum(TreeNode root) {
        //set to -infinity
        maxsum = Integer.MIN_VALUE;   
        //call helper method on root
        helper(root);
        //max will have max path in the end
        return maxsum; 
    }
    
    private int helper(TreeNode root) {
        //base case, when root = null, sum till root will be 0
        // so return 0
        if(root == null) {
            return 0; 
        }
        
        //max sum of a root, will be
        //max between : including left (or 0 if -ve)
        //including right (or 0 if -ve)
        //so find left and right recursively from leaf node
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        
        //even if all numbers are negative, we will get maxsum = least negative number
        //when left/right is called on a leaf node, leaf nodes children are null (returns 0)
        //and its val is root.val, so maxsum will check single node sum as well
        //else maxsum chooses between prev maxsum and 
        //curr sum (left/right becomes 0, if sum of its subtree is -ve)
        maxsum = Math.max(maxsum, left+right+root.val);
        
        //return sum to recursive call (returns maxsum formed until the root (root.val + left/right))
        return root.val + Math.max(left, right);      
        
    }
}
