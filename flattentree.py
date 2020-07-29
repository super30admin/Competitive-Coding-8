# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# time complexity - O(n) -- worst case O(n^2)
# space complexity - O(h) -- worst case O(n)
# using postorder traversal
# STEPS: 
# traverse to the end of the tree
# serialize the left child, serialize the right child and combine the serialized nodes to the right of the root. 
# assign left child of the node to None.

# did it run on leetcode? : yes
# did you encounter any issues while running the code? : no
class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # using recursion
        def serialize_tree(root):
            if not root:
                return 
            
            # 4 cases 
            # if both nodes are not none
            if left and right:
                while left.right:
                    left = left.right
                left.right = root.right
                root.right = root.left
                root.left = None
            elif left:
                root.right = root.left
                root.left = None
                

            return root
        
        return serialize_tree(root)
    
    
    
# time complexity - O(n)
# space complexity - O(h) -- worst case O(n)
# using postorder traversal
# STEPS: 
# traverse to the end of the tree
# serialize the left child, serialize the right child and combine the serialized nodes to the right of the root. 
# in this solution, instead of returning the left child root, we return the tail. reduces the worst case time from O(n^2) to O(n).
# assign left child of the node to None. 
# did it run on leetcode? : yes
# did you encounter any issues while running the code? : no
class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # using recursion
        def serialize_tree(root):
            if not root:
                return 
            
            if not root.left and not root.right:
                return root
            
            left = serialize_tree(root.left)
            right = serialize_tree(root.right)
            
            if left:
                left.right = root.right
                root.right = root.left
                root.left = None
                
            return right if right else left
        
        return serialize_tree(root)
    
    
    
# using iterative procedure
# time complexity - O(n)
# space complexity - O(h) -- worst case O(n)
from collections import deque
class Solution:
    def flatten(self, root: TreeNode) -> None:
        if not root: return root
        nodes_stack = deque()
        nodes_stack.append(root) # add root node to the stack
        prev = None
        
        while nodes_stack:
            node = nodes_stack.pop() # pop node from the stack
            
            # add the node's children to the stack.
            if node.right:
                nodes_stack.append(node.right)
            if node.left:
                nodes_stack.append(node.left)
            
            # append the node to the right of the previous node
            if prev:  
                prev.right = node
                prev.left = None
            
            # assign the current node to the previous.
            prev = node
            
        return root

    
    
# using iterative procedure
# worst case time complexity - O(n^2)
# space - O(1)
# without using explicit stack
class Solution:
    def flatten(self, root: TreeNode) -> None:
        node = root
        
        while node:
            if node.left:
                # attach node's right child to the end of the left child.
                temp = node.left
                while temp.right:
                    temp = temp.right
                temp.right = node.right
                # assign the leftchild of the node to the left
                node.right = node.left 
                # assign the left child as none
                node.left = None

            node = node.right # traverse to the right child
        
        return root
        