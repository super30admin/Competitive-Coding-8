# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# Time Complexity:O(h)
# Time Complexity: O(h)

class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        if root.left:
            last = self.helper(root.left)
            last.right = root.right
            root.right = root.left
            root.left = None
        root = root.right
        if root is not None:
            self.flatten(root)

    def helper(self, root):
        if not root.right:
            return root

        if root.right:
            return self.helper(root.right)
