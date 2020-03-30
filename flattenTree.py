'''
Time Complexity: O(n)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation: We iterate through the binary search tree and convert of the left pointers to the right ie, for every
left subtree we move the elements from the left subtree and attach them to the right subtree. We iterate through the newly
left subtree in the right of the tree until we reach null. Once we reach null we attach the previous right subtree to
the newly linked left subtree in the right.
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def convert(self, root: TreeNode) -> TreeNode:
        if root == None or (root.left == None and root.right == None):
            return

        if root.left != None:
            self.convert(root.left)
            temp = root.right
            root.right = root.left
            root.left = None
            while root.right != None:
                root = root.right

            root.right = temp

        self.convert(root.right)

    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.convert(root)