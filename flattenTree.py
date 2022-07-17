# Approach : DFS 
# TC : O(N) as we traverse all nodes, it may be slight more than O(N) as we also have a while loop to go down right of the left subtree but still linear
# SC: O(logN) - recursion stack usage as height of the tree same 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        def dfs(curr, prev):
            # base
            if not curr:
                return
            
            # logic
            # go down the right most subtree
            dfs(curr.right, curr)            
            
            # base
            # when we reach a leaf node
            if curr.right is None and curr.left is None:
                # check if prev is valid and it has right subtree None, left is curr
                if prev and prev.right is None and prev.left == curr:
                    # then update prev to have curr as right subtree and make left subtree None
                    prev.right = curr
                    prev.left = None
                elif prev and prev.right and prev.right != curr:
                    # prev is valid and prev right is also valid and it doesn't have curr subtree
                    # as right subtree, so update curr.right to have prev.right
                    # prev.right can then become current and left can be set to None
                    curr.right = prev.right
                    prev.right = curr
                    prev.left = None
                return   # as we have no left node to process, it is already None
            
            
            dfs(curr.left, curr) # else go down the left subtree and process all leaves in the same manner
            # when we return to root of any subtree, we want to ensure we don't have any left children
            
            if curr.left:
                # so if we do then set pointer to left node
                p = curr.left
                # then traverse down to right most leaf not
                while p and p.right:
                    p = p.right
                # at the end, make p.right as curr.right
                p.right = curr.right
                #then make curr.right as curr.left
                curr.right = curr.left
                # curr.left becomes None
                curr.left = None
            return 
        
        dfs(root, None)
        return root