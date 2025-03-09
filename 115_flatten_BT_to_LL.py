# Time complexity - O(n)
# Space complexity - O(n) # recursive stack, if the tree is skewed

# Approach - Store the root.right, apply the flatten() function on root.left, assign root.right to root.left, 
# set root.left to None, assign root.right to the stored root.right, and finally apply the flatten() on
# root.right.

from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # base case
        if (root == None or root.left == None and root.right == None):
            return
        
        # logic
        temp_right = root.right
        self.flatten(root.left)
        root.right = root.left
        root.left = None
        while(root.right != None):
            root = root.right
        root.right = temp_right
        
        self.flatten(root.right)