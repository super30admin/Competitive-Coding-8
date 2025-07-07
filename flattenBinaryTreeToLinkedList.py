# Definition for a binary tree node.

# // Time Complexity : o(n) traversing the complete tree
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


# // Your code here along with comments explaining your approach
# idea is to do post order traversal compute the left and right pointers and then manipulate those pointers to flatten the ll

from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # base
        if not root : return None
        # logic
        leftTail = self.flatten(root.left)
        rightTail = self.flatten(root.right)
        if leftTail:
            leftTail.right = root.right
            root.right = root.left
            root.left = None
        if rightTail:
            return rightTail
        elif leftTail:
            return leftTail
        else:
            return root


        