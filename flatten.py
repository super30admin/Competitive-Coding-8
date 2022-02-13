class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        Time Complexity = O(N)
        Space Complexity = O(1)
        """
        def helper(root):
            if not root:
                return 
            if not root.left and not root.right:
                return           
            helper(root.left)
            helper(root.right)
            temp = root.right
            root.right = root.left
            root.left = None
            # right_temp = root.right.right
            rightmost = root
            while rightmost.right :
                rightmost = rightmost.right
                
            rightmost.right = temp
            
        helper(root)
        return root
