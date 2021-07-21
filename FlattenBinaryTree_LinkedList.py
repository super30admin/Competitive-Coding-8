# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """without using stack and recursion--no extra space used---Top Down approach
    Time complexity-O(n) as going through all elements of tree
    Space complexity-O(1)"""
    def __init(self):
        self.temp=None
    def flatten(self, root: TreeNode) -> None:
        if not root or (not root.left and not root.right):
            return
        while root:
            self.temp=root.right
            if root.left:
                root.right=root.left
                root.left=None
                if root.right:
                    updateroot=root.right
                    while updateroot.right!=None:
                        updateroot=updateroot.right
                updateroot.right=self.temp
            root=root.right
    # def flatten(self, root: TreeNode) -> None:
        """Using recursive stack
        Time complexity-O(n)
        Space complexity-O(h)"""
        # if not root:
        #     return
        # self.flatten(root.left)
        # temp=root.right
        # if root.left:
        #     root.right=root.left
        #     root.left=None
        #     temp1=root.right
        #     if temp1:
        #         while temp1.right:
        #             temp1=temp1.right
        #         temp1.right=temp
        # self.flatten(root.right)
        
        