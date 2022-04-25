# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Time Complexity : O(n)
#Sapce Complexity :O(1)
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.prev = None
        head = root
        if(head == None):
            return
        self.helper(root)
        self.prev.next = None
        while(root.next != None):
            root.right = root.next
            root.left = None
            root = root.next
        return root
        
        
    def helper(self, root):
        if root == None:
            return
        
        if self.prev != None:
            self.prev.next = root
        self.prev = root
        
        self.helper(root.left)
        self.helper(root.right)
