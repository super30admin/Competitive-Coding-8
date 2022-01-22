class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    # Time Complexity - O(n)
    # Space Complexity - O(h) where h is the max height of the tree
    def flatten(self, root) -> None:

        def function(root):
            if root is None:
                return None
            function(root.left)
            function(root.right)

            if root.left:
                temp = root.right
                root.right = root.left
                root.left = None
                tail = root.right
                while tail.right:
                    tail = tail.right

                tail.right = temp

        function(root)