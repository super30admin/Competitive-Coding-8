#Time Complexity O(t)
#Space Complexity O(t)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    temp = TreeNode(None)
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        dfs = [root]
        temp = None
        if not root: return
        while dfs:
            root = dfs.pop()
            if root.right:
                dfs.append(root.right)
            if root.left:
                dfs.append(root.left)
                root.left = None
            if temp:
                temp.right = root
            temp = root
        
#         def helper(root):
#             #Base
#             if not root: return
            
#             if self.temp:
#                 self.temp.left = None
#                 self.temp.right = root
#             self.temp = root
            
#             #Logic
#             left, right = root.left, root.right
#             helper(left)
#             helper(right)
        
        
#         self.temp = None
#         helper(root)