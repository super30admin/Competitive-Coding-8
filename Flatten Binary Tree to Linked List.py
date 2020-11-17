# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def flatten(self, root) -> None:
        if not root:
            return
        L = self.flatten(root.left)         # go to most left node 
        R = self.flatten(root.right)
                                    # for a root (consider 2, we need to create LL from L = 3 and R = 4)
        if L:
            root.right = L          # make right of root=2 to L ctd.
            
            while L and L.right:    # when L is long like (for root=1 L will be 2->3->4)
                L = L.right
            
            L.right = R            
            root.left = None        
        return root
    
    
"""
L = 3
R = 4
root = 2

"""