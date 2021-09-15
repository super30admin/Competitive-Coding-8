# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def recursive_flatten(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        if not root:
            return None
        
        self.recursive_flatten(root.left)
        self.recursive_flatten(root.right)
        
        if root.left:
            backup_prev_right = root.right
            root.right = root.left
            root.left = None
            
            while root.right:
                root = root.right
                
            root.right = backup_prev_right
            
                    
        
    def flatten(self,root):
        self.recursive_flatten(root)