'''

Acepted on leetcode(114)
Time - O(n)
Space - O(1)
'''
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # Base Case - either root is None or both left and right are None then return
        if root == None or root.left == None and root.right == None:
            return
        # Recursive case
        if root.left != None:
            self.flatten(root.left) # call recursion
            tempRight = root.right # save the full right node to a tempNode
            root.right = root.left # assign left to right
            root.left = None # then make left None as the linked list only has right nodes.
            #Repeat until u reach the end of right link to attach the next right tree to the previous tree
            print(root)
            while root.right != None:
                root = root.right
            # put back the right at the end of left constructed tree
            root.right = tempRight

        self.flatten(root.right)