public class FlattenBinaryTree {
	static class TreeNode {
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

	public void flatten(TreeNode root) {
		// base
		if (root == null)
			return;

		if (root.left == null && root.right == null)
			return;

		// logic
		if (root.left != null) {

			flatten(root.left);

			TreeNode tempNodeRight = root.right;
			root.right = root.left;
			root.left = null;

			TreeNode curr = root.right;
			while (curr.right != null)

				curr.right = tempNodeRight;

		}
		flatten(root.right);

	}

	public static void main(String[] args) {

		TreeNode left1 = new TreeNode(3, null, null);
		TreeNode right1 = new TreeNode(4, null, null);
		TreeNode right2 = new TreeNode(6, null, null);
		TreeNode right = new TreeNode(5, null, right2);
		TreeNode left = new TreeNode(2, left1, right1);
		TreeNode root = new TreeNode(1, left, right);

		FlattenBinaryTree f = new FlattenBinaryTree();
		f.flatten(root);

	}
}
