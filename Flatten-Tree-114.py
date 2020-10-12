# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        if root is None or (root.left is None and root.right is None):
            return
        
        current = root
        if current.left is not None:
            self.flatten(current.left)
            temp = current.right
            current.right = current.left
            current.left = None
            curr = current.right
            while curr.right is not None:
                curr = curr.right
            curr.right = temp
        
        if current.right is not None:
            self.flatten(current.right)
