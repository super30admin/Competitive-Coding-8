# https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

# TC: O(n)
# SC: O(1)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    temp = None
    def flatten(self, root: Optional[TreeNode]) -> None:
        self.helper(root)

    def helper(self, root):
        if root is None:
            return None

        self.helper(root.right)
        self.helper(root.left)
        root.left = None
        root.right = self.temp
        self.temp = root
