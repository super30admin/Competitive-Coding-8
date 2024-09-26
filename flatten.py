# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# TC: O(N)
# SC: O(h), h =  logN
class Solution:
    def dfs(self, root):
        
        if not root:
            return None
        if not root.left and not root.right:
            return root
        
        left = self.dfs(root.left)
        right = self.dfs(root.right)
        
        if left:
            temp = root.right
            root.right = left
            cur  = root.right
            while cur.right:
                cur = cur.right
            cur.right = temp
            root.left = None
        return root
            
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        root = self.dfs(root)
        