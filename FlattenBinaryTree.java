package CompetitiveCoding8;
//TC : o(n)
//SC : o(n)
public class FlattenBinaryTree {
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
	        
	        if(root == null || root.left == null && root.right == null) return;
	        
	        //logic
	        if(root.left!=null){
	            flatten(root.left);
	            TreeNode tempNode = root.right;
	            root.right = root.left;
	            root.left = null;
	            while(root.right!=null){
	                root = root.right;
	            }
	            root.right = tempNode;
	        }
	        flatten(root.right);
	    }
	}
}
