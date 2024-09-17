# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # Recursively
        # TC - O(N)
        # SC - O(N) (recursive or implicit stack space)
        
        # base case
        if root == None or (root.left == None and root.right == None):
            return 
        
        if root.left != None: # Flattening the left part
            self.flatten(root.left)
            tempRight = root.right # Storing the right part into temporary TreeNode
            root.right = root.left # Storing left part to root's right
            root.left = None # Making left to None
            while(root.right!=None):
                root=root.right
            root.right = tempRight
            
        self.flatten(root.right) # Similarly for right
        
        return root
    
   '''
   # Iterative Solution
   # TC - O(N)
   # SC - O(N) (Explicit stack)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        if root == None:
            return
        stack = []
        p = root
        while True:
            if p.left != None and p.right != None:
                stack.append(p.right)
                p.right = p.left
                p.left = None
            elif p.left != None:
                p.right = p.left
                p.left = None
            elif p.right != None:
                p = p.right
            else:
                if stack == []:
                    return
                p.right = stack.pop()
                p = p.right
                
        return root
        
'''