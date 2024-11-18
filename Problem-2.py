#Approach
# from the root add the oot.left to root.right and end of left to root.right


#Complexities
#Time : O(n)
#Space : O(n)



# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from typing import Optional


class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.helper(root)

    def helper(self,root):
        if root is None:
            return None

        left = self.helper(root.left)
        right = self.helper(root.right)

        if left is not None:
            temp = root.left
            while temp.right is not None:
                temp = temp.right

            temp.right = right
            root.left = None
            root.right = left
        return root
