#114. Flatten Binary Tree to Linked List
"""
Time Complexity : O(n)
Space Complexity : O(height of tree)
"""
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
            temp = root.right #storing right because we will be loosing it
            root.right = root.left
            root.left = None #no need for left node now. None required acc. question
            while root.right != None: #go till end of the flattern temp LL 
                                    #so that temp can be atttached at end.
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
        
