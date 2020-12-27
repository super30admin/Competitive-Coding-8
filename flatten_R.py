"""
TC is O(N)
SC is O(H) where H is height of tree
"""


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
        #base 
        
        if(root is None or root.left is None and root.right is None):
            return 
        
        #logic
        if root.left:
            self.flatten(root.left)
            ptr=root.right
            root.right=root.left
            root.left=None
            while root.right:
                root=root.right
            root.right=ptr
            
        self.flatten(root.right)