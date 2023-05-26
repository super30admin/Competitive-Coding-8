# Time Complexity: O(n)
# Space Complexity: O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
The code creates a linked list from a binary tree by recursively replacing the right node with the left node and then appending the previous right node onto it.
"""

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
        if root == None: return

        # go left
        self.flatten(root.left)

        # go right
        self.flatten(root.right)

        if root.left != None:
            temp = root.right
            root.right = root.left
            left_subtree = root.right

            while True:
                if left_subtree.right == None:
                    break
                else:
                    left_subtree = left_subtree.right

            left_subtree.right = temp

            root.left = None