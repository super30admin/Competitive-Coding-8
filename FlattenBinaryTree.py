---------------------------------------Flatten Binary Tree to Linkedlist------------------------------------------
# Time Complexity : O(N) as N is the length of elements we can take 
# Space Complexity : O(N) stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I iterated through the entire tree until the last node in the left, and find the l and r nodes. Once we got the l and r
# we need to make the lastmost left node right node is root.right and make the root.right node as l.
# and make the left nodes as None for all the nodes. So we will return the right node of the root in every iteration.


class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        if not root:
            return 
        
        def dfs(root):
            if not root:
                return
            
            if not root.left and not root.right:
                return root
            
            l = dfs(root.left)
            r = dfs(root.right)
            
    
            if l:
                l.right= root.right
                l.left = None
                root.right = root.left
                root.left = None
            
            return r if r else l
        
        return dfs(root)