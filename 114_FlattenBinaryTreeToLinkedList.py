"""
TC: O(N)
SC: O(N)
Logic:
Do preorder traversal and append nodes to a queue.
While queue is not empty, pop elements and wire the right pointers properly
"""

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
        q = []

        def preorder(root):
            if root is None:
                return
            q.append(root)
            preorder(root.left)
            preorder(root.right)

        preorder(root)
        temp = TreeNode()
        ptr = temp
        while q:
            curr = q.pop(0)
            curr.left = None
            temp.right = curr
            temp = curr
        return ptr.right


