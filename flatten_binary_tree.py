# Time Complexity :
# O(N)  - Size of the source string

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes


#We do a preorder traversal of the tree and store the path in a list. We then go through this list and connect each node to the next appearing node in the tree

class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root== None:
            return
        pre_order_path =self.preorder(root)
        for i,node in enumerate(pre_order_path[:-1]):
            node.left = None
            node.right = pre_order_path[i+1]
            
    def preorder(self,root):
        if root == None:
            return []
        left = self.preorder(root.left)
        right = self.preorder(root.right)
        return [root] + left+ right
