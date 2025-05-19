# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Approach:
        1. Use reverse post-order traversal (right -> left -> node).
        2. Keep a reference to the previously processed node (`prev`).
        3. For each node:
           - Set node.right = prev
           - Set node.left = None
           - Update prev = node
        4. This effectively transforms the tree into a right-skewed linked list in-place.

        Time Complexity: O(N) — Each node is visited exactly once.
        Space Complexity: O(H) — Due to recursion stack, where H is the height of the tree.
                             In worst case (skewed tree), H = N; in best case (balanced), H = log N.
        """
        prev = None

        def flattenTree(node):
            nonlocal prev
            if not node:
                return

            flattenTree(node.right)
            flattenTree(node.left)

            node.right = prev
            node.left = None
            prev = node 

        flattenTree(root)
