# Time complexity - O(N) : n-no.of nodes
# Space Complexity: O(h) : h : height of the tree
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach : preorder traversal, flatten the left subtree and then right subtree.

class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        
        """

        if root == None or (root.left == None and root.right== None):
            return
        
        self.flatten(root.left)
        temp= root.right
        root.right = root.left
        root.left = None
        
        while root.right!= None:
            root = root.right
        
        root.right = temp
        self.flatten(root.right)
        