// Time Complexity : O(n), number of nodes
// Space Complexity : O(h), recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**we iterate over the tree and will recursively call the first flattening the left part and linking it to right of root
 * and then flattening the remaining right part
 * */

// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}


public class Flatten_Binary_Tree_to_Linked_List {
	public void flatten(TreeNode root) {
		//base case
		if(root == null || root.left == null && root.right == null) // if root becomes null or we reach leaf node
			return;

		//recursive case
		if(root.left != null){
			flatten(root.left); // flattening the left first

			TreeNode tempRight = root.right;     // point a temp to root's right
			root.right = root.left; // shift root left to root right
			root.left = null;   // make root left as null   

			while(root.right != null){  // iterate over the added nodes to root right till we hit null
				root = root.right;
			}

			root.right = tempRight;     // now point the root right to the initially right subtree marked by temp
		}
		flatten(root.right);   // flattening the root's right
	}
}
