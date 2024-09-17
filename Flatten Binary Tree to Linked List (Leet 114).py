'''
Using Recursion
Time: O(n)
Space: recursive stack
'''

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
        
        if root is None:
            return None
        
        self.helper(root)
        
        
    def helper(self, root):
        if root is None:
            return
        
        if root.left is None and root.right is None:
            return
        
        if root.left:
            self.helper(root.left)
            temp = root.right
            root.right = root.left
            root.left = None
            while root.right != None:
                root = root.right
            root.right = temp
        self.helper(root.right)
        
        
        