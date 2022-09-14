# Time complexity : O(n)
# Space complexity : O(1) - asymp, recursion - O(n)
# Leetcode : Solved and submitted

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
        # base
        # if not root then just return
        if not root:
            return
        # if we reach a leaf node, we return to the last root, as we need to be at depth of leaf - 1
        if root.left == None and root.right == None:
            return root
        
        # logic
        # if we have a left child of root
        if root.left != None:
            # go to the last but one depth, just above the leaf node
            self.flatten(root.left)
            
            # store the right child or root in a temp
            tempR = root.right
            
            # make the right child of root to the left of root
            root.right = root.left
            
            # make the left child of root as None
            root.left = None
            
            # move to the righmost node of the current root
            while root.right:
                root = root.right
            
            # append the temp node to the rightmost node
            root.right = tempR
        
        # move to the right side of the root to follow the same principle
        self.flatten(root.right)
