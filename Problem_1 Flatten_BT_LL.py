# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

# Definition for a binary tree node.
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
        if not root:
            return root
        return self.helper(root)

    def helper(self, root):
        # base
        if not root:
            return None
        if root.left == None and root.right == None:
            return root

        # logic
        leftLeaf = self.helper(root.left)
        rightLeaf = self.helper(root.right)

        if leftLeaf:
            leftLeaf.right = root.right
            root.right = root.left
            root.left = None

        return rightLeaf if rightLeaf else leftLeaf

