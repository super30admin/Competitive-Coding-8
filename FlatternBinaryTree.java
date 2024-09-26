package com.recommender;

import java.util.Stack;

/*
Time Complexity: O(N) for Both Approaces
Space Complexity: O(N) for Stack,O(1) for Approach 2
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
*/

/**
 * 
 * Two Approaches have been used to flattern binarty tree to linkedlist. First
 * Approach In this approach,we find the right most node of left subtree.Link
 * the right child to this rightmost Node.After that we link the left child with
 * right child and set the left child to null
 * 
 * Second Approach It utilizes stack  to flatten the binary
 * tree.Push root node to stack value .Pop the node from stack .Let this node be
 * currentNode and check its children for null values.If children are not null
 * add it to stack Now pop node from stack and set it to right child to
 * currentNode. Set the left child of currentChild to null Keep repeating above
 * steps until all the nodes of trees are processed
 * 
 * 
 * 
 * @author sachinsharma
 *
 */
public class FlatternBinaryTree {

	public static void flatten1(TreeNode root) {
		if (root == null)
			return;
		TreeNode node = root;
		while (node != null) {
			if (node.left != null) {
				TreeNode rightNode = node.left;
				while (rightNode.right != null) {
					rightNode = rightNode.right;
				}
				rightNode.right = node.right;
				node.right = node.left;
				node.left = null;
			}
			node = node.right;
		}

		System.out.println(node);
	}

	public static void flatten(TreeNode node) {
		if (node == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();

		stack.push(node);

		while (!stack.isEmpty()) {
			TreeNode current = stack.pop();

			if (current.right != null) {
				stack.push(current.right);
			}

			if (current.left != null) {
				stack.push(current.left);
			}

			if (!stack.isEmpty()) {
				current.right = stack.peek();
			}

			current.left = null;
		}

		System.out.print(node);
	}

	public static void main(String args[]) {

		TreeNode root = new TreeNode(1);

		for (int i = 0; i < 100; i++) {
			root.left = new TreeNode(2);
			root.right = new TreeNode(5);
			root.left.left = new TreeNode(3);
			root.left.right = new TreeNode(4);
			root.right.right = new TreeNode(6);

		}
		flatten(root);
		flatten1(root);

	}
}
