# TC : O(N)
# SC : O(N)

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
        ll = []
        if root is None:
            return None
        def preorder(root):
            if not root:
                return
            ll.append(root)
            preorder(root.left)
            preorder(root.right)

        preorder(root)
        root = ll[0]
        for i in range(1, len(ll)):
            root.left = None
            root.right = ll[i]
            root = root.right
            
