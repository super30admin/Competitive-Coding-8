# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(n), number of nodes
# Space Complexity: O(h), height of the tree
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        #base case
        if root==None or (root.right==None and root.left==None):return
        #logic
        if root.left!=None:
            self.flatten(root.left)
            rootright=root.right
            root.right=root.left
            root.left=None
            while root.right!=None:
                root=root.right
            root.right=rootright
        self.flatten(root.right)
        