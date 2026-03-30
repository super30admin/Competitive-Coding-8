# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We flatten the left and right subtrees recursively.
# Then we move the left subtree to the right and nullify the left.

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
        self.helper(root)

    def helper(self, node):
        if node is None:
            return
        
        if node.left is None and node.right is None:
            return node

        leftLeaf = self.helper(node.left)
        rightLeaf = self.helper(node.right)

        if leftLeaf:
            leftLeaf.right = node.right
            node.right = node.left
            node.left = None

        return rightLeaf if rightLeaf else leftLeaf
        