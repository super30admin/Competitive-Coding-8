#------ Solution 1 : Using DFS recursive solution--------
''' Time Complexity : O(n) 
    Space Complexity : O(h) : Recursive stack of height of tree
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.leaf = None
        def dfs (root):
            if root is None:
                return 
            dfs(root.right)
            dfs(root.left)

            root.right = self.leaf
            root.left = None
            self.leaf = root
        
        dfs(root)

#------ Solution 2 : Iterative Solutionn--------
''' Time Complexity : O(n) 
    Space Complexity : O(1) : 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        curr = root
        while curr:
            if curr.left:
                prev = curr.left
                while prev.right:
                    prev = prev.right
                prev.right = curr.right
                curr.right = curr.left
                curr.left = None
            curr = curr.right