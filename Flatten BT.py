#Definition for a binary tree node.
#TC: O(n)
#SC: O(n)
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution(object):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        if root==None: return None
        head=root
        result=[]
        def preorder(root):
            if root==None: return 
            result.append(root.val)
            preorder(root.left)
            preorder(root.right)
        preorder(root)
        for i in range(1,len(result)):
            new=TreeNode(result[i])
            root.right=new
            root=root.right
        head.left=None
        return head
    
        