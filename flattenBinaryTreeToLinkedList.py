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
        def helper(root):
            #base case
            if not root:
                return root

            l = helper(root.left)
            r = helper(root.right)
            if root.left:
                l.right = root.right
                root.right = root.left
            root.left = None
            return r or l or root
        helper(root)
        return root