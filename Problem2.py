# Problem 2 : Flatten Binary Tree to Linked List
# Time Complexity : O(n) where n is the number of nodes in a tree
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # edge case if the root is None then return
        if root is None: return

        # flatten function where the tree is flatten. This is recursive method
        def flatten(root: Optional[TreeNode]) -> Optional[TreeNode]:
            # base case if the root is left or if it is a leaf node then return
            if root == None or root.left == None and root.right == None:
                return 

            # if the root.left is not None then flatten the left sub tree
            if root.left != None:
                flatten(root.left)

                # save the right tree in temp
                temp = root.right
                # set the right pointer of the root to point to left sub tree
                root.right = root.left
                # set the left pointer to None
                root.left = None
                
                # find position for inserting the right sub tree in tree

                # define t pointer to right of the root
                t = root.right
                # loop until the right of root is None
                while t.right != None:
                    # move t to the right of the t node
                    t = t.right
                # finally set the right pointer to point to the right subtree which is pointer by temp
                t.right = temp

            # if the right sub tree is not None then flatten the right sub tree
            if root.right != None:
                flatten(root.right)

        # flatten tree at root 
        flatten(root)