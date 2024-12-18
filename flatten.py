# The flatten method converts a binary tree into a flattened linked list in-place, following a pre-order traversal.

# Use DFS to recursively process the tree:
# - Flatten the left and right subtrees and return their tails.
# - If the left subtree exists:
#   - Attach the left subtree to the right of the current node.
#   - Append the original right subtree to the end of the flattened left subtree.
# - Return the last node (tail) of the flattened subtree.

# TC: O(n) - Each node is visited once.
# SC: O(h) - Space for the recursion stack, where h is the tree height.


from typing import Optional


class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        def dfs(root):
            if not root:
                return None

            leftTail = dfs(root.left)
            rightTail = dfs(root.right)

            if root.left:
                leftTail.right = root.right
                root.right = root.left
                root.left = None

            last = rightTail or leftTail or root
            return last

        dfs(root)
