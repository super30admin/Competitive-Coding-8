# TC: O(n)
# SC: O(n)
# DFS: flatten subtrees at lower levels- rewire to make right skewed subtree, then proceed to parent branch- repeat until whole tree is a right skewed tree.
class Solution:
    def flatten(self, root: TreeNode) -> None:
        if not root: return root
        return self.helper(root)
    
    def helper(self, root):
        # base
        if not root: return None
        if root.left == None and root.right == None:
            return root
        
        # logics
        leftLeaf = self.helper(root.left)
        rightLeaf = self.helper(root.right)
        
        if leftLeaf:
            leftLeaf.right = root.right
            root.right = root.left
            root.left = None
        
        return rightLeaf if rightLeaf else leftLeaf