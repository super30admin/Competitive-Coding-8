# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.helper(root)

    def helper(self, root):

        if not root:
            return

        if not root.left and not root.right:
            return root

        left = self.helper(root.left)
        right = self.helper(root.right)

        if left:
            left.right = root.right
            root.right = root.left
            root.left = None

        if right:
            return right
        else:
            return left
