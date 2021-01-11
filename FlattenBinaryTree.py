# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
Approach: DFS

Here the problem can be divided into subproblems like this. 
- Faltten the left tree
1) Store the right part into a variable
2) Put left subtree in place of right subtree 
3) Now traverse towards the very end of our new right subtree 
4) Assign the old right subtree stored in vairable at step 2
5) Now follow step 1 to 4 on this newly added right subtree in step 4

        
      
1) temp = 4
         / \
        N   N
            
2) 
        2 <-root
       / \
      N   3  
      
3) 
        2 
       / \
      N   3 <-root
      
4)  
         2 
        / \
       N   3 <-root
            \
            4
           / \
          N   N
 
TC: O(n)
SC: O(h)

n = no of nodes
h = height of the tree
"""
class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root == None or (root.left == None and root.right == None):
            return
        
        
        #logic
        if root.left != None:
            self.flatten(root.left)
            temp = root.right
            root.right = root.left
            root.left = None

            while root.right != None:
                root = root.right

            root.right = temp
            
        self.flatten(root.right)
        
        