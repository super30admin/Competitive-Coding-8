# Time Complexity : O(N) where N is the number of nodes in the binary tree
# Space Complexity : O(h) where h is the height of the binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using a recursive approach to flatten the binary tree.
# I am using a helper function dfs to traverse the tree in a reverse pre-order manner (right -> left -> root).
# I am keeping track of the previous node using a variable self.prev.
# For each node, I am setting the right pointer to the previous node and the left pointer to None.
# Finally, I am updating the previous node to the current node.

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
        self.prev = None
        def dfs(root):
            if not root:
                return 
            dfs(root.right)
            dfs(root.left)
            root.right = self.prev
            root.left = None
            self.prev = root
        dfs(root)