# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
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
        """
        Do preorder traversal and change pointers accordingly.
        """
        if not root:
            return
        
        stack = [root]
        prev = None
        
        while stack:
        
            curr = stack.pop()
            
            if curr.right:
                stack.append(curr.right)
            if curr.left:
                stack.append(curr.left)
                
            if prev:
                prev.right = curr
                prev.left = None
                curr.left = None
            prev = curr

                
                