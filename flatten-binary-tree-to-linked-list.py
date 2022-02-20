'''
TC: O(n)
SC: O(H)
'''
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        if not root or (not root.left and not root.right):
            return 
        
        if root.left:
            self.flatten(root.left)
            
        tmp = root.right
        
        if root.right:
            self.flatten(root.right)
        
        lh = root.left
        root.right = lh
        root.left = None
        
        if lh:
            while lh.right:
                lh = lh.right
            lh.right = tmp
        else:
            root.right = tmp