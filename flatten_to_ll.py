# Time Complexity: O(n), where n - number of nodes in the tree
# Space Complexity: O(n), recursion stack

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional


class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """

        if not root or (not root.left and not root.right):
            return None

        self.flatten(root.left)

        temp = root.right
        root.right = root.left
        root.left = None

        while root.right:
            root = root.right

        root.right = temp
        self.flatten(root.right)
