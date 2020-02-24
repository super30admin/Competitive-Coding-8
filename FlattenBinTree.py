"""
Time Complexity : O(n)
Space Complexity : O(1) - [O(h) - stack space, where h is the height of the tree]
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # base case
        if not root:
            return
        if not root.left and not root.right:
            return
        
        # logic
        if root.left:
            self.flatten(root.left)
            temp = root.right
            root.right = root.left
            root.left = None
            while root.right:
                root = root.right
            root.right = temp
            
        self.flatten(root.right)
        