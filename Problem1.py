#Time Complexity :- O(n)
#Space Complexity :- O(1)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    prev = None
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.dfs(root)
        
    
    def dfs(self, root):
        if root == None:
            return
        
        self.dfs(root.right)
        self.dfs(root.left)
        if self.prev!=None:
            root.left = None
            root.right = self.prev
        self.prev =root

            