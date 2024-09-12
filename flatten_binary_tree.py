#TC:O(N) where N is the no. of nodes in a BT
#SC: O(1) as no extra space used

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
        #edge case
        if root == None: return
        if root.left == None and root.right == None: return 
        
        #This function calls itself recursively on the left branch 
		#stores the right part of the tree in a temp variable
		#left tree is assigned to the right tree 
		#left tree is made Null
		#process is repeated till right part of the left sub tree is Null
		self.flatten(root.left)
        temp = root.right
        root.right = root.left
        root.left = None
        while root.right != None:
            root = root.right
        root.right = temp
        self.flatten(root.right)