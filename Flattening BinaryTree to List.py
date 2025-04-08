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


        if root == None:
            return []
        
        self.flatten(root.left)
        self.flatten(root.right)
        temp = root.right
        root.right = root.left
        root.left = None

        curr = root
        while curr.right:
            curr = curr.right
        
        curr.right = temp
        
# Tc : O(n)
# Sc : O(1)