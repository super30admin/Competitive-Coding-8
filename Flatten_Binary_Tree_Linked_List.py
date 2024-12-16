# Approach:
# - We'll use an iterative pre-order traversal with a stack.
# - Traverse the tree from the root, and for each node:
#   1. Set its left child to None (since we're flattening the tree into a linked list).
#   2. Link the right child to the next node in the traversal (using the stack to handle that).
#   3. Move on to the right child in the traversal, ensuring that it points to the next node.
# This is done iteratively with a stack to avoid recursion overhead.

# Time Complexity: O(n) where n is the number of nodes in the tree. We visit each node once.
# Space Complexity: O(h) where h is the height of the tree (due to the stack). In the worst case (skewed tree), this is O(n).
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No, it's straightforward with an iterative approach.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        if not root:
            return None
        
        # Stack for iterative pre-order traversal
        stack = [root]
        
        while stack:
            node = stack.pop()
            
            # If there's a right child, push it onto the stack
            if node.right:
                stack.append(node.right)
            
            # If there's a left child, push it onto the stack
            if node.left:
                stack.append(node.left)
            
            # Now, we set the current node's left child to None
            # and its right child to the next node in the stack
            if stack:
                node.right = stack[-1]
            node.left = None
