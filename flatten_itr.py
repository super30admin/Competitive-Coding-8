"""
Iterative solution
TC- 0(N)
SC-0(N) O(height of the tree)

1. Push the right node into the stack
2.change the left node to right node and make the left none 
3.if left none , then pop the element from stack and apptend to ptr to right and move ptr to ptr to right 
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root is None:
            return None
        ptr=root
        st=[]
        while ptr or st:
            if(ptr.right is not None):
                st.append(ptr.right)
            if(ptr.left is not None):
                ptr.right = ptr.left
                ptr.left = None
            elif st:
                temp = st.pop()
                ptr.right=temp
            ptr = ptr.right