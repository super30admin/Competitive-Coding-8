# Time complexity: O(n)
# Space complexity: O(h)

class Solution:
    def flatten(self, root: TreeNode) -> None:
        self.prev = None
        self.flatten_tree(root)
    
    def flatten_tree(self, node):
        if not node:
            return
        self.flatten_tree(node.right)
        self.flatten_tree(node.left)
        node.right = self.prev
        node.left = None
        self.prev = node
