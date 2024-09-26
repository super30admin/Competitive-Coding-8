"""
    // Time Complexity :O(n) traversing through the entire tree
    // Space Complexity :O(1)
    // Did this code successfully run on Leetcode : YES
    // Any problem you faced while coding this : NA

    //Explanation:
    this problem requires reverse preorder traversal(root,right,left).
    iterative for better understanding
    only three cases are there:
    case1 : root has left child and right child.push right child in stack
    assign left child to right. left child to None
    case2 : if right child is None, simply assign left child to right child.
    now left child is None
    case3 : if right is None, do nothing
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        stack = []

        while root != None or len(stack) != 0:
            #case 1
            if root.left and root.right:
                stack.append(root.right)
                root.right = root.left
                root.left = None
                root = root.right
            # case 2
            elif root.left and root.right is None:
                root.right = root.left
                root.left = None
                root = root.right
            #case 3
            elif root.right and root.left is None:
                root = root.right
            else:
                if stack:
                    root.right = stack.pop()
                root = root.right
        return
