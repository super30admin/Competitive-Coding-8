"""
Runtime Complexity:
O(n) - because we traverse through all the nodes.
Space Complexity:
O(n) - recrusive stack space. 
Yes, the worked on leetcode.
Issues while coding - No
"""

class Solution:
    def flattenTree(self, node):
        
        if (node==None):
            return 
        if (node.left==None) and (node.right==None):
            return node
        
        left = self.flattenTree(node.left)
        right =self.flattenTree(node.right)
        
        if left:
            left.right = node.right
            node.right = node.left
            node.left = None
        return right if right else left
    
    def flatten(self,root:TreeNode)-> None:
        self.flattenTree(root)