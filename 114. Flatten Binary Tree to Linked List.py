T = O(n)
S = o(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root or (not root.right and not root.left):
            return
            
        if root.left:
            self.flatten(root.left)
            temp = root.right
            root.right = root.left
            root.left = None
            while root.right:
                root = root.right
            root.right = temp
        self.flatten(root.right)