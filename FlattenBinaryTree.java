/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * Idea: Use recursion, preorder traversal technique, recusively obtain flattened left subtree and right subtree.
 * clear the root's left, and set its right to flattened left, then use cursor to reach to last node of flatten left and attach flatten right.
 * 
 * Leetcode Result:
 * Time Complexity: O(n)
 * Space Complexity: Constant extra space.
 * 
 */
class Solution {
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode root) {
        // base case
        if(root == null) {
            return null;
        }
        
        TreeNode flattenLeft = helper(root.left);
        TreeNode flattenRight = helper(root.right);
        root.left = null;
        root.right = flattenLeft;
        
        TreeNode cursor = root;
        while(cursor.right != null) {
            cursor = cursor.right;
        }
        cursor.right = flattenRight;
        return root;
    }
}


// Other apporach to keep track of the tail node on the fly
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    private TreeNode[] helper(TreeNode root) {
        // base case 
        if(root == null) {
            TreeNode[] result = new TreeNode[2];
            return result;
        }
        if(root.left == null && root.right == null) {
            TreeNode[] result = new TreeNode[2];
            result[0] = root;
            result[1] = root;
            return result;
        }

        
        TreeNode[] leftInfo = helper(root.left);
        TreeNode[] rightInfo = helper(root.right);
        
        root.left = null;
        
        TreeNode[] result = new TreeNode[2];
        result[0] = root;
        result[1] = root;
        
        if(leftInfo[0] != null) {
            root.right = leftInfo[0];
            result[1] = leftInfo[1];
        }
        
        if(rightInfo[0] != null) {
            result[1].right = rightInfo[0];
            result[1] = rightInfo[1];
        }
        
        return result;
    }
}