# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    # tc : O(n) visiting each node once
    # sc : O(h) worst case like skwed tree h will be n O(n)
    def flatten(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: None Do not return anything, modify root in-place instead.
        """
        # Recrussion to find my next preorder node 
        # left_end so that i know the left[ointer and then attach my node.,righ tot it 
        # and then move the whole node.left(whuich is a new linked list which has the nigh node attachd n the end ) 
        # copies ot the rigt node.right = node.left
        # make my keft pointers to the null
        # and return the rigth end so in. the enxt recrussion i attach the rigth subtree to the end of this


        # base conditin
        if root is None:
            return None

        # if the in leaf nodes
        if root.left is None and root.right is None:
            return root

        left_end = self.flatten(root.left)
        right_end = self.flatten(root.right)


        # action
        if left_end:
            left_end.right = root.right
            root.right = root.left
            root.left = None

        # return he right pointer 
        if right_end :
            return right_end
        else:
            return left_end

