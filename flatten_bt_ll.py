# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def flatten(self, root: TreeNode) -> None:
        current = root

        while current:
            if current.left:
                # Find the rightmost node in the left subtree (predecessor)
                predecessor = current.left
                while predecessor.right:
                    predecessor = predecessor.right

                # Connect the right subtree to the right of the predecessor
                predecessor.right = current.right

                # Move the left subtree to the right
                current.right = current.left
                current.left = None  # Set the left child to None

            # Move to the next node (right child)
            current = current.right


# time complexity is O(n)
# space complexity is O(1)
