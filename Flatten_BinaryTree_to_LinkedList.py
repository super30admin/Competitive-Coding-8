# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Initializing stack with root
# Until stack is empty pop the node from the stack
# If the node is visited and prev is not None then set prev.right to node set prev.left = None and then move prev to node
# Append the node's right child to stack
# Append the node's left child to stack
# Append the node to stack and set visited as True


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def flatten(self, root: TreeNode | None) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return None
        stack = [(root, False)]
        preorder = []
        while stack:
            node, visited = stack.pop()
            if node:
                if visited:
                    preorder.append(node)
                else:
                    stack.append((node.right, False))
                    stack.append((node.left, False))
                    stack.append((node, True))
        for i in range(len(preorder)-1):
            preorder[i].left = None
            preorder[i].right = preorder[i+1]
#Time - O(n) — Every node is pushed and popped once.
#Space - O(n)

class Solution:
    def flatten(self, root: TreeNode | None) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return None
        stack = [(root, False)]
        prev = None
        while stack:
            node, visited = stack.pop()
            if node:
                if visited:
                    if prev:
                        prev.left = None
                        prev.right = node
                    prev = node
                else:
                    stack.append((node.right, False))
                    stack.append((node.left, False))
                    stack.append((node, True))
#Time - O(n) — Every node is pushed and popped once.
#Space - O(h) — The stack stores nodes awaiting processing, where h is the tree height.

class Solution:
    def flatten(self, root: TreeNode | None) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return None
        self.prev = None
        self.helper(root)
    
    def helper(self, root):
        if not root:
            return None
        self.helper(root.right)
        self.helper(root.left)
        root.right = self.prev
        root.left = None
        self.prev = root
#Time - O(N)
#Space - (H)

class Solution:
    def flatten(self, root: TreeNode | None) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return None
        currentNode = root
        prev = None
        while currentNode:
            if currentNode.left:
                prev = currentNode.left
                while prev.right:
                    prev = prev.right
                prev.right = currentNode.right
                currentNode.right = currentNode.left
                currentNode.left = None
            currentNode = currentNode.right
#Time - O(N)
#Space - O(1)

