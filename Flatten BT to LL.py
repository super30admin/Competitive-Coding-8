"""
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

      TIME - O(N)
      SPACE = O(N) RECURSION STACK
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.

        """
        if root == None:
            return

        self.flatten(root.left)     #traverse to left most

        temp = root.right      #store right of root in temp
        root.right = root.left  # assign left child of root as right
        root.left = None

        while root.right != None:   #check for root. right
            root = root.right
        root.right = temp          # now make right child stored in temp as root.right

        self.flatten(root.right)

#faster
class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.

        """
        if root == None:
            return

        self.prev = root

        self.flatten(root.left)

        temp = root.right
        root.right = root.left
        root.left = None

        self.prev.right = temp

        self.flatten(temp)