import java.util.Stack;

// Time complexity is O(n)
// Space complexity is O(h)
// This solution is submitted on leetcode

public class BigN104FlattenBinaryTreeIterativeStack {

	class Solution {
		public void flatten(TreeNode root) {
			// Iterative solution
			// base case
			if (root == null)
				return;
			Stack<TreeNode> st = new Stack<>();
			st.push(root);
			while (!st.isEmpty()) {
				TreeNode curr = st.pop();
				if (curr.right != null)
					st.push(curr.right);
				if (curr.left != null)
					st.push(curr.left);
				if (!st.isEmpty()) {
					curr.right = st.peek();
				}
				curr.left = null;
			}
		}
	}
}