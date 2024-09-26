#Time Complexity:O(n)
#Space Complexity:O(n)
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
        if not root:
            return root
        self.helper(root)                       #Use a recursive helper function
        
    def helper(self,root:TreeNode)->None:
        if not root.left and not root.right:
            return root
        if root.left:                           #if the left child of a node exists
            temp=root.right                     #assign its right child to temp
            root.right=root.left                #move its left child to be right child
            root.left=None                      #let its left node point to null
            root=root.right                     #make the new right node as root and call helper function on it.
            if root:
                self.helper(root)
            if temp:
                self.helper(temp)               #if temp exists the call helper on it too
            while root.right:                   #while root.right exists parse through till the end to add the temp node.
                root=root.right
            root.right=temp
        elif root.right:                        #call halper function on right node if it exists
            self.helper(root.right)