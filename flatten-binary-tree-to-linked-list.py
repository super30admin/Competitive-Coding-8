# Time O(n)
# Space O(n)
class Solution:
    
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root == None or root.left == None and root.right == None: return
        
        #get rightmost in left
        tempRight = root.right
        self.flatten(root.left)
        root.right = root.left
        root.left = None
        while root.right != None:
            root = root.right
        root.right = tempRight
        self.flatten(root.right)