'''
leet code- flatten binary tree - 114
time complexity - O(N)
Approach - First we flatten left sub tree and assign it to root. right, meanwhile we store the original root.right as temp_right.
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        #base case
        if root==None or root.left==None and root.right==None:
            return
        
        #recursive
        if (root.left!=None):
            self.flatten(root.left)
            temp_right=root.right
            root.right=root.left
            root.left=None
            print(root)
            while (root.right!=None):
                root=root.right
            root.right=temp_right
            
        self.flatten(root.right)
        
        