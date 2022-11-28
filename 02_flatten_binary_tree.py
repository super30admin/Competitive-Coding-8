#TC: O(n) n = number of nodes
#SC: O(h) #for recursive call ie depth of the tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        #will flatten and return list
        def dfs(node):
            if node == None:
                return None
            
            left = dfs(node.left) #will return tail
            right = dfs(node.right)
            
            #left tail is not null
            if left:
                left.right = node.right
                node.right = node.left
                node.left = None
        
            #right tail not null or left is not null or root 
            tail = right or left or node
            return tail
        dfs(root)