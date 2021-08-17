Flatten Binary Tree to Linked List

        Given the root of a binary tree, flatten the tree into a "linked list":

        The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
        The "linked list" should be in the same order as a pre-order traversal of the binary tree.

        Example:
        Input: root = [1,2,5,3,4,null,6]
        Output: [1,null,2,null,3,null,4,null,5,null,6]

// Time Complexity : O(N) number of nodes in the Tree
// Space Complexity : O(N) recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


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
    public void flatten(TreeNode root) {
        if(root==null) return ;

        if(root.left==null && root.right==null)
            return ;

        TreeNode ans =  helper(root);

    }

    private TreeNode helper(TreeNode root){
        if(root==null) return root;

        if(root.left==null && root.right==null)
            return root;

        TreeNode leftNode = helper(root.left);
        TreeNode rightNode = helper(root.right);
        if(leftNode!=null){
            leftNode.right=root.right;
            root.right = root.left;
            root.left = null;

        }
        if(rightNode!=null){
            return rightNode;
        } else
            return leftNode;


    }
}

Approach 2-------------------------- Using Stack
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
    public void flatten(TreeNode root) {
        if(root==null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if(curr.right!=null)
                stack.push(curr.right);
            if(curr.left!=null)
                stack.push(curr.left);
            if(!stack.isEmpty())
                curr.right= stack.peek();
            curr.left=null;
        }
    }
}