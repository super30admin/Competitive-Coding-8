#time:O(n)
#space: O(h)

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
        self.helper(root)
    def helper(self,root):
        if(root==None):
            return None
        if(root.left==None and root.right==None):
            return root
        leftsub=self.helper(root.left)
        rightsub=self.helper(root.right)
        
        if(leftsub!=None):
            leftsub.right=root.right
            root.right=root.left
            root.left=None
        if(rightsub!=None):
            return rightsub
        else:
            return leftsub
        
        