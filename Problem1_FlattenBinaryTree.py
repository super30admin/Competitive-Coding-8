# Time Complexity: O(n), where n - number of nodes in the tree
# Space Complexity: O(n), recursion stack

class Solution:
    def flatten(self, root: TreeNode) -> None:
        # base
        if not root or (not root.left and not root.right):
            return None

        # logic
        self.flatten(root.left)
        temp = root.right
        root.right = root.left
        root.left = None
        while root.right:
            root = root.right
        root.right = temp
        self.flatten(root.right)