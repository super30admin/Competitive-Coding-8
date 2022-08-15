# Time Complexity: log(n) # n is number of nodes in the tree
# Space Complexity: log(h) # h is height of the tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = []
    def helper(self, root):
        #base case
        if root == None:
            return
        
        #logic
        if root.left != None:
            self.helper(root.left)
            temp = root.right 
            root.right = root.left
            root.left = None 
            while root.right != None: 
                root = root.right 
                
            root.right = temp
        
        if root.right != None:
            self.helper(root.right)
    
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        #null case
        if root == None:
            return None
        
        self.helper(root)
