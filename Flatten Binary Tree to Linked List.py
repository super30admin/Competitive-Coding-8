""""// Time Complexity : O(n)
// Space Complexity : O(h) recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.temp = None

    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.dfs(root)

    def dfs(self, root):
        # base
        if root is None:
            return

            # logic
        self.dfs(root.left)
        self.dfs(root.right)

        if root.left:
            print(root.right)
            self.temp = root.right
            root.right = root.left
            root.left = None
            while (root.right):
                root = root.right
            root.right = self.temp
