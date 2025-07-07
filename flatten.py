# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

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
        
        # Recursively flatten left and right subtrees
        self.flatten(root.left)
        self.flatten(root.right)
        
        # Store the left and right subtrees
        left = root.left
        right = root.right
        
        # Move left subtree to right
        root.left = None
        root.right = left
        
        # Find the rightmost node of the new right subtree
        curr = root
        while curr.right:
            curr = curr.right
        
        # Attach the original right subtree
        curr.right = right
        