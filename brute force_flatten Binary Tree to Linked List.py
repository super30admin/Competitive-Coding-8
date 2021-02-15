#time:O(n)
#space: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    node=None
    root2=None
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if(root==None):
            return 
        self.node=None
        self.root2=None
        self.helper(root)
        root.right=self.root2.right
        root.left=None
        
    def helper(self,root):
        if(root==None):
            return None
        if(self.node==None):
            self.node=TreeNode(root.val,None,None)
            self.root2=self.node
        else:
            self.node.right=TreeNode(root.val,None,None)
            self.node=self.node.right
        self.helper(root.left)
        self.helper(root.right)
            
        
        