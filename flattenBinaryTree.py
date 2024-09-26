#Time Complexity : O(n)
#Sapce Complexity :  O(n)
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
        temproot = None
        if root == None:
            return
        def dfs(root):
            if root == None:
                return
            if root.left != None:
                temproot= root.right
                root.right = root.left
                root.left= None
                curr = root
                while(curr.right!=None):
                    curr = curr.right
                curr.right = temproot  
            dfs(root.right)
        
        
        dfs(root)
=====================================================================================