# Time Complexity : Add - O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Flatten left subtree recursively by storing the right subtree as temp and replacing right of the root with the left
2. Now explicitly traverse through bottom of the new ttached right subtree, and attach the temp
'''

class Solution:
    
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        self._helper(root)
        
        
    def _helper(self, root):
        
        if root is None or (root.left is None and root.right is None):
            return
        
        self._helper(root.left)
        
        if root.left:
            temp = root.right
            root.right = root.left
            root.left = None
            while (root.right):
                root = root.right
            
            root.right = temp

        self._helper(root.right)