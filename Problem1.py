# // Time Complexity : O(n) where n is the number of nodes. 
# // Space Complexity : O(h). where h is the height of the tree.
# // Did this code successfully run on Leetcode : Yes.
# // Any problem you faced while coding this : No.


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
        self.prev = None
        def helper(root):
            # base
            if root == None:
                return
            # logic
            self.prev = root
            right = root.right
            root.right = root.left
            root.left = None
            helper(root.right)
            if right != None:
                self.prev.right = right
                helper(right)
        curr = root
        helper(curr)
