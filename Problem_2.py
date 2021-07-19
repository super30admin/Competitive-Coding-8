class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root == None:
            return
        
        if root.left != None:
            self.flatten(root.left)
            tempRight = root.right
            root.right = root.left
            root.left = None
            while root.right != None:
                root = root.right
            root.right = tempRight
        self.flatten(root.right)


# Time Complexity: O(n)
# Space Complexity: O(n) because of recursive stack because tree can be left or right skewed
