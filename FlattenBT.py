# Time Complexity : O(n)
# Space Complexity : O(1)  

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        head = root
        while head != None:
            right = head.right
            if head.left != None:
                node = head.left
                # connecting the right most element to the right of the head
                while node.right != None:
                    node = node.right
                node.right = right
                head.right = head.left
                head.left = None
            head = head.right