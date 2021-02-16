# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: TreeNode) -> None:
        '''
        Time Complexity: O(n)
        Space Complexity: O(n) if include recursive stack
        '''
        
        prev = None
        def helper(root):
            if(root==None):
                return
            left = root.left
            right = root.right
            nonlocal prev
            if(prev==None):
                prev = root
                root.left = None
                root.right = None
            else:
                prev.right = root
                root.left = None
                root.right = None
                prev = prev.right
            
            if(left!=None):
                helper(left)
            
            if(right!=None):
                helper(right)
            
            
        helper(root)
        
        return root
