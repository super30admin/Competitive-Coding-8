# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#All solutions:
#Time Complexity: O(N) — Each node is visited exactly once.
#Space Complexity: O(H) — Due to recursion stack, where H is the height of the tree. In worst case (skewed tree), H = N; in best case (balanced), H = log N.

# pre order traversal
class Solution:
    def __init__(self):
        self.prev = None  # keep track of previous node in preorder
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.helper(root)        
    def helper(self, node: Optional[TreeNode]) -> None:
        if not node:
            return        
        left = node.left     # store left subtree
        right = node.right   # store right subtree        
        # If there's a previous node, link it to current
        if self.prev:
            self.prev.right = node
            self.prev.left = None        
        self.prev = node  # update prev to current        
        # Recurse in preorder: root -> left -> right
        self.helper(left)
        self.helper(right)


# #postorder traversal
# class Solution:
#     def flatten(self, root):
#         self._flatten(root)        
#     def _flatten(self, node):
#         if not node:
#             return None        
#         # Flatten left and right subtrees
#         left_tail = self._flatten(node.left)
#         right_tail = self._flatten(node.right)        
#         # If there's a left subtree, weave it into the right side
#         if node.left:
#             # Connect left subtree's tail to right subtree
#             left_tail.right = node.right
#             # Move left subtree to right
#             node.right = node.left
#             node.left = None        
#         # Return the rightmost node after flattening
#         if right_tail:
#             return right_tail
#         if left_tail:
#             return left_tail
#         return node
        
# # reverse post-order traversal
# class Solution:
#     def __init__(self):
#         self.prev = None
#     def flatten(self, root):
#         self.flattenTree(root)
#     def flattenTree(self, node):
#         if not node:
#             return    
#         self.flattenTree(node.right)  # recurse right first
#         self.flattenTree(node.left)   # then left    
#         node.right = self.prev  # connect current node to previously processed node
#         node.left = None   # clear left pointer    
#         self.prev = node  # update prev to current node