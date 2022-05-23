
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//we can solve this question also by using queue level order traversal
//we need to make current node as right child of previous node and left of previous node as null
//but it rquires extra space, which cannot be used
//so we call function recursively.
public class Solution {
    public void Flatten(TreeNode root) {
        
        if(root == null)
            return;
        
        if(root.left == null && root.right == null)
            return;
        
        if(root.left != null)
        {
            //move left recusively
            Flatten(root.left);
            
            //store node right in to temp
            //then move node left to node right
            // and make node left to null, that way node left part moves to right and left becomes null
            var temp = root.right;
            root.right = root.left;
            root.left = null;
            
            //move all the way to right node to insert temp right node from above
            var curr = root.right;
            while(curr.right != null)
            {
                curr = curr.right;
            }
            
            curr.right = temp;
        }
        
        //call flatten receursively again on right node
        Flatten(root.right);
    }
}