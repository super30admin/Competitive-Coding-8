# problem 2 

# https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

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
        curr_node = root
        while curr_node:
            if curr_node.left:
                l_node = curr_node.left
                # fund the right most
                while l_node.right:
                    l_node = l_node.right 
                l_node.right = curr_node.right
                curr_node.right = curr_node.left
                curr_node.left = None 
            curr_node = curr_node.right
        