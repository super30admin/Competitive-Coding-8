#Time - O(N)
#Space- O(H)
#dfs, recursion

def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root == None:
            return None
        self.helper(root)
    def helper(self, root):
        if not root:
            return
        l = self.helper(root.left)
        r = self.helper(root.right)
        if l:
            root.right = l
            while l and l.right:
                l = l.right
            l.right = r
            root.left = None
        return root
