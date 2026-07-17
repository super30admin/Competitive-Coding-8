"""
1. We use dfs to traverse the tree and store the nodes in a stack moving to the left child until we reach the leftmost node.
2. When we call next(), we pop the top node from the stack and return its value, but before returning, we call dfs on the right child of the popped node to continue the in-order traversal.

TC: O(1) 
SC: O(h) -> stack space where h is the height of the tree.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.dfs(root)

    def next(self) -> int:
        root = self.stack.pop()
        self.dfs(root.right)
        return root.val


    def hasNext(self) -> bool:
        return len(self.stack)!=0
        
    def dfs(self,root):
        while root:
            self.stack.append(root)
            root = root.left

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()