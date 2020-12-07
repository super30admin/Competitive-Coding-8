#Time Complexity : O(n) where n is the number of nodes in the tree
#Space Complexity : O(h) where h is the height of the tree
#Did this code successfully run on Leetcode : Yes


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def helper(self, root):
        if root is None:
            return
        #if we come acorss a leaf node we return from there
        if root.right is None and root.left is None:
            return

        #iterate through all the left children firs
        self.helper(root.left)

        temp = root.right #store the right child of current root in a temp
        root.right = root.left #make the current root's right child it's left child
        root.left = None #make the left child None
        #while we have a right child keep iterating down
        while root.right:
            root = root.right
        root.right = temp #make the leaf's right child the temp

        #iterate through all the right children
        self.helper(root.right)



    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root is None:
            return root

        self.helper(root)
