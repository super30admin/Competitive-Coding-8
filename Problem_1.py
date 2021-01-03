"""
Time Complexity : O(n)
Space Complexity : O(h) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
I have two versions of this. One when starting with left pointer first and the other when starting with right
pointer first. I submitted right one in the interview.
"""


class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        if root.right:
            temp = root.right
            if root.left:
                root.right = root.left
                root.left = None
                node = root
                while node.right:
                    node = node.right
                node.right = temp
        else:
            root.right = root.left
            root.left = None
        self.flatten(root.right)


class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root or (not root.left and not root.right):
            return
        if root.left:
            self.flatten(root.left)
            temp = root.right
            root.right = root.left
            root.left = None
            while root.right:
                root = root.right
            root.right = temp
        self.flatten(root.right)
