"""
Leetcode: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

Approach 1: Recursion
Time Complexity: O(N) since we process each node of the tree exactly once.
Space Complexity: O(N) which is occupied by the recursion stack. The problem statement doesn't mention
    anything about the tree being balanced or not and hence, the tree could be e.g. left skewed
    and in that case the longest branch (and hence the number of nodes in the recursion stack) would be N.
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:

    def flattenTree(self, node):

        # Handle the null scenario
        if not node:
            return None

        # For a leaf node, we simply return the
        # node as is.
        if not node.left and not node.right:
            return node

        # Recursively flatten the left subtree
        leftTail = self.flattenTree(node.left)

        # Recursively flatten the right subtree
        rightTail = self.flattenTree(node.right)

        # If there was a left subtree, we shuffle the connections
        # around so that there is nothing on the left side
        # anymore.
        if leftTail:
            leftTail.right = node.right
            node.right = node.left
            node.left = None

        # We need to return the "rightmost" node after we are
        # done wiring the new connections.
        return rightTail if rightTail else leftTail

    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.flattenTree(root)


# Approach 2: Iterative Solution using Stack
# Time Complexity: O(N) since we process each node of the tree exactly once.
# Space Complexity: O(N) which is occupied by the recursion stack. The problem statement doesn't mention
#     anything about the tree being balanced or not and hence, the tree could be e.g. left skewed
#     and in that case the longest branch (and hence the number of nodes in the recursion stack) would be N.


class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # Handle the null scenario
        if not root:
            return None

        # Initialize stack with root
        stack = [root]

        while stack:
            node = stack.pop()
            # push right subtree first so that left will be popped first from stack
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)

            # make left of root as None
            node.left = None
            # make right of root as left since last node pushed to stack is root's left node
            node.right = stack[-1] if stack else None