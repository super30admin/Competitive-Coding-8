# Time Complexity : O(nlogn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No  


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# parsing through the head, connecting rightest element of left subtree to the current right then moving the left of the root to right.
# then moving root to the right at every step
class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        #moving linearly along the right of the tree
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
                head.left = None #removing the left
            # updating the head pointer
            head = head.right