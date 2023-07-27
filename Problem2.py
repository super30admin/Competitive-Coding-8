#Time complexity is: O(N)
#Space complexity is: O(H)
#No issues faced while coding
#Code ran successfully on leetcode
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        #Base case
        if root is None:
            return None
        else:
            #We are flattening the left part of the tree
            left_part = self.helper(root.left)
            #We are flattening the right part of the tree
            right_part = self.helper(root.right)
            #WE are making left part as None
            root.left = None
            #Appending the left part ot the right of the tree
            root.right = left_part
            current = root
            #We will move towards right of the tree
            while current.right is not None:
                current = current.right
            #At te end we are appending the right part
            current.right = right_part

    def helper(self, root):
        #Base case
        if root is None:
            return None
        #Child node condition
        elif root.left is None and root.right is None:
            return root
        else:
            #Completely moving towards left part
            left_part = self.helper(root.left)
            #Taking the right part
            right_part = self.helper(root.right)
            #We will make the left part as None
            root.left = None
            #In the right part,we are attachung the left part
            root.right = left_part
            current = root
            #We will move towards compelte right of the tree
            while current.right is not None:
                current = current.right
            #To the right of the current we will append the right value that is stored
            current.right = right_part
            #Finally we will return root
            return root