# https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

class Solution:
    # def flatten(self, root):
    #     self.prev = None
    #     self.helper(root)

    # def helper(self, root):
    #     if not root:
    #         return
    #     self.helper(root.right)
    #     self.helper(root.left)
    #     root.right = self.prev
    #     root.left = None
    #     self.prev = root

    
    def flatten(self, root):
        while root:
            if root.left:
                prev = root.left
                while prev.right:
                    prev = prev.right
                prev.right = root.right
                root.right = root.left
                root.left = None
            root = root.right