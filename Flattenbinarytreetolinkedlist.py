#Time Complexity: O(n), where n is the number of nodes in the tree, as each node is visited once.
#Space Complexity: O(h), where h is the height of the tree, due to the recursive call stack.
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.flattentree(root)
    def flattentree(self, node):
        if(node==None):
            return None
        if(node.left == None and node.right == None):
            return node
        lefttail = self.flattentree(node.left)
        righttail = self.flattentree(node.right)
        if(lefttail!=None):
            lefttail.right = node.right
            node.right = node.left
            node.left = None
        if(righttail!=None):
            return righttail
        else:
            return lefttail