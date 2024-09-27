"""
Name: Srinidhi Bhat
Did it run on LC: Yes

Space Complexity: O(N) - Recursion Stack - The tree can be skewed and hence all N nodes can be in the Stack
Time Complexity: O(N) - Each node will be processed at least once

Logic: Recursivley we can flatten each part of the tree

How to Flatten? - We need to link the leftTail (left Subtree end) to the right subtree and then 
shift the left subtree to the right of the node, calling it

If this is done Recursivley, we can flatten the binary tree like a linkedList
"""
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
            return root
        
        
        self.flattenTree(root)
        
    
    def flattenTree(self,node):
        if node is None:
            return None
        
        if node.left is None and node.right is None:
            return node
        
        leftTail = self. flattenTree(node.left)
        rightTail = self.flattenTree(node.right)
        
        if leftTail:
            leftTail.right = node.right
            node.right = node.left
            node.left = None
        
        return rightTail if rightTail else leftTail