'''
TC: O(n) - to all nodes in the tree
SC: O(1) - I'm moving in-place so no additional space required.
'''
# Definition for a binary tree node.
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """

        def dfs(root):
            if not root:
                return None
            left = dfs(root.left)
            right = dfs(root.right)
            if not left and not right:
                return root
            if not left and right:
                return root
            flattened_nodes = left
            while left.right != None:
                left = left.right
            left.right = right
            root.right = flattened_nodes
            root.left = None
            return root

        dfs(root)