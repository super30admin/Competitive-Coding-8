# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    # Recursive function to go to the left most mode and assign its right to the right of root and so on
    #    if it is leaf node we will return that or else we will keep calling function
    #    recursively on left and right sid eof the tree
    # if we have left element then we will change its right to root  right and change root
    # right to root left and finally assign root left to None.
    def ft(self, root):
        if not root:
            return

        if not root.left and not root.right:
            return root

        left = self.ft(root.left)
        right = self.ft(root.right)

        if left:
            left.right = root.right
            root.right = root.left
            root.left = None

        if right:
            return right
        else:
            return left

    def flatten(self, root):
        """
        Do not return anything, modify root in-place instead.
        """
        self.ft(root)