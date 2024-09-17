# Time Complexity: O(n)
# Space Complexity: O(n)
# Approach: Bottom up Recursion. At any arbitrary node, given that the left and right subtrees are flattened, use the tail node of the left subtree to connext to the right subtree and return the tail of the newly created linked list to the node. 
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
        # Edge
        if not root:
            return None
        
        def helper(node):
            if not node:
                return None
            
            left_tail, right_tail = None, None
            # Leaf
            if node.left is None and node.right is None:
                return node
            
            if node.left:
                left_tail = helper(node.left)
            if node.right:
                right_tail = helper(node.right)
                
            if left_tail:
                left_tail.right = node.right
                node.right = node.left
            node.left = None
                
            # Return
            if right_tail:
                return right_tail
            else:
                return left_tail
                
        helper(root)