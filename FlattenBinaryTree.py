# Time Complexity : O(N) for each operation.
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to flatten right subtree and merge left in to existing created temp tree.

class Solution:
    def preorder(self, root):
        if not root: return

        temp = root
        while temp:
            if temp.left: 
                rightMost = temp.left
                while rightMost.right: 
                    rightMost = rightMost.right
                rightMost.right = temp.right 
                temp.right = temp.left
                temp.left = None
            temp = temp.right
            
            
        else:
            return
        return root

    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        temp=self.preorder(root)
        return temp
