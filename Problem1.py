## Problem 1
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
        TC: O(N) where N is the num of nodes
        SC: O(H) where H is the height of the tree
        """
        dummy = TreeNode()
        curr = dummy

        def traverse(root):
            nonlocal curr
            if not root:
                return
            
            left = root.left
            right = root.right

            curr.right = root
            curr = curr.right
            curr.left = None
            curr.right = None

            traverse(left)
            traverse(right)

            
        
        traverse(root)
        return dummy.right
