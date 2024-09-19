#Tiem complexity - O(n)
# Space complexity = O(h)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return root

        def helper(root):
            if not root:
                return None

            if not root.left and not root.right:
                return root

            left = helper(root.left)
            right = helper(root.right)
