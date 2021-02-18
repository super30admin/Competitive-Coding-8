'''
    Time Complexity:
        O(n) (where n = number of nodes)

    Space Complexity:
        O(h) (where h = height of the tree)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Post Order fashion.
        Maintain a global previous pointer, pointing to None initially.
        Flatten the right subtree first and then the left subtree.
        This way, when you are done flatten the left subtree, you would attach
            the right subtree (flattened previously) to the right of the one in
            process.
        Make sure to reset the left pointers to None.
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.prev = None

    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return

        self.flatten(root.right)
        self.flatten(root.left)

        root.right = self.prev
        self.prev = root
        root.left = None
