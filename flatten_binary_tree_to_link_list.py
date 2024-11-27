# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
O(N)
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        if root == None:
            return root
        
        def preorder(root):
            if root: # non null
                print(root.val)
                temp = root.right 
                
                root.right = preorder(root.left)
                
                root.left = None
                
                runner = root
                
                while(runner.right != None):
                    runner = runner.right
                
                runner.right = preorder(temp)
                return root
            
            return None
        
        preorder(root)
                
            
