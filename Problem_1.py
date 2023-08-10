"""
Problem : 1

Time Complexity : O(n)
Space Complexity : O(h) //h=height of tree

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Flatten Binary Tree to Linked List

# Approach - 1
# Recursive preorder

class Solution(object):
    def __init__(self):
        self.result=[]
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """

        self.preorder(root)
        for i in range(len(self.result)-1):
            node=self.result[i]
            nextnode=self.result[i+1]
            node.left=None
            node.right=nextnode

    
    def preorder(self,root):
        if not root:
            return
        self.result.append(root)
        self.preorder(root.left)
        self.preorder(root.right)


# Approach - 2
# Iterative Preorder

class Solution(object):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        result=[]
        stack=[]

        while stack or root:
            if root:
                result.append(root)
                stack.append(root)
                root=root.left
            else:
                root=stack.pop()
                root=root.right

        for i in range(len(result)-1):
            node=result[i]
            nextnode=result[i+1]
            node.left=None
            node.right=nextnode