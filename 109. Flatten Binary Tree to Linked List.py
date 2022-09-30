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
        if root is None or root.right is None and root.left is None:
            return  # we do functional level return is we hit a leaf node or root is None

        if root.left:  # we traverse left
            self.flatten(root.left)  # we keep going left until we hit leaf node
            tempNode = root.right  # Assigning root.right to temp variable
            root.right = root.left  # assigning all the left value to root.right
            root.left = None  # we make left of root None of the one that me referenced to the right side of the root
            while root.right:  # we keep going right until we hit None
                root = root.right
            root.right = tempNode  # once we hit None we assign the tem value on root.right
        self.flatten(root.right)  # we do the same on the left subtree

# Recursion
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No