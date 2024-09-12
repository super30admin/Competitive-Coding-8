// Time Complexity : O(n), n -> Number of nodes in the tree
// Space Complexity : O(n), n -> Size of recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

public class FlattenBinaryTree {
	public void flatten(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return;
		}

		if (root.left != null) {
			flatten(root.left);

			TreeNode rightNode = root.right;
			root.right = root.left;
			root.left = null;

			while (root.right != null) {
				root = root.right;
			}

			root.right = rightNode;
		}

		flatten(root.right);
	}

	private void printFlattenedTree(TreeNode root) {
		TreeNode node = root;

		while (node.right != null) {
			System.out.print(node.val + " -> ");
			node = node.right;
		}
		System.out.print(node.val);
	}

	public static void main(String[] args) {
		FlattenBinaryTree obj = new FlattenBinaryTree();

		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(5);

		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);

		root.right.right = new TreeNode(6);

		obj.flatten(root);

		System.out.println("Linked List: ");
		obj.printFlattenedTree(root);
	}

}
