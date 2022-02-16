"""
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class
where the right child pointer points to the next node in the list 
and the left child pointer is always null.
The "linked list" should be in the same order as a 
pre-order traversal of the binary tree.

"""

# Time Complexity : O(n) n = number of nodes
# Space Complexity : O(h) h = height of tree
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        # null case
        if not root or root.left == None and root.right == None:
            return
        
        #logic
        if root.left != None:
            self.flatten(root.left)
            tempright = root.right
            root.right = root.left
            root.left = None
            
            while(root.right != None):
                root = root.right
                
            root.right = tempright
            
        self.flatten(root.right)