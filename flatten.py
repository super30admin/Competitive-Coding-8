#114. Flatten Binary Tree to Linked List
# Time Complexity : O(n) 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
#first goes on the left side of the root , call flatten function which will append the left node to right of root, and add actual right to the new appended nodes
class Solution:
    def flatten(self, root: TreeNode) -> None:
        #base
        if not root  or not root.left  and not root.right :
            return
        #logic
        if root.left:
            self.flatten(root.left)
            temp = root.right
            root.right = root.left
            root.left = None
            while root.right != None:
                root = root.right
            root.right = temp
        self.flatten(root.right)
        