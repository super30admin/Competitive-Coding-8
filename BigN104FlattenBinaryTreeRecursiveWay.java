// Time complexity is O(n)
// Space complexity is O(h)
// This solution is submitted on leetcode

public class BigN104FlattenBinaryTreeRecursiveWay {

	class Solution {
		public void flatten(TreeNode root) {
			// edge case
			if (root == null)
				return;
			if (root.left == null && root.right == null)
				return;
			if (root.left != null) {
				flatten(root.left);
				TreeNode tmp = root.right;
				root.right = root.left;
				root.left = null;
				while (root.right != null)
					root = root.right;
				root.right = tmp;
			}
			flatten(root.right);
		}
	}
}