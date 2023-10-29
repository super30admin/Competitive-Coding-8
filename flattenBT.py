# Time Complexity: O(n)
# Space Complexity: O(h)


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        def helper(root):
            if not root:
                return None
            if not root.left and not root.right:
                return root
        
            leftTail = helper(root.left)
            rightTail = helper(root.right)

            if root.left:

                leftTail.right =  root.right
                root.right= root.left
                root.left=None


            res = rightTail or leftTail or root
            return res

        helper(root)
        
            
        
