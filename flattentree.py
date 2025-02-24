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
            return None
        if not root.left and not root.right:
            return root
        last_left = self.flatten(root.left)
        last_right = self.flatten(root.right)
        if last_left:
            last_left.right = root.right
            root.right = root.left
            root.left = None
        
        return last_right if last_right else last_left