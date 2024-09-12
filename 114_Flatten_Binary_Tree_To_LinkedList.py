# Leetcode problem link : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
# Time Complexity:    O(n) 
# Space Complexity:   O(1)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
      1. Process the left and right nodes of the current node.
      2. Update the pointers to make left as none and left and right based on they are not null
      3. Always return the last node or tail node so that there is no need to traverse again and again
''' 

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
        self.dfs(root)
    
    def dfs(self,node):
        if not node or (node.left is None and node.right is None):
            return node
        
        newLeft = self.dfs(node.left)
        newRight = self.dfs(node.right)
        currLeft = node.left
        currRight = node.right
        if newLeft:
            
            newLeft.right = currRight
            node.right = currLeft
        node.left = None
        
        if newRight != None:
            return newRight
        else:
            return newLeft