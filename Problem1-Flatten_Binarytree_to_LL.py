#TC - O(n) where n is the number of nodes in the tree
#SC - O(1)


class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        def dfs(root):
            if not root:
                return None

            leftsub=dfs(root.left)
            rightsub=dfs(root.right)

            if root.left:
                leftsub.right=root.right
                root.right=root.left
                root.left=None

            result=rightsub or leftsub or root
            return result
        dfs(root)

        """
        Do not return anything, modify root in-place instead.
        """
        