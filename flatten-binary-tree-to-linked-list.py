# TC : O(n)
# SC : O(n)
class Solution(object):
    def flatten(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: None Do not return anything, modify root in-place instead.
        """

        if root is None:
            return

        left = root.left
        right = root.right

        self.flatten(root.left)
        self.flatten(root.right)


        root.left = None
        root.right = left

        temp = root

        while temp.right:
            temp = temp.right
        temp.right = right