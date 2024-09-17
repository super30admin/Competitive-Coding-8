# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    TC:O(n)
    SC:O(h)+O(h) for recursive stack 
    """
    def __init__(self):
        self.prev=None
        
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.helper(root)
        return root
    
    def helper(self, root):
        # base
        if root==None:
            return
        
        # recurse
        self.helper(root.right)
        self.helper(root.left)
        
        root.right=self.prev
        root.left=None
        self.prev=root
        
        