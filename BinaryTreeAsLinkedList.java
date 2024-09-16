// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/*
 * 1. Idea is to move left ref of a node to right side first node.
 * 2. do DFS and do each node move left node reference to right node and make left node ref null.
 * 3. do it for both the sides of the root. 
 */

public class BinaryTreeAsLinkedList {


	public void flatten(TreeNode root) {
		//base case
		if(root==null || (root.left==null && root.right==null)) {
			return;
		}
		
		//recur on left
		if(root.left!=null) {
			flatten(root.left);
			//pop
			
			//take a ref of right
			TreeNode tempRight=root.right;
			//make left child as right child
			root.right=root.left;
			//after moving to right make it null
			root.left=null;
			
			//traverse to end of the right tree and link ref right
			while(root.right!=null) root=root.right;
			root.right=tempRight;
		}
		
		//recur on right
		flatten(root.right);
		
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);

		new BinaryTreeAsLinkedList().flatten(root);
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
