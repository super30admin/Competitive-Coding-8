# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes


# Your code here along with comments explaining your approach

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
        if root == None:
            return 
        
        leftnode = root.left
        rightnode = root.right

        if leftnode!=None:
            while(leftnode.right!=None):
                leftnode = leftnode.right  
            root.right = root.left
            leftnode.right = rightnode
            root.left = None

        self.flatten(root.right)
        