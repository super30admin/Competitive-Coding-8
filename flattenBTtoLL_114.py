# https://leetcode.com/problems/flatten-binary-tree-to-linked-list/submissions/

# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Yes

# // Your code here along with comments explaining your approach
# Iteratively push the nodes on to the stack in level order. Keep pushing the right and left nodes on the stack. Pop the top of the stack and move the prev pointer to point ahead, adding the stack's top node to right branch and left node to None. 

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
        if not root:
            return 
        
        stack = [root]
        prev = None
        
        while stack:
            front = stack.pop()
            
            if front.right:
                stack.append(front.right)
            if front.left:
                stack.append(front.left)
                
            if prev:
                prev.right = front
                prev.left = None
            
            prev = front
            
        return root
                
        