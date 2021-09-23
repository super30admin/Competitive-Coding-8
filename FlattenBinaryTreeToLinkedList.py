"""
Time Complexity : O(n) is the number of nodes in the bianry tree
Space Complexity : O(n) is the number of nodes in the bianry tree
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
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
        if not root:
            return 
        # We first go traverse in the left nodes we find the rightmost node among 
        # them. When we find the righmost node we link it to the parent nodes right 
        # and make the left none and then repeat the same thing
        self.flatten(root.left)
        if root.left:
            rightNode = root.right
            root.right = root.left
            root.left = None
            while root.right:
                root = root.right
            root.right = rightNode
        self.flatten(root.right)
        
