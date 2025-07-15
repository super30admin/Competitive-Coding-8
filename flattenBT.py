# Time Complexity: O(n) where n is the length of the binary tree
# Space Complexity: O(h) where h is the height of the tree (for recursion stack)

class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        if root is None or (root.left is None and root.right is None):
            return
        
        if root.left:
            self.flatten(root.left)
            
            tempRight = root.right
            root.right = root.left
            root.left = None

            # Traverse to the end of the new right subtree
            current = root.right
            while current.right:
                current = current.right

            current.right = tempRight
        
        self.flatten(root.right)

# Time Complexity: O(n) where n is the length of the binary tree
# Space Complexity: O(1) for the iterative approach
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        curr = root

        while curr:
            if curr.left:
                # Find rightmost of left subtree
                prev = curr.left
                while prev.right:
                    prev = prev.right

                # Attach current's right subtree at the end of left
                prev.right = curr.right

                # Make left the new right, and remove left
                curr.right = curr.left
                curr.left = None

            curr = curr.right
