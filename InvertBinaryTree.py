# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
Approach: DFS(postorder or preorder)

We will do a DFS here but either or posttorder or preorder. Reason being that we need to first traverse both the children first then move on to their parents. So in case of the following example

     4
   /   \
  2     7
 / \   / \
1   3 6   9

we first go to 1 check for its left and right child, do the same thing with 3 and go back to 2. As 1 and 3 has no child it will return back to 2. Now 2 has two child, so we will swap them with each other and move on to its right sibling 7 and repeat the same procedure there.

So as we can see a preorder or a postorder traversal is the only option in DFS that could work here because traversing the child first will always be our priority.

TC: O(n)
SC: O(h)

n = no of nodes in a tree
h = height of the tree
"""
class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if root == None:
            return None
        
        self.dfs(root)
        return root
        
    def dfs(self, root):
        if root == None:
            return
        
        self.dfs(root.left)
        self.dfs(root.right)
        root.left, root.right = root.right, root.left
        