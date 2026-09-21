# https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

# Time complexity: O(n) 
# Space complexity: O(1)
# Explanation: flatten left tree and right tree recursively; if the left child had nodes, then perform a swap such that
# current node's right node is linked to left child right; current node's left node is linked to current node's right node; current node's left is set to None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def helper(self, node: TreeNode) -> TreeNode:
        if not node:
            return None
        
        if not node.left and not node.right:
            return node
        
        leftC = self.helper(node.left)
        rightC = self.helper(node.right)

        if leftC:
            leftC.right = node.right
            node.right = node.left
            node.left = None
    
        return rightC if rightC else leftC


    def flatten(self, root: TreeNode | None) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.helper(root)
        
