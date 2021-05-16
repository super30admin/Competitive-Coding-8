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
        if not root:
            return None
        
        self.prev = root    
        #print(self.prev.val)
        self.flatten(root.left)
        temp = root.right
        root.right = root.left
        root.left = None
    
        self.prev.right = temp
        if self.prev.right:
            print(self.prev.right.val)
        self.flatten(temp)
        
        return
        
        
