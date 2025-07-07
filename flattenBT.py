# TC: O(n)
# SC: O(h)
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        prev=None
        def helper(root):
            nonlocal prev
            #base
            if not root:
                return
            #logic
            helper(root.right)
            helper(root.left)
            root.right=prev
            root.left=None
            prev=root
        helper(root)
