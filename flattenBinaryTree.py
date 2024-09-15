#O(n) time and O(h) space solution
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        def flat(root):
          
            if root is None:
                return None
            leftEdge = flat(root.left)
            rightEdge = flat(root.right)
            
            if root.left:
                #leftEdge.right = root.right
                root.right = root.left
                root.left = None
                while leftEdge.right:
                    leftEdge = leftEdge.right
                leftEdge.right = rightEdge
            
            return root or leftEdge or rightEdge 
        flat(root)
            