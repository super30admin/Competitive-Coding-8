"""114. Flatten Binary Tree to Linked List
Time Complexity: O(n)
Space Complexity: O(n)"""

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
        if root is None:
            return None
        stack = [root]
        curr = root
        
        while stack: #root needed or not?
            curr = stack.pop()
            
            if curr.right:
                stack.append(curr.right)
            if curr.left:
                stack.append(curr.left)
                
            if curr and stack:
                curr.left = None
                curr.right = stack[-1]
            
        return root
            
            
            