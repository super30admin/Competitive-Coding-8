#Time: O(N)
#Space: O(H)

class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root is None:
            return root
        
        self.flatten(root.left)
        temp = root.right
        root.right = root.left
        root.left = None
        while root.right:
            root = root.right           
        root.right = temp 
        self.flatten(root.right)
