# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    """
    Time Complexity: O(N), N is total number of nodes
    Space Complexity: O(h), h is the height of the tree
    """
    def flatten(self, root: Optional[TreeNode]) -> None:
        def dfs(root):
            if root == None:
                return None
            
            # Flatten the left subtree
            left_tail = dfs(root.left)
            # Flatten the right subtree
            right_tail = dfs(root.right)
            
            # If there's a left subtree, attach it to the right and adjust pointers
            if root.left:
                left_tail.right = root.right
                root.right = root.left
                root.left = None
            
            # Return the last node in the flattened tree
            last = right_tail or left_tail or root
            return last
        
        dfs(root)
