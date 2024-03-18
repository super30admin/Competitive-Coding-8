'''
Time Complexity - O(n). We are traversing all the nodes in the tree
Space Complexity - O(n). We are using a recursive stack whose size is that of height of the tree

Works on Leetcode
'''



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.ll = []
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # if root==None:
        #     return
        # self.preorder(root)
        # curr = root
        # for i in range(1,len(self.ll)):
        #     curr.left = None
        #     curr.right = TreeNode(self.ll[i])
        #     curr = curr.right
        #base
        if root == None or (root.left == None and root.right == None):# return if the node is None or it is a leaf Node
            return

        #logic
        # we are taversing inorder
        if root.left!= None:
            self.flatten(root.left)
            temp = root.right # make a temp to point to right of root
            root.right = root.left #make right of root to point to left
            root.left = None # left of root points to None
            while root.right != None: #we traverse right to the last Node
                root = root.right 
            root.right = temp #and make its right point to the temp
        self.flatten(root.right) #we then flattern the right part of the root
        
        


    def preorder(self, root):
        if root == None:
            return
        self.ll.append(root.val)
        self.preorder(root.left)
        self.preorder(root.right)
        