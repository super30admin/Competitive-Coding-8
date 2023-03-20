# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#All TC on leetocde passed

class Solution:

    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        #Here we traverse right chilren and make them as prev. Now if prev exits then we make the cur node's right as prev and left as null.
        #Time complexity - O(n) - all nodes
        #Space complexity - O(h) - height of tree
        def helper(root):
            if not root:
                return 

            helper(root.right)
            helper(root.left)
            if self.prev:
                root.right = self.prev
                root.left = None
            self.prev = root
        
        self.prev = None
        helper(root)


        
