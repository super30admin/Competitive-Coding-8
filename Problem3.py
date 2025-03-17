# Problem 3 : Lowest Common Ancestor of a Binary Tree IV
# Time Complexity : O(n) where n is the number of nodes in the tree
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def lowestCommonAncestor(
        self, root: 'TreeNode', nodes: 'List[TreeNode]'
    ) -> 'TreeNode':
        # base case if the root is None then return None
        if root is None:
            return None
        
        # dfs function to traverse the tree
        def dfs (root: 'TreeNode') -> 'TreeNode':
            # nodes list is an global variable
            nonlocal nodes
            # base case if root is None or is in the list of nodes then return root
            if root is None or root in nodes:
                return root
            
            # find the ancestor of the left of the sub-tree
            leftAncestor = dfs(root.left)
            # find the ancestor of the right of the sub-tree
            rightAncestor = dfs(root.right)
            
            # if there is left and right ancestor then return root
            if leftAncestor and rightAncestor:
                return root
            # if there is right and not left ancestor then return left ancestor
            elif leftAncestor != None and rightAncestor == None:
                return leftAncestor
            # if there is left and not right ancestor then return right ancestor
            elif leftAncestor == None and rightAncestor != None:
                return rightAncestor
            # else return None
            else:
                return None
        # call dfs function for root and return the result of it
        return dfs(root)