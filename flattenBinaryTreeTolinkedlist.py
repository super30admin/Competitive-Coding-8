# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from typing import Optional


class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root is None:
            return
        
        def helper(node):
            if node is None:
                return
            
            if node.left is None and node.right is None:
                return node
            
            left = helper(node.left)
            right = helper(node.right)

            if left:  
                left.right = node.right
                node.right = node.left
                node.left = None
            
            if right:
                return right
            else:
                return left

        helper(root)