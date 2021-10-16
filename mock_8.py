# // Time Complexity :O(n)
# // Space Complexity :O(h),recursive stack
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.temp=None
        
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.dfs(root)
        # root.right=self.dfs(root.left)
        # root.left=None
        

    def dfs(self,root):
        #base
        if root is None:
            # self.temp=root
            return 
            
        #logic

        self.dfs(root.left)
        print("a",root.val)
        
        self.dfs(root.right)
        print("x")
        
        if root.left:
            print(root.right)
            self.temp=root.right
            root.right=root.left
            root.left=None
            while(root.right):
                root=root.right
            root.right=self.temp
        


            
            
            # print(root.right.val)
            # print(root.right.right.val)
            

        
        
        

        
        
        
        