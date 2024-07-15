# Time Complexity : O(n)
# Space Complexity : O(h)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def flatten(self, root: TreeNode) -> None:
        if not root:
            return
        self.flatten(root.left)
        self.flatten(root.right)
        left = root.left
        right = root.right
        root.left = None
        root.right = left
        current = root
        while current.right:
            current = current.right
        current.right = right

# Example 1

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(5)
root.left.left = TreeNode(3)
root.left.right = TreeNode(4)
root.right.right = TreeNode(6)

sol = Solution()
sol.flatten(root)

# Output the flattened tree
current = root
while current:
    print(current.val, end=" -> " if current.right else "\n") # Output : 1 -> 2 -> 3 -> 4 -> 5 -> 6
    current = current.right

# Example 2

root = TreeNode(0)
root.left = TreeNode(1)
root.left.left = TreeNode(2)
root.left.right = TreeNode(3)
root.left.right.right = TreeNode(4)

sol = Solution()
sol.flatten(root)

# Output the flattened tree
current = root
while current:
    print(current.val, end=" -> " if current.right else "\n") # Output : 0 -> 1 -> 2 -> 3 -> 4
    current = current.right

# Example 3

root = TreeNode(1)
root.right = TreeNode(2)
root.right.left = TreeNode(3)

sol = Solution()
sol.flatten(root)

# Output the flattened tree
current = root
while current:
    print(current.val, end=" -> " if current.right else "\n") # Output : 1 -> 2 -> 3
    current = current.right