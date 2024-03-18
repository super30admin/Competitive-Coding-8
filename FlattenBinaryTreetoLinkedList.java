
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Solution23 {
	TreeNode left;
	TreeNode right;

	public void flatten(TreeNode root) {
		helper(root);
	}

	private void helper(TreeNode root) {
		// base
		if (root == null)
			return;
		helper(root.left);
		helper(root.right);
		flattenhelper(root, root.left, root.right);

	}

	private void flattenhelper(TreeNode root, TreeNode left2, TreeNode right2) {
		if (root != null && root.left != null && root.right != null) {
			TreeNode temp = root.right;
			root.right = root.left;
			TreeNode curr = root.left;
			while (curr.right != null) {
				curr = curr.right;
			}
			curr.right = temp;
			root.left = null;
		}
		else if(root.right==null){
            root.right = root.left;
            root.left = null;
        }

	}
}

public class FlattenBinaryTreetoLinkedList {

	public static void main(String[] args) {
		// Construct the binary tree
		TreeNode node8 = new TreeNode(8, null, null);
		TreeNode node7 = new TreeNode(7, null, node8);
		TreeNode node6 = new TreeNode(6, null, null);
		TreeNode node5 = new TreeNode(5, null, null);
		TreeNode node4 = new TreeNode(4, node5, node6);
		TreeNode node3 = new TreeNode(3, null, null);
		TreeNode node2 = new TreeNode(2, node3, node4);
		TreeNode node1 = new TreeNode(1, node2, node7);

		// Set root of the binary tree
		TreeNode root = node1;

		// Call the flatten method
		Solution23 solution = new Solution23();
		solution.flatten(root);

		// Print the flattened tree
		// printFlattenedTree(root);
	}

	// Helper method to print the flattened tree
	private static void printFlattenedTree(TreeNode root) {
		TreeNode current = root;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.right;
		}
	}
}
