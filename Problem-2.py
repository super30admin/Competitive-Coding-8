from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # Approach 1: bottom up recursion
    """
    1. Find left tail and right tail
    2. cut right tail and attach to lef tail's right
    3. do this on left sub tree first, the on he right sub tree
    TC: O(n) num of nodes
    SC: O(h) height of the tree
    """
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.helper(root)
        return
    
    def helper(self, node):
        #base
        if not node:
            return 
        if not node.left and not node.right:
            return node
        
        #logic
        left_tail = self.helper(node.left)
        right_tail = self.helper(node.right)
        
        if left_tail:
            left_tail.right = node.right
            node.right = node.left
            node.left = None
        return right_tail if right_tail else left_tail
    
    # Approach 2: top down recursion
    """
    1. follow a reverse post order traversal i.e. right, left, root
    2. have prev node such that
        a) after exploring both children, point the rightpointer of the left node to the prev node
    3. update prev node to curr
    
    TC: O(n)
    SC: O(n)
    """
    def __init__(self):
        self.prev = None
    def flatten(self, root: Optional[TreeNode]) -> None:
        self.helper(root)
        return
    
    def helper(self, node):
        #base
        if not node:
            return
        #logic
        self.helper(node.right)
        self.helper(node.left)
        node.right = self.prev
        node.left = None
        self.prev = node
    
    # Approach 3: iterative using stack - bottom up
    """
    Same flow as above
    TC: O(n)
    SC: O(h)
    """
    def flatten(self, root: Optional[TreeNode]) -> None:
        if not root:
            return
        stack = deque()
        stack.append(root)
        while stack:
            curr = stack.pop()
            if curr.right:
                stack.append(curr.right)
            if curr.left:
                stack.append(curr.left)
            if stack:
                curr.right = stack[-1] # top
            curr.left = None
        return
    
    # Approach 4: Morris traversal
    """
    each left node needs to points to its inorder traversal. We can do this iteratively
    TC: O(n)
    SC: O(1)
    """
    def flatten(self, root: Optional[TreeNode]) -> None:
        if not root:
            return
        node = root
        while node:
            if node.left:
                prev = node.left
                while prev.right:
                    prev = prev.right
                prev.right = node.right
                node.right = node.left
                node.left = None
            node = node.right