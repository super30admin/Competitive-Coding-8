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
        #Approach: Iterative
        #Time Complexity: O(n)
        #Space Complexity: O(h)
        #where, n and h are the size and height of the tree, respectively
        
        prev = None
        
        st = []
        while st or root:
            while root:
                left, right = root.left, root.right
                root.left, root.right = None, None
                
                if prev:
                    prev.right = root
                prev = root
                
                st.append((root, right))
                root = left
            
            root, right = st.pop()
            root = right
    
    '''
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        #Approach: Recursive
        #Time Complexity: O(n)
        #Space Complexity: O(h)
        #where, n and h are the size and height of the tree, respectively

        self.prev = None
        self.preorder(root)
        return
    
    def preorder(self, root):
        #base
        if not root:
            return
        
        #logic
        left, right = root.left, root.right
        root.left, root.right = None, None
        
        if self.prev:
            self.prev.right = root
        self.prev = root
        
        self.preorder(left)
        self.preorder(right)
    '''