# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def flatten(self, root) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        temp = root
        while root:
            if root.left:
                # finding predecessor for a node
                pre = root.left
                while pre.right:
                    pre = pre.right
                # connecting predecessor to node's right
                pre.right = root.right
                # root's right is connected to root's left
                root.right = root.left
                # root's left is setting to None
                root.left = None
            root = root.right
        while temp.right:
            print(temp.right.val, end=" ")
            temp = temp.right


root = TreeNode(40)
root.left = TreeNode(30)
root.right = TreeNode(50)
root.left.left = TreeNode(20)
root.left.right = TreeNode(35)
root.right.left = TreeNode(45)
root.right.right = TreeNode(70)
root.left.left.left = TreeNode(10)
root.right.left.right = TreeNode(25)
root.left.right.left = TreeNode(32)
root.left.right.right = TreeNode(37)
root.right.left.left = TreeNode(42)
root.right.left.right = TreeNode(47)
root.right.right.left = TreeNode(60)
root.right.right.right = TreeNode(100)
Solution().flatten(root)

