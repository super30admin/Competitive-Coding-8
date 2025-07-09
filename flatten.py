# TimeComplexity:O(n) visting all nodes
# Space complexity:O(n) for recursive stack


# Approach:faltten recursively untill you hit one node  lets say you have 
#   root
#   /  \
# left  right
# flattent left sub tree and have left tail pointer so that lefttail.right =root.right
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
        def dfs(root):
            if not root:return 
            leftTail=dfs(root.left)
            rightTail=dfs(root.right)

            if root.left:
                
                leftTail.right=root.right
                root.right=root.left
                
                root.left=None
            last= rightTail or leftTail or root
            return last
        dfs(root)
