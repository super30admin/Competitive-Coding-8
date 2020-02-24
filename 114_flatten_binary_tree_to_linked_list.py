# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        """
            Time Complexity - O(n)
            'n' is the number of nodes
            Space Complexity - O(h)
            'h' is the height of the tree
        """
        if not root:
            return
        # pre order traversal
        # D L R
        stack = [root]
        dummy = TreeNode(None)
        ptr = dummy
        while stack:
            cur = stack.pop()
            if cur.right:
                stack.append(cur.right)
            if cur.left:
                stack.append(cur.left)
            if stack:
                cur.right = stack[-1]
            cur.left = None
