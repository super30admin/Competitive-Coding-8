'''
Did it run on leet code: yes
Did you face any problem: Small mistake, and was asked in my mock interview.
Was struck in a part where I did no do node.left=None in my mock interview and my tree balsted, giving
repeated elements.

Time Complexity: 0(N2)
Space Complexity: 0(N)

Algorithm:
- Make a post order traversal of the tree
- store the left,store the right, make left=None and attach it to right.
- After that traverse through the end in right, and attach the stored right to the pointer reached


'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        self.inorderTraversal(root)
        
    def inorderTraversal(self,node):
        
        if node:
            self.inorderTraversal(node.left)
            self.inorderTraversal(node.right)
            left = node.left
            right = node.right
            if left:
                node.right = left 
                node.left=None
                temp = left
                while temp.right:
                    temp=temp.right
                temp.right = right
            
            
        