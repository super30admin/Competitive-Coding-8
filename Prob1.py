# Time complexity : O(n), number of nodes in the binary tree
# Space complexity : O(H), height of the tree to maintain the stack
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

        def helper(root):
            if not root:
                return
            
            helper(root.left)

            if root.left:
                temp1 = root.right
                temp2 = root.left

                root.right = temp2

                while temp2.right:
                    temp2 = temp2.right
                temp2.right = temp1
                root.left = None

                helper(temp1)
            else:
                helper(root.right)

        helper(root)

        return root