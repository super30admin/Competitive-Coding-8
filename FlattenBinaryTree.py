class Solution:
    def preorder(self, root):
        if not root: return

        temp = root
        while temp:
            if temp.left: 
                rightMost = temp.left
                while rightMost.right: 
                    rightMost = rightMost.right
                rightMost.right = temp.right 
                temp.right = temp.left
                temp.left = None
            temp = temp.right


        else:
            return
        return root

    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        temp=self.preorder(root)
        return temp