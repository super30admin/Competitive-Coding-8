# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#TC : O(n)
#SC : O(h)
class Solution:
    def __init__(self):
        self.prev = None
    
    def dfs(self,root):
        if root is None:
            return
        
        self.dfs(root.right) # Traverse through right nodes first and then the left
        self.dfs(root.left)
        
        root.right = self.prev # Make right of root as prev and make left Null
        root.left = None
        self.prev = root # Update prev to current root
    
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.dfs(root)
        