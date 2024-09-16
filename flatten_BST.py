# Time Complexity : O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this :No

# assign root.left to root.right 
# save root.right in temp 
# make root.left None
# save root in temp
# loop through root till end and attach root.right
# call flatten on root.right
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
        # base
        if root is None:
            return
        temp1 = root.right
        root.right = root.left
        root.left  = None
        temp2 = root  # 1
        while root.right is not None:
            root = root.right
        root.right = temp1
        self.flatten(temp2.right)


        