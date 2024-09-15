# Brute Force Solution: Time Complexity: O(n), Space Complexity: O(n)
class Solution:
    
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        result = []
        self.preOrder(root, result)
        
        dummy = TreeNode(None)
        node = dummy
        for item in result:
            dummy.right = item
            dummy.left = None
            dummy = dummy.right

        return node
        
    def preOrder(self, root, arr): 

        if root == None: return 
        arr.append(root) 
        self.preOrder(root.left, arr)
        self.preOrder(root.right, arr) 
        
# Optimized solution: Time Complexity: O(n), Space Complexity: O(1)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        if root == None: return
        if root.left == None and root.right == None: return
        
        if root.left:
            
            self.flatten(root.left)
            
            subtree = root.right
            root.right = root.left
            root.left = None
        
            curr = root.right
            while curr.right:
                curr = curr.right
            
            curr.right = subtree
            
        self.flatten(root.right)
