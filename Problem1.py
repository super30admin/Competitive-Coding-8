# Time Complexity : O(n) 
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # EDGE 
        if not root or root == None:
            return None 
        head  = root
        while root is not None:
            if root.left is not None:
                copy = root.right 
                root.right = root.left 
                root.left = None 
                node = root
                while node.right is not None:
                    node = node.right 
                node.right = copy   
            root = root.right 
                
        return head 
            