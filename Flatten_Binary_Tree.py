# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#time:O(logn)
#Space:O(height)
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        def traverse(root):
            if not root:
                return None
            if not root.left and not root.right:
                return root
            
            left_last = traverse(root.left)
            right_last = traverse(root.right)
            
            
            if root.left:
                left_last.right = root.right
                root.right = root.left
                root.left = None
            
            return right_last if right_last else left_last
        
        traverse(root)
        return root
        