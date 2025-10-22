# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# The time complexity: O(n) as we have to traverse every node of the tree. The space is O(n) as well for recursion depth stack
# The intuition here is to do a DFS, we go until the left bottom and then move the pointer from right to left and then store the right pointer in a temp variable. Eventually pointing
# that to right. This way after the traversal each pointers are moved toward the right skewed way

class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        def helper(curr):
            if not curr: return
            helper(curr.left)
            temp = curr.right
            curr.right = curr.left
            curr.left = None
            while curr.right:
                curr = curr.right
            curr.right = temp
            helper(curr.right)

        helper(root)


